package lab2;

import lab2.CustomCanvas.MyCanvas;
import lab2.Misc.Vector;

import java.util.ArrayList;

public class Figure {
    private ArrayList<Vector> firstLevel, secondLevel;
    private double r1, r2;

    Figure(double lowRad, double highRad) {
        r1 = lowRad;
        r2 = highRad;
        firstLevel = new ArrayList<>();
        secondLevel = new ArrayList<>();
        generatePoints();
    }

    private void generatePoints() {
        double cur = 0;
        for (int i = 0; i < 17; i++) {
            double x1 = r1 * Math.cos(cur * Math.PI / 180);
            double y1 = r1 * Math.sin(cur * Math.PI / 180);
            double z1 = 0;
            firstLevel.add(new Vector(x1, y1, z1, 1));
            double x2 = r2 * Math.cos(cur * Math.PI / 180);
            double y2 = r2 * Math.sin(cur * Math.PI / 180);
            double z2 = 0;
            secondLevel.add(new Vector(x2, y2, z2, 1));
            cur += 360 / 17;
        }
    }

    public void draw(MyCanvas canvas) {
        Drawer drawer = new Drawer();
        drawer.draw(canvas, firstLevel);
        drawer.draw(canvas, secondLevel);
    }
}
