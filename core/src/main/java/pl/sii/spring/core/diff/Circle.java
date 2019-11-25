package pl.sii.spring.core.diff;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {
    private int r = 5;

    @Override
    public int area() {
        return (int) (Math.PI * r * r);
    }
}
