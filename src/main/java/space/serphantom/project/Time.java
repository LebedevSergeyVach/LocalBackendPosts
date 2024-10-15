package space.serphantom.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public String getTimeData() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

        return now.format(formatter);
    }
}
