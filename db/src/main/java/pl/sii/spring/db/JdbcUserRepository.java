package pl.sii.spring.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pl.sii.spring.db.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("jdbc")
public class JdbcUserRepository implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM user", Long.class);
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
        long id = insertUserAndReturnId(user);
        User newUser = new User(id, user.getFirstName(), user.getLastName(), user.getUserAge(), user.getBirthDate());
        return newUser;
    }

    @Override
    public void delete(long id) {

    }

    private long insertUserAndReturnId(User user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user");
        insert.setGeneratedKeyName("id");
        Map<String, Object> args= new HashMap();
        args.put("firstName", user.getFirstName());
        args.put("lastName", user.getLastName());
        args.put("age", user.getUserAge());
        args.put("birthDate", user.getBirthDate());
        return insert.executeAndReturnKey(args).longValue();
    }
}
