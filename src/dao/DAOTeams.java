/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Teams;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySQL.DB;

/**
 *
 * @author Семён
 */
public class DAOTeams {
    //id_teams int(3) primary key, type int(3),team_status int(3)
     private DB db;

    public DAOTeams(DB db) {
        this.db = db;
    }

    public void update(Teams ob) {
          try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement(
                    "update teams set id_teams=?, type=?, team_status =?");
            ps.setInt(1,ob.getId_Teams());
            ps.setInt(2, ob.getType());
            ps.setInt(3, ob.getTeam_status());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOTeams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Teams ob) {
       db.update("delete from table teams where id ="+ob.getId_Teams());
    }

    public void insert(Teams ob) {
        try {
            PreparedStatement ps =(PreparedStatement) db.getCn().prepareStatement("insert into teams values(?,?,?)");
            ps.setInt(1,ob.getId_Teams());
            ps.setInt(2, ob.getType());
            ps.setInt(3, ob.getTeam_status());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOTeams.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
