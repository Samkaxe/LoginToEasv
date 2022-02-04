package GUI.Controller;

import GUI.Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginwithpicsController implements Initializable {
    @FXML
    private TilePane tilepane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Student student1 = new Student(1,"lina");
        Student student2 = new Student(2,"Maria");
        Student student3 = new Student(3 ,"Lilane");
        Student student4 = new Student(4,"Omori");
        Student student5 = new Student(5,"Kel");
        Student student6 = new Student(6,"Áubrey");
        Student student7 = new Student(7 , "Hero");

        ObservableList<Student> students = FXCollections.observableArrayList();
        students.addAll(student1,student2,student3,student4,student5,student6,student7);

        for(Student i : students){
            ImageView view = new ImageView("tools/userpicture.png");
            Label lbl = new Label(i.getName());
            VBox vBox = new VBox();
            vBox.getChildren().add(view);
            vBox.getChildren().add(lbl);
            tilepane.getChildren().add(vBox);
        }

        /*
        for(Student i : students){
            Button btn = new Button(i.getName());
            btn.setLayoutX(100);
            btn.setLayoutY(100);
            tilepane.getChildren().add(btn);
        }

         */


        /*
        for(int i = 0 ; i < 10 ; i++){
            Button btn = new Button("new button " + i);
            btn.setLayoutX(100*i);
            btn.setLayoutY(0);
            tilepane.getChildren().add(btn);
        }

         */
    }
}
