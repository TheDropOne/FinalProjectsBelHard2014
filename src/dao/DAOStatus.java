/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Status;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class DAOStatus {
    //id_status int(3) primary key,status varchar(15))
     private DB db;

    public DAOStatus(DB db) {
        this.db = db;
    }

    public void update(Status ob) {
          try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement(
                    "update status set id_status=?, status=?");
            ps.setInt(1,ob.getId_status());
            ps.setString(2, ob.getStatus());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Status ob) {
       db.update("delete from table status where id ="+ob.getId_status());
    }

    public void insert(Status ob) {
        try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement("insert into status values(?,?)");
            ps.setInt(1,ob.getId_status());
            ps.setString(2, ob.getStatus());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
