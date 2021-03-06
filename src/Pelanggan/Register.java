/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelanggan;

import Admin.CustomerManage;
import Driver.Login;
import KoneksiDB.koneksi;
import Model.modelPelanggan;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Register extends javax.swing.JFrame {
        PreparedStatement pre=null;
        Statement  stat=null;
        Connection conn= koneksi.getConnection();;
        ResultSet rs=null;
        private static String id_tarif;
        private static String id_pelanggan;
        private static String id_penggunaan;
        private static String id_tagihan;
        private static boolean checked = false;
        Random randomNumbers = new Random();
        private static int METER_AWAL;
        private static boolean OP = false;
        private static String Tanggal;
        private static int tahun,hari,bulan;
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        Btn_Back.setOpaque(false);
        Btn_Back.setContentAreaFilled(false); //to make the content area transparent
        Btn_Back.setBorderPainted(false);
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
                Tanggal  = hari+""+bulan+""+tahun+""+jam+""+menit;
                
            }
        }
    }.start();
        try{
        
        stat = conn.createStatement();
        rs = stat.executeQuery("select * from tarif");
            while(rs.next())
            {
             comboPower.addItem(rs.getInt("daya"));
            }
        
        }
        catch(SQLException ex)
        {
            
        }
        
        txt_noKWH.setText("14"+String.valueOf(Tanggal));
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_NamaPelanggan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txt_noKWH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_tarif = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboPower = new javax.swing.JComboBox();
        Btn_Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102)));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Created.png"))); // NOI18N
        jLabel6.setText("@CopyRigh Group 3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Algerian", 2, 24)); // NOI18N
        jLabel3.setText("E  Pay");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logi Listrik.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(290, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(344, 344, 344))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Customers Name *");

        txt_NamaPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NamaPelangganActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Address *");

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane1.setViewportView(txt_alamat);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("No KWH");

        txt_noKWH.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Power *");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Rates *");

        txt_tarif.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Username *");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Password *");

        jButton1.setText("Check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Save.png"))); // NOI18N
        jButton2.setText("CREATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboPower.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Daya" }));
        comboPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPowerActionPerformed(evt);
            }
        });

        Btn_Back.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        Btn_Back.setText("BACK");
        Btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_NamaPelanggan)
                    .addComponent(jScrollPane1)
                    .addComponent(txt_noKWH)
                    .addComponent(txt_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPower, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_username)
                                    .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(126, 126, 126))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btn_Back)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Back)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txt_NamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_noKWH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(comboPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(40, 40, 40)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPowerActionPerformed
        int pilih;
        int daya = 0;
        String TarifSelected = null;
        if(!String.valueOf(comboPower.getSelectedItem()).equals("Pilih Daya"))
        {
            daya = Integer.parseInt(String.valueOf(comboPower.getSelectedItem()));
        }
        else
        {
            String.valueOf(daya);
        }
        pilih = comboPower.getSelectedIndex();
        switch (pilih) {
            case 0:
                txt_tarif.setText("");
                    id_tarif = null;
                break;
            case 1:
                try{
                    
                    pre = conn.prepareStatement("select * from tarif where daya=?");
                    pre.setInt(1, daya);
                    rs = pre.executeQuery();
                        if(rs.next())
                        {
                         TarifSelected = String.valueOf(rs.getInt("tarif_perkwh"));
                         id_tarif = rs.getString("id_tarif");
                         METER_AWAL = rs.getInt("daya");
                        }
                    }
                catch(SQLException ex)
                    {
                    }
                break;
            case 2:
                try{
                    
                    pre = conn.prepareStatement("select * from tarif where daya=?");
                    pre.setInt(1, daya);
                    rs = pre.executeQuery();
                        if(rs.next())
                        {
                         TarifSelected = String.valueOf(rs.getInt("tarif_perkwh"));
                         id_tarif = rs.getString("id_tarif");
                         METER_AWAL = rs.getInt("daya");
                        }
                    }
                catch(SQLException ex)
                    {
                    }
                break;
            case 3:
                try{
                   
                    pre = conn.prepareStatement("select * from tarif where daya=?");
                    pre.setInt(1, daya);
                    rs = pre.executeQuery();
                        if(rs.next())
                        {
                         TarifSelected = String.valueOf(rs.getInt("tarif_perkwh"));
                         id_tarif = rs.getString("id_tarif");
                         METER_AWAL = rs.getInt("daya");
                        }
                    }
                catch(SQLException ex)
                    {
                    };
                break;
            case 4:
                try{
                   
                    pre = conn.prepareStatement("select * from tarif where daya=?");
                    pre.setInt(1, daya);
                    rs = pre.executeQuery();
                        if(rs.next())
                        {
                         TarifSelected = String.valueOf(rs.getInt("tarif_perkwh"));
                         id_tarif = rs.getString("id_tarif");
                         METER_AWAL = rs.getInt("daya");
                        }
                    }
                catch(SQLException ex)
                    {
                    };
                break;
            case 5:
                try{
                   
                    pre = conn.prepareStatement("select * from tarif where daya=?");
                    pre.setInt(1, daya);
                    rs = pre.executeQuery();
                        if(rs.next())
                        {
                         TarifSelected = String.valueOf(rs.getInt("tarif_perkwh"));
                         id_tarif = rs.getString("id_tarif");
                         METER_AWAL = rs.getInt("daya");
                        }
                    }
                catch(SQLException ex)
                    {
                    };
                break;
            case 6:
                try{
                   
                    pre = conn.prepareStatement("select * from tarif where daya=?");
                    pre.setInt(1, daya);
                    rs = pre.executeQuery();
                        if(rs.next())
                        {
                         TarifSelected = String.valueOf(rs.getInt("tarif_perkwh"));
                         id_tarif = rs.getString("id_tarif");
                         METER_AWAL = rs.getInt("daya");
                        }
                    }
                catch(SQLException ex)
                    {
                    };
                break;
            
        }
        txt_tarif.setText(TarifSelected);
        
    }//GEN-LAST:event_comboPowerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
        
        stat = conn.createStatement();

        rs = stat.executeQuery("select * from pelanggan ");
        boolean X = false;
            while(rs.next())
            {
               if(String.valueOf(txt_username.getText()).equals(rs.getString("username")))
               {
                   JOptionPane.showMessageDialog(null, "Username Already Use");
                   checked = false;
                   X = true;
               }
            }
            if(txt_username.getText().equals(""))
            {
                
            }
            else if(X == false)
            {
                JOptionPane.showMessageDialog(null, "Username can Use");
                checked = true;
            }
        }
        catch(SQLException ex)
        {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_NamaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NamaPelangganActionPerformed
    }//GEN-LAST:event_txt_NamaPelangganActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
            int Hasil = 0 ;
        try 
        {
            // Cek Data Pelanggan
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from pelanggan");
            int count = 0;
            while(rs.next())
            {
                count++;
            }
                if(count > 0)
                {
                   rs = stat.executeQuery("select COUNT(*),left(id_pelanggan,2) from pelanggan");
                     while(rs.next())
                     {
                     int ID = rs.getInt("COUNT(*)");
                      Hasil = ID + 1;
                     String code = rs.getString("left(id_pelanggan,2)");
                     id_pelanggan=(code + String.valueOf(Hasil));
                     }
                }
                else
                {
                     Hasil = 1;
                     id_pelanggan = ("P0" + String.valueOf(Hasil));
                }
            if(id_tarif == null)
            {
                JOptionPane.showMessageDialog(null, "Choose Daya First");
            }
            else if(checked == false)
            {
                JOptionPane.showMessageDialog(null, "Username Can Not use or Not Filled");
            }
            else if(String.valueOf(txt_password.getText()).equals("") || String.valueOf(txt_NamaPelanggan.getText()).equals("")|| String.valueOf(txt_alamat.getText()).equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill in all fields that have the symbol * ");
            }
            else
            {
            // Input Pelanggan
                pre = conn.prepareStatement("insert into pelanggan values(?,?,?,?,?,?,?)");
              pre.setString(1, id_pelanggan);
              pre.setString(2, String.valueOf(txt_username.getText()));
              pre.setString(3, String.valueOf(txt_password.getText()));
              pre.setString(4, String.valueOf(txt_noKWH.getText()));
              pre.setString(5, String.valueOf(txt_NamaPelanggan.getText()));
              pre.setString(6, String.valueOf(txt_alamat.getText()));
              pre.setString(7, id_tarif);
              
 
              
              pre.executeUpdate();
              
              InsertPenggunaan();
              InsertTagihan();
              
              JOptionPane.showMessageDialog(null, "Data Succes to Save");
              if(OP == false)
              {
              new BayarTagihan().main(id_pelanggan,null);
                       this.setVisible(false);
              }
              else
              {
                 new CustomerManage().setVisible(true);
                       this.setVisible(false); 
              }
              
            }
       
        }
         catch(SQLException ex)   
        {
             
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BackActionPerformed
     if(OP == false)
     {
         new Login().setVisible(true);
         this.setVisible(false);
     }
     else
     {
         new CustomerManage().setVisible(true);
         this.setVisible(false);
     }
    }//GEN-LAST:event_Btn_BackActionPerformed

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
              pre.setString(2, id_pelanggan);
              pre.setInt(3, bulan);
              pre.setInt(4, tahun);
              pre.setInt(5, meter_awal);
              pre.setInt(6, meter_akhir);
              System.out.println(id_penggunaan);
              System.out.println(id_pelanggan);
              System.out.println(bulan);
              System.out.println(tahun);
              System.out.println(meter_awal);
              System.out.println(meter_akhir);
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
                 
                System.out.println(bulan);
                
                pre = conn.prepareStatement("insert into tagihan values(?,?,?,?,?,?,?)");
              pre.setString(1, id_tagihan);
              pre.setString(2, id_penggunaan);
              pre.setString(3, id_pelanggan);
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
       
         
    /**
     * @param args the command line arguments
     */
    public static void main(boolean O,String args[]) {
        OP = O;
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Back;
    private javax.swing.JComboBox comboPower;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_NamaPelanggan;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_noKWH;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_tarif;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
