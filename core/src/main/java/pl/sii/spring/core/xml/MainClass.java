package pl.sii.spring.core.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        //! FileSystemXmlApplicationContext

        //DefaultListableBeanFactory

        //getBean -> DefaultListableBeanFactory -> DefaultSingletonBeanRegistry
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.print();

        helloWorld.setMessage("test");
        helloWorld.print();

        HelloWorld helloWorldBySetter = (HelloWorld) context.getBean("helloWorldSetter");
        helloWorldBySetter.print();

        HelloWorld helloWorldByConstructor = context.getBean("helloWordConstructor", HelloWorld.class);
        helloWorldByConstructor.print();
    }
}
