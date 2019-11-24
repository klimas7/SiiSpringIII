package pl.sii.spring.properties;

import org.springframework.stereotype.Component;

@Component
public class TestProperty {
    private String property = "testProperty";

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
