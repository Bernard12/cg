package lab1.CustomCanvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lab1.Drawer;
import lab1.Misc.TMatrix;


public class MyCanvas extends Canvas {

    private TMatrix state;
    private double initWidth;
    private double initHeight;

    public MyCanvas(double width, double height) {
        super(width, height);
        //widthProperty().addListener((observableValue, number, t1) -> init());
        //heightProperty().addListener((observableValue, number, t1) -> init());
        state = new TMatrix(new double[][] {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}}
        );
        initWidth = width;
        initHeight = height;
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.WHEAT);
        gc.fillRect(0, 0, getWidth(), getHeight());
        Drawer drawer = new Drawer();
        drawer.initCord(this, state);
    }

    @Override
    public final void resize(double width, double height) {
        double sc = Math.max(width / initWidth, height / initHeight);
        state.getMatrix()[2][2] = sc;
        setWidth(width);
        setHeight(height);
        init();
    }

    @Override
    public final boolean isResizable() {
        return true;
    }

    public void init() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.WHEAT);
        gc.fillRect(0, 0, getWidth(), getHeight());
        Drawer drawer = new Drawer();
        drawer.initCord(this, state);
    }
}
