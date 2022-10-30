/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.view.util.tbmodel;

/**
 *
 * @author zoomcoder
 */
public class VehicleTM {
   private String Vehicle_No;
   private String CID;
   private String Brand;
   private String Model;
   private String Gearbox;
   private String FID;
   private int Max_Passengers;
   private int Doors;
   private String Color;
   private double Price_Per_Day;

    public VehicleTM() {
    }

    public VehicleTM(String Vehicle_No, String CID, String Brand, String Model, String Gearbox, String FID, int Max_Passengers, int Doors, String Color, double Price_Per_Day) {
        this.Vehicle_No = Vehicle_No;
        this.CID = CID;
        this.Brand = Brand;
        this.Model = Model;
        this.Gearbox = Gearbox;
        this.FID = FID;
        this.Max_Passengers = Max_Passengers;
        this.Doors = Doors;
        this.Color = Color;
        this.Price_Per_Day = Price_Per_Day;
    }

    /**
     * @return the Vehicle_No
     */
    public String getVehicle_No() {
        return Vehicle_No;
    }

    /**
     * @param Vehicle_No the Vehicle_No to set
     */
    public void setVehicle_No(String Vehicle_No) {
        this.Vehicle_No = Vehicle_No;
    }

    /**
     * @return the CID
     */
    public String getCID() {
        return CID;
    }

    /**
     * @param CID the CID to set
     */
    public void setCID(String CID) {
        this.CID = CID;
    }

    /**
     * @return the Brand
     */
    public String getBrand() {
        return Brand;
    }

    /**
     * @param Brand the Brand to set
     */
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    /**
     * @return the Model
     */
    public String getModel() {
        return Model;
    }

    /**
     * @param Model the Model to set
     */
    public void setModel(String Model) {
        this.Model = Model;
    }

    /**
     * @return the Gearbox
     */
    public String getGearbox() {
        return Gearbox;
    }

    /**
     * @param Gearbox the Gearbox to set
     */
    public void setGearbox(String Gearbox) {
        this.Gearbox = Gearbox;
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
     * @return the Max_Passengers
     */
    public int getMax_Passengers() {
        return Max_Passengers;
    }

    /**
     * @param Max_Passengers the Max_Passengers to set
     */
    public void setMax_Passengers(int Max_Passengers) {
        this.Max_Passengers = Max_Passengers;
    }

    /**
     * @return the Doors
     */
    public int getDoors() {
        return Doors;
    }

    /**
     * @param Doors the Doors to set
     */
    public void setDoors(int Doors) {
        this.Doors = Doors;
    }

    /**
     * @return the Color
     */
    public String getColor() {
        return Color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(String Color) {
        this.Color = Color;
    }

    /**
     * @return the Price_Per_Day
     */
    public double getPrice_Per_Day() {
        return Price_Per_Day;
    }

    /**
     * @param Price_Per_Day the Price_Per_Day to set
     */
    public void setPrice_Per_Day(double Price_Per_Day) {
        this.Price_Per_Day = Price_Per_Day;
    }

    @Override
    public String toString() {
        return "VehicleTM{" + "Vehicle_No=" + Vehicle_No + ", CID=" + CID + ", Brand=" + Brand + ", Model=" + Model + ", Gearbox=" + Gearbox + ", FID=" + FID + ", Max_Passengers=" + Max_Passengers + ", Doors=" + Doors + ", Color=" + Color + ", Price_Per_Day=" + Price_Per_Day + '}';
    }

    
    
}
