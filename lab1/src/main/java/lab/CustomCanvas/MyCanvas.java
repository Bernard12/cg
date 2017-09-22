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
        this.setWidth(width);
        this.setHeight(height);
        final GraphicsContext gc = this.getGraphicsContext2D();
        double sc = Math.max(width/ initWidth,height / initHeight);
        this.matrix.getMatrix()[0][0] = sc;
        this.matrix.getMatrix()[1][1] = sc;
        gc.setFill(Color.WHEAT);
        gc.fillRect(0,0,this.getWidth(),this.getHeight());
        Drawer drawer = new Drawer(this);
        drawer.initCord(matrix);
        g.draw(this);
    }

    @Override
    public final boolean isResizable(){
        return true;
    }

}
