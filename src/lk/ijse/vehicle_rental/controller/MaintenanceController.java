/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
import lk.ijse.vehicle_rental.business.custom.MaintenanceBO;
import lk.ijse.vehicle_rental.business.custom.VehicleBO;
import lk.ijse.vehicle_rental.db.DBConnection;
import lk.ijse.vehicle_rental.dto.MaintenanceDTO;
import lk.ijse.vehicle_rental.dto.VehicleDTO;
import lk.ijse.vehicle_rental.view.util.tbmodel.MaintenanceTM;
import lk.ijse.vehicle_rental.view.util.tbmodel.VehicleTM;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class MaintenanceController implements Initializable {

    @FXML
    private JFXTextField txtMaintananceComName;
    @FXML
    private JFXTextField txtComNumber;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private JFXDatePicker datePickerAddedON;
    @FXML
    private JFXDatePicker datePickerNextDueDate;
    @FXML
    private JFXTextField txtPaymentsStatus;
    @FXML
    private JFXComboBox<String> cmbVehicleNO;
    @FXML
    private JFXTextArea txtMCAddress;
    @FXML
    private TableView<MaintenanceTM> tblMaintenance;

    private MaintenanceBO maintenanceBO;
    
    ObservableList<VehicleTM> vehicleTM;

    private VehicleBO vehicleBO;
    @FXML
    private JFXTextField txtMID;
    @FXML
    private JFXTextField searchMaintenance;

    /**
     * Initializes the controller class.
     */
    private void loadAllMaintenance() {
        try {
            ArrayList<MaintenanceDTO> alMaintenance = maintenanceBO.getAllMaintenance();
            ObservableList<MaintenanceTM> olMaintenance = tblMaintenance.getItems();
            olMaintenance.removeAll(olMaintenance);
            for (MaintenanceDTO maintenanceDTO : alMaintenance) {
                olMaintenance.add(new MaintenanceTM(
                        maintenanceDTO.getMID(),
                        maintenanceDTO.getVehicle_NO(),
                        maintenanceDTO.getMaintenance_Company_Name(),
                        maintenanceDTO.getCompany_Address(),
                        maintenanceDTO.getContact_Number(),
                        maintenanceDTO.getAddedOn(),
                        maintenanceDTO.getAmount(),
                        maintenanceDTO.getPaymentStatus(),
                        maintenanceDTO.getNextDueDate()));

            }
        } catch (Exception ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            maintenanceBO = (MaintenanceBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MAINTENANCE);
            vehicleBO = (VehicleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.VEHICLE);
            
            tblMaintenance.getColumns().get(0).setStyle("-fx-alignment:center");
            
            
            tblMaintenance.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("MID"));
            tblMaintenance.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Vehicle_NO"));
            tblMaintenance.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Maintenance_Company_Name"));
            tblMaintenance.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Company_Address"));
            tblMaintenance.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Contact_Number"));
            tblMaintenance.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("AddedOn"));
            tblMaintenance.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("Amount"));
            tblMaintenance.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("PaymentStatus"));
            tblMaintenance.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("NextDueDate"));
            
            loadAllMaintenance();
            getVehicleNO(cmbVehicleNO.getSelectionModel().getSelectedItem());
            txtMID.setText(genarateID());
        } catch (Exception ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnAdd(MouseEvent event) {
        try {
            String MID=txtMID.getText();
            String companyName = txtMaintananceComName.getText();
            String companyAddress = txtMCAddress.getText();
            String contactNumber = txtComNumber.getText();
            String addedON = datePickerAddedON.getValue().toString();
            String nextDueDate = datePickerNextDueDate.getValue().toString();
            String paymentStatus = txtPaymentsStatus.getText();
            double amount = Double.parseDouble(txtAmount.getText());
            String vehicleNO = cmbVehicleNO.getSelectionModel().getSelectedItem();

            MaintenanceDTO maintenanceDTO = new MaintenanceDTO(MID, vehicleNO, companyName, companyAddress, contactNumber, addedON, nextDueDate, paymentStatus, amount);

            boolean isAdded = maintenanceBO.saveMaintenance(maintenanceDTO);

            if (isAdded) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Added Success", ButtonType.OK);
                a1.show();
                txtMID.setText(genarateID());
                loadAllMaintenance();
                btnClear( event);

            } else {
                Alert a2 = new Alert(Alert.AlertType.ERROR, "Field", ButtonType.OK);
                a2.show();

            }
        } catch (Exception ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUpdate(MouseEvent event) {
        try {
            String MID=txtMID.getText();
            String companyName = txtMaintananceComName.getText();
            String companyAddress = txtMCAddress.getText();
            String contactNumber = txtComNumber.getText();
            String addedON = datePickerAddedON.getValue().toString();
            String nextDueDate = datePickerNextDueDate.getValue().toString();
            String paymentStatus = txtPaymentsStatus.getText();
            double amount = Double.parseDouble(txtAmount.getText());
            String vehicleNO = cmbVehicleNO.getSelectionModel().getSelectedItem();

            MaintenanceDTO maintenanceDTO = new MaintenanceDTO(MID, vehicleNO, companyName, companyAddress, contactNumber, addedON, nextDueDate, paymentStatus, amount);

            boolean isAdded = maintenanceBO.updateMaintenance(maintenanceDTO);

            if (isAdded) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Updated Success", ButtonType.OK);
                a1.show();
                txtMID.setText(genarateID());
                loadAllMaintenance();
                btnClear(event);

            } else {
                Alert a2 = new Alert(Alert.AlertType.ERROR, "Field", ButtonType.OK);
                a2.show();

            }
        } catch (Exception ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnRemove(MouseEvent event) {
        try {
            MaintenanceTM selecteMaintenance=tblMaintenance.getSelectionModel().getSelectedItem();
            if(selecteMaintenance==null){
                return;
            }
            boolean result=maintenanceBO.removeMaintenance(selecteMaintenance.getMID());
            if(result){
                
                Alert a1=new Alert(Alert.AlertType.INFORMATION, "Deleted Success", ButtonType.OK);
                a1.show();
                 loadAllMaintenance();
                txtMID.setText(genarateID());           
            }else{
                Alert a2=new Alert(Alert.AlertType.ERROR, "Field", ButtonType.OK);
                a2.show();
            }
           
        } catch (Exception ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void imgRefresh(MouseEvent event) {
        loadAllMaintenance();
    }

    @FXML
    private void btnClear(MouseEvent event) throws Exception {
        txtAmount.clear();
        txtComNumber.clear();
        txtMCAddress.clear();
        txtMaintananceComName.clear();
        txtPaymentsStatus.clear();
        datePickerAddedON.setValue(null);
        datePickerNextDueDate.setValue(null);
        cmbVehicleNO.getSelectionModel().clearSelection();
        searchMaintenance.clear();
        
        txtMID.setText(genarateID());
    }

    private void getVehicleNO(String id) {
        ArrayList<VehicleDTO> allMaintaince;
        try {
            allMaintaince = vehicleBO.getAllVehicle();
            ObservableList<String> olMaintenance = cmbVehicleNO.getItems();
            olMaintenance.removeAll(olMaintenance);
            for (VehicleDTO catergory : allMaintaince) {
                olMaintenance.add(catergory.getVehicle_No());
                
            }

        } catch (Exception ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     private String genarateID() throws SQLException, Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT MID FROM Maintenance ORDER BY MID DESC LIMIT 1");

        if (rst.next()) {
            String maintenanceID = rst.getString(1);
            maintenanceID = maintenanceID.split("[A-Z]")[1];
            maintenanceID = (Integer.parseInt(maintenanceID) + 1) + "";
            return "M00" + maintenanceID;
        } else {
            return "M001";
        }
    }
     
    private void loadTable(MouseEvent event) {

        loadAllMaintenance();

    }

    @FXML
    private void tblRowClicked(MouseEvent event) {
        MaintenanceTM alMaintenance= tblMaintenance.getSelectionModel().getSelectedItem();
        
        if(alMaintenance==null){
            return;
        
        }
        
        String cmdVehicleNO=alMaintenance.getVehicle_NO();
      
        txtAmount.setText(Double.toString(alMaintenance.getAmount()));
        txtComNumber.setText(alMaintenance.getContact_Number());
        txtMCAddress.setText(alMaintenance.getCompany_Address());
        txtMID.setText(alMaintenance.getMID());
        txtMaintananceComName.setText(cmdVehicleNO);
        txtPaymentsStatus.setText(alMaintenance.getPaymentStatus());
        datePickerAddedON.setValue(LocalDate.parse(alMaintenance.getAddedOn()));
        datePickerNextDueDate.setValue(LocalDate.parse(alMaintenance.getNextDueDate()));
        cmbVehicleNO.getSelectionModel().select(cmdVehicleNO);
    }

    @FXML
    private void searchVehicleNo(ActionEvent event) {
                
        String MID =searchMaintenance.getText();
        
        try {
            String[] maintenance = maintenanceBO.searchMaintenance(MID);
            if (maintenance != null) {
                txtMID.setText(maintenance[0]);
                cmbVehicleNO.getSelectionModel().select(maintenance[1]);
                txtMaintananceComName.setText(maintenance[2]);
                txtMCAddress.setText(maintenance[3]);
                txtComNumber.setText(maintenance[4]);
                datePickerAddedON.setValue(LocalDate.parse(maintenance[5]));
                datePickerNextDueDate.setValue(LocalDate.parse(maintenance[6]));
                txtPaymentsStatus.setText(maintenance[7]);
                txtAmount.setText(maintenance[8]);
                
          
                
            }else{
                 Alert a1=new Alert(Alert.AlertType.INFORMATION, "Customer not Found", ButtonType.OK);
                 a1.show();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
