package service;

import dao.DatabaseConnection;
import model.Log;

public class LogService {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public void addLog(Log log) {
        databaseConnection.addLog(log);
    }
}
