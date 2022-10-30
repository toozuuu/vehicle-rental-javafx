/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.DriverDAO;
import lk.ijse.vehicle_rental.entity.Driver;

/**
 *
 * @author zoomcoder
 */
 public class DriverDAOImpl implements DriverDAO {

    @Override
    public boolean save(Driver driver) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Driver VALUES (?,?,?,?)", driver.getDID(), driver.getLicense_No(),
                driver.getDname(), driver.getDphone());
    }

    @Override
    public boolean update(Driver driver) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Driver SET License_No=? ,Dname=?, Dphone=? WHERE DID=?", driver.getLicense_No(),
                driver.getDname(), driver.getDphone(), driver.getDID());

    }

    @Override
    public ArrayList<Driver> getAll() throws Exception {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Driver");

        ArrayList<Driver> alDrivers = new ArrayList<>();

        while (rst.next()) {
            Driver driver = new Driver(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            alDrivers.add(driver);
        }

        return alDrivers;
    }

    @Override
    public Driver get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Driver WHERE DID=?", id);

        Driver driver = null;

        if (rst.next()) {
            driver = new Driver(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3), rst.getString(4));
        }

        return driver;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Driver where DID=?", id);

    }

    @Override
    public String[] search(String id) throws Exception {
       
        ResultSet rst = CrudUtil.executeQuery("select * from Driver where License_No =? ",id) ;
        
        if (rst.next()) {
            String[] driver = {
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
                    
                              
            };
             return driver;
        }
        return null;
         }
}
