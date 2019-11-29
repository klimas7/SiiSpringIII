package pl.sii.spring.mongo;

import org.springframework.data.mongodb.core.MongoOperations;
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
}
