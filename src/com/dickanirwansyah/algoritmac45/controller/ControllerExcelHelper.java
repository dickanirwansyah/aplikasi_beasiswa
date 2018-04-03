/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.controller;

import com.dickanirwansyah.algoritmac45.helper.ExcelHelper;
import com.dickanirwansyah.algoritmac45.panel.PanelTraining;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dickajava
 */
//public class ControllerExcelHelper implements ActionListener{
//
//    ExcelHelper excelHelper = new ExcelHelper();
//    PanelTraining panelTraining = new PanelTraining();
//    JFileChooser chooserSelected = new JFileChooser();
//    File file;
//    int contAction = 0;
//    
//    public ControllerExcelHelper(PanelTraining panelTraining, ExcelHelper excelHelper){
//        this.panelTraining = panelTraining;
//        this.excelHelper = excelHelper;
//        this.panelTraining.btnImportTraining.addActionListener(this);
//    }
//    
//    public void prosesFilter(){
//        chooserSelected.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
//        chooserSelected.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
//    }
//    
////    public void ControllerImportFile(PanelTraining panelTraining){
//        contAction ++;
//        if(contAction == 1)prosesFilter();
//        
//        if(chooserSelected.showDialog(null, "pilih file excel")
//                == JFileChooser.APPROVE_OPTION){
//            file = chooserSelected.getSelectedFile();
//            if(file.getName().endsWith("xls") || file.getName().endsWith("xlsx")){
//                JOptionPane.showMessageDialog(null, excelHelper.prosesImport(file, 
//                        panelTraining.getDynamicDataTraining()));
//            }else{
//                JOptionPane.showMessageDialog(null, "maaf ini bukan file excel");
//            }
//        }
//    }
    
//    @Override
//    public void actionPerformed(ActionEvent e) {
//      contAction++;
//      if(contAction == 1)prosesFilter();
//      
//      if(e.getSource() == panelTraining.btnImportTraining){
//          if(chooserSelected.showDialog(null, "selected file excel") 
//                  == JFileChooser.APPROVE_OPTION){
//              
//              file = chooserSelected.getSelectedFile();
//              if(file.getName().endsWith("xls") || file.getName().endsWith("xlsx")){
//                  JOptionPane.showMessageDialog(null, excelHelper.prosesImport(file, 
//                          panelTraining.getDynamicDataTraining()));
//              }else{
//                  JOptionPane.showMessageDialog(null, "maaf ini bukan file excel");
//              }
//          }
//      }
//      
//      //nanti untuk file export
//    }
//    
////}
