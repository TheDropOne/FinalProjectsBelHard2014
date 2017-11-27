/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Role;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import mySQL.DB;

/**
 * @author Семён
 */
public class DAORole {
    //id_role int(3) primary key,name varchar(15))
    private DB db;

    public DAORole(DB db) {
        this.db = db;
    }

    public void update(Role ob) {
        try {
            PreparedStatement ps = (PreparedStatement) db.getCn().prepareStatement(
                    "update role set id_role=?, name=?");
            ps.setInt(1, ob.getId_role());
            ps.setString(2, ob.getName());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Role ob) {
        db.update("delete from table role where id =" + ob.getId_role());
    }

    public void insert(Role ob) {
        try {
            PreparedStatement ps = (PreparedStatement) db.getCn().prepareStatement("insert into role values(?,?)");
            ps.setInt(1, ob.getId_role());
            ps.setString(2, ob.getName());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
