/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class ReportsController implements Initializable {

    @FXML
    private AnchorPane reportPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCustomerDetailReport(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/customerReport.fxml"));
            reportPane.getChildren().clear();
            reportPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnVehicleDetailReport(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/vehicleReport.fxml"));
            reportPane.getChildren().clear();
            reportPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @FXML
    private void btnMaintenanceDetailReport(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/maintenanceReport.fxml"));
            reportPane.getChildren().clear();
            reportPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnPaymentDetailReport(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/paymentReport.fxml"));
            reportPane.getChildren().clear();
            reportPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnDriverDetailReport(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/driverReport.fxml"));
            reportPane.getChildren().clear();
            reportPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
