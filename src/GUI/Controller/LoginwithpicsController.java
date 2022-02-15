package GUI.Controller;

import BE.Student;
import GUI.Model.ManagerModel;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class LoginwithpicsController implements Initializable {
    @FXML
    private StackPane stackpane;
    @FXML
    private TilePane tilepane;
    @FXML
    private ImageView view;
    @FXML
    private VBox vBox;

    ManagerModel model = new ManagerModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createstudent();

    }

    public void createstudent() {

        model.getStudnets();

        java.util.Date Ust = new Date();
        java.sql.Date date = new java.sql.Date(Ust.getTime());

        for (Student i : model.getStudnets()) {
            view = new ImageView(i.getImage());
            Label lbl = new Label(i.getName());
            vBox = new VBox();
            vBox.getChildren().add(view);
            vBox.getChildren().add(lbl);
            tilepane.getChildren().add(vBox);
            vBox.setOnMousePressed(event -> {

                 if(i.getSignin() == null){
                    i.setSignin(date);
                    System.out.println(" first if statmenet ");
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
                     alert.setTitle("Alert");
                     alert.setHeaderText(null);
                     alert.setContentText("Login success ");
                     alert.showAndWait();

                   } else if( i.getSignin().compareTo(date) == 0 ){

                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Alert");
                     alert.setHeaderText(null);
                     alert.setContentText("you already login today  ");
                     if(alert.showAndWait().get() == ButtonType.OK){
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
                     }

                }

            });

        }

    }

}







