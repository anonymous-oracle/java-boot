package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
   private Task<ObservableList<String>> task;
   public void initialize(){
       task = new Task<ObservableList<String>>() {
           @Override
           protected ObservableList<String> call() throws Exception {
Thread.sleep(1000);
           return FXCollections.observableArrayList("abc","pqr","xyz");
           }
       };
   }


    @FXML
    public void buttonPressed(ActionEvent actionEvent) {
       new Thread(task).start();
    }
}
