package pl.sii.spring.boot;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private SessionScopeMessage sessionScopeMessage;
    private RequestScopeMessage requestScopeMessage;
    private ResourceReader resourceReader;

    public ApiController(SessionScopeMessage sessionScopeMessage, RequestScopeMessage requestScopeMessage, ResourceReader resourceReader) {
        this.sessionScopeMessage = sessionScopeMessage;
        this.requestScopeMessage = requestScopeMessage;
        this.resourceReader = resourceReader;
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

    @GetMapping("/getSiiImages")
    public void getSiiImages(HttpServletResponse response) throws IOException {
        File zip = resourceReader.getImagesAsZip();
        InputStream is = new FileInputStream(zip);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setContentLengthLong(zip.length());
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attchment; filename=\"" + zip.getName() + "\"");
        IOUtils.copy(is, response.getOutputStream());
        response.flushBuffer();
    }
}
