package pl.sii.spring.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

//-Dspring.profiles.active=test
public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class, args);
    }
}
