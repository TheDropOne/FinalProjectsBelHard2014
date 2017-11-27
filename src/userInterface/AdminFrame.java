/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class AdminFrame {
     public JFrame frame;
    public JPanel panel;
    public JButton plan,teams,list;
    private MyTable tableUser;
    private JScrollPane scroll;
    private DB db;
    
    public AdminFrame() {
        DB db = new DB("jdbc:mysql://127.0.0.1", "phillip", "password");
        this.db = db;
        db.update("use final");
        ResultSet rs = db.query("select * from user");
        tableUser = new MyTable(rs);
        scroll = new JScrollPane(tableUser);
        scroll.setBounds(50, 210, 200, 150);
        scroll.setVisible(false);
        frame = new JFrame("Окно администратора");
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        action();
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public void initComponents() {
        panel = new JPanel(null);
        plan = new JButton("План");
        plan.setBounds(50, 30, 200, 40);
        teams = new JButton("Бригады");
        teams.setBounds(50, 90, 200, 40);
        list = new JButton("Список пользователей");
        list.setBounds(50,150,200,40);
        panel.add(scroll);
        panel.add(list);
        panel.add(plan);
        panel.add(teams);
        frame.add(panel);
        
    }
    public void action(){
        list.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setSize(300,400);
                scroll.setVisible(true);
            }
        });
    }
}
