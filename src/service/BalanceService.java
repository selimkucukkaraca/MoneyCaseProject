package service;

import dao.DatabaseConnection;
import model.Balance;

public class BalanceService {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public void depositMoney(double balance){
        if (checkBalance(new Balance(balance))){
            databaseConnection.withdrawMoney(balance);
        }
    }

    public void withdrawMoney(double balance){

    }

    private boolean checkBalance(Balance balance){
        if (balance.equals("0")){
        }
        return false;
    }

}
