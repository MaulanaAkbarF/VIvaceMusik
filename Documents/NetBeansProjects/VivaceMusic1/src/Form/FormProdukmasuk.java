/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

package Form;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FormProdukmasuk extends javax.swing.JPanel {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi
    */ 
    
    // Tabel model
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    
    
    private void load_tabelsp() {
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
        tabel.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabelsp(){
        TableColumn kolom;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabel.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(40);
        kolom = tabel.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(100); 
        kolom = tabel.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(230); 
        kolom = tabel.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(150);
        kolom = tabel.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(120);
        kolom = tabel.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(250);
    }
    
    private void load_tabelbr() {
        model.addColumn("No");
        model.addColumn("ID Alat Musik");
        model.addColumn("Nama Alat Musik");
        model.addColumn("Harga Beli");
        model.addColumn("Stok");
        
        try { 
            int no = 1;
            String sql = "SELECT idalatmusik, namaalatmusik, harga_beli, stok FROM alatmusik ORDER BY idalatmusik";
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
    
    private void lebar_tabelbr(){
        TableColumn kolom;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabel.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(60);
        kolom = tabel.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(150); 
        kolom = tabel.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(380); 
        kolom = tabel.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(200);
        kolom = tabel.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(100);
    }
    
    private void load_tabelkeranjang(){

        model2.addColumn("ID Produk Masuk");
        model2.addColumn("ID Alat Musik ");
        model2.addColumn("Nama Alat Musik");
        model2.addColumn("Harga Beli");
        model2.addColumn("Stok Masuk");
        model2.addColumn("Harga Total");
        model2.addColumn("Tanggal");

        daftar.setModel(model2);
       }
    
    private void lebar_tabelkeranjang(){
        TableColumn kolom;
        daftar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
       
        kolom = daftar.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(120);
        kolom = daftar.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(120);
        kolom = daftar.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(200);
        kolom = daftar.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(120);
        kolom = daftar.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(90);
        kolom = daftar.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(120);
        kolom = daftar.getColumnModel().getColumn(6); 
        kolom.setPreferredWidth(120);
    }
    
    private void hidebtn(){
        txtnamabarang.setVisible(false);
        txthargabeli.setVisible(false);
        txtidsupplier.setVisible(false);
        txtstok.setVisible(false);
        spON.setVisible(false);
        brON.setVisible(false);
        namaspON.setVisible(false);
    }
    
    private void kosongkan(){
        txtidbarang.setText(null);
        txtjumlah.setText(null);
        txthargatotal.setText(null);
        txtpembayaran.setText(null);
        txtkembalian.setText(null);
    }
    
    private void auto_kdPM() {
        txtidprodukmasuk.disable();
        try{
        String sql = "SELECT MAX(RIGHT(id_produkmasuk,8)) FROM produkmasuk";
        java.sql.Connection con = (Connection) Config.configDB();
        java.sql.Statement st = con.createStatement();
        java.sql.ResultSet rst = st.executeQuery(sql);
        if(rst.next()) {
            String auto_kdPM, tambah;
            int kdb;
            auto_kdPM = Integer.toString(rst.getInt(1)+1);
            kdb = auto_kdPM.length();
            tambah = "";
            for (int i = 1; i <= 8 - kdb; i++ ){
                tambah = tambah + "0";
            }
            txtidprodukmasuk.setText("PM"+tambah+auto_kdPM);
            
         }
        }
        catch (Exception e) {
            txtidprodukmasuk.setText("PM00000001");
        }
    }
    
    private void tambahtotalkeranjang(){
        int hasil = 0 ;
        for(int i = 0; i < model2.getRowCount();i++){
            String hht = model2.getValueAt(i, 5).toString();
            if("".equals(hht)){
                hht = "0";
            }
            int ht1 = Integer.parseInt(hht);
             hasil +=  ht1;
        }
        txthargatotal.setText(String.valueOf(hasil));
    }
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 

    public FormProdukmasuk() {
        initComponents();
        hidebtn();
        auto_kdPM();
        load_tabelsp();
        lebar_tabelsp();
        load_tabelkeranjang();
        lebar_tabelkeranjang();
        spON.setText("on");
        brON.setText("off");
        namaspON.setText("off");
        spdot.setVisible(true);
        brdot.setVisible(false);
        btnCarisp.setVisible(true);
        txtcarisupplier.setVisible(true);
        btnCaribr.setVisible(false);
        txtcaribarang.setVisible(false);
        txtnamasupplier.setEnabled(false);
        btnHapussp.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMenu = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        btnHitung = new javax.swing.JLabel();
        btnCetak = new javax.swing.JLabel();
        btnTambahkan = new javax.swing.JLabel();
        btnTambahsp = new javax.swing.JLabel();
        btnHapussp = new javax.swing.JLabel();
        btnCarisp = new javax.swing.JLabel();
        btnCaribr = new javax.swing.JLabel();
        btnBarang = new javax.swing.JLabel();
        btnSupplier = new javax.swing.JLabel();
        brdot = new javax.swing.JLabel();
        spdot = new javax.swing.JLabel();
        txtcaribarang = new javax.swing.JTextField();
        txtcarisupplier = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        txtpembayaran = new javax.swing.JTextField();
        txthargatotal = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        txtidbarang = new javax.swing.JTextField();
        txtnamasupplier = new javax.swing.JTextField();
        txtidprodukmasuk = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        daftar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtidsupplier = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txthargabeli = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        brON = new javax.swing.JTextField();
        spON = new javax.swing.JTextField();
        namaspON = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        txtMenu.setText("Produk Masuk");
        txtMenu.setAlignmentY(0.0F);
        add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 400, 45));

        btnReset.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnReset.setForeground(new java.awt.Color(95, 95, 95));
        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReset.setText("RESET");
        btnReset.setPreferredSize(new java.awt.Dimension(104, 36));
        btnReset.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnResetMouseMoved(evt);
            }
        });
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnResetMouseExited(evt);
            }
        });
        add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1272, 422, 235, 38));

        btnHitung.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnHitung.setForeground(new java.awt.Color(95, 95, 95));
        btnHitung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHitung.setText("HITUNG");
        btnHitung.setPreferredSize(new java.awt.Dimension(104, 36));
        btnHitung.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnHitungMouseMoved(evt);
            }
        });
        btnHitung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHitungMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHitungMouseExited(evt);
            }
        });
        add(btnHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(984, 903, 235, 38));

        btnCetak.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnCetak.setForeground(new java.awt.Color(95, 95, 95));
        btnCetak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCetak.setText("CETAK FAKTUR");
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
        add(btnCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1272, 903, 235, 38));

        btnTambahkan.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnTambahkan.setForeground(new java.awt.Color(95, 95, 95));
        btnTambahkan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTambahkan.setText("TAMBAHKAN");
        btnTambahkan.setPreferredSize(new java.awt.Dimension(104, 36));
        btnTambahkan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTambahkanMouseMoved(evt);
            }
        });
        btnTambahkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahkanMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahkanMouseExited(evt);
            }
        });
        add(btnTambahkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(985, 422, 235, 38));

        btnTambahsp.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnTambahsp.setForeground(new java.awt.Color(95, 95, 95));
        btnTambahsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTambahsp.setText("TAMBAH");
        btnTambahsp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTambahsp.setPreferredSize(new java.awt.Dimension(104, 36));
        btnTambahsp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTambahspMouseMoved(evt);
            }
        });
        btnTambahsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahspMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahspMouseExited(evt);
            }
        });
        add(btnTambahsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 34, 154, 30));

        btnHapussp.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnHapussp.setForeground(new java.awt.Color(95, 95, 95));
        btnHapussp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapussp.setText("HAPUS");
        btnHapussp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHapussp.setPreferredSize(new java.awt.Dimension(104, 36));
        btnHapussp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnHapusspMouseMoved(evt);
            }
        });
        btnHapussp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusspMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHapusspMouseExited(evt);
            }
        });
        add(btnHapussp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 34, 154, 30));

        btnCarisp.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnCarisp.setForeground(new java.awt.Color(95, 95, 95));
        btnCarisp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCarisp.setText("CARI");
        btnCarisp.setPreferredSize(new java.awt.Dimension(104, 36));
        btnCarisp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCarispMouseMoved(evt);
            }
        });
        btnCarisp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCarispMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCarispMouseExited(evt);
            }
        });
        add(btnCarisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 90, 40));

        btnCaribr.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnCaribr.setForeground(new java.awt.Color(95, 95, 95));
        btnCaribr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCaribr.setText("CARI");
        btnCaribr.setPreferredSize(new java.awt.Dimension(104, 36));
        btnCaribr.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCaribrMouseMoved(evt);
            }
        });
        btnCaribr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCaribrMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCaribrMouseExited(evt);
            }
        });
        add(btnCaribr, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 90, 40));

        btnBarang.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnBarang.setForeground(new java.awt.Color(95, 95, 95));
        btnBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBarang.setText("BARANG");
        btnBarang.setPreferredSize(new java.awt.Dimension(104, 36));
        btnBarang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBarangMouseMoved(evt);
            }
        });
        btnBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBarangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBarangMouseExited(evt);
            }
        });
        add(btnBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 160, 40));

        btnSupplier.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnSupplier.setForeground(new java.awt.Color(95, 95, 95));
        btnSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSupplier.setText("SUPPLIER");
        btnSupplier.setPreferredSize(new java.awt.Dimension(104, 36));
        btnSupplier.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSupplierMouseMoved(evt);
            }
        });
        btnSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupplierMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSupplierMouseExited(evt);
            }
        });
        add(btnSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 160, 40));

        brdot.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        brdot.setForeground(new java.awt.Color(95, 95, 95));
        brdot.setText("  • ");
        add(brdot, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 30, 40));

        spdot.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        spdot.setForeground(new java.awt.Color(95, 95, 95));
        spdot.setText("  • ");
        add(spdot, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 30, 40));

        txtcaribarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcaribarang.setBorder(null);
        txtcaribarang.setOpaque(false);
        txtcaribarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaribarangActionPerformed(evt);
            }
        });
        add(txtcaribarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 230, 40));

        txtcarisupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcarisupplier.setBorder(null);
        txtcarisupplier.setOpaque(false);
        txtcarisupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarisupplierActionPerformed(evt);
            }
        });
        add(txtcarisupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 230, 40));

        txtkembalian.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtkembalian.setBorder(null);
        txtkembalian.setOpaque(false);
        add(txtkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 840, 510, 40));

        txtpembayaran.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtpembayaran.setBorder(null);
        txtpembayaran.setOpaque(false);
        txtpembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpembayaranActionPerformed(evt);
            }
        });
        add(txtpembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 740, 510, 40));

        txthargatotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txthargatotal.setBorder(null);
        txthargatotal.setOpaque(false);
        add(txthargatotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 640, 510, 40));

        txtjumlah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtjumlah.setBorder(null);
        txtjumlah.setOpaque(false);
        add(txtjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, 510, 40));

        txtidbarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtidbarang.setBorder(null);
        txtidbarang.setOpaque(false);
        add(txtidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 260, 510, 40));

        txtnamasupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnamasupplier.setBorder(null);
        txtnamasupplier.setOpaque(false);
        add(txtnamasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 70, 310, 40));

        txtidprodukmasuk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtidprodukmasuk.setBorder(null);
        txtidprodukmasuk.setOpaque(false);
        add(txtidprodukmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, 200, 40));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 890, 280));

        daftar.setBackground(new java.awt.Color(244, 239, 224));
        daftar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        daftar.setModel(new javax.swing.table.DefaultTableModel(
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
        daftar.setGridColor(new java.awt.Color(199, 199, 199));
        daftar.setRowHeight(18);
        daftar.setSelectionBackground(new java.awt.Color(194, 184, 156));
        daftar.setSelectionForeground(new java.awt.Color(0, 0, 0));
        daftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daftarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(daftar);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 890, 390));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form ProdukMasuk.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        txtidsupplier.setText("jTextField1");
        add(txtidsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        txtnamabarang.setText("jTextField1");
        add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        txthargabeli.setText("jTextField1");
        add(txthargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        txtstok.setText("jTextField1");
        add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, -1, -1));

        brON.setText("jTextField1");
        add(brON, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        spON.setText("jTextField1");
        add(spON, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        add(namaspON, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSupplierMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseMoved
        btnSupplier.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSupplierMouseMoved

    private void btnSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseClicked
        model.setRowCount(0);
        model.setColumnCount(0);
        load_tabelsp();
        lebar_tabelsp();
        spON.setText("on");
        brON.setText("off");
        spdot.setVisible(true);
        brdot.setVisible(false);
        btnCarisp.setVisible(true);
        txtcarisupplier.setVisible(true);
        btnCaribr.setVisible(false);
        txtcaribarang.setVisible(false);
        txtidbarang.setText("");
    }//GEN-LAST:event_btnSupplierMouseClicked

    private void btnSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseExited
        btnSupplier.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSupplierMouseExited

    // Variabel untuk tabelMouseClicked
    public String idbr, namabr, hargabelibr;
    
    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int x = tabel.getSelectedRow();
        int baris = tabel.rowAtPoint(evt.getPoint());
        if (spON.getText().equals("on")){
            txtidsupplier.setText(tabel.getValueAt(baris, 1).toString()); 
            txtidbarang.setText("");
            if (namaspON.getText().equals("off")){
            txtnamasupplier.setText(tabel.getValueAt(baris, 2).toString());
            }
        } else if (brON.getText().equals("on")){
            txtidsupplier.setText("");
            txtidbarang.setText(tabel.getValueAt(baris, 1).toString());
            String id = model.getValueAt(x, 1).toString();
            idbr = id;
            if (namaspON.getText().equals("off")){
            txtnamasupplier.setText("");
            }
        } else {
            txtidsupplier.setText("");
            txtidbarang.setText("");
        }
        if (brON.getText().equals("on")){
            String nama = model.getValueAt(x, 2).toString();
            namabr = nama;
        }
        if (brON.getText().equals("on")){
            String harga = model.getValueAt(x, 3).toString();
            hargabelibr = harga;
        }
    }//GEN-LAST:event_tabelMouseClicked

    // Variabel untuk daftarMouseClicked
    public int mctp;
    
    private void daftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarMouseClicked
        int mct = daftar.getSelectedRow();
        mctp = mct;
    }//GEN-LAST:event_daftarMouseClicked

    private void btnBarangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBarangMouseMoved
        btnBarang.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnBarangMouseMoved

    private void btnBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBarangMouseClicked
        if (namaspON.getText().equals("on")){
            model.setRowCount(0);
            model.setColumnCount(0);
            load_tabelbr();
            lebar_tabelbr();
            spON.setText("off");
            brON.setText("on");
            spdot.setVisible(false);
            brdot.setVisible(true);
            btnCarisp.setVisible(false);
            txtcarisupplier.setVisible(false);
            btnCaribr.setVisible(true);
            txtcaribarang.setVisible(true);
        } else {
            model.setRowCount(0);
            model.setColumnCount(0);
            load_tabelbr();
            lebar_tabelbr();
            spON.setText("off");
            brON.setText("on");
            spdot.setVisible(false);
            brdot.setVisible(true);
            btnCarisp.setVisible(false);
            txtcarisupplier.setVisible(false);
            btnCaribr.setVisible(true);
            txtcaribarang.setVisible(true);
            txtnamasupplier.setText("");
        }
    }//GEN-LAST:event_btnBarangMouseClicked

    private void btnBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBarangMouseExited
        btnBarang.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnBarangMouseExited

    private void btnCarispMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarispMouseMoved
        btnCarisp.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCarispMouseMoved

    private void btnCarispMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarispMouseClicked
        try {
            String sqls = "SELECT * FROM supplier WHERE id_supplier LIKE '%"+txtcarisupplier.getText()+
            "%' OR nama_supplier LIKE '%"+txtcarisupplier.getText()+"%' OR alamat LIKE '%"+txtcarisupplier.getText()+
            "%' OR no_telp LIKE '"+txtcarisupplier.getText()+
            "' OR keterangan LIKE '%"+txtcarisupplier.getText()+"%' ORDER BY id_supplier";
            java.sql.Connection conn = (Connection)Config.configDB();
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
    }//GEN-LAST:event_btnCarispMouseClicked

    private void btnCarispMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarispMouseExited
        btnCarisp.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCarispMouseExited

    private void btnCaribrMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaribrMouseMoved
        btnCaribr.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCaribrMouseMoved

    private void btnCaribrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaribrMouseClicked
        try {
            String sqls = "SELECT * FROM alatmusik WHERE idalatmusik LIKE '%"+txtcaribarang.getText()+
            "%' OR namaalatmusik LIKE '%"+txtcaribarang.getText()+"%' OR harga_jual LIKE '"+txtcaribarang.getText()+"' OR harga_beli LIKE '"+txtcaribarang.getText()+
            "' OR stok LIKE '"+txtcaribarang.getText()+"' ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection)Config.configDB();
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
    }//GEN-LAST:event_btnCaribrMouseClicked

    private void btnCaribrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaribrMouseExited
        btnCaribr.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCaribrMouseExited

    private void txtcarisupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcarisupplierActionPerformed
        try {
            String sqls = "SELECT * FROM supplier WHERE id_supplier LIKE '%"+txtcarisupplier.getText()+
            "%' OR nama_supplier LIKE '%"+txtcarisupplier.getText()+"%' OR alamat LIKE '%"+txtcarisupplier.getText()+
            "%' OR no_telp LIKE '"+txtcarisupplier.getText()+
            "' OR keterangan LIKE '%"+txtcarisupplier.getText()+"%' ORDER BY id_supplier";
            java.sql.Connection conn = (Connection)Config.configDB();
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

    private void txtcaribarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaribarangActionPerformed
        try {
            String sqls = "SELECT * FROM alatmusik WHERE idalatmusik LIKE '%"+txtcaribarang.getText()+
            "%' OR namaalatmusik LIKE '%"+txtcaribarang.getText()+"%' OR harga_jual LIKE '"+txtcaribarang.getText()+"' OR harga_beli LIKE '"+txtcaribarang.getText()+
            "' OR stok LIKE '"+txtcaribarang.getText()+"' ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection)Config.configDB();
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
    }//GEN-LAST:event_txtcaribarangActionPerformed

    private void btnTambahspMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahspMouseMoved
        btnTambahsp.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTambahspMouseMoved

    private void btnTambahspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahspMouseClicked
        try {        
        String sql1 = "INSERT INTO produkmasuk VALUES('"+txtidprodukmasuk.getText()+"','"+txtidsupplier.getText()+"', CURRENT_TIMESTAMP)";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        pst1.execute();
        JOptionPane.showMessageDialog(null,"Data Supplier dan Produk Masuk Berhasil Ditambahkan");
        txtjumlah.setText(null);
        namaspON.setText("on");
        btnHapussp.setVisible(true);
        btnTambahsp.setVisible(false);
        txthargatotal.setText(null);
        txtpembayaran.setText(null);
        txtkembalian.setText(null);
        
    } catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_btnTambahspMouseClicked

    private void btnTambahspMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahspMouseExited
        btnTambahsp.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTambahspMouseExited

    private void btnTambahkanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahkanMouseMoved
        btnTambahkan.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTambahkanMouseMoved

    private void btnTambahkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahkanMouseClicked
        if (namaspON.getText().equals("on")){
            String jumlah = txtjumlah.getText();
            int jumlah1 = Integer.parseInt(jumlah);
            int harga1 = Integer.parseInt(hargabelibr);
            int total = jumlah1 * harga1;
        
            txthargabeli.setText(String.valueOf(total));
        
            Date date = new Date();
            DateFormat formattanggal = new SimpleDateFormat("yyyy-MM-dd");
            String sekarang = formattanggal.format(date);
            model2.addRow (new Object[] {txtidprodukmasuk.getText(), idbr, namabr, hargabelibr, jumlah, total, sekarang});

            tambahtotalkeranjang();
            txtjumlah.setText(null);
        } else {
            JOptionPane.showMessageDialog(null,"Tidak dapat menambahkan barang!\nTambahkan supplier terlebih dahulu");
        }
    }//GEN-LAST:event_btnTambahkanMouseClicked

    private void btnTambahkanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahkanMouseExited
        btnTambahkan.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTambahkanMouseExited

    private void btnResetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseMoved
        btnReset.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnResetMouseMoved

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        model2.setRowCount(0);
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseExited
        btnReset.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnResetMouseExited

    private void btnHitungMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitungMouseMoved
        btnHitung.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnHitungMouseMoved

    private void btnHitungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitungMouseClicked
        Date date = new Date();
        DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
        String sekarang = formattanggal.format(date);

        int bayar = Integer.parseInt(txtpembayaran.getText());
        int totalharga = Integer.parseInt(txthargatotal.getText());

        int kembalian = totalharga - bayar;
        if(bayar>=totalharga){
            txtkembalian.setText(String.valueOf(Math.abs(kembalian)));
            JOptionPane.showMessageDialog(this, "Pembayaran Berhasil");
            try{
                for(int i = 0; i < model2.getRowCount(); i++){
                    String sql = "INSERT INTO detail_produkmasuk VALUE('"+model2.getValueAt(i, 0)+"',"
                    + " '"+model2.getValueAt(i, 1)+"', '"+model2.getValueAt(i, 3)+"', "
                    + "'"+model2.getValueAt(i, 4)+"', '"+model2.getValueAt(i, 5)+"', '"+model2.getValueAt(i, 6)+"')";
                    Connection con = (Connection)Config.configDB();
                    java.sql.PreparedStatement pst = con.prepareStatement(sql);
                    pst.execute();
                    namaspON.setText("off");
                    kosongkan();
                    auto_kdPM();
                    if (namaspON.getText().equals("off")){
                    txtnamasupplier.setText("");
                    }
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null,"Pembayaran Gagal!\nUang yang di bayarkan kurang sebesar RP."+kembalian);
        }
    }//GEN-LAST:event_btnHitungMouseClicked

    private void btnHitungMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitungMouseExited
        btnHitung.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnHitungMouseExited

    private void btnCetakMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseMoved
        btnCetak.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCetakMouseMoved

    private void btnCetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakMouseClicked

    private void btnCetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseExited
        btnCetak.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCetakMouseExited

    private void txtpembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpembayaranActionPerformed
        Date date = new Date();
        DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
        String sekarang = formattanggal.format(date);

        int bayar = Integer.parseInt(txtpembayaran.getText());
        int totalharga = Integer.parseInt(txthargatotal.getText());

        int kembalian = totalharga - bayar;
        if(bayar>=totalharga){
            txtkembalian.setText(String.valueOf(Math.abs(kembalian)));
            JOptionPane.showMessageDialog(this, "Pembayaran Berhasil");
            try{
                for(int i = 0; i < model2.getRowCount(); i++){
                    String sql = "INSERT INTO detail_produkmasuk VALUE('"+model2.getValueAt(i, 0)+"',"
                    + " '"+model2.getValueAt(i, 1)+"', '"+model2.getValueAt(i, 3)+"', "
                    + "'"+model2.getValueAt(i, 4)+"', '"+model2.getValueAt(i, 5)+"', '"+model2.getValueAt(i, 6)+"')";
                    Connection con = (Connection)Config.configDB();
                    java.sql.PreparedStatement pst = con.prepareStatement(sql);
                    pst.execute();
                    namaspON.setText("off");
                    txtnamasupplier.setText(null);
//                    kosongkan();
                    auto_kdPM();
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null,"Pembayaran Gagal!\nUang yang di bayarkan kurang sebesar RP."+kembalian);
        }
    }//GEN-LAST:event_txtpembayaranActionPerformed

    private void btnHapusspMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusspMouseMoved
        btnHapussp.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnHapusspMouseMoved

    private void btnHapusspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusspMouseClicked
        try {
            String sql = "DELETE FROM produkmasuk WHERE id_produkmasuk = '"+txtidprodukmasuk.getText()+"'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst1 = conn.prepareStatement(sql);
            pst1.execute();
            JOptionPane.showMessageDialog(null,"Data Supplier dan Produk Masuk Berhasil Dihapus"
            
            );
            spON.setText("on");
            txtnamasupplier.setText(null);
            txtnamasupplier.setEnabled(true);
            btnTambahsp.setVisible(true);
            btnHapussp.setVisible(false);
            txthargatotal.setText(null);
            txtpembayaran.setText(null);
            txtkembalian.setText(null);
            model2.setRowCount(0);

        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnHapusspMouseClicked

    private void btnHapusspMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusspMouseExited
        btnHapussp.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnHapusspMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brON;
    private javax.swing.JLabel brdot;
    private javax.swing.JLabel btnBarang;
    private javax.swing.JLabel btnCaribr;
    private javax.swing.JLabel btnCarisp;
    private javax.swing.JLabel btnCetak;
    private javax.swing.JLabel btnHapussp;
    private javax.swing.JLabel btnHitung;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSupplier;
    private javax.swing.JLabel btnTambahkan;
    private javax.swing.JLabel btnTambahsp;
    private javax.swing.JTable daftar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namaspON;
    private javax.swing.JTextField spON;
    private javax.swing.JLabel spdot;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel txtMenu;
    private javax.swing.JTextField txtcaribarang;
    private javax.swing.JTextField txtcarisupplier;
    private javax.swing.JTextField txthargabeli;
    private javax.swing.JTextField txthargatotal;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtidprodukmasuk;
    private javax.swing.JTextField txtidsupplier;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnamasupplier;
    private javax.swing.JTextField txtpembayaran;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
