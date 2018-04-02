/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.dao;

import com.dickanirwansyah.algoritmac45.entity.Staff;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface StaffDao {
    
    Staff createdStaff(Staff staff);
    
    Staff updatedStaff(Staff staff);
    
    Staff findStaffById(int idstaff);
}
