package pl.sii.spring.core.diff;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape {
    private int a = 5;
    @Override
    public int area() {
        return a * a;
    }

    @Override
    public String description() {
        return Square.class.getName() + " area: " + area();
    }
}
