/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import dao.DAOUser;
import entity.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class Registration {

    public JFrame frame;
    public JPanel panel;
    public JTextField login, pass;
    public JButton ok;
    private DB db;
    private ResultSet rs2;
    private int a = 0;

    public Registration() {
        frame = new JFrame("Регистрация");
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        action();
        frame.setVisible(true);

    }

    public void initComponents() {
        DB db = new DB("jdbc:mysql://127.0.0.1/final", "phillip", "password");
        this.db = db;
        panel = new JPanel(null);
        login = new JTextField("");
        login.setBounds(50, 30, 200, 40);
        pass = new JTextField("");
        pass.setBounds(50, 90, 200, 40);
        ok = new JButton("Зарегистрироваться!");
        ok.setBounds(50, 140, 200, 50);
        panel.add(login);
        panel.add(pass);
        panel.add(ok);
        frame.add(panel);
    }

    public void action() {
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String loginT, passT;
                loginT = login.getText();
                passT = pass.getText();
                try {
                    DAOUser dao = new DAOUser(db);
                    a = 0;
                    nullPointer();
                    System.out.println(a);
                    if (a == 0) {
                        ResultSet rs = (db.query("Select MAX(id_user) from user"));
                        int id = 0;
                        if (rs.next()) {
                            id = rs.getInt(1);
                        }
                        try {
                            dao.insert(new User(id + 1, loginT, passT, 2));
                            frame.dispose();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(panel, "Введи нормальный пароль!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(panel, "Такой логин уже занят");
                    }
                } catch (SQLException ex) {
                    System.out.println("Ошибка при регистрации" + ex);
                }
            }
        }
        );
    }

    private void nullPointer() {
        try {
            rs2 = db.query("Select * from user where login ='" + login.getText() + "';");
            if (rs2.next()) {
                this.a = 1;
            }
        } catch (Exception ex) {
            System.out.println("null" + ex);
        }
    }

}
