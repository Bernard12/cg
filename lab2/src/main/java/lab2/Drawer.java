package lab2;

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
        Vector z = state.transform(new Vector(0, 0, 30, 1));
        line(canvas, zero, x, Color.RED);
        line(canvas, zero, y, Color.GREEN);
        line(canvas,zero,z,Color.BLUE);
    }

    public void draw(MyCanvas canvas, List<Vector> points, TMatrix state) {

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
