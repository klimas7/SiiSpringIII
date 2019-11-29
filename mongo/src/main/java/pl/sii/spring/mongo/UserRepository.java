package pl.sii.spring.mongo;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private MongoOperations mongo;
    private UserMongoRepository userMongoRepository;

    public UserRepository(MongoOperations mongo, UserMongoRepository userMongoRepository) {
        this.mongo = mongo;
        this.userMongoRepository = userMongoRepository;
    }

    public List<User> save(Iterable<User> users) {
        return userMongoRepository.saveAll(users);
    }

    public List<User> findAll() {
//        return userMongoRepository.findAll();
        return mongo.findAll(User.class);
    }

    public List<User> findByFirstName(String firstName) {
        return userMongoRepository.findUserByFirstName(firstName);
    }

    //db.user.find().sort({userAge: -1}).limit(1)
    public User getOldestUser() {
//        Query query = new Query();
//        query.with(Sort.by(Sort.Direction.DESC, "age"));
//        query.limit(1);
//
//        return mongo.findOne(query, User.class);
        return userMongoRepository.findTopByAgeIsAfterOrderByAgeDesc(0);
    }
}
