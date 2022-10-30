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
import lk.ijse.vehicle_rental.business.custom.DriverBO;
import lk.ijse.vehicle_rental.db.DBConnection;
import lk.ijse.vehicle_rental.dto.DriverDTO;
import lk.ijse.vehicle_rental.view.util.tbmodel.DriverTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */


public class DriverReportController implements Initializable {

    @FXML
    private AnchorPane driverReportPane;
    @FXML
    private TableView<DriverTM> tblDriver;
    
    private DriverBO driverBO;

    /**
     * Initializes the controller class.
     */
    
    private void loadAllDrivers() {

        try {
            ArrayList<DriverDTO> alDriver = driverBO.getAllDrivers();

            ObservableList<DriverTM> olDriver = tblDriver.getItems();

            olDriver.removeAll(olDriver);

            for (DriverDTO driver : alDriver) {

                olDriver.add(new DriverTM(
                        driver.getDID(),
                        driver.getLicense_No(),
                        driver.getDname(),
                        driver.getDphone()
                ));
            }
        } catch (Exception ex) {

            Logger.getLogger(DriverController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        driverBO = (DriverBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.DRIVER);

        
        tblDriver.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("DID"));
        tblDriver.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("License_No"));
        tblDriver.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Dname"));
        tblDriver.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Dphone"));

        loadAllDrivers();

      
    }    

    @FXML
    private void btnBack(ActionEvent event) {
           try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/reportsForm.fxml"));
            driverReportPane.getChildren().clear();
            driverReportPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DriverReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void imgPrint(MouseEvent event) throws SQLException, ClassNotFoundException {
     try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/vehicle_rental/report/DriverReport.jasper");
            Connection connection = DBConnection.getDBConnection().getConnection();
            HashMap map = new HashMap();
            
            JasperPrint report = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(report, false);
            
        } catch (JRException ex) {
            Logger.getLogger(DriverReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void loadTable(MouseEvent event) {

        loadAllDrivers();

    }

}
