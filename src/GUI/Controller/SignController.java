package GUI.Controller;

import BE.Student;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SignController {
    @FXML
    public Button bck;
    @FXML
    public StackPane stackpane;
    @FXML
    public AnchorPane anchorpane;
    @FXML
    public TextField firstname;
    @FXML
    public TextField email;
    @FXML
    public TextField telephone;
    @FXML
    public TextField adress;
    @FXML
    public TextField cpr;
    @FXML
    public Button upload;
    @FXML
    public ImageView image;
    @FXML
    public TextField lastname;
    @FXML
    private Image image2 ;
    @FXML
    private int tel ;
    @FXML
    private int cprr ;

    public void save(ActionEvent actionEvent) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        if(!telephone.getText().isEmpty()) {
             tel = Integer.parseInt(telephone.getText());
        }
        if(!cpr.getText().isEmpty()) {
             cprr = Integer.parseInt(cpr.getText());
        }
       Student student = new Student(1,firstname.getText()+ " "+lastname.getText(),email.getText(),tel,cprr,image2,adress.getText(),0);
       students.add(student);
        System.out.println(students);

        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainWindow.fxml"));
        Scene scene = bck.getScene();
        root.translateXProperty().set(scene.getWidth());
        stackpane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackpane.getChildren().remove(anchorpane);
        });
        timeline.play();

    }

    public void upload(){
        upload.setOnAction(event -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG FILE","*png"));
            File file =  fileChooser.showOpenDialog(stage);
           if(file != null) {
               image2 = new Image(file.toString());
               image.setImage(image2);
           }
                });
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainWindow.fxml"));
        Scene scene = bck.getScene();
        root.translateXProperty().set(scene.getWidth());
        stackpane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackpane.getChildren().remove(anchorpane);
        });
        timeline.play();
    }
}
