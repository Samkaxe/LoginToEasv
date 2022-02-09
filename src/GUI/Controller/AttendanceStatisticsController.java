package GUI.Controller;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

public class AttendanceStatisticsController {
    @FXML
    public ImageView imageview;
    @FXML
    public Label name;
    @FXML
    public Label cpr;
    @FXML
    public Label phone;
    @FXML
    public Label email;
    @FXML
    public Label adress;
    @FXML
    public StackPane tilepane;
    @FXML
    public AnchorPane ancorpane;
    @FXML
    public Button tilebtn;
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    public showstudentstatusController controller ;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();


    public void showstatic(ActionEvent actionEvent) {
        name.setText(controller.selectedstudent);
        cpr.setText(String.valueOf(controller.selectedcpr));
        phone.setText(String.valueOf(controller.selectedtelephone));
        email.setText(controller.selectedemail);
        adress.setText(controller.selectedadress);
        imageview.setImage(controller.selectediamge);
        charts();

    }

    public void charts(){
        // Get an array with the English month names.
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        int[] values= new int[]{1,2,4,5,6,7,8,9,1,4,3,6,7};
        // Convert it to a list and add it to our ObservableList of months.
        monthNames.addAll(Arrays.asList(months));
        // Assign the month names as categories for the horizontal axis.
        xAxis.setCategories(monthNames);
        yAxis.setLabel("Number of attendance");
        XYChart.Series<String, Integer> series1= new XYChart.Series<>();
        series1.setName("Attendance");
        for (int i = 0; i < months.length; i++) {
            series1.getData().add(new XYChart.Data<>(months[i],values[i] ));


        }
        barChart.getData().add(series1);
    }


    public void setController(showstudentstatusController controller) {
        this.controller = controller;

    }


    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader omori = new FXMLLoader(getClass().getResource("/GUI/View/checkstatus.fxml"));
        Parent root = omori.load();
        Scene scene = tilebtn.getScene();
        root.translateXProperty().set(scene.getWidth());
        tilepane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            tilepane.getChildren().remove(ancorpane);
        });
        timeline.play();
    }

    }

