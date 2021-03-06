package kp;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import kp.CustomCanvas.MyCanvas;
import kp.Misc.TMatrix;

/**
 * Class listener used to rotate figure
 */
public class RotationHandler implements EventHandler<MouseEvent> {

    private MyCanvas canvas;
    private TMatrix state;
    private double startX;
    private double startY;

    RotationHandler(MyCanvas c, TMatrix m){
        canvas = c;
        state = m;
        startX = c.getWidth()/2;
        startY = c.getHeight()/2;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        EventType<? extends MouseEvent> type = mouseEvent.getEventType();
        if(type == MouseEvent.MOUSE_PRESSED){
            startX = mouseEvent.getX();
            startY = mouseEvent.getY();
            System.out.println("click");
        }else{
            double diffX = mouseEvent.getSceneX() - startX;
            double diffY = mouseEvent.getSceneY() - startY;

            state.multyPly(TMatrix.rotationX(diffY));
            state.multyPly(TMatrix.rotationY(diffX));

            startX = mouseEvent.getSceneX();
            startY = mouseEvent.getSceneY();

            canvas.init();
        }
    }

    public TMatrix getState() {
        return state;
    }

    public void setState(TMatrix state) {
        this.state = state;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }
}
