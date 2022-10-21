package utils;

public interface Query {

    String login = "Select * From user where name = ? and surname = ? and password = ?";
    String getBalance = "Select * from balance where user = ?";
    String depositMoney = "Insert Into balance (user,balance) VALUES(?,?)";
    String addLog = "Insert Into log (id,description,date) VALUES(?,?,?)";
    String getBalanceByUserName = "SELECT * FROM balance WHERE user = '";
    String saveOperationQuery = "Insert Into operation_history (id,amount,user,date) VALUES(?,?,?,?)";

    //String MoneyTransfer = "Select * FROM user where name = ?";
    // String sql = "SELECT r2.Balance,r2.acc_number FROM bankapplication.register1 r1,bankapplication.register2 r2 where
    // r1.Username=? and r1.Password=? and r1.account_number=r2.acc_number;";
}
