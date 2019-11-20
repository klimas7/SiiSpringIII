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
    private String message2;

    void print() {
        System.out.println("Your messages: " + message + " : " + message2);
    }
}

