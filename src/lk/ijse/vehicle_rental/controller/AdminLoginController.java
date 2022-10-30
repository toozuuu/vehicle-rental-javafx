/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class AdminLoginController implements Initializable {

    @FXML
    private JFXTextArea adminLoginUserName;
    @FXML
    private JFXPasswordField adminLoginPassword;
    @FXML
    private AnchorPane adminLoginPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnLogin(MouseEvent event) {
        
        try {
          
            
            
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/DashBoard_Admin.fxml"));
            Scene temp=new Scene(root);
            Stage stage=(Stage)this.adminLoginPane.getScene().getWindow();
            stage.setScene(temp);
            stage.centerOnScreen();
            
            FadeTransition transition=new FadeTransition(Duration.millis(500),root);
            transition.setFromValue(0.0);
            transition.setToValue(1.0);
            transition.play();
        } catch (IOException ex) {
            Logger.getLogger(AdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }

    
    
}
