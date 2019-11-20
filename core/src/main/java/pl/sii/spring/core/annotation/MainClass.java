package pl.sii.spring.core.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("pl.sii.spring.core.annotation");
        System.out.println(context.getBeanDefinitionCount());
        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("----------------");

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.print();

        HelloWorld helloWorldBySetter = (HelloWorld) context.getBean("helloWorldSetter");
        helloWorldBySetter.print();

        System.out.println("//-------------------------");
        Factory factory = context.getBean("factory", Factory.class);
        factory.doWork();
    }
}
