/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Type;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class DAOType {
    //id_type int(3) primary key, name varchar(15))"
     private DB db;

    public DAOType(DB db) {
        this.db = db;
    }

    public void update(Type ob) {
          try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement(
                    "update type set id_type=?, name=?");
            ps.setInt(1,ob.getId_type());
            ps.setString(2, ob.getName());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOType.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Type ob) {
       db.update("delete from table type where id ="+ob.getId_type());
    }

    public void insert(Type ob) {
        try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement("insert into type values(?,?)");
            ps.setInt(1,ob.getId_type());
            ps.setString(2, ob.getName());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOType.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
