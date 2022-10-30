/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.controller;

import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author zoomcoder
 */
public class BackupDataController implements Initializable {

    @FXML
    private JFXTextField txtBrowsePath;
    @FXML
    private Label labelField;
    
    String path=null;
    String filename;
    Date date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBackupNow(MouseEvent event) {
        
          if (labelField.getText().equals("")){
            
         
        }
        else{
            try{
                String dbname = labelField.getText();
                String dbuser = "root";
                String dbpass = "root";
                String folderpath = "src" + "\\Backup database";
                
                File fl = new File(folderpath);
                fl.mkdir();
                
                String savepath = "\"" + folderpath + "\\" + "" + dbname +  ""+".sql\"";
                String execudecmd = "mysqldump -u" + dbuser + " -p" + dbpass + " --database " + dbname + " -r " + savepath;
                Process runtimeprocess = Runtime.getRuntime().exec(execudecmd);
                int processcomplete = runtimeprocess.waitFor();
                
                if (processcomplete == 0){
                  labelField.setText("Backup Created Succuss");
                }
                else{
                    labelField.setText("Can't Create Backup ");
                     File f2 = new File("src\\Backup Database\\"+ dbname+".sql");
                     f2.delete();
                }
                
            }catch(IOException | InterruptedException e){
            }
        }
        
       
    }

    @FXML
    private void btnRestoreNow(MouseEvent event) {
         if (labelField.getText().equals("")){
            //JOptionPane.showMessageDialog(rootPane,"Ketik Nama Database");
         
        }
        else{
            try{
                String dbname = labelField.getText();
                String dbuser = "root";
                String dbpass = "dilshannew";
                String folderpath = "src" + "\\Backup Database";
                
                String restorepath = "src\\Backup Database\\"+ dbname+".sql";
                String[] execudecmd = new String[] {"mysql", "--user=" +dbuser, "--password=" +dbpass, dbname,"-e"," source " + restorepath}; 
                  
                Process runtimeprocess = Runtime.getRuntime().exec(execudecmd);
                int processcomplete = runtimeprocess.waitFor();
                
                if (processcomplete == 0){
                     labelField.setText("Backup Created Succuss");
                }
                else{
                    labelField.setText("Can't Create Backup ");
                    
                }
                
            }catch(IOException | InterruptedException e){
            }
        }
    }
    
    
    
    
    
    
    
    
}
