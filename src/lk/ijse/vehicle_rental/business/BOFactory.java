/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business;


import lk.ijse.vehicle_rental.business.custom.impl.CategoryBOImpl;
import lk.ijse.vehicle_rental.business.custom.impl.CustomerBOImpl;
import lk.ijse.vehicle_rental.business.custom.impl.DriverBOImpl;
import lk.ijse.vehicle_rental.business.custom.impl.FuelBOImpl;
import lk.ijse.vehicle_rental.business.custom.impl.MaintenanceBOImpl;
import lk.ijse.vehicle_rental.business.custom.impl.VehicleBOImpl;


/**
 *
 * @author zoomcoder
 */
public class BOFactory {
    
    public enum BOTypes{
            CUSTOMER,DRIVER,RESERVATION_DETAIL,PAYMENT,VEHICLE,BLACKLIST,MAINTENANCE, QUERY,ADMIN,RESERVATION,CATEGORY,FUEL;

    }
    
    public static BOFactory boFactory;

    public BOFactory() {
    }
    
   public static BOFactory getInstance(){
       
       if(boFactory==null){
           boFactory=new BOFactory();
       }return boFactory;
   }
   
   public SuperBO getBO(BOTypes type){
       
       switch(type){
            
            case DRIVER :
                return new DriverBOImpl();
                            
            case CUSTOMER :
                
                return new CustomerBOImpl();
                
             case VEHICLE :
                 return  new VehicleBOImpl();
                 
             case MAINTENANCE :
                 return  new MaintenanceBOImpl();
             case CATEGORY :
                 return  new CategoryBOImpl();
             case FUEL :
                 return new FuelBOImpl();
                
           
                  
           
            default :
                return null;
       
       }
   
   }
}
