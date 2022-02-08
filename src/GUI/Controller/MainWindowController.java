package GUI.Controller;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MainWindowController implements Initializable {

    @FXML
    public ImageView image;
    @FXML
    public Button signfxid;
    @FXML
    public StackPane stackpane;
    @FXML
    public AnchorPane mainancorpane;
    @FXML
    public Button logfxid;
    @FXML
    public Label welcomelbl;
    @FXML
    public Button tilebtn;
    @FXML
    public Button close;
     @FXML
    public Button openthiswindow;

    private  List<String> num = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        intro();

    }

    public void intro() {
        Thread newThread = new Thread(() -> {
            String intro = " welcome to Easv  ";
            String totalSentence = "";
            char[] num = intro.toCharArray();
            for (char c : num) {
                totalSentence = totalSentence + "" + c;
                updateText(totalSentence);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        newThread.start();

    }
    public void updateText(String c) {
        Platform.runLater(() -> {
            welcomelbl.setText("" + c);
        });
    }


    public void log(ActionEvent actionEvent) throws IOException {
        FXMLLoader kel = new FXMLLoader(getClass().getResource("/GUI/View/login.fxml"));
        Parent root = kel.load();
        Scene scene = logfxid.getScene();
        root.translateYProperty().set(scene.getHeight());
        stackpane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackpane.getChildren().remove(mainancorpane);
        });
        timeline.play();
    }

    public void sign(ActionEvent actionEvent) throws IOException {
        FXMLLoader kel = new FXMLLoader(getClass().getResource("/GUI/View/sign.fxml"));
        Parent root = kel.load();
        Scene scene = signfxid.getScene();
        root.translateXProperty().set(scene.getWidth());
        stackpane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackpane.getChildren().remove(mainancorpane);
        });
        timeline.play();
    }

    public void opentilepane(ActionEvent actionEvent) throws IOException {
        FXMLLoader omori = new FXMLLoader(getClass().getResource("/GUI/View/loginwithpics.fxml"));
        Parent root = omori.load();
        Scene scene = tilebtn.getScene();
        root.translateXProperty().set(scene.getWidth());
        stackpane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackpane.getChildren().remove(mainancorpane);
        });
        timeline.play();
    }
    public void exit(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }


    public void showAttendanceStatistics(ActionEvent actionEvent) throws IOException {
        FXMLLoader omori = new FXMLLoader(getClass().getResource("/GUI/View/AttendanceStatistics.fxml"));
        Parent root = omori.load();
        Scene scene = tilebtn.getScene();
        root.translateXProperty().set(scene.getWidth());
        stackpane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackpane.getChildren().remove(mainancorpane);
        });
        timeline.play();
    }
    }

