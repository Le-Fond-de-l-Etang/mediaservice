package data.database.dao;

import data.beans.MusicEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import data.database.utils.HibernateUtil;

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
    public Optional<MusicEntity> getMusic(int id) {
        try {
            MusicEntity music = session.get(MusicEntity.class, id);
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
    public Optional<Integer> addMusic(MusicEntity music) {
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
    public void updateMusic(MusicEntity music) {
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
    public List<MusicEntity> getMusics() {
        Criteria criteria = session.createCriteria(MusicEntity.class);
        List<MusicEntity> musicList = (List<MusicEntity>) criteria.list();
        return musicList;
    }

    /**
     * Return all musics with an author, a title or an ISMN matching the search term
     *
     * @param searchTerm the searched term
     * @return the musics matching the search term
     */
    public List<MusicEntity> searchMusics(String searchTerm) {
        List musics = session.createCriteria(MusicEntity.class).add(Restrictions.or(
                Restrictions.like("ismn", "%"+searchTerm+"%"),
                Restrictions.like("title", "%"+searchTerm+"%"),
                Restrictions.like("author", "%"+searchTerm+"%"),
                Restrictions.like("album", "%"+searchTerm+"%")
                )).list();
        return musics;
    }
}
