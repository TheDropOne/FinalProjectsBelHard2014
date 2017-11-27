/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Семён
 */
public class Teams {
    //id_teams int(3) primary key, type int(3),team_status int(3)
    private int id_teams;
    private int type;
    private int team_status;
    
    public Teams() {

    }

    public Teams(int id_teams,int type, int team_status) {
        this.id_teams = id_teams;
        this.type = type;
        this.team_status= team_status;
    }

    public int getId_Teams() {
        return id_teams;
    }

    public void setId_Teams(int id_teams) {
        this.id_teams = id_teams;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public int getTeam_status() {
        return team_status;
    }

    public void setTeam_status(int team_status) {
        this.team_status = team_status;
    }
    
}
