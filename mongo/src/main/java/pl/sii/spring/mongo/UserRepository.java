package pl.sii.spring.mongo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
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

    //db.user.find().sort({age: -1}).limit(1)
    public User getOldestUser() {
//        Query query = new Query();
//        query.with(Sort.by(Sort.Direction.DESC, "age"));
//        query.limit(1);
//
//        return mongo.findOne(query, User.class);
        return userMongoRepository.findTopByAgeIsAfterOrderByAgeDesc(0);
    }

    //db.user.aggregate([{ "$group" : {_id: "$age", count:{$sum:1}} }])
    public List<AgeCounts> getUserAgeCounts() {
        Aggregation agg = Aggregation.newAggregation(Aggregation.group("age").count().as("count"),
                Aggregation.project("count").and("age").previousOperation(),
                Aggregation.sort(Sort.Direction.DESC, "age"));

        AggregationResults<AgeCounts> aggregate = mongo.aggregate(agg, User.class, AgeCounts.class);
        return aggregate.getMappedResults();
    }

    @Cacheable("users")
    public List<User> findByFirstNameSlow(String name) {
        sleep();
        return findByFirstName(name);
    }

    private void sleep() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
