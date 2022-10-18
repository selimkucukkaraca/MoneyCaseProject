package service;

import dao.DatabaseConnection;
import model.Balance;

import java.sql.SQLException;

public class BalanceService {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public void depositMoney(String user, double balance){
            databaseConnection.withdrawMoney(user, balance);
    }

    public void withdrawMoney(double balance){


    }

    public double getBalanceByUser(String user) throws SQLException {
        return databaseConnection.getBalanceByUser(user);
    }



}
