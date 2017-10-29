package lab4;

import lab4.Misc.Model;
import lab4.Misc.Shader;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.stackPush;

public class Application {

    private long win;
    private Matrix4f m;
    private double curX, curY;

    private Application() {
        m = new Matrix4f().identity();
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
            glViewport(0, 0, w, h);
            glOrtho(0, w, h, 0, -1, 1);
        });

        glfwSetMouseButtonCallback(win,(win,button,action,mods) ->{
            if(button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS){
                System.out.println("hohoo");
                DoubleBuffer posX = BufferUtils.createDoubleBuffer(1);
                DoubleBuffer posY = BufferUtils.createDoubleBuffer(1);
                glfwGetCursorPos(win, posX, posY);
                double x = posX.get(0);
                double y = posY.get(0);
                curX = x;
                curY = y;
            }
        });

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); //    int*
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
        glfwSwapInterval(1);

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

        glEnable(GL_TEXTURE_2D);

        // Set the background color
        glClearColor(245.0f / 255, 222.0f / 255, 179.0f / 255, 0.0f);

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.

        float[] axisX = new float[]{
                0, 0, 0,
                1, 0, 0
        };
        Model modelX = new Model(axisX);

        float[] axisy = new float[]{
                0, 0, 0,
                0, 1, 0
        };
        Model modelY = new Model(axisy);

        float[] axisz = new float[]{
                0, 0, 0,
                0, 0, 1
        };
        Model modelZ = new Model(axisz);

        FloatBuffer fb = BufferUtils.createFloatBuffer(16);
        m.scale(0.5f);
        Shader shader = new Shader("simple");
        Figure figure = new Figure(5, 10);
        boolean bnd = false;
        while (!glfwWindowShouldClose(win)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            // Load transform matrix
            glLoadMatrixf(m.get(fb));

            if (glfwGetMouseButton(win, GLFW_MOUSE_BUTTON_1) == GLFW_PRESS) {
                DoubleBuffer posX = BufferUtils.createDoubleBuffer(1);
                DoubleBuffer posY = BufferUtils.createDoubleBuffer(1);
                glfwGetCursorPos(win, posX, posY);
                double x = posX.get(0);
                double y = posY.get(0);
                int dy = (int) (x - curX);
                int dx = (int) (y - curY);
                System.out.println(x + " " + y);
                m.rotateY((float) Math.toRadians(dy));
                m.rotateX((float) Math.toRadians(dx));
                curX = x;
                curY = y;

            }
            shader.setColor(1,0,0);
            modelX.render(null);
            shader.setColor(0,1,0);
            modelY.render(null);
            shader.setColor(0,0,1);
            modelZ.render(null);
            shader.setColor(0,0,0);
            shader.bind();
            shader.setUniform("project",m);
            figure.draw(m);

            glfwSwapBuffers(win); // swap the color buffers
            glfwPollEvents();
        }
    }

    public static void main(String[] args) throws Exception {
        new Application().start();
    }
}