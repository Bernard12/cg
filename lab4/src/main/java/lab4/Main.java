package lab4;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {

    private long win;
    private float f1 = 0;

    private void start(){
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

        win = glfwCreateWindow(400, 400, "Лабораторная работа №4", 0, 0);
        glfwSetKeyCallback(win, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS)
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        });

        try(MemoryStack stack = stackPush()){
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
        glClearColor(245.0f/255, 222.0f/255, 179.0f/255, 0.0f);

        glEnable(GL_DEPTH_TEST);
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.

        while ( !glfwWindowShouldClose(win) ) {

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            glBegin(GL_LINE_LOOP);
                glVertex2f(0.f, 0.f);
                glVertex2f(0.5f, 0.0f);
                glVertex2f(0.0f, 0.5f);
            glEnd();

            glfwSwapBuffers(win); // swap the color buffers
            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        new Main().start();
    }
}