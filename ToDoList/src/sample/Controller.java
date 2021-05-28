package sample;

import datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;

    @FXML
    private ListView todoListView;
    @FXML
    private TextArea itemDetails;
    @FXML
    private Label deadLineLabel;

    public void initialize() { // starts the UI with the following initialization
        TodoItem item1 = new TodoItem("Complete the java course", "Complete the java course according to plan. It will be useful for many things", LocalDate.of(2021, Month.MAY, 31));
        TodoItem item2 = new TodoItem("Complete the java servlets course", "After completing the java course complete the java servlets course", LocalDate.of(2021, Month.JUNE, 30));
        TodoItem item3 = new TodoItem("Complete the spring beginner course", "Complete the spring framework course to learn backend development", LocalDate.of(2021, Month.JULY, 31));
        TodoItem item4 = new TodoItem("Learn algorithms and data structures", "Learn algorithms and data structures in Java so that it gives a better understanding about programming", LocalDate.of(2021, Month.AUGUST, 31));
        TodoItem item5 = new TodoItem("Learn system design", "Learn system design and complete the coding decks", LocalDate.of(2021, Month.SEPTEMBER, 30));
        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

//        here the selected item data is obtained by the getSelectionModel's getSelectedItem method;
//        using this whenever a change happens, a listener is added to the selected model's selected item property and
//        the text area is replaced with the selected item's object and the text area is set with it's details
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if (t1 != null) {
                    TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
                    itemDetails.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
                    deadLineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // select only one item at a time
        // by default first item will be selected when UI starts; however this would not count as a mouse click and hence any click based event handlers won't be triggered
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView() {
        TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
        itemDetails.setText(item.getDetails());
        deadLineLabel.setText(item.getDeadline().toString());
        ////        System.out.println("Selected item is: " + item);
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline());
//        itemDetails.setText(sb.toString());
    }
}
