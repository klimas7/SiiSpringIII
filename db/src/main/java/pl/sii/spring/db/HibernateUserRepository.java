package pl.sii.spring.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sii.spring.db.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
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
        return findRecent(3);
    }

    @Override
    public List<User> findRecent(int count) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.orderBy(cb.desc(root.get("age")));
        return session.createQuery(query)
                .setMaxResults(count)
                .getResultList();
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
    @Transactional
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
