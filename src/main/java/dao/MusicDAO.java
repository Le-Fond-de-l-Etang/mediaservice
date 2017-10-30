package dao;

import beans.Music;
import exceptions.AllMusicsAlreadyReturnedException;
import exceptions.MusicNotFoundException;
import exceptions.UnavailableMusicException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class MusicDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Get a music from its id
     *
     * @param id the id of the wanter music
     * @return a music with the given id if there is one
     */
    Optional<Music> getMusic(String id) {
        try {
            Music music = session.get(Music.class, id);
            return Optional.ofNullable(music);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    /**
     * Add a music
     *
     * @param music the music
     * @return the id of the added music if the isbn exists
     */
    Optional<String> addMusic(Music music) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(music);
        session.getTransaction().commit();
    }

    /**
     * Update a music
     * @param music the music
     */
    void updateMusic(Music music) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(music);
        session.getTransaction().commit();
    }

    /**
     * Get all musics of the library
     *
     * @return the musics
     */
    List<Music> getMusics() {
        Criteria criteria = session.createCriteria(Music.class);
        List<Music> musicList = (List<Music>) criteria.list();
        return musicList;
    }

    /**
     * Return all musics with an author, a title or an ISBN matching the search term
     *
     * @param searchTerm the searched term
     * @return the musics matching the search term
     */
    List<Music> searchMusics(String searchTerm) {
        List musics = session.createCriteria(Music.class).add(Restrictions.or(
                Restrictions.like("author", "%"+searchTerm+"%"),
                Restrictions.like("title", "%"+searchTerm+"%")
                )).list();
        return musics;
    }
}
