package GUI.Controller;

import BE.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassController implements Initializable {
    @FXML
    private TilePane tilepane;
    @FXML
    private ImageView view ;
    @FXML
    private VBox vBox;
    @FXML
    private Label label ;
    @FXML
    private LoginwithpicsController mainCtrl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Department department1 = new Department(1,"IT organization");
        Department department2 = new Department(2,"Software Construction");
        Department department3 = new Department(3,"database system operations");
        Department department4 = new Department(4,"software design");

        ObservableList<Department> departments = FXCollections.observableArrayList();
        departments.addAll(department1,department2,department3,department4);

        for(Department d : departments){
         view = new ImageView("tools/userpicture.png");
             label = new Label(d.getName());
             String Class = d.getName();
            vBox = new VBox();
            vBox.getChildren().add(view);
            vBox.getChildren().add(label);
            tilepane.getChildren().add(vBox);
            vBox.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event){
                    ImageIcon icon = new ImageIcon("/tools/R.png");
                   JOptionPane.showOptionDialog(null,
                           "dear "+mainCtrl.selectedstudent +" please comfirm your login to " + Class, " Login ",
                           JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,icon,null,0) ;
                    System.out.println(mainCtrl.selectedstudent);

                    // here we set alert  or joption pane to confirm we set the date and the class :D
                    // i recomad  timer alert will colse after 2 second automatically :)
                }
            });
        }
    }

    public void setController(LoginwithpicsController controller) {
        this.mainCtrl = controller;
    }

}
