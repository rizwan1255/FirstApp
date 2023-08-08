package com.example.oflinedatabase;


import java.io.Serializable;

public class UserModel implements Serializable {

    public String name;
    public String password;
    public String id;

    public UserModel() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
