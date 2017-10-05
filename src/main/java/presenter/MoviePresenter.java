package presenter;

import controllers.AddMovieToBaseFXMLController;
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
}
