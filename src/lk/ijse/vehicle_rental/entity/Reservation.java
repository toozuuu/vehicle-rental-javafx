/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.entity;

/**
 *
 * @author zoomcoder
 */
public class Reservation {
    private String RID;
    private String NIC;
    private String DID;

    public Reservation() {
    }

    public Reservation(String RID, String NIC, String DID) {
        this.RID = RID;
        this.NIC = NIC;
        this.DID = DID;
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
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the DID
     */
    public String getDID() {
        return DID;
    }

    /**
     * @param DID the DID to set
     */
    public void setDID(String DID) {
        this.DID = DID;
    }

    @Override
    public String toString() {
        return "Reservation{" + "RID=" + RID + ", NIC=" + NIC + ", DID=" + DID + '}';
    }
    
}
