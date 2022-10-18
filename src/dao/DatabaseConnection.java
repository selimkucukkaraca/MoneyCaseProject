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

    public Balance withdrawMoney(double balance){
        System.out.println("money-service");

            try {
                preparedStatement = con.prepareStatement(Query.depositMoney);
                Balance balance1 = new Balance(balance);
                preparedStatement.setDouble(1,balance1.getBalance());
                preparedStatement.executeUpdate();

                System.out.println(balance1.getBalance());
                return balance1;

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


}
