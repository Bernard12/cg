package lab4;


import lab4.Misc.Model;
import lab4.Misc.Shader;
import lombok.Getter;
import lombok.Setter;
import org.joml.Matrix4f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.glColor3f;

public class Figure {

    private double h, k, r;

    private int approx, sides;

    private List<Model> triangles;


    public Figure(double r, int sides) {
        this.sides = sides;
        this.r = r;
        this.h = 50;
        this.k = 1;
        this.approx = 100;
        triangles = new ArrayList<>();
        generateTriangles();
    }

    private double func(double x) {
        return (-1 * (x * x / h) + x) * k + 5;
    }

    private void generateTriangles() {
        float part = 0;
        ArrayList<ArrayList<Vector4f>> list = new ArrayList<>();
        for (int i = 0; i <= approx; i++) {
            /*double t = h * i / approx;*/
            double radius = func(part) + getR();
            double cur = 0;
            ArrayList<Vector4f> lev = new ArrayList<>();
            for (int j = 0; j < sides; j++) {
                float x = (float) (radius * Math.cos(cur * Math.PI / 180));
                float y = (float) (radius * Math.sin(cur * Math.PI / 180));
                lev.add(new Vector4f(x / 50, y / 50, part / 50, 1));
                cur += 360. / sides;
            }
            part += h / approx;
            list.add(lev);
        }
        float last = list.get(list.size() - 1).get(0).z;
        Vector4f center1 = new Vector4f(0, 0, 0, 1);
        Vector4f center2 = new Vector4f(0, 0, last, 1);
        for (int i = 0; i < sides; i++) {
            Vector4f v1 = list.get(0).get(i % sides);
            Vector4f v2 = list.get(0).get((i + 1) % sides);
            triangles.add(new Model(new float[]{
                    center1.x, center1.y, center1.z,
                    v1.x, v1.y, v1.z,
                    v2.x, v2.y, v2.z,
            }));

            v1 = list.get(list.size() - 1).get(i % sides);
            v2 = list.get(list.size() - 1).get((i + 1) % sides);
            triangles.add(new Model(new float[]{
                    center2.x, center2.y, center2.z,
                    v1.x, v1.y, v1.z,
                    v2.x, v2.y, v2.z,
            }));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                Vector4f v1 = list.get(i).get(j % sides);
                Vector4f v2 = list.get(i).get((j + 1) % sides);
                Vector4f v3 = list.get(i + 1).get(j % sides);
                triangles.add(new Model(new float[]{
                        v1.x, v1.y, v1.z,
                        v2.x, v2.y, v2.z,
                        v3.x, v3.y, v3.z,
                }));
                v1 = list.get(i + 1).get(j % sides);
                v2 = list.get(i + 1).get((j + 1) % sides);
                v3 = list.get(i).get((j+1) % sides);
                triangles.add(new Model(new float[]{
                        v1.x, v1.y, v1.z,
                        v2.x, v2.y, v2.z,
                        v3.x, v3.y, v3.z,
                }));
            }
        }
    }

    void draw(Matrix4f m, Shader shader, int ang){
        for(Model model: triangles){
            glColor3f(0,0,0);
            model.render(m, shader,ang);
        }
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public int getApprox() {
        return approx;
    }

    public void setApprox(int approx) {
        this.approx = approx;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public List<Model> getTriangles() {
        return triangles;
    }

    public void setTriangles(List<Model> triangles) {
        this.triangles = triangles;
    }
}
