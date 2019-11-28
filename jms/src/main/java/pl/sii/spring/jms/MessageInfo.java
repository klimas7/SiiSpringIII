package pl.sii.spring.jms;

import java.io.Serializable;

public class MessageInfo implements Serializable {
    private String message;
    private Integer count;

    public MessageInfo() {
    }

    public MessageInfo(String message) {
        this.message = message;
        this.count = 1;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "message='" + message + '\'' +
                ", count=" + count +
                '}';
    }
}
