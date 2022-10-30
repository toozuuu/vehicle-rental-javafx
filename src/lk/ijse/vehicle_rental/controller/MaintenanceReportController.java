/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.db.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class MaintenanceReportController implements Initializable {

    @FXML
    private AnchorPane maintenanceReportPane;
    @FXML
    private JFXDatePicker datePickerFrom;
    @FXML
    private JFXDatePicker datePickerTo;
    @FXML
    private JFXButton btnSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBack(ActionEvent event) {
             try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/reportsForm.fxml"));
            maintenanceReportPane.getChildren().clear();
            maintenanceReportPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void imgPrint(MouseEvent event) {
        
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/vehicle_rental/report/MaintenanceReport.jasper");
            Connection connection = DBConnection.getDBConnection().getConnection();
            HashMap map = new HashMap();
            map.put("Date1", datePickerFrom.getValue().toString());
            map.put("Date2", datePickerTo.getValue().toString());
            JasperPrint report = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(report, false);
            
        } catch (JRException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MaintenanceReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSearch(MouseEvent event) {
        String dFrom = datePickerFrom.getValue().toString();
        String dTo =datePickerTo.getValue().toString();
                
        
        
         
        
    }

    
}
