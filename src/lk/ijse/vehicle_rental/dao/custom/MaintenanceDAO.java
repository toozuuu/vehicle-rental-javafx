/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom;

import lk.ijse.vehicle_rental.dao.CrudDAO;
import lk.ijse.vehicle_rental.entity.Maintenance;

/**
 *
 * @author zoomcoder
 */
public interface MaintenanceDAO  extends CrudDAO<Maintenance, String>{
    
    public String getVehicleNo(String id) throws Exception;
    public String[] getMaintenanceReport(String id) throws Exception;
   
}
