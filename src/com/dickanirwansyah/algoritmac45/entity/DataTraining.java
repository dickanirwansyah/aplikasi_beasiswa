/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.entity;

import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author dickajava
 */
public class DataTraining {
    
    private String idtraining;
    @TableColumn(name = "Nama", number = 1, size = 30)
    private String nama;
    
    @TableColumn(name = "Rumah", number = 2, size = 30)
    private String rumah;
    
    @TableColumn(name = "Jumlah Kendaraan", number = 3, size = 35)
    private String jumlah_kendaraan;
    
    @TableColumn(name = "Penghasilan Ortu", number = 4, size = 35)
    private String penghasilan_orangtua;
    
    @TableColumn(name = "Pekerjaan Ortu", number = 5, size = 35)
    private String pekerjaan_orangtua;
    
    @TableColumn(name = "Jumlah saudara kandung", number = 6, size = 40)
    private String jumlah_saudarakandung;
    
    @TableColumn(name = "Nilai Rapot", number = 7, size = 35)
    private String nilai_rapot;
    
    @TableColumn(name = "Kelayakan", number = 8, size = 30)
    private String kelayakan;
    
    
    public String getKelayakan(){
        return kelayakan;
    }
    
    public void setKelayakan(String kelayakan){
        this.kelayakan = kelayakan;
    }
    
    public String getNilai_rapot(){
        return nilai_rapot;
    }
    
    public void setNilai_rapot(String nilai_rapot){
        this.nilai_rapot = nilai_rapot;
    }
    
    public String getJumlah_saudarakandung(){
        return jumlah_saudarakandung;
    }
    
    public void setJumlah_saudarakandung(String jumlah_saudarakandung){
        this.jumlah_saudarakandung = jumlah_saudarakandung;
    }
    
    public String getPekerjaan_orangtua(){
        return pekerjaan_orangtua;
    }
    
    public void setPekerjaan_orangtua(String pekerjaan_orangtua){
        this.pekerjaan_orangtua = pekerjaan_orangtua;
    }
    
    public String getPenghasilan_orangtua(){
        return penghasilan_orangtua;
    }
    
    public void setPenghasilan_orangtua(String penghasilan_orangtua){
        this.penghasilan_orangtua = penghasilan_orangtua;
    }
    
    public void setJumlah_kendaraan(String jumlah_kendaraan){
        this.jumlah_kendaraan = jumlah_kendaraan;
    }
    
    public String getJumlah_kendaraan(){
        return jumlah_kendaraan;
    }
    
    public String getRumah(){
        return rumah;
    }
    
    public void setRumah(String rumah){
        this.rumah = rumah;
    }
    
    public String getIdtraining(){
        return idtraining;
    }
    
    public void setIdtraining(String idtraining){
        this.idtraining = idtraining;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
}
