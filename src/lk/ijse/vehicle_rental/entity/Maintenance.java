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
public class Maintenance {
    private String MID;
    private String Vehicle_NO;
    private String Maintenance_Company_Name;
    private String Company_Address;
    private String Contact_Number;
    private String AddedOn;
    private String NextDueDate;
    private String PaymentStatus;
    private double Amount;

    public Maintenance() {
    }

    public Maintenance(String MID, String Vehicle_NO, String Maintenance_Company_Name, String Company_Address, String Contact_Number, String AddedOn, String NextDueDate, String PaymentStatus, double Amount) {
        this.MID = MID;
        this.Vehicle_NO = Vehicle_NO;
        this.Maintenance_Company_Name = Maintenance_Company_Name;
        this.Company_Address = Company_Address;
        this.Contact_Number = Contact_Number;
        this.AddedOn = AddedOn;
        this.NextDueDate = NextDueDate;
        this.PaymentStatus = PaymentStatus;
        this.Amount = Amount;
    }

    /**
     * @return the MID
     */
    public String getMID() {
        return MID;
    }

    /**
     * @param MID the MID to set
     */
    public void setMID(String MID) {
        this.MID = MID;
    }

    /**
     * @return the Vehicle_NO
     */
    public String getVehicle_NO() {
        return Vehicle_NO;
    }

    /**
     * @param Vehicle_NO the Vehicle_NO to set
     */
    public void setVehicle_NO(String Vehicle_NO) {
        this.Vehicle_NO = Vehicle_NO;
    }

    /**
     * @return the Maintenance_Company_Name
     */
    public String getMaintenance_Company_Name() {
        return Maintenance_Company_Name;
    }

    /**
     * @param Maintenance_Company_Name the Maintenance_Company_Name to set
     */
    public void setMaintenance_Company_Name(String Maintenance_Company_Name) {
        this.Maintenance_Company_Name = Maintenance_Company_Name;
    }

    /**
     * @return the Company_Address
     */
    public String getCompany_Address() {
        return Company_Address;
    }

    /**
     * @param Company_Address the Company_Address to set
     */
    public void setCompany_Address(String Company_Address) {
        this.Company_Address = Company_Address;
    }

    /**
     * @return the Contact_Number
     */
    public String getContact_Number() {
        return Contact_Number;
    }

    /**
     * @param Contact_Number the Contact_Number to set
     */
    public void setContact_Number(String Contact_Number) {
        this.Contact_Number = Contact_Number;
    }

    /**
     * @return the AddedOn
     */
    public String getAddedOn() {
        return AddedOn;
    }

    /**
     * @param AddedOn the AddedOn to set
     */
    public void setAddedOn(String AddedOn) {
        this.AddedOn = AddedOn;
    }

    /**
     * @return the NextDueDate
     */
    public String getNextDueDate() {
        return NextDueDate;
    }

    /**
     * @param NextDueDate the NextDueDate to set
     */
    public void setNextDueDate(String NextDueDate) {
        this.NextDueDate = NextDueDate;
    }

    /**
     * @return the PaymentStatus
     */
    public String getPaymentStatus() {
        return PaymentStatus;
    }

    /**
     * @param PaymentStatus the PaymentStatus to set
     */
    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }

    /**
     * @return the Amount
     */
    public double getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    @Override
    public String toString() {
        return "Maintenance{" + "MID=" + MID + ", Vehicle_NO=" + Vehicle_NO + ", Maintenance_Company_Name=" + Maintenance_Company_Name + ", Company_Address=" + Company_Address + ", Contact_Number=" + Contact_Number + ", AddedOn=" + AddedOn + ", NextDueDate=" + NextDueDate + ", PaymentStatus=" + PaymentStatus + ", Amount=" + Amount + '}';
    }

   
}
