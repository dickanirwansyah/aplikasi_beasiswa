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
    int hitungTotalKasus();
    
    //menghitung total kasus ya
    int hitungtotalKasusYa();
    
    //menghitung total kasus tidak
    int totalKasusTidak();
    
    //menghitung total rumah milik sendiri
    int hitungTotalRumahMilikSendiri();
    
    //menghitung total rumah [milik sendiri -> kelayakan = ya]
    int hitungRumahMilikSendiriYA();
    
    //menghitung total rumah [milik sendiri -> kelayakan = tidak]
    int hitungRumahMilikSendiriTidak();
    
    //menghitung total rumah kontrak 
    int hitungTotalRumahKontrak();
    
    //menghitung total rumah [kontrak -> kelayakan = ya]
    int hitungRumahKontrakYA();
    
    //menghitung total rumah [kontrak -> kelayakan = tidak]
    int hitungRumahKontrakTidak();
    
    //menghitung total jumlah kendaraan [hanya satu]
    int hitungJmlKendaraanHanyaSatu();
    
    //menghitung total jumlah kendaraan [hanya satu -> kelayakan = Ya]
    int hitungJmlKendaraanHanyaSatuYa();
    
    //menghitung total jumlah kendaraaan [hanya satu -> kelayakan = Tidak]
    int hitungJmlKendaraanHanyaSatuTidak();
    
    //menghitung total jumlah kendaraan [lebih dari satu]
    int hitungJmlKendaraanLebihDariSatu();
    
    //menghitung total jumlah kendaraan [lebih dari satu -> kelayakan = Ya]
    int hitungJmlKendaraanLebihDariSatuYa();
    
    //menghitung total jumlah kendaraan [lebih dari satu -> kelayakan = Tidak]
    int hitungJmlKendaraanLebihDariSatuTidak();
    
    //menghitung total Penghasilan Orang Tua [Cukup]
    int hitungJmlPenghasilanOrtuCukup();
    
    //menghitung total penghasilan orang tua [Cukup - Ya]
    int hitungJmlPenghasilanOrtuCukupYa();
    
    //menghitung total penghasilan orang tua [Cukup -Tidak]
    int hitungJmlPenghasilanOrtuCukupTidak();
    
    //menghitung total penghasilan orang tua [kurang]
    int hitungJmlPenghasilanOrtuKurang();
    
    //menghitung total penghasilan orang tua [kurang - Ya]
    int hitungJmlPenghasilanOrtuKurangYa();
    
    //menghitung total penghasilan orang tua [kurang - Tidak]
    int hitungJmlPenghasilanOrtuKurangTidak();
    
    //menghitung total penghasilan orang tua [baik]
    int hitungJmlPenghasilanOrtuBaik();
    
    //menghitung total penghasilan orang tua [baik -ya]
    int hitungJmlPenghasilanOrtuBaikYa();
    
    //menghitung total penghasilan orang tua [baik - tidak]
    int hitungJmlPenghasilanOrtuBaikTidak();
    
    //menghitung total pekerjaan orang tua [wiraswasta]
    int hitungPekerjaanWiraswasta();
    
    //menghitung total pekerjaan orang tua [wiraswasta - ya]
    int hitungPekerjaaWiraswastaYa();
    
    //menghitung total pekerjaan orang tua [wiraswasta - Tidak]
    int hitungPekerjaanWiraswtaTidak();
    
    //mengitung total pekerjaan orang tua [pegawai negeri]
    int hitungPekerjaanPegawaiNegeri();
    
    //menghitung total pekerjaan orang tua [pegawai negeri - Ya]
    int hitungPekerjaanPegawaiNegeriYa();
    
    //menghitung total pekerjaan orang tua [pegawai negeri - Tidak]
    int hitungPekerjaaPegawaiNegeriTidak();
    
    //menghitung total pekerjaan orang tua [lainnya]
    int hitungPekerjaanLainnya();
    
    //menghitung total pekerjaan orang tua [lainnya - ya]
    int hitungPekerjaanLainnyaYa();
    
    //menghitung total pekerjaan orang tua [lainnya - tidak]
    int hitungPekerjaanLainnyaTidak();
    
    //menghitung total saudara kandung [lebih dari satu]
    int hitungSdrKandungLebihDariSatu();
    
    //menghitung total saudara kandung [lebih dari satu - Ya]
    int hitungSdrKandungLebihDariSatuYa();
    
    //menghitung total saudara kandung [lebih dari satu - Tidak]
    int hitungSdrKandungLebihDariSatuTidak();
    
    //menghitung total saudra kandung [hanya satu]
    int hitungSdrKandungHanyaSatu();
    
    //menghitung total saudara kandung [hanya satu - Ya]
    int hitungSdrKandungHanyaSatuYa();
    
    //menghitung total saudara kandung [hanya satu - Tidak]
    int hitungSdrKandungHanyaSatuTidak();
    
    //menghitung total nilai rapot [Baik]
    int hitungTotalRapotBaik();
    
    //menghitung total nilai rapot [Baik - Ya]
    int hitungTotalRapotBaikYa();
    
    //menghitung total nilai rapot [Baik - Tidak]
    int hitungTotatlRapotBaikTidak();
    
    //menghitung total nilai rapot [Cukup]
    int hitungTotalRapotCukup();
    
    //menghitung total nilai rapot [Cukup - Ya]
    int hitungTotalRapotCukupYa();
    
    //menghitung total nilai rapot [Cukup - Tidak]
    int hitungTotalRapotCukupTidak();
    
    //menghitung total nilai rapot [Kurang]
    int hitungTotalRapotKurang();
    
    //menghitung total nilai rapot [Kurang - Ya]
    int hitungTotalRapotKurangYa();
    
    //menghitung total nilai rapot [Kurang - Tidak]
    int hitungTotalRapotKurangTidak();
}
