package pl.sii.spring.core.order;

import org.springframework.stereotype.Component;

@Component
public class Good implements Rating {
    @Override
    public int getRating() {
        return 2;
    }
}