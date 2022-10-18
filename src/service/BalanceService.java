package service;

import dao.DatabaseConnection;

import java.sql.SQLException;

public class BalanceService {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();


    public void depositMoney(String user, double balance){
            databaseConnection.withdrawMoney(user, balance);
    }


    public double getBalanceByUser(String user) throws SQLException {
        return databaseConnection.getBalanceByUser(user);
    }

   public void updateBalance(double balance, String username) throws SQLException {
        databaseConnection.updateBalance(balance, username);
   }


}
