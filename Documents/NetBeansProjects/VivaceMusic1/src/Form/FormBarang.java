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
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class FormBarang extends javax.swing.JPanel {
    
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
        kolom.setPreferredWidth(60);
        kolom = tabelbarang.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(120); 
        kolom = tabelbarang.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(340); 
        kolom = tabelbarang.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(100);
        kolom = tabelbarang.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(100);
        kolom = tabelbarang.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(80);
    }
    
    private void Auto_kodebarang(){
        try{
            String sql = "SELECT MAX(right(idalatmusik,8)) from alatmusik";
            Connection conn = (Connection) Config.configDB();
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sql);
            if(rst.next()){
                String auto_kode,tambah;int kdb;
                auto_kode = Integer.toString(rst.getInt(1)+1);
                kdb = auto_kode.length();
                tambah = "";
                for (int i = 1; i <= 8 - kdb; i++ ){
                    tambah = tambah + "0";
                }
                txtidbarang.setText("AM"+tambah+auto_kode);
            }
            
        }catch(Exception e){
            txtidbarang.setText("AM00000001");
        }
    }
    
    public void kosongkan(){
        Auto_kodebarang();
        txtnamabarang.setText(null);
        txthargabeli.setText(null);
        txthargajual.setText(null);
        txtstok.setText(null);
        
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
    
    
    //fungsi membuat barcode
      private void generate(String kode) throws Exception{
   
       Code128 barcode = new Code128();
       barcode.setData(kode);
       barcode.setUom(IBarcode.UOM_PIXEL);
       barcode.setX(3f);
       barcode.setY(75f);
       
       barcode.setLeftMargin(0f);
       barcode.setRightMargin(0f);
       barcode.setTopMargin(0f);
       barcode.setBottomMargin(0f);
       
       barcode.setResolution(72);
       barcode.setShowText(true);
       barcode.setTextFont(new Font("Arial", 0, 12));
       
       barcode.setTextMargin(6);
       barcode.setRotate(IBarcode.ROTATE_0);
       
       barcode.drawBarcode("src" + "/" + "img" + "/barcode/" + kode + ".gif" );
         
    }
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 
    
    public FormBarang() {
        initComponents();
        Auto_kodebarang();
        load_tabelbarang();
        lebar_tabelbarang();
        txtidbarang.disable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMenu = new javax.swing.JLabel();
        txtidbarang = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txthargabeli = new javax.swing.JTextField();
        txthargajual = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        txtcaribarang = new javax.swing.JTextField();
        txtlokasi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        btnUbah = new javax.swing.JLabel();
        btnEkspor = new javax.swing.JLabel();
        btnCari = new javax.swing.JLabel();
        btnCetak = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        barcodebaca = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        txtMenu.setText("Barang");
        txtMenu.setAlignmentY(0.0F);
        add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 400, 45));

        txtidbarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtidbarang.setBorder(null);
        txtidbarang.setOpaque(false);
        add(txtidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 590, 40));

        txtnamabarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnamabarang.setBorder(null);
        txtnamabarang.setOpaque(false);
        add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 590, 40));

        txthargabeli.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txthargabeli.setBorder(null);
        txthargabeli.setOpaque(false);
        add(txthargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 590, 40));

        txthargajual.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txthargajual.setBorder(null);
        txthargajual.setOpaque(false);
        add(txthargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 590, 40));

        txtstok.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtstok.setBorder(null);
        txtstok.setOpaque(false);
        add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 590, 40));

        txtcaribarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcaribarang.setBorder(null);
        txtcaribarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaribarangActionPerformed(evt);
            }
        });
        add(txtcaribarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 890, 600, 40));

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
        tabelbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbarang);

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
        add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 890, 148, 40));

        btnCetak.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnCetak.setForeground(new java.awt.Color(95, 95, 95));
        btnCetak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCetak.setText("CETAK");
        btnCetak.setPreferredSize(new java.awt.Dimension(104, 36));
        btnCetak.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCetakMouseMoved(evt);
            }
        });
        btnCetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCetakMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCetakMouseExited(evt);
            }
        });
        add(btnCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 860, 128, 50));

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
        add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 860, 130, 50));

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
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 860, 125, 50));

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
        add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 860, 120, 50));
        add(barcodebaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 720, 470, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Barang.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void tabelbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseClicked
        int baris = tabelbarang.rowAtPoint(evt.getPoint());
        String idText = tabelbarang.getValueAt(baris, 1).toString();
        txtidbarang.setText(idText);
        txtidbarang.disable();

        if (tabelbarang.getValueAt(baris, 2)==null){
            txtnamabarang.setText("");
        } else {
            txtnamabarang.setText(tabelbarang.getValueAt(baris, 2).toString());
        }
        if (tabelbarang.getValueAt(baris, 3)==null){
            txthargabeli.setText("");
        } else {
            txthargabeli.setText(tabelbarang.getValueAt(baris, 3).toString());
        }
        if (tabelbarang.getValueAt(baris, 4)==null){
            txthargajual.setText("");
        } else {
            txthargajual.setText(tabelbarang.getValueAt(baris, 4).toString());
        }
        if (tabelbarang.getValueAt(baris, 5)==null){
            txtstok.setText("");
        } else {
            txtstok.setText(tabelbarang.getValueAt(baris, 5).toString());
              ImageIcon imgThisImg = new ImageIcon("src" + "/" + "img" + "/barcode/" + txtidbarang.getText() + ".gif" );
            barcodebaca.setIcon(imgThisImg);
        }
    }//GEN-LAST:event_tabelbarangMouseClicked

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

    private void btnTambahMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseMoved
    btnTambah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTambahMouseMoved

    private void btnTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseExited
    btnTambah.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTambahMouseExited

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
    String kb = String.valueOf(txtidbarang.getText());
        try {
            String sql3 = "INSERT INTO alatmusik VALUES ('"+txtidbarang.getText()+"','"+txtnamabarang.getText()+
            "',"+txthargabeli.getText()+","+txthargajual.getText()+","+txtstok.getText()+")";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            
            load_tabelbarang();
            lebar_tabelbarang();
            kosongkan();
             generate(kb);
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(FormBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnEditMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseMoved
    btnEdit.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEditMouseMoved

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
    btnEdit.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEditMouseExited

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
    try {
            String sql = "UPDATE alatmusik "+"SET namaalatmusik = '"+txtnamabarang.getText()+"',"
            + " harga_beli = '"+txthargabeli.getText()
            +"', harga_jual = '"+txthargajual.getText()
            +"', stok = '"+txtstok.getText()+"'"+
            " WHERE idalatmusik = '"+txtidbarang.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil di Perbarui");
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            load_tabelbarang();
            lebar_tabelbarang();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal!\n"+e.getMessage());
        }
        kosongkan();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnHapusMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseMoved
    btnHapus.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnHapusMouseMoved

    private void btnHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseExited
    btnHapus.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnHapusMouseExited

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
    try {
            String sql = "DELETE FROM alatmusik WHERE idalatmusik ='"+txtidbarang.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus");
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            load_tabelbarang();
            lebar_tabelbarang();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        kosongkan();
        Auto_kodebarang();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnCetakMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseMoved
    btnCetak.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCetakMouseMoved

    private void btnCetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseExited
    btnCetak.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCetakMouseExited

    private void btnCetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakMouseClicked

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
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan dalam Bentuk Excel");
        }catch(HeadlessException | IOException | WriteException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString());
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcodebaca;
    private javax.swing.JLabel btnCari;
    private javax.swing.JLabel btnCetak;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnEkspor;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelbarang;
    private javax.swing.JLabel txtMenu;
    private javax.swing.JTextField txtcaribarang;
    private javax.swing.JTextField txthargabeli;
    private javax.swing.JTextField txthargajual;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
