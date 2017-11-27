/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Семён
 */
public interface DAOInterface<T> {

    public void update(T ob);

    public void delete(T ob);

    public void insert(T ob);
}
