package service;

import dao.DatabaseConnection;

public class UserService {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public boolean login(String name,String surname,int password){
        return databaseConnection.login(name,surname,password);
    }
}
