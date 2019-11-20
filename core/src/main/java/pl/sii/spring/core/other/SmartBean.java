package pl.sii.spring.core.other;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public class SmartBean implements InitializingBean, DisposableBean {
    private List<User> users;
    private User otherUser;

    /*
    Uwaga dodać drugi cokstruktor i pokazać że jak sa dwa to jeden musi mieć Autowired
    @Autowired
    public SmartBean(User user) {
        this.users = Arrays.asList(user);
        System.out.println(users);
    }*/
    /*
    public SmartBean(User user, User user2 ) {
        this.users = Arrays.asList(user, user2);
        System.out.println(users);
    }
    */

    public SmartBean(List<User> users) {
        this.users = users;//Arrays.asList(user, user2);
        System.out.println(users);
    }

    @Resource
    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
        System.out.println("Other user: " + otherUser);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post Constract");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Shutting down SmartBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing SmartBean");
    }
}
