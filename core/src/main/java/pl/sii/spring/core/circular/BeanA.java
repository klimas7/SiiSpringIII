package pl.sii.spring.core.circular;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
    private BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }
}
