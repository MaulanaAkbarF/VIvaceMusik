
/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

package Form;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FormPengaturan extends javax.swing.JPanel {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi
    */ 
    
    String location=null;
    String tgl, filename;
    DefaultTableModel model = new DefaultTableModel();
    
    private void load_tabel() {
        model.addColumn("No");
        model.addColumn("ID Keanggotaan");
        model.addColumn("Nama Keanggotaan");
        model.addColumn("Hak Akses");
        model.addColumn("No. Telepon");
        
        try { 
            int no = 1;
            String sql = "SELECT idkaryawan, nama_karyawan, user_parameter, telepon FROM user ORDER BY idkaryawan";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow (new Object[] {no++, res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4)});
            }
        tabel.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabel(){
        TableColumn kolom;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabel.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(40);
        kolom = tabel.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(80); 
        kolom = tabel.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(200); 
        kolom = tabel.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(140);
        kolom = tabel.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(120);
//        kolom = tabel.getColumnModel().getColumn(5); 
//        kolom.setPreferredWidth(220);
    }
    
    public void kosongkan(){
        txtnamakeanggotaan.setText(null);
        txtpassword.setText(null);
        txtnotelp.setText(null);
        txtidktp.setText(null);
    }
    
    private void fileChooser(){
        JFileChooser path = new JFileChooser();
        path.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try{
                File f = path.getSelectedFile();
                location = f.getAbsolutePath();
                filename = location + "_" + date +".xls";
                txtlokasi.setText(filename);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 
    
    public FormPengaturan() {
        initComponents();
        load_tabel();
        lebar_tabel();
        txtidkeanggotaan.disable();
        eyeshow.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pengaturancb = new javax.swing.JComboBox<>();
        panelP = new javax.swing.JPanel();
        txtidktp = new javax.swing.JTextField();
        txtidkeanggotaan = new javax.swing.JTextField();
        txtnamakeanggotaan = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        eyehide = new javax.swing.JLabel();
        eyeshow = new javax.swing.JLabel();
        txtnotelp = new javax.swing.JTextField();
        hakaksescb = new javax.swing.JComboBox<>();
        tglst = new com.toedter.calendar.JDateChooser();
        txtcarisupplier = new javax.swing.JTextField();
        txtlokasi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnUbah = new javax.swing.JLabel();
        btnEkspor = new javax.swing.JLabel();
        btnCari = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        bgP = new javax.swing.JLabel();
        panelD = new javax.swing.JPanel();
        btnUbahD = new javax.swing.JLabel();
        bgP1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pengaturancb.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        Pengaturancb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pengaturan", "Database" }));
        Pengaturancb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PengaturancbActionPerformed(evt);
            }
        });
        add(Pengaturancb, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 50, 400, 45));

        panelP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtidktp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtidktp.setBorder(null);
        txtidktp.setOpaque(false);
        panelP.add(txtidktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 590, 40));

        txtidkeanggotaan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtidkeanggotaan.setBorder(null);
        txtidkeanggotaan.setOpaque(false);
        panelP.add(txtidkeanggotaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 590, 40));

        txtnamakeanggotaan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnamakeanggotaan.setBorder(null);
        txtnamakeanggotaan.setOpaque(false);
        panelP.add(txtnamakeanggotaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 590, 40));

        txtpassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtpassword.setBorder(null);
        txtpassword.setOpaque(false);
        panelP.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 540, 40));

        eyehide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eyehide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-hide-30.png"))); // NOI18N
        eyehide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyehideMouseClicked(evt);
            }
        });
        panelP.add(eyehide, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 550, 40, 40));

        eyeshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eyeshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-eye-30.png"))); // NOI18N
        eyeshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyeshowMouseClicked(evt);
            }
        });
        panelP.add(eyeshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 550, 40, 40));

        txtnotelp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnotelp.setBorder(null);
        txtnotelp.setOpaque(false);
        panelP.add(txtnotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 590, 40));

        hakaksescb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hakaksescb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "Pemilik", "Administrator", "Karyawan" }));
        hakaksescb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hakaksescbActionPerformed(evt);
            }
        });
        panelP.add(hakaksescb, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 750, 270, 40));

        tglst.setDateFormatString("dd-MM-yyyy");
        tglst.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelP.add(tglst, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 750, 290, 40));

        txtcarisupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcarisupplier.setBorder(null);
        txtcarisupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarisupplierActionPerformed(evt);
            }
        });
        panelP.add(txtcarisupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 890, 600, 40));

        txtlokasi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtlokasi.setBorder(null);
        txtlokasi.setOpaque(false);
        panelP.add(txtlokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 530, 40));

        tabel.setBackground(new java.awt.Color(244, 239, 224));
        tabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.setGridColor(new java.awt.Color(199, 199, 199));
        tabel.setRowHeight(18);
        tabel.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabel.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        panelP.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 800, 680));

        btnUbah.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(95, 95, 95));
        btnUbah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbah.setText("UBAH");
        btnUbah.setPreferredSize(new java.awt.Dimension(104, 36));
        btnUbah.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUbahMouseMoved(evt);
            }
        });
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahMouseExited(evt);
            }
        });
        panelP.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 30, 120, 40));

        btnEkspor.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnEkspor.setForeground(new java.awt.Color(95, 95, 95));
        btnEkspor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEkspor.setText("EKSPOR");
        btnEkspor.setPreferredSize(new java.awt.Dimension(104, 36));
        btnEkspor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEksporMouseMoved(evt);
            }
        });
        btnEkspor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEksporMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEksporMouseExited(evt);
            }
        });
        panelP.add(btnEkspor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 30, 120, 40));

        btnCari.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnCari.setForeground(new java.awt.Color(95, 95, 95));
        btnCari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCari.setText("CARI");
        btnCari.setPreferredSize(new java.awt.Dimension(104, 36));
        btnCari.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCariMouseMoved(evt);
            }
        });
        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCariMouseExited(evt);
            }
        });
        panelP.add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 890, 148, 40));

        btnHapus.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(95, 95, 95));
        btnHapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus.setText("HAPUS");
        btnHapus.setPreferredSize(new java.awt.Dimension(104, 36));
        btnHapus.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnHapusMouseMoved(evt);
            }
        });
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHapusMouseExited(evt);
            }
        });
        panelP.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 860, 175, 50));

        btnEdit.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(95, 95, 95));
        btnEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEdit.setText("PERBARUI");
        btnEdit.setPreferredSize(new java.awt.Dimension(104, 36));
        btnEdit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEditMouseMoved(evt);
            }
        });
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });
        panelP.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 860, 170, 50));

        btnTambah.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(95, 95, 95));
        btnTambah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTambah.setText("TAMBAH");
        btnTambah.setPreferredSize(new java.awt.Dimension(104, 36));
        btnTambah.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTambahMouseMoved(evt);
            }
        });
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahMouseExited(evt);
            }
        });
        panelP.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 860, 166, 50));

        bgP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Pengaturan.png"))); // NOI18N
        panelP.add(bgP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        add(panelP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        panelD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUbahD.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnUbahD.setForeground(new java.awt.Color(95, 95, 95));
        btnUbahD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbahD.setText("BROWSE");
        btnUbahD.setPreferredSize(new java.awt.Dimension(104, 36));
        panelD.add(btnUbahD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 297, 200, 40));

        bgP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Database.png"))); // NOI18N
        panelD.add(bgP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        add(panelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int baris = tabel.rowAtPoint(evt.getPoint());
        String idText = tabel.getValueAt(baris, 1).toString();
        txtidkeanggotaan.setText(idText);
        txtidkeanggotaan.disable();

        if (tabel.getValueAt(baris, 2)==null){
            txtnamakeanggotaan.setText("");
        } else {
            txtnamakeanggotaan.setText(tabel.getValueAt(baris, 2).toString());
        }
        if (tabel.getValueAt(baris, 4)==null){
            txtnotelp.setText("");
        } else {
            txtnotelp.setText(tabel.getValueAt(baris, 4).toString());
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void txtcarisupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcarisupplierActionPerformed
    try {
            String sqls = "SELECT * FROM supplier WHERE id_supplier LIKE '%"+txtcarisupplier.getText()+
                    "%' OR nama_supplier LIKE '%"+txtcarisupplier.getText()+"%' OR alamat LIKE '%"+txtcarisupplier.getText()+
                    "%' OR no_telp LIKE '"+txtcarisupplier.getText()+
                    "' OR keterangan LIKE '%"+txtcarisupplier.getText()+"%' ORDER BY id_supplier";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
        }
        tabel.setModel(model);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_txtcarisupplierActionPerformed

    private void btnTambahMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseMoved
        btnTambah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTambahMouseMoved

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        String tanggal = ((JTextField)tglst.getDateEditor().getUiComponent()).getText();
        try {
            String sql3 = "INSERT INTO user VALUES ('"+txtidkeanggotaan.getText()+"','"+txtnamakeanggotaan.getText()+
            "','"+txtpassword.getText()+"','"+hakaksescb.getSelectedItem()+"',"+tanggal+","+txtnotelp.getText()+","+txtidktp.getText()+")";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
            model.setRowCount(0);
            model.setColumnCount(0);
            load_tabel();
            lebar_tabel();
            kosongkan();
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseExited
        btnTambah.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTambahMouseExited

    private void btnEditMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseMoved
        btnEdit.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEditMouseMoved

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        String tanggal = ((JTextField)tglst.getDateEditor().getUiComponent()).getText();
        try {
            String sql = "UPDATE user SET nama_karyawan = '"+txtnamakeanggotaan.getText()+"', telepon = "
                         +txtnotelp.getText()+", user_parameter = '"+hakaksescb.getSelectedItem()+"' WHERE idkaryawan = '" + txtidkeanggotaan.getText()+"'";
            String sql2 = "SELECT idkaryawan, telepon, tgl_lahir, idktp FROM user";
            String sql3 = "UPDATE user SET password = '"+txtpassword.getText()+"' WHERE idkaryawan = '" + txtidkeanggotaan.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
            java.sql.PreparedStatement pst3 = conn.prepareStatement(sql3);
            pst.execute();
            java.sql.ResultSet rs = pst.executeQuery(sql2);
            while (rs.next()){
            if (txtidkeanggotaan.getText().equals(rs.getString("idkaryawan"))&& txtnotelp.getText().equals(rs.getString("telepon"))&& txtidktp.getText().equals(rs.getString("idktp"))){
//                && tglst.getDate().equals(rs.getString("tgl_lahir"))
                pst3.execute();
                JOptionPane.showMessageDialog(null,"Data Berhasil di Perbarui\nPassword Berhasil Diubah!");
                } else {
                }
            }
            JOptionPane.showMessageDialog(null,"Password Gagal Diubah!\nHarap cek kembali semua data yang dimasukkan");
            DefaultTableModel model = (DefaultTableModel)tabel.getModel();
            model.setRowCount(0);
            model.setColumnCount(0);
            load_tabel();
            lebar_tabel();
        } catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal!\n"+e.getMessage());
        }
        kosongkan();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        btnEdit.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEditMouseExited

    private void btnHapusMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseMoved
        btnHapus.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnHapusMouseMoved

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        try {
            String sql = "DELETE FROM supplier WHERE id_supplier ='"+txtidkeanggotaan.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus");
            DefaultTableModel model = (DefaultTableModel)tabel.getModel();
            model.setRowCount(0);
            load_tabel();
            lebar_tabel();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        kosongkan();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseExited
        btnHapus.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnHapusMouseExited

    private void btnCariMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseMoved
        btnCari.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCariMouseMoved

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        try {
            String sqls = "SELECT * FROM supplier WHERE id_supplier LIKE '%"+txtcarisupplier.getText()+
                    "%' OR nama_supplier LIKE '%"+txtcarisupplier.getText()+"%' OR alamat LIKE '%"+txtcarisupplier.getText()+
                    "%' OR no_telp LIKE '"+txtcarisupplier.getText()+
                    "' OR keterangan LIKE '%"+txtcarisupplier.getText()+"%' ORDER BY id_supplier";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabel.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
        }
        tabel.setModel(model);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnCariMouseClicked

    private void btnCariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseExited
        btnCari.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCariMouseExited

    private void btnEksporMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporMouseMoved
        btnEkspor.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEksporMouseMoved

    private void btnEksporMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporMouseClicked
        tabel.setModel(model);
        try{
            WritableWorkbook write = Workbook.createWorkbook(new File(filename));
            WritableSheet sheet = write.createSheet("export-data",0);
            sheet.addCell(new Label(0,0,"Id Alat Musik"));
            sheet.addCell(new Label(1,0,"Nama Alat Musik"));
            sheet.addCell(new Label(2,0,"Harga Jual"));
            sheet.addCell(new Label(3,0,"Harga Beli"));
            sheet.addCell(new Label(4,0,"Stok"));
            for (int i = 0; i < model.getColumnCount(); i++) {
                Label column = new Label(i, 0, model.getColumnName(i));
                sheet.addCell(column);
            }
            int j = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                for (j = 0; j < model.getColumnCount(); j++) {
                    Label row = new Label(j, i + 1,
                        model.getValueAt(i, j).toString());
                    sheet.addCell(row);
                }
            }
            write.write();
            write.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan dalam Bentuk Excel");
        }catch(HeadlessException | IOException | WriteException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString());
        }
    }//GEN-LAST:event_btnEksporMouseClicked

    private void btnEksporMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporMouseExited
        btnEkspor.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEksporMouseExited

    private void btnUbahMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseMoved
        btnUbah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnUbahMouseMoved

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        fileChooser(); 
    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnUbahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseExited
        btnUbah.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnUbahMouseExited

    private void PengaturancbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PengaturancbActionPerformed
        if (Pengaturancb.getSelectedIndex()==0){
            model.setRowCount(0);
            model.setColumnCount(0);
            panelP.setVisible(true);
            panelD.setVisible(false);
            load_tabel();
            lebar_tabel();
        }
        if (Pengaturancb.getSelectedIndex()==1){
            panelP.setVisible(false);
            panelD.setVisible(true);
        }
    }//GEN-LAST:event_PengaturancbActionPerformed

    private void hakaksescbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hakaksescbActionPerformed
        if (hakaksescb.getSelectedIndex()==0){
            txtidkeanggotaan.setText(null);
        }
        if (hakaksescb.getSelectedIndex()==1){
            txtidkeanggotaan.disable();
            try{
                String sql = "SELECT MAX(RIGHT(idkaryawan,4)) FROM user";
                java.sql.Connection con = (Connection) Config.configDB();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rst = st.executeQuery(sql);
            if(rst.next()) {
                String auto_kdPM, tambah;
                int kdb;
                auto_kdPM = Integer.toString(rst.getInt(1)+1);
                kdb = auto_kdPM.length();
                tambah = "";
                for (int i = 1; i <= 4 - kdb; i++ ){
                    tambah = tambah + "0";
                }
                txtidkeanggotaan.setText("PM"+tambah+auto_kdPM);
                }
            }
            catch (Exception e) {
                txtidkeanggotaan.setText("PM0001");
            }
            }
        if (hakaksescb.getSelectedIndex()==2){
            txtidkeanggotaan.disable();
            try{
                String sql = "SELECT MAX(RIGHT(idkaryawan,4)) FROM user";
                java.sql.Connection con = (Connection) Config.configDB();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rst = st.executeQuery(sql);
            if(rst.next()) {
                String auto_kdPM, tambah;
                int kdb;
                auto_kdPM = Integer.toString(rst.getInt(1)+1);
                kdb = auto_kdPM.length();
                tambah = "";
                for (int i = 1; i <= 4 - kdb; i++ ){
                    tambah = tambah + "0";
                }
                txtidkeanggotaan.setText("AD"+tambah+auto_kdPM);
                }
            }
            catch (Exception e) {
                txtidkeanggotaan.setText("AD0001");
            }
        }
        if (hakaksescb.getSelectedIndex()==3){
            txtidkeanggotaan.disable();
            try{
                String sql = "SELECT MAX(RIGHT(idkaryawan,4)) FROM user";
                java.sql.Connection con = (Connection) Config.configDB();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rst = st.executeQuery(sql);
            if(rst.next()) {
                String auto_kdPM, tambah;
                int kdb;
                auto_kdPM = Integer.toString(rst.getInt(1)+1);
                kdb = auto_kdPM.length();
                tambah = "";
                for (int i = 1; i <= 4 - kdb; i++ ){
                    tambah = tambah + "0";
                }
                txtidkeanggotaan.setText("KR"+tambah+auto_kdPM);
                }
            }
            catch (Exception e) {
                txtidkeanggotaan.setText("KR0001");
            }
        }
    }//GEN-LAST:event_hakaksescbActionPerformed

    private void eyeshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeshowMouseClicked
        txtpassword.setEchoChar('•');
        eyeshow.setVisible(false);
        eyehide.setVisible(true);
    }//GEN-LAST:event_eyeshowMouseClicked

    private void eyehideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyehideMouseClicked
        txtpassword.setEchoChar((char)0);
        txtpassword.setFont(new java.awt.Font("Segoe UI Bold", 2, 18));
        eyeshow.setVisible(true);
        eyehide.setVisible(false);
    }//GEN-LAST:event_eyehideMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Pengaturancb;
    private javax.swing.JLabel bgP;
    private javax.swing.JLabel bgP1;
    private javax.swing.JLabel btnCari;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnEkspor;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btnUbah;
    private javax.swing.JLabel btnUbahD;
    private javax.swing.JLabel eyehide;
    private javax.swing.JLabel eyeshow;
    private javax.swing.JComboBox<String> hakaksescb;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelD;
    private javax.swing.JPanel panelP;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser tglst;
    private javax.swing.JTextField txtcarisupplier;
    private javax.swing.JTextField txtidkeanggotaan;
    private javax.swing.JTextField txtidktp;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtnamakeanggotaan;
    private javax.swing.JTextField txtnotelp;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
