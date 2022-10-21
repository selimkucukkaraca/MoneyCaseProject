package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Transfer {
    private String id = UUID.randomUUID().toString();
    private String fromUser;
    private String toUser;
    private double amount;
    private LocalDateTime date = LocalDateTime.now();

    public Transfer(String fromUser, String toUser, double amount) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }
}
