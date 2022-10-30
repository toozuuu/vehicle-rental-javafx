/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.MaintenanceDAO;
import lk.ijse.vehicle_rental.entity.Maintenance;

/**
 *
 * @author zoomcoder
 */
public class MaintenanceDAOImpl implements MaintenanceDAO {

    @Override
    public ArrayList<Maintenance> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select *from Maintenance ");
        ArrayList<Maintenance> alMaintenance = new ArrayList<>();
        while (rst.next()) {
            Maintenance maintenance = new Maintenance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getDouble(9)
            );
            alMaintenance.add(maintenance);
        }
        return alMaintenance;
    }

    @Override
    public Maintenance get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Maintenance where MID=?", id);
        Maintenance dtos = null;
        if (rst.next()) {
            dtos = new Maintenance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getDouble(9));
        }
        return dtos;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Maintenance where MID=?", id);
    }

    @Override
    public boolean save(Maintenance entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Maintenance values(?,?,?,?,?,?,?,?,?)",
                entity.getMID(),
                entity.getVehicle_NO(),
                entity.getMaintenance_Company_Name(),
                entity.getCompany_Address(),
                entity.getContact_Number(),
                entity.getAddedOn(),
                entity.getNextDueDate(),
                entity.getPaymentStatus(),
                entity.getAmount());
    }

    @Override
    public boolean update(Maintenance entity) throws Exception {
        return CrudUtil.executeUpdate("update Maintenance set Vehicle_No=?,Company_Name=?,Company_Address=?,Contact_Number=?,AddedOn=?,NextDueDate=?,PaymentStatus=?,Amount=? where MID=?",
                entity.getVehicle_NO(),
                entity.getMaintenance_Company_Name(),
                entity.getCompany_Address(),
                entity.getContact_Number(),
                entity.getAddedOn(),
                entity.getNextDueDate(),
                entity.getPaymentStatus(),
                entity.getAmount(),
                entity.getMID());
    }

    @Override
    public String getVehicleNo(String id) throws Exception {
        ResultSet set = CrudUtil.executeQuery("select Vehicle_No from Vehicle");
        String vehicleNO = null;
        while (set.next()) {
            vehicleNO = set.getString(1);

        }
        return vehicleNO;
        
    }

    @Override
    public String[] search(String id) throws Exception {
          
        ResultSet rst = CrudUtil.executeQuery("select * from Maintenance where Vehicle_No=? ",id);
        
        if (rst.next()) {
            String[] maintenance = {
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
             return maintenance;
        }
        return null;
         }

    @Override
    public String[] getMaintenanceReport(String id) throws Exception {
        
        ResultSet rst = CrudUtil.executeQuery("select * from Maintenance where AddedOn between AddedOn=? and AddedOn=? ",id);
        
        if (rst.next()) {
            String[] maintenance = {
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
             return maintenance;
        }
        return null;
         }

    }



