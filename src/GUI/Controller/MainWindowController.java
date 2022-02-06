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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
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
     private ImageView view ;
    @FXML
    private  Image image2 ;
    @FXML
    private  List<String> num = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        intro();
        timer();

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
    public void timer(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
              num.clear();
              changeMainView();
                System.out.println("the list is cleared ");

            }
        };

            timer.scheduleAtFixedRate(task, 0, 5000);

    }

    private void changeMainView() {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                mainancorpane.getChildren().remove(view);
            }
        });
    }

    public void key(KeyEvent e) {
            num.add(e.getCode().toString().toLowerCase());
          String str = String.join("",num);
          System.out.println(str);

          if(str.equals("omori")) {
              System.out.println("its working ");
              image2 = new Image("/tools/mari.gif");
              view = new ImageView(image2);
              mainancorpane.getChildren().add(view);
              view.setLayoutX(200);
              view.setLayoutY(100);
              /*
              TranslateTransition t = new TranslateTransition();
              t.setNode(view);
              t.setDuration(Duration.millis(2000));
              t.setByX(905);
              t.play();
               */
              playmidea();

              num.clear();
          }
    }
    public void playmidea(){
        String path = "C:\\Users\\sam kaxe\\Documents\\GitHub\\LoginToEasv\\src\\tools\\sounds\\something.wav";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

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
       // Stage stage = new Stage();
       // stage.setTitle("sign");
      //  stage.setScene(new Scene(root));
       // stage.show();
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


    /*
     @FXML
    private void handleNewSongbtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/gui/view/AddEditSongView.fxml"));
        Parent root = loader.load();
      //  but.setGraphic(new ImageView("images/icon.png"));
        but.setStyle("-fx-background-color: #26ff00; ");
        Scene scene = but.getScene();
        root.translateYProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        ((AddEditSongViewController)loader.getController()).setSongModel(songModel);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(mainorderPain);
        });
        timeline.play();
     */
        // easter
    /*
    public void key(KeyEvent keyEvent) {
        ArrayList<KeyCode> cat = new ArrayList<>();
        cat.add(keyEvent.getCode());
        /*
        for(KeyCode d : cat){
            System.out.println(d);
        }

         */
        /*
        if(keyEvent.getCode() == KeyCode.A){
            cat.add(KeyCode.A);
            System.out.println(cat);

        }

         */
        // we could set new stage called tirminal with one text field in it and enter option



    public void exit(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }



}
