package lab4.Misc;

import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;


public class Model {
    private int drawCount;
    private int vertexId;
    private float[] verts;

    public Model(float[] vertices) {
        verts = vertices;
        drawCount = vertices.length / 3;

        FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length);
        buffer.put(vertices);
        buffer.flip();

        vertexId = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vertexId);
        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }

    private Vector4f crossProduct(Vector4f a,Vector4f b){
        return new Vector4f(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x,
                1);
    }

    private double dot(Vector4f a, Vector4f b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    private double length(Vector4f a){
        return Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z);
    }

    public void render(Matrix4f m, Shader shader) {
        double d = -1;
        float intens = 1;
        if(m!=null) {
            Vector4f v1 = new Vector4f(verts[0], verts[1], verts[2], 1);
            Vector4f v2 = new Vector4f(verts[3], verts[4], verts[5], 1);
            Vector4f v3 = new Vector4f(verts[6], verts[7], verts[8], 1);
            Vector4f inner = new Vector4f(0, 0, 0.01f, 1);
            m.transform(v1);
            m.transform(v2);
            m.transform(v3);
            m.transform(inner);

            Vector4f sb1 = v2.sub(v1);
            Vector4f sb2 = v3.sub(v1);
            Vector4f n = crossProduct(sb1, sb2);
            Vector4f tmp = inner.sub(v1);
            if (dot(n, tmp) > 0) {
                n.negate();
            }
            Vector4f view = new Vector4f(0, 0, 50, 1);
            if (dot(n, view) > 0) {
                d = -1;
                intens = (float) (dot(n, view) / (length(n) * length(view)));
                intens *= intens;
            } else {
                d = 1;
            }
        }
        if(d<0) {
            glEnableClientState(GL_VERTEX_ARRAY);
            {

                glBindBuffer(GL_ARRAY_BUFFER, vertexId);
                {
                    glVertexPointer(3, GL_FLOAT, 0, 0);
                    if(m == null){
                        shader.setUniform("intens",1);
                        glDrawArrays(GL_LINE_LOOP, 0, drawCount);
                    }else {
                        shader.setUniform("intens",intens);
                        glDrawArrays(GL_TRIANGLES, 0, drawCount);
                    }
                }
                glBindBuffer(GL_ARRAY_BUFFER, 0);

            }
            glDisableClientState(GL_VERTEX_ARRAY);
        }
    }
}
