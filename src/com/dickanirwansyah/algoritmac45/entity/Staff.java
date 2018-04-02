/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.entity;

/**
 *
 * @author dickajava
 */
public class Staff {
    
    private int idstaff;
    private String nama;
    private String username;
    private String password;
    
    public int getIdstaff(){
        return idstaff;
    }
    
    public void setIdstaff(int idstaff){
        this.idstaff = idstaff;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
