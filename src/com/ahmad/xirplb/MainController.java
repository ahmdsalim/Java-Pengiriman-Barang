/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.xirplb;

import com.ahmadpengirimanbarang.xirplb.DataTransaksi;
import com.ahmadpengirimanbarang.xirplb.Tujuan;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author LABKOM2-RPL01
 */
public class MainController implements Initializable {

    @FXML
    private Button proses;
    @FXML
    private Button cetak_resi;
    @FXML
    private Button list_data_transaksi;
    @FXML
    private AnchorPane data_pengirim;
    @FXML
    private TextArea alamat_pengirim;
    @FXML
    private TextField nama_pengirim;
    @FXML
    private TextField no_tlp_pengirim;
    @FXML
    private AnchorPane data_pengiriman;
    @FXML
    private TextField berat_barang;
    @FXML
    private TextField biaya_perkilo;
    @FXML
    private TextField jenis_barang;
    @FXML
    private TextArea keterangan_barang;
    @FXML
    private TextArea total;
    @FXML
    private ComboBox tipe_layanan;
    @FXML
    private AnchorPane data_penerima;
    @FXML
    private TextArea alamat_penerima;
    @FXML
    private TextField nama_penerima;
    @FXML
    private TextField no_tlp_penerima;
    @FXML
    private ComboBox kota_penerima;
    @FXML
    private Button btn_logout;

    /**
     * Initializes the controller class.
     */
    DataTransaksi dt = new DataTransaksi();
    
    private MainForm application;
    
    public void setApp(MainForm application){
        this.application = application;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Tujuan tujuan = new Tujuan();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
        tujuan.listKota.add(0, "Pilih Kota");
        tujuan.listLayanan.add(0, "Pilih Layanan");
        
        kota_penerima.getItems().addAll(
        tujuan.listKota
        );
        
        tipe_layanan.getItems().addAll(
        tujuan.listLayanan
        );
        
        total.setEditable(false);
        biaya_perkilo.setEditable(false);
        cetak_resi.setDisable(true);
        kota_penerima.getSelectionModel().selectFirst();
        tipe_layanan.getSelectionModel().selectFirst();
        
        berat_barang.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")){
                berat_barang.setText(oldValue);
                }
            }
            
        });
        
        tipe_layanan.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(kota_penerima.getSelectionModel().getSelectedIndex() != 0){
                    tujuan.pilihLayanan(kota_penerima.getSelectionModel().getSelectedItem().toString(),
                            tipe_layanan.getSelectionModel().getSelectedItem().toString());
                    biaya_perkilo.setText(formatter.format(tujuan.hargaPengiriman));
                }
            }
            
        });
        
        kota_penerima.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(tipe_layanan.getSelectionModel().getSelectedIndex() != 0){
                    tujuan.pilihLayanan(kota_penerima.getSelectionModel().getSelectedItem().toString(),
                            tipe_layanan.getSelectionModel().getSelectedItem().toString());
                    biaya_perkilo.setText(formatter.format(tujuan.hargaPengiriman));
                }
            }
            
        });
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
        if(application != null){
            String notif = "";
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to process?");
            
            Optional <ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                if("".equals(berat_barang.getText())) notif = notif + "Berat Barang,";
                else if(Double.parseDouble(berat_barang.getText()) > 20) notif = notif + "Berat tidak boleh melebihi 20kg dan ";
                if("".equals(nama_pengirim.getText())) notif = notif + "Nama Pengirim,";
                if("".equals(alamat_pengirim.getText())) notif = notif + "Alamat Pengirim,";
                if("".equals(no_tlp_pengirim.getText())) notif = notif + "No Telepon Pengirim,";
                if("".equals(nama_penerima.getText())) notif = notif + "Nama Penerima,";
                if("".equals(alamat_penerima.getText())) notif = notif + "Alamat Penerima,";
                if("".equals(no_tlp_penerima.getText())) notif = notif + "No Telepon Penerima,";
                if(kota_penerima.getSelectionModel().getSelectedIndex() == 0) notif = notif + "Kota Penerima,";
                if(tipe_layanan.getSelectionModel().getSelectedIndex() == 0) notif = notif + "Layanan,";
                if("".equals(jenis_barang.getText())) notif = notif + "Jeni Barang,";
                if("".equals(berat_barang.getText())) notif = notif + "Berat Barang,";
                if("".equals(keterangan_barang.getText())) notif = notif + "Keterangan,";
                
                if(!notif.equals("")){
                    Alert alert2 = new Alert(Alert.AlertType.WARNING);
                    alert2.setTitle("Warning Dialog");
                    alert2.setHeaderText(null);
                    alert2.setContentText(notif + " Tidak Boleh Kosong!");
                    
                    alert2.showAndWait();
                } else {
                    NumberFormat formatter = NumberFormat.getCurrencyInstance();
                    
                    dt.inputDataPengirim(nama_pengirim.getText(), alamat_pengirim.getText(), no_tlp_pengirim.getText());
                    
                    dt.inputDataPenerima(nama_penerima.getText(), alamat_penerima.getText(), no_tlp_penerima.getText());
                    
                    double total1 = dt.inputDataBarang(kota_penerima.getSelectionModel().getSelectedItem().toString(),
                            tipe_layanan.getSelectionModel().getSelectedItem().toString(),
                            jenis_barang.getText(),Double.parseDouble(berat_barang.getText()),
                            keterangan_barang.getText());
                    total.setText(formatter.format(total1));
                    cetak_resi.setDisable(false);
                    proses.setDisable(true);
                    
                    application.dataAllResi.dataTransaksi.add(dt);
                }
            } else {
                alert.close();
            }
        }
    }
    
    public void prosesCetak(){
        if (application != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                application.userResi(dt);
            } else{
                alert.close();
            }
        }
    }
    
    public void prosesList(){
        if(application != null){
        application.userList();
    }
    }
    
}
