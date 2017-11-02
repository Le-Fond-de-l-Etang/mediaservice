package action;

import beans.TVShow;
import dao.TVShowDAO;
import exceptions.MediaAlreadyReturnedException;
import exceptions.MediaNotFoundException;
import exceptions.UnavailableMediaException;

import java.util.List;
import java.util.Optional;

public class TVShowAction {
    TVShowDAO tvshowDAO = new TVShowDAO();

    /**
     * Get a tvshow from its id
     *
     * @param id the id of the wanted tvshow
     * @return a music with the given id if there is one
     */
    Optional<TVShow> getTVShow(String id) {
        return tvshowDAO.getTVShow(id);
    }

    /**
     * Add a tvshow
     *
     * @param tvshow the tvshow
     * @return the id of the added tvshow if success
     */
    Optional<Integer> addTVShow(TVShow tvshow) {
        return tvshowDAO.addTVShow(tvshow);
    }

    /**
     * Borrow a tvshow from the library
     *
     * @param id the id of the borrowed tvshow
     * @param username the name of the user
     * @throws MediaNotFoundException if no tvshow in the library has the given id
     * @throws UnavailableMediaException if all tvshows in the library with the given id have been borrowed
     */
    void borrowTVShow(String id, String username) throws MediaNotFoundException, UnavailableMediaException {
        Optional<TVShow> optionalTVShow = tvshowDAO.getTVShow(id);
        if (!optionalTVShow.isPresent()) {
            throw new MediaNotFoundException("TVShow " + id + " not found.");
        }
        TVShow tvshow = optionalTVShow.get();
        if (tvshow.isBorrowed()) {
            throw new UnavailableMediaException("TVShow " + id + " already borrowed.");
        }
        tvshow.setBorrowed(true);
        tvshow.setBorrower(username);
        tvshowDAO.updateTVShow(tvshow);
    }

    /**
     * Return a music back to the library
     *
     * @param id the id of the tvshow to borrow
     * @param username the name of the user
     * @throws MediaNotFoundException if no tvshow in the library has the given id
     * @throws MediaAlreadyReturnedException if all tvshows with the given id are already returned
     */
    void returnTVShow(String id, String username) throws MediaNotFoundException, MediaAlreadyReturnedException {
        Optional<TVShow> optionalTVShow = tvshowDAO.getTVShow(id);
        if (!optionalTVShow.isPresent()) {
            throw new MediaNotFoundException("TVShow " + id + " not found.");
        }
        TVShow tvshow = optionalTVShow.get();
        if (!tvshow.isBorrowed() || !tvshow.getBorrower().equals(username)) {
            throw new MediaAlreadyReturnedException("TVShow " + id + " not borrowed by " + username + ".");
        }
        tvshow.setBorrowed(false);
        tvshowDAO.updateTVShow(tvshow);
    }

    /**
     * Get all tvshows of the library
     *
     * @return the musics
     */
    List<TVShow> getTVShows() {
        return tvshowDAO.getTVShows();
    }

    /**
     * Return all tvshows with an director, producer or title matching the search term
     *
     * @param searchTerm the searched term
     * @return the tvshows matching the search term
     */
    List<TVShow> searchTVShows(String searchTerm) {
        return tvshowDAO.searchTVShows(searchTerm);
    }
}
