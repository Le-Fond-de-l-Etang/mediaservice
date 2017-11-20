package server.controller;

import action.TVShowAction;
import data.beans.TVShowEntity;
import exceptions.MediaAlreadyReturnedException;
import exceptions.MediaNotFoundException;
import exceptions.UnavailableMediaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for tvshow management
 */
@RestController
public class TVShowController {
    TVShowAction tvshowaction = new TVShowAction();

    /**
     * Get a specific tvshow
     * @param id ID of the tvshow
     * @return TVShow if present
     */
    @RequestMapping(method = RequestMethod.GET, value = "/tvshow/{id}")
    public ResponseEntity<TVShowEntity> getTVShow(@PathVariable int id) {
        Optional<TVShowEntity> tvshow = tvshowaction.getTVShow(id);
        if (tvshow.isPresent()) {
            return new ResponseEntity<>(tvshow.get(), HttpStatus.OK) ;
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Return tvshows matching filter
     * @param filter Search term
     * @return List of tvshows
     */
    @RequestMapping(method = RequestMethod.GET, value = "/tvshow")
    public List<TVShowEntity> searchTVShows(@RequestParam(value="filter", defaultValue="", required=false) String filter) {
        return tvshowaction.searchTVShows(filter);
    }

    /**
     * Add a new tvshow
     * @param tvshow TVShow to add
     * @return TVShow, if added
     */
    @RequestMapping(method = RequestMethod.POST, value = "/tvshow")
    public ResponseEntity<TVShowEntity> addTVShow(@RequestBody TVShowEntity tvshow) {
        tvshowaction.addTVShow(tvshow);
        int id = tvshow.getId();
        Optional<TVShowEntity> persistedTVShow = tvshowaction.getTVShow(id);
        if (persistedTVShow.isPresent()) {
            return new ResponseEntity<>(persistedTVShow.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Borrow a tvshow if available
     * @param id ID of the tvshow to borrow
     * @param username Username of the borrower
     * @return TVShow, if borrowed
     */
    @RequestMapping(method = RequestMethod.POST, value = "/tvshow/{id}/borrow")
    public ResponseEntity<TVShowEntity> borrowTVShow(@PathVariable int id, @RequestParam(value="username") String username) {
        try {
            tvshowaction.borrowTVShow(id, username);
            Optional<TVShowEntity> tvshow = tvshowaction.getTVShow(id);
            if (tvshow.isPresent()) {
                return new ResponseEntity<>(tvshow.get(), HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (MediaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (UnavailableMediaException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Return a borrowed tvshow
     * @param id ID of the tvshow
     * @param username Username of the borrower
     * @return TVShow, if returned
     */
    @RequestMapping(method = RequestMethod.POST, value = "/tvshow/{id}/return")
    public ResponseEntity<TVShowEntity> returnTVShow(@PathVariable int id, @RequestParam(value="username") String username) {
        try {
            tvshowaction.returnTVShow(id, username);
            Optional<TVShowEntity> tvshow = tvshowaction.getTVShow(id);
            if (tvshow.isPresent()) {
                return new ResponseEntity<>(tvshow.get(), HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (MediaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (MediaAlreadyReturnedException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
