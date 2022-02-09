import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/View/MainWindow.fxml"));
        Parent omori = loader.load();
        primaryStage.setScene(new Scene(omori));
      //  primaryStage.setResizable(false);
        primaryStage.setTitle("Easv");
        primaryStage.show();
        // testing github


    }
}
