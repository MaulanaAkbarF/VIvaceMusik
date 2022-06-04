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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FormSupplierKaryawan extends javax.swing.JPanel {
    
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
        kolom.setPreferredWidth(60);
        kolom = tabelsupplier.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(80); 
        kolom = tabelsupplier.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(440); 
        kolom = tabelsupplier.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(240);
        kolom = tabelsupplier.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(150);
        kolom = tabelsupplier.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(530);
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
                JOptionPane.showMessageDialog(null, "Perintah tidak valid/dibatalkan.","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 
    
    public FormSupplierKaryawan() {
        initComponents();
        load_tabelsupplier();
        lebar_tabelsupplier();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMenu = new javax.swing.JLabel();
        txtcarisupplier = new javax.swing.JTextField();
        txtlokasi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelsupplier = new javax.swing.JTable();
        btnUbah = new javax.swing.JLabel();
        btnEkspor = new javax.swing.JLabel();
        btnCari = new javax.swing.JLabel();
        suppliercb = new javax.swing.JComboBox<>();
        tekssupplier = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        txtMenu.setText("Supplier");
        txtMenu.setAlignmentY(0.0F);
        add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 400, 45));

        txtcarisupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcarisupplier.setBorder(null);
        txtcarisupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarisupplierActionPerformed(evt);
            }
        });
        add(txtcarisupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 890, 1300, 40));

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
        jScrollPane1.setViewportView(tabelsupplier);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 1500, 680));

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
        add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 890, 148, 40));

        suppliercb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        suppliercb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "Keterangan" }));
        suppliercb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliercbActionPerformed(evt);
            }
        });
        add(suppliercb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 117, 200, -1));

        tekssupplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tekssupplier.setText("Urut Berdasarkan :");
        add(tekssupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Supplier Karyawan.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
    }// </editor-fold>//GEN-END:initComponents

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
        if (txtlokasi.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Gagal di Export ke Excel!\nHarap Pilih lokasi penyimpanan file Excel ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
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
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan dalam Bentuk Excel","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
        }catch(HeadlessException | IOException | WriteException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
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

    private void suppliercbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliercbActionPerformed
        if (suppliercb.getSelectedIndex()==0){
            try {
            String sqls = "SELECT * FROM supplier ORDER BY id_supplier";
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
        } else if (suppliercb.getSelectedIndex()==1){
            try {
            String sqls = "SELECT * FROM supplier ORDER BY nama_supplier";
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
        } else if (suppliercb.getSelectedIndex()==2){
            try {
            String sqls = "SELECT * FROM supplier ORDER BY alamat";
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
        } else if (suppliercb.getSelectedIndex()==3){
            try {
            String sqls = "SELECT * FROM supplier ORDER BY keterangan";
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
        }
    }//GEN-LAST:event_suppliercbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCari;
    private javax.swing.JLabel btnEkspor;
    private javax.swing.JLabel btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JComboBox<String> suppliercb;
    private javax.swing.JTable tabelsupplier;
    protected javax.swing.JLabel tekssupplier;
    private javax.swing.JLabel txtMenu;
    private javax.swing.JTextField txtcarisupplier;
    private javax.swing.JTextField txtlokasi;
    // End of variables declaration//GEN-END:variables
}
