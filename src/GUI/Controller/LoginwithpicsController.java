package GUI.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginwithpicsController implements Initializable {
    @FXML
    private TilePane tilepane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> items = FXCollections.observableArrayList("mustafa", "zahra", "samkaxe", "diana", "java", "c#",
                "i", "hate", "java", "omori");

        for( int i = 0 ; i < items.size() ; i++) {
            Label lbl = new Label("yawn");
            ImageView view = new ImageView("tools/userpicture.png");
            VBox vBox = new VBox();
            vBox.getChildren().add(view);
            vBox.getChildren().add(lbl);
            tilepane.getChildren().add(vBox);
        }

        /*
        for(String i : items){
            Button btn = new Button(i);
            btn.setLayoutX(100);
            btn.setLayoutY(100);
            tilepane.getChildren().add(btn);
        }

         */
        /*
        for(int i = 0 ; i < 10 ; i++){
            Button btn = new Button("new button " + i);
            btn.setLayoutX(100*i);
            btn.setLayoutY(0);
            tilepane.getChildren().add(btn);
        }

         */
    }
}
