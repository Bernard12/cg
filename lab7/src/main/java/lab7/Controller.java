package lab7;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lab7.CustomCanvas.MyCanvas;
import lab7.Misc.MyCircle;
import lab7.Misc.TMatrix;
import lab7.Misc.Vector;

import java.util.ArrayList;

/*
    Class to connect view(data from window) and logic
 */
public class Controller {

    @FXML
    private AnchorPane cent7;

    @FXML
    private Slider w1;

    @FXML
    private Slider w2;

    @FXML
    private Slider w3;

    @FXML
    private Slider w4;

    @FXML
    private Slider w5;

    @FXML
    private void initialize() {
        Slider[] params = {w1, w2, w3, w4, w5};
        ArrayList<MyCircle> points = new ArrayList<>();
        points.add(new MyCircle(new Vector(-8, 4, 10), 5, Color.AQUA));
        points.add(new MyCircle(new Vector(-6, 5, 10), 5, Color.RED));
        points.add(new MyCircle(new Vector(0, 3, 10), 5, Color.AZURE));
        points.add(new MyCircle(new Vector(6, 5, 10), 5, Color.GREEN));
        points.add(new MyCircle(new Vector(8, 4, 10), 5, Color.BLUE));

        TMatrix state = new TMatrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}}
        );
        Graphic graphic = new Graphic(params, points);

        MyCanvas canvas = new MyCanvas(
                cent7.getPrefWidth(),
                cent7.getPrefHeight()
        );
        double width = cent7.getPrefWidth();
        double height = cent7.getPrefHeight();

        AnchorPane.setTopAnchor(canvas, 0.0);
        AnchorPane.setBottomAnchor(canvas, 0.0);
        AnchorPane.setLeftAnchor(canvas, 0.0);
        AnchorPane.setRightAnchor(canvas, 0.0);

        for (Slider slider : params) {
            slider.valueProperty().addListener((observableValue, number, t1) -> {
                canvas.init();
                graphic.draw(canvas, state);
            });
        }

        canvas.widthProperty().addListener((observableValue, number, t1) -> {
            double sc = t1.doubleValue() / width;
            state.getMatrix()[2][2] = sc;
        });
        canvas.heightProperty().addListener((observableValue, number, t1) -> {
            double sc = t1.doubleValue() / height;
            state.getMatrix()[2][2] = sc;
        });
        final int[] pressed = {-1};
        final int[] curX = {-1};
        final int[] curY = {-1};
        cent7.setOnMouseClicked(mouseEvent -> {
            int x = (int) mouseEvent.getX();
            int y = (int) -mouseEvent.getY();
            int xCenter = (int) canvas.getWidth() / 2;
            int yCenter = (int) canvas.getHeight() / 2;
            x -= xCenter;
            y += yCenter;
            //System.out.println(x + " " + y);
            for(int i = 0; i < points.size(); i++){
                Vector v = new Vector(points.get(i).getCenter());
                v = state.transform(v);
                double d = Math.pow(v.getX()*v.getH() - x,2) + Math.pow(v.getY()*v.getH() - y,2);
                double r = points.get(i).getR();
                if( d < r * r){
                    pressed[0] = i;
                    System.out.println(i);
                    curX[0] = (int) mouseEvent.getX();
                    curY[0] = (int) mouseEvent.getY();
                    break;
                }
            }
        });

        cent7.setOnMouseDragged(mouseEvent -> {
            int x = (int) mouseEvent.getX();
            int y = (int) mouseEvent.getY();
            if(pressed[0]!=-1){
                MyCircle circle = points.get(pressed[0]);
                Vector r = circle.getCenter();
                double diffX = x - curX[0];
                double diffY = y - curY[0];

                r.setX(r.getX() + diffX);
                r.setY(r.getY() - diffY);
                curX[0] = x;
                curY[0] = y;
                canvas.init();
                graphic.draw(canvas, state);
            }
        });

        cent7.setOnMouseReleased(mouseEvent -> {
            pressed[0] = -1;
        });

        cent7.getChildren().add(canvas);
    }

}
