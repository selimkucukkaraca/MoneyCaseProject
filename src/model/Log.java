package model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class Log {
    private String id = UUID.randomUUID().toString();
    private String description;
    private LocalDateTime date = LocalDateTime.now();

    public Log(String description) {
        this.description = description;
    }
}
