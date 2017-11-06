package action;

import beans.MovieEntity;
import dao.MovieDAO;
import exceptions.MediaAlreadyReturnedException;
import exceptions.MediaNotFoundException;
import exceptions.UnavailableMediaException;

import java.util.List;
import java.util.Optional;

public class MovieAction {
    MovieDAO movieDAO = new MovieDAO();

    /**
     * Get a movie from its id
     *
     * @param id the id of the wanted movie
     * @return a music with the given id if there is one
     */
    public Optional<MovieEntity> getMovie(int id) {
        return movieDAO.getMovie(id);
    }

    /**
     * Add a movie
     *
     * @param movie the movie
     * @return the id of the added movie if success
     */
    public Optional<Integer> addMovie(MovieEntity movie) {
        return movieDAO.addMovie(movie);
    }

    /**
     * Borrow a movie from the library
     *
     * @param id the id of the borrowed movie
     * @param username the name of the user
     * @throws MediaNotFoundException if no movie in the library has the given id
     * @throws UnavailableMediaException if all movies in the library with the given id have been borrowed
     */
    public void borrowMovie(int id, String username) throws MediaNotFoundException, UnavailableMediaException {
        Optional<MovieEntity> optionalMovie = movieDAO.getMovie(id);
        if (!optionalMovie.isPresent()) {
            throw new MediaNotFoundException("MovieEntity " + id + " not found.");
        }
        MovieEntity movie = optionalMovie.get();
        if (movie.isBorrowed()) {
            throw new UnavailableMediaException("MovieEntity " + id + " already borrowed.");
        }
        movie.setBorrowed(true);
        movie.setBorrower(username);
        movieDAO.updateMovie(movie);
    }

    /**
     * Return a music back to the library
     *
     * @param id the id of the movie to borrow
     * @param username the name of the user
     * @throws MediaNotFoundException if no movie in the library has the given id
     * @throws MediaAlreadyReturnedException if all movies with the given id are already returned
     */
    public void returnMovie(int id, String username) throws MediaNotFoundException, MediaAlreadyReturnedException {
        Optional<MovieEntity> optionalMovie = movieDAO.getMovie(id);
        if (!optionalMovie.isPresent()) {
            throw new MediaNotFoundException("MovieEntity " + id + " not found.");
        }
        MovieEntity movie = optionalMovie.get();
        if (!movie.isBorrowed() || !movie.getBorrower().equals(username)) {
            throw new MediaAlreadyReturnedException("MovieEntity " + id + " not borrowed by " + username + ".");
        }
        movie.setBorrowed(false);
        movieDAO.updateMovie(movie);
    }

    /**
     * Get all movies of the library
     *
     * @return the musics
     */
    public List<MovieEntity> getMovies() {
        return movieDAO.getMovies();
    }

    /**
     * Return all movies with an director, producer or title matching the search term
     *
     * @param searchTerm the searched term
     * @return the movies matching the search term
     */
    public List<MovieEntity> searchMovies(String searchTerm) {
        return movieDAO.searchMovies(searchTerm);
    }
}
