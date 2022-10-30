/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.SuperBO;
import lk.ijse.vehicle_rental.dto.CustomerDTO;

/**
 *
 * @author zoomcoder
 */
public interface CustomerBO extends SuperBO{
    public boolean saveCustomer(CustomerDTO user )throws Exception;
    public boolean updateCustomer(CustomerDTO user )throws Exception;
    public boolean deleteCustomer(String id )throws Exception;

    public ArrayList<CustomerDTO> getAllCustomers()throws Exception;
    public String[]  searchCustomer(String id)throws Exception;
}
