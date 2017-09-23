package lab.CustomCanvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lab.Drawer;
import lab.Graphic;
import lab.Misc.TMatrix;


public class MyCanvas extends Canvas {

    private TMatrix matrix;
    private Graphic g;
    private double initWidth;
    private double initHeight;

    public MyCanvas(double width, double height,
                    TMatrix matrix, Graphic g){
        super(width,height);
        this.matrix = matrix;
        this.initWidth = width;
        this.initHeight = height;
        this.g = g;
    }

    @Override
    public final void resize(double width, double height){
        setWidth(width);
        setHeight(height);
        final GraphicsContext gc = getGraphicsContext2D();

        double wChange = width/ initWidth;
        double hChange = height/ initHeight;
        double sc = Math.max(wChange,hChange);
        double[][] newM = {
                {sc, 0,  0},
                {0,  sc, 0},
                {0,  0,  1}
        };
        double[][] newM2 = {
                {sc, 0,  0},
                {0,  sc, 0},
                {0,  0,  1}
        };
        //this.matrix = this.matrix.multyPly(new TMatrix(newM));
        matrix = new TMatrix(newM);
        g.setMatrix(new TMatrix(newM2));
        gc.setFill(Color.WHEAT);
        gc.fillRect(0,0,getWidth(),getHeight());
        Drawer drawer = new Drawer(this);
        drawer.initCord(matrix);
    }

    @Override
    public final boolean isResizable(){
        return true;
    }

    public TMatrix getMatrix() {
        return matrix;
    }
}
