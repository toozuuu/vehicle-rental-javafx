/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.VehicleDAO;
import lk.ijse.vehicle_rental.entity.Vehicle;

/**
 *
 * @author zoomcoder
 */
public class VehicleDAOImpl implements VehicleDAO {

    @Override
    public ArrayList<Vehicle> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select *from Vehicle");
        ArrayList<Vehicle> alVehicle = new ArrayList<>();
        while (rst.next()) {
            Vehicle vehicle = new Vehicle(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getInt(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getDouble(10)
            );
            alVehicle.add(vehicle);
        }
        return alVehicle;
    }

    @Override
    public Vehicle get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select *from Vehicle where Vehicle_No=?", id);
        Vehicle v = null;
        if (rst.next()) {
            v = new Vehicle(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getInt(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getDouble(10)
            );

        }
        return v;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Vehicle where Vehicle_No=?", id);
    }

    @Override
    public boolean save(Vehicle entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Vehicle values(?,?,?,?,?,?,?,?,?,?)",
                entity.getVehicle_No(),
                entity.getCID(),
                entity.getBrand(),
                entity.getModel(),
                entity.getGearbox(),
                entity.getFID(),
                entity.getMax_Passengers(),
                entity.getDoors(),
                entity.getColor(),
                entity.getPrice_Per_Day());

    }

    @Override
    public boolean update(Vehicle entity) throws Exception {
        return CrudUtil.executeUpdate("update Vehicle set CID=?,Brand=?,Model=?,Gearbox=?,Fuel=?,Max_Passengers=?,Doors=?,Color=?,Price_Per_Day=? where Vehicle_No=?",
                entity.getVehicle_No(),
                entity.getCID(),
                entity.getBrand(),
                entity.getModel(),
                entity.getGearbox(),
                entity.getFID(),
                entity.getMax_Passengers(),
                entity.getDoors(),
                entity.getColor(),
                entity.getPrice_Per_Day()
        );
    }

    @Override
    public String[] search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Vehicle where Vehicle_No = ?", id);

        if (rst.next()) {
            String[] vehicle = {
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5),
                rst.getString(6),
                rst.getString(7),
                rst.getString(8),
                rst.getString(9),
                rst.getString(10)

            };
            return vehicle;
        }
        return null;
    }

    

    @Override
    public String getFuel(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select Fuel from Vehicle");
        String fuel = null;
        while (rst.next()) {
            fuel = rst.getString(1);

        }
        return fuel;
    }

    @Override
    public String getBrand(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select Brand from Vehicle");
        String brand = null;
        while (rst.next()) {
            brand = rst.getString(1);

        }
        return brand;
    }

    @Override
    public Vehicle rentVehicle(Vehicle vehicle) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("");
        
        if (rst.next()) {
             vehicle =new Vehicle(
            
             rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5),
                rst.getString(6),
                rst.getInt(7),
                rst.getInt(8),
                rst.getString(9),
                rst.getDouble(10)
            
            
            
            );
               

         
            return vehicle;
      
    }
        return null;
        

    }



}


