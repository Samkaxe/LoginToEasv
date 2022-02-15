package GUI.Controller;

import BE.Student;
import GUI.Model.ManagerModel;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Allstudent implements Initializable {
    @FXML
    public StackPane stackpane;
    @FXML
    public AnchorPane ancchorpane;
    @FXML
    public JFXButton backbut;
    @FXML
    public JFXCheckBox SCO;
    @FXML
    public ChoiceBox choicebox;
    @FXML
    public ImageView imageview;
    @FXML
    public Label name;
    @FXML
    public TableView<Student> tbleview;
    @FXML
    public TableColumn<Student, Integer> id;
    @FXML
    public TableColumn<Student, String> namee;
    @FXML
    public TableColumn<Student, Integer> atteneded;
    @FXML
    public TableColumn<Student, String> address;
    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    private ObservableList s ;
    private ManagerModel model = new ManagerModel();
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

        if(choicebox.getSelectionModel().getSelectedItem() == d){

            // if the student.getdate after the currunt date will add 1 meaning he show up
            // if its after meaning he came late or how didnot show at all
            atteneded.setCellValueFactory(new PropertyValueFactory<>("totalscore"));
            tbleview.refresh();
      }else if (choicebox.getSelectionModel().getSelectedItem() == m){
            atteneded.setCellValueFactory(new PropertyValueFactory<>("scoalt"));
            tbleview.refresh();
      }else if (choicebox.getSelectionModel().getSelectedItem() == w){
            atteneded.setCellValueFactory(new PropertyValueFactory<>("itoalt"));
            tbleview.refresh();

      }


    }

    public void Displaystudent() {

       tbleview.setItems(model.getStudnets());
        //    public Student(int id, String name, String email, int telephone, int cpr, Image image,Date signin, String address,int scoalt, int itoalt,int sdealt,int totalscore) {

        id.setCellValueFactory(new PropertyValueFactory<>("cpr"));
        namee.setCellValueFactory(new PropertyValueFactory<>("name"));
        atteneded.setCellValueFactory(new PropertyValueFactory<>("totalscore"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
    }
    public void chart(){
        Axis<String> axis = barChart.getXAxis();
        axis.setLabel("course");
        ArrayList<String> classes = new ArrayList<>();
        classes.add("ITO" );
        classes.add("SCO" );
        classes.add("SDE" );
        classes.add("DBOS" );
        ObservableList<String> s = FXCollections.observableArrayList();
        s.addAll(classes);
        xAxis.setCategories(s);
        Axis<Integer> yaxis = barChart.getYAxis();
        yaxis.setLabel("attendence");
        XYChart.Series<String ,Integer> series = new XYChart.Series<>();
        series.setName("attend to the course");
        Random r = new Random();
        series.getData().add(new XYChart.Data<>("ITO",r.nextInt(1,365)));
        series.getData().add(new XYChart.Data<>("SCO",r.nextInt(1,365)));
        series.getData().add(new XYChart.Data<>("SDE",r.nextInt(1,365)));
        series.getData().add(new XYChart.Data<>("DBOS",r.nextInt(1,365)));
        barChart.getData().add(series);


    }

    public void checkSco(ActionEvent actionEvent) {
        atteneded.setCellValueFactory(new PropertyValueFactory<>("scoalt"));
        // tell the world that i spend two hours updating the model , the list , adding rerfresh methods , boolean
        // check google , stackoverflow and at the end ,this small line of code did the job without crash , excepion , error's
        // this is me in melt down mode telling java THANKS , THANKS ALOT  :)
        tbleview.refresh();
    }

    public void checkITO(ActionEvent actionEvent) {
        atteneded.setCellValueFactory(new PropertyValueFactory<>("itoalt"));
        tbleview.refresh();
    }
    public void checkSDE(ActionEvent actionEvent) {
        atteneded.setCellValueFactory(new PropertyValueFactory<>("sdealt"));
        tbleview.refresh();
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

    public void fs(MouseEvent mouseEvent) {
       if(tbleview.getSelectionModel().getSelectedIndex() != -1) {
           barChart.getData().clear();
           name.setText(tbleview.getSelectionModel().getSelectedItem().getName());
           imageview.setImage(tbleview.getSelectionModel().getSelectedItem().getImage());
           chart();
       }

    }
}
