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
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FormSupplier extends javax.swing.JPanel {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi
    */ 
    
    String location=null;
    String tgl, filename;
    DefaultTableModel model = new DefaultTableModel();
    
    private void load_tabelsupplier() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Supplier");
        model.addColumn("Nama Supplier");
        model.addColumn("Alamat");
        model.addColumn("No. Telepon");
        model.addColumn("Keterangan");
        
        try { 
            int no = 1;
            String sql = "SELECT * FROM supplier ORDER BY id_supplier";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow (new Object[] {no++, res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
        tabelsupplier.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabelsupplier(){
        TableColumn kolom;
        tabelsupplier.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabelsupplier.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(40);
        kolom = tabelsupplier.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(70); 
        kolom = tabelsupplier.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(200); 
        kolom = tabelsupplier.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(140);
        kolom = tabelsupplier.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(130);
        kolom = tabelsupplier.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(220);
    }
    
    private void Auto_kodebarang(){
        try{
        String sql = "SELECT MAX(RIGHT(id_supplier,3)) FROM supplier";
        java.sql.Connection con = (Connection) Config.configDB();
        java.sql.Statement st = con.createStatement();
        java.sql.ResultSet rst = st.executeQuery(sql);
        if(rst.next()) {
            String auto_kdPM, tambah;
            int kdb;
            auto_kdPM = Integer.toString(rst.getInt(1)+1);
            kdb = auto_kdPM.length();
            tambah = "";
            for (int i = 1; i <= 3 - kdb; i++ ){
                tambah = tambah + "0";
            }
            txtidsupplier.setText("SUP"+tambah+auto_kdPM);
            
         }
        }
        catch (Exception e) {
            txtidsupplier.setText("SUP001");
        }
    }
    
    public void kosongkan(){
        Auto_kodebarang();
        txtnamasupplier.setText(null);
        txtalamat.setText(null);
        txtnotelp.setText(null);
        txtketerangan.setText(null);
        
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
    
    public FormSupplier() {
        initComponents();
        Auto_kodebarang();
        load_tabelsupplier();
        lebar_tabelsupplier();
        txtidsupplier.disable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMenu = new javax.swing.JLabel();
        txtidsupplier = new javax.swing.JTextField();
        txtnamasupplier = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txtnotelp = new javax.swing.JTextField();
        txtketerangan = new javax.swing.JTextField();
        txtcarisupplier = new javax.swing.JTextField();
        txtlokasi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelsupplier = new javax.swing.JTable();
        btnUbah = new javax.swing.JLabel();
        btnEkspor = new javax.swing.JLabel();
        btnCari = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        txtMenu.setText("Supplier");
        txtMenu.setAlignmentY(0.0F);
        add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 400, 45));

        txtidsupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtidsupplier.setBorder(null);
        txtidsupplier.setOpaque(false);
        add(txtidsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 590, 40));

        txtnamasupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnamasupplier.setBorder(null);
        txtnamasupplier.setOpaque(false);
        add(txtnamasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 590, 40));

        txtalamat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtalamat.setBorder(null);
        txtalamat.setOpaque(false);
        add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 590, 40));

        txtnotelp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnotelp.setBorder(null);
        txtnotelp.setOpaque(false);
        add(txtnotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 590, 40));

        txtketerangan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtketerangan.setBorder(null);
        txtketerangan.setOpaque(false);
        add(txtketerangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 590, 40));

        txtcarisupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcarisupplier.setBorder(null);
        txtcarisupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarisupplierActionPerformed(evt);
            }
        });
        add(txtcarisupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 890, 600, 40));

        txtlokasi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtlokasi.setBorder(null);
        txtlokasi.setOpaque(false);
        add(txtlokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 530, 40));

        tabelsupplier.setBackground(new java.awt.Color(244, 239, 224));
        tabelsupplier.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabelsupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelsupplier.setGridColor(new java.awt.Color(199, 199, 199));
        tabelsupplier.setRowHeight(18);
        tabelsupplier.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabelsupplier.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelsupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelsupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelsupplier);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 800, 680));

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
        add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 30, 120, 40));

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
        add(btnEkspor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 30, 120, 40));

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
        add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 890, 148, 40));

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
        add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 860, 175, 50));

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
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 860, 170, 50));

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
        add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 860, 166, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Supplier.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void tabelsupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelsupplierMouseClicked
        int baris = tabelsupplier.rowAtPoint(evt.getPoint());
        String idText = tabelsupplier.getValueAt(baris, 1).toString();
        txtidsupplier.setText(idText);
        txtidsupplier.disable();

        if (tabelsupplier.getValueAt(baris, 2)==null){
            txtnamasupplier.setText("");
        } else {
            txtnamasupplier.setText(tabelsupplier.getValueAt(baris, 2).toString());
        }
        if (tabelsupplier.getValueAt(baris, 3)==null){
            txtalamat.setText("");
        } else {
            txtalamat.setText(tabelsupplier.getValueAt(baris, 3).toString());
        }
        if (tabelsupplier.getValueAt(baris, 4)==null){
            txtnotelp.setText("");
        } else {
            txtnotelp.setText(tabelsupplier.getValueAt(baris, 4).toString());
        }
        if (tabelsupplier.getValueAt(baris, 5)==null){
            txtketerangan.setText("");
        } else {
            txtketerangan.setText(tabelsupplier.getValueAt(baris, 5).toString());
        }
    }//GEN-LAST:event_tabelsupplierMouseClicked

    private void txtcarisupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcarisupplierActionPerformed
    try {
            String sqls = "SELECT * FROM supplier WHERE id_supplier LIKE '%"+txtcarisupplier.getText()+
                    "%' OR nama_supplier LIKE '%"+txtcarisupplier.getText()+"%' OR alamat LIKE '%"+txtcarisupplier.getText()+
                    "%' OR no_telp LIKE '"+txtcarisupplier.getText()+
                    "' OR keterangan LIKE '%"+txtcarisupplier.getText()+"%' ORDER BY id_supplier";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelsupplier.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
        }
        tabelsupplier.setModel(model);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_txtcarisupplierActionPerformed

    private void btnTambahMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseMoved
        btnTambah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTambahMouseMoved

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        try {
            String sql3 = "INSERT INTO supplier VALUES ('"+txtidsupplier.getText()+"','"+txtnamasupplier.getText()+
            "','"+txtalamat.getText()+"',"+txtnotelp.getText()+",'"+txtketerangan.getText()+"')";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
            DefaultTableModel model = (DefaultTableModel)tabelsupplier.getModel();
            model.setRowCount(0);
            load_tabelsupplier();
            lebar_tabelsupplier();
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
        try {
            String sql = "UPDATE supplier "+"SET nama_supplier = '"+txtnamasupplier.getText()
            +"', alamat = '" +txtalamat.getText() + "', no_telp = "+txtnotelp.getText()+", keterangan = '"+txtketerangan.getText()
            +"' WHERE id_supplier = '"+txtidsupplier.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil di Perbarui");
            DefaultTableModel model = (DefaultTableModel)tabelsupplier.getModel();
            model.setRowCount(0);
            load_tabelsupplier();
            lebar_tabelsupplier();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal!\n"+e.getMessage());
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
            String sql = "DELETE FROM supplier WHERE id_supplier ='"+txtidsupplier.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus");
            DefaultTableModel model = (DefaultTableModel)tabelsupplier.getModel();
            model.setRowCount(0);
            load_tabelsupplier();
            lebar_tabelsupplier();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        kosongkan();
        Auto_kodebarang();
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
            DefaultTableModel model = (DefaultTableModel)tabelsupplier.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
        }
        tabelsupplier.setModel(model);
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
        tabelsupplier.setModel(model);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCari;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnEkspor;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelsupplier;
    private javax.swing.JLabel txtMenu;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcarisupplier;
    private javax.swing.JTextField txtidsupplier;
    private javax.swing.JTextField txtketerangan;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtnamasupplier;
    private javax.swing.JTextField txtnotelp;
    // End of variables declaration//GEN-END:variables
}
