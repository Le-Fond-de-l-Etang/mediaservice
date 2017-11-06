package database.dao;

import beans.MovieEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import database.utils.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class MovieDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Get a movie from its id
     *
     * @param id the id of the wanted movie
     * @return a movie with the given id if there is one
     */
    public Optional<MovieEntity> getMovie(int id) {
        try {
            MovieEntity movie = session.get(MovieEntity.class, id);
            return Optional.ofNullable(movie);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    /**
     * Add a movie
     *
     * @param movie the movie
     * @return the id of the added movie if the ismn exists
     */
    public Optional<Integer> addMovie(MovieEntity movie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(movie);
        session.getTransaction().commit();
        return Optional.ofNullable(movie.getId());
    }

    /**
     * Update a movie
     * @param movie the movie
     */
    public void updateMovie(MovieEntity movie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(movie);
        session.getTransaction().commit();
    }

    /**
     * Get all movies of the library
     *
     * @return the movies
     */
    public List<MovieEntity> getMovies() {
        Criteria criteria = session.createCriteria(MovieEntity.class);
        List<MovieEntity> movieList = (List<MovieEntity>) criteria.list();
        return movieList;
    }

    /**
     * Return all movies with an author, a title or an ISMN matching the search term
     *
     * @param searchTerm the searched term
     * @return the movies matching the search term
     */
    public List<MovieEntity> searchMovies(String searchTerm) {
        List movies = session.createCriteria(MovieEntity.class).add(Restrictions.or(
                Restrictions.like("director", "%"+searchTerm+"%"),
                Restrictions.like("title", "%"+searchTerm+"%")
                )).list();
        return movies;
    }
}
