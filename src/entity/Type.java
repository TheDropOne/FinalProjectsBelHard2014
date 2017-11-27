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
public class Type {
    /*db.update("create table type(id_type int(3) primary key, name varchar(15))");
        ;
        db.update("create table order(id_order int(3) primary key, id_user int(3),type int(3),date DATE,checked int(3), foreign key (id_user) references user (id_user),foreign key (type) references type (id_type),foreign key (checked) references status (id_status))");
        db.update("create table teams(id_teams int(3) primary key, type int(3),team_status int(3) foreign key (team_status) references status (id_status))");
        db.update("create table plan(id_plan int(3) primary key, order int(3), id_team int(3),foreign key(id_team) references teams(id_teams))");
        */
    private int id_type;
    private String name;

    public Type() {

    }

    public Type(int id_type, String name) {
        this.id_type = id_type;
        this.name = name;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

