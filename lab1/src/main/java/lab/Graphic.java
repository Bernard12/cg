package lab;

import javafx.scene.control.Slider;
import lab.CustomCanvas.MyCanvas;
import lab.Misc.TMatrix;
import lab.Misc.Vector;

import java.util.ArrayList;
import java.util.List;

public class Graphic {

    private final Slider[] params;
    private TMatrix matrix;

    Graphic(Slider[] params, TMatrix matrix) {
        this.params = params;
        this.matrix = matrix;
    }

    public Slider[] getParams() {
        return params;
    }

    public List<Vector> points(){
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
            list.add(new Vector(x * 40, y * 40));
        }
        return list;
    }

    public void draw(MyCanvas canvas) {
        List<Vector> points = this.points();
        if(points.isEmpty()){
            return;
        }

        Drawer drawer = new Drawer(canvas);
        drawer.draw(points,matrix);

    }
}
