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
public class CustomerDTO {
    private String NIC;
    private String Passport_ID;
    private String Name;
    private String Address;
    private String DOB;
    private String Cphone;
    private String Gender;
    private String License_No;
    private String Country;

    public CustomerDTO() {
    }

    public CustomerDTO(String NIC, String Passport_ID, String Name, String Address, String DOB, String Cphone, String Gender, String License_No, String Country) {
        this.NIC = NIC;
        this.Passport_ID = Passport_ID;
        this.Name = Name;
        this.Address = Address;
        this.DOB = DOB;
        this.Cphone = Cphone;
        this.Gender = Gender;
        this.License_No = License_No;
        this.Country = Country;
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
     * @return the Passport_ID
     */
    public String getPassport_ID() {
        return Passport_ID;
    }

    /**
     * @param Passport_ID the Passport_ID to set
     */
    public void setPassport_ID(String Passport_ID) {
        this.Passport_ID = Passport_ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the Cphone
     */
    public String getCphone() {
        return Cphone;
    }

    /**
     * @param Cphone the Cphone to set
     */
    public void setCphone(String Cphone) {
        this.Cphone = Cphone;
    }

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
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
     * @return the Country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * @param Country the Country to set
     */
    public void setCountry(String Country) {
        this.Country = Country;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "NIC=" + NIC + ", Passport_ID=" + Passport_ID + ", Name=" + Name + ", Address=" + Address + ", DOB=" + DOB + ", Cphone=" + Cphone + ", Gender=" + Gender + ", License_No=" + License_No + ", Country=" + Country + '}';
    }

    
}
