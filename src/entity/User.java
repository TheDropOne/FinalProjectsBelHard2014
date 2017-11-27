/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Семён
 */
public class User {

    //id_user int(3) primary key, login varchar(30),pass varchar(16),role int(3)
    private int id_user;
    private String login;
    private String pass;
    private int role;

    public User() {

    }

    public User(int id_user, String login, String pass, int role) {
        this.id_user = id_user;
        this.login = login;
        this.pass = pass;
        this.role = role;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
