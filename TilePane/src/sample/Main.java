package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {




    public static void main(String[] args) {
        launch(args);

        HelloWorld greetClass = new HelloWorld() {
            String greeting = "Hello World";

            @Override
            public void greet() {
                System.out.println(greeting);
            }
        };
        greetClass.greet();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
