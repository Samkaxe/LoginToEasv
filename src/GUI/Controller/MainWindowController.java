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
    // ᚱᛖᛗᛟvᛁᚾᚷ Hᛁᛞᛞᛖᚾ Eᚨᛊᛏᛖᚱ ,
    // ᚾᛟᛏᛖ : Dᛟᚾᛏ ᛞᛖᛚᛖᛏᛖ ᛏᚺᛁᛊ Cᛟᚾᛏᛖᚾᛏ
 /*
    ᛈᚢᛒᛚᛁc vᛟᛁᛞ ᛏᛁᛗᛖᚱ(){
        Tᛁᛗᛖᚱ ᛏᛁᛗᛖᚱ = ᚾᛖᚹ Tᛁᛗᛖᚱ();
        TᛁᛗᛖᚱTᚨᛊᚲ ᛏᚨᛊᚲ = ᚾᛖᚹ TᛁᛗᛖᚱTᚨᛊᚲ() {
            @Ovᛖᚱᚱᛁᛞᛖ
            ᛈᚢᛒᛚᛁc vᛟᛁᛞ ᚱᚢᚾ() {
              ᚾᚢᛗ.cᛚᛖᚨᚱ();
              cᚺᚨᚾᚷᛖMᚨᛁᚾVᛁᛖᚹ();
                Syᛊᛏᛖᛗ.ᛟᚢᛏ.ᛈᚱᛁᚾᛏᛚᚾ("ᛏᚺᛖ ᛚᛁᛊᛏ ᛁᛊ cᛚᛖᚨᚱᛖᛞ ");

            }
        };

            ᛏᛁᛗᛖᚱ.ᛊcᚺᛖᛞᚢᛚᛖAᛏFᛁxᛖᛞRᚨᛏᛖ(ᛏᚨᛊᚲ, 0, 5000);

    }

    ᛈᚱᛁvᚨᛏᛖ vᛟᛁᛞ cᚺᚨᚾᚷᛖMᚨᛁᚾVᛁᛖᚹ() {
        Pᛚᚨᛏᚠᛟᚱᛗ.ᚱᚢᚾLᚨᛏᛖᚱ(ᚾᛖᚹ Rᚢᚾᚾᚨᛒᛚᛖ(){
            @Ovᛖᚱᚱᛁᛞᛖ
            ᛈᚢᛒᛚᛁc vᛟᛁᛞ ᚱᚢᚾ() {
                ᛗᚨᛁᚾᚨᚾcᛟᚱᛈᚨᚾᛖ.ᚷᛖᛏCᚺᛁᛚᛞᚱᛖᚾ().ᚱᛖᛗᛟvᛖ(vᛁᛖᚹ);
            }
        });
    }

    ᛈᚢᛒᛚᛁc vᛟᛁᛞ ᚲᛖy(KᛖyEvᛖᚾᛏ ᛖ) {
            ᚾᚢᛗ.ᚨᛞᛞ(ᛖ.ᚷᛖᛏCᛟᛞᛖ().ᛏᛟSᛏᚱᛁᚾᚷ().ᛏᛟLᛟᚹᛖᚱCᚨᛊᛖ());
          Sᛏᚱᛁᚾᚷ ᛊᛏᚱ = Sᛏᚱᛁᚾᚷ.ᛃᛟᛁᚾ("",ᚾᚢᛗ);
          Syᛊᛏᛖᛗ.ᛟᚢᛏ.ᛈᚱᛁᚾᛏᛚᚾ(ᛊᛏᚱ);

          ᛁᚠ(ᛊᛏᚱ.ᛖqᚢᚨᛚᛊ("ᛟᛗᛟᚱᛁ")) {
              Syᛊᛏᛖᛗ.ᛟᚢᛏ.ᛈᚱᛁᚾᛏᛚᚾ("ᛁᛏᛊ ᚹᛟᚱᚲᛁᚾᚷ ");
              ᛁᛗᚨᚷᛖ2 = ᚾᛖᚹ Iᛗᚨᚷᛖ("/ᛏᛟᛟᛚᛊ/ᛗᚨᚱᛁ.ᚷᛁᚠ");
              vᛁᛖᚹ = ᚾᛖᚹ IᛗᚨᚷᛖVᛁᛖᚹ(ᛁᛗᚨᚷᛖ2);
              ᛗᚨᛁᚾᚨᚾcᛟᚱᛈᚨᚾᛖ.ᚷᛖᛏCᚺᛁᛚᛞᚱᛖᚾ().ᚨᛞᛞ(vᛁᛖᚹ);
              vᛁᛖᚹ.ᛊᛖᛏLᚨyᛟᚢᛏX(200);
              vᛁᛖᚹ.ᛊᛖᛏLᚨyᛟᚢᛏY(100);
              TᚱᚨᚾᛊᛚᚨᛏᛖTᚱᚨᚾᛊᛁᛏᛁᛟᚾ ᛏ = ᚾᛖᚹ TᚱᚨᚾᛊᛚᚨᛏᛖTᚱᚨᚾᛊᛁᛏᛁᛟᚾ();
              ᛏ.ᛊᛖᛏNᛟᛞᛖ(vᛁᛖᚹ);
              ᛏ.ᛊᛖᛏDᚢᚱᚨᛏᛁᛟᚾ(Dᚢᚱᚨᛏᛁᛟᚾ.ᛗᛁᛚᛚᛁᛊ(2000));
              ᛏ.ᛊᛖᛏByX(905);
              ᛏ.ᛈᛚᚨy();
              ᛈᛚᚨyᛗᛁᛞᛖᚨ();

              ᚾᚢᛗ.cᛚᛖᚨᚱ();
          }
    }
    ᛈᚢᛒᛚᛁc vᛟᛁᛞ ᛈᛚᚨyᛗᛁᛞᛖᚨ(){
        Sᛏᚱᛁᚾᚷ ᛈᚨᛏᚺ = "C:\\Uᛊᛖᚱᛊ\\ᛊᚨᛗ ᚲᚨxᛖ\\Dᛟcᚢᛗᛖᚾᛏᛊ\\GᛁᛏHᚢᛒ\\LᛟᚷᛁᚾTᛟEᚨᛊv\\ᛊᚱc\\ᛏᛟᛟᛚᛊ\\ᛊᛟᚢᚾᛞᛊ\\ᛊᛟᛗᛖᛏᚺᛁᚾᚷ.ᚹᚨv";
        Mᛖᛞᛁᚨ ᛗᛖᛞᛁᚨ = ᚾᛖᚹ Mᛖᛞᛁᚨ(ᚾᛖᚹ Fᛁᛚᛖ(ᛈᚨᛏᚺ).ᛏᛟURI().ᛏᛟSᛏᚱᛁᚾᚷ());
        MᛖᛞᛁᚨPᛚᚨyᛖᚱ ᛗᛖᛞᛁᚨPᛚᚨyᛖᚱ = ᚾᛖᚹ MᛖᛞᛁᚨPᛚᚨyᛖᚱ(ᛗᛖᛞᛁᚨ);
        ᛗᛖᛞᛁᚨPᛚᚨyᛖᚱ.ᛈᛚᚨy();

    }

         */


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

