/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.db.DBConnection;
import lk.ijse.vehicle_rental.entity.Customer;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class HomeFormController implements Initializable {

    @FXML
    private AnchorPane homePane;
    @FXML
    private Label lableTotalCustomers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void btnPayment(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/paymentFormDashBoard.fxml"));
            homePane.getChildren().clear();
            homePane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadTotalCustomerCount() throws Exception{
        
        String sql="select count(NIC) from Customer ;";
        
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement ptsm=conn.prepareStatement(sql);
        ptsm.setObject(1, sql);
       
    }
}
