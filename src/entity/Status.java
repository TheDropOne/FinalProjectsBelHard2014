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
public class Status {
    //db.update("create table status(id_status int(3) primary key,status varchar(15))")
        private int id_status;
    private String status;

    public Status() {

    }

    public Status(int id_status, String status) {
        this.id_status = id_status;
        this.status = status;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}