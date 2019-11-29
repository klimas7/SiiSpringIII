package pl.sii.spring.mongo;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApi {
    private static final Log log = LogFactory.getLog(RestApi.class);
    private UserRepository userRepository;

    public RestApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/createUsers")
    private void createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Rambo", 42, LocalDateTime.of(1960, Month.JANUARY, 12, 0 ,0 )));
        users.add(new User("Neo", "Matrix", 42, LocalDateTime.of(1963, Month.MAY, 13, 0 ,0 )));
        users.add(new User("Myszka", "Miki", 12, LocalDateTime.of(2017, Month.JANUARY, 12, 0 ,0 )));
        users.add(new User("Kaczor", "Donald", 42, LocalDateTime.of(2017, Month.JANUARY, 12, 0 ,0 )));
        users.add(new User("Dziadek", "Mroz", 142, LocalDateTime.of(1860, Month.JANUARY, 12, 0 ,0 )));
        userRepository.save(users);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{firstName}")
    public List<User> getUserByName(@PathVariable String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @GetMapping("/oldestUser")
    public User getOldestUser() {
        return userRepository.getOldestUser();
    }

    @GetMapping("/userAgeCounts")
    public List<AgeCounts> getUserAgeCounts() {
        return userRepository.getUserAgeCounts();
    }

    @GetMapping("/cacheTest")
    public void cacheTest() {
        log.info("Cache Test");
        log.info("1: " + userRepository.findByFirstNameSlow("John"));
        log.info("2: " + userRepository.findByFirstNameSlow("Neo"));
        log.info("3: " + userRepository.findByFirstNameSlow("Myszka"));

        log.info("1a: " + userRepository.findByFirstNameSlow("John"));
        log.info("2a: " + userRepository.findByFirstNameSlow("Neo"));
        log.info("3a: " + userRepository.findByFirstNameSlow("Myszka"));

        log.info("1b: " + userRepository.findByFirstNameSlow("John"));
        log.info("2b: " + userRepository.findByFirstNameSlow("Neo"));
        log.info("3b: " + userRepository.findByFirstNameSlow("Myszka"));
    }
}
