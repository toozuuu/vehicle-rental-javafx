/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.vehicle_rental.business.BOFactory;
import lk.ijse.vehicle_rental.business.custom.DriverBO;
import lk.ijse.vehicle_rental.db.DBConnection;
import lk.ijse.vehicle_rental.dto.DriverDTO;
import lk.ijse.vehicle_rental.view.util.tbmodel.DriverTM;

public class DriverController implements Initializable {

    @FXML
    private JFXTextField txtDriverID;
    @FXML
    private JFXTextField txtDriverMobileNumber;
    @FXML
    private JFXTextField txtDriverName;
    @FXML
    private TableView<DriverTM> tbDriver;

    private DriverBO driverBO;
    @FXML
    private JFXTextField txtSearchDriverID;

    ObservableList<DriverTM> driverTM;

    @FXML
    private JFXTextField txtLicenseNO;

    private void loadAllDrivers() {

        try {
            ArrayList<DriverDTO> alDriver = driverBO.getAllDrivers();

            ObservableList<DriverTM> olDriver = tbDriver.getItems();

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        driverBO = (DriverBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.DRIVER);

        tbDriver.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("DID"));
        tbDriver.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("License_No"));
        tbDriver.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Dname"));
        tbDriver.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Dphone"));

        loadAllDrivers();

        try {
            txtDriverID.setText(genarateID());
        } catch (Exception ex) {
            Logger.getLogger(DriverController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnAdd(MouseEvent event) throws Exception {
        String driverID = txtDriverID.getText();
        String driverMobileNumber = txtDriverMobileNumber.getText();
        String driverName = txtDriverName.getText();
        String driverLicenseNo = txtLicenseNO.getText();

      //  if (validateName() && validateNumber() && validateLicenseNO()) {
            DriverDTO driver = new DriverDTO(driverID, driverLicenseNo, driverName, driverMobileNumber);

            boolean result = driverBO.saveDriver(driver);
            if (result) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Added Success", ButtonType.OK);
                a1.show();
            }
            txtDriverID.setText(genarateID());
            loadAllDrivers();
            btnClearTxtField();

//        } else {
//
//            Alert a2 = new Alert(Alert.AlertType.WARNING, "Validate Details", ButtonType.OK);
//            a2.show();
//
//        }

    }

    @FXML
    private void btnUpdate(MouseEvent event) throws Exception {

        String driverID = txtDriverID.getText();
        String driverMobileNumber = txtDriverMobileNumber.getText();
        String driverName = txtDriverName.getText();
        String driverLicenseNo = txtLicenseNO.getText();

      //  if (validateName() && validateNumber() && validateLicenseNO()) {
            DriverDTO driver = new DriverDTO(driverID, driverLicenseNo, driverName, driverMobileNumber);

            boolean isAdded = driverBO.updateDriver(driver);
            if (isAdded) {

                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Updated Success", ButtonType.OK);
                a1.show();

            }

            txtDriverID.setText(genarateID());
            loadAllDrivers();
            btnClearTxtField();

//        } else {
//            Alert a2 = new Alert(Alert.AlertType.WARNING, "Validate Details", ButtonType.OK);
//            a2.show();
//
//        }

    }

    @FXML
    private void btnRemove(MouseEvent event) throws Exception {
        try {
            DriverTM selecteDriver = tbDriver.getSelectionModel().getSelectedItem();

            if (selecteDriver == null) {
                return;
            }
            boolean result = driverBO.deleteDriver(selecteDriver.getDID());
            if (result) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Deleted Success", ButtonType.OK);
                a1.show();
            } else {
                Alert a2 = new Alert(Alert.AlertType.ERROR, "Field", ButtonType.OK);
                a2.show();

            }
        } catch (Exception ex) {
            Logger.getLogger(DriverController.class.getName()).log(Level.SEVERE, null, ex);
        }

        loadAllDrivers();
        btnClearTxtField();

    }

    @FXML
    private void loadTable(MouseEvent event) {

        loadAllDrivers();

    }

    // for genarate Driver ID
    private String genarateID() throws SQLException, Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT DID FROM Driver ORDER BY DID DESC LIMIT 1");

        if (rst.next()) {
            String driverID = rst.getString(1);
            driverID = driverID.split("[A-Z]")[1];
            driverID = (Integer.parseInt(driverID) + 1) + "";
            return "D00" + driverID;
        } else {
            return "D001";
        }
    }

    @FXML
    private void searchDriverID(ActionEvent event) throws Exception {
       String DID = txtSearchDriverID.getText();
        
        try {
            String[] driver = driverBO.searchDriver(DID);
            if (driver != null) {
                txtDriverID.setText(driver[0]);
                txtLicenseNO.setText(driver[1]);
                txtDriverName.setText(driver[2]);
                txtDriverMobileNumber.setText(driver[3]);
             
            }else{
                 Alert a1=new Alert(Alert.AlertType.INFORMATION, "Driver not Found", ButtonType.OK);
                 a1.show();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // for clear textField using by clear button 
    @FXML
    private void btnClearTxtField() throws Exception {

        txtDriverMobileNumber.clear();
        txtDriverName.clear();
        txtSearchDriverID.clear();
        txtLicenseNO.clear();
        txtSearchDriverID.clear();
        txtDriverID.setText(genarateID());
    }

    @FXML
    private void tblRowClicked(MouseEvent event) {
        DriverTM alDrivers = tbDriver.getSelectionModel().getSelectedItem();

        txtDriverID.setText(alDrivers.getDID());
        txtLicenseNO.setText(alDrivers.getLicense_No());
        txtDriverName.setText(alDrivers.getDname());
        txtDriverMobileNumber.setText(alDrivers.getDphone());

    }

    //for validate 
   
     
     private boolean validateName1(){
           String name1 = txtDriverName.getText();
           return name1.matches("^[a-zA-Z]{1,100}[ ][a-zA-Z]{1,100}$");
     }
     
     private boolean validateName2(){
         String name2=txtDriverName.getText();
         return name2.matches("[a-zA-Z]+");
     }
     
     private boolean validateMobileNumber(){
         String mobNO = txtDriverMobileNumber.getText();
         return mobNO.matches("[0-9]{10,12}");
     
     }
     
     private boolean validateLicenseNumber(){
           String licenseNO=txtLicenseNO.getText();
           return licenseNO.matches("[a-zA-Z]{1,1}[0-9]{6,10}");
     
     }
}
