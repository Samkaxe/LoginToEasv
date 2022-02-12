package GUI.Controller;

import BE.Department;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public StackPane stackpane;
    @FXML
    public AnchorPane ancorpane;
    @FXML
    public Button backbtn;
    @FXML
    private ComboBox combobx;
    @FXML
    private ChoiceBox departmentcombo;
    @FXML
    private ChoiceBox classcombo;

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainWindow.fxml"));
        Scene scene = backbtn.getScene();
        root.translateYProperty().set(scene.getWidth());
        stackpane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackpane.getChildren().remove(ancorpane);
        });
        timeline.play();
    }


    public void login(ActionEvent actionEvent) {
        System.out.println(classcombo.getSelectionModel().getSelectedItem());
        System.out.println(combobx.getSelectionModel().getSelectedItem());
    }
    public void itemsinclass(){
        Department department1 = new Department(1,"SC",0);
        Department department2 = new Department(2,"ITO",0);
        Department department3 = new Department(3,"DBOS",0);
        Department department4 = new Department(4,"SDE",0);

        ObservableList<Department> departments = FXCollections.observableArrayList();
        departments.addAll(department1,department2,department3,department4);

        classcombo.setItems(departments);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createstudent();
    }

    public void createstudent(){
        combobx.setEditable(true);
        ObservableList<String> items = FXCollections.observableArrayList("mustafa alworo", "zahra something", "samkaxe", "diana jackobsen", "mathias jounier", "tawfic murad",
                "zakaria", "mikkel schalendar", "fridrick mansen", "lars kurkby");

        FilteredList<String> filteredItems = new FilteredList<>(items, p -> true);
        combobx.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            final TextField editor = combobx.getEditor();
            final String selected = (String) combobx.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                // If the no item in the list is selected or the selected item
                // isn't equal to the current input, we refilter the list.
                if (selected == null || !selected.equals(editor.getText())) {
                    filteredItems.setPredicate(item -> {
                        return item.toUpperCase().startsWith(newValue.toUpperCase());
                    });
                }
            });
        });
        combobx.setItems(filteredItems);
        itemsinclass();
    }
}
