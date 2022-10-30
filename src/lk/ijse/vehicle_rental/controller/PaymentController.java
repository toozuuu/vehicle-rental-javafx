/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class PaymentController implements Initializable {

    @FXML
    private AnchorPane paymentPane;
    @FXML
    private JFXComboBox<String> cmdDriver;
    @FXML
    private JFXTextField txtDamageCharges;
    @FXML
    private JFXTextField txtAdvancePaid;
    @FXML
    private JFXCheckBox checkBOXDriver;
    @FXML
    private JFXCheckBox checkBOXDamage;
    @FXML
    private JFXDatePicker DatePickerBookingTillDate;
    @FXML
    private JFXTimePicker TimePickerBookingTillTime;
    @FXML
    private JFXTextField txtTotalPrice;
    @FXML
    private JFXTextField txtBalance;
    @FXML
    private JFXTextField txtReservationID;
    private JFXTextField txtBookingDate;
    @FXML
    private JFXTextField txtBookingTime;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXDatePicker DatePickerBookingDate;
    @FXML
    private JFXTextField txtPricePerDay;
   
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        txtBalance.setText("0");
        txtDamageCharges.setText("0");
        
        
        checkBOXDriver.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                HiredDriver();
                
            }
            
        });
        checkBOXDamage.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                DamagePayment();
                
            }
            
           
            
        });
        
        DatePickerBookingDate.setValue(LocalDate.now());
        txtBookingTime.setText(LocalTime.now().toString());
        
        
        
       
       
    }

    @FXML
    private void btnSubmit(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/reservationForm.fxml"));
            paymentPane.getChildren().clear();
            paymentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnBack(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/addCustomer.fxml"));
            paymentPane.getChildren().clear();
            paymentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void tblRowClicked(MouseEvent event) {
    }

    @FXML
    private void btnAdd(MouseEvent event) {
    }



    private void HiredDriver() {
        if (checkBOXDriver.isSelected()) {
            cmdDriver.setDisable(false);
        }else{
            cmdDriver.setDisable(true);
        }

    }

    private void DamagePayment() {
        if (checkBOXDamage.isSelected()) {
            txtDamageCharges.setDisable(false);
        }else{
            txtDamageCharges.setDisable(true);
        }

    }

    @FXML
    private void cmdSelectDriver(ActionEvent event) throws ParseException {
         if(cmdDriver.getValue()!=null){
       
       
             TotalPrice();
       
       
       }else{
             TotalPrice();
       }
       
    }

    @FXML
    private void txtDamageCharges(ActionEvent event) throws ParseException {
        TotalPrice();
    }

    @FXML
    private void txtAdvancePaid(ActionEvent event) {
         if(txtTotalPrice!=null || txtDamageCharges!=null || txtAdvancePaid!=null){
        double M = Double.parseDouble(txtTotalPrice.getText());
        double N = Double.parseDouble(txtAdvancePaid.getText());
        double U =Double.parseDouble(txtDamageCharges.getText());
        double L=M+U;
        if (L > N) {
            double x = L - N;

            txtBalance.setText(x + "");
        } else if(L<N) {
            double y = N - L;
            txtBalance.setText(-y + "");

        }
        }
    }

    @FXML
    private void isSelectedDriver(MouseEvent event)throws ParseException{
         TotalPrice();
        
    }

    @FXML
    private void isSelectedDamage(MouseEvent event) throws ParseException {
           if(checkBOXDamage.isSelected()){
             txtDamageCharges.clear();
             TotalPrice();
        }else{
              txtDamageCharges.setText("0");
          }
    }

   @FXML
    private void TotalPrice() throws ParseException {
    
        if (DatePickerBookingTillDate.getValue() != null) {
            long date1 = DatePickerBookingTillDate.getValue().toEpochDay();
            long date2 = DatePickerBookingDate.getValue().toEpochDay();
            double days = (double) Math.abs(date1 - date2);
            try {
                double T = days * (Double.parseDouble(txtPricePerDay.getText()));
                double M =Double.parseDouble(txtDamageCharges.getText());
                double W=T+M;
                if(cmdDriver.getValue()!=null){
                    double K=1500;
                    double P=K+W;
                    txtTotalPrice.setText(P + "");

                }else{
                    txtTotalPrice.setText(W + "");

                }
            } catch (NumberFormatException e) {}

        }
    }


    @FXML
    private void txtPricePerDay(ActionEvent event) throws ParseException {
        TotalPrice();
    }

    @FXML
    private void btnClear(MouseEvent event) {
        txtAdvancePaid.clear();
        txtBalance.clear();
        txtBookingTime.clear();
        txtDamageCharges.clear();
        txtPricePerDay.clear();
        txtReservationID.clear();
        txtTotalPrice.clear();       
        checkBOXDriver.setSelected(false);
        cmdDriver.getSelectionModel().clearSelection();
        DatePickerBookingTillDate.setValue(null);
        checkBOXDriver.setSelected(false);
        checkBOXDamage.setSelected(false);
    }

    @FXML
    private void imgPrint(MouseEvent event) {
    }
    
   
    
    

}
