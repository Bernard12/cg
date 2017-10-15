package lab3.CustomCanvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lab3.Drawer;
import lab3.Figure;
import lab3.Misc.TMatrix;


public class MyCanvas extends Canvas {

    private TMatrix state;
    private Figure fig;
    private double initWidth;
    private double initHeight;

    public MyCanvas(double width, double height, TMatrix m) {
        super(width, height);
        state = m;
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
        state.getMatrix()[3][3] = sc;
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
        fig.draw(this, 10);
    }

    public TMatrix getState() {
        return state;
    }

    public void setFig(Figure fig) {
        this.fig = fig;
    }

    public Figure getFig() {
        return fig;
    }
}
