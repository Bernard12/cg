package lab;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lab.CustomCanvas.MyCanvas;
import lab.Misc.TMatrix;
import lab.Misc.Vector;

import java.util.List;

public class Drawer {

    public Drawer() {
    }

    public void initCord(MyCanvas canvas, TMatrix state) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHEAT);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int axisSize = 50;
        Vector zero = state.transform(new Vector(0, 0, 1));
        Vector x = state.transform(new Vector(axisSize, 0, 1));
        Vector y = state.transform(new Vector(0, axisSize, 1));
        line(canvas, zero, x, Color.GREEN);
        line(canvas, zero, y, Color.RED);
    }

    public void draw(MyCanvas canvas, List<Vector> points, TMatrix state) {
        for (int i = 1; i < points.size(); i++) {
            Vector t1 = points.get(i - 1);
            Vector t2 = points.get(i);
            Vector firstPoint = state.transform(t1);
            Vector secondPoint = state.transform(t2);
            line(canvas, firstPoint, secondPoint, Color.GOLDENROD);
        }
    }

    public void rVector(MyCanvas canvas, Vector p) {
        Vector zero = new Vector(0, 0, 1);
        line(canvas, zero, p, Color.YELLOW);
    }

    private void line(MyCanvas canvas, Vector p1, Vector p2, Paint color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int xCenter = (int) canvas.getWidth() / 2;
        int yCenter = (int) canvas.getHeight() / 2;
        gc.setStroke(color);
        double h1 = p1.getH();
        double h2 = p2.getH();
        gc.strokeLine(
                (p1.getX() / h1) + xCenter, (-p1.getY() / h1) + yCenter,
                (p2.getX() / h2) + xCenter, (-p2.getY() / h2) + yCenter);
    }

}
