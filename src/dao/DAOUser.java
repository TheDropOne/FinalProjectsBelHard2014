/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import entity.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class DAOUser {
    //id_user int(3) primary key, login varchar(30),pass varchar(16),role int(3)
    private DB db;

    public DAOUser(DB db) {
        this.db = db;
    }

    public void update(User ob) {
          try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement(
                    "update user set id_user=?, login=?, pass =?, role=?");
            ps.setInt(1,ob.getId_user());
            ps.setString(2, ob.getLogin());
            ps.setString(3, ob.getPass());
            ps.setInt(4, ob.getRole());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(User ob) {
       db.update("delete from table user where id ="+ob.getId_user());
    }

    public void insert(User ob) {
        try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement("insert into user values(?,?,?,?)");
             ps.setInt(1,ob.getId_user());
            ps.setString(2, ob.getLogin());
            ps.setString(3, ob.getPass());
            ps.setInt(4, ob.getRole());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
