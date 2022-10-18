package utils;

public interface Query {

    String login = "Select * From user where name = ? and surname = ? and password = ?";
    String getBalance = "Select * from balance where balance = ?";
    String depositMoney = "Insert Into balance (balance) VALUES(?)";
    String addLog = "Insert Into log (id,description,date) VALUES(?,?,?)";

}
