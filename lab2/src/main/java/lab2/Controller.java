package lab2;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lab2.CustomCanvas.MyCanvas;
import lab2.Misc.TMatrix;

public class Controller {

    @FXML
    private AnchorPane center;

    @FXML
    private void initialize() {
        TMatrix state = new TMatrix(new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}}
        );


        MyCanvas canvas = new MyCanvas(
                center.getPrefWidth(),
                center.getPrefHeight(),
                state
        );

        double width = center.getPrefWidth();
        double height = center.getPrefHeight();

        RotationHandler rot = new RotationHandler(canvas,state);

        AnchorPane.setTopAnchor(canvas, 0.0);
        AnchorPane.setBottomAnchor(canvas, 0.0);
        AnchorPane.setLeftAnchor(canvas, 0.0);
        AnchorPane.setRightAnchor(canvas, 0.0);

        canvas.widthProperty().addListener((observableValue, number, t1) -> {
            double sc = t1.doubleValue() / width;
            state.getMatrix()[3][3] = sc;
        });
        canvas.heightProperty().addListener((observableValue, number, t1) -> {
            double sc = t1.doubleValue() / height;
            state.getMatrix()[3][3] = sc;
        });

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,rot);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,rot);
        center.getChildren().add(canvas);
    }

}
