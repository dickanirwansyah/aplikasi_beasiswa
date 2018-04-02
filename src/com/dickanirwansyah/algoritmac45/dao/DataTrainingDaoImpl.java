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

    @Override
    public DataTraining hitungTotalKasus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
