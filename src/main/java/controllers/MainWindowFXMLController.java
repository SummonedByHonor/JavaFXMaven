package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainWindowFXMLController {
    BackgroundPaneController backgroundPaneController;

//    @FXML
//    AnchorPane anchorPane;

    public void exitProgram(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void enterShowScheduleWindow(ActionEvent actionEvent) {
    }

    public void enterShowMovieInfoWindow(ActionEvent actionEvent) {
    }

    @FXML
    public void enterAddMovieWindow(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddMovieToBaseFXML.fxml"));
        AnchorPane addMovieAnchorPane = null;
        try {
            addMovieAnchorPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        backgroundPaneController.setScreen(addMovieAnchorPane);

    }

    public void setBackgroundPaneController(BackgroundPaneController backgroundPaneController) {
        this.backgroundPaneController = backgroundPaneController;
    }
}
