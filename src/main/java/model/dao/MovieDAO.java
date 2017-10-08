package model.dao;


import model.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class MovieDAO {
    public Integer addMovie(Movie movie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer movieID = null;
        try {
            tx = session.beginTransaction();
            movieID = (Integer) session.save(movie);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return movieID;
    }


    public void deleteMove(Movie movie) {
        if (movie.getMovie_id() == 0) {
            return;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer movieID = null;
        try {
            tx = session.beginTransaction();
            session.delete(movie);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public String getMovieTitle(Integer movieId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Movie movie = null;
        try {
            tx = session.beginTransaction();
            movie = session.get(Movie.class, movieId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        String movieTitle = movie.getTitle();
        return movieTitle;
    }

    public List<Movie> getMovieList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Movie> movies = null;
        try {
            tx = session.beginTransaction();
            movies = session.createQuery("FROM Movie").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return movies;
    }


}
