package pl.sii.spring.core.dependson;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("beanB")
public class BeanA {
    public BeanA() {
        System.out.println("BeanA");
    }
}
