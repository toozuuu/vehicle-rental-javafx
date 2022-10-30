/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.vehicle_rental.db.DBConnection;
import lk.ijse.vehicle_rental.business.custom.RentBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.CustomerDAO;
import lk.ijse.vehicle_rental.dao.custom.DriverDAO;
import lk.ijse.vehicle_rental.dao.custom.PaymentDAO;
import lk.ijse.vehicle_rental.dao.custom.Reservation_DetailDAO;
import lk.ijse.vehicle_rental.dao.custom.VehicleDAO;
import lk.ijse.vehicle_rental.dto.CustomerDTO;
import lk.ijse.vehicle_rental.dto.DriverDTO;
import lk.ijse.vehicle_rental.dto.PaymentDTO;
import lk.ijse.vehicle_rental.dto.Reservation_DetailDTO;
import lk.ijse.vehicle_rental.dto.VehicleDTO;
import lk.ijse.vehicle_rental.entity.Customer;

/**
 *
 * @author zoomcoder
 */
public class RentBOImpl implements RentBO{
    
    CustomerDAO customerDAO;
    VehicleDAO vehicleDAO;
    PaymentDAO paymentDAO;
    DriverDAO driverDAO;
    Reservation_DetailDAO reservation_DetailDAO;

    public RentBOImpl() {
        customerDAO= (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        vehicleDAO=(VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLE);
        paymentDAO=(PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
        driverDAO=(DriverDAO) (DriverDTO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVER);
        reservation_DetailDAO=(Reservation_DetailDAO) (Reservation_DetailDTO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION_DETAIL);
    }
    
    

    @Override
    public boolean purchaseOrder(CustomerDTO cdtos, VehicleDTO vdtos, PaymentDTO pdtos, DriverDTO dtos, ArrayList<Reservation_DetailDTO> allOrders) throws Exception {
        Connection  connection=DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        
        Customer customerTemp=new Customer();
        customerTemp.setNIC(cdtos.getNIC());
        customerTemp.setPassport_ID(cdtos.getPassport_ID());
        customerTemp.setName(cdtos.getName());
        customerTemp.setAddress(cdtos.getAddress());
        customerTemp.setDOB(cdtos.getDOB());
        customerTemp.setCphone(cdtos.getCphone());
        customerTemp.setGender(cdtos.getGender());
        customerTemp.setLicense_No(cdtos.getLicense_No());
        customerTemp.setCountry(cdtos.getCountry());
        boolean add=customerDAO.save(customerTemp);
        if (add) {
           // for(VehicleDTO alVehicle:)
        }
        return false;

    }
    
}
