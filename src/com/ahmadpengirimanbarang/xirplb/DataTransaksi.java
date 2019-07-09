/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadpengirimanbarang.xirplb;

import java.util.Scanner;

/**
 *
 * @author LABKOM2-RPL01
 */
public class DataTransaksi extends Resi {
    public String namaPengirim;
    public String alamatPengirim;
    public String noTelponPengirim;
    public String namaPenerima;
    public String alamatPenerima;
    public String kotaPenerima;
    public String noTelponPenerima;
    public double berat;
    public String jenisBarang;
    public String keterangan;
    public String layanan;
    Scanner sc = new Scanner(System.in);
    
    public void inputDataPengirim(String nama, String alamat, String noTelepon){
        namaPengirim = nama;
        alamatPengirim = alamat;
        noTelponPengirim = noTelepon;
    }
    public void inputDataPenerima(String nama, String alamat, String noTelepon){
        namaPenerima = nama;
        alamatPenerima = alamat;
        noTelponPenerima = noTelepon;
    }
    
    public double inputDataBarang(String kota, String tipe, String jenis, double berat, String keteranganBarang){
        
        Tujuan tujuan = new Tujuan();
        
        tujuan.kotaLayanan = kota;
        tujuan.tipeLayanan = tipe;
        tujuan.pilihLayanan(kota, tipe);
        
        kotaPenerima = kota;
        layanan = tipe;
        jenisBarang = jenis;
        keterangan = keteranganBarang;
        
        this.berat = berat;
        return tujuan.kalkulasiHarga(berat);
    }
    
}
