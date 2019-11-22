package pl.sii.spring.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class RatingRetriever {
    private final List<Rating> ratings; //As alphabet

    public RatingRetriever(List<Rating> ratings) {
        this.ratings = ratings;
    }
    //DefaultListableBeanFactory.getBeanNamesForType --> this.allBeanNamesByType Tutaj jest zgodnie z alfabetem
    //ClassPathBeanDefinitionScanner -> doScan

    //If add Order
    /*
    DefaultListableBeanFactory.resolveMultipleBeans
    1371
    if (result instanceof List) {
				Comparator<Object> comparator = adaptDependencyComparator(matchingBeans);
				if (comparator != null) {
					((List<?>) result).sort(comparator);
				}
			}
	OrderComparator
	AnnotationAwareOrderComparator
     */


    @PostConstruct
    public void printRating() {
        ratings.forEach(rating -> System.out.println("Rating: " + rating.getRating()));
    }
}
