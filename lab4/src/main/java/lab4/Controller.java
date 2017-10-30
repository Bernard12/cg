package lab4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;


public class Controller {


    @FXML
    private Slider r;

    @FXML
    private Slider g;

    @FXML
    private Slider b;

    @FXML
    private Button bt;

    @FXML
    private void initialize() {
        bt.setOnAction(event -> {
            System.out.println(1);
            Main.red = (float) r.getValue();
            Main.green = (float) g.getValue();
            Main.blue = (float) b.getValue();
        });
    }
}
