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
public class Orders {
    //order(id_order int(3) primary key, id_user int(3),type int(3),date DATE,checked int(3)
    private int id_order;
    private int id_user;
    private int type;
    private String date;
    private int checked;

    public Orders() {

    }

    public Orders(int id_order, int id_user, int type,String date,int checked) {
        this.id_order = id_order;
        this.id_user = id_user;
        this.type = type;
        this.date = date;
        this.checked = checked;
    }
    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int  getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
}
