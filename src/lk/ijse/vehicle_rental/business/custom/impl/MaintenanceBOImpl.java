/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.custom.MaintenanceBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.MaintenanceDAO;
import lk.ijse.vehicle_rental.dto.MaintenanceDTO;
import lk.ijse.vehicle_rental.entity.Maintenance;

/**
 *
 * @author zoomcoder
 */
public class MaintenanceBOImpl  implements MaintenanceBO{
    private MaintenanceDAO maintenanceDAO;

    public MaintenanceBOImpl() {
        maintenanceDAO=(MaintenanceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MAINTENANCE);
    }
    

    @Override
    public boolean saveMaintenance(MaintenanceDTO maintenance) throws Exception {
        return maintenanceDAO.save(new Maintenance(
                maintenance.getMID(), 
                maintenance.getVehicle_NO(),
                maintenance.getMaintenance_Company_Name(), 
                maintenance.getCompany_Address(), 
                maintenance.getContact_Number(), 
                maintenance.getAddedOn(),
                maintenance.getNextDueDate(),
                maintenance.getPaymentStatus(),
                maintenance.getAmount()));
    }

    @Override
    public boolean updateMaintenance(MaintenanceDTO maintenance) throws Exception {
     return  maintenanceDAO.update(new Maintenance(
                maintenance.getMID(), 
                maintenance.getVehicle_NO(),
                maintenance.getMaintenance_Company_Name(), 
                maintenance.getCompany_Address(), 
                maintenance.getContact_Number(), 
                maintenance.getAddedOn(),
                maintenance.getNextDueDate(),
                maintenance.getPaymentStatus(),
                maintenance.getAmount()));
        
    }

    @Override
    public boolean removeMaintenance(String itemCode) throws Exception {
       return  maintenanceDAO.delete(itemCode);
    }

    @Override
    public ArrayList<MaintenanceDTO> getAllMaintenance() throws Exception {
        ArrayList<Maintenance> alMaintenance= maintenanceDAO.getAll();
        ArrayList<MaintenanceDTO> dtos=new ArrayList<>();
        for(Maintenance maintenance : alMaintenance){
            dtos.add(new MaintenanceDTO(
                maintenance.getMID(), 
                maintenance.getVehicle_NO(),
                maintenance.getMaintenance_Company_Name(), 
                maintenance.getCompany_Address(), 
                maintenance.getContact_Number(), 
                maintenance.getAddedOn(),
                maintenance.getNextDueDate(),
                maintenance.getPaymentStatus(),
                maintenance.getAmount()));
        
        }return  dtos;
    }

    @Override
    public String getVehicleNo(String id) throws Exception {
         return maintenanceDAO.getVehicleNo(id);
    }

    @Override
    public String[] searchMaintenance(String id) throws Exception {
        return  maintenanceDAO.search(id);
    }

    @Override
    public String[] getMaintenanceReport(String id) throws Exception {
        return  maintenanceDAO.getMaintenanceReport(id);
    }
    
}
