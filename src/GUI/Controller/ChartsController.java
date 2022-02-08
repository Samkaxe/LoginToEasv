package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;

import java.util.Random;

public class ChartsController {
    @FXML
    public ScatterChart<String , Number> mychart;
    // change the line chart to area chart to stacked areachart and updated it in the Fxml file
    /*
     @FXML
    public LineChart<Number , Number> mychart;
     */
    @FXML
    public Button drewchart;

    public void drewchart(ActionEvent actionEvent) {
        Axis<String> xs = mychart.getXAxis();
        xs.setLabel("month");

        Axis<Number> yy = mychart.getYAxis();
        yy.setLabel("sold");

        XYChart.Series<String, Number> sires = new  XYChart.Series<String ,Number>();
        sires.setName("linechart");

        Random r = new Random();
        //Random rs = new Random();
        sires.getData().add(new XYChart.Data<>("monday" ,r.nextInt(1,100)));
        sires.getData().add(new XYChart.Data<>("tuesday" ,r.nextInt(1,75)));
        sires.getData().add(new XYChart.Data<>("wedenday" ,r.nextInt(1,50)));
        sires.getData().add(new XYChart.Data<>("thursday" ,r.nextInt(1,50)));
        sires.getData().add(new XYChart.Data<>("friday" ,r.nextInt(1,50)));
        /*
        sires.getData().add(new XYChart.Data<>(rs.nextInt("meaw",r.nextInt(1,200));
        sires.getData().add(new XYChart.Data<>(rs.nextInt("bro", r.nextInt(1,300));
        sires.getData().add(new XYChart.Data<>(rs.nextInt("fdsf",r.nextInt(1,500));

         */
        mychart.getData().add(sires);

    }
}
