/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelanggan;

import Driver.Login;
import KoneksiDB.koneksi;
import Model.modelPelanggan;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class BayarTagihan extends javax.swing.JFrame {
        PreparedStatement pre=null;
        Statement  stat=null;
        Connection conn=koneksi.getConnection();;
        ResultSet rs=null;
        private static String getID,Check_ID_Tagihan;
        private static String id_pembayaran;
        private static String id_tagihan;
        private static String id_pelanggan;
        private static String id_penggunaan;
        private static int METER_AWAL;
        private static int TotalBayar;
        private static int count;
        private static int LastDay,Day;
        private static int tahun,hari,bulan,res;
        Random randomNumbers = new Random();
        InfoTagihan IT = new InfoTagihan();
    /**
     * Creates new form BayarTagihan
     */
    public BayarTagihan() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        new Thread(){
        public void run(){
            while (true){
                Calendar kal = new GregorianCalendar();
                tahun =  kal.get(Calendar.YEAR);
                bulan = kal.get(Calendar.MONTH)+1;
                hari = kal.get(Calendar.DAY_OF_MONTH);
                int jam = kal.get(Calendar.HOUR_OF_DAY);
                int menit = kal.get(Calendar.MINUTE);
                int detik = kal.get(Calendar.SECOND);
                String Tanggal  = tahun+"-"+bulan+"-"+hari;
                String waktu1= jam+" : "+menit+" : "+ detik;
                String waktu2= jam+" - "+menit+" : "+ detik;
                txt_Tanggal.setText(Tanggal);
                txt_waktu.setText(waktu1);
               
            }
        }
    }.start();
        
        try {
            pre = conn.prepareStatement("select * from penggunaan where bulan=?");
              pre.setInt(1, bulan);
              rs = pre.executeQuery();
              if(rs.next())
              {
                  
              }
              else
              {
                  InsertPenggunaan();
                  InsertTagihan();
              }
        }catch(SQLException ex)
        {
            
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Jpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboBulan = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_KWH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_tarif = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_biayaAdmin = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txt_Total = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txt_Tanggal = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txt_waktu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Paymen.png"))); // NOI18N
        jButton1.setText("INFO BILLS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account.png"))); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Exit.png"))); // NOI18N
        jLabel2.setText("Exit");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel2)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );

        Jpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Month");

        comboBulan.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        comboBulan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        comboBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBulanActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Search.png"))); // NOI18N
        jButton3.setText("FIND");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Watt used");

        txt_KWH.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Rate / Watt");

        txt_tarif.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Cost Admin");

        txt_biayaAdmin.setEditable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Pay.png"))); // NOI18N
        jButton2.setText("PAY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_Total.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Total Cost");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_biayaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_KWH, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(103, 103, 103))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_KWH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txt_biayaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel3)
                .addGap(56, 56, 56)
                .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(89, 89, 89))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102)));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Created.png"))); // NOI18N
        jLabel5.setText("@CopyRigh Group 3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(240, 240, 240))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(26, 26, 26))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_Tanggal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_Tanggal.setText("Tanggal");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        txt_waktu.setBackground(new java.awt.Color(204, 255, 255));
        txt_waktu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_waktu.setText("Waktu");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(txt_waktu)
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txt_waktu)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_Tanggal)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_Tanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private static int meter_awal = 0;
    private static int meter_akhir = 0;
    public void InsertPenggunaan(){
        // Cek Data Penggunaan 
         int count = 0;
         int Hasil;
         try
         {
              stat = conn.createStatement();
                rs = stat.executeQuery("select * from penggunaan");
                int count2 = 0;
                    while(rs.next())
                    {
                        count++;
                    }
                        if(count > 0)
                        {
                           rs = stat.executeQuery("select COUNT(*),left(id_penggunaan,3) from penggunaan");
                             while(rs.next())
                             {
                             int ID = rs.getInt("COUNT(*)");
                              Hasil = ID + 1;
                             String code = rs.getString("left(id_penggunaan,3)");
                             id_penggunaan=(code + String.valueOf(Hasil));
                             }
                        }
                        else
                        {
                             Hasil = 1;
                             id_penggunaan = ("PG0" + String.valueOf(Hasil));
                        }    


           
            
            if(METER_AWAL == 900)
            {
                meter_awal = randomNumbers.nextInt(900);
            }
            else if(METER_AWAL == 1300)
            {
                meter_awal = randomNumbers.nextInt(1300);
            }
            else if(METER_AWAL == 2200)
            {
                meter_awal = randomNumbers.nextInt(2200);
            }
            else if(METER_AWAL == 3500)
            {
                meter_awal = randomNumbers.nextInt(3500);
            }
            else if(METER_AWAL == 4400)
            {
                meter_awal = randomNumbers.nextInt(4400);
            }
            else
            {
                meter_awal = randomNumbers.nextInt(5500);
            }
            meter_akhir = randomNumbers.nextInt(5500);
            while(meter_awal < meter_akhir)
            {
               meter_akhir = randomNumbers.nextInt(5500); 
            }
                pre = conn.prepareStatement("insert into penggunaan values(?,?,?,?,?,?)");
              pre.setString(1, id_penggunaan);
              pre.setString(2, getID);
              pre.setInt(3, bulan);
              pre.setInt(4, tahun);
              pre.setInt(5, meter_awal);
              pre.setInt(6, meter_akhir);
              
              pre.executeUpdate();
         }
              catch(SQLException ex)   
              {
               }
    }
    public void InsertTagihan(){
        // Cek Data Penggunaan 
         int count = 0;
         int Hasil;
         
         try
         {
              stat = conn.createStatement();
                rs = stat.executeQuery("select * from tagihan");
                
                    while(rs.next())
                    {
                        count++;
                    }
                        if(count > 0)
                        {
                           rs = stat.executeQuery("select COUNT(*),left(id_tagihan,2) from tagihan");
                             while(rs.next())
                             {
                             int ID = rs.getInt("COUNT(*)");
                             Hasil = ID + 1;
                             String code = rs.getString("left(id_tagihan,2)");
                             id_tagihan=(code + String.valueOf(Hasil));
                             }
                        }
                        else
                        {
                             Hasil = 1;
                             id_tagihan = ("T0" + String.valueOf(Hasil));
                        }    
                 
               
                
                pre = conn.prepareStatement("insert into tagihan values(?,?,?,?,?,?,?)");
              pre.setString(1, id_tagihan);
              pre.setString(2, id_penggunaan);
              pre.setString(3, getID);
              pre.setInt(4,  bulan);
              pre.setInt(5, tahun);
              pre.setInt(6, meter_awal - meter_akhir);
              pre.setInt(7, 0);
              
              pre.executeUpdate();
         }
              catch(SQLException ex)   
              {
              }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new InfoTagihan().main(getID,null);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             // Cek Data Penggunaan 
         int count = 0;
         int Hasil;
     
       try
         {
           if(txt_KWH.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null, "Please Find Your Bills First");
           }
           else
           {
             if(count == 0)
              {
                stat = conn.createStatement();
                rs = stat.executeQuery("select * from pembayaran INNER Join tagihan ON pembayaran.id_tagihan = tagihan.id_tagihan ");
                String Status = IT.StatusPembayaran(Check_ID_Tagihan);
                if(!Status.equals("paid")) 
                {
                            while(rs.next())
                            {
                                count++;
                            }
                                if(count > 0)
                                {
                                   rs = stat.executeQuery("select COUNT(*),left(id_pembayaran,4) from pembayaran");
                                     while(rs.next())
                                     {
                                     int ID = rs.getInt("COUNT(*)");
                                      Hasil = ID + 1;
                                     String code = rs.getString("left(id_pembayaran,4)");
                                     id_pembayaran=(code + String.valueOf(Hasil));
                                     }
                                }
                                else
                                {
                                     Hasil = 1;
                                     id_pembayaran = ("PAY0" + String.valueOf(Hasil));
                                }   

                    int Tanggal = randomNumbers.nextInt(29);
                    int Bulan = randomNumbers.nextInt(12);


                        pre = conn.prepareStatement("insert into pembayaran values(?,?,?,?,?,?,?,null)");
                      pre.setString(1, id_pembayaran);
                      pre.setString(2, id_tagihan);
                      pre.setString(3, getID);
                      pre.setInt(4, hari);
                      pre.setInt(5, bulan);
                      pre.setInt(6, 2500);
                      pre.setInt(7, TotalBayar);
                      pre.executeUpdate();
                      JOptionPane.showMessageDialog(null, "Payment Succesfull");
                   String reportSource = null;
                   String reportDest = null;
           try{
           HashMap hash = new HashMap();
           
           hash.put("ID", getID);
           hash.put("bulan", comboBulan.getSelectedIndex()+1);
           reportSource = System.getProperty("user.dir") +"/src/Report/report3.jrxml";
           reportDest = System.getProperty("user.dir") +"/src/Report/report3.jasper";
           JasperReport JR = JasperCompileManager.compileReport(reportSource);
           JasperPrint jp = JasperFillManager.fillReport(JR, hash, conn);
           JasperExportManager.exportReportToHtmlFile(jp,reportDest);
           JasperViewer.viewReport(jp,false);
           
           }
           catch(Exception ex)
           {
               System.out.println(ex.getMessage());
           }
                 }
                else
                {
                    StatusKosong();
                        JOptionPane.showMessageDialog(null, "the bills has been Paid");
                        
                }
        
             }
           }
       }
              catch(SQLException ex)   
              {
              }
    
    
    }//GEN-LAST:event_jButton2ActionPerformed
    private void StatusKosong(){
        txt_KWH.setText("");
        txt_tarif.setText("");
        txt_biayaAdmin.setText("");
        txt_Total.setText("");
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String Bulan = String.valueOf(comboBulan.getSelectedItem());
        Calendar c = Calendar.getInstance();
        c.set(tahun, (comboBulan.getSelectedIndex()+1) - 1, 1);
       int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
       
        try{
           
        
            pre = conn.prepareStatement("SELECT * FROM tagihan INNER JOIN pelanggan ON pelanggan.id_pelanggan = tagihan.id_pelanggan INNER JOIN tarif ON pelanggan.id_tarif = tarif.id_tarif where pelanggan.id_pelanggan=? and bulan=?");
            pre.setString(1, getID);
            pre.setString(2, Bulan);
            rs = pre.executeQuery();
            if(rs.next())
            {
             Check_ID_Tagihan = rs.getString("tagihan.id_tagihan");
             Check(Check_ID_Tagihan);
             
             String Status = IT.StatusPembayaran(Check_ID_Tagihan);
             
             
                if(count == 0 && hari == lastDay||count == 0 && bulan > comboBulan.getSelectedIndex()+1)
                {
                txt_KWH.setText(String.valueOf(rs.getInt("tagihan.jumlah_meter")));
                id_tagihan = rs.getString("tagihan.id_tagihan");
                int tarif = rs.getInt("tarif.tarif_perkwh")/rs.getInt("tarif.daya");
                txt_tarif.setText(String.valueOf(tarif));
                txt_biayaAdmin.setText(String.valueOf(2500));
                TotalBayar = (rs.getInt("tagihan.jumlah_meter")*tarif)+2500;
                txt_Total.setText(String.valueOf((rs.getInt("tagihan.jumlah_meter")*tarif)+2500));
                
                }
                else if (Status.equals("paid"))
                {
                    JOptionPane.showMessageDialog(null, "the bills has been Paid");
                }
                else if(hari != lastDay)
                {
                    StatusKosong();
                    JOptionPane.showMessageDialog(null, "You can only pay at the end of the month");
                }
                
            }
            else
            {
                StatusKosong();
                JOptionPane.showMessageDialog(null, " You not have  bills this month ");
            }
        
        }
        catch(SQLException ex)
        {
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    private void Check(String id_tagihan){
        try
        {
            pre = conn.prepareStatement("SELECT count(*),tagihan.jumlah_meter,tarif.tarif_perkwh,tarif.daya,tagihan.id_tagihan FROM pembayaran INNER JOIN tagihan on pembayaran.id_tagihan=tagihan.id_tagihan INNER JOIN pelanggan ON pelanggan.id_pelanggan = tagihan.id_pelanggan INNER JOIN tarif ON pelanggan.id_tarif = tarif.id_tarif where pembayaran.id_tagihan=?");
            pre.setString(1, id_tagihan);
            rs = pre.executeQuery();
            if(rs.next())
            {
                count = rs.getInt("count(*)");
            }
            
        }
        catch(SQLException ex)
        {
            
        }
    }
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new Login().setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void comboBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBulanActionPerformed
       
    }//GEN-LAST:event_comboBulanActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String ID,String args[]) {
        getID = ID;
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BayarTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BayarTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BayarTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BayarTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BayarTagihan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JComboBox comboBulan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_KWH;
    private javax.swing.JLabel txt_Tanggal;
    private javax.swing.JTextField txt_Total;
    private javax.swing.JTextField txt_biayaAdmin;
    private javax.swing.JTextField txt_tarif;
    private javax.swing.JLabel txt_waktu;
    // End of variables declaration//GEN-END:variables
}
