/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.business.BOFactory;
import lk.ijse.vehicle_rental.business.custom.VehicleBO;
import lk.ijse.vehicle_rental.db.DBConnection;
import lk.ijse.vehicle_rental.dto.VehicleDTO;
import lk.ijse.vehicle_rental.view.util.tbmodel.VehicleTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class VehicleReportController implements Initializable {

    @FXML
    private AnchorPane vehicleReportPane;
    @FXML
    private TableView<VehicleTM> tblVehicle;

    private VehicleBO vehicleBO;
            
    /**
     * Initializes the controller class.
     */
    
    private void loadAllVehicle(){
        try {
            ArrayList<VehicleDTO> alVehicle=vehicleBO.getAllVehicle();
            ObservableList<VehicleTM> olVehicle=tblVehicle.getItems();
            olVehicle.removeAll(olVehicle);
            for (VehicleDTO vehicle : alVehicle) {
                olVehicle.add(new VehicleTM(
                        vehicle.getVehicle_No(),
                        vehicle.getCID(),
                        vehicle.getBrand(),
                        vehicle.getModel(),
                        vehicle.getGearbox(),
                        vehicle.getFID(),
                        vehicle.getMax_Passengers(),
                        vehicle.getDoors(),
                        vehicle.getColor(),
                        vehicle.getPrice_Per_Day()));
            }
        } catch (Exception ex) {
            Logger.getLogger(AddVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           vehicleBO=(VehicleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.VEHICLE);
        
        
        
        
        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Category"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Vehicle_No"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Brand"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Model"));
        tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Gearbox"));
        tblVehicle.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Fuel"));
        tblVehicle.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("Color"));
        tblVehicle.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("Price_Per_Day"));
        tblVehicle.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("Max_Passengers"));
        tblVehicle.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("Doors"));
        
       
                
        loadAllVehicle();
    }    

    @FXML
    private void btnBack(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/reportsForm.fxml"));
           vehicleReportPane.getChildren().clear();
            vehicleReportPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(VehicleReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void imgPrint(MouseEvent event) throws SQLException, ClassNotFoundException {
         
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/vehicle_rental/report/VehicleReport.jasper");
            Connection connection = DBConnection.getDBConnection().getConnection();
            HashMap map = new HashMap();
            
            JasperPrint report = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(report, false);
            
        } catch (JRException ex) {
            Logger.getLogger(CustomerReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     
    private void loadTable(MouseEvent event) {

        loadAllVehicle();
    }
    
}
