/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.entity;

import java.util.Date;

/**
 *
 * @author zoomcoder
 */
public class Reservation_Detail {
    private String RID;
    private String Vehicle_No;
    private Date Resive_Date;
    private Date Resive_Till_Date;
    private Date Resive_Time;
    private Date Resive_Till_Time;

    public Reservation_Detail() {
    }

    public Reservation_Detail(String RID, String Vehicle_No, Date Resive_Date, Date Resive_Till_Date, Date Resive_Time, Date Resive_Till_Time) {
        this.RID = RID;
        this.Vehicle_No = Vehicle_No;
        this.Resive_Date = Resive_Date;
        this.Resive_Till_Date = Resive_Till_Date;
        this.Resive_Time = Resive_Time;
        this.Resive_Till_Time = Resive_Till_Time;
    }

    /**
     * @return the RID
     */
    public String getRID() {
        return RID;
    }

    /**
     * @param RID the RID to set
     */
    public void setRID(String RID) {
        this.RID = RID;
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
     * @return the Resive_Date
     */
    public Date getResive_Date() {
        return Resive_Date;
    }

    /**
     * @param Resive_Date the Resive_Date to set
     */
    public void setResive_Date(Date Resive_Date) {
        this.Resive_Date = Resive_Date;
    }

    /**
     * @return the Resive_Till_Date
     */
    public Date getResive_Till_Date() {
        return Resive_Till_Date;
    }

    /**
     * @param Resive_Till_Date the Resive_Till_Date to set
     */
    public void setResive_Till_Date(Date Resive_Till_Date) {
        this.Resive_Till_Date = Resive_Till_Date;
    }

    /**
     * @return the Resive_Time
     */
    public Date getResive_Time() {
        return Resive_Time;
    }

    /**
     * @param Resive_Time the Resive_Time to set
     */
    public void setResive_Time(Date Resive_Time) {
        this.Resive_Time = Resive_Time;
    }

    /**
     * @return the Resive_Till_Time
     */
    public Date getResive_Till_Time() {
        return Resive_Till_Time;
    }

    /**
     * @param Resive_Till_Time the Resive_Till_Time to set
     */
    public void setResive_Till_Time(Date Resive_Till_Time) {
        this.Resive_Till_Time = Resive_Till_Time;
    }

    @Override
    public String toString() {
        return "Reservation_Detail{" + "RID=" + RID + ", Vehicle_No=" + Vehicle_No + ", Resive_Date=" + Resive_Date + ", Resive_Till_Date=" + Resive_Till_Date + ", Resive_Time=" + Resive_Time + ", Resive_Till_Time=" + Resive_Till_Time + '}';
    }

    
}
