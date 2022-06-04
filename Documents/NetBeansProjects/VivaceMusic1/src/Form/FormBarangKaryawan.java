/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

package Form;

import com.onbarcode.barcode.Code128;
import com.onbarcode.barcode.IBarcode;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;
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

public class FormBarangKaryawan extends javax.swing.JPanel {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi
    */ 
    
    String location=null;
    String tgl, filename;
    
    private void load_tabelbarang() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Alat Musik");
        model.addColumn("Nama Alat Musik");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Stok");
        
        try { 
            int no = 1;
            String sql = "SELECT * FROM alatmusik ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow (new Object[] {no++, res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
            tabelbarang.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabelbarang(){
        TableColumn kolom;
        tabelbarang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabelbarang.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(120);
        kolom = tabelbarang.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(140); 
        kolom = tabelbarang.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(820); 
        kolom = tabelbarang.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(150);
        kolom = tabelbarang.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(150);
        kolom = tabelbarang.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(120);
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
     pp
     project versi 2.0
    */ 
    
    public FormBarangKaryawan() {
        initComponents();
        load_tabelbarang();
        lebar_tabelbarang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMenu = new javax.swing.JLabel();
        txtcaribarang = new javax.swing.JTextField();
        txtlokasi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        btnUbah = new javax.swing.JLabel();
        btnEkspor = new javax.swing.JLabel();
        btnCari = new javax.swing.JLabel();
        barangcb = new javax.swing.JComboBox<>();
        teksbarang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        txtMenu.setText("Barang");
        txtMenu.setAlignmentY(0.0F);
        add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 400, 45));

        txtcaribarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcaribarang.setBorder(null);
        txtcaribarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaribarangActionPerformed(evt);
            }
        });
        add(txtcaribarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 890, 1300, 40));

        txtlokasi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtlokasi.setBorder(null);
        txtlokasi.setOpaque(false);
        add(txtlokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 530, 40));

        tabelbarang.setBackground(new java.awt.Color(244, 239, 224));
        tabelbarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabelbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelbarang.setGridColor(new java.awt.Color(199, 199, 199));
        tabelbarang.setRowHeight(18);
        tabelbarang.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabelbarang.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabelbarang);

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
        add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1261, 30, 119, 40));

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

        barangcb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barangcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Barang", "Nama Barang", "Harga Beli Terendah", "Harga Beli Tertinggi", "Harga Jual Terendah", "Harga Jual Tertinggi", "Stok Terendah", "Stok Tertinggi" }));
        barangcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barangcbActionPerformed(evt);
            }
        });
        add(barangcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 117, 200, -1));

        teksbarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        teksbarang.setText("Urut Berdasarkan :");
        add(teksbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Barang Karyawan.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void txtcaribarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaribarangActionPerformed
        try {
            String sqls = "SELECT * FROM alatmusik WHERE idalatmusik LIKE '%"+txtcaribarang.getText()+
            "%' OR namaalatmusik LIKE '%"+txtcaribarang.getText()+"%' OR harga_jual LIKE '"+txtcaribarang.getText()+"'"
            + " OR harga_beli LIKE '"+txtcaribarang.getText()+
            "' OR stok LIKE '"+txtcaribarang.getText()+"' ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
        }
        tabelbarang.setModel(model);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_txtcaribarangActionPerformed

    private void btnCariMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseMoved
    btnCari.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCariMouseMoved

    private void btnCariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseExited
    btnCari.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCariMouseExited

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        try {
            String sqls = "SELECT * FROM alatmusik WHERE idalatmusik LIKE '%"+txtcaribarang.getText()+
            "%' OR namaalatmusik LIKE '%"+txtcaribarang.getText()+"%' OR harga_jual LIKE '"+txtcaribarang.getText()+"'"
            + " OR harga_beli LIKE '"+txtcaribarang.getText()+
            "' OR stok LIKE '"+txtcaribarang.getText()+"' ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
        }
        tabelbarang.setModel(model);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnCariMouseClicked

    private void btnEksporMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporMouseMoved
    btnEkspor.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEksporMouseMoved

    private void btnEksporMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporMouseExited
    btnEkspor.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEksporMouseExited

    private void btnEksporMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporMouseClicked
        if (txtlokasi.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Gagal di Export ke Excel!\nHarap Pilih lokasi penyimpanan file Excel ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
        DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
        tabelbarang.setModel(model);
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

    private void btnUbahMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseMoved
    btnUbah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnUbahMouseMoved

    private void btnUbahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseExited
    btnUbah.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnUbahMouseExited

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
    fileChooser();
    }//GEN-LAST:event_btnUbahMouseClicked

    private void barangcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barangcbActionPerformed
    if (barangcb.getSelectedIndex()==0){
            try {
            String sqls = "SELECT * FROM alatmusik ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
            }
            tabelbarang.setModel(model);
            } catch (SQLException ex) {
            }
        } else if (barangcb.getSelectedIndex()==1){
            try {
            String sqls = "SELECT * FROM alatmusik ORDER BY namaalatmusik";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
            }
            tabelbarang.setModel(model);
            } catch (SQLException ex) {
            }
        } else if (barangcb.getSelectedIndex()==2){
            try {
            String sqls = "SELECT * FROM alatmusik ORDER BY harga_beli ASC";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
            }
            tabelbarang.setModel(model);
            } catch (SQLException ex) {
            }
        } else if (barangcb.getSelectedIndex()==3){
            try {
            String sqls = "SELECT * FROM alatmusik ORDER BY harga_beli DESC";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
            }
            tabelbarang.setModel(model);
            } catch (SQLException ex) {
            }
        } else if (barangcb.getSelectedIndex()==4){
            try {
            String sqls = "SELECT * FROM alatmusik ORDER BY harga_jual ASC";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
            }
            tabelbarang.setModel(model);
            } catch (SQLException ex) {
            }
        } else if (barangcb.getSelectedIndex()==5){
            try {
            String sqls = "SELECT * FROM alatmusik ORDER BY harga_jual DESC";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
            }
            tabelbarang.setModel(model);
            } catch (SQLException ex) {
            }
        } else if (barangcb.getSelectedIndex()==6){
            try {
            String sqls = "SELECT * FROM alatmusik ORDER BY stok ASC";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
            }
            tabelbarang.setModel(model);
            } catch (SQLException ex) {
            }
        } else if (barangcb.getSelectedIndex()==7){
            try {
            String sqls = "SELECT * FROM alatmusik ORDER BY stok DESC";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
            }
            tabelbarang.setModel(model);
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_barangcbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox<String> barangcb;
    private javax.swing.JLabel btnCari;
    private javax.swing.JLabel btnEkspor;
    private javax.swing.JLabel btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelbarang;
    protected javax.swing.JLabel teksbarang;
    private javax.swing.JLabel txtMenu;
    private javax.swing.JTextField txtcaribarang;
    private javax.swing.JTextField txtlokasi;
    // End of variables declaration//GEN-END:variables
}
