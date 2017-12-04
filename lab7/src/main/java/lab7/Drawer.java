package lab7;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import lab7.CustomCanvas.MyCanvas;
import lab7.Misc.MyCircle;
import lab7.Misc.TMatrix;
import lab7.Misc.Vector;

import java.util.List;

/**
 * @author Ivan Simakhin
 * Functional class to drawPoints lines between 2 point
 */
public class Drawer {

    public Drawer() {
    }

    // Draw coodrinate system
    public void initCord(MyCanvas canvas, TMatrix state) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHEAT);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int axisSize = 50;
        Vector zero = new Vector(0, 0, 2);
        Vector x = new Vector(axisSize, 0, 2);
        Vector y = new Vector(0, axisSize, 2);
        line(canvas, zero, x, Color.GREEN);
        line(canvas, zero, y, Color.RED);
    }

    // drawPoints array of points
    void drawPoints(MyCanvas canvas, List<Vector> points, TMatrix state, Color p) {
        for (int i = 1; i < points.size(); i++) {
            Vector t1 = points.get(i - 1);
            Vector t2 = points.get(i);
            Vector firstPoint = state.transform(t1);
            Vector secondPoint = state.transform(t2);
            line(canvas, firstPoint, secondPoint, p);
        }
    }

    // drawPoints array of points
    void drawCircle(MyCanvas canvas, List<MyCircle> points, TMatrix state) {
        for (int i = 1; i < points.size(); i++) {
            MyCircle t1 = points.get(i - 1);
            MyCircle t2 = points.get(i);
            Vector nc1 = new Vector(t1.getCenter().getX(), t1.getCenter().getY(), t1.getCenter().getH());
            MyCircle nw1 = new MyCircle(nc1, t1.getR(), t1.getCol());
            nw1.setCenter(state.transform(nc1));
            Vector nc2 = new Vector(t2.getCenter().getX(), t2.getCenter().getY(), t2.getCenter().getH());
            MyCircle nw2 = new MyCircle(nc2, t2.getR(), t2.getCol());
            nw2.setCenter(state.transform(nc2));
            circle(canvas, nw1, nw2, nw1.getCol(),nw2.getCol());
        }
    }

    // connect 2 point with a line
    private void line(MyCanvas canvas, Vector p1, Vector p2, Paint color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int xCenter = (int) canvas.getWidth() / 2;
        int yCenter = (int) canvas.getHeight() / 2;
        gc.setStroke(color);
        double h1 = p1.getH();
        double h2 = p2.getH();
        gc.strokeLine(
                p1.getX() * h1 + xCenter, -p1.getY() * h1 + yCenter,
                p2.getX() * h2 + xCenter, -p2.getY() * h2 + yCenter);
    }

    private void circle(MyCanvas canvas, MyCircle one, MyCircle two, Color color1,Color color2) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int xCenter = (int) canvas.getWidth() / 2;
        int yCenter = (int) canvas.getHeight() / 2;
        gc.setFill(color1);
        Vector center1 = one.getCenter();
        int x1 = (int) center1.getX();
        int y1 = (int) center1.getY();
        Vector center2 = two.getCenter();
        int x2 = (int) center2.getX();
        int y2 = (int) center2.getY();
        line(canvas, center1, center2, Color.BLACK);
        gc.fillOval(xCenter + x1 * center1.getH() - one.getR(), -y1 * center1.getH() + yCenter - one.getR(), 10, 10);
        gc.setFill(color2);

        gc.fillOval(xCenter + x2 * center2.getH() - two.getR(), -y2 * center2.getH() + yCenter - two.getR(), 10, 10);
        //center1.setX(xCenter + x1 * center1.getH());
        //center1.setY(yCenter + -y1 * center1.getH());
    }
}
