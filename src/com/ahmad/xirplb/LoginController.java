/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.xirplb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LABKOM2-RPL01
 */
public class LoginController implements Initializable {

    @FXML
    private TextField nik;
    @FXML
    private PasswordField password;
    @FXML
    private Button btn_login;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    private MainForm application;
    
    public void setApp(MainForm application){
        this.application = application;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void prosesLogin(ActionEvent event) {
        if (application == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Error Application Null");
            
            alert.showAndWait();
            
        }else{
            if (!application.userLogging(nik.getText(), password.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("NIK / Password is incorrect");
            
                alert.showAndWait();    
            } 
        }
    }
    @FXML
    void prosesMasuk(ActionEvent event){
        if(application != null){
            application.userMain();
        }
    }
    
}
