/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.controller;

import com.dickanirwansyah.algoritmac45.dao.StaffDaoImpl;
import com.dickanirwansyah.algoritmac45.entity.Staff;
import com.dickanirwansyah.algoritmac45.panel.PanelStaff;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author dickajava
 */
public class ControllerStaff {
    
    private StaffDaoImpl daoImpl;
    public ControllerStaff(){
        daoImpl = new StaffDaoImpl();
    }
    
    //validator
    private boolean validator(PanelStaff panelStaff){
        
        boolean valid = false;
        
        if(panelStaff.getTextNama().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama masih kosong");
        }else if(panelStaff.getTextUsername().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Username masih kosong");
        }else if(panelStaff.getTextPassword().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Password masih kosong");
        }else{
            valid = true;
        }
        return valid;
    }
    
 
    
    //reset and refresh
    private void reset(PanelStaff panelStaff){
        panelStaff.getTextNama().setText("");
        panelStaff.getTextPassword().setText("");
        panelStaff.getTextUsername().setText("");
    }
    
    //cretaed staff
    public Staff createdStaff(PanelStaff panelStaff){
         
        if(validator(panelStaff)){
            
            String nama = panelStaff.getTextNama().getText();
            String username = panelStaff.getTextUsername().getText();
            String password = panelStaff.getTextPassword().getText();
            
            
            Staff staff = new Staff();
            staff.setNama(nama);
            staff.setUsername(username);
            staff.setPassword(password);
            
            daoImpl.createdStaff(staff);
            reset(panelStaff);
        }
       return null;
    }
}
