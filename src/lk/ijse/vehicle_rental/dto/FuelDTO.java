/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dto;

/**
 *
 * @author zoomcoder
 */
public class FuelDTO {
     private String FID;
    private String FuelName;

    public FuelDTO() {
    }

    public FuelDTO(String FID, String FuelName) {
        this.FID = FID;
        this.FuelName = FuelName;
    }

    /**
     * @return the FID
     */
    public String getFID() {
        return FID;
    }

    /**
     * @param FID the FID to set
     */
    public void setFID(String FID) {
        this.FID = FID;
    }

    /**
     * @return the FuelName
     */
    public String getFuelName() {
        return FuelName;
    }

    /**
     * @param FuelName the FuelName to set
     */
    public void setFuelName(String FuelName) {
        this.FuelName = FuelName;
    }

    @Override
    public String toString() {
        return "FuelDTO{" + "FID=" + FID + ", FuelName=" + FuelName + '}';
    }
    
}
