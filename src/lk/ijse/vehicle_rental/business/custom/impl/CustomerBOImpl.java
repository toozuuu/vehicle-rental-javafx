/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.custom.CustomerBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.CustomerDAO;
import lk.ijse.vehicle_rental.dto.CustomerDTO;
import lk.ijse.vehicle_rental.entity.Customer;

/**
 *
 * @author zoomcoder
 */
public class CustomerBOImpl implements CustomerBO{
    
    private CustomerDAO customerDAO; 
    
    public CustomerBOImpl(){
        customerDAO=(CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }

    @Override
    public boolean saveCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.save(new Customer(customer.getNIC(), customer.getPassport_ID(), customer.getName(), customer.getAddress(), customer.getDOB(), customer.getCphone(), customer.getGender(), customer.getLicense_No(), customer.getCountry()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.update(new Customer(customer.getNIC(), customer.getPassport_ID(), customer.getName(), customer.getAddress(), customer.getDOB(), customer.getCphone(), customer.getGender(), customer.getLicense_No(), customer.getCountry()));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
            ArrayList<Customer> alCustomer=customerDAO.getAll();
            ArrayList<CustomerDTO> dtos=new ArrayList<>();
            
            for(Customer customer: alCustomer){
                dtos.add(new CustomerDTO(customer.getNIC(), customer.getPassport_ID(), customer.getName(), customer.getAddress(), customer.getDOB(), customer.getCphone(), customer.getGender(), customer.getLicense_No(), customer.getCountry()));
            }
            return dtos;
    }

    @Override
    public String[] searchCustomer(String id) throws Exception {
        return customerDAO.search(id);
    }

    

    
    
}
