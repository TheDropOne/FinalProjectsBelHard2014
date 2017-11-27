/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import entity.Orders;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class DAOOrders {
    //(id_order int(3) primary key, id_user int(3),type int(3),date DATE,checked int(3))");
     private DB db;

    public DAOOrders(DB db) {
        this.db = db;
    }

    public void update(Orders ob) {
          try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement(
                    "update orders set id_order=?, id_user=?, type =?, date=?");
            ps.setInt(1,ob.getId_order());
            ps.setInt(2, ob.getId_user());
            ps.setInt(3, ob.getType());
            ps.setString(4, ob.getDate());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Orders ob) {
       db.update("delete from table orders where id ="+ob.getId_order());
    }

    public void insert(Orders ob) {
        try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement("insert into orders values(?,?,?,?)");
            ps.setInt(1,ob.getId_order());
            ps.setInt(2, ob.getId_user());
            ps.setInt(3, ob.getType());
            ps.setString(4, ob.getDate());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
