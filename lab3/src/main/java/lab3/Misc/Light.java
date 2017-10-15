package lab3.Misc;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lab3.CustomCanvas.MyCanvas;

public class Light {
    private int r,g,b;

    public Light(int r,int g,int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void fillPolygon(MyCanvas canvas, Vector p1, Vector p2, Vector p3,Color col, double inten) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(
                Color.rgb(
                        Math.min((int) ((col.getRed() + this.r)*inten),255),
                        Math.min((int) ((col.getGreen() + this.g)*inten),255),
                        Math.min((int) ((col.getBlue() + this.b)*inten),255)
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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
