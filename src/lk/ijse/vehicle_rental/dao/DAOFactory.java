/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao;


import lk.ijse.vehicle_rental.dao.custom.impl.CategoryDAOImpl;
import lk.ijse.vehicle_rental.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.vehicle_rental.dao.custom.impl.DriverDAOImpl;
import lk.ijse.vehicle_rental.dao.custom.impl.FuelDAOImpl;
import lk.ijse.vehicle_rental.dao.custom.impl.MaintenanceDAOImpl;
import lk.ijse.vehicle_rental.dao.custom.impl.QueryDAOImpl;
import lk.ijse.vehicle_rental.dao.custom.impl.VehicleDAOImpl;





/**
 *
 * @author zoomcoder
 */
public class DAOFactory {
    
    public enum DAOTypes{
        CUSTOMER,DRIVER,RESERVATION_DETAIL,PAYMENT,VEHICLE,BLACKLIST,MAINTENANCE,QUERY,ADMIN,RESERVATION,CATEGORY,FUEL;
        }
    private static DAOFactory dAOFactory;

    public DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if(dAOFactory==null){
            dAOFactory=new DAOFactory();
        
        }return dAOFactory;      
 }
    
    public SuperDAO getDAO(DAOTypes types){
        switch(types){
            case DRIVER :
                return new DriverDAOImpl();
                
                 
             case QUERY :
                 return new QueryDAOImpl();
                 
             case CUSTOMER :
                 return  new CustomerDAOImpl();
                 
             case VEHICLE :
                 return  new VehicleDAOImpl();
                 
             case MAINTENANCE :
                 return  new MaintenanceDAOImpl();
             case CATEGORY :
                 return  new CategoryDAOImpl();
                 
             case FUEL :
                 return new FuelDAOImpl();
            
                 
          
          
            default :
                return null;
                
        
        
        }
    }
    
}
