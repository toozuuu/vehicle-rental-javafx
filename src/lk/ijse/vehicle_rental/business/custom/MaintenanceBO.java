/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.SuperBO;
import lk.ijse.vehicle_rental.dto.MaintenanceDTO;

/**
 *
 * @author zoomcoder
 */
public interface MaintenanceBO extends SuperBO{
        public boolean saveMaintenance(MaintenanceDTO maintenance) throws Exception;

        public boolean updateMaintenance(MaintenanceDTO maintenance) throws Exception;

        public boolean removeMaintenance(String itemCode) throws Exception;

        public ArrayList<MaintenanceDTO> getAllMaintenance() throws Exception;

        public String getVehicleNo(String id) throws Exception;
        
        public String[]  searchMaintenance(String id) throws Exception;
        
        public String[] getMaintenanceReport(String id) throws Exception;
}
