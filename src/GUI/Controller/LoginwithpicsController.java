package GUI.Controller;

import BE.DD;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class LoginwithpicsController implements Initializable {
    @FXML
    public StackPane stackpane;
    @FXML
    private TilePane tilepane;
    @FXML
    private ImageView view;
    @FXML
    private VBox vBox;

    public static int softwereconstruction ;
    public static int softweredesign ;
    public static int itorganistion ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createstudent();

    }

    public void createstudent() {
        Image image1 = new Image("/tools/image/studnets/1.jpg");
        Image image2 = new Image("/tools/image/studnets/2.jpg");
        Image image3 = new Image("/tools/image/studnets/3.jpg");
        Image image4 = new Image("/tools/image/studnets/4.jpg");
        Image image5 = new Image("/tools/image/studnets/5.jpg");
        Image image6 = new Image("/tools/image/studnets/6.jpg");

        Student student1 = new Student(1,"imad","conteb@live.com",158692,19253881 ,image1,null,"sdasdd",0,0,0,0);
        Student student2 = new Student(2,"john","srour@yahoo.com",154726,19285425 ,image2,null,"sdasdd",0,0,0,0);
        Student student3 = new Student(3 ,"darwin","helger@icloud.com",245842,17914099  ,image3,null,"sdasdd",0,0,0,0);
        Student student4 = new Student(4,"miami","scarlet@live.com",694252,61589431  ,image4,null,"sdasdd",0,0,0,0);
        Student student5 = new Student(5,"sarah","hyper@live.com",254861,18497631 ,image5,null,"sdasdd",0,0,0,0);
        Student student6 = new Student(6,"Dan","yzheng@optonline.net",287465,91549940 ,image6,null,"sdasdd",0,0,0,0);

        ObservableList<Student> students = FXCollections.observableArrayList();
        students.addAll(student1, student2, student3, student4, student5, student6);

        for (Student i : students) {
            view = new ImageView(i.getImage());
            Label lbl = new Label(i.getName());
            vBox = new VBox();
            vBox.getChildren().add(view);
            vBox.getChildren().add(lbl);
            tilepane.getChildren().add(vBox);
            vBox.setOnMousePressed(event -> {

                SimpleDateFormat dayformat = new SimpleDateFormat("E");
                String day = dayformat.format(Calendar.getInstance().getTime());

                switch (day){
                    case "Mon" :
                        i.setScoalt(i.getScoalt() + 1);
                        System.out.println(i.getScoalt());
                        break;
                    case "Tus" :
                        i.setScoalt(softwereconstruction++);
                        break;
                    case "Wed" :
                       i.setItoalt(softweredesign++);
                       i.setSdealt( itorganistion++);
                        break;
                    case "Ther" :
                        i.setSdealt( itorganistion++);
                        i.setScoalt(softwereconstruction++);
                        break;
                    case "Fri" :
                        i.setSdealt( itorganistion++);
                        break;
                }

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alert");
                    alert.setHeaderText(null);
                    alert.setContentText("Login success ");
                    alert.showAndWait();

                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainWindow.fxml"));
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

            });

        }

    }

}







