package pl.sii.spring.db.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.sii.spring.db.UserRepository;
import pl.sii.spring.db.model.User;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApi {
    @Autowired
    @Qualifier("hibernate")
    private UserRepository userRepository;

    @GetMapping("/count")
    public Long countUser() {
        return userRepository.count();
    }

    @GetMapping("/findRecent")
    public List<User> findRecent() {
        return userRepository.findRecent();
    }

    @GetMapping("/findRecent/{count}")
    public List<User> findRecent(@PathVariable Integer count) {
        return userRepository.findRecent(count);
    }

    @PostMapping("/add/{firstName}/{lastName}")
    public User addUser(@PathVariable String firstName, @PathVariable String lastName) {
        User user = new User(null, firstName, lastName, 10, LocalDateTime.now());
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.delete(id);
    }
}
