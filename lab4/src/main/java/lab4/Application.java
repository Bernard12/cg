package lab4;

import lab4.Misc.Model;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.stackPush;

public class Application {

    private long win;
    private boolean rot = false;
    private Matrix4f m;
    private double aspect;
    private int initWidth, initHeight;

    private Application(int w, int h) {
        m = new Matrix4f().identity();
        aspect = 1;
        initWidth = w;
        initHeight = h;
    }

    private void start() {
        init();
        loop();

        glfwFreeCallbacks(win);
        glfwDestroyWindow(win);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Unable to init GLFW");
        }

        glfwDefaultWindowHints();
        // window hint = window property?
        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        win = glfwCreateWindow(600, 600, "Лабораторная работа №4", 0, 0);
        glfwSetWindowSizeLimits(win, 400, 400, 900, 900);
        glfwSetKeyCallback(win, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            }
            if (key == GLFW_KEY_UP && action == GLFW_PRESS) {
                System.out.println("UP");
                m.rotateX((float) Math.toRadians(-30));
            }
            if (key == GLFW_KEY_DOWN && action == GLFW_PRESS) {
                System.out.println("DOWN");
                m.rotateX((float) Math.toRadians(30));
            }
            if (key == GLFW_KEY_LEFT && action == GLFW_PRESS) {
                System.out.println("LEFT");
                m.rotateY((float) Math.toRadians(30));
            }
            if (key == GLFW_KEY_RIGHT && action == GLFW_PRESS) {
                System.out.println("RIGHT");
                m.rotateY((float) Math.toRadians(-30));
            }
        });

        glfwSetFramebufferSizeCallback(win, (win, w, h) -> {
            //aspect = Math.max(w/600.,h/600.);
            //m.scale((float) aspect);
            //int mn = Math.max(w,h);
            glViewport(0, 0, w, h);
            glOrtho(0,w,h,0,-1,1);
        });

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(win, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    win,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        }

        glfwMakeContextCurrent(win);
        // Enable v-sync
        glfwSwapInterval(0);

        // Make the window visible
        glfwShowWindow(win);
    }

    private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();
        // Set the clear color
        glClearColor(245.0f / 255, 222.0f / 255, 179.0f / 255, 0.0f);

        glEnable(GL_DEPTH_TEST);
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.

        /*Vector4f center = new Vector4f(0, 0, 0, 1);
        Vector4f axisX = new Vector4f(1, 0, 0, 1);
        Vector4f axisY = new Vector4f(0, 1, 0, 1);
        Vector4f axisZ = new Vector4f(0, 0, 1, 1);*/
        float[] axisX = new float[]{
                0,0,0,
                1,0,0
        };
        Model modelX = new Model(axisX);

        float[] axisy = new float[]{
                0,0,0,
                0,1,0
        };
        Model modelY = new Model(axisy);

        float[] axisz = new float[]{
                0,0,0,
                0,0,1
        };
        Model modelZ = new Model(axisz);

        FloatBuffer fb = BufferUtils.createFloatBuffer(16);
        m.scale(0.5f);
        while (!glfwWindowShouldClose(win)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            // Load transform matrix
            glLoadMatrixf(m.get(fb));
            if (glfwGetMouseButton(win, GLFW_MOUSE_BUTTON_1) == GLFW_PRESS) {
                System.out.println("hohho");
            }
            glColor3f(1,0,0);
            modelX.render();
            glColor3f(0,1,0);
            modelY.render();
            glColor3f(0,0,1);
            modelZ.render();
            //modelX.render();

            glfwSwapBuffers(win); // swap the color buffers
            glfwPollEvents();
        }
    }

    public static void main(String[] args) throws Exception {
        new Application(600, 600).start();
    }
}