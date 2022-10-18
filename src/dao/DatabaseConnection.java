package dao;

import model.Balance;
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

        int query = Query.depositMoney;

            try {
                preparedStatement = con.prepareStatement(String.valueOf(query));
                Balance balance1 = new Balance(balance);
                preparedStatement.setInt(1, (int) balance1.getBalance());
                preparedStatement.executeUpdate();

                return null;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }


}
