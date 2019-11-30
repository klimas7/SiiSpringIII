package pl.sii.spring.db;


import pl.sii.spring.db.model.User;

import java.util.List;

public interface UserRepository {
    long count();

    List<User> findRecent();

    List<User> findRecent(int count);

    User findOne(long id);

    User save(User user);

    void delete(long id);
}
