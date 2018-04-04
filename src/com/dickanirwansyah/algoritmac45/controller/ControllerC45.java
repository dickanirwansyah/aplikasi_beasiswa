/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.controller;

import com.dickanirwansyah.algoritmac45.dao.DataTrainingDaoImpl;
import com.dickanirwansyah.algoritmac45.panel.PanelTraining;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class ControllerC45 {
    
    private DataTrainingDaoImpl trainingDaoImpl;
    public ControllerC45(){
        trainingDaoImpl = new DataTrainingDaoImpl();
    }
    
    //menghitung total kasus
    public int analisaData(PanelTraining training){
        
        //menghitung total kasus
        int total_kasus = trainingDaoImpl.hitungTotalKasus();
        System.out.println("Total kasus :"+total_kasus);
        
        
        //menghitung total kasus ya
        int total_kasus_ya = trainingDaoImpl.hitungtotalKasusYa();
        System.out.println("Total kasus ya : "+total_kasus_ya);
        
        
        //menghitung total kasus tidak
        int total_kasus_tidak = trainingDaoImpl.totalKasusTidak();
        System.out.println("Total kasus tidak : "+total_kasus_tidak);
        
        //menghitung total kasus rumah [milik sendiri]
        int total_rumah_miliksendiri = trainingDaoImpl.hitungTotalRumahMilikSendiri();
        System.out.println("Total rumah [milik sendiri] :"+total_rumah_miliksendiri);
        
        //menghitung total kasus rumah [milik sendiri - YA]
        int total_rumah_miliksendiriYa = trainingDaoImpl.hitungRumahMilikSendiriYA();
        System.out.println("Total rumah [milik sendiri - Ya] : "+total_rumah_miliksendiriYa);
        
        //menghitung total kasus rumah [milik sendiri - TIDAK]
        int total_rumah_miliksendiriTidak = trainingDaoImpl.hitungRumahMilikSendiriTidak();
        System.out.println("Total rumah [milik sendiri - Tidak]");
        
        //menghitung total kasus rumah [Kontrak]
        int total_rumah_kontrak = trainingDaoImpl.hitungTotalRumahKontrak();
        System.out.println("Total rumah [kontrak] : "+total_rumah_kontrak);
        
        //menghitung total kasus rumah [Kontrak - YA]
        int total_rumah_kontrakYa = trainingDaoImpl.hitungRumahKontrakYA();
        System.out.println("Total rumah [kontrak - Ya] : "+total_rumah_kontrakYa);
        
        //menghitung total kasus rumah [Kontrak - Tidak]
        int total_rumah_kontrakTidak = trainingDaoImpl.hitungRumahKontrakTidak();
        System.out.println("Total rumah [kontrak - Tidak] : "+total_rumah_kontrakTidak);
        
        //menghitung total kasus jumlah kendaraan [hanya satu]
        int total_jmlKendaraan_hanyaSatu = trainingDaoImpl.hitungJmlKendaraanHanyaSatu();
        System.out.println("Total Jumlah Kendaraan [Hanya Satu] : "+total_jmlKendaraan_hanyaSatu);
        
        //menghitung total kasus jumlah kendaraan [hanya satu - Ya]
        int total_jmlKendaraan_hanyaSatuYa = trainingDaoImpl.hitungJmlKendaraanHanyaSatuYa();
        System.out.println("Total Jumlah Kendaraan [Hanya Satu - Ya] : "+total_jmlKendaraan_hanyaSatuYa);
        
        //menghitung total kasus jumlah kendaraan [hanya satu - Tidak]
        int total_jmlKendaraan_hanyaSatuTidak = trainingDaoImpl.hitungJmlKendaraanHanyaSatuTidak();
        System.out.println("Total jumlah kendaraan [hanya satu - Tidak] : "+total_jmlKendaraan_hanyaSatuTidak);
        
        //menghitung total kasus jumlah kendaraan [lebih dari satu]
        int total_jmlKendaraan_lebihDariSatu = trainingDaoImpl.hitungJmlKendaraanLebihDariSatu();
        System.out.println("Total jumlah kendaraan [lebih dari satu] : "+total_jmlKendaraan_lebihDariSatu);
        
        //menghitung total kasus jumlah kendaraan [lebih dari satu - Ya]
        int total_jmlKendaraan_lebihDariSatuYa = trainingDaoImpl.hitungJmlKendaraanLebihDariSatuYa();
        System.out.println("Total jumlah kendaraan [lebih dari satu - Ya] : "+total_jmlKendaraan_lebihDariSatuYa);
        
        //menghitung total kasus jumlah kendaraan [lebih dari satu - Tidak]
        int total_jmlKendaraan_lebihDariSatuTidak = trainingDaoImpl.hitungJmlKendaraanLebihDariSatuTidak();
        System.out.println("Total jumlah kendaraan [lebih dari satu - Tidak] : "+total_jmlKendaraan_lebihDariSatuTidak);
        
        //menghitung total kasus penghasilan orang tua [cukup]
        int total_jmlPenghasilanOrtuCuku = trainingDaoImpl.hitungJmlPenghasilanOrtuCukup();
        System.out.println("Total jumlah penghasilan ortu [cukup] : "+total_jmlPenghasilanOrtuCuku);
        
        //menghitung total kasus penghasilan orang tua [Cukup - Ya]
        int total_penghasilanOrtuCukupYa = trainingDaoImpl.hitungJmlPenghasilanOrtuCukupYa();
        System.out.println("Total penghasilan ortu [cukup - Ya]: "+total_penghasilanOrtuCukupYa);
        
        //menghitung total kasus penghasilan orang tua [Cukup - Tidak]
        int total_penghasilanOrtuCukupTidak = trainingDaoImpl.hitungJmlPenghasilanOrtuCukupTidak();
        System.out.println("Total penghasilan ortu [cukup - Tidak] : "+total_penghasilanOrtuCukupTidak);
        
        //menghitung total kasus penghasilan orang tua [Kurang]
        int total_penghasilanOrtuKurang = trainingDaoImpl.hitungJmlPenghasilanOrtuKurang();
        System.out.println("Total penghasilan ortu [kurang]: "+total_penghasilanOrtuKurang);
        
        //menghitung total kasus penghasilan orang tua [Kurang - Ya]
        int total_penghasilanOrtuKurangYa = trainingDaoImpl.hitungJmlPenghasilanOrtuKurangYa();
        System.out.println("Total penghasilan ortu [kurang - Ya]: "+total_penghasilanOrtuKurangYa);
        
        //menghitung total kasus penghasilan orang tua [Kurang - Tidak]
        int total_penghasilanOrtuKurangTidak = trainingDaoImpl.hitungJmlPenghasilanOrtuKurangTidak();
        System.out.println("Total penghasilan ortu [kurang - Tidak] : "+total_penghasilanOrtuKurangTidak);
        
        //menghitung total kasus penghasilan orang tua [Baik]
        int total_penghasilanOrtuBaik = trainingDaoImpl.hitungJmlPenghasilanOrtuBaik();
        System.out.println("Total penghasilan ortu [baik]: "+total_penghasilanOrtuBaik);
        
        //menghting total kasus penghasilan orang tua [Baik - Ya]
        int total_penghasilanOrtuBaikYa = trainingDaoImpl.hitungJmlPenghasilanOrtuBaikYa();
        System.out.println("Total penghasilan ortu [baik - ya] : "+total_penghasilanOrtuBaikYa);
        
        //menghitung total kasus penghasilan orang tua [Baik - Tidak]
        int total_penghasilanOrtuBaikTidak = trainingDaoImpl.hitungJmlPenghasilanOrtuBaikTidak();
        System.out.println("Total penghasilan ortu [baik - tidak]: "+total_penghasilanOrtuBaikTidak);
        
        //menghitung total kasus pekerjaan orang tua [wiraswasta]
        int total_wiraswasta = trainingDaoImpl.hitungPekerjaanWiraswasta();
        System.out.println("Total pekerjaan ortu [wiraswasta]: "+total_wiraswasta);
        
        //menghitung total kasus pekerjaan orang tua [wiraswasta - Ya]
        int total_wiraswastaYa = trainingDaoImpl.hitungPekerjaaWiraswastaYa();
        System.out.println("Total pekerjaan ortu [wiraswasta - Ya] : "+total_wiraswastaYa);
        
        //menggitung total kasus pekerjaan orang tua [wiraswasta - Tidak]
        int total_wiraswastaTidak = trainingDaoImpl.hitungPekerjaanWiraswtaTidak();
        System.out.println("Total pekerjaan ortu [wiraswasta - Tidak] : "+total_wiraswastaTidak);
        
        //menghitung total kasus pekerjaan orang tua [pegawai negeri]
        int total_PNS = trainingDaoImpl.hitungPekerjaanPegawaiNegeri();
        System.out.println("Total pekerjaan [PNS] : "+total_PNS);
        
        //menghitung total kasus pekerjaan orang tua [pegawai negeri - Ya]
        int total_pnsYa = trainingDaoImpl.hitungPekerjaanPegawaiNegeriYa();
        System.out.println("Total pekerjaan [PNS - Ya] : "+total_pnsYa);
        
        //menghitung total kasus pekerjaan orang tua [pegawan negeri - Tidak]
        int total_pnsTidak = trainingDaoImpl.hitungPekerjaaPegawaiNegeriTidak();
        System.out.println("Total pekerjaan [PNS - Tidak] : "+total_pnsTidak);
        
        //menghitung total kasus pekerjaan orang tua [lainnya]
        int total_lainnya = trainingDaoImpl.hitungPekerjaanLainnya();
        System.out.println("Total pekerjaan [lainnya] : "+total_lainnya);
        
        //menghitung total kasus pekerjaan orang tua [lainnya - Ya]
        int total_lainnyaYa = trainingDaoImpl.hitungPekerjaanLainnyaYa();
        System.out.println("Total pekerjaan [lainnya - Ya] : "+total_lainnyaYa);
        
        //menghitung total kasus pekerjaan orang tua [lainnya - Tidak]
        int total_lainnyaTidak = trainingDaoImpl.hitungPekerjaanLainnyaTidak();
        System.out.println("Total pekerjaan [lainnya - Tidak] : "+total_lainnyaTidak);
        
        //menghitung total kasus saudara kandung [lebih dari satu]
        int total_sdrkandung_lebihdarisatu=trainingDaoImpl.hitungSdrKandungLebihDariSatu();
        System.out.println("Total Saudara kandung [lebih dari satu] : "+total_sdrkandung_lebihdarisatu);
        
        //menghitung total kasus saudara kandung [lebih dari satu - Ya]
        int total_sdrkandung_lebihdarisatuYa = trainingDaoImpl.hitungSdrKandungLebihDariSatuYa();
        System.out.println("Total saudara kandung [lebih dari satu - Ya]: "+total_sdrkandung_lebihdarisatuYa );
        
        //menghitung total kasus saudara kandung [lebih dari satu - Tidak]
        int total_sdrkandung_lebihdarisatuTidak = trainingDaoImpl.hitungSdrKandungLebihDariSatuTidak();
        System.out.println("Total saudara kandung [lebih dari satu - Tidak]: "+total_sdrkandung_lebihdarisatuTidak);
        
        //menghitung total kasus saudara kandung [hanya satu]
        int total_sdrkandung_hanyasatu = trainingDaoImpl.hitungSdrKandungHanyaSatu();
        System.out.println("Total saudara kandung [hanya satu]: "+total_sdrkandung_hanyasatu);
        
        //menghitung total kasus saudara kandung [hanya satu - Ya]
        int total_sdrkandung_hanyasatuYa = trainingDaoImpl.hitungSdrKandungHanyaSatuYa();
        System.out.println("Total saudara kandung [hanya satu - Ya]: "+total_sdrkandung_hanyasatuYa);
        
        //menghitung total kasus saudara kandung [hanya satu - Tidak]
        int total_sdrkandung_hanyasatuTidak = trainingDaoImpl.hitungSdrKandungHanyaSatuTidak();
        System.out.println("Total saudara kandung [hanya satu - Tidak]: "+total_sdrkandung_hanyasatuTidak);
        
        //menhitung total kasus nilai rapot [Baik]
        int total_nilaiRapotBaik = trainingDaoImpl.hitungTotalRapotBaik();
        System.out.println("Total nilai rapot [Baik] : "+total_nilaiRapotBaik);
        
        //menghitung total kasus nilai rapot [Baik - Ya]
        int total_nilaiRapotBaikYa = trainingDaoImpl.hitungTotalRapotBaikYa();
        System.out.println("Total nilai rapot [Baik - Ya] : "+total_nilaiRapotBaikYa);
        
        //menghitung total kasus nilai rapot [Baik - Tidak]
        int total_nilaiRapotBaikTidak = trainingDaoImpl.hitungTotatlRapotBaikTidak();
        System.out.println("Total nilai rapot [Baik - Tidak] : "+total_nilaiRapotBaikTidak);
        
        //menghitung total kasus nilai rapot [Cukup]
        int total_nilaiRapotCukup = trainingDaoImpl.hitungTotalRapotCukup();
        System.out.println("Total nilai rapot [Cukup] : "+total_nilaiRapotCukup);
        
        //menghitung total kasus nilai rapot [Cukup - Ya]
        int total_nilaiRapotCukupYa = trainingDaoImpl.hitungTotalRapotCukupYa();
        System.out.println("Total nilai rapot [Cukup - Ya]: "+total_nilaiRapotCukupYa);
        
        //menghitung total kasus nilai rapot [Cukup - Tidak]
        int total_nilaiRapotCukupTidak = trainingDaoImpl.hitungTotalRapotCukupTidak();
        System.out.println("Total nilai rapot [Cukup - Tidak] : "+total_nilaiRapotCukupTidak);
        
        //menghitung total kasus nilai rapot [kurang]
        int total_nilaiRapotKurang = trainingDaoImpl.hitungTotalRapotKurang();
        System.out.println("Total nilai rapot [Kurang]: "+total_nilaiRapotKurang);
        
        //menghitung total kasus nilai rapot [kurang - Ya]
        int total_nilaiRapotKurangYa = trainingDaoImpl.hitungTotalRapotKurangYa();
        System.out.println("Total nilai rapot [Kurang - Ya]: "+total_nilaiRapotKurangYa);
        
        //menghitung total kasus nilai rapot [kurang - Tidak]
        int total_nilaiRapotKurangTidak = trainingDaoImpl.hitungTotalRapotKurangTidak();
        System.out.println("Total nilai rapot [Kurang - Tidak] : "+total_nilaiRapotKurangTidak);
        
        //text area
        training.getTextArea().setText(String.valueOf("Total Kasus :"+total_kasus+"\n"+
                "Total Kasus Ya : "+total_kasus_ya+"\n"+
                "Total Kasus Tidak : "+total_kasus_tidak+"\n"+
                "Total Rumah [Milik Sendiri] : "+total_rumah_miliksendiri+"\n"+
                "Total Rumah [Milik Sendiri - Ya] :"+total_rumah_miliksendiriYa+"\n"+
                "Total Rumah [Milik Sendiri - Tidak] :"+total_rumah_miliksendiriTidak+"\n"+
                "Total Rumah [Kontrak] : "+total_rumah_kontrak+"\n"+
                "Total Rumah [Kontrak - Ya] : "+total_rumah_kontrakYa+"\n"+
                "Total Rumah [Kontrak - Tidak] : "+total_rumah_kontrakTidak+"\n"+
                "Total Jumlah Kendaraan [Hanya Satu]: "+total_jmlKendaraan_hanyaSatu+"\n"+
                "Total Jumlah Kendaraan [Hanya Satu - Ya] : "+total_jmlKendaraan_hanyaSatuYa+"\n"+
                "Total Jumlah Kendaraan [Hanya Satu - Tidak] : "+total_jmlKendaraan_hanyaSatuTidak+"\n"+
                "Total jumlah kendaraan [Lebih dari satu]: "+total_jmlKendaraan_lebihDariSatu)+"\n"+
                "Total Jumlah Kendaraan [Lebih dari satu - Ya] :"+total_jmlKendaraan_lebihDariSatuYa+"\n"+
                "Total Jumlah Kendaraan [Lebih dari satu - Tidak ] : "+total_jmlKendaraan_lebihDariSatuTidak+"\n"+
                "Total Penghasilan Ortu [Cukup] : "+total_jmlPenghasilanOrtuCuku+"\n"+
                "Total Penghasilan Ortu [Cukup - Ya]: "+total_penghasilanOrtuCukupYa+"\n"+
                "Total Penghasilan Ortu [Cukup - Tidak]: "+total_penghasilanOrtuCukupTidak +"\n"+
                "Total Penghasilan Ortu [Kurang]: "+total_penghasilanOrtuKurang+"\n"+
                "Total Penghasilan Ortu [Kurang - Ya]: "+total_penghasilanOrtuKurangYa+"\n"+
                "Total Penghasilan Ortu [Kurang - Tidak]: "+total_penghasilanOrtuKurangTidak+"\n"+
                "Total Penghasilan Ortu [Baik] :"+total_penghasilanOrtuBaik+"\n"+
                "Total Penghasilan Ortu [Baik - Ya] : "+total_penghasilanOrtuBaikYa+"\n"+
                "Total Penghasilan Ortu [Baik - Tidak]: "+total_penghasilanOrtuBaikTidak+"\n"+
                "Total pekerjaan Ortu [Wiraswasta]: "+total_wiraswasta+"\n"+
                "Total Pekerjaan Ortu [Wiraswasta - Ya] : "+total_wiraswastaYa+"\n"+
                "Total Pekerjaan Ortu [Wiraswasta - Tidak] : "+total_wiraswastaTidak+"\n"+
                "Total Pekerjaan Ortu [PNS] : "+total_PNS+"\n"+
                "Total Pekerjaan Ortu [PNS - YA] : "+total_pnsYa+"\n"+
                "Total Pekerjaan Ortu [PNS - Tidak] : "+total_pnsTidak+"\n"+
                "Total Pekerjaan Ortu [Lainnya] : "+total_lainnya+"\n"+
                "Total Pekerjaan Ortu [Lainnya - Ya] : "+total_lainnyaYa+"\n"+
                "Total Pekerjaan Ortu [Lainnya - Tidak] : "+total_lainnya+"\n"+
                "Total Saudara kandung [lebih dari satu]: "+total_sdrkandung_lebihdarisatu+"\n"+
                "Total Saudara kandung [lebih dari satu - Ya] : "+total_sdrkandung_lebihdarisatuYa+"\n"+
                "Total Saudara kandung [lebih dari satu - Tidak]: "+total_sdrkandung_lebihdarisatuTidak+"\n"+
                "Total Saudara kandung [hanya satu] : "+total_sdrkandung_hanyasatu+"\n"+
                "Total Saudara kandung [hanya satu - Ya] : "+total_sdrkandung_hanyasatuYa+"\n"+
                "Total Saudara kandung [hanya satu - Tidak] : "+total_sdrkandung_hanyasatuTidak+"\n"+
                "Total Rapot [Baik] : "+total_nilaiRapotBaik+"\n"+
                "Total Rapot [Baik - Ya] : "+total_nilaiRapotBaikYa+"\n"+
                "Total Rapot [Baik - Tidak] : "+total_nilaiRapotBaikTidak + "\n"+
                "Total Rapot [Cukup] :"+total_nilaiRapotCukup+"\n"+
                "Total Rapot [Cukup - Ya]: "+total_nilaiRapotCukupYa+"\n"+
                "Total Rapot [Cukup - Tidak]: "+total_nilaiRapotCukupTidak+"\n"+
                "Total Rapot [Kurang] : "+total_nilaiRapotKurang+"\n"+
                "Total Rapot [Kurang - Ya] : "+total_nilaiRapotKurangYa+"\n"+
                "Total Rapot [Kurang - Tidak] : "+total_nilaiRapotKurangTidak);
        
        return total_kasus;
    }
    
    //Logaritma
    static double prosesLogaritma(double x){
        return Math.log(x)/Math.log(2.0);
    }
    
    //hitung entropy dan gain
    public double hitungEntropyDanGain(PanelTraining training){
        
         //menghitung total kasus
        double total_kasus = trainingDaoImpl.hitungTotalKasus();
                
        //menghitung total kasus ya
        double total_kasus_ya = trainingDaoImpl.hitungtotalKasusYa();
        
        
        //menghitung total kasus tidak
        double total_kasus_tidak = trainingDaoImpl.totalKasusTidak();
     
        
        //menghitung total kasus rumah [milik sendiri]
        double total_rumah_miliksendiri = trainingDaoImpl.hitungTotalRumahMilikSendiri();
      
        
        //menghitung total kasus rumah [milik sendiri - YA]
        double total_rumah_miliksendiriYa = trainingDaoImpl.hitungRumahMilikSendiriYA();
      
        
        //menghitung total kasus rumah [milik sendiri - TIDAK]
        double total_rumah_miliksendiriTidak = trainingDaoImpl.hitungRumahMilikSendiriTidak();
       
        
        //menghitung total kasus rumah [Kontrak]
        double total_rumah_kontrak = trainingDaoImpl.hitungTotalRumahKontrak();
      
        
        //menghitung total kasus rumah [Kontrak - YA]
        double total_rumah_kontrakYa = trainingDaoImpl.hitungRumahKontrakYA();
      
        
        //menghitung total kasus rumah [Kontrak - Tidak]
        double total_rumah_kontrakTidak = trainingDaoImpl.hitungRumahKontrakTidak();
     
        
        //menghitung total kasus jumlah kendaraan [hanya satu]
        double total_jmlKendaraan_hanyaSatu = trainingDaoImpl.hitungJmlKendaraanHanyaSatu();
       
        
        //menghitung total kasus jumlah kendaraan [hanya satu - Ya]
        double total_jmlKendaraan_hanyaSatuYa = trainingDaoImpl.hitungJmlKendaraanHanyaSatuYa();
      
        
        //menghitung total kasus jumlah kendaraan [hanya satu - Tidak]
        double total_jmlKendaraan_hanyaSatuTidak = trainingDaoImpl.hitungJmlKendaraanHanyaSatuTidak();
       
        
        //menghitung total kasus jumlah kendaraan [lebih dari satu]
        double total_jmlKendaraan_lebihDariSatu = trainingDaoImpl.hitungJmlKendaraanLebihDariSatu();
        
        
        //menghitung total kasus jumlah kendaraan [lebih dari satu - Ya]
        double total_jmlKendaraan_lebihDariSatuYa = trainingDaoImpl.hitungJmlKendaraanLebihDariSatuYa();
        
        //menghitung total kasus jumlah kendaraan [lebih dari satu - Tidak]
        double total_jmlKendaraan_lebihDariSatuTidak = trainingDaoImpl.hitungJmlKendaraanLebihDariSatuTidak();
        
        //menghitung total kasus penghasilan orang tua [cukup]
        double total_jmlPenghasilanOrtuCuku = trainingDaoImpl.hitungJmlPenghasilanOrtuCukup();
        
        //menghitung total kasus penghasilan orang tua [Cukup - Ya]
        double total_penghasilanOrtuCukupYa = trainingDaoImpl.hitungJmlPenghasilanOrtuCukupYa();
        
        //menghitung total kasus penghasilan orang tua [Cukup - Tidak]
        double total_penghasilanOrtuCukupTidak = trainingDaoImpl.hitungJmlPenghasilanOrtuCukupTidak();
        
        //menghitung total kasus penghasilan orang tua [Kurang]
        double total_penghasilanOrtuKurang = trainingDaoImpl.hitungJmlPenghasilanOrtuKurang();
        
        //menghitung total kasus penghasilan orang tua [Kurang - Ya]
        double total_penghasilanOrtuKurangYa = trainingDaoImpl.hitungJmlPenghasilanOrtuKurangYa();
        
        //menghitung total kasus penghasilan orang tua [Kurang - Tidak]
        double total_penghasilanOrtuKurangTidak = trainingDaoImpl.hitungJmlPenghasilanOrtuKurangTidak();
        
        //menghitung total kasus penghasilan orang tua [Baik]
        double total_penghasilanOrtuBaik = trainingDaoImpl.hitungJmlPenghasilanOrtuBaik();
        
        //menghting total kasus penghasilan orang tua [Baik - Ya]
        double total_penghasilanOrtuBaikYa = trainingDaoImpl.hitungJmlPenghasilanOrtuBaikYa();
        
        //menghitung total kasus penghasilan orang tua [Baik - Tidak]
        double total_penghasilanOrtuBaikTidak = trainingDaoImpl.hitungJmlPenghasilanOrtuBaikTidak();
        
        //menghitung total kasus pekerjaan orang tua [wiraswasta]
        double total_wiraswasta = trainingDaoImpl.hitungPekerjaanWiraswasta();
        
        //menghitung total kasus pekerjaan orang tua [wiraswasta - Ya]
        double total_wiraswastaYa = trainingDaoImpl.hitungPekerjaaWiraswastaYa();
        
        //menggitung total kasus pekerjaan orang tua [wiraswasta - Tidak]
        double total_wiraswastaTidak = trainingDaoImpl.hitungPekerjaanWiraswtaTidak();
        
        //menghitung total kasus pekerjaan orang tua [pegawai negeri]
        double total_PNS = trainingDaoImpl.hitungPekerjaanPegawaiNegeri();
        
        //menghitung total kasus pekerjaan orang tua [pegawai negeri - Ya]
        double total_pnsYa = trainingDaoImpl.hitungPekerjaanPegawaiNegeriYa();
        
        //menghitung total kasus pekerjaan orang tua [pegawan negeri - Tidak]
        double total_pnsTidak = trainingDaoImpl.hitungPekerjaaPegawaiNegeriTidak();
        
        //menghitung total kasus pekerjaan orang tua [lainnya]
        double total_lainnya = trainingDaoImpl.hitungPekerjaanLainnya();
        
        //menghitung total kasus pekerjaan orang tua [lainnya - Ya]
        double total_lainnyaYa = trainingDaoImpl.hitungPekerjaanLainnyaYa();
        
        //menghitung total kasus pekerjaan orang tua [lainnya - Tidak]
        double total_lainnyaTidak = trainingDaoImpl.hitungPekerjaanLainnyaTidak();
        
        //menghitung total kasus saudara kandung [lebih dari satu]
        double total_sdrkandung_lebihdarisatu=trainingDaoImpl.hitungSdrKandungLebihDariSatu();
        
        //menghitung total kasus saudara kandung [lebih dari satu - Ya]
        double total_sdrkandung_lebihdarisatuYa = trainingDaoImpl.hitungSdrKandungLebihDariSatuYa();
        
        //menghitung total kasus saudara kandung [lebih dari satu - Tidak]
        double total_sdrkandung_lebihdarisatuTidak = trainingDaoImpl.hitungSdrKandungLebihDariSatuTidak();
        
        //menghitung total kasus saudara kandung [hanya satu]
        double total_sdrkandung_hanyasatu = trainingDaoImpl.hitungSdrKandungHanyaSatu();
        
        //menghitung total kasus saudara kandung [hanya satu - Ya]
        double total_sdrkandung_hanyasatuYa = trainingDaoImpl.hitungSdrKandungHanyaSatuYa();
        
        //menghitung total kasus saudara kandung [hanya satu - Tidak]
        double total_sdrkandung_hanyasatuTidak = trainingDaoImpl.hitungSdrKandungHanyaSatuTidak();
        
        //menhitung total kasus nilai rapot [Baik]
        double total_nilaiRapotBaik = trainingDaoImpl.hitungTotalRapotBaik();
        
        //menghitung total kasus nilai rapot [Baik - Ya]
        double total_nilaiRapotBaikYa = trainingDaoImpl.hitungTotalRapotBaikYa();
        
        //menghitung total kasus nilai rapot [Baik - Tidak]
        double total_nilaiRapotBaikTidak = trainingDaoImpl.hitungTotatlRapotBaikTidak();
        
        //menghitung total kasus nilai rapot [Cukup]
        double total_nilaiRapotCukup = trainingDaoImpl.hitungTotalRapotCukup();
        
        //menghitung total kasus nilai rapot [Cukup - Ya]
        double total_nilaiRapotCukupYa = trainingDaoImpl.hitungTotalRapotCukupYa();
        
        //menghitung total kasus nilai rapot [Cukup - Tidak]
        double total_nilaiRapotCukupTidak = trainingDaoImpl.hitungTotalRapotCukupTidak();
        
        //menghitung total kasus nilai rapot [kurang]
        double total_nilaiRapotKurang = trainingDaoImpl.hitungTotalRapotKurang();
        
        //menghitung total kasus nilai rapot [kurang - Ya]
        double total_nilaiRapotKurangYa = trainingDaoImpl.hitungTotalRapotKurangYa();
        
        //menghitung total kasus nilai rapot [kurang - Tidak]
        double total_nilaiRapotKurangTidak = trainingDaoImpl.hitungTotalRapotKurangTidak();
        
        
        //#============ENTROPY TOTAL=============#
        double entropyTotal = 0.0;
        double calculate_total_ya = total_kasus_ya / total_kasus;
        double calculate_total_tidak = total_kasus_tidak / total_kasus;
       
        entropyTotal = (-(total_kasus_ya / total_kasus) * prosesLogaritma(calculate_total_ya)) + 
                (-(total_kasus_tidak / total_kasus) * prosesLogaritma(calculate_total_tidak));
        
        System.out.println("CALCULATE_TOTAL_YA ="+ calculate_total_ya);
        System.out.println("CALCULATE_TOTAL_TIDAK ="+ calculate_total_tidak);
        System.out.println("RESULT ENTROPY TOTAL ="+entropyTotal);
        //#============ENTROPY TOTAL============#
        
        //#=========ENTROPY RUMAH [KONTRAK] ============#
        double entropyRumahKontrak = 0.0;
        double kontrak_ya = total_rumah_kontrakYa / total_rumah_kontrak;
        double kontrak_tidak = total_rumah_kontrakTidak / total_rumah_kontrak;
        
        entropyRumahKontrak = (-(total_rumah_kontrakYa / total_rumah_kontrak) * prosesLogaritma(kontrak_ya)) + 
                (-(total_rumah_kontrakTidak / total_rumah_kontrak) * prosesLogaritma(kontrak_tidak));
        
        System.out.println("RESULT ENTROPY RUMAH [KONTRAK] = "+entropyRumahKontrak);
        System.out.println("CALCULATE_KONTRAK_YA = "+kontrak_ya);
        System.out.println("CALCULATE_KONTRAK_TIDAK = "+kontrak_tidak);
        //#==========ENTROPY RUMAH [KONTRAK] ===========#
        
        return total_kasus;
        
    }
}
