package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class BackgroundPaneController {

    @FXML
    private StackPane backgroundPane;

    @FXML
    public void initialize() {
        setMainWindow();
    }

    public void setMainWindow() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindowFXML.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainWindowFXMLController controller = loader.getController();
        controller.setBackgroundPaneController(this);

        setScreen(anchorPane);

    }

    public void setScreen(Pane pane) {
        backgroundPane.getChildren().clear();
        backgroundPane.getChildren().add(pane);
    }

}
