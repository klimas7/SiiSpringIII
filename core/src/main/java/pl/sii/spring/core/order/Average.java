package pl.sii.spring.core.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Average implements Rating {
    @Override
    public int getRating() {
        return 3;
    }
}
