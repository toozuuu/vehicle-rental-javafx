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
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import lk.ijse.vehicle_rental.business.BOFactory;
import lk.ijse.vehicle_rental.business.custom.DriverBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dto.DriverDTO;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class PaymentFormDashBoardController implements Initializable {

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
    @FXML
    private JFXTextField txtBookingTime;

    @FXML
    private JFXTextField txtSearchCustomer;
    @FXML
    private JFXDatePicker DatePickerBookingDate;
    @FXML
    private JFXTextField txtPricePerDay;
    
    private DriverBO  driverBO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        driverBO=(DriverBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.DRIVER);
        
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
        getDriver();

    }

    @FXML
    private void tblRowClicked(MouseEvent event) {
    }

    @FXML
    private void btnAdd(MouseEvent event) {
    }

    @FXML
    private void btnUpdate(MouseEvent event) {
    }

    @FXML
    private void imgRefersh(MouseEvent event) {
    }

    @FXML
    private void btnSubmit(MouseEvent event) {
    }

    private void HiredDriver() {
        if (checkBOXDriver.isSelected()) {
            cmdDriver.setDisable(false);
        } else {
            cmdDriver.setDisable(true);
        }

    }

    private void DamagePayment() {
        if (checkBOXDamage.isSelected()) {
            txtDamageCharges.setDisable(false);
        } else {
            txtDamageCharges.setDisable(true);
        }

    }

    @FXML
    private void txtDamageCharges(ActionEvent event) throws ParseException {
        
        TotalPrice();
        txtAdvancePaid(event);
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
    private void txtSearchCustomer(ActionEvent event) {
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
    private void btnClear(MouseEvent event) throws ParseException {
        txtAdvancePaid.clear();
        txtBalance.clear();
        txtDamageCharges.clear();
        txtPricePerDay.clear();
        txtReservationID.clear();
        txtSearchCustomer.clear();
        txtTotalPrice.clear();       
        checkBOXDriver.setSelected(false);
        cmdDriver.getSelectionModel().clearSelection();
        DatePickerBookingTillDate.setValue(null);
        checkBOXDriver.setSelected(false);
        checkBOXDamage.setSelected(false);
        
        txtBalance.setText("0");
        
        TotalPrice();

    }

    @FXML
    private void txtPricePerDay(ActionEvent event) throws ParseException {

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
    private void isSelectedDriver(MouseEvent event) throws ParseException {
         if(checkBOXDriver.isSelected()){
             
             TotalPrice();
        }else{
             TotalPrice();
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
    private void imgPrint(MouseEvent event) {
    }
    
    
 
    private void getDriver() {
        ArrayList<DriverDTO> alDriver;
        try {
            alDriver = driverBO.getAllDrivers();
            ObservableList<String> olDruver = cmdDriver.getItems();
            olDruver.removeAll(olDruver);
            for (DriverDTO dTO : alDriver) {
                olDruver.add(dTO.getDname());
            }

        } catch (Exception ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }   
    
    
    
    
    
 }
    
    


