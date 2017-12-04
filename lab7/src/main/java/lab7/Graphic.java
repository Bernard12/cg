package lab7;

import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import lab7.CustomCanvas.MyCanvas;
import lab7.Misc.MyCircle;
import lab7.Misc.TMatrix;
import lab7.Misc.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
   @author Ivan Simakhin
 Functional class for drawing my curve with presetted params
 */
public class Graphic {

    private final Slider[] params;
    private ArrayList<Function<Double,Double>> functions;
    private ArrayList<MyCircle> p;


    Graphic(Slider[] params,ArrayList<MyCircle> points) {
        this.params = params;
        functions = new ArrayList<>();
        functions.add(t -> {
            if (t > -10. && t < 0.) {
                return (-t * t * t / 1000.);
            } else {
                return 0.;
            }
        }); // n_0
        functions.add(t -> {
            if (t > -10 && t < 0) {
                return ((t + 10.) * t * t / 1000.) - (10. - t) * (3 * t * t + 20 * t - 100) / 4000.;
            } else if (t > 0 && t < 10) {
                return (10 - t) * (10 - t) * (10 - t) / 4000.;
            } else {
                return 0.;
            }
        }); // n 1
        functions.add(t -> {
            if (t > -10 && t < 0) {
                return ((10 - t) * (t + 10) * (t + 10) / 4000.) - (t + 10) * (3 * t * t + 20 * t - 100) / 4000.;
            } else if (t > 0 && t < 10) {
                return ((t + 10) * (10 - t) * (10 - t) / 4000.) - (10 - t) * (3 * t * t - 20 * t - 100) / 4000.;
            } else {
                return 0.;
            }
        }); // n 2
        functions.add(t -> {
            if (t > -10 && t < 0) {
                return (t + 10) * (t + 10) * (t + 10) / 4000.;
            } else if (t > 0 && t < 10) {
                return ((10 - t) * t * t / 1000.) - (t + 10) * (3 * t * t - 20 * t - 100) / 4000.;
            } else {
                return 0.;
            }
        }); // n 3
        functions.add(t -> {
            if (t > 0 && t < 10) {
                return t * t * t / 1000.;
            } else {
                return 0.;
            }
        }); // n 4
        this.p = points;
    }

    public Slider[] getParams() {
        return params;
    }

    private double covfefe(double t){
        double res = 0;
        for(int i = 0; i < functions.size(); i++) {
            res += functions.get(i).apply(t) * getParams()[i].getValue();
        }
        return res;
    }
    /**
     * @return array of points from A to B depends on parametrs
     */
    private List<Vector> points() {
        ArrayList<Vector> res = new ArrayList<>();
        double step = 0.02;
        double cur = -9.999;
        double end = 10.;
        while (cur < end) {
            double c = covfefe(cur);
            double x = 0;
            double y = 0;
            for (int i = 0; i < functions.size(); i++) {
                x += functions.get(i).apply(cur) * getParams()[i].getValue() * p.get(i).getCenter().getX();
                y += functions.get(i).apply(cur) * getParams()[i].getValue() * p.get(i).getCenter().getY();
            }
            res.add(new Vector(x/c, y/c, 15));
            cur += step;
        }
        return res;
    }

    void draw(MyCanvas canvas, TMatrix state) {
        List<Vector> points = this.points();
        if(points.isEmpty()){
            return;
        }

        Drawer drawer = new Drawer();
        //drawer.drawPoints(canvas,points,state, Color.RED);
        drawer.drawCircle(canvas,p,state);

    }

}
