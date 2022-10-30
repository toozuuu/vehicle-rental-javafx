/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom;

import lk.ijse.vehicle_rental.dao.CrudDAO;
import lk.ijse.vehicle_rental.entity.Vehicle;

/**
 *
 * @author zoomcoder
 */
public interface VehicleDAO extends CrudDAO<Vehicle, String>{
      
 
   
    
    public String getFuel(String id) throws Exception;
 
    public String getBrand(String id) throws Exception;

    public Vehicle rentVehicle(Vehicle vehicle)throws Exception;
    
    

}
