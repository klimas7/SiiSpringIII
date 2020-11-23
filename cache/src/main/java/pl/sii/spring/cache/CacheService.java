package pl.sii.spring.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheService {

    @Cacheable("names")
    public String get(String name, String age) {
        log.info("Cache service {} {}", name, age);
        return name + " : " + age;
    }
}
