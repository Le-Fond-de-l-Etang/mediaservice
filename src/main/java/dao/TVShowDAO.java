package dao;

import beans.TVShow;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;

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
    public Optional<TVShow> getTVShow(String id) {
        try {
            TVShow tvshow = session.get(TVShow.class, id);
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
    public Optional<Integer> addTVShow(TVShow tvshow) {
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
    public void updateTVShow(TVShow tvshow) {
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
    public List<TVShow> getTVShows() {
        Criteria criteria = session.createCriteria(TVShow.class);
        List<TVShow> tvshowList = (List<TVShow>) criteria.list();
        return tvshowList;
    }

    /**
     * Return all tvshows with an author, a title or an ISMN matching the search term
     *
     * @param searchTerm the searched term
     * @return the tvshows matching the search term
     */
    public List<TVShow> searchTVShows(String searchTerm) {
        List tvshows = session.createCriteria(TVShow.class).add(Restrictions.or(
                Restrictions.like("director", "%"+searchTerm+"%"),
                Restrictions.like("producer", "%"+searchTerm+"%"),
                Restrictions.like("title", "%"+searchTerm+"%")
                )).list();
        return tvshows;
    }
}
