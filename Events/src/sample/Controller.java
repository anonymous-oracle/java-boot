package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML // variable names using fxml id's should either be annotated or should be declared with public access modifier
    private TextField nameField; // variable name should be same as that of id of textfield element

    @FXML
    private Button helloButton;

    @FXML
    private Button byeButton;

    @FXML
    private CheckBox ourCheckBox;

    @FXML
    private Label ourLabel;

//    @FXML // no need to annotate event handlers but doing so helps improve code readability
//    public void onButtonClick(ActionEvent e) {
//        System.out.println("Hello, " + nameField.getText());
//        System.out.println("The following button was pressed: " + e.getSource());
//    }

    @FXML // all functionality implemented in this method will be executed whenever the GUI program is run
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClick(ActionEvent e) {
        if (e.getSource().equals(this.helloButton)) {
            System.out.println("Hello, " + this.nameField.getText());
        } else if (e.getSource().equals(this.byeButton)) {
            System.out.println("Bye, " + this.nameField.getText());
        }

//        this is just to demonstrate how UI threads interact because the UI and the event handler run on separate threads
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I am going to sleep on the: " + s);
                    Thread.sleep(3000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I am updating the label on the: " + s);
                            ourLabel.setText("We did something!");
                        }
                    });
                } catch (InterruptedException event) {
//            nothing to do here
                }
            }
        };
        new Thread(task).start(); // call to start a thread

        if (this.ourCheckBox.isSelected()) {
            nameField.clear();
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = this.nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleChange() {
        System.out.println("The checkbox is " + (this.ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}
