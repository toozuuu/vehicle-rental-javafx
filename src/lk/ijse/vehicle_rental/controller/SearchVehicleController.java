/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
public class SearchVehicleController implements Initializable {

    @FXML
    private AnchorPane searchVehiclePane;
    @FXML
    private JFXComboBox<String> cmdFuel;
    @FXML
    private JFXComboBox<String> cmdCategory;
    @FXML
    private TableView<VehicleTM> tblVehicle;

    private VehicleBO vehicleBO;
    
    private CategoryBO categoryBO;
    
    private FuelBO fuelBO;
    
    private VehicleDTO vehicleDTO;
//    private 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vehicleBO = (VehicleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.VEHICLE);
        categoryBO=(CategoryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CATEGORY);
        fuelBO=(FuelBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.FUEL);

        getCategory();
        
        getFuel();

    }

    @FXML
    private void btnSearch(MouseEvent event)  {
        try {
            String Vcategory=cmdCategory.getSelectionModel().getSelectedItem();
            String Vfuel=cmdFuel.getSelectionModel().getSelectedItem();
            
            vehicleDTO=new VehicleDTO(Vcategory, Vfuel);
            vehicleBO.rentVehicle(vehicleDTO);
        } catch (Exception ex) {
            Logger.getLogger(SearchVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnBookNow(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/addCustomer.fxml"));
            searchVehiclePane.getChildren().clear();
            searchVehiclePane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(SearchVehicleController.class.getName()).log(Level.SEVERE, null, ex);
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

    @FXML
    private void tblRowClicked(MouseEvent event) {
    }

}
