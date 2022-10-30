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
public class PaymentDTO {
   private String Payment_ID;
    private String Payment_Status;
    private double Advance_Paid;
    private double Total_Price;

    public PaymentDTO() {
    }

    public PaymentDTO(String Payment_ID, String Payment_Status, double Advance_Paid, double Total_Price) {
        this.Payment_ID = Payment_ID;
        this.Payment_Status = Payment_Status;
        this.Advance_Paid = Advance_Paid;
        this.Total_Price = Total_Price;
    }

    /**
     * @return the Payment_ID
     */
    public String getPayment_ID() {
        return Payment_ID;
    }

    /**
     * @param Payment_ID the Payment_ID to set
     */
    public void setPayment_ID(String Payment_ID) {
        this.Payment_ID = Payment_ID;
    }

    /**
     * @return the Payment_Status
     */
    public String getPayment_Status() {
        return Payment_Status;
    }

    /**
     * @param Payment_Status the Payment_Status to set
     */
    public void setPayment_Status(String Payment_Status) {
        this.Payment_Status = Payment_Status;
    }

    /**
     * @return the Advance_Paid
     */
    public double getAdvance_Paid() {
        return Advance_Paid;
    }

    /**
     * @param Advance_Paid the Advance_Paid to set
     */
    public void setAdvance_Paid(double Advance_Paid) {
        this.Advance_Paid = Advance_Paid;
    }

    /**
     * @return the Total_Price
     */
    public double getTotal_Price() {
        return Total_Price;
    }

    /**
     * @param Total_Price the Total_Price to set
     */
    public void setTotal_Price(double Total_Price) {
        this.Total_Price = Total_Price;
    }

   
}
