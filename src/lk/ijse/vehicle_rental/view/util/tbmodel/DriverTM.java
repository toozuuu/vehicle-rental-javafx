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
public class DriverTM {
    private String DID;
    private String License_No;
    private String Dname;
    private String Dphone;

    public DriverTM() {
    }

    public DriverTM(String DID, String License_No, String Dname, String Dphone) {
        this.DID = DID;
        this.License_No = License_No;
        this.Dname = Dname;
        this.Dphone = Dphone;
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

    /**
     * @return the License_No
     */
    public String getLicense_No() {
        return License_No;
    }

    /**
     * @param License_No the License_No to set
     */
    public void setLicense_No(String License_No) {
        this.License_No = License_No;
    }

    /**
     * @return the Dname
     */
    public String getDname() {
        return Dname;
    }

    /**
     * @param Dname the Dname to set
     */
    public void setDname(String Dname) {
        this.Dname = Dname;
    }

    /**
     * @return the Dphone
     */
    public String getDphone() {
        return Dphone;
    }

    /**
     * @param Dphone the Dphone to set
     */
    public void setDphone(String Dphone) {
        this.Dphone = Dphone;
    }

    @Override
    public String toString() {
        return "DriverTM{" + "DID=" + DID + ", License_No=" + License_No + ", Dname=" + Dname + ", Dphone=" + Dphone + '}';
    }

  
    
    
    
    
}
