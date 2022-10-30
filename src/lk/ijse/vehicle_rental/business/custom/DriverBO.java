/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.SuperBO;
import lk.ijse.vehicle_rental.dto.DriverDTO;

/**
 *
 * @author zoomcoder
 */
public interface DriverBO extends SuperBO {

    public boolean saveDriver(DriverDTO driver) throws Exception;

    public boolean updateDriver(DriverDTO customer) throws Exception;

    public boolean deleteDriver(String id) throws Exception;

    public ArrayList<DriverDTO> getAllDrivers() throws Exception;

    public String[] searchDriver(String id) throws Exception;

   

}
