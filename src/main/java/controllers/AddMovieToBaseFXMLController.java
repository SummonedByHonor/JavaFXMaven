package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Movie;
import presenter.MoviePresenter;


public class AddMovieToBaseFXMLController {

    MoviePresenter moviePresenter = new MoviePresenter(this);

    @FXML
    TextField titleTextField;

    @FXML
    TextField directorTextField;

    @FXML
    DatePicker productionDate;

    @FXML
    TextField durationTextField;

    @FXML
    private Button addMovieButton;

    @FXML
    private Button deleteMovieButton;

    @FXML
    private Button returnButton;

    @FXML
    public void initialize() {


    }

    public void addMovieToDatabase(ActionEvent actionEvent) {
        Movie movie = new Movie();
        movie.setTitle(titleTextField.getText());
        movie.setDirector(directorTextField.getText());
        movie.setYear(productionDate.getValue());
        movie.setDuration(Integer.valueOf(durationTextField.getText()));

        moviePresenter.addMovieToDatabase(movie);
    }

    public void removeMovieFromDatabase(ActionEvent actionEvent) {
    }

    public void returnToMainMenu(ActionEvent actionEvent) {

    }
}
