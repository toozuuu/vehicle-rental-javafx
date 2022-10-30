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
import lk.ijse.vehicle_rental.business.custom.CustomerBO;
import lk.ijse.vehicle_rental.db.DBConnection;
import lk.ijse.vehicle_rental.dto.CustomerDTO;
import lk.ijse.vehicle_rental.view.util.tbmodel.CustomerTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class CustomerReportController implements Initializable {

    @FXML
    private AnchorPane customerReportPane;
    @FXML
    private TableView<CustomerTM> tblCustomer;
    
    private CustomerBO customerBO;

    /**
     * Initializes the controller class.
     */
      private void loadAllCustomers() {
        try {
            ArrayList<CustomerDTO> alCustomer = customerBO.getAllCustomers();
            ObservableList<CustomerTM> olCustomer = tblCustomer.getItems();

            olCustomer.removeAll(olCustomer);

            for (CustomerDTO customer : alCustomer) {
                olCustomer.add(new CustomerTM(customer.getNIC(), customer.getPassport_ID(), customer.getName(), customer.getAddress(), customer.getDOB(), customer.getCphone(), customer.getGender(), customer.getLicense_No(), customer.getCountry()));

            }
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

        tblCustomer.getColumns().get(0).setStyle("-fx-alignment:center");
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("NIC"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Passport_ID"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Address"));
        tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("DOB"));
        tblCustomer.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Cphone"));
        tblCustomer.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("Gender"));
        tblCustomer.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("License_No"));
        tblCustomer.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("Country"));
        loadAllCustomers();
    }    

    @FXML
    private void btnBack(ActionEvent event) {
             try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/reportsForm.fxml"));
            customerReportPane.getChildren().clear();
            customerReportPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(CustomerReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void imgPrint(MouseEvent event) throws SQLException, ClassNotFoundException {
        
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/vehicle_rental/report/CustomerReport.jasper");
            Connection connection = DBConnection.getDBConnection().getConnection();
            HashMap map = new HashMap();
            
            JasperPrint report = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(report, false);
            
        } catch (JRException ex) {
            Logger.getLogger(CustomerReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    private void loadTable(MouseEvent event) {

        loadAllCustomers();
    }
    
}
