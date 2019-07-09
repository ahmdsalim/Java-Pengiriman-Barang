/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadpengirimanbarang.xirplb;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author LABKOM2-RPL01
 */
public class Resi {
    public String tanggalPengiriman;
    public String nomorResi;
    public ArrayList<DataTransaksi> dataTransaksi = new ArrayList<>();
    
    public Resi(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        tanggalPengiriman = dateFormat.format(cal.getTime());
        nomorResi = generateNomorResi();
    }

    private String generateNomorResi() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        
        return "RES" + dateFormat.format(cal.getTime());
    }
    
}
