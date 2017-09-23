package lab.CustomCanvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lab.Drawer;
import lab.Graphic;
import lab.Misc.TMatrix;


public class MyCanvas extends Canvas {

    private TMatrix matrix;
    private double initWidth;
    private double initHeight;

    public MyCanvas(double width, double height) {
        super(width, height);
        this.matrix = new TMatrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}}
        );
        this.initWidth = width;
        this.initHeight = height;
    }

    @Override
    public final void resize(double width, double height) {
        setWidth(width);
        setHeight(height);
        final GraphicsContext gc = getGraphicsContext2D();
        double wChange = initWidth / width;
        double hChange = initHeight / height;
        gc.setFill(Color.WHEAT);
        gc.fillRect(0, 0, getWidth(), getHeight());
        double sc = Math.max(wChange, hChange);
        matrix.getMatrix()[2][2] = sc;
        Drawer drawer = new Drawer();
        drawer.initCord(this, getMatrix());
    }

    @Override
    public final boolean isResizable() {
        return true;
    }

    public TMatrix getMatrix() {
        return matrix;
    }
}
