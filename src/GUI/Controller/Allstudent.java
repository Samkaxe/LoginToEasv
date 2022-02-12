package GUI.Controller;

import BE.Student;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Allstudent implements Initializable {
    @FXML
    public StackPane stackpane;
    @FXML
    public AnchorPane ancchorpane;
    @FXML
    public JFXTreeTableView tableview;
    @FXML
    public JFXButton backbut;
    @FXML
    public JFXCheckBox SCO;
    @FXML
    public ChoiceBox choicebox;

    private TreeTableColumn name = new TreeTableColumn("Name");
    @FXML
    private  TreeTableColumn cpr = new TreeTableColumn("cpr");
    @FXML
    private  TreeTableColumn email = new TreeTableColumn("email");
    @FXML
    private  TreeTableColumn tele = new TreeTableColumn("telephone");
    @FXML
    private TreeTableColumn atteneded = new TreeTableColumn("attend");
    @FXML
    private  TreeTableColumn Course = new TreeTableColumn("Course");
    @FXML
    private  TreeTableColumn score = new TreeTableColumn("total");

    private ObservableList s ;
    private ObservableList listofStudents ;

    private String d = "Today" ;
    private String w = "Last week" ;
    private String m = "Last month" ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Displaystudent();
        choice();

    }

    public void choice(){
        s = FXCollections.observableArrayList();
       s.addAll(d,w,m);
        choicebox.setItems(s);
        choicebox.setOnAction(this :: choosedate);
    }

    private void choosedate(Event event) {
        /*
       Date d = new Date();
       SimpleDateFormat das = new SimpleDateFormat("hh:mm:ss");
        System.out.println(das.format(d));
        SimpleDateFormat dasS = new SimpleDateFormat("DD:MM:YYYY");
         System.out.println(dasS.format(d));
         */

        if(choicebox.getSelectionModel().getSelectedItem() == d){
            // if the student.getdate after the currunt date will add 1 meaning he show up
            // if its after meaning he came late or how didnot show at all
        atteneded.setCellValueFactory(new TreeItemPropertyValueFactory<Student,Integer>("totalscore"));
        tableview.refresh();
      }else if (choicebox.getSelectionModel().getSelectedItem() == m){
            atteneded.setCellValueFactory(new TreeItemPropertyValueFactory<Student,Integer>("scoalt"));
            tableview.refresh();
      }else if (choicebox.getSelectionModel().getSelectedItem() == w){
            atteneded.setCellValueFactory(new TreeItemPropertyValueFactory<Student,Integer>("sdealt"));
            tableview.refresh();

      }
    }

    public void Displaystudent() {
         name = new TreeTableColumn("Name");
         cpr = new TreeTableColumn("cpr");
         email = new TreeTableColumn("email");
         tele = new TreeTableColumn("telephone");
         atteneded = new TreeTableColumn("attend");
         Course = new TreeTableColumn("Course");
         score = new TreeTableColumn("total");
        name.setCellValueFactory(new TreeItemPropertyValueFactory<Student,String>("name"));
        cpr.setCellValueFactory(new TreeItemPropertyValueFactory<Student,Integer>("cpr"));
        email.setCellValueFactory(new TreeItemPropertyValueFactory<Student,String>("email"));
        tele.setCellValueFactory(new TreeItemPropertyValueFactory<Student,Integer>("telephone"));
        atteneded.setCellValueFactory(new TreeItemPropertyValueFactory<Student,Integer>("totalscore"));
        java.util.Date Ust = new Date();
        java.sql.Date date = new java.sql.Date(Ust.getTime());
        Image image1 = new Image("/tools/image/studnets/1.jpg");
        Student student1 = new Student(1,"imad","conteb@live.com",158692,19253881 ,image1,date,"sdasdd",15,5,4,0);
        Student student2 = new Student(2,"john","srour@yahoo.com",154726,19285425 ,image1,date,"sdasdd",13,4,2,1);
        Student student3 = new Student(3 ,"darwin","helger@icloud.com",245842,17914099  ,image1,date,"sdasdd",23,0,3,1);
        Student student4 = new Student(4,"miami","scarlet@live.com",694252,61589431  ,image1,date,"sdasdd",22,0,2,1);
        Student student5 = new Student(5,"sarah","hyper@live.com",254861,18497631 ,image1,date,"sdasdd",12,0,0,1);
        Student student6 = new Student(6,"Dan","yzheng@optonline.net",287465,91549940 ,image1,date,"sdasdd",10,10,5,0);
        listofStudents = FXCollections.observableArrayList();
        listofStudents.addAll(student1,student2,student3,student4,student5,student6);
        tableview.getColumns().addAll(atteneded,name,cpr,email);
        TreeItem<Student> root = new RecursiveTreeItem<>(listofStudents, RecursiveTreeObject :: getChildren);
        tableview.setRoot(root);
        tableview.setShowRoot(false);

    }

    public void checkSco(ActionEvent actionEvent) {
        atteneded.setCellValueFactory(new TreeItemPropertyValueFactory<Student,Integer>("scoalt"));
        // tell the world that i spend two hours updating the model , the list , adding rerfresh methods , boolean
        // check google , stackoverflow and at the end ,this small line of code did the job without crash , excepion , error's
        // this is me in melt down mode telling java THANKS , THANKS ALOT  :)
        tableview.refresh();
    }

    public void checkITO(ActionEvent actionEvent) {
        atteneded.setCellValueFactory(new TreeItemPropertyValueFactory<Student,Integer>("itoalt"));
        tableview.refresh();
    }
    public void checkSDE(ActionEvent actionEvent) {
        atteneded.setCellValueFactory(new TreeItemPropertyValueFactory<Student,Integer>("sdealt"));
        tableview.refresh();
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader omori = new FXMLLoader(getClass().getResource("/GUI/View/MainWindow.fxml"));
        Parent root = omori.load();
        Scene scene = backbut.getScene();
        root.translateXProperty().set(scene.getWidth());
        stackpane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackpane.getChildren().remove(ancchorpane);
        });
        timeline.play();
    }

}
