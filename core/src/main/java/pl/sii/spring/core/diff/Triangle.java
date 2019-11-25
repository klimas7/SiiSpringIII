package pl.sii.spring.core.diff;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {
    int a = 5;

    @Override
    public int area() {
        return (int) ((a * a * Math.sqrt(3)) / 2);
    }
}
