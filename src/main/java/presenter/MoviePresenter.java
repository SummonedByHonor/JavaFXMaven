package presenter;

import controllers.AddMovieToBaseFXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Movie;
import model.dao.MovieDAO;

public class MoviePresenter {
MovieDAO movieDAO = new MovieDAO();
AddMovieToBaseFXMLController addMovieToBaseFXMLController;

    public MoviePresenter(AddMovieToBaseFXMLController addMovieToBaseFXMLController) {
        this.addMovieToBaseFXMLController = addMovieToBaseFXMLController;
    }

    public void addMovieToDatabase(Movie movie){
        movieDAO.addMovie(movie);
    }

    public void getMovieListFromDatase(){
        addMovieToBaseFXMLController.updateMovies(movieDAO.getMovieList());
    }

    public String getMovieTitleFromDatabase(Movie movie){
        Integer gottenMovieId = movie.getMovie_id();
        String gottenMovieTitle = movieDAO.getMovieTitle(gottenMovieId);
        return gottenMovieTitle;
    }

    public void removeMovieFromDatabase(Movie movie, int index){
        movieDAO.deleteMove(movie, index);
    }
}
