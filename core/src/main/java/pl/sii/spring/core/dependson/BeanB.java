package pl.sii.spring.core.dependson;

import org.springframework.stereotype.Component;

@Component
public class BeanB {
    public BeanB() {
        System.out.println("BeanB");
    }
}
