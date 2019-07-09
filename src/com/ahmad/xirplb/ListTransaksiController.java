/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.xirplb;

import com.ahmadpengirimanbarang.xirplb.DataTransaksi;
import com.ahmadpengirimanbarang.xirplb.Resi;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author LABKOM2-RPL01
 */
public class ListTransaksiController implements Initializable {

    @FXML
    private TableView<String> tblData;
    @FXML
    private TableColumn<String, String> no_resi;
    @FXML
    private TableColumn<String, String> nama_pengirim;
    @FXML
    private TableColumn<String, String> kota_tujuan;
    @FXML
    private TableColumn<String, String> tanggal;

    /**
     * Initializes the controller class.
     */
       private MainForm application;
    
    public void setApp(MainForm application,Resi resi){
        this.application = application;
        
        for(DataTransaksi element : resi.dataTransaksi){
            no_resi.setCellValueFactory(c -> new SimpleStringProperty(new String(element.nomorResi)));
            nama_pengirim.setCellValueFactory(c -> new SimpleStringProperty(new String(element.namaPengirim)));
            kota_tujuan.setCellValueFactory(c -> new SimpleStringProperty(new String(element.kotaPenerima)));
            tanggal.setCellValueFactory(c -> new SimpleStringProperty(new String(element.tanggalPengiriman)));
            tblData.getItems().addAll("Abcd");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void prosesLogout(){
        if (application != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                application.userLogout();
            } else{
                alert.close();
            }
        }
    }
    
    public void prosesTransaksi(){
        if (application != null){
            application.userMain();
        }
    }
}
