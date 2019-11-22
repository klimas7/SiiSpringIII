package pl.sii.spring.core.dependson;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("beanC")
public class BeanB {
    public BeanB() {
        System.out.println("BeanB");
    }
}
