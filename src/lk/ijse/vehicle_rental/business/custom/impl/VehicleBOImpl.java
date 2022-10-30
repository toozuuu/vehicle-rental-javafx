/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.custom.VehicleBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.VehicleDAO;
import lk.ijse.vehicle_rental.dto.VehicleDTO;
import lk.ijse.vehicle_rental.entity.Vehicle;



/**
 *
 * @author zoomcoder
 */
public class VehicleBOImpl implements VehicleBO{
    private VehicleDAO vehicleDAO;
    
    private Vehicle vehicle;

    public VehicleBOImpl() {
        vehicleDAO=(VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLE);
    }
    

   @Override
    public boolean saveVehicle(VehicleDTO vehicleDTO) throws Exception {
        return vehicleDAO.save(new Vehicle(
                vehicleDTO.getVehicle_No(),
                vehicleDTO.getCID(),
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getGearbox(),
                vehicleDTO.getFID(),
                vehicleDTO.getMax_Passengers(),
                vehicleDTO.getDoors(),
                vehicleDTO.getColor(),
                vehicleDTO.getPrice_Per_Day()
               ));
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws Exception {
       return vehicleDAO.update(new Vehicle(
                vehicleDTO.getVehicle_No(),
                vehicleDTO.getCID(),
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getGearbox(),
                vehicleDTO.getFID(),
                vehicleDTO.getMax_Passengers(),
                vehicleDTO.getDoors(),
                vehicleDTO.getColor(),
                vehicleDTO.getPrice_Per_Day()
                ));
    }

    @Override
    public boolean removeVehicle(String itemCode) throws Exception {
       return vehicleDAO.delete(itemCode);
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() throws Exception {
          ArrayList<Vehicle> alVehicle = vehicleDAO.getAll();

        ArrayList<VehicleDTO> dtos = new ArrayList<>();

        for (Vehicle vehicleDTO : alVehicle) {
            dtos.add(new VehicleDTO(
                vehicleDTO.getVehicle_No(),
                vehicleDTO.getCID(),
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getGearbox(),
                vehicleDTO.getFID(),
                vehicleDTO.getMax_Passengers(),
                vehicleDTO.getDoors(),
                vehicleDTO.getColor(),
                vehicleDTO.getPrice_Per_Day()
              
            
                ));

        }

        return dtos;

    }


   


    @Override
    public String getFuel(String id) throws Exception {
       return  vehicleDAO.getFuel(id);
    }

    
    @Override
    public String getVehicleBrand(String id) throws Exception {
        return vehicleDAO.getBrand(id);
    }

    @Override
    public String[] searchVehicle(String id) throws Exception {
       return  vehicleDAO.search(id);
    }

 

    @Override
    public void rentVehicle(VehicleDTO vehicleDTO) throws Exception {
        vehicle=new Vehicle(vehicleDTO.getCID(),vehicle.getFID());
        vehicleDAO.rentVehicle(vehicle);
    }

   

   

 

   
    
}
