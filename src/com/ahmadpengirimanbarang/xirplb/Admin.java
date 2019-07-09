/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadpengirimanbarang.xirplb;

/**
 *
 * @author LABKOM2-RPL 2
 */
public class Admin {
    public String namaAdmin;
    public String nikAdmin;
    public String passwordAdmin;
    
    public Admin(){
        namaAdmin = "Ahmad Salim A";
        nikAdmin = "1234";
        passwordAdmin = "sama";
    }
    
    public boolean validate(String nik, String password){
        if (nikAdmin.equals(nik) && passwordAdmin.equals(password)) {
            return true;
        }else{
            return false;
        }
    
    }
    
    
}