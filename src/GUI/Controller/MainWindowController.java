package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindowController {

    @FXML
    public ImageView image;
    @FXML
    public Button login;
    @FXML
    public Button signin;

    public void log(ActionEvent actionEvent) throws IOException {
        FXMLLoader hero = new FXMLLoader(getClass().getResource("/GUI/View/login.fxml"));
        Parent root = hero.load();
        Stage stage = new Stage();
        stage.setTitle("login");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void sign(ActionEvent actionEvent) throws IOException {
        FXMLLoader kel = new FXMLLoader(getClass().getResource("/GUI/View/sign.fxml"));
        Parent root = kel.load();
        Stage stage = new Stage();
        stage.setTitle("sign");
        stage.setScene(new Scene(root));
        stage.show();
    }

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

    }
}
