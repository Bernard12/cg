package lab4.Misc;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;


public class Model {
    private int drawCount;
    private int vertexId;

    public Model(float[] vertices){
        drawCount = vertices.length / 3;

        FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length);
        buffer.put(vertices);
        buffer.flip();

        vertexId = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vertexId);
        glBufferData(GL_ARRAY_BUFFER,buffer,GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER,0);
    }

    public void render(){
        glEnableClientState(GL_VERTEX_ARRAY);
        {

            glBindBuffer(GL_ARRAY_BUFFER, vertexId);
            {
                glVertexPointer(3, GL_FLOAT, 0, 0);
                glDrawArrays(GL_LINE_LOOP, 0, drawCount);

            }
            glBindBuffer(GL_ARRAY_BUFFER, 0);

        }
        glDisableClientState(GL_VERTEX_ARRAY);
    }
}
