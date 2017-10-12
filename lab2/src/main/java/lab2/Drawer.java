package lab2;

import com.sun.scenario.effect.impl.prism.PrImage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lab2.CustomCanvas.MyCanvas;
import lab2.Misc.TMatrix;
import lab2.Misc.Vector;

import java.util.List;

public class Drawer {

    public Drawer() {
    }

    public void initCord(MyCanvas canvas, TMatrix state) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHEAT);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int axisSize = 50;
        Vector zero = state.transform(new Vector(0, 0, 0, 1));
        Vector x = state.transform(new Vector(axisSize, 0, 0, 1));
        Vector y = state.transform(new Vector(0, axisSize, 0, 1));
        Vector z = state.transform(new Vector(0, 0, axisSize, 1));
        line(canvas, zero, x, Color.RED);
        line(canvas, zero, y, Color.GREEN);
        line(canvas,zero,z,Color.BLUE);
    }

    public void draw(MyCanvas canvas, List<Vector> points) {
        /*for(int i = 0; i < points.size(); i++) {
            Vector cur = points.get(i);
            Vector next = points.get((i + 1) % points.size());
            cur = canvas.getState().transform(cur);
            next = canvas.getState().transform(next);
            line(canvas,cur,next,Color.BLACK);
        }*/
        Vector def = new Vector(
                0,
                0,
                points.get(0).getZ(),
                points.get(0).getH()
        );
        int n = points.size();
        for (int i = 0; i < n; i++) {
            drawTriangle(canvas,
                    def,
                    points.get(i % n),
                    points.get((i + 1) % n));
        }
    }

    public void draw(MyCanvas canvas,Vector p1,Vector p2){
        Vector t1 = canvas.getState().transform(p1);
        Vector t2 = canvas.getState().transform(p2);
        line(canvas,t1,t2,Color.BLACK);
    }

    public void drawTriangle(MyCanvas canvas,Vector p1,Vector p2,Vector p3) {
        draw(canvas,p1,p2);
        draw(canvas,p1,p3);
        draw(canvas,p2,p3);
    }

    public void rVector(MyCanvas canvas, Vector p) {
        Vector zero = new Vector(0, 0, 0,1);
        line(canvas, zero, p, Color.YELLOW);
    }

    private void line(MyCanvas canvas, Vector p1, Vector p2, Paint color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int xCenter = (int) canvas.getWidth() / 2;
        int yCenter = (int) canvas.getHeight() / 2;
        gc.setStroke(color);
        double h1 = p1.getH();
        double h2 = p2.getH();
        int a = 5/2;
        gc.strokeLine(
                p1.getX() * h1 + xCenter, -p1.getY() * h1 + yCenter,
                p2.getX() * h2 + xCenter, -p2.getY() * h2 + yCenter);
    }

}
