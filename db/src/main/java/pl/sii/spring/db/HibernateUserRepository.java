package pl.sii.spring.db;

import org.springframework.stereotype.Repository;
import pl.sii.spring.db.model.User;

import java.util.List;

@Repository("hibernate")
public class HibernateUserRepository implements UserRepository {
    @Override
    public long count() {
        return 0;
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
}
