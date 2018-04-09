/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.algoritmac45.panel;

import com.dickanirwansyah.algoritmac45.controller.ControllerC45;
import com.dickanirwansyah.algoritmac45.dao.DataTrainingDaoImpl;
import com.dickanirwansyah.algoritmac45.entity.DataTraining;
import com.dickanirwansyah.algoritmac45.helper.ExcelHelper;
import com.dickanirwansyah.algoritmac45.tabelmodel.TabelModelDataTraining;
import com.stripbandunk.jwidget.JDynamicTable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dickajava
 */
public class PanelTraining extends javax.swing.JPanel {

    
    private DataTrainingDaoImpl daoImpl;
    private TabelModelDataTraining dataTraining;
    private ExcelHelper excelHelper;
    private JFileChooser chooserSelected = new JFileChooser();
    private ControllerC45 c45;
    int contAction = 0;
    File file;
    
    public PanelTraining() {
        initComponents();
        c45 = new ControllerC45();
        progressBarTraining.setVisible(false);
        progressBarTraining.setVisible(false);
        txtHasilAnalisia.setEnabled(false);
        daoImpl = new DataTrainingDaoImpl();
        excelHelper = new ExcelHelper();
        loadDataTraining();
    }

    private void loadDataTraining(){
        List list = daoImpl.listDataTraining();
        dataTraining = new TabelModelDataTraining(list, DataTraining.class);
        tabel_data_training.setModel(dataTraining);
    }
    
    
    public void prosesFilter(){
        chooserSelected.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        chooserSelected.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }
    
    //progress bar
      class TampilkanWorker extends SwingWorker{
        
        @Override
        protected Object doInBackground() throws Exception {
            
            for(int i=0; i<=100; i++){
                try{
                    Thread.sleep(30);
                    progressBarTraining.setValue(i);
                    progressBarTraining.setVisible(true);
                    progressBarTraining.setIndeterminate(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void done() {
            progressBarTraining.setVisible(false);
        }
    }
    
    
    //controller for excel helper
    public JButton getButtonImportDataTraining(){
        return btnImportTraining;
    }
    
    //controller dynamic tabel 
    public JDynamicTable getDynamicDataTraining(){
        return tabel_data_training;
    }
    
    //controller progress bar
    public JProgressBar getProgressbar(){
        return progressBarTraining;
    }
    
    //controller text area
    public JTextArea getTextArea(){
        return txtHasilAnalisia;
    }
    
    //controller button
    public JButton getButtonAnalisaData(){
        return btnAnalisaData;
    }
    
    public JButton getButtonEntropyGain(){
        return btnEntropyGain;
    }
    
    public JButton getButtonPohonKeputusan(){
        return btnTampilkanPohon;
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bluePanel1 = new paket.launk.java.container.BluePanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_data_training = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel3 = new javax.swing.JPanel();
        btnImportTraining = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        progressBarTraining = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_hasil_perhitungan = new com.stripbandunk.jwidget.JDynamicTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtHasilAnalisia = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnAnalisaData = new javax.swing.JButton();
        btnEntropyGain = new javax.swing.JButton();
        btnTampilkanPohon = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proses Perhitungan Algoritma C4.5");

        javax.swing.GroupLayout bluePanel1Layout = new javax.swing.GroupLayout(bluePanel1);
        bluePanel1.setLayout(bluePanel1Layout);
        bluePanel1Layout.setHorizontalGroup(
            bluePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bluePanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bluePanel1Layout.setVerticalGroup(
            bluePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bluePanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Training"));

        jScrollPane2.setViewportView(tabel_data_training);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnImportTraining.setText("Import Data");
        btnImportTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportTrainingActionPerformed(evt);
            }
        });
        jPanel3.add(btnImportTraining);

        jButton1.setText("Simpan Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("Kosongkan Data");
        jPanel3.add(jButton2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBarTraining, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBarTraining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hasil Perhitungan"));

        jScrollPane1.setViewportView(tabel_hasil_perhitungan);

        jLabel5.setText("Hasil Analisa Data");

        txtHasilAnalisia.setColumns(20);
        txtHasilAnalisia.setRows(5);
        txtHasilAnalisia.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jScrollPane3.setViewportView(txtHasilAnalisia);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAnalisaData.setText("Analisa Data");
        btnAnalisaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisaDataActionPerformed(evt);
            }
        });
        jPanel4.add(btnAnalisaData);

        btnEntropyGain.setText("Hitung Entropy dan Gain");
        btnEntropyGain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntropyGainActionPerformed(evt);
            }
        });
        jPanel4.add(btnEntropyGain);

        btnTampilkanPohon.setText("Tampilkan Pohon");
        jPanel4.add(btnTampilkanPohon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bluePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bluePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportTrainingActionPerformed
        contAction++;
        TampilkanWorker worker = new TampilkanWorker();
        if(contAction == 1)prosesFilter();
        
        if(chooserSelected.showDialog(null, "pilih file excel")==JFileChooser.APPROVE_OPTION){
            file = chooserSelected.getSelectedFile();
            worker.execute();
            if(file.getName().endsWith("xls") || file.getName().endsWith("xlsx")){
                JOptionPane.showMessageDialog(null, excelHelper.prosesImport(file, 
                        tabel_data_training));
            }else{
                JOptionPane.showMessageDialog(null, "maaf ini bukan file excel");
            }
        }
    }//GEN-LAST:event_btnImportTrainingActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        TampilkanWorker worker = new TampilkanWorker();
        if(tabel_data_training.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "maaf data training masih kosong");
        }else{
            List<DataTraining>listData = new ArrayList<>();
            for(int i=0; i<tabel_data_training.getRowCount(); i++){
                
                String Nama_Siswa = (String) tabel_data_training.getValueAt(i, 0);
                String Atribut_Rumah = (String) tabel_data_training.getValueAt(i, 1);
                String Atribut_Kendaraan = (String) tabel_data_training.getValueAt(i, 2);
                String Atribut_Penghasilan = (String) tabel_data_training.getValueAt(i, 3);
                String Atribut_Pekerjaan = (String) tabel_data_training.getValueAt(i, 4);
                String Atribut_Saudara = (String) tabel_data_training.getValueAt(i, 5);
                String Atribut_Rapot = (String) tabel_data_training.getValueAt(i, 6);
                String Kelayakan = (String) tabel_data_training.getValueAt(i, 7);
                
                DataTraining training = new DataTraining();
                training.setNama(Nama_Siswa);
                training.setRumah(Atribut_Rumah);
                training.setJumlah_kendaraan(Atribut_Kendaraan);
                training.setJumlah_saudarakandung(Atribut_Saudara);
                training.setPenghasilan_orangtua(Atribut_Penghasilan);
                training.setPekerjaan_orangtua(Atribut_Pekerjaan);
                training.setNilai_rapot(Atribut_Rapot);
                training.setKelayakan(Kelayakan);
                
                //simpan keseluruhan data training
                worker.execute();
                daoImpl.simpanDataTraining(training);
            }
            loadDataTraining();
            JOptionPane.showMessageDialog(null, "data training berhasil disimpan");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAnalisaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisaDataActionPerformed
        // analisa data
        JOptionPane.showMessageDialog(null, "data berhasil di analisa");
        c45.analisaData(this);
    }//GEN-LAST:event_btnAnalisaDataActionPerformed

    private void btnEntropyGainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntropyGainActionPerformed
        // entropy dan gain
        c45.hitungEntropyDanGain(this);
    }//GEN-LAST:event_btnEntropyGainActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private paket.launk.java.container.BluePanel bluePanel1;
    private javax.swing.JButton btnAnalisaData;
    private javax.swing.JButton btnEntropyGain;
    public javax.swing.JButton btnImportTraining;
    private javax.swing.JButton btnTampilkanPohon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JProgressBar progressBarTraining;
    private com.stripbandunk.jwidget.JDynamicTable tabel_data_training;
    private com.stripbandunk.jwidget.JDynamicTable tabel_hasil_perhitungan;
    private javax.swing.JTextArea txtHasilAnalisia;
    // End of variables declaration//GEN-END:variables
}
