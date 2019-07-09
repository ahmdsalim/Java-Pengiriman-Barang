/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.xirplb;

import com.ahmadpengirimanbarang.xirplb.Admin;
import com.ahmadpengirimanbarang.xirplb.DataTransaksi;
import com.ahmadpengirimanbarang.xirplb.Resi;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author LABKOM2-RPL 3
 */
public class MainForm extends Application {
    private Group root = new Group();
    private Admin loggedUser;
    public Resi dataAllResi = new Resi();
    
    public Parent createContent(){
        gotoLogin();
        return root;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public boolean userLogging(String nik, String password){
        loggedUser = new Admin();
        if(loggedUser.validate(nik,password)){
            gotoMain();
            return true;
        }else{
            return false;
        }
    }
    void userList(){
        gotoList(dataAllResi);
    }
    void userMain(){
        gotoMain();
    }
    void userLogout(){
        gotoLogin();
    }
    void userResi(DataTransaksi dt){
        gotoResi(dt);
    }
    private void gotoMain(){
        try{
            MainController profile =
                    (MainController)replaceSceneContent("formtransaksi.fxml");
            profile.setApp(this);
        }catch (Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void gotoList(Resi resi){
        try{
            ListTransaksiController profile =
                    (ListTransaksiController)replaceSceneContent("listTransaksi.fxml");
            profile.setApp(this,resi);
        }catch (Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void gotoLogin(){
        try{
            LoginController login =
                    (LoginController)replaceSceneContent("login.fxml");
            login.setApp(this);
        }catch(Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void gotoResi(DataTransaksi dt){
        try{
            ResiController resi =
                    (ResiController)replaceSceneContent("resi.fxml");
            resi.setApp(this,dt);
        }catch(Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,ex);
        }
    }
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainForm.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainForm.class.getResource(fxml));
        AnchorPane page;
        
        try{
            page = (AnchorPane) loader.load(in);
        }finally{
            in.close();
        }
        root.getChildren().removeAll();
        root.getChildren().addAll(page);
        
        return (Initializable)loader.getController();
    }
}
