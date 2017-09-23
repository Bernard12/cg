package lab;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lab.CustomCanvas.MyCanvas;
import lab.Misc.TMatrix;
import lab.Misc.Vector;

import java.util.List;

public class Drawer {

    private final MyCanvas canvas;

    private int xCenter,yCenter;

    public Drawer(MyCanvas canvas) {
        this.canvas = canvas;
        this.xCenter = (int)canvas.getWidth()/2;
        this.yCenter = (int)canvas.getHeight()/2;
    }

    public MyCanvas getCanvas() {
        return canvas;
    }


    public void initCord(TMatrix matrix) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHEAT);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        int axisSize = 50;
        Vector zero = matrix.transform(new Vector(0, 0,1));
        Vector x = matrix.transform(new Vector(axisSize, 0,1));
        Vector y = matrix.transform(new Vector(0, axisSize,1));
        this.line(zero,x,Color.GREEN);
        this.line(zero,y,Color.RED);
    }

    public void draw(List<Vector> points,TMatrix matrix){
        this.initCord(matrix);
        for (int i = 1; i < points.size(); i++) {
            Vector t1 = points.get(i-1);
            Vector t2 = points.get(i);
            Vector firstPoint = matrix.transform(t1);
            Vector secondPoint = matrix.transform(t2);
            this.line(firstPoint, secondPoint, Color.GOLDENROD);
        }
    }

    public void rVector(Vector p){
        Vector zero = new Vector(0, 0,1);
        this.line(zero,p,Color.YELLOW);
    }

    public void line(Vector p1, Vector p2, Paint color){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(color);
        gc.strokeLine(
                p1.getX()+xCenter,-p1.getY()+yCenter,
                p2.getX()+xCenter,-p2.getY()+yCenter);
    }

}
