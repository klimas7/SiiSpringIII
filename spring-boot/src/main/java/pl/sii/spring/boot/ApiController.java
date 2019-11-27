package pl.sii.spring.boot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private SessionScopeMessage sessionScopeMessage;
    private RequestScopeMessage requestScopeMessage;

    public ApiController(SessionScopeMessage sessionScopeMessage, RequestScopeMessage requestScopeMessage) {
        this.sessionScopeMessage = sessionScopeMessage;
        this.requestScopeMessage = requestScopeMessage;
    }

    @GetMapping("/helloSii")
    public String helloSii() {
        return "Hello Sii";
    }


    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam String name) {
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

    @GetMapping("/session")
    public String session() {
        return sessionScopeMessage.getMessage();
    }

    @GetMapping("/request")
    public String request() {
        return requestScopeMessage.getMessage();
    }

    @GetMapping("/object")
    public ResponseEntity<Test> getTest() {
        return new ResponseEntity<>(new Test(), HttpStatus.OK);
    }

}
