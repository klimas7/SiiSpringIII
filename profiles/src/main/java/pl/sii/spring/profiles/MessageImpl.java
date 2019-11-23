package pl.sii.spring.profiles;

public class MessageImpl implements Message {
    private String message;

    public MessageImpl(String message) {
        this.message = message;
    }

    @Override
    public void sendMessage() {
        System.out.println(message);
    }
}
