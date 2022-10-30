/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.main;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author zoomcoder
 */
public class Main  extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root=FXMLLoader.load(this.getClass().getResource("/lk/ijse/vehicle_rental/view/login.fxml"));
        Scene temp=new Scene(root);
        primaryStage.setTitle("Ryder");
        primaryStage.setScene(temp);
        primaryStage.show();
        
        FadeTransition transition=new FadeTransition(Duration.millis(1000),root);
        transition.setFromValue(0.0);
        transition.setToValue(1.0);
        transition.play();
    }
    
}
