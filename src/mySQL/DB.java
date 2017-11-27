/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mySQL;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Семён
 */
public class DB {

    private Connection cn;
    private Statement st;
    private ResultSet rs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DB db = new DB("jdbc:mysql://127.0.0.1", "phillip", "password");
        db.update("drop database final");
        db.update("create database final");
        db.update("use final");

        db.update("create table role(id_role int(3) primary key,name varchar(15))");
        db.update("create table user(id_user int(3) primary key, login varchar(30),pass varchar(16),role int(3), foreign key(role) references role(id_role))");
        db.update("create table type(id_type int(3) primary key, name varchar(15))");
        db.update("create table status(id_status int(3) primary key,status varchar(15))");
        db.update("create table orders(id_order int(3) primary key, id_user int(3),type int(3),date DATE,checked int(3), foreign key (id_user) references user (id_user),foreign key (type) references type (id_type),foreign key (checked) references status (id_status))");
        db.update("create table teams(id_teams int(3) primary key, type int(3),team_status int(3), foreign key (team_status) references status (id_status))");
        db.update("create table plan(id_plan int(3) primary key, id_order int(3), id_team int(3),foreign key(id_team) references teams(id_teams),foreign key(id_order)references orders(id_order))");
        db.update("insert into user values (1,'admin','admin',2)");
        db.update("insert into user values (2,'user','user',1)");

        db.close();
    }

    public Connection getCn() {
        return cn;
    }

    public void update(String sql) {
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Ошибка в запросе update " + ex);
        }
    }

    public ResultSet query(String sql) {
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("ошибка в запросе query  "+ex);
        }
        return rs;
    }

    public void showResultSet(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + "\t");
            }
            while (rs.next()) {
                System.out.println("\n____________________________");
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.println(rs.getString(i) + "\t|");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DB(String url, String login, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                cn = (Connection) DriverManager.getConnection(url, login, pass);
                st = (Statement) cn.createStatement();
            } catch (SQLException ex) {
                System.out.println("ошибка при установке соединения с базой данных " + ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ошибка загрузки драйвера " + ex);
        }
    }

    public void close() {
        try {
            st.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
