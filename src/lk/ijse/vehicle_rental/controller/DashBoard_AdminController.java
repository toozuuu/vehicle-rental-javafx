/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class DashBoard_AdminController implements Initializable {

    @FXML
    private AnchorPane adminPane;
    @FXML
    private Label curTime;
    @FXML
    private AnchorPane adminLoadPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/homeForm.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       this.loadCurrentTime();
        
    }    

    @FXML
    private void adminClickedHome(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/homeForm.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adminClickedResivetionDetail1(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/reservationForm.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adminClickedVehicle(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/addVehicle.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void userClickedBooking(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/searchVehicle.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adminClickedDrivers(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/driverForm.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adminClickedMaintenance(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/maintenanceForm.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adminClickedPayments(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/paymentFormDashBoard.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void adminClickedUsers(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/addUser.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adminReport(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/reportsForm.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imgBack(MouseEvent event) throws IOException {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirmation Dialog");
                        alert.setHeaderText("Look, a Confirmation Dialog");
                        alert.setContentText("Are You Want to LogOut");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK){
                               
                                    Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/loginMain.fxml"));
                                    Scene temp=new Scene(root);
                                    Stage stage=(Stage)this.adminLoadPane.getScene().getWindow();
                                    stage.setScene(temp);
                                    stage.setResizable(false);
                                    stage.centerOnScreen();
                        } 
    }
    
 private void loadCurrentTime() {
        Timeline timeLine = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Calendar times = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                        curTime.setText(simpleDateFormat.format(times.getTime()));
                    }
                }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }

    @FXML
    private void adminClickedCustomer(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/manageCustomer.fxml"));
            adminLoadPane.getChildren().clear();
            adminLoadPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
