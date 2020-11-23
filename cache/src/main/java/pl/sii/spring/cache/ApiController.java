package pl.sii.spring.cache;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class ApiController {
    private final CacheService cacheService;

    @GetMapping("/cache/{name}/{age}")
    public String helloSii(@PathVariable String name, @PathVariable String age ) {
        log.info("In api controller {} {}", name, age);
        return cacheService.get(name, age);
    }
}
