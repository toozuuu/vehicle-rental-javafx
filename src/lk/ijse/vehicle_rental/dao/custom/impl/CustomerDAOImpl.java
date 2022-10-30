/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.CustomerDAO;
import lk.ijse.vehicle_rental.entity.Customer;

/**
 *
 * @author zoomcoder
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from Customer");
        ArrayList<Customer> alCustomer = new ArrayList<>();

        while (rst.next()) {
            Customer customer = new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)
            );
            alCustomer.add(customer);
        }
        return alCustomer;

    }

    @Override
    public Customer get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Customer where NIC=?", id);
        Customer dtos = null;

        if (rst.next()) {
            dtos = new Customer(
                    rst.getString(1), 
                    rst.getString(2),
                    rst.getString(3), 
                    rst.getString(4),
                    rst.getString(5), 
                    rst.getString(6), 
                    rst.getString(7), 
                    rst.getString(8), 
                    rst.getString(9));

        }
        return dtos;

    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Customer where NIC=?", id);
    }

    @Override
    public boolean save(Customer entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Customer values (?,?,?,?,?,?,?,?,?)", 
                entity.getNIC(),
                entity.getPassport_ID(),
                entity.getName(), 
                entity.getAddress(), 
                entity.getDOB(), 
                entity.getCphone(), 
                entity.getGender(),
                entity.getLicense_No(), 
                entity.getCountry());

    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return CrudUtil.executeUpdate("update Customer set Passport_ID=?,Name=?,Address=?,DOB=?,Cphone=?,Gender=?,License_No=?,Country=? where NIC=?", 
                entity.getPassport_ID(), 
                entity.getName(),
                entity.getAddress(), 
                entity.getDOB(),
                entity.getCphone(), 
                entity.getGender(),
                entity.getLicense_No(), 
                entity.getCountry(), 
                entity.getNIC());
    }

    @Override
    public String[] search(String id) throws Exception {
       
        ResultSet rst = CrudUtil.executeQuery("select * from Customer where NIC = ?",id);
        
        if (rst.next()) {
            String[] customer = {
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)
                              
            };
             return customer;
        }
        return null;
    }

}
