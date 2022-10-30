/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import lk.ijse.vehicle_rental.business.custom.CategoryBO;
import lk.ijse.vehicle_rental.business.custom.FuelBO;
import lk.ijse.vehicle_rental.business.custom.VehicleBO;
import lk.ijse.vehicle_rental.dto.CategoryDTO;
import lk.ijse.vehicle_rental.dto.FuelDTO;
import lk.ijse.vehicle_rental.dto.VehicleDTO;
import lk.ijse.vehicle_rental.view.util.tbmodel.VehicleTM;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class AddVehicleController implements Initializable {

    @FXML
    private JFXTextField txtMaxPassengers;
    @FXML
    private JFXTextField txtDoors;
    @FXML
    private JFXTextField txtPricePerDay;
    @FXML
    private JFXTextField txtVehicleBrand;
    @FXML
    private JFXTextField txtVehicleModel;
    @FXML
    private JFXTextField txtGearbox;
    private JFXTextField txtFuel;
    @FXML
    private JFXTextField txtColor;

    private VehicleBO vehicleBO;

    private CategoryBO categoryBO;

    @FXML
    private TableView<VehicleTM> tblVehicle;
    @FXML
    private JFXTextField txtVehicleNO;

    @FXML
    private JFXTextField txtSearchVehicle;
    @FXML
    private JFXComboBox<String> cmdCategory;
    @FXML
    private JFXComboBox<String> cmdFuel;

    private FuelBO fuelBO;

    /**
     * Initializes the controller class.
     */
    private void loadAllVehicle() {
        try {
            ArrayList<VehicleDTO> alVehicle = vehicleBO.getAllVehicle();
            ObservableList<VehicleTM> olVehicle = tblVehicle.getItems();
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

        getCategory();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vehicleBO = (VehicleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.VEHICLE);
        categoryBO = (CategoryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CATEGORY);
        fuelBO = (FuelBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.FUEL);

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

        getCategory();
        getFuel();

    }

    @FXML
    private void tblRowClicked(MouseEvent event) {
        VehicleTM vehicleTM = tblVehicle.getSelectionModel().getSelectedItem();

        cmdCategory.setValue(vehicleTM.getCID());
        txtColor.setText(vehicleTM.getColor());
        txtDoors.setText(Integer.toString(vehicleTM.getDoors()));
        cmdFuel.setValue(vehicleTM.getFID());
        txtGearbox.setText(vehicleTM.getGearbox());
        txtMaxPassengers.setText(Integer.toString(vehicleTM.getMax_Passengers()));
        txtPricePerDay.setText(Double.toString(vehicleTM.getPrice_Per_Day()));
        txtVehicleBrand.setText(vehicleTM.getBrand());
        txtVehicleModel.setText(vehicleTM.getModel());
        txtVehicleNO.setText(vehicleTM.getVehicle_No());
    }

    @FXML
    private void btnAdd(MouseEvent event) {
        try {
            String vehicleNO = txtVehicleNO.getText();
            String CID = categoryBO.getCatID(cmdCategory.getSelectionModel().getSelectedItem());
            String brand = txtVehicleBrand.getText();
            String model = txtVehicleModel.getText();
            String gearbox = txtGearbox.getText();
            String fuel = fuelBO.getFualID(cmdFuel.getSelectionModel().getSelectedItem());
            int maxPassengers = Integer.parseInt(txtMaxPassengers.getText());
            int doors = Integer.parseInt(txtDoors.getText());
            String color = txtColor.getText();
            double pricePerDay = Double.parseDouble(txtPricePerDay.getText());

            System.out.println("ksjdkfj " + CID);

            VehicleDTO vehicle = new VehicleDTO(vehicleNO, CID, brand, model, gearbox, fuel, maxPassengers, doors, color, pricePerDay);
            System.out.println(vehicle);

            boolean result = vehicleBO.saveVehicle(vehicle);

            if (result) {
                loadAllVehicle();
                btnClearTxtField(event);

                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle has been successfully Saved", ButtonType.OK).show();
            } else {
                loadAllVehicle();
                new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK).show();

            }

        } catch (Exception ex) {
            Logger.getLogger(AddVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUpdate(MouseEvent event) {
        try {
            String vehicleNO = txtVehicleNO.getText();
            String CID = cmdCategory.getSelectionModel().getSelectedItem();
            String brand = txtVehicleBrand.getText();
            String model = txtVehicleModel.getText();
            String gearbox = txtGearbox.getText();
            String fuel = cmdFuel.getSelectionModel().getSelectedItem();
            int maxPassengers = Integer.parseInt(txtMaxPassengers.getText());
            int doors = Integer.parseInt(txtDoors.getText());
            String color = txtColor.getText();
            double pricePerDay = Double.parseDouble(txtPricePerDay.getText());

            VehicleDTO vehicle = new VehicleDTO(vehicleNO, CID, brand, model, gearbox, CID, maxPassengers, doors, color, pricePerDay);

            boolean result = vehicleBO.updateVehicle(vehicle);

            if (result) {
                loadAllVehicle();
                btnClearTxtField(event);

                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle has been successfully Updated", ButtonType.OK).show();
            } else {
                loadAllVehicle();
                new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK).show();

            }

        } catch (Exception ex) {
            Logger.getLogger(AddVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnRemove(MouseEvent event) {
        try {
            VehicleTM selecteVehicle = tblVehicle.getSelectionModel().getSelectedItem();

            if (selecteVehicle == null) {
                return;
            }
            boolean result = vehicleBO.removeVehicle(selecteVehicle.getVehicle_No());
            if (result) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Vehicle has been successfully Deleted", ButtonType.OK);
                a1.show();
            } else {
                Alert a2 = new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK);
                a2.show();

            }
        } catch (Exception ex) {
            Logger.getLogger(DriverController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnClearTxtField(MouseEvent event) {
        cmdFuel.getSelectionModel().clearSelection();
        txtColor.clear();
        txtDoors.clear();
        cmdCategory.getSelectionModel().clearSelection();
        txtGearbox.clear();
        txtMaxPassengers.clear();
        txtPricePerDay.clear();
        txtVehicleBrand.clear();
        txtVehicleModel.clear();
        txtVehicleNO.clear();
        txtSearchVehicle.clear();
    }

    @FXML
    private void imgRefresh(MouseEvent event) {
        loadAllVehicle();
    }

    private void loadTable(MouseEvent event) {

        loadAllVehicle();

    }

    @FXML
    private void searchCustomer(ActionEvent event) {
        String VID = txtSearchVehicle.getText();

        try {
            String[] vehicleNO = vehicleBO.searchVehicle(VID);
            if (vehicleNO != null) {
                txtVehicleNO.setText(vehicleNO[0]);
                cmdCategory.setAccessibleHelp(vehicleNO[1]);
                txtVehicleBrand.setText(vehicleNO[2]);
                txtVehicleModel.setText(vehicleNO[3]);
                txtGearbox.setText(vehicleNO[4]);
                cmdFuel.setAccessibleHelp(vehicleNO[5]);
                txtMaxPassengers.setText(vehicleNO[6]);
                txtDoors.setText(vehicleNO[7]);
                txtColor.setText(vehicleNO[8]);
                txtPricePerDay.setText(vehicleNO[9]);

            } else {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Driver not Found", ButtonType.OK);
                a1.show();
            }

        } catch (Exception ex) {
            Logger.getLogger(AddCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getCategory() {
        ArrayList<CategoryDTO> alCategory;
        try {
            alCategory = categoryBO.getAllCategory();
            ObservableList<String> olCategory = cmdCategory.getItems();
            olCategory.removeAll(olCategory);
            for (CategoryDTO catergory : alCategory) {
                olCategory.add(catergory.getCategoryName());

            }

        } catch (Exception ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getFuel() {
        ArrayList<FuelDTO> alFuel;
        try {
            alFuel = fuelBO.getAllFuel();
            ObservableList<String> olFuel = cmdFuel.getItems();
            olFuel.removeAll(olFuel);
            for (FuelDTO dTO : alFuel) {
                olFuel.add(dTO.getFuelName());
            }

        } catch (Exception ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
