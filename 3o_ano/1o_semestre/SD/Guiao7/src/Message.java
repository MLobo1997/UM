import java.time.LocalDateTime;

public class Message {
    private LocalDateTime time;
    private String user;
    private String text;

    public Message(LocalDateTime time, String user, String text) {
        this.time = time;
        this.user = user;
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }
}
