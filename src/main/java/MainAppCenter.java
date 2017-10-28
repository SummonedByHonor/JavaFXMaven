import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainAppCenter extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("/fxml/BackgroundPaneFXML.fxml"));


        StackPane stackPane = fxmlLoader.load();

        Scene scene =  new Scene(stackPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Window Application");
        primaryStage.show();


    }
}
