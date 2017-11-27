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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class UserFrame {
    public JFrame frame;
    public JPanel panel;
    public JButton create,show;
    private MyTable tableUser;
    private JScrollPane scroll;
    private DB db;
    private JComboBox cbTeam,cbMonth,cbDay;
    private JLabel date,isEmpty,team;
    

    public UserFrame() {
        DB db = new DB("jdbc:mysql://127.0.0.1", "phillip", "password");
        this.db = db;
        db.update("use final");
        ResultSet rs = db.query("select * from user");
        tableUser = new MyTable(rs);
        scroll = new JScrollPane(tableUser);
        scroll.setBounds(20, 150, 260, 250);
        scroll.setVisible(false);
        frame = new JFrame("Окно пользователя");
        frame.setSize(300, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public void initComponents() {
        panel = new JPanel(null);
        create = new JButton("Создать заявку");
        create.setBounds(50, 30, 200, 40);
        show = new JButton("Мои заявки");
        show.setBounds(50, 90, 200, 40);
        cbTeam = new JComboBox();
        cbTeam.setBounds(50, 150, 200, 40);
        cbMonth = new JComboBox();
        cbMonth.setBounds(50,210,90,40);
        cbDay = new JComboBox();
        cbDay.setBounds(160,210,90,40);
        cbTeam.setVisible(false);
        cbMonth.setVisible(false);
        cbDay.setVisible(false);
        cbTeam.addItem("1_Сантехники");
        cbTeam.addItem("2_Слесари");
        cbTeam.addItem("3_Монтажники");
        cbTeam.addItem("4_Плотники");
        cbMonth.addItem("Апрель");
        cbMonth.addItem("Май");
        for (int i = 1; i < 31; i++) {
            cbDay.addItem(i+"");
        }
        panel.add(create);
        panel.add(show);
        panel.add(scroll);
        panel.add(cbTeam);
        panel.add(cbMonth);
        panel.add(cbDay);
        frame.add(panel);
        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                scroll.setVisible(true);
                ResultSet rs = db.query("select * from user");
            }
        });
        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                scroll.setVisible(false);
                cbTeam.setVisible(true);
                cbMonth.setVisible(true);
                cbDay.setVisible(true);
            }
        });
    }
}
