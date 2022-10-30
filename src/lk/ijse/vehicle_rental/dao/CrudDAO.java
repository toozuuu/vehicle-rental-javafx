/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao;

import java.util.ArrayList;

/**
 *
 * @author zoomcoder
 * @param <T>
 * @param <ID>
 */
public interface CrudDAO<T,ID> extends SuperDAO {
    
    public ArrayList<T> getAll() throws Exception;
    
    public T get(ID id) throws Exception;
    
    public boolean delete(ID id)throws Exception;
    
    public boolean save(T entity)throws Exception;
    
    public boolean update(T entity)throws Exception;
    
    public String[] search(ID id)throws Exception;
}
