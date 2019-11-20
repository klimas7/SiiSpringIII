package pl.sii.spring.core.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("pl.sii.spring.annotation");
        System.out.println(context.getBeanDefinitionCount());
        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
