package utils;

public interface Query {

    String login = "Select * From user where name = ? and surname = ? and password = ?";
    int depositMoney = Integer.parseInt("Insert Into balance (balance) VALUES(?)");

}
