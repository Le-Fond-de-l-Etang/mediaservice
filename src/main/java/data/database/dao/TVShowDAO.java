package data.database.dao;

import data.beans.TVShowEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import data.database.utils.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class TVShowDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Get a tvshow from its id
     *
     * @param id the id of the wanted tvshow
     * @return a tvshow with the given id if there is one
     */
    public Optional<TVShowEntity> getTVShow(int id) {
        try {
            TVShowEntity tvshow = session.get(TVShowEntity.class, id);
            return Optional.ofNullable(tvshow);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    /**
     * Add a tvshow
     *
     * @param tvshow the tvshow
     * @return the id of the added tvshow if the ismn exists
     */
    public Optional<Integer> addTVShow(TVShowEntity tvshow) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(tvshow);
        session.getTransaction().commit();
        return Optional.ofNullable(tvshow.getId());
    }

    /**
     * Update a tvshow
     * @param tvshow the tvshow
     */
    public void updateTVShow(TVShowEntity tvshow) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(tvshow);
        session.getTransaction().commit();
    }

    /**
     * Get all tvshows of the library
     *
     * @return the tvshows
     */
    public List<TVShowEntity> getTVShows() {
        Criteria criteria = session.createCriteria(TVShowEntity.class);
        List<TVShowEntity> tvshowList = (List<TVShowEntity>) criteria.list();
        return tvshowList;
    }

    /**
     * Return all tvshows with an author, a title or an ISMN matching the search term
     *
     * @param searchTerm the searched term
     * @return the tvshows matching the search term
     */
    public List<TVShowEntity> searchTVShows(String searchTerm) {
        List tvshows = session.createCriteria(TVShowEntity.class).add(Restrictions.or(
                Restrictions.like("director", "%"+searchTerm+"%"),
                Restrictions.like("producer", "%"+searchTerm+"%"),
                Restrictions.like("title", "%"+searchTerm+"%")
                )).list();
        return tvshows;
    }
}
