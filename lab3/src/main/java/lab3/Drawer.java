package lab3;

import com.sun.scenario.effect.impl.prism.PrImage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lab3.CustomCanvas.MyCanvas;
import lab3.Misc.TMatrix;
import lab3.Misc.Vector;

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

    public void draw(MyCanvas canvas, List<Vector> points,int k) {
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
        Vector def = new Vector(0, 0, 50, 1);

        Vector t1 = canvas.getState().transform(p1);
        Vector t2 = canvas.getState().transform(p2);
        Vector t3 = canvas.getState().transform(p3);


        Vector sb1 = Vector.sub(t1, t2);
        Vector sb2 = Vector.sub(t1, t3);
        Vector n = Vector.crossProduct(sb1, sb2);
        if (Vector.tripleProduct(sb1, sb2, n) < 0) {
            n = Vector.crossProduct(sb2, sb1);
        }
        double d = Vector.dotProduct(def, n);
        Vector v = canvas.getState().transform(new Vector(0, 0, 10, 1));
        Vector c = Vector.sub(t1, v);
        int kk = 1;
        if (Vector.dotProduct(c, n) < 0) {
            kk = -1;
        }
        if (kk * d < 0) {
            double inten = d/(def.lenght()*n.lenght());
            canvas.getLight().fillPolygon(canvas,p1,p2,p3,inten);
            line(canvas, t1, t2, Color.BLACK);
            line(canvas, t1, t3, Color.BLACK);
            line(canvas, t2, t3, Color.BLACK);
        }
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
        gc.strokeLine(
                p1.getX() * h1 + xCenter, -p1.getY() * h1 + yCenter + 50,
                p2.getX() * h2 + xCenter, -p2.getY() * h2 + yCenter + 50);
    }

}
