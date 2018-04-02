/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.tabelmodel;

import com.dickanirwansyah.algoritmac45.entity.DataTraining;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class TabelModelDataTraining extends DynamicTableModel<DataTraining>{
    
    private List<DataTraining> list = new ArrayList<>();
    public TabelModelDataTraining(List<DataTraining> data, Class<DataTraining> clazz) {
        super(data, clazz);
    }
    
}
