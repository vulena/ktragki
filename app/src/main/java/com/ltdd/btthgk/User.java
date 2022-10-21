package com.ltdd.btthgk;

public class User {
    String username,pass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User() {
    }

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }
}
