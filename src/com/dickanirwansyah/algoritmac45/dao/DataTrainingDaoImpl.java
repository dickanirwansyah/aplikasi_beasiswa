/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.dao;

import com.dickanirwansyah.algoritmac45.connection.DBConnection;
import com.dickanirwansyah.algoritmac45.entity.DataTraining;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class DataTrainingDaoImpl implements DataTrainingDao{
    
    private Connection connection;
    public DataTrainingDaoImpl(){
        connection = DBConnection.getConnection();
    }

    /*
    *   menampilkan data training 
     */
    @Override
    public List<DataTraining> listDataTraining() {
        PreparedStatement statement = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "select * from tabel_data_training";
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while(rs.next()){
                DataTraining t = new DataTraining();
                t.setNama(rs.getString("nama"));
                t.setRumah(rs.getString("rumah"));
                t.setJumlah_kendaraan(rs.getString("jumlah_kendaraan"));
                t.setPenghasilan_orangtua(rs.getString("penghasilan_orangtua"));
                t.setPekerjaan_orangtua(rs.getString("pekerjaan_orangtua"));
                t.setJumlah_saudarakandung(rs.getString("jumlah_sdrkandung"));
                t.setNilai_rapot(rs.getString("nilai_rapot"));
                t.setKelayakan(rs.getString("kelayakan"));
                
                list.add(t);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //SIMPAN DATA TRAINING
    @Override
    public boolean simpanDataTraining(DataTraining dataTraining) {
        boolean valid = false;
        PreparedStatement statement = null;
        String sql = "insert into tabel_data_training(nama, rumah, jumlah_kendaraan, "
                + "penghasilan_orangtua, pekerjaan_orangtua, jumlah_sdrkandung, nilai_rapot, "
                + "kelayakan) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, dataTraining.getNama());
            statement.setString(2, dataTraining.getRumah());
            statement.setString(3, dataTraining.getJumlah_kendaraan());
            statement.setString(4, dataTraining.getPenghasilan_orangtua());
            statement.setString(5, dataTraining.getPekerjaan_orangtua());
            statement.setString(6, dataTraining.getJumlah_saudarakandung());
            statement.setString(7, dataTraining.getNilai_rapot());
            statement.setString(8, dataTraining.getKelayakan());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            valid = false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    
    //menghitung total kasus keseluruhan (Himpunan Kasus)
    @Override
    public int hitungTotalKasus() {
      PreparedStatement statement = null;
      String sql = "select count(*) as counter from tabel_data_training";
      ResultSet rs = null;
      int totalkasus = 0;
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalkasus = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return totalkasus;
    }
    
    //total kasus ya
    @Override
    public int hitungtotalKasusYa() {
      String sql = "select count(*) as counter from tabel_data_training where kelayakan='Ya'";
      int totalKasusYa = 0;
      ResultSet rs = null;
      PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalKasusYa = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return totalKasusYa;
    }

    //total kasus tidak
    @Override
    public int totalKasusTidak() {
     PreparedStatement statement = null;
     ResultSet rs = null;
     String sql = "select count(*) as counter from tabel_data_training where kelayakan='Tidak'";
     int total_kasus_tidak = 0;
        try {
            statement = connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                total_kasus_tidak = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return total_kasus_tidak;
    }

    //menghitung total rumah milik sendiri
    @Override
    public int hitungTotalRumahMilikSendiri() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        int totalRumahMilikSendiri = 0;
        String sql = "select count(*) as countere from tabel_data_training where rumah='milik sendiri'";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalRumahMilikSendiri = rs.getInt("countere");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return totalRumahMilikSendiri;
    }

    //hitung rumah milik sendiri ya
    @Override
    public int hitungRumahMilikSendiriYA() {
      PreparedStatement statement = null;
      int miliksendiriYa = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where rumah='milik sendiri' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                miliksendiriYa = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return miliksendiriYa;
    }

    //hitung rumah milik sendiri tidak
    @Override
    public int hitungRumahMilikSendiriTidak() {
     PreparedStatement statement = null;
     ResultSet rs = null;
     int totalRumahMilikSendiriTidak = 0;
     String sql = "select count(*) as counter from tabel_data_training where rumah='milik sendiri' and kelayakan='Tidak'";
     
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalRumahMilikSendiriTidak = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
     
     return totalRumahMilikSendiriTidak;
    }

    //menghitung total rumah kontrak
    @Override
    public int hitungTotalRumahKontrak() {
        PreparedStatement statement = null;
        int totalRumahKontral = 0;
        ResultSet rs = null;
        String sql = "select count(*) as counter from tabel_data_training where rumah='kontrak'";
        
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalRumahKontral = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return totalRumahKontral;
    }

    
    //menghitung total rumah kontrak Ya
    @Override
    public int hitungRumahKontrakYA() {
      PreparedStatement statement = null;
      int hitungRumahKontrakYa = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where rumah='kontrak' and kelayakan='Ya'";
      
        try {
            statement = connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungRumahKontrakYa = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungRumahKontrakYa;
    }

    //menghitung total rumah kontrak tidak
    @Override
    public int hitungRumahKontrakTidak() {
       PreparedStatement statement = null;
       int totalRumahKontrakTidak = 0;
       ResultSet rs = null;
       String sql = "select count(*) as counter from tabel_data_training where rumah='kontrak' and kelayakan='Tidak'";
       
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalRumahKontrakTidak = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
       return totalRumahKontrakTidak;
    }

    //hitung jumlah kendaraan hanya satu
    @Override
    public int hitungJmlKendaraanHanyaSatu() {
        ResultSet rs = null;
        PreparedStatement statement = null;
        int totalJmlKendaraanHanyaSatu= 0;
        String sql = "select count(*) as counter from tabel_data_training where jumlah_kendaraan='hanya satu'";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalJmlKendaraanHanyaSatu = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return totalJmlKendaraanHanyaSatu;
    }

    //total kendaraan hanya satu Ya
    @Override
    public int hitungJmlKendaraanHanyaSatuYa() {
       ResultSet rs = null;
        PreparedStatement statement = null;
        int totalJmlKendaraanHanyaSatuYa= 0;
        String sql = "select count(*) as counter from tabel_data_training where jumlah_kendaraan='hanya satu' and kelayakan='Ya'";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalJmlKendaraanHanyaSatuYa = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return totalJmlKendaraanHanyaSatuYa;
    }

    //total kasus kendaraan hanya satu Tidak
    @Override
    public int hitungJmlKendaraanHanyaSatuTidak() {
       ResultSet rs = null;
        PreparedStatement statement = null;
        int totalJmlKendaraanHanyaSatuTidak= 0;
        String sql = "select count(*) as counter from tabel_data_training where jumlah_kendaraan='hanya satu' and kelayakan='Tidak'";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalJmlKendaraanHanyaSatuTidak = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return totalJmlKendaraanHanyaSatuTidak; 
    }

    //total kasus kendaraan lebih dari satu
    @Override
    public int hitungJmlKendaraanLebihDariSatu() {
      ResultSet rs = null;
        PreparedStatement statement = null;
        int totalJmlKendaraanLebihDariSatu= 0;
        String sql = "select count(*) as counter from tabel_data_training where jumlah_kendaraan='lebih dari satu'";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalJmlKendaraanLebihDariSatu = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return totalJmlKendaraanLebihDariSatu;  
    }

    //total kasus kendaraan lebih dari satu Ya
    @Override
    public int hitungJmlKendaraanLebihDariSatuYa() {
       ResultSet rs = null;
        PreparedStatement statement = null;
        int totalJmlKendaraanLebihDariSatuYa= 0;
        String sql = "select count(*) as counter from tabel_data_training where jumlah_kendaraan='lebih dari satu' and kelayakan='Ya'";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalJmlKendaraanLebihDariSatuYa = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return totalJmlKendaraanLebihDariSatuYa;  
    }

    @Override
    public int hitungJmlKendaraanLebihDariSatuTidak() {
       ResultSet rs = null;
        PreparedStatement statement = null;
        int totalJmlKendaraanLebihDariSatuTidak= 0;
        String sql = "select count(*) as counter from tabel_data_training where jumlah_kendaraan='lebih dari satu' and kelayakan='Tidak'";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                totalJmlKendaraanLebihDariSatuTidak = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return totalJmlKendaraanLebihDariSatuTidak;   
    }

    //total orang tua cukup
    @Override
    public int hitungJmlPenghasilanOrtuCukup() {
      PreparedStatement statement = null;
      int hitungJmlPenghasilanOrtuCukup = 0;
      ResultSet rs = null;
      String sql = "select count(*)as counter from tabel_data_training where penghasilan_orangtua='cukup'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungJmlPenghasilanOrtuCukup = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungJmlPenghasilanOrtuCukup;
    }

    //penghasilan ortu cukup ya
    @Override
    public int hitungJmlPenghasilanOrtuCukupYa() {
      PreparedStatement statement = null;
      int hitungJmlPenghasilanOrtuCukupYa = 0;
      ResultSet rs = null;
      String sql = "select count(*)as counter from tabel_data_training where penghasilan_orangtua='cukup' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungJmlPenghasilanOrtuCukupYa = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungJmlPenghasilanOrtuCukupYa; 
    }

    //total penghasilan ortu cukup tidak
    @Override
    public int hitungJmlPenghasilanOrtuCukupTidak() {
      PreparedStatement statement = null;
      int hitungJmlPenghasilanOrtuCukupTidak = 0;
      ResultSet rs = null;
      String sql = "select count(*)as counter from tabel_data_training where penghasilan_orangtua='cukup' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungJmlPenghasilanOrtuCukupTidak = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungJmlPenghasilanOrtuCukupTidak;   
    }

    @Override
    public int hitungJmlPenghasilanOrtuKurang() {
      PreparedStatement statement = null;
      int hitungJmlPenghasilanOrtuKurang = 0;
      ResultSet rs = null;
      String sql = "select count(*)as counter from tabel_data_training where penghasilan_orangtua='kurang'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungJmlPenghasilanOrtuKurang = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungJmlPenghasilanOrtuKurang;   
    }

    //total kasus penghasilan ortu kurang Ya
    @Override
    public int hitungJmlPenghasilanOrtuKurangYa() {
       PreparedStatement statement = null;
      int hitungJmlPenghasilanOrtuKurangYa = 0;
      ResultSet rs = null;
      String sql = "select count(*)as counter from tabel_data_training where penghasilan_orangtua='kurang' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungJmlPenghasilanOrtuKurangYa = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungJmlPenghasilanOrtuKurangYa;   
    }

    //total penghasilan ortu tidak
    @Override
    public int hitungJmlPenghasilanOrtuKurangTidak() {
       PreparedStatement statement = null;
      int hitungJmlPenghasilanOrtuKurangTidak = 0;
      ResultSet rs = null;
      String sql = "select count(*)as counter from tabel_data_training where penghasilan_orangtua='kurang' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungJmlPenghasilanOrtuKurangTidak = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungJmlPenghasilanOrtuKurangTidak;  
    }

    
    //total penghasilan ortu baik
    @Override
    public int hitungJmlPenghasilanOrtuBaik() {
      PreparedStatement statement = null;
      int hitungJmlPenghasilanOrtuBaik = 0;
      ResultSet rs = null;
      String sql = "select count(*)as counter from tabel_data_training where penghasilan_orangtua='baik'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungJmlPenghasilanOrtuBaik = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungJmlPenghasilanOrtuBaik;    
    }

    //total penghasilan orang tua baik ya
    @Override
    public int hitungJmlPenghasilanOrtuBaikYa() {
       PreparedStatement statement = null;
      int hitungJmlPenghasilanOrtuBaikYa = 0;
      ResultSet rs = null;
      String sql = "select count(*)as counter from tabel_data_training where penghasilan_orangtua='baik' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungJmlPenghasilanOrtuBaikYa = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungJmlPenghasilanOrtuBaikYa;  
    }

    @Override
    public int hitungJmlPenghasilanOrtuBaikTidak() {
        PreparedStatement statement = null;
      int hitungJmlPenghasilanOrtuBaikTidak = 0;
      ResultSet rs = null;
      String sql = "select count(*)as counter from tabel_data_training where penghasilan_orangtua='baik' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hitungJmlPenghasilanOrtuBaikTidak = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      
      return hitungJmlPenghasilanOrtuBaikTidak; 
    }

    //total wiraswasta
    @Override
    public int hitungPekerjaanWiraswasta() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where pekerjaan_orangtua='wiraswasta'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;
    }

    //total wiraswasta kelayakan -> ya
    @Override
    public int hitungPekerjaaWiraswastaYa() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where pekerjaan_orangtua='wiraswasta' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;  
    }

    //total wiraswasta kelayakan -> tidak
    @Override
    public int hitungPekerjaanWiraswtaTidak() {
       PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where pekerjaan_orangtua='wiraswasta' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;   
    }

    //total pegawai negeri 
    @Override
    public int hitungPekerjaanPegawaiNegeri() {
       PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where pekerjaan_orangtua='pegawai negeri'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;  
    }

    //PNS kelayakan ya
    @Override
    public int hitungPekerjaanPegawaiNegeriYa() {
       PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where pekerjaan_orangtua='pegawai negeri' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;  
    }

    @Override
    public int hitungPekerjaaPegawaiNegeriTidak() {
       PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where pekerjaan_orangtua='pegawai negeri' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;   
    }

    //lainnya
    @Override
    public int hitungPekerjaanLainnya() {
       PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where pekerjaan_orangtua='lainnya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;    
    }

    //lainnya - Ya
    @Override
    public int hitungPekerjaanLainnyaYa() {
        PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where pekerjaan_orangtua='lainnya' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;     
    }

    //lainnya - Tidak
    @Override
    public int hitungPekerjaanLainnyaTidak() {
        PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where pekerjaan_orangtua='lainnya' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;     
    }

    //lebih dari satu saudara kandung
    @Override
    public int hitungSdrKandungLebihDariSatu() {
         PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where jumlah_sdrkandung='lebih dari satu'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;    
    }

    //saudara kandung lebih dari satu ya
    @Override
    public int hitungSdrKandungLebihDariSatuYa() {
         PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where jumlah_sdrkandung='lebih dari satu' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;      
    }

    //total saudara kandung lebih dari satu tidak
    @Override
    public int hitungSdrKandungLebihDariSatuTidak() {
         PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where jumlah_sdrkandung='lebih dari satu' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;    
    }

    //saudara kandung hanya satu
    @Override
    public int hitungSdrKandungHanyaSatu() {
    PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where jumlah_sdrkandung='hanya satu'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;        
    }

    //saudara kandung hanya satu ya
    @Override
    public int hitungSdrKandungHanyaSatuYa() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where jumlah_sdrkandung='hanya satu' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;  
    }

    
    //saudara kandung hanya satu tidak
    @Override
    public int hitungSdrKandungHanyaSatuTidak() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where jumlah_sdrkandung='hanya satu' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;    
    }

    //hitung total rapot baik
    @Override
    public int hitungTotalRapotBaik() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where nilai_rapot='baik'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;     
    }

    //total rapot baik ya
    @Override
    public int hitungTotalRapotBaikYa() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where nilai_rapot='baik' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;     
    }

    //nilai rapot baik tidak
    @Override
    public int hitungTotatlRapotBaikTidak() {
       PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where nilai_rapot='baik' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;      
    }

    //nilai rapot cukup
    @Override
    public int hitungTotalRapotCukup() {
       PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where nilai_rapot='cukup'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;      
    }

    //nilai rapot cukup ya
    @Override
    public int hitungTotalRapotCukupYa() {
       PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where nilai_rapot='cukup' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;     
    }

    //nilai rapot cukup tidak
    @Override
    public int hitungTotalRapotCukupTidak() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where nilai_rapot='cukup' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil; 
    }

    //nilai rapot kurang
    @Override
    public int hitungTotalRapotKurang() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where nilai_rapot='kurang'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;  
    }

    //nilai rapot kurang ya
    @Override
    public int hitungTotalRapotKurangYa() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where nilai_rapot='kurang' and kelayakan='Ya'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;   
    }

    //total rapot kurang tidak
    @Override
    public int hitungTotalRapotKurangTidak() {
      PreparedStatement statement = null;
      int hasil = 0;
      ResultSet rs = null;
      String sql = "select count(*) as counter from tabel_data_training where nilai_rapot='kurang' and kelayakan='Tidak'";
      
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                hasil = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataTrainingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
      return hasil;    
    }

  
    
}
