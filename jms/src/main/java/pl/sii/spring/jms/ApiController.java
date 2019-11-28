package pl.sii.spring.jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Log log = LogFactory.getLog(ApiController.class);

    private MessageService messageService;

    public ApiController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/text")
    public void sendText(@RequestParam("text") String text) {
        log.info("Send text: " + text);
        messageService.sendMessage(text);
    }

    @PostMapping("/message")
    public void sendMessage(@RequestBody MessageInfo messageInfo) {
        log.info("Send message info: " + messageInfo);
        messageService.sendMessageInfo(messageInfo);
    }

    @GetMapping("/text")
    public String getText() {
        log.info("Get text");
        return messageService.getMessage();
    }

    @GetMapping("/message")
    public MessageInfo getMessage() {
        log.info("Get message info");
        return messageService.getMessageInfo();
    }

}
/*
GET http://localhost:8080/api/text

###
GET http://localhost:8080/api/message

###
POST http://localhost:8080/api/text?text=SiiPowerPeople

###
POST http://localhost:8080/api/message
Content-Type: application/json

{"message" : "Hello Sii People", "count": 1}
 */