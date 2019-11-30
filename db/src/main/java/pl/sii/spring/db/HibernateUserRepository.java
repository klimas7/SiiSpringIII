package pl.sii.spring.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sii.spring.db.model.User;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository("hibernate")
public class HibernateUserRepository implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long count() {
        return findAll().size();
    }


    @Override
    public List<User> findRecent() {
        return null;
    }

    @Override
    public List<User> findRecent(int count) {
        return null;
    }

    @Override
    public User findOne(long id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    private List<User> findAll() {
        Session session = getCurrentSession();
        CriteriaQuery<User> query = session.getCriteriaBuilder().createQuery(User.class);
        query.from(User.class);
        return session.createQuery(query).getResultList();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
