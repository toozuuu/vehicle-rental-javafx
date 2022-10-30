/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.SuperBO;
import lk.ijse.vehicle_rental.dto.VehicleDTO;

/**
 *
 * @author zoomcoder
 */
public interface VehicleBO extends SuperBO{
    
    public boolean saveVehicle(VehicleDTO vehicleDTO) throws Exception;
   
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws Exception;

    public boolean removeVehicle(String itemCode) throws Exception;
    
    public ArrayList<VehicleDTO> getAllVehicle() throws Exception;
    
    public String getVehicleBrand(String id) throws Exception;
    
    public String getFuel(String id) throws Exception;

    public String[] searchVehicle(String id)throws Exception;

    public void rentVehicle(VehicleDTO vehicleDTO)throws Exception;
    
    


}
