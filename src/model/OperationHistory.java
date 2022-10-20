package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class OperationHistory {
    private String id = UUID.randomUUID().toString();
    private double amount;
    private String user;
    private LocalDateTime date = LocalDateTime.now();

    public OperationHistory(double amount, String user) {
        this.amount = amount;
        this.user = user;
    }
}
