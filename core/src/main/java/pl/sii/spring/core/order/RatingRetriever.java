package pl.sii.spring.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RatingRetriever {
    @Autowired
    @Qualifier("excellent")
    private Rating rating;

    @PostConstruct
    public void printRating() {
        System.out.println("Rating " + rating.getRating());
    }
}
