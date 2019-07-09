/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadpengirimanbarang.xirplb;

import java.util.ArrayList;

/**
 *
 * @author LABKOM2-RPL01
 */
public class Tujuan {
    public String kotaLayanan;
    public String tipeLayanan;
    public double hargaPengiriman;
    public String estimasi;
    public ArrayList<String> listKota = new ArrayList<>();
    public ArrayList<String> listLayanan = new ArrayList<>();
    
    public Tujuan(){
        listKota.add("Jakarta");
        listKota.add("Yogyakarta");
        listKota.add("Surabaya");
        
        listLayanan.add("Ekspress");
        listLayanan.add("Regular");
        listLayanan.add("Normal");
    }
    
    public void pilihLayanan(String kota, String layanan){
        if(kota.equalsIgnoreCase("jakarta")){
            if(layanan.equalsIgnoreCase("ekspress")){
                hargaPengiriman = 25000;
                estimasi = "1 Hari";
            } else if(layanan.equalsIgnoreCase("normal")){
                hargaPengiriman = 15000;
                estimasi = "2 - 5 Hari";
            } else if(layanan.equalsIgnoreCase("regular")){
                hargaPengiriman = 10000;
                estimasi = "5 - 7 Hari";
            } 
        }
        else if(kota.equalsIgnoreCase("yogyakarta")){
            if(layanan.equalsIgnoreCase("ekspress")){
                hargaPengiriman = 35000;
                estimasi = "1 Hari";
            } else if(layanan.equalsIgnoreCase("normal")){
                hargaPengiriman = 25000;
                estimasi = "2 - 5 Hari";
            } else if(layanan.equalsIgnoreCase("regular")){
                hargaPengiriman = 20000;
                estimasi = "5 - 7 Hari";
            } 
        }
        else if(kota.equalsIgnoreCase("surabaya")){
            if(layanan.equalsIgnoreCase("ekspress")){
                hargaPengiriman = 45000;
                estimasi = "1 Hari";
            } else if(layanan.equalsIgnoreCase("normal")){
                hargaPengiriman = 35000;
                estimasi = "2 - 5 Hari";
            } else if(layanan.equalsIgnoreCase("regular")){
                hargaPengiriman = 30000;
                estimasi = "5 - 7 Hari";
            } 
        }
        
    }
    
    public double kalkulasiHarga(double berat){
        double subTotal;
        
        subTotal = berat * hargaPengiriman;
        
        return subTotal;
    }
}
