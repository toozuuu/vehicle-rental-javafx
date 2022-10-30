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
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class LoginController extends Application implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextArea txtLoginUserName;
    @FXML
    private JFXPasswordField txtLoginPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLogin (MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/DashBoard_Admin.fxml"));
        Scene temp = new Scene(root);
       Stage stage=(Stage)this.rootPane.getScene().getWindow();
       stage.setScene(temp);
       stage.centerOnScreen();
       
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    }

}
