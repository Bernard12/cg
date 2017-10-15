package lab3;

import lab3.CustomCanvas.MyCanvas;
import lab3.Misc.Vector;

import java.util.ArrayList;

public class Figure {
    private ArrayList<ArrayList<Vector>> levels;
    private double h, k, r, sides;

    /**
     * @param r base radius
     */
    Figure(double r, double sides) {
        this.levels = new ArrayList<>();
        this.r = r;
        this.sides = sides;
        this.h = 100;
        this.k = 1;
    }

    private void generatePoints(int levels) {
        int phases = (int) h / levels;
        for (int i = 0; i < phases; i++) {
            double radius = func(h*i/levels) + getR();
            double cur = 0;
            ArrayList<Vector> lev = new ArrayList<>();
            for (int j = 0; j < sides; j++) {
                double x = radius * Math.cos(cur * Math.PI / 180);
                double y = radius * Math.sin(cur * Math.PI / 180);
                double z = (i * h) / levels;
                lev.add(new Vector(x, y, z, 1));
                cur += 360 / sides;
            }
            this.levels.add(lev);
        }

    }

    public void draw(MyCanvas canvas, int levels) {
        Drawer drawer = new Drawer();
        this.levels.clear();
        generatePoints(levels);
        int n = this.levels.size();
        int sides = this.levels.get(0).size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < sides; j++) {
                drawer.drawTriangle(canvas,
                        this.levels.get(i).get(j % sides),
                        this.levels.get(i).get((j + 1) % sides),
                        this.levels.get(i+1).get(j % n), -1);
                drawer.drawTriangle(canvas,
                        this.levels.get(i + 1).get(j % sides),
                        this.levels.get(i + 1).get((j + 1) % sides),
                        this.levels.get(i).get((j) % sides), 1);
            }
        }

    }

    private double func(double x) {
        return (-1 * (x * x / h) + x) * k;
    }

    public double getR() {
        return r;
    }
    public double getSides() {
        return sides;
    }

}
