/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class StartFrame {

    public JFrame frame;
    public JPanel panel;
    public JTextField login, pass;
    public JButton ok, registration;
    private DB db;
    public JLabel label;

    public StartFrame() {
        frame = new JFrame("Выполните вход!");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        action();
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public void initComponents() {
        DB db = new DB("jdbc:mysql://127.0.0.1", "phillip", "password");
        this.db = db;
        db();
        panel = new JPanel(null);
        login = new JTextField("");
        login.setBounds(50, 30, 200, 40);
        pass = new JTextField("");
        pass.setBounds(50, 90, 200, 40);
        //--------------------------------------
        login.setText("admin");
        pass.setText("admin");
        //--------------------------------------
        registration = new JButton("Регистрация");
        registration.setBounds(50, 140, 200, 30);
        ok = new JButton("Войти!");
        ok.setBounds(260, 65, 100, 50);
        label = new JLabel("");
        label.setBounds(80, 170, 200, 40);
        panel.add(login);
        panel.add(pass);
        panel.add(registration);
        panel.add(ok);
        panel.add(label);
        frame.add(panel);
    }

    public void action() {
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String loginT, passT;
                    loginT = login.getText();
                    ResultSet rs = db.query("Select * from user where login ='" + loginT + "';");
                    System.out.println(rs);
                    if (rs.next()) {
                        System.out.println("0");
                        if (rs.getString(3).equals(pass.getText())) {
                            System.out.println("111");
                            if (rs.getInt(4) == 1) {
                                AdminFrame adminframe = new AdminFrame();
                            }
                            if (rs.getInt(4) == 2) {
                                UserFrame userframe = new UserFrame();
                            }
                        } else {
                            label.setText("Не подходит пароль");
                        }
                    } else {
                        label.setText("Нет такого логина");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StartFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    System.out.println("Нет такого логина " + ex);
                    label.setText("Плохие входные данные!");
                }

            }
        });
        registration.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Registration registration = new Registration();
            }
        });
    }
    private void db(){
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
        db.update("insert into role values (1,'admin')");
        db.update("insert into role values (2,'user')");
        db.update("insert into user values (1,'admin','admin',1)");
        db.update("insert into user values (2,'user','user',2)");
    }
}
