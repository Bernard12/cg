package lab2.CustomCanvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lab2.Drawer;
import lab2.Figure;
import lab2.Misc.TMatrix;


public class MyCanvas extends Canvas {

    private TMatrix state;
    private Figure fig;
    private double initWidth;
    private double initHeight;

    public MyCanvas(double width, double height,TMatrix m) {
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
        drawer.draw(this,fig.getFirstLevel());
        drawer.draw(this,fig.getSecondLevel());
        int n = fig.getFirstLevel().size();
        for(int i = 0; i < n;i++) {
            drawer.drawTriangle(this,
                    fig.getFirstLevel().get(i % n),
                    fig.getFirstLevel().get((i + 1) % n),
                    fig.getSecondLevel().get(i % n));
            drawer.drawTriangle(this,
                    fig.getSecondLevel().get(i % n),
                    fig.getSecondLevel().get((i + 1) % n),
                    fig.getFirstLevel().get((i + 1) % n));
        }

        int a = 5/2;
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
