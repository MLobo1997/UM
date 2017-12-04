import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static java.time.format.DateTimeFormatter.ISO_DATE;
import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;

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

    public String toString(){
        StringBuilder str = new StringBuilder();

        str.append(time.toString());
        str.append(" [");
        str.append(user);
        str.append("]: ");
        str.append(text);

        return str.toString();
    }
}
