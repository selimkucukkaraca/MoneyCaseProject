package request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOperationHistoryRequest {
    private double amount;
    private String user;
}
