package utils;

public interface Query {

    String login = "Select * From user where name = ? and surname = ? and password = ?";
    String getBalance = "Select * from balance where user = ?";
    String depositMoney = "Insert Into balance (user,balance) VALUES(?,?)";
    String addLog = "Insert Into log (id,description,date) VALUES(?,?,?)";
    String getBalanceByUserName = "SELECT * FROM balance WHERE user = '";

}
