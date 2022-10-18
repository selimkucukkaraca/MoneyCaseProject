package dao;

import model.Balance;
import model.Log;
import utils.DatabaseInformation;
import utils.Query;

import java.sql.*;

public class DatabaseConnection {

    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public DatabaseConnection() {
        String url = "jdbc:mysql://" + DatabaseInformation.host + ":" +
                DatabaseInformation.port + "/" + DatabaseInformation.db_name +
                "?useUnicode=true&characterEncoding=utf8";

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }

        try {
            con = DriverManager.getConnection(url, DatabaseInformation.user_name, DatabaseInformation.password);
            System.out.println("Bağlantı Başarılı...");

        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
        }
    }


    public boolean login(String name,String surname,int password){
        String query = Query.login;

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            preparedStatement.setInt(3,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void withdrawMoney(String user, double amount){

            try {
                preparedStatement = con.prepareStatement(Query.depositMoney);
                Balance balance = new Balance(user, amount);
                preparedStatement.setString(1, balance.getUser());
                preparedStatement.setDouble(2,balance.getBalance());
                preparedStatement.executeUpdate();


                //System.out.println(balance1.getBalance());

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public void addLog(Log log) {

        try {
            preparedStatement = con.prepareStatement(Query.addLog);
            preparedStatement.setString(1, log.getId());
            preparedStatement.setString(2, log.getDescription());
            preparedStatement.setString(3, String.valueOf(log.getDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public double getBalanceByUser(String user) throws SQLException {

        statement = con.createStatement();
        String query = Query.getBalanceByUserName + user + "'"; //TODO: refactor

        ResultSet resultSet = statement.executeQuery(query);
        double balance = 0;
        while (resultSet.next()){
             balance = resultSet.getDouble("balance");
        }
        return balance;
    }


}
