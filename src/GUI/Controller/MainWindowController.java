package GUI.Controller;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindowController {

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

    public void log(ActionEvent actionEvent) throws IOException {
        FXMLLoader kel = new FXMLLoader(getClass().getResource("/GUI/View/login.fxml"));
        Parent root = kel.load();
        Scene scene = logfxid.getScene();
        root.translateYProperty().set(scene.getHeight());
        stackpane.getChildren().add(root);
        // stackpane.getChildren().remove(mainancorpane);
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
       // Stage stage = new Stage();
       // stage.setTitle("sign");
      //  stage.setScene(new Scene(root));
       // stage.show();
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

    }
}
