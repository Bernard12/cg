package lab3.Misc;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lab3.CustomCanvas.MyCanvas;

public class Light {
    private Color color;

    public Light(Color color) {
        this.color = color;
    }

    public void fillPolygon(MyCanvas canvas, Vector p1, Vector p2, Vector p3, double inten) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(
                Color.rgb(
                        (int)(Math.abs(255*inten)),
                        (int)(Math.abs(255*inten)),
                        (int)(Math.abs(255*inten))
                )
        );

        Vector t1 = canvas.getState().transform(p1);
        Vector t2 = canvas.getState().transform(p2);
        Vector t3 = canvas.getState().transform(p3);

        double h = t1.getH();
        int xCenter = (int) canvas.getWidth() / 2;
        int yCenter = (int) canvas.getHeight() / 2;

        gc.fillPolygon(
                new double[]{t1.getX() * h + xCenter, t2.getX() * h + xCenter, t3.getX() * h + xCenter},
                new double[]{-t1.getY() * h + yCenter + 50, -t2.getY() * h + yCenter + 50, -t3.getY() * h + yCenter + 50},
                3);
    }
}
