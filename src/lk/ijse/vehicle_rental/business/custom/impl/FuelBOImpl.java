/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.custom.FuelBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.FuelDAO;
import lk.ijse.vehicle_rental.dto.FuelDTO;
import lk.ijse.vehicle_rental.entity.Fuel;

/**
 *
 * @author zoomcoder
 */
public class FuelBOImpl implements FuelBO {

    private FuelDAO fuelDAO;

    public FuelBOImpl() {
        fuelDAO = (FuelDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FUEL);
    }

    @Override
    public ArrayList<FuelDTO> getAllFuel() throws Exception {
        ArrayList<Fuel> alFuel = fuelDAO.getAll();
        ArrayList<FuelDTO> dtos = new ArrayList<>();
        for (Fuel fuel : alFuel) {
            dtos.add(new FuelDTO(fuel.getFID(), fuel.getFuelName()));
        }
        return dtos;
    }

    @Override
    public String getFualID(String FualNAme) throws Exception {
        return fuelDAO.getFualID(FualNAme);
    }

}
