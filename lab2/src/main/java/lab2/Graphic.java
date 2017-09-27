package lab2;

import javafx.scene.control.Slider;
import lab2.CustomCanvas.MyCanvas;
import lab2.Misc.TMatrix;
import lab2.Misc.Vector;

import java.util.ArrayList;
import java.util.List;

public class Graphic {

    private final Slider[] params;

    Graphic(Slider[] params) {
        this.params = params;
    }

    public Slider[] getParams() {
        return params;
    }

    private List<Vector> points() {
        double A, B, a, b, t;
        A = params[0].getValue();
        B = params[1].getValue();
        a = params[2].getValue();
        b = params[3].getValue();
        t = params[4].getValue();
        if (!(A <= B && a > 0 && b > 0)) {
            return new ArrayList<>();
        }
        List<Vector> list = new ArrayList<>();
        for (double i = A; i <= B; i += t) {
            double x = a * i - b * Math.sin(i);
            double y = a - b * Math.cos(i);
            list.add(new Vector(x * 40, y * 40, 1));
        }
        return list;
    }

    void draw(MyCanvas canvas, TMatrix state) {
        List<Vector> points = this.points();
        if (points.isEmpty()) {
            return;
        }

        Drawer drawer = new Drawer();
        drawer.draw(canvas, points, state);

    }

}
