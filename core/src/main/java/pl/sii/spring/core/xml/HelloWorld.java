package pl.sii.spring.core.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class HelloWorld {
    private String message;

    void print() {
        System.out.println("Your message: " + message);
    }
}

