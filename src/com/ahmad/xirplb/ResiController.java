/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.xirplb;

import com.ahmadpengirimanbarang.xirplb.Admin;
import com.ahmadpengirimanbarang.xirplb.DataTransaksi;
import com.ahmadpengirimanbarang.xirplb.Tujuan;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author LABKOM2-RPL01
 */
public class ResiController implements Initializable {

    @FXML
    Text txtNamaPengirim;
    @FXML
    Text txtNoTeleponPengirim;
    @FXML
    Text txtAlamatPengirim;
    @FXML
    Text txtNamaPenerima;
    @FXML
    Text txtNoTeleponPenerima;
    @FXML
    Text txtAlamatPenerima;
    @FXML
    Text txtKota;
    @FXML
    Text txtJenisBarang;
    @FXML
    Text txtBerat;
    @FXML
    Text txtKeterangan;
    @FXML
    Text txtTipeLayanan;
    @FXML
    Text txtEstimasi;
    @FXML
    Text txtNamaPetugas;
    @FXML
    Text txtTotal;
    @FXML
    Text txtTanggal;
    @FXML
    Text txtNoResi;
    

    /**
     * Initializes the controller class.
     */
    private MainForm application;
    
    public void setApp(MainForm application, DataTransaksi dt) {
        this.application = application;
        
        tampilData(dt);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void tampilData(DataTransaksi dt) {
      Tujuan tujuan = new Tujuan();
      Admin admin = new Admin();
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      
      tujuan.kotaLayanan = dt.kotaPenerima;
      tujuan.tipeLayanan = dt.layanan;
      tujuan.pilihLayanan(dt.kotaPenerima, dt.layanan);
      
      txtNamaPengirim.setText(dt.namaPengirim);
      txtNoTeleponPengirim.setText(dt.noTelponPengirim);
      txtAlamatPengirim.setText(dt.alamatPengirim);
      txtNamaPenerima.setText(dt.namaPenerima);
      txtNoTeleponPenerima.setText(dt.noTelponPenerima);
      txtAlamatPenerima.setText(dt.alamatPenerima);
      txtKota.setText(dt.kotaPenerima);
      txtJenisBarang.setText(dt.jenisBarang);
      txtBerat.setText(dt.berat + " Kg");
      txtKeterangan.setText(dt.keterangan);
      txtTipeLayanan.setText(dt.layanan);
      txtEstimasi.setText(tujuan.estimasi);
      txtNamaPetugas.setText(admin.namaAdmin);
      txtTotal.setText(formatter.format(tujuan.kalkulasiHarga(dt.berat)));
      txtNoResi.setText(dt.nomorResi);
      txtTanggal.setText(dt.tanggalPengiriman);
    }
    @FXML
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
    
    @FXML
    public void prosesBack(){
        if (application != null){
            application.userMain();
        }
    }
    
    
}
