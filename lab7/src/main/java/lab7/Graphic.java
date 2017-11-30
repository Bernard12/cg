package lab7;

import javafx.scene.control.Slider;
import lab7.CustomCanvas.MyCanvas;
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
    private ArrayList<Function<Double,Double>> functions = new ArrayList<>();

    Graphic(Slider[] params) {
        this.params = params;
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
    }

    public Slider[] getParams() {
        return params;
    }

    /**
     * @return array of points from A to B depends on parametrs
     */
    private List<Vector> points(){

        return null;
    }

    void draw(MyCanvas canvas, TMatrix state) {
        List<Vector> points = this.points();
        if(points.isEmpty()){
            return;
        }

        Drawer drawer = new Drawer();
        drawer.draw(canvas,points,state);

    }

}
