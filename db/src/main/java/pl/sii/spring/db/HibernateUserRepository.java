package pl.sii.spring.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sii.spring.db.model.User;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
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
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public User save(User user) {
        Serializable id = getCurrentSession().save(user);
        User newUser = new User((Long) id, user.getFirstName(), user.getFirstName(), user.getAge(), user.getBirthDate());
        return newUser;
    }

    @Override
    public void delete(long id) {
        getCurrentSession().delete(findOne(id));
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
