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
        // this is useless
    public void combo(ActionEvent actionEvent) {
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
        combobx.setEditable(true);
        ObservableList<String> items = FXCollections.observableArrayList("mustaf", "zahra", "samkaxe", "diana", "java", "c#",
                "i", "hate", "jave", "omori");
        FilteredList<String> filteredItems = new FilteredList<>(items, p -> true);
        combobx.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            final TextField editor = combobx.getEditor();
            final String selected = (String) combobx.getSelectionModel().getSelectedItem();
            // This needs run on the GUI thread to avoid the error described
            // here: https://bugs.openjdk.java.net/browse/JDK-8081700.
            Platform.runLater(() -> {
                // If the no item in the list is selected or the selected item
                // isn't equal to the current input, we refilter the list.
                if (selected == null || !selected.equals(editor.getText())) {
                    filteredItems.setPredicate(item -> {
                        // We return true for any items that starts with the
                        // same letters as the input. We use toUpperCase to
                        // avoid case sensitivity.
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });
        });
        combobx.setItems(filteredItems);
        itemsinclass();
    }

    /*

        ComboBox<String> cb = new ComboBox<String>();
        cb.setEditable(true);

        // Create a list with some dummy values.
        ObservableList<String> items = FXCollections.observableArrayList("One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten");

        // Create a FilteredList wrapping the ObservableList.
        FilteredList<String> filteredItems = new FilteredList<String>(items, p -> true);

        // Add a listener to the textProperty of the combobox editor. The
        // listener will simply filter the list every time the input is changed
        // as long as the user hasn't selected an item in the list.
        cb.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            final TextField editor = cb.getEditor();
            final String selected = cb.getSelectionModel().getSelectedItem();

            // This needs run on the GUI thread to avoid the error described
            // here: https://bugs.openjdk.java.net/browse/JDK-8081700.
            Platform.runLater(() -> {
                // If the no item in the list is selected or the selected item
                // isn't equal to the current input, we refilter the list.
                if (selected == null || !selected.equals(editor.getText())) {
                    filteredItems.setPredicate(item -> {
                        // We return true for any items that starts with the
                        // same letters as the input. We use toUpperCase to
                        // avoid case sensitivity.
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });
        });

        cb.setItems(filteredItems);

        root.getChildren().add(cb);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
     */
}
