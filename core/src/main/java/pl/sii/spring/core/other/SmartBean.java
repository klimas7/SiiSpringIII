package pl.sii.spring.core.other;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class SmartBean implements InitializingBean, DisposableBean {
    private User user;
    private User otherUser;

    private SmartBean(User user) {
        this.user = user;
        System.out.println("User: " + user);
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
