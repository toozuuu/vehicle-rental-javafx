/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.business.BOFactory;
import lk.ijse.vehicle_rental.business.custom.CustomerBO;
import lk.ijse.vehicle_rental.dto.CustomerDTO;
import lk.ijse.vehicle_rental.view.util.tbmodel.CustomerTM;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class manageCustomerController implements Initializable {

    @FXML
    private AnchorPane customerPane;
    @FXML
    private JFXTextField txtCustomerNIC;
    @FXML
    private JFXTextField txtCustomerName;
    @FXML
    private JFXTextField txtCustomerMobileNumber;
    @FXML
    private JFXTextArea txtCustomerAddress;
    @FXML
    private JFXDatePicker setCustomerBirthday;
    @FXML
    private JFXTextField txtCustomerPasspordID;
    @FXML
    private JFXTextField txtCustomerLicenseNO;
    @FXML
    private JFXTextField txtCustomerCountry;
    @FXML
    private JFXRadioButton radioMale;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private JFXRadioButton radioFemale;
    @FXML
    private TableView<CustomerTM> tblCustomer;

    ObservableList<CustomerTM> customerTM;

    private String gender;

    private CustomerBO customerBO;
    @FXML
    private JFXTextField txtSearchCustomerNIC;

    /**
     * Initializes the controller class.
     */
    private void loadAllCustomers() {
        try {
            ArrayList<CustomerDTO> alCustomer = customerBO.getAllCustomers();

            ObservableList<CustomerTM> olCustomer = tblCustomer.getItems();

            olCustomer.removeAll(olCustomer);

            for (CustomerDTO customer : alCustomer) {
                olCustomer.add(new CustomerTM(
                        customer.getNIC(),
                        customer.getPassport_ID(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getDOB(),
                        customer.getCphone(),
                        customer.getGender(),
                        customer.getLicense_No(),
                        customer.getCountry()
                ));

            }
        } catch (Exception ex) {
            Logger.getLogger(manageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
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
        InitializeToggleGroup();
        loadAllCustomers();
    }

    @FXML
    private void btnAdd(MouseEvent event) {
        try {

            String NIC = txtCustomerNIC.getText();
            String PassportID = txtCustomerPasspordID.getText();
            String name = txtCustomerName.getText();
            String address = txtCustomerAddress.getText();
            String dob = setCustomerBirthday.getValue().toString();
            String Cphone = txtCustomerMobileNumber.getText();

            if (radioMale.isSelected()) {
                gender = "Male";
            } else if (radioFemale.isSelected()) {
                gender = "Female";
            }

            String Gender = gender;
            String licenseNO = txtCustomerLicenseNO.getText();
            String country = txtCustomerCountry.getText();
            
//                        
//  if(validateNIC()) {  
//         if(validateName()){
//                if(validateMobileNumber()){
//                        if(validateLicenseNO()){
//                                if(validateCountry()){
//                                    if(validatePassportID()){
                                

            CustomerDTO customer = new CustomerDTO(NIC, PassportID, name, address, dob, Cphone, Gender, licenseNO, country);
            boolean isAdded = customerBO.saveCustomer(customer);
            if (isAdded) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Added Success", ButtonType.OK);
                a1.show();
                btnClearTxtField(event);
                loadAllCustomers();
            } else {
                Alert a2 = new Alert(Alert.AlertType.ERROR, "Field", ButtonType.OK);
                a2.show();

            }
//                                    
//                                    }else{
//                                        Alert a1=new Alert(Alert.AlertType.ERROR, "Validate Customer Passport ID ", ButtonType.OK);
//                                        a1.show();
//                        
//                                    }}else{
//                                        Alert a1=new Alert(Alert.AlertType.ERROR, "Validate Customer Country ", ButtonType.OK);
//                                        a1.show();
//                        
//                                }}else{
//                                        Alert a1=new Alert(Alert.AlertType.ERROR, "Validate Customer License NO ", ButtonType.OK);
//                                        a1.show();
//                        
//                        }}else{
//                                        Alert a1=new Alert(Alert.AlertType.ERROR, "Validate Customer Mobile NO ", ButtonType.OK);
//                                        a1.show();
//                        
//                }}else{
//                                        Alert a1=new Alert(Alert.AlertType.ERROR, "Validate Customer NIC ", ButtonType.OK);
//                                        a1.show();
//                        
//         
//         }}           
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    private void InitializeToggleGroup() {
        genderGroup = new ToggleGroup();
        radioMale.setToggleGroup(genderGroup);
        radioFemale.setToggleGroup(genderGroup);
    }

    @FXML
    private void btnUpdate(MouseEvent event) {
        try {
            String NIC = txtCustomerNIC.getText();
            String PassportID = txtCustomerPasspordID.getText();
            String name = txtCustomerName.getText();
            String address = txtCustomerAddress.getText();
            String dob = setCustomerBirthday.getValue().toString();
            String Cphone = txtCustomerMobileNumber.getText();

            if (radioMale.isSelected()) {
                gender = "Male";
            } else if (radioFemale.isSelected()) {
                gender = "Female";
            }

            String Gender = gender;

            String licenseNO = txtCustomerLicenseNO.getText();
            String country = txtCustomerCountry.getText();

            CustomerDTO customer = new CustomerDTO(NIC, PassportID, name, address, dob, Cphone, Gender, licenseNO, country);
            boolean isAdded = customerBO.updateCustomer(customer);
            if (isAdded) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Updated Success", ButtonType.OK);
                a1.show();
            } else {
                Alert a2 = new Alert(Alert.AlertType.ERROR, "Field", ButtonType.OK);
                a2.show();

            }

            loadAllCustomers();
            btnClearTxtField(event);
        } catch (Exception ex) {
            Logger.getLogger(manageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnRemove(MouseEvent event) throws Exception {
        CustomerTM selecteCustomer = tblCustomer.getSelectionModel().getSelectedItem();
        if (selecteCustomer == null) {
            return;
        }
        boolean result = customerBO.deleteCustomer(selecteCustomer.getNIC());
        if (result) {

            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Deleted Success", ButtonType.OK);
            a1.show();
        } else {
            Alert a2 = new Alert(Alert.AlertType.ERROR, "Field", ButtonType.OK);
            a2.show();
        }
        loadAllCustomers();
    }

    @FXML
    private void btnClearTxtField(MouseEvent event) {

        txtCustomerAddress.setText(null);
        txtCustomerCountry.setText(null);
        txtCustomerLicenseNO.setText(null);
        txtCustomerMobileNumber.setText(null);
        txtCustomerNIC.setText(null);
        txtCustomerName.setText(null);
        txtCustomerPasspordID.setText(null);
        genderGroup.selectToggle(null);
        setCustomerBirthday.setValue(null);

    }

    @FXML
    private void tblRowClicked(MouseEvent event) {
        CustomerTM alCustomer = tblCustomer.getSelectionModel().getSelectedItem();

        txtCustomerNIC.setText(alCustomer.getNIC());
        txtCustomerAddress.setText(alCustomer.getAddress());
        txtCustomerCountry.setText(alCustomer.getCountry());
        txtCustomerLicenseNO.setText(alCustomer.getLicense_No());
        txtCustomerMobileNumber.setText(alCustomer.getCphone());
        txtCustomerPasspordID.setText(alCustomer.getPassport_ID());
        txtCustomerName.setText(alCustomer.getName());
        setCustomerBirthday.setValue(LocalDate.parse(alCustomer.getDOB()));
        String gender1 = alCustomer.getGender();

        if (gender1.equals("Female")) {
            genderGroup.selectToggle(radioFemale);
        } else if (gender1.equals("Male")) {
            genderGroup.selectToggle(radioMale);
        }
    }

    private void loadTable(MouseEvent event) {

        loadAllCustomers();
        btnClearTxtField(event);

    }

    @FXML
    private void searchCustomer(ActionEvent event) {
          String nic = txtSearchCustomerNIC.getText();
        
        try {
            String[] member = customerBO.searchCustomer(nic);
            if (member != null) {
                txtCustomerAddress.setText(member[3]);
                txtCustomerCountry.setText(member[8]);
                txtCustomerLicenseNO.setText(member[7]);
                txtCustomerMobileNumber.setText(member[5]);
                txtCustomerNIC.setText(member[0]);
                txtCustomerName.setText(member[2]);
                txtCustomerPasspordID.setText(member[1]);
                setCustomerBirthday.setValue(LocalDate.parse(member[4]));
                
                 String gender=member[6];
                 if (gender.equals("Male")) {
                        radioMale.setSelected(true);
                     }else{
                     radioFemale.setSelected(true);
                 
                 }

                
                
            }else{
                
                Alert a1=new Alert(Alert.AlertType.INFORMATION, "Customer not Found", ButtonType.OK);
                a1.show();
                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private boolean validateNIC(){
        String NIC=txtCustomerNIC.getText();
        
        boolean match=NIC.matches("[0-9]{9,15}[a-zA-Z]{1,1}");
        return match;
         
   }
  
   private boolean validateName(){
        String name = txtCustomerName.getText();
        boolean match=name.matches("^[a-zA-Z]{1,100}[ ][a-zA-Z]{1,100}$");
        return match;
   
   }
  
   private boolean  validateMobileNumber(){
        String mobNO = txtCustomerMobileNumber.getText();
        boolean match=mobNO.matches("[0-9]{10,12}");
        return match;
   
   }
   
   private boolean validateLicenseNO(){
        String licenseNO=txtCustomerLicenseNO.getText();
        boolean match=licenseNO.matches("[a-zA-Z]{1,1}[0-9]{6,10}");
        return  match;
   
   }
   
   private boolean validatePassportID(){
       String passportID=txtCustomerPasspordID.getText();
       boolean match=passportID.matches("[0-9]");
       return match;
   }
   
   private boolean validateCountry(){
       String country=txtCustomerCountry.getText();
       boolean match=country.matches("[a-zA-Z]+");
       return match;
       
   }

}
