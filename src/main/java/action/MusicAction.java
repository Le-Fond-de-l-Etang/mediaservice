package action;

import beans.Music;
import dao.MusicDAO;
import exceptions.AllMusicsAlreadyReturnedException;
import exceptions.MusicNotFoundException;
import exceptions.UnavailableMusicException;

import java.util.List;
import java.util.Optional;

public class MusicAction {
    MusicDAO musicDAO = new MusicDAO();

    /**
     * Get a music from its id
     *
     * @param id the id of the wanter music
     * @return a music with the given id if there is one
     */
    Optional<Music> getMusic(String id) {
        return musicDAO.getMusic(id);
    }

    /**
     * Add a music
     *
     * @param music the music
     * @return the id of the added music if the ismn exists
     */
    Optional<String> addMusic(Music music) {
        return musicDAO.addMusic(music);
    }

    /**
     * Borrow a music from the library
     *
     * @param id the id of the borrowed music
     * @param username the name of the user
     * @throws MusicNotFoundException if no music in the library has the given id
     * @throws UnavailableMusicException if all musics in the library with the given id have been borrowed
     */
    void borrowMusic(String id, String username) throws MusicNotFoundException, UnavailableMusicException {
        Optional<Music> optionalMusic = musicDAO.getMusic(id);
        if (!optionalMusic.isPresent()) {
            throw new MusicNotFoundException("Music " + id + " not found.");
        }
        Music music = optionalMusic.get();
        if (music.isBorrowed()) {
            throw new UnavailableMusicException("Music " + id + " already borrowed.");
        }
        music.setBorrowed(true);
        music.setBorrower(username);
        musicDAO.updateMusic(music);
    }

    /**
     * Return a music back to the library
     *
     * @param id the id of the music to borrow
     * @param username the name of the user
     * @throws MusicNotFoundException if no music in the library has the given id
     * @throws AllMusicsAlreadyReturnedException if all musics with the given id are already returned
     */
    void returnMusic(String id, String username) throws MusicNotFoundException, AllMusicsAlreadyReturnedException {
        Optional<Music> optionalMusic = musicDAO.getMusic(id);
        if (!optionalMusic.isPresent()) {
            throw new MusicNotFoundException("Music " + id + " not found.");
        }
        Music music = optionalMusic.get();
        if (!music.isBorrowed() || !music.getBorrower().equals(username)) {
            throw new AllMusicsAlreadyReturnedException("Music " + id + " not borrowed by " + username + ".");
        }
        music.setBorrowed(false);
        musicDAO.updateMusic(music);
    }

    /**
     * Get all musics of the library
     *
     * @return the musics
     */
    List<Music> getMusics() {
        return musicDAO.getMusics();
    }

    /**
     * Return all musics with an author, a title or an ISMN matching the search term
     *
     * @param searchTerm the searched term
     * @return the musics matching the search term
     */
    List<Music> searchMusics(String searchTerm) {
        return musicDAO.searchMusics(searchTerm);
    }
}
