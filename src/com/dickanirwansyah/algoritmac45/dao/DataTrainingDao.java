/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.dao;

import com.dickanirwansyah.algoritmac45.entity.DataTraining;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface DataTrainingDao {
    
    //simpan data training
    boolean simpanDataTraining(DataTraining dataTraining);
    
    //Menampilkan data training secara keseluruhan
    List<DataTraining> listDataTraining();
    
    //menghitung total kasus
    DataTraining hitungTotalKasus();
}
