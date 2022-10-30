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
public class BlacklistTM {
   
    private String NIC;
    private String Recent;

    public BlacklistTM() {
    }

    public BlacklistTM(String NIC, String Recent) {
        this.NIC = NIC;
        this.Recent = Recent;
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
     * @return the Recent
     */
    public String getRecent() {
        return Recent;
    }

    /**
     * @param Recent the Recent to set
     */
    public void setRecent(String Recent) {
        this.Recent = Recent;
    }

    @Override
    public String toString() {
        return "BlacklistTM{" + "NIC=" + NIC + ", Recent=" + Recent + '}';
    }

  

    
}
