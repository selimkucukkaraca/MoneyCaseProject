package model;

import lombok.Data;

@Data
public class User {

    private String name;
    private String surname;
    private int password;

    public User(String name, String surname, int password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
}
