package GUI.Controller;

import BE.Student;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

    public String selectedstudent ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createstudent();

    }

    public void createstudent(){
        Image image1 = new Image("/tools/image/studnets/1.jpg");
        Image image2 = new Image("/tools/image/studnets/2.jpg");
        Image image3 = new Image("/tools/image/studnets/3.jpg");
        Image image4 = new Image("/tools/image/studnets/4.jpg");
        Image image5 = new Image("/tools/image/studnets/5.jpg");
        Image image6 = new Image("/tools/image/studnets/6.jpg");

        Student student1 = new Student(1,"imad","conteb@live.com",158692,19253881 ,image1,"sdasdd",0);
        Student student2 = new Student(2,"john","srour@yahoo.com",154726,19285425 ,image2,"sdasdd",0);
        Student student3 = new Student(3 ,"darwin","helger@icloud.com",245842,17914099  ,image3,"sdasdd",0);
        Student student4 = new Student(4,"miami","scarlet@live.com",694252,61589431  ,image4,"sdasdd",0);
        Student student5 = new Student(5,"sarah","hyper@live.com",254861,18497631 ,image5,"sdasdd",0);
        Student student6 = new Student(6,"Dan","yzheng@optonline.net",287465,91549940 ,image6,"sdasdd",0);

        ObservableList<Student> students = FXCollections.observableArrayList();
        students.addAll(student1,student2,student3,student4,student5,student6);

        for(Student i : students){
            view = new ImageView(i.getImage());
            Label lbl = new Label(i.getName());
            vBox = new VBox();
            vBox.getChildren().add(view);
            vBox.getChildren().add(lbl);
            tilepane.getChildren().add(vBox);
            vBox.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        selectedstudent = i.getName();
                        System.out.println("student selected : " +  i.getName());
                        FXMLLoader omori = new FXMLLoader(getClass().getResource("/GUI/View/Class.fxml"));
                        Parent root = omori.load();
                        omori.<ClassController>getController().setController(LoginwithpicsController.this);
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
