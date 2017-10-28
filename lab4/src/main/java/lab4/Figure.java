package lab4;


import lab4.Misc.Model;
import lombok.Getter;
import lombok.Setter;
import org.joml.Matrix4f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.glColor3f;

public class Figure {

    @Setter @Getter
    private double h, k, r;
    @Setter @Getter
    private int approx, sides;
    @Setter @Getter
    private List<Model> triangles;


    public Figure(double r, int sides) {
        this.sides = sides;
        this.r = r;
        this.h = 50;
        this.k = 1;
        this.approx = 10;
        triangles = new ArrayList<>();
        generateTriangles();
    }

    private double func(double x) {
        return (-1 * (x * x / h) + x) * k + 5;
    }

    private void generateTriangles(){
        float part = 0;
        ArrayList<ArrayList<Vector4f>> list = new ArrayList<>();
        for (int i = 0; i < approx; i++) {
            /*double t = h * i / approx;*/
            double radius = func(part) + getR();
            double cur = 0;
            ArrayList<Vector4f> lev = new ArrayList<>();
            for (int j = 0; j < sides; j++) {
                float x = (float) (radius * Math.cos(cur * Math.PI / 180));
                float y = (float) (radius * Math.sin(cur * Math.PI / 180));
                lev.add(new Vector4f(x/50, y/50, part/50, 1));
                cur += 360 / sides;
            }
            part += h / approx;
            list.add(lev);
        }
        float last = list.get(list.size() - 1).get(0).z;
        Vector4f center1 = new Vector4f(0,0,0,1);
        Vector4f center2 = new Vector4f(0,0,last,1);
        for(int i = 0; i < sides; i++) {
            Vector4f v1 = list.get(0).get(i % sides);
            Vector4f v2 = list.get(0).get((i + 1) % sides);
            /*triangles.add(new Model(new float[]{
                    center1.x, center1.y, center1.z,
                    v1.x, v1.y, v1.z,
                    v2.x, v2.y, v2.z,
            }));*/

            v1 = list.get(list.size() - 1).get(i % sides);
            v2 = list.get(list.size() - 1).get((i + 1) % sides);
            triangles.add(new Model(new float[]{
                    center2.x, center2.y, center2.z,
                    v1.x, v1.y, v1.z,
                    v2.x, v2.y, v2.z,
            }));
        }
    }

    void draw(Matrix4f m){
        for(Model model: triangles){
            glColor3f(0,0,0);
            model.render(m);
        }
    }
}
