/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.dao;

import com.dickanirwansyah.algoritmac45.connection.DBConnection;
import com.dickanirwansyah.algoritmac45.entity.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class StaffDaoImpl implements StaffDao{
    
    private Connection connection;
    public StaffDaoImpl(){
        connection = DBConnection.getConnection();
    }

    @Override
    public Staff createdStaff(Staff staff) {
        PreparedStatement statement = null;
        String sql = "insert into tabel_staff_tu(idstaff, nama, username, password) "
                + "values(?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, staff.getIdstaff());
            statement.setString(2, staff.getNama());
            statement.setString(3, staff.getUsername());
            statement.setString(4, staff.getPassword());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return staff;
    }

    @Override
    public Staff updatedStaff(Staff staff) {
      PreparedStatement statement = null;
      String sql = "update tabel_staff_tu set nama=?, username=?, password=?"
              + " where idstaff=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, staff.getNama());
            statement.setString(2, staff.getUsername());
            statement.setString(3, staff.getPassword());
            statement.setInt(4, staff.getIdstaff());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return staff;
    }

    @Override
    public Staff findStaffById(int idstaff) {
      PreparedStatement statement = null;
      Staff staff = null;
        ResultSet rs = null;
        String sql = "select * from tabel_staff_tu where idstaff=?";
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while(rs.next()){
                staff = new Staff();
                staff.setIdstaff(rs.getInt("idstaff"));
                staff.setNama(rs.getString("nama"));
                staff.setUsername(rs.getString("username"));
                staff.setPassword(rs.getString("password"));
            }
            return staff;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
