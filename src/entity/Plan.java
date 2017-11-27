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
public class Plan {
    //id_plan int(3) primary key, order int(3), id_team int(3)
    private int id_plan;
    private int id_order;
    private int id_team;

    public Plan() {

    }

    public Plan(int id_plan,int id_order, int id_team) {
        this.id_plan = id_plan;
        this.id_order = id_order;
        this.id_team = id_team;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_Plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int order) {
        this.id_order = order;
    }
    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }
    
}
