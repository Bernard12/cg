package lab4;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class Controller {


    @FXML
    private Slider r;

    @FXML
    private void initialize() {
        r.valueProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println(newValue.doubleValue());
        }));
    }
}
