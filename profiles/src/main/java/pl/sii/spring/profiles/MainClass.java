package pl.sii.spring.profiles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

//-Dspring.profiles.active=test
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("pl.sii.spring.profiles");

        Arrays.asList(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("----------------");
        Message message = applicationContext.getBean("message", Message.class);
        message.sendMessage();
    }
}
