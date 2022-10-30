/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.custom.DriverBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.DriverDAO;
import lk.ijse.vehicle_rental.dto.DriverDTO;
import lk.ijse.vehicle_rental.entity.Driver;

/**
 *
 * @author Sachin Dilshan
 */
public class DriverBOImpl implements DriverBO {

    private DriverDAO driverDAO;

    public DriverBOImpl() {
        driverDAO = (DriverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVER);
    }

    @Override
    public boolean saveDriver(DriverDTO driver) throws Exception {
        return driverDAO.save(new Driver(
                driver.getDID(),
                driver.getLicense_No(),
                driver.getDname(),
                driver.getDphone()));
    }

    @Override
    public boolean updateDriver(DriverDTO driver) throws Exception {
        return driverDAO.update(new Driver(
                driver.getDID(),
                driver.getLicense_No(),
                driver.getDname(),
                driver.getDphone()));
    }

    @Override
    public boolean deleteDriver(String id) throws Exception {
        return driverDAO.delete(id);
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() throws Exception {

        ArrayList<Driver> allDriver = driverDAO.getAll();

        ArrayList<DriverDTO> dtos = new ArrayList<>();

        for (Driver driver : allDriver) {
            dtos.add(new DriverDTO(
                    driver.getDID(),
                    driver.getLicense_No(),
                    driver.getDname(),
                    driver.getDphone()
            ));
        }

        return dtos;
    }

    @Override
    public String[] searchDriver(String id) throws Exception {
        return driverDAO.search(id);
    }

}
