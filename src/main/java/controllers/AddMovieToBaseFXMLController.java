package controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import model.Movie;
import presenter.MoviePresenter;
import sun.rmi.log.LogInputStream;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;


public class AddMovieToBaseFXMLController {

    List<Movie> listOfMovies = new ArrayList<>();
    BackgroundPaneController backgroundPaneController;
    MoviePresenter moviePresenter = new MoviePresenter(this);
    Movie movieBegin;
    ObservableList<Movie> observableMoviesList;

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
    private TableView<Movie> moviesTableFX;

    @FXML
    private TableColumn<Movie, String> titleColumn;

    @FXML
    private TableColumn<Movie, LocalDate> yearColumn;

    @FXML
    public void initialize() {
        movieBegin = new Movie();
        moviePresenter.getMovieListFromDatase();
        observableMoviesList = FXCollections.observableArrayList(listOfMovies);
        moviesTableFX.setItems(observableMoviesList);
        titleColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTitle()));
        yearColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getYear()));

    }

    private void updateMovieTable() {
        moviesTableFX.getItems().clear();
        moviesTableFX.setItems(observableMoviesList);

    }

    public void updateMovies(List<Movie> list) {
        listOfMovies.clear();
        listOfMovies.addAll(list);
        observableMoviesList = FXCollections.observableArrayList(listOfMovies);
        updateMovieTable();


    }

    public void addMovieToDatabase(ActionEvent actionEvent) {
        Movie movie = new Movie();
        movie.setTitle(titleTextField.getText());
        movie.setDirector(directorTextField.getText());
        movie.setYear(productionDate.getValue());
        movie.setDuration(Integer.valueOf(durationTextField.getText()));

        moviePresenter.addMovieToDatabase(movie);
        moviePresenter.getMovieListFromDatase();
    }

    public void removeMovieFromDatabase(ActionEvent actionEvent) {
    }

    public void returnToMainMenu(ActionEvent actionEvent) {
        backgroundPaneController.setMainWindow();

    }

    public void setBackgroundPaneController(BackgroundPaneController backgroundPaneController) {
        this.backgroundPaneController = backgroundPaneController;
    }
}
