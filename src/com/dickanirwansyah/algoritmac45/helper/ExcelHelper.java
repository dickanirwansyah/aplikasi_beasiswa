/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.helper;

import com.dickanirwansyah.algoritmac45.panel.PanelTraining;
import com.stripbandunk.jwidget.JDynamicTable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dickajava
 */
public class ExcelHelper {
    
    Workbook workbook;

    public String prosesImport(File file, JDynamicTable tabel){
        String messages = "tidak dapat memproses import file excel";
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tabel.setModel(defaultTableModel);
        
        try{
            workbook = WorkbookFactory.create(new FileInputStream(file));
            Sheet sheet = workbook.getSheetAt(0);
            Iterator fileIterator = sheet.rowIterator();
            int indiceFile = -1;
            
            while(fileIterator.hasNext()){
                indiceFile++;
                Row rowFile = (Row) fileIterator.next();
                Iterator columnIterator = rowFile.cellIterator();
                Object[] listColumn = new Object[8];
                int indiceColumn =-1;
                
                while(columnIterator.hasNext()){
                    indiceColumn++;
                    Cell cell = (Cell) columnIterator.next();
                    if(indiceFile == 0){
                        defaultTableModel.addColumn(cell.getStringCellValue());
                    }else{
                        if(cell!=null){
                            switch(cell.getCellType()){
                                case Cell.CELL_TYPE_NUMERIC:
                                    listColumn[indiceColumn] = Math.round(cell.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    listColumn[indiceColumn] = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    listColumn[indiceColumn] = cell.getBooleanCellValue();
                                    break;
                                default:
                                    listColumn[indiceColumn] = cell.getDateCellValue();
                                    break;
                            } 
                        }
                    }
                }
                if(indiceFile != 0) defaultTableModel.addRow(listColumn);
            }
            messages="Data berhasil di Import";
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return messages;
    }
    
    public String prosesExport(File file, JDynamicTable dynamicTable){
        String message = "Tidak dapat memproses export file excel";
        int numFile = dynamicTable.getRowCount();
        int numColumn = dynamicTable.getColumnCount();
        
        if(file.getName().endsWith("xls")){
            workbook = new HSSFWorkbook();
        }else{
            workbook = new XSSFWorkbook();
        }
        Sheet sheet = workbook.createSheet("create excel");
        try{
            for(int i=-1; i < numFile; i++){
                Row rowFiled = sheet.createRow(i+1);
                
                for(int j = 0; j < numColumn; j++){
                    Cell celled = rowFiled.createCell(i);
                    if(i==-1){
                        celled.setCellValue(String.valueOf(dynamicTable.getColumnName(j)));
                    }else{
                        celled.setCellValue(String.valueOf(dynamicTable.getValueAt(i, j)));
                    }
                    workbook.write(new FileOutputStream(file));
                }
            }
            message = "Export file excel berhasil";
        }catch(Exception e){
            e.printStackTrace();
        }
        return message;
    }
    
}
