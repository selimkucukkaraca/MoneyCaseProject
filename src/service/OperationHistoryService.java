package service;

import dao.DatabaseConnection;
import request.CreateOperationHistoryRequest;

public class OperationHistoryService {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public void saveOperationHistory(CreateOperationHistoryRequest request) {
        databaseConnection.saveOperationHistory(request);
    }
}
