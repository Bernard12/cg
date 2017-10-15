package lab3;

import javafx.scene.paint.Color;
import lab3.CustomCanvas.MyCanvas;
import lab3.Misc.Light;
import lab3.Misc.Vector;

import java.util.ArrayList;

public class Figure {
    private ArrayList<ArrayList<Vector>> levels;
    private double h, k, r, sides;

    private int approx;

    /**
     * @param r base radius
     */
    Figure(double r, double sides) {
        this.levels = new ArrayList<>();
        this.r = r;
        this.sides = sides;
        this.h = 100;
        this.k = 1;
        this.approx = 10;
    }
    private void generatePoints() {
        double part = 0;
        for (; part < h; ) {
            /*double t = h * i / approx;*/
            double radius = func(part) + getR();
            double cur = 0;
            ArrayList<Vector> lev = new ArrayList<>();
            for (int j = 0; j < sides; j++) {
                double x = radius * Math.cos(cur * Math.PI / 180);
                double y = radius * Math.sin(cur * Math.PI / 180);
                lev.add(new Vector(x, y, part, 1));
                cur += 360 / sides;
            }
            this.levels.add(lev);
            part += h / approx;
        }
    }

    public void draw(MyCanvas canvas) {
        Drawer drawer = new Drawer();
        this.levels.clear();
        generatePoints();
        int n = this.levels.size();
        int sides = this.levels.get(0).size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < sides; j++) {
                drawer.drawTriangle(canvas,
                        this.levels.get(i).get(j % sides),
                        this.levels.get(i).get((j + 1) % sides),
                        this.levels.get(i + 1).get(j % n));
                drawer.drawTriangle(canvas,
                        this.levels.get(i + 1).get(j % sides),
                        this.levels.get(i + 1).get((j + 1) % sides),
                        this.levels.get(i).get((j+1) % sides));
            }
        }
        Vector center1 = new Vector(0, 0, 0, 1);
        Vector center2 = new Vector(0, 0, h, 1);
        for (int i = 0; i < sides; i++) {
            drawer.drawTriangle(canvas,
                    center1,
                    this.levels.get(0).get(i % sides),
                    this.levels.get(0).get((i + 1) % sides));
            drawer.drawTriangle(canvas,
                    center2,
                    this.levels.get(n-1).get(i % sides),
                    this.levels.get(n-1).get((i + 1) % sides));
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
    public ArrayList<ArrayList<Vector>> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<ArrayList<Vector>> levels) {
        this.levels = levels;
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

    public void setR(double r) {
        this.r = r;
    }

    public void setSides(double sides) {
        this.sides = sides;
    }

    public int getApprox() {
        return approx;
    }

    public void setApprox(int approx) {
        this.approx = approx;
    }
}
