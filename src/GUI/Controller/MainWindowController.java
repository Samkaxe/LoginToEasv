package GUI.Controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Tooltip;
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
    public Label welcomelbl;
    @FXML
    public Button tilebtn;
    @FXML
    public Button close;
     @FXML
    public JFXButton totalattendence;

    private final List<String> num = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        intro();
        information();

    }
    public void information(){
        close.setTooltip(new Tooltip("Close this window"));
        tilebtn.setTooltip(new Tooltip("Quick login to the class"));
        signfxid.setTooltip(new Tooltip("create your own profile in Easv"));
        totalattendence.setTooltip(new Tooltip("show student statics \n charts and inforamtion"));
    }

    public void showattendeme(ActionEvent actionEvent) throws IOException {
        FXMLLoader kel = new FXMLLoader(getClass().getResource("/GUI/View/allstudent.fxml"));
        Parent root = kel.load();
        Scene scene = totalattendence.getScene();
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

    public void intro() {
        Thread newThread = new Thread(() -> {
            String intro = " welcome to Easv  ";
            String totalSentence = "";
            char[] num = intro.toCharArray();
            for (char c : num) {
                totalSentence = totalSentence + "" + c;
                updateText(totalSentence);
                try {
                    Thread.sleep(500);
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


    public void danish(ActionEvent actionEvent) {
        close.setText("lukke");
        tilebtn.setText("kvik Signin");
        signfxid.setText("oprette nye profil");
        totalattendence.setText("vise statistik");
        welcomelbl.setText("velkommen til Easv");
    }

    public void english(ActionEvent actionEvent) {
        close.setText("Close");
        tilebtn.setText("Quick login");
        signfxid.setText("Create Profile");
        totalattendence.setText("show attendance");
        welcomelbl.setText("Welcome to Easv");
    }
}

// ᚱᛖᛗᛟvᛁᚾᚷ Hᛁᛞᛞᛖᚾ Eᚨᛊᛏᛖᚱ ,
// ᚾᛟᛏᛖ : Dᛟᚾᛏ ᛞᛖᛚᛖᛏᛖ ᛏᚺᛁᛊ Cᛟᚾᛏᛖᚾᛏ


