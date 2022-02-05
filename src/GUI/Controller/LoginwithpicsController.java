package GUI.Controller;

import GUI.Model.Student;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginwithpicsController implements Initializable {
    @FXML
    public StackPane stackpane;
    @FXML
    private TilePane tilepane;
    @FXML
    private ImageView view ;
    @FXML
    private VBox vBox ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Student student1 = new Student(1,"lina");
        Student student2 = new Student(2,"Maria");
        Student student3 = new Student(3 ,"Lilane");
        Student student7 = new Student(7 , "Hero");
        Student student4 = new Student(4,"Omori");
        Student student5 = new Student(5,"Kel");
        Student student6 = new Student(6,"Áubrey");

        ObservableList<Student> students = FXCollections.observableArrayList();
        students.addAll(student1,student2,student3,student4,student5,student6,student7);

        for(Student i : students){
             view = new ImageView("tools/userpicture.png");
            Label lbl = new Label(i.getName());
             vBox = new VBox();
            vBox.getChildren().add(view);
            vBox.getChildren().add(lbl);
            tilepane.getChildren().add(vBox);
            vBox.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        System.out.println("student selected : " +  i.getName());
                        FXMLLoader omori = new FXMLLoader(getClass().getResource("/GUI/View/Class.fxml"));
                        Parent root = omori.load();
                        Scene scene = vBox.getScene();
                        root.translateXProperty().set(scene.getWidth());
                        stackpane.getChildren().add(root);
                        Timeline timeline = new Timeline();
                        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
                        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
                        timeline.getKeyFrames().add(kf);
                        timeline.setOnFinished(t -> {
                            stackpane.getChildren().remove(tilepane);
                        });
                        timeline.play();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }


}
