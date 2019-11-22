package pl.sii.spring.core.dependson;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
    public BeanA() {
        System.out.println("BeanA");
    }
}
