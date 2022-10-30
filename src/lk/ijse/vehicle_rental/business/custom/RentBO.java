/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.dto.CustomerDTO;
import lk.ijse.vehicle_rental.dto.DriverDTO;
import lk.ijse.vehicle_rental.dto.PaymentDTO;
import lk.ijse.vehicle_rental.dto.Reservation_DetailDTO;
import lk.ijse.vehicle_rental.dto.VehicleDTO;

/**
 *
 * @author zoomcoder
 */
public interface RentBO {
          public boolean purchaseOrder(CustomerDTO cdtos,VehicleDTO vdtos,PaymentDTO pdtos,DriverDTO dtos,ArrayList<Reservation_DetailDTO> allOrders)throws Exception;

}
