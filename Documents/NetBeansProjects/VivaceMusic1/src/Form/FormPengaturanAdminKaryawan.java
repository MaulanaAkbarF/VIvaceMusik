
/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class FormPengaturanAdminKaryawan extends javax.swing.JPanel {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi
    */
    private void tampilkaninfo_admin(){
        try {
            String sqls = "SELECT info_admin FROM informasi";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            while (ress.next()){
                txtinformasiadmin.setText(ress.getString(1));
            }
            } catch (SQLException ex) {
        }
    }
    
    private void tampilkaninfo_pemilik(){
        try {
            String sqls = "SELECT info_pemilik FROM informasi";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            while (ress.next()){
                txtinformasipemilik.setText(ress.getString(1));
            }
            } catch (SQLException ex) {
        }
    }
    
    private void tampilkaninfo_admin_edit(){
        try {
            String sqls = "SELECT info_admin FROM informasi";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            while (ress.next()){
                txtInfo.setText(ress.getString(1));
            }
            } catch (SQLException ex) {
        }
    }
    
    private void hidebtn(){
        btnTWTON.setText(null);
        btnTWTON.setVisible(false);
        btnTSOFF.setText(null);
        btnTSOFF.setVisible(false);
        btnSOUON.setText(null);
        btnSOUON.setVisible(false);
    }
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 
    
    public FormPengaturanAdminKaryawan() {
        initComponents();
        hidebtn();
        tampilkaninfo_admin();
        tampilkaninfo_pemilik();
        panelI.setVisible(false);
        txtinformasiadmin.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMenu = new javax.swing.JLabel();
        panelI = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JLabel();
        btnBatal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        panelD = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtinformasipemilik = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtinformasiadmin = new javax.swing.JTextArea();
        btnTWTOFF = new javax.swing.JLabel();
        btnTWTON = new javax.swing.JLabel();
        btnTSOFF = new javax.swing.JLabel();
        btnTSON = new javax.swing.JLabel();
        btnSOUOFF = new javax.swing.JLabel();
        btnSOUON = new javax.swing.JLabel();
        btnINFAEdit = new javax.swing.JLabel();
        teksTWT = new javax.swing.JLabel();
        teksTS = new javax.swing.JLabel();
        teksINFA = new javax.swing.JLabel();
        teksSOU = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        txtLogout = new javax.swing.JLabel();
        bgP1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        txtMenu.setText("Pengaturan");
        txtMenu.setAlignmentY(0.0F);
        add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 400, 45));

        panelI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(95, 95, 95));
        btnSimpan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSimpan.setText("SIMPAN");
        btnSimpan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSimpanMouseMoved(evt);
            }
        });
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSimpanMouseExited(evt);
            }
        });
        panelI.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1027, 786, 200, 40));

        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(95, 95, 95));
        btnBatal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBatal.setText("BATAL");
        btnBatal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBatalMouseMoved(evt);
            }
        });
        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBatalMouseExited(evt);
            }
        });
        panelI.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 786, 200, 40));

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        txtInfo.setColumns(20);
        txtInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtInfo.setRows(5);
        jScrollPane1.setViewportView(txtInfo);

        panelI.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 820, 460));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Informasi Admin.png"))); // NOI18N
        panelI.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        add(panelI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        panelD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(null);

        txtinformasipemilik.setColumns(20);
        txtinformasipemilik.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtinformasipemilik.setRows(5);
        jScrollPane3.setViewportView(txtinformasipemilik);

        panelD.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 213, 720, 300));

        jScrollPane2.setBorder(null);

        txtinformasiadmin.setColumns(20);
        txtinformasiadmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtinformasiadmin.setRows(5);
        jScrollPane2.setViewportView(txtinformasiadmin);

        panelD.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 620, 720, 300));

        btnTWTOFF.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnTWTOFF.setForeground(new java.awt.Color(95, 95, 95));
        btnTWTOFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTWTOFF.setText("OFF");
        btnTWTOFF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTWTOFFMouseMoved(evt);
            }
        });
        btnTWTOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTWTOFFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTWTOFFMouseExited(evt);
            }
        });
        panelD.add(btnTWTOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 160, 40));

        btnTWTON.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnTWTON.setForeground(new java.awt.Color(95, 95, 95));
        btnTWTON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTWTON.setText("ON");
        btnTWTON.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTWTONMouseMoved(evt);
            }
        });
        btnTWTON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTWTONMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTWTONMouseExited(evt);
            }
        });
        panelD.add(btnTWTON, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 160, 40));

        btnTSOFF.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnTSOFF.setForeground(new java.awt.Color(95, 95, 95));
        btnTSOFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTSOFF.setText("OFF");
        btnTSOFF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTSOFFMouseMoved(evt);
            }
        });
        btnTSOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTSOFFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTSOFFMouseExited(evt);
            }
        });
        panelD.add(btnTSOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 160, 40));

        btnTSON.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnTSON.setForeground(new java.awt.Color(95, 95, 95));
        btnTSON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTSON.setText("ON");
        btnTSON.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTSONMouseMoved(evt);
            }
        });
        btnTSON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTSONMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTSONMouseExited(evt);
            }
        });
        panelD.add(btnTSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 160, 40));

        btnSOUOFF.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnSOUOFF.setForeground(new java.awt.Color(95, 95, 95));
        btnSOUOFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSOUOFF.setText("OFF");
        btnSOUOFF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSOUOFFMouseMoved(evt);
            }
        });
        btnSOUOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSOUOFFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSOUOFFMouseExited(evt);
            }
        });
        panelD.add(btnSOUOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 160, 40));

        btnSOUON.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnSOUON.setForeground(new java.awt.Color(95, 95, 95));
        btnSOUON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSOUON.setText("ON");
        btnSOUON.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSOUONMouseMoved(evt);
            }
        });
        btnSOUON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSOUONMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSOUONMouseExited(evt);
            }
        });
        panelD.add(btnSOUON, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 160, 40));

        btnINFAEdit.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnINFAEdit.setForeground(new java.awt.Color(95, 95, 95));
        btnINFAEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnINFAEdit.setText("EDIT INFO");
        btnINFAEdit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnINFAEditMouseMoved(evt);
            }
        });
        btnINFAEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnINFAEditMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnINFAEditMouseExited(evt);
            }
        });
        panelD.add(btnINFAEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 160, 40));

        teksTWT.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        teksTWT.setText("Tampilkan Waktu dan Tanggal :");
        teksTWT.setToolTipText("");
        panelD.add(teksTWT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 410, 40));

        teksTS.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        teksTS.setText("Tampilkan Username :");
        panelD.add(teksTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 410, 40));

        teksINFA.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        teksINFA.setText("Ubah Informasi Administrator :");
        panelD.add(teksINFA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 410, 40));

        teksSOU.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        teksSOU.setText("Sembunyikan Opsi Urutkan :");
        panelD.add(teksSOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 410, 40));

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(95, 95, 95));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logouticon.png"))); // NOI18N
        btnLogout.setText("     KELUAR");
        btnLogout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLogoutMouseMoved(evt);
            }
        });
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        panelD.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 864, 140, 50));
        panelD.add(txtLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 950, -1, -1));

        bgP1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Informasi.png"))); // NOI18N
        panelD.add(bgP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        add(panelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void btnTWTOFFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTOFFMouseMoved
        btnTWTOFF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTWTOFFMouseMoved

    private void btnTWTOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTOFFMouseClicked
        btnTWTOFF.setText(null);
        btnTWTOFF.setVisible(false);
        btnTWTON.setText("ON");
        btnTWTON.setVisible(true);
    }//GEN-LAST:event_btnTWTOFFMouseClicked

    private void btnTWTOFFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTOFFMouseExited
        btnTWTOFF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTWTOFFMouseExited

    private void btnTWTONMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTONMouseMoved
        btnTWTON.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTWTONMouseMoved

    private void btnTWTONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTONMouseClicked
        btnTWTOFF.setText("OFF");
        btnTWTOFF.setVisible(true);
        btnTWTON.setText(null);
        btnTWTON.setVisible(false);
    }//GEN-LAST:event_btnTWTONMouseClicked

    private void btnTWTONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTONMouseExited
        btnTWTON.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTWTONMouseExited

    private void btnTSOFFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSOFFMouseMoved
        btnTSOFF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTSOFFMouseMoved

    private void btnTSOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSOFFMouseClicked
        btnTSOFF.setText(null);
        btnTSOFF.setVisible(false);
        btnTSON.setText("ON");
        btnTSON.setVisible(true);
    }//GEN-LAST:event_btnTSOFFMouseClicked

    private void btnTSOFFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSOFFMouseExited
        btnTSOFF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTSOFFMouseExited

    private void btnTSONMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSONMouseMoved
        btnTSON.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTSONMouseMoved

    private void btnTSONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSONMouseClicked
        btnTSOFF.setText("OFF");
        btnTSOFF.setVisible(true);
        btnTSON.setText(null);
        btnTSON.setVisible(false);
    }//GEN-LAST:event_btnTSONMouseClicked

    private void btnTSONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSONMouseExited
        btnTSON.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTSONMouseExited

    private void btnSOUOFFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUOFFMouseMoved
        btnSOUOFF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSOUOFFMouseMoved

    private void btnSOUOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUOFFMouseClicked
        btnSOUOFF.setText(null);
        btnSOUOFF.setVisible(false);
        btnSOUON.setText("ON");
        btnSOUON.setVisible(true);
    }//GEN-LAST:event_btnSOUOFFMouseClicked

    private void btnSOUOFFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUOFFMouseExited
        btnSOUOFF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSOUOFFMouseExited

    private void btnSOUONMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUONMouseMoved
        btnSOUON.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSOUONMouseMoved

    private void btnSOUONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUONMouseClicked
        btnSOUOFF.setText("OFF");
        btnSOUOFF.setVisible(true);
        btnSOUON.setText(null);
        btnSOUON.setVisible(false);
    }//GEN-LAST:event_btnSOUONMouseClicked

    private void btnSOUONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUONMouseExited
        btnSOUON.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSOUONMouseExited

    private void btnLogoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseMoved
        btnLogout.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnLogoutMouseMoved

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        hidebtn();
        btnTWTOFF.setText("OFF");
        btnTSON.setText("ON");
        btnSOUOFF.setText("OFF");
        txtLogout.setText("logout");
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        btnLogout.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnINFAEditMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnINFAEditMouseMoved
        btnINFAEdit.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnINFAEditMouseMoved

    private void btnINFAEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnINFAEditMouseClicked
        tampilkaninfo_admin_edit();
        panelI.setVisible(true);
        btnINFAEdit.setVisible(false);
        txtinformasipemilik.setVisible(false);
        txtinformasiadmin.setVisible(false);
        btnLogout.setVisible(false);
        txtMenu.setText("Informasi");
    }//GEN-LAST:event_btnINFAEditMouseClicked

    private void btnINFAEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnINFAEditMouseExited
        btnINFAEdit.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnINFAEditMouseExited

    private void btnSimpanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseMoved
        btnSimpan.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSimpanMouseMoved

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        try {
            String sqls = "UPDATE informasi SET info_admin = '"+txtInfo.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            pst.execute();
            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Perubahan Data Gagal!\n"+e.getMessage(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
        txtinformasiadmin.setText(txtInfo.getText());
        panelI.setVisible(false);
        btnINFAEdit.setVisible(true);
        txtinformasipemilik.setVisible(true);
        txtinformasiadmin.setVisible(true);
        btnLogout.setVisible(true);
        txtMenu.setText("Pengaturan");
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnSimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseExited
        btnSimpan.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSimpanMouseExited

    private void btnBatalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseMoved
        btnBatal.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnBatalMouseMoved

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
        panelI.setVisible(false);
        btnINFAEdit.setVisible(true);
        txtinformasipemilik.setVisible(true);
        txtinformasiadmin.setVisible(true);
        btnLogout.setVisible(true);
        txtMenu.setText("Pengaturan");
    }//GEN-LAST:event_btnBatalMouseClicked

    private void btnBatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseExited
        btnBatal.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnBatalMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgP1;
    private javax.swing.JLabel btnBatal;
    public javax.swing.JLabel btnINFAEdit;
    private javax.swing.JLabel btnLogout;
    public javax.swing.JLabel btnSOUOFF;
    public javax.swing.JLabel btnSOUON;
    private javax.swing.JLabel btnSimpan;
    public javax.swing.JLabel btnTSOFF;
    public javax.swing.JLabel btnTSON;
    public javax.swing.JLabel btnTWTOFF;
    public javax.swing.JLabel btnTWTON;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelD;
    private javax.swing.JPanel panelI;
    public javax.swing.JLabel teksINFA;
    private javax.swing.JLabel teksSOU;
    private javax.swing.JLabel teksTS;
    private javax.swing.JLabel teksTWT;
    public javax.swing.JTextArea txtInfo;
    protected javax.swing.JLabel txtLogout;
    private javax.swing.JLabel txtMenu;
    private javax.swing.JTextArea txtinformasiadmin;
    private javax.swing.JTextArea txtinformasipemilik;
    // End of variables declaration//GEN-END:variables
}
