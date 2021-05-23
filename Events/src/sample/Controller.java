package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML // variable names using fxml id's should either be annotated or should be declared with public access modifier
    private TextField nameField; // variable name should be same as that of id of textfield element

    @FXML // no need to annotate event handlers but doing so helps improve code readability
    public void onButtonClick() {
        System.out.println("Hello, " + nameField.getText());
    }
}
