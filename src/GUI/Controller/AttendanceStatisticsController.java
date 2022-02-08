package GUI.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

public class AttendanceStatisticsController {
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();
    @FXML
    private void initialize() {
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





}
