/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Plan;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class DAOPlan {
    //id_plan int(3) primary key, order int(3), id_team int(3)
     private DB db;

    public DAOPlan(DB db) {
        this.db = db;
    }

    public void update(Plan ob) {
          try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement(
                    "update plan set id_plan=?, id_order=?, id_team =?");
            ps.setInt(1,ob.getId_plan());
            ps.setInt(2, ob.getId_order());
            ps.setInt(3, ob.getId_team());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Plan ob) {
       db.update("delete from table plan where id ="+ob.getId_plan());
    }

    public void insert(Plan ob) {
        try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement("insert into plan values(?,?,?)");
            ps.setInt(1,ob.getId_plan());
            ps.setInt(2, ob.getId_order());
            ps.setInt(3, ob.getId_team());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
