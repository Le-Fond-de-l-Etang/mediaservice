package dao;

import beans.Music;
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
     * @param id the id of the wanted music
     * @return a music with the given id if there is one
     */
    public Optional<Music> getMusic(String id) {
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
     * @return the id of the added music if the ismn exists
     */
    public Optional<Integer> addMusic(Music music) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(music);
        session.getTransaction().commit();
        return Optional.ofNullable(music.getId());
    }

    /**
     * Update a music
     * @param music the music
     */
    public void updateMusic(Music music) {
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
    public List<Music> getMusics() {
        Criteria criteria = session.createCriteria(Music.class);
        List<Music> musicList = (List<Music>) criteria.list();
        return musicList;
    }

    /**
     * Return all musics with an author, a title or an ISMN matching the search term
     *
     * @param searchTerm the searched term
     * @return the musics matching the search term
     */
    public List<Music> searchMusics(String searchTerm) {
        List musics = session.createCriteria(Music.class).add(Restrictions.or(
                Restrictions.like("ismn", "%"+searchTerm+"%"),
                Restrictions.like("author", "%"+searchTerm+"%"),
                Restrictions.like("title", "%"+searchTerm+"%")
                )).list();
        return musics;
    }
}
