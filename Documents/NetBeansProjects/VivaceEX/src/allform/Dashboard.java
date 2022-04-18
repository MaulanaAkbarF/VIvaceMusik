package allform;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Dashboard extends javax.swing.JFrame {
    
    private void dashboardshow(){
        dashboardbtn.setBackground(new java.awt.Color(194,184,156));
        dashboardmenu.setForeground(new java.awt.Color(0,0,0));
        barangbtn.setBackground(new java.awt.Color(244, 239, 224));
        barangmenu.setForeground(new java.awt.Color(153,153,153));
        barangbtn.setBackground(new java.awt.Color(244, 239, 224));
        barangmenu.setForeground(new java.awt.Color(153,153,153));
        transaksibtn.setBackground(new java.awt.Color(244, 239, 224));
        transaksimenu.setForeground(new java.awt.Color(153,153,153));
        supplierbtn.setBackground(new java.awt.Color(244, 239, 224));
        suppliermenu.setForeground(new java.awt.Color(153,153,153));
        laporanbtn.setBackground(new java.awt.Color(244, 239, 224));
        laporanmenu.setForeground(new java.awt.Color(153,153,153));
        pengaturanbtn.setBackground(new java.awt.Color(244, 239, 224));
        pengaturanmenu.setForeground(new java.awt.Color(153,153,153));
        keluarbtn.setBackground(new java.awt.Color(244, 239, 224));
        keluarmenu.setForeground(new java.awt.Color(153,153,153));
    }
    
    private void barangshow(){
        dashboardbtn.setBackground(new java.awt.Color(244, 239, 224));
        dashboardmenu.setForeground(new java.awt.Color(153,153,153));
        barangbtn.setBackground(new java.awt.Color(194,184,156));
        barangmenu.setForeground(new java.awt.Color(0,0,0));
        transaksibtn.setBackground(new java.awt.Color(244, 239, 224));
        transaksimenu.setForeground(new java.awt.Color(153,153,153));
        supplierbtn.setBackground(new java.awt.Color(244, 239, 224));
        suppliermenu.setForeground(new java.awt.Color(153,153,153));
        laporanbtn.setBackground(new java.awt.Color(244, 239, 224));
        laporanmenu.setForeground(new java.awt.Color(153,153,153));
        pengaturanbtn.setBackground(new java.awt.Color(244, 239, 224));
        pengaturanmenu.setForeground(new java.awt.Color(153,153,153));
        keluarbtn.setBackground(new java.awt.Color(244, 239, 224));
        keluarmenu.setForeground(new java.awt.Color(153,153,153));
    }
    
    private void transaksishow(){
        dashboardbtn.setBackground(new java.awt.Color(244, 239, 224));
        dashboardmenu.setForeground(new java.awt.Color(153,153,153));
        barangbtn.setBackground(new java.awt.Color(244, 239, 224));
        barangmenu.setForeground(new java.awt.Color(153,153,153));
        transaksibtn.setBackground(new java.awt.Color(194,184,156));
        transaksimenu.setForeground(new java.awt.Color(0,0,0));
        supplierbtn.setBackground(new java.awt.Color(244, 239, 224));
        suppliermenu.setForeground(new java.awt.Color(153,153,153));
        laporanbtn.setBackground(new java.awt.Color(244, 239, 224));
        laporanmenu.setForeground(new java.awt.Color(153,153,153));
        pengaturanbtn.setBackground(new java.awt.Color(244, 239, 224));
        pengaturanmenu.setForeground(new java.awt.Color(153,153,153));
        keluarbtn.setBackground(new java.awt.Color(244, 239, 224));
        keluarmenu.setForeground(new java.awt.Color(153,153,153));
    }
    
    private void suppliershow(){
        dashboardbtn.setBackground(new java.awt.Color(244, 239, 224));
        dashboardmenu.setForeground(new java.awt.Color(153,153,153));
        barangbtn.setBackground(new java.awt.Color(244, 239, 224));
        barangmenu.setForeground(new java.awt.Color(153,153,153));
        transaksibtn.setBackground(new java.awt.Color(244, 239, 224));
        transaksimenu.setForeground(new java.awt.Color(153,153,153));
        supplierbtn.setBackground(new java.awt.Color(194,184,156));
        suppliermenu.setForeground(new java.awt.Color(0,0,0));
        laporanbtn.setBackground(new java.awt.Color(244, 239, 224));
        laporanmenu.setForeground(new java.awt.Color(153,153,153));
        pengaturanbtn.setBackground(new java.awt.Color(244, 239, 224));
        pengaturanmenu.setForeground(new java.awt.Color(153,153,153));
        keluarbtn.setBackground(new java.awt.Color(244, 239, 224));
        keluarmenu.setForeground(new java.awt.Color(153,153,153));
    }
    
    private void laporanshow(){
        dashboardbtn.setBackground(new java.awt.Color(244, 239, 224));
        dashboardmenu.setForeground(new java.awt.Color(153,153,153));
        barangbtn.setBackground(new java.awt.Color(244, 239, 224));
        barangmenu.setForeground(new java.awt.Color(153,153,153));
        transaksibtn.setBackground(new java.awt.Color(244, 239, 224));
        transaksimenu.setForeground(new java.awt.Color(153,153,153));
        supplierbtn.setBackground(new java.awt.Color(244, 239, 224));
        suppliermenu.setForeground(new java.awt.Color(153,153,153));
        laporanbtn.setBackground(new java.awt.Color(194,184,156));
        laporanmenu.setForeground(new java.awt.Color(0,0,0));
        pengaturanbtn.setBackground(new java.awt.Color(244, 239, 224));
        pengaturanmenu.setForeground(new java.awt.Color(153,153,153));
        keluarbtn.setBackground(new java.awt.Color(244, 239, 224));
        keluarmenu.setForeground(new java.awt.Color(153,153,153));
    }
    
    private void pengaturanshow(){
        dashboardbtn.setBackground(new java.awt.Color(244, 239, 224));
        dashboardmenu.setForeground(new java.awt.Color(153,153,153));
        barangbtn.setBackground(new java.awt.Color(244, 239, 224));
        barangmenu.setForeground(new java.awt.Color(153,153,153));
        transaksibtn.setBackground(new java.awt.Color(244, 239, 224));
        transaksimenu.setForeground(new java.awt.Color(153,153,153));
        supplierbtn.setBackground(new java.awt.Color(244, 239, 224));
        suppliermenu.setForeground(new java.awt.Color(153,153,153));
        laporanbtn.setBackground(new java.awt.Color(244, 239, 224));
        laporanmenu.setForeground(new java.awt.Color(153,153,153));
        pengaturanbtn.setBackground(new java.awt.Color(194,184,156));
        pengaturanmenu.setForeground(new java.awt.Color(0,0,0));
        keluarbtn.setBackground(new java.awt.Color(244, 239, 224));
        keluarmenu.setForeground(new java.awt.Color(153,153,153));
    }
    
    private void keluarshow(){
        dashboardbtn.setBackground(new java.awt.Color(244, 239, 224));
        dashboardmenu.setForeground(new java.awt.Color(153,153,153));
        barangbtn.setBackground(new java.awt.Color(244, 239, 224));
        barangmenu.setForeground(new java.awt.Color(153,153,153));
        transaksibtn.setBackground(new java.awt.Color(244, 239, 224));
        transaksimenu.setForeground(new java.awt.Color(153,153,153));
        supplierbtn.setBackground(new java.awt.Color(244, 239, 224));
        suppliermenu.setForeground(new java.awt.Color(153,153,153));
        laporanbtn.setBackground(new java.awt.Color(244, 239, 224));
        laporanmenu.setForeground(new java.awt.Color(153,153,153));
        pengaturanbtn.setBackground(new java.awt.Color(244, 239, 224));
        pengaturanmenu.setForeground(new java.awt.Color(153,153,153));
        keluarbtn.setBackground(new java.awt.Color(194,184,156));
        keluarmenu.setForeground(new java.awt.Color(0,0,0));
    }
    
    private void kosong(){
        idbarangfield.setText(null);
        namabarangfield.setText(null);
        hargabelifield.setText(null);
        hargajualfield.setText(null);
        stokfield.setText(null);
        carifield.setText(null);
        idbarangfield.enable();
    }
    
    private void kosongsp(){
        idsupplierfield.setText(null);
        namasupplierfield.setText(null);
        alamatsupplierfield.setText(null);
        notelpsupplierfield.setText(null);
        keterangansupplierfield.setText(null);
        carisupplierfield.setText(null);
        idsupplierfield.enable();
    }
    
    private void kosongst(){
        idkaryawanstfield.setText(null);
        namakaryawanstfield.setText(null);
        passwordstfield.setText(null);
        notelpstfield.setText(null);
    }
    
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
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow (new Object[] {no++, res.getString(1),
                    res.getString(2), "Rp. "+res.getString(3), "Rp. "+res.getString(4), res.getString(5)});
            }
        tabelbarang.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabelbarang(){
        TableColumn kolom;
        tabelbarang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabelbarang.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(40);
        kolom = tabelbarang.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(100); 
        kolom = tabelbarang.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(300); 
        kolom = tabelbarang.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(120);
        kolom = tabelbarang.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(120);
        kolom = tabelbarang.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(100);
    }
    
    private void load_tabelbarangtr() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Alat Musik");
        model.addColumn("Nama Alat Musik");
        model.addColumn("Harga");
        model.addColumn("Stok");
        
        try { 
            int no = 1;
            String sql = "SELECT idalatmusik, namaalatmusik, harga_jual, stok FROM alatmusik ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow (new Object[] {no++, res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4)});
            }
        tabelbarangtr.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabelbarangtr(){
        TableColumn kolom;
        tabelbarangtr.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabelbarangtr.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(30);
        kolom = tabelbarangtr.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(100); 
        kolom = tabelbarangtr.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(300); 
        kolom = tabelbarangtr.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(120);
        kolom = tabelbarangtr.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(120);
    }
    
    private void load_tabelkeranjang() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("ID Alat Musik");
        model.addColumn("Nama Alat Musik");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");
        model.addColumn("Tanggal");
        
        try { 
            int no = 1;
//            String sql1 = "SELECT idpembeli FROM pembeli ORDER BY idpembeli";
            String sql2 = "SELECT idtransaksi, idalatmusik, namaalatmusik, harga, qty, totalbayar, tanggal FROM transaksi ORDER BY idtransaksi";
            java.sql.Connection conn = (Connection)Config.configDB();
//            java.sql.Statement stm1 = conn.createStatement();
            java.sql.Statement stm2 = conn.createStatement();
//            java.sql.ResultSet res1 = stm1.executeQuery(sql1);
            java.sql.ResultSet res2 = stm2.executeQuery(sql2);
//            while (res1.next()){
//                model.addRow (new Object[] {no++, res1.getString(1)});
//            }
            while (res2.next()){
                model.addRow (new Object[] {no++, res2.getString(1), res2.getString(2), res2.getString(3), res2.getString(4),
                    res2.getString(5), res2.getString(6), res2.getString(7)});
            }
        tabelkeranjang.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabelkeranjang(){
        TableColumn kolom;
        tabelkeranjang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabelkeranjang.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(30);
        kolom = tabelkeranjang.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(50);
        kolom = tabelkeranjang.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(50);
        kolom = tabelkeranjang.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(50);
        kolom = tabelkeranjang.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(150);
        kolom = tabelkeranjang.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(100);
        kolom = tabelkeranjang.getColumnModel().getColumn(6); 
        kolom.setPreferredWidth(100);
        kolom = tabelkeranjang.getColumnModel().getColumn(7); 
        kolom.setPreferredWidth(50);
    }
    
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
        kolom.setPreferredWidth(100); 
        kolom = tabelsupplier.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(150); 
        kolom = tabelsupplier.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(100);
        kolom = tabelsupplier.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(100);
        kolom = tabelsupplier.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(270);
    }
    
    private void load_tabelsetting() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Karyawan");
        model.addColumn("Nama Karyawan");
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
        tabelsetting.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabelsetting(){    
        TableColumn kolom;
        tabelsetting.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabelsetting.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(40);
        kolom = tabelsetting.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(100); 
        kolom = tabelsetting.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(250); 
        kolom = tabelsetting.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(120);
        kolom = tabelsetting.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(250);
    }
    
    private void TampilkanJumlah() {
        try {
 
        String sql = "SELECT SUM(totalbayar) AS total FROM transaksi WHERE tanggal=CURDATE()";      
        java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
        String data = rs.getString("total");
             if(data == null){
                angkapenjualan1hr.setText("Rp. 0");   
            }else{
                angkapenjualan1hr.setText("Rp. "+data );   
            }                                        
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       }
    
    private void TampilkanOrang() {
        try {
 
            String sql = "SELECT COUNT(idpembeli) AS total FROM transaksi WHERE tanggal=CURDATE()";      
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            
        while(rs.next()){
            String data = rs.getString("total");
             if(data == null){
                angkatotalpembelian.setText("0 Orang");   
            }else{
                angkatotalpembelian.setText(data+" Orang" );   
            }                                        
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        }
        
    private void TampilkanStok() {
        try {
 
            String sql = "SELECT SUM(stok) AS total FROM alatmusik";      
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
            String data = rs.getString("total");
            if(data == null){
                angkastok.setText("0");   
            }else{
                angkastok.setText(data);   
            }                                        
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        }       
                
    private void TampilkanStokMasuk() {
        try {
 
        String sql = "SELECT SUM(stok_total) AS total FROM produkmasuk WHERE tgl_pembelian=CURDATE()";      
        java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
        String data = rs.getString("total");
             if(data == null){
                angkajumlah.setText("0");   
            }else{
                angkajumlah.setText(data);   
            }                                        
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    
    public Dashboard() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        DASHBOARD.setVisible(true);
        BARANG.setVisible(false);
        TRANSAKSI.setVisible(false);
        SUPPLIER.setVisible(false);
        LAPORANTOTAL.setVisible(false);
        LAPORANSELECT1.setVisible(false);
        LAPORANSELECT2.setVisible(false);
        SETTING.setVisible(false);
        laporanselectcb.setVisible(false);
        
//        auto_id kelas = new auto_id();
        
        TampilkanJumlah();
        TampilkanOrang();
        TampilkanStok();
        TampilkanStokMasuk();
//        kelas.autoidbarang();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VivaceIcon = new javax.swing.JLabel();
        usermenu = new javax.swing.JLabel();
        dashboardmenu = new javax.swing.JLabel();
        barangmenu = new javax.swing.JLabel();
        transaksimenu = new javax.swing.JLabel();
        suppliermenu = new javax.swing.JLabel();
        laporanmenu = new javax.swing.JLabel();
        pengaturanmenu = new javax.swing.JLabel();
        keluarmenu = new javax.swing.JLabel();
        laporanselectcb = new javax.swing.JComboBox<>();
        dashboardbtn = new javax.swing.JPanel();
        barangbtn = new javax.swing.JPanel();
        transaksibtn = new javax.swing.JPanel();
        supplierbtn = new javax.swing.JPanel();
        laporanbtn = new javax.swing.JPanel();
        pengaturanbtn = new javax.swing.JPanel();
        keluarbtn = new javax.swing.JPanel();
        LAPORANSELECT1 = new javax.swing.JPanel();
        laporanpic1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        bgLaporanselect = new javax.swing.JLabel();
        LAPORANTOTAL = new javax.swing.JPanel();
        laporanpic = new javax.swing.JLabel();
        angkapenjualan1thn = new javax.swing.JLabel();
        textpenjualan1thn = new javax.swing.JLabel();
        angkabrterjual = new javax.swing.JLabel();
        textbrterjual = new javax.swing.JLabel();
        angkapembelian1thn = new javax.swing.JLabel();
        textpembelian1thn = new javax.swing.JLabel();
        angkadibeli = new javax.swing.JLabel();
        textdibeli = new javax.swing.JLabel();
        textgrafikthn = new javax.swing.JLabel();
        bgLaporantotal = new javax.swing.JLabel();
        SETTING = new javax.swing.JPanel();
        HSDBFORM = new javax.swing.JLabel();
        idkaryawanstfield = new javax.swing.JTextField();
        namakaryawanstfield = new javax.swing.JTextField();
        passwordstfield = new javax.swing.JPasswordField();
        notelpstfield = new javax.swing.JTextField();
        carisettingfield = new javax.swing.JTextField();
        hapusstbtn = new javax.swing.JPanel();
        updatestbtn = new javax.swing.JPanel();
        tambahkanstbtn = new javax.swing.JPanel();
        exportstbtn = new javax.swing.JPanel();
        caristbtn = new javax.swing.JPanel();
        eyehide = new javax.swing.JLabel();
        eyeshow = new javax.swing.JLabel();
        tglst = new com.toedter.calendar.JDateChooser();
        hakaksescb = new javax.swing.JComboBox<>();
        jPane2 = new javax.swing.JScrollPane();
        tabelsetting = new javax.swing.JTable();
        hapusdatabarangbtn = new javax.swing.JPanel();
        hapusdatasupplierbtn = new javax.swing.JPanel();
        hapusdatalaporanpjbtn = new javax.swing.JPanel();
        hapusdatalaporansmbtn = new javax.swing.JPanel();
        settingpic = new javax.swing.JLabel();
        bgSetting = new javax.swing.JLabel();
        LAPORANSELECT2 = new javax.swing.JPanel();
        laporanpic2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        bgLaporanselect2 = new javax.swing.JLabel();
        SUPPLIER = new javax.swing.JPanel();
        supplierpic = new javax.swing.JLabel();
        idsupplierfield = new javax.swing.JTextField();
        namasupplierfield = new javax.swing.JTextField();
        alamatsupplierfield = new javax.swing.JTextField();
        notelpsupplierfield = new javax.swing.JTextField();
        keterangansupplierfield = new javax.swing.JTextField();
        carisupplierfield = new javax.swing.JTextField();
        hapusspbtn = new javax.swing.JPanel();
        updatespbtn = new javax.swing.JPanel();
        tambahkanspbtn = new javax.swing.JPanel();
        exportspbtn = new javax.swing.JPanel();
        carispbtn = new javax.swing.JPanel();
        jPane1 = new javax.swing.JScrollPane();
        tabelsupplier = new javax.swing.JTable();
        bgSupplier = new javax.swing.JLabel();
        TRANSAKSI = new javax.swing.JPanel();
        transaksipic = new javax.swing.JLabel();
        hargatrfield = new javax.swing.JTextField();
        jumlahtrfield = new javax.swing.JTextField();
        namapembelitrfield = new javax.swing.JTextField();
        tambahkantrbtn = new javax.swing.JPanel();
        totalhargatrfield = new javax.swing.JTextField();
        bayartrfield = new javax.swing.JTextField();
        kembaliantrfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarangtr = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelkeranjang = new javax.swing.JTable();
        idpembelitrfield = new javax.swing.JTextField();
        idtransaksitrfield = new javax.swing.JTextField();
        bgTransaksi = new javax.swing.JLabel();
        idbarangtrfield = new javax.swing.JTextField();
        namabarangtrfield = new javax.swing.JTextField();
        totalbelanjafield = new javax.swing.JTextField();
        BARANG = new javax.swing.JPanel();
        barangpic = new javax.swing.JLabel();
        idbarangfield = new javax.swing.JTextField();
        namabarangfield = new javax.swing.JTextField();
        hargajualfield = new javax.swing.JTextField();
        hargabelifield = new javax.swing.JTextField();
        stokfield = new javax.swing.JTextField();
        carifield = new javax.swing.JTextField();
        tambahkanbrbtn = new javax.swing.JPanel();
        updatebrbtn = new javax.swing.JPanel();
        hapusbrbtn = new javax.swing.JPanel();
        caribrbtn = new javax.swing.JPanel();
        exportbrbtn = new javax.swing.JPanel();
        jPane = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        bgBarang = new javax.swing.JLabel();
        DASHBOARD = new javax.swing.JPanel();
        dashboardpic = new javax.swing.JLabel();
        angkapenjualan1hr = new javax.swing.JLabel();
        textpenjualan1hr = new javax.swing.JLabel();
        angkastok = new javax.swing.JLabel();
        textstok = new javax.swing.JLabel();
        angkatotalpembelian = new javax.swing.JLabel();
        texttotalpembelian = new javax.swing.JLabel();
        angkajumlah = new javax.swing.JLabel();
        textjumlah = new javax.swing.JLabel();
        textgrafik = new javax.swing.JLabel();
        bgDashboard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VivaceIcon.setBackground(new java.awt.Color(255, 255, 255));
        VivaceIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/VIVACEMUSIC 1.png"))); // NOI18N
        getContentPane().add(VivaceIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 170, 140));

        usermenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        usermenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/usericon.png"))); // NOI18N
        usermenu.setText("   HAI, KARYAWAN!");
        getContentPane().add(usermenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, -1));

        dashboardmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        dashboardmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/homeicon.png"))); // NOI18N
        dashboardmenu.setText("     DASHBOARD");
        dashboardmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardmenuMouseClicked(evt);
            }
        });
        getContentPane().add(dashboardmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 260, 60));

        barangmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        barangmenu.setForeground(new java.awt.Color(153, 153, 153));
        barangmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/barangicon.png"))); // NOI18N
        barangmenu.setText("     BARANG");
        barangmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barangmenuMouseClicked(evt);
            }
        });
        getContentPane().add(barangmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 260, 60));

        transaksimenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        transaksimenu.setForeground(new java.awt.Color(153, 153, 153));
        transaksimenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/creditcard.png"))); // NOI18N
        transaksimenu.setText("     TRANSAKSI");
        transaksimenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaksimenuMouseClicked(evt);
            }
        });
        getContentPane().add(transaksimenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 260, 60));

        suppliermenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        suppliermenu.setForeground(new java.awt.Color(153, 153, 153));
        suppliermenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/suppliericon.icon.png"))); // NOI18N
        suppliermenu.setText("     SUPPLIER");
        suppliermenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppliermenuMouseClicked(evt);
            }
        });
        getContentPane().add(suppliermenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 260, 60));

        laporanmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        laporanmenu.setForeground(new java.awt.Color(153, 153, 153));
        laporanmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/laporanicon.png"))); // NOI18N
        laporanmenu.setText("     LAPORAN");
        laporanmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laporanmenuMouseClicked(evt);
            }
        });
        getContentPane().add(laporanmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 260, 60));

        pengaturanmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        pengaturanmenu.setForeground(new java.awt.Color(153, 153, 153));
        pengaturanmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settingicon.png"))); // NOI18N
        pengaturanmenu.setText("     PENGATURAN");
        pengaturanmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pengaturanmenuMouseClicked(evt);
            }
        });
        getContentPane().add(pengaturanmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 260, 60));

        keluarmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        keluarmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logouticon.png"))); // NOI18N
        keluarmenu.setText("     KELUAR");
        keluarmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarmenuMouseClicked(evt);
            }
        });
        getContentPane().add(keluarmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 930, 210, 40));

        laporanselectcb.setBackground(new java.awt.Color(244, 239, 224));
        laporanselectcb.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        laporanselectcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laporan Total", "Laporan Penjualan", "Laporan Stok Masuk" }));
        laporanselectcb.setBorder(null);
        laporanselectcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanselectcbActionPerformed(evt);
            }
        });
        getContentPane().add(laporanselectcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 350, 50));

        dashboardbtn.setBackground(new java.awt.Color(194, 184, 156));

        javax.swing.GroupLayout dashboardbtnLayout = new javax.swing.GroupLayout(dashboardbtn);
        dashboardbtn.setLayout(dashboardbtnLayout);
        dashboardbtnLayout.setHorizontalGroup(
            dashboardbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        dashboardbtnLayout.setVerticalGroup(
            dashboardbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(dashboardbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 300, 60));

        barangbtn.setBackground(new java.awt.Color(244, 239, 224));
        barangbtn.setFocusTraversalPolicyProvider(true);

        javax.swing.GroupLayout barangbtnLayout = new javax.swing.GroupLayout(barangbtn);
        barangbtn.setLayout(barangbtnLayout);
        barangbtnLayout.setHorizontalGroup(
            barangbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        barangbtnLayout.setVerticalGroup(
            barangbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(barangbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        transaksibtn.setBackground(new java.awt.Color(244, 239, 224));

        javax.swing.GroupLayout transaksibtnLayout = new javax.swing.GroupLayout(transaksibtn);
        transaksibtn.setLayout(transaksibtnLayout);
        transaksibtnLayout.setHorizontalGroup(
            transaksibtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        transaksibtnLayout.setVerticalGroup(
            transaksibtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(transaksibtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

        supplierbtn.setBackground(new java.awt.Color(244, 239, 224));

        javax.swing.GroupLayout supplierbtnLayout = new javax.swing.GroupLayout(supplierbtn);
        supplierbtn.setLayout(supplierbtnLayout);
        supplierbtnLayout.setHorizontalGroup(
            supplierbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        supplierbtnLayout.setVerticalGroup(
            supplierbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(supplierbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, -1, -1));

        laporanbtn.setBackground(new java.awt.Color(244, 239, 224));

        javax.swing.GroupLayout laporanbtnLayout = new javax.swing.GroupLayout(laporanbtn);
        laporanbtn.setLayout(laporanbtnLayout);
        laporanbtnLayout.setHorizontalGroup(
            laporanbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        laporanbtnLayout.setVerticalGroup(
            laporanbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(laporanbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, -1, -1));

        pengaturanbtn.setBackground(new java.awt.Color(244, 239, 224));

        javax.swing.GroupLayout pengaturanbtnLayout = new javax.swing.GroupLayout(pengaturanbtn);
        pengaturanbtn.setLayout(pengaturanbtnLayout);
        pengaturanbtnLayout.setHorizontalGroup(
            pengaturanbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        pengaturanbtnLayout.setVerticalGroup(
            pengaturanbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(pengaturanbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, -1, -1));

        keluarbtn.setBackground(new java.awt.Color(244, 239, 224));
        keluarbtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                keluarbtnMouseMoved(evt);
            }
        });
        keluarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keluarbtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout keluarbtnLayout = new javax.swing.GroupLayout(keluarbtn);
        keluarbtn.setLayout(keluarbtnLayout);
        keluarbtnLayout.setHorizontalGroup(
            keluarbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        keluarbtnLayout.setVerticalGroup(
            keluarbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(keluarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 920, -1, -1));

        LAPORANSELECT1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        laporanpic1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        laporanpic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/laporanpic.png"))); // NOI18N
        LAPORANSELECT1.add(laporanpic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable4.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jTable4);

        LAPORANSELECT1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 1490, 630));

        bgLaporanselect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LS1.png"))); // NOI18N
        LAPORANSELECT1.add(bgLaporanselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        getContentPane().add(LAPORANSELECT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LAPORANTOTAL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        laporanpic.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        laporanpic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/laporanpic.png"))); // NOI18N
        LAPORANTOTAL.add(laporanpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

        angkapenjualan1thn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapenjualan1thn.setText("Rp.0,0");
        LAPORANTOTAL.add(angkapenjualan1thn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 410, 50));

        textpenjualan1thn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpenjualan1thn.setForeground(new java.awt.Color(130, 130, 130));
        textpenjualan1thn.setText("Penjualan Selama Satu Tahun");
        LAPORANTOTAL.add(textpenjualan1thn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 260, -1));

        angkabrterjual.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkabrterjual.setText("0");
        LAPORANTOTAL.add(angkabrterjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 250, 410, 50));

        textbrterjual.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textbrterjual.setForeground(new java.awt.Color(130, 130, 130));
        textbrterjual.setText("Jumlah Barang Terjual");
        LAPORANTOTAL.add(textbrterjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 300, 260, -1));

        angkapembelian1thn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapembelian1thn.setText("Rp. 0,0");
        LAPORANTOTAL.add(angkapembelian1thn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 410, 50));

        textpembelian1thn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpembelian1thn.setForeground(new java.awt.Color(130, 130, 130));
        textpembelian1thn.setText("Pembelian Selama Satu Tahun");
        LAPORANTOTAL.add(textpembelian1thn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 260, -1));

        angkadibeli.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkadibeli.setText("0");
        LAPORANTOTAL.add(angkadibeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 490, 410, 50));

        textdibeli.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textdibeli.setForeground(new java.awt.Color(130, 130, 130));
        textdibeli.setText("Jumlah Barang Dibeli");
        LAPORANTOTAL.add(textdibeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 540, 260, -1));

        textgrafikthn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textgrafikthn.setText("Grafik Penjulan dari Tahun ke Tahun");
        LAPORANTOTAL.add(textgrafikthn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 740, 630, 50));

        bgLaporantotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/DS1.png"))); // NOI18N
        LAPORANTOTAL.add(bgLaporantotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(LAPORANTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SETTING.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HSDBFORM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HSDB.png"))); // NOI18N
        SETTING.add(HSDBFORM, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 910, 560));

        idkaryawanstfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        idkaryawanstfield.setBorder(null);
        SETTING.add(idkaryawanstfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 250, 30));

        namakaryawanstfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        namakaryawanstfield.setBorder(null);
        SETTING.add(namakaryawanstfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 570, 30));

        passwordstfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        passwordstfield.setText("jPasswordField1");
        passwordstfield.setBorder(null);
        SETTING.add(passwordstfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 530, 30));

        notelpstfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        notelpstfield.setBorder(null);
        SETTING.add(notelpstfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 590, 250, 40));

        carisettingfield.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        carisettingfield.setBorder(null);
        carisettingfield.setOpaque(false);
        SETTING.add(carisettingfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 90, 220, 30));

        hapusstbtn.setOpaque(false);
        hapusstbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusstbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapusstbtnLayout = new javax.swing.GroupLayout(hapusstbtn);
        hapusstbtn.setLayout(hapusstbtnLayout);
        hapusstbtnLayout.setHorizontalGroup(
            hapusstbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        hapusstbtnLayout.setVerticalGroup(
            hapusstbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        SETTING.add(hapusstbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 670, 180, 70));

        updatestbtn.setOpaque(false);
        updatestbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatestbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout updatestbtnLayout = new javax.swing.GroupLayout(updatestbtn);
        updatestbtn.setLayout(updatestbtnLayout);
        updatestbtnLayout.setHorizontalGroup(
            updatestbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        updatestbtnLayout.setVerticalGroup(
            updatestbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        SETTING.add(updatestbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 670, 180, 70));

        tambahkanstbtn.setOpaque(false);
        tambahkanstbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahkanstbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tambahkanstbtnLayout = new javax.swing.GroupLayout(tambahkanstbtn);
        tambahkanstbtn.setLayout(tambahkanstbtnLayout);
        tambahkanstbtnLayout.setHorizontalGroup(
            tambahkanstbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        tambahkanstbtnLayout.setVerticalGroup(
            tambahkanstbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        SETTING.add(tambahkanstbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, 180, 70));

        exportstbtn.setOpaque(false);
        exportstbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportstbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exportstbtnLayout = new javax.swing.GroupLayout(exportstbtn);
        exportstbtn.setLayout(exportstbtnLayout);
        exportstbtnLayout.setHorizontalGroup(
            exportstbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        exportstbtnLayout.setVerticalGroup(
            exportstbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        SETTING.add(exportstbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 90, 150, 40));

        caristbtn.setOpaque(false);
        caristbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caristbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout caristbtnLayout = new javax.swing.GroupLayout(caristbtn);
        caristbtn.setLayout(caristbtnLayout);
        caristbtnLayout.setHorizontalGroup(
            caristbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        caristbtnLayout.setVerticalGroup(
            caristbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        SETTING.add(caristbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 90, 120, 40));

        eyehide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-hide-30.png"))); // NOI18N
        eyehide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyehideMouseClicked(evt);
            }
        });
        SETTING.add(eyehide, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 480, 40, 30));

        eyeshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-eye-30.png"))); // NOI18N
        eyeshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyeshowMouseClicked(evt);
            }
        });
        SETTING.add(eyeshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 480, 40, 30));

        tglst.setDateFormatString("yyyy-MM-dd");
        tglst.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        SETTING.add(tglst, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, 280, 40));

        hakaksescb.setBackground(new java.awt.Color(244, 239, 224));
        hakaksescb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hakaksescb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Akses --", "Pemilik", "Administrator", "Karyawan" }));
        hakaksescb.setBorder(null);
        SETTING.add(hakaksescb, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 280, 50));

        tabelsetting.setBackground(new java.awt.Color(244, 239, 224));
        tabelsetting.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tabelsetting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "ID Karyawan", "Nama Karyawan", "Hak Akses", "No. Telepon"
            }
        ));
        tabelsetting.setGridColor(new java.awt.Color(255, 255, 255));
        tabelsetting.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabelsetting.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelsetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelsettingMouseClicked(evt);
            }
        });
        jPane2.setViewportView(tabelsetting);

        SETTING.add(jPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 150, 780, 620));

        hapusdatabarangbtn.setOpaque(false);
        hapusdatabarangbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusdatabarangbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapusdatabarangbtnLayout = new javax.swing.GroupLayout(hapusdatabarangbtn);
        hapusdatabarangbtn.setLayout(hapusdatabarangbtnLayout);
        hapusdatabarangbtnLayout.setHorizontalGroup(
            hapusdatabarangbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        hapusdatabarangbtnLayout.setVerticalGroup(
            hapusdatabarangbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        SETTING.add(hapusdatabarangbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 870, 160, 30));

        hapusdatasupplierbtn.setOpaque(false);
        hapusdatasupplierbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusdatasupplierbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapusdatasupplierbtnLayout = new javax.swing.GroupLayout(hapusdatasupplierbtn);
        hapusdatasupplierbtn.setLayout(hapusdatasupplierbtnLayout);
        hapusdatasupplierbtnLayout.setHorizontalGroup(
            hapusdatasupplierbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        hapusdatasupplierbtnLayout.setVerticalGroup(
            hapusdatasupplierbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        SETTING.add(hapusdatasupplierbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 940, 160, 40));

        hapusdatalaporanpjbtn.setOpaque(false);
        hapusdatalaporanpjbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusdatalaporanpjbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapusdatalaporanpjbtnLayout = new javax.swing.GroupLayout(hapusdatalaporanpjbtn);
        hapusdatalaporanpjbtn.setLayout(hapusdatalaporanpjbtnLayout);
        hapusdatalaporanpjbtnLayout.setHorizontalGroup(
            hapusdatalaporanpjbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        hapusdatalaporanpjbtnLayout.setVerticalGroup(
            hapusdatalaporanpjbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        SETTING.add(hapusdatalaporanpjbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 870, 160, 30));

        hapusdatalaporansmbtn.setOpaque(false);
        hapusdatalaporansmbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusdatalaporansmbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapusdatalaporansmbtnLayout = new javax.swing.GroupLayout(hapusdatalaporansmbtn);
        hapusdatalaporansmbtn.setLayout(hapusdatalaporansmbtnLayout);
        hapusdatalaporansmbtnLayout.setHorizontalGroup(
            hapusdatalaporansmbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        hapusdatalaporansmbtnLayout.setVerticalGroup(
            hapusdatalaporansmbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        SETTING.add(hapusdatalaporansmbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 940, -1, -1));

        settingpic.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        settingpic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settingpic.png"))); // NOI18N
        settingpic.setText("     Pengaturan");
        SETTING.add(settingpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

        bgSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ST1.png"))); // NOI18N
        SETTING.add(bgSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        getContentPane().add(SETTING, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LAPORANSELECT2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        laporanpic2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        laporanpic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/laporanpic.png"))); // NOI18N
        LAPORANSELECT2.add(laporanpic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(jTable5);

        LAPORANSELECT2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 1490, 630));
        LAPORANSELECT2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        bgLaporanselect2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LS1.png"))); // NOI18N
        LAPORANSELECT2.add(bgLaporanselect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        getContentPane().add(LAPORANSELECT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SUPPLIER.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supplierpic.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        supplierpic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/supplierpic.png"))); // NOI18N
        supplierpic.setText("     Supplier");
        SUPPLIER.add(supplierpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

        idsupplierfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        idsupplierfield.setBorder(null);
        SUPPLIER.add(idsupplierfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 570, 30));

        namasupplierfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        namasupplierfield.setBorder(null);
        SUPPLIER.add(namasupplierfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 570, 30));

        alamatsupplierfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        alamatsupplierfield.setBorder(null);
        SUPPLIER.add(alamatsupplierfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 570, 30));

        notelpsupplierfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        notelpsupplierfield.setBorder(null);
        SUPPLIER.add(notelpsupplierfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 570, 40));

        keterangansupplierfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        keterangansupplierfield.setBorder(null);
        SUPPLIER.add(keterangansupplierfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 690, 570, 40));

        carisupplierfield.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        carisupplierfield.setBorder(null);
        carisupplierfield.setOpaque(false);
        SUPPLIER.add(carisupplierfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 100, 220, 30));

        hapusspbtn.setOpaque(false);
        hapusspbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusspbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapusspbtnLayout = new javax.swing.GroupLayout(hapusspbtn);
        hapusspbtn.setLayout(hapusspbtnLayout);
        hapusspbtnLayout.setHorizontalGroup(
            hapusspbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        hapusspbtnLayout.setVerticalGroup(
            hapusspbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        SUPPLIER.add(hapusspbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 810, 180, 70));

        updatespbtn.setOpaque(false);
        updatespbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatespbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout updatespbtnLayout = new javax.swing.GroupLayout(updatespbtn);
        updatespbtn.setLayout(updatespbtnLayout);
        updatespbtnLayout.setHorizontalGroup(
            updatespbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        updatespbtnLayout.setVerticalGroup(
            updatespbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        SUPPLIER.add(updatespbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 810, 180, 70));

        tambahkanspbtn.setOpaque(false);
        tambahkanspbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahkanspbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tambahkanspbtnLayout = new javax.swing.GroupLayout(tambahkanspbtn);
        tambahkanspbtn.setLayout(tambahkanspbtnLayout);
        tambahkanspbtnLayout.setHorizontalGroup(
            tambahkanspbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        tambahkanspbtnLayout.setVerticalGroup(
            tambahkanspbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        SUPPLIER.add(tambahkanspbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 810, 180, 70));

        exportspbtn.setOpaque(false);
        exportspbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportspbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exportspbtnLayout = new javax.swing.GroupLayout(exportspbtn);
        exportspbtn.setLayout(exportspbtnLayout);
        exportspbtnLayout.setHorizontalGroup(
            exportspbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        exportspbtnLayout.setVerticalGroup(
            exportspbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        SUPPLIER.add(exportspbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 100, 150, 40));

        carispbtn.setOpaque(false);
        carispbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carispbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout carispbtnLayout = new javax.swing.GroupLayout(carispbtn);
        carispbtn.setLayout(carispbtnLayout);
        carispbtnLayout.setHorizontalGroup(
            carispbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        carispbtnLayout.setVerticalGroup(
            carispbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        SUPPLIER.add(carispbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 100, 120, 40));

        tabelsupplier.setBackground(new java.awt.Color(244, 239, 224));
        tabelsupplier.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tabelsupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "ID Supplier", "Nama Supplier", "Alamat", "No. Telepon", "Keterangan"
            }
        ));
        tabelsupplier.setGridColor(new java.awt.Color(255, 255, 255));
        tabelsupplier.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabelsupplier.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelsupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelsupplierMouseClicked(evt);
            }
        });
        jPane1.setViewportView(tabelsupplier);
        if (tabelsupplier.getColumnModel().getColumnCount() > 0) {
            tabelsupplier.getColumnModel().getColumn(4).setHeaderValue("No. Telepon");
            tabelsupplier.getColumnModel().getColumn(5).setHeaderValue("Keterangan");
        }

        SUPPLIER.add(jPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 160, 780, 790));

        bgSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/SP1.png"))); // NOI18N
        SUPPLIER.add(bgSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(SUPPLIER, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        TRANSAKSI.setOpaque(false);
        TRANSAKSI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transaksipic.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        transaksipic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/barangpic.png"))); // NOI18N
        transaksipic.setText("     Transaksi");
        TRANSAKSI.add(transaksipic, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

        hargatrfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hargatrfield.setBorder(null);
        hargatrfield.setOpaque(false);
        TRANSAKSI.add(hargatrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 350, 260, 30));

        jumlahtrfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jumlahtrfield.setBorder(null);
        jumlahtrfield.setOpaque(false);
        TRANSAKSI.add(jumlahtrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 350, 240, 30));

        namapembelitrfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        namapembelitrfield.setBorder(null);
        namapembelitrfield.setOpaque(false);
        TRANSAKSI.add(namapembelitrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 260, 570, 40));

        tambahkantrbtn.setOpaque(false);
        tambahkantrbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahkantrbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tambahkantrbtnLayout = new javax.swing.GroupLayout(tambahkantrbtn);
        tambahkantrbtn.setLayout(tambahkantrbtnLayout);
        tambahkantrbtnLayout.setHorizontalGroup(
            tambahkantrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        tambahkantrbtnLayout.setVerticalGroup(
            tambahkantrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        TRANSAKSI.add(tambahkantrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 410, 260, 50));

        totalhargatrfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalhargatrfield.setBorder(null);
        totalhargatrfield.setOpaque(false);
        TRANSAKSI.add(totalhargatrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 570, 480, 40));

        bayartrfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bayartrfield.setBorder(null);
        bayartrfield.setOpaque(false);
        TRANSAKSI.add(bayartrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 680, 480, 40));

        kembaliantrfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        kembaliantrfield.setBorder(null);
        kembaliantrfield.setOpaque(false);
        TRANSAKSI.add(kembaliantrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 780, 480, 50));

        tabelbarangtr.setBackground(new java.awt.Color(244, 239, 224));
        tabelbarangtr.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tabelbarangtr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "ID Alat Musik", "Nama Alat Musik", "Harga", "Stok"
            }
        ));
        tabelbarangtr.setGridColor(new java.awt.Color(255, 255, 255));
        tabelbarangtr.setRequestFocusEnabled(false);
        tabelbarangtr.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabelbarangtr.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelbarangtr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbarangtrMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbarangtr);

        TRANSAKSI.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 800, 300));

        tabelkeranjang.setBackground(new java.awt.Color(244, 239, 224));
        tabelkeranjang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tabelkeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "ID Pembeli", "ID Transaksi", "ID Alat Musik", "Nama Alat Musik", "Harga", "Jumlah", "Total Harga", "Tanggal"
            }
        ));
        tabelkeranjang.setGridColor(new java.awt.Color(255, 255, 255));
        tabelkeranjang.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabelkeranjang.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tabelkeranjang);

        TRANSAKSI.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 970, 430));

        idpembelitrfield.setText("PB");
        TRANSAKSI.add(idpembelitrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 80, -1));
        TRANSAKSI.add(idtransaksitrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 80, -1));

        bgTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TR1.png"))); // NOI18N
        TRANSAKSI.add(bgTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        idbarangtrfield.setText("jTextField1");
        TRANSAKSI.add(idbarangtrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, -1, -1));

        namabarangtrfield.setText("jTextField1");
        TRANSAKSI.add(namabarangtrfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, -1, -1));

        totalbelanjafield.setText("jTextField1");
        TRANSAKSI.add(totalbelanjafield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 60, -1, -1));

        getContentPane().add(TRANSAKSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1010));

        BARANG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barangpic.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        barangpic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/barangpic.png"))); // NOI18N
        barangpic.setText("     Barang");
        BARANG.add(barangpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

        idbarangfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        idbarangfield.setBorder(null);
        BARANG.add(idbarangfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 570, 30));

        namabarangfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        namabarangfield.setBorder(null);
        BARANG.add(namabarangfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 570, 30));

        hargajualfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hargajualfield.setBorder(null);
        BARANG.add(hargajualfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 570, 30));

        hargabelifield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hargabelifield.setBorder(null);
        BARANG.add(hargabelifield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 570, 40));

        stokfield.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        stokfield.setBorder(null);
        BARANG.add(stokfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 690, 570, 40));

        carifield.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        carifield.setBorder(null);
        carifield.setOpaque(false);
        BARANG.add(carifield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 100, 220, 30));

        tambahkanbrbtn.setOpaque(false);
        tambahkanbrbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahkanbrbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tambahkanbrbtnLayout = new javax.swing.GroupLayout(tambahkanbrbtn);
        tambahkanbrbtn.setLayout(tambahkanbrbtnLayout);
        tambahkanbrbtnLayout.setHorizontalGroup(
            tambahkanbrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        tambahkanbrbtnLayout.setVerticalGroup(
            tambahkanbrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        BARANG.add(tambahkanbrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 810, 180, 70));

        updatebrbtn.setOpaque(false);
        updatebrbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebrbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout updatebrbtnLayout = new javax.swing.GroupLayout(updatebrbtn);
        updatebrbtn.setLayout(updatebrbtnLayout);
        updatebrbtnLayout.setHorizontalGroup(
            updatebrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        updatebrbtnLayout.setVerticalGroup(
            updatebrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        BARANG.add(updatebrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 810, 180, 70));

        hapusbrbtn.setOpaque(false);
        hapusbrbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusbrbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapusbrbtnLayout = new javax.swing.GroupLayout(hapusbrbtn);
        hapusbrbtn.setLayout(hapusbrbtnLayout);
        hapusbrbtnLayout.setHorizontalGroup(
            hapusbrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        hapusbrbtnLayout.setVerticalGroup(
            hapusbrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        BARANG.add(hapusbrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 810, 180, 70));

        caribrbtn.setOpaque(false);
        caribrbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caribrbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout caribrbtnLayout = new javax.swing.GroupLayout(caribrbtn);
        caribrbtn.setLayout(caribrbtnLayout);
        caribrbtnLayout.setHorizontalGroup(
            caribrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        caribrbtnLayout.setVerticalGroup(
            caribrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        BARANG.add(caribrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 100, 120, 40));

        exportbrbtn.setOpaque(false);
        exportbrbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportbrbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exportbrbtnLayout = new javax.swing.GroupLayout(exportbrbtn);
        exportbrbtn.setLayout(exportbrbtnLayout);
        exportbrbtnLayout.setHorizontalGroup(
            exportbrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        exportbrbtnLayout.setVerticalGroup(
            exportbrbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        BARANG.add(exportbrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 100, 150, 40));

        tabelbarang.setBackground(new java.awt.Color(244, 239, 224));
        tabelbarang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tabelbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "ID Alat Musik", "Nama Alat Musik", "Harga Jual", "Harga Beli", "Stok"
            }
        ));
        tabelbarang.setGridColor(new java.awt.Color(255, 255, 255));
        tabelbarang.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabelbarang.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbarangMouseClicked(evt);
            }
        });
        jPane.setViewportView(tabelbarang);
        if (tabelbarang.getColumnModel().getColumnCount() > 0) {
            tabelbarang.getColumnModel().getColumn(4).setHeaderValue("No. Telepon");
            tabelbarang.getColumnModel().getColumn(5).setHeaderValue("Keterangan");
        }

        BARANG.add(jPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 160, 780, 790));

        bgBarang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        bgBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BR1.png"))); // NOI18N
        BARANG.add(bgBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(BARANG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        DASHBOARD.setOpaque(false);
        DASHBOARD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboardpic.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        dashboardpic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboardpic1.png"))); // NOI18N
        dashboardpic.setText("     Dashboard");
        DASHBOARD.add(dashboardpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

        angkapenjualan1hr.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapenjualan1hr.setText("Rp.0,0");
        DASHBOARD.add(angkapenjualan1hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 410, 50));

        textpenjualan1hr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpenjualan1hr.setForeground(new java.awt.Color(130, 130, 130));
        textpenjualan1hr.setText("Penjualan Selama Satu Hari");
        DASHBOARD.add(textpenjualan1hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 260, -1));

        angkastok.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkastok.setText("0");
        DASHBOARD.add(angkastok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 250, 410, 50));

        textstok.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textstok.setForeground(new java.awt.Color(130, 130, 130));
        textstok.setText("Stok Barang");
        DASHBOARD.add(textstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 300, 260, -1));

        angkatotalpembelian.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkatotalpembelian.setText("0 ORANG");
        DASHBOARD.add(angkatotalpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 410, 50));

        texttotalpembelian.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        texttotalpembelian.setForeground(new java.awt.Color(130, 130, 130));
        texttotalpembelian.setText("Total Pembelian Hari Ini");
        DASHBOARD.add(texttotalpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 260, -1));

        angkajumlah.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkajumlah.setText("0");
        DASHBOARD.add(angkajumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 490, 410, 50));

        textjumlah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textjumlah.setForeground(new java.awt.Color(130, 130, 130));
        textjumlah.setText("Jumlah Barang Masuk");
        DASHBOARD.add(textjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 540, 260, -1));

        textgrafik.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textgrafik.setText("Grafik Penjulan Selama Satu Minggu");
        DASHBOARD.add(textgrafik, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 740, 630, 50));

        bgDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/DS1.png"))); // NOI18N
        DASHBOARD.add(bgDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        getContentPane().add(DASHBOARD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1010));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardmenuMouseClicked
    DASHBOARD.setVisible(true);
    BARANG.setVisible(false);
    TRANSAKSI.setVisible(false);
    SUPPLIER.setVisible(false);
    LAPORANTOTAL.setVisible(false);
    LAPORANSELECT1.setVisible(false);
    LAPORANSELECT2.setVisible(false);
    SETTING.setVisible(false);
    laporanselectcb.setVisible(false);
    dashboardshow();
    kosong();
    kosongsp();
    }//GEN-LAST:event_dashboardmenuMouseClicked

    private void barangmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangmenuMouseClicked
    DASHBOARD.setVisible(false);
    BARANG.setVisible(true);
    TRANSAKSI.setVisible(false);
    SUPPLIER.setVisible(false);
    LAPORANTOTAL.setVisible(false);
    LAPORANSELECT1.setVisible(false);
    LAPORANSELECT2.setVisible(false);
    SETTING.setVisible(false);
    laporanselectcb.setVisible(false);
    barangshow();
    kosong();
    kosongsp();
    load_tabelbarang();
    lebar_tabelbarang();
    }//GEN-LAST:event_barangmenuMouseClicked

    private void transaksimenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksimenuMouseClicked
    DASHBOARD.setVisible(false);
    BARANG.setVisible(false);
    TRANSAKSI.setVisible(true);
    SUPPLIER.setVisible(false);
    LAPORANTOTAL.setVisible(false);
    LAPORANSELECT1.setVisible(false);
    LAPORANSELECT2.setVisible(false);
    SETTING.setVisible(false);
    laporanselectcb.setVisible(false);
    transaksishow();
    kosong();
    kosongsp();
    load_tabelbarangtr();
    lebar_tabelbarangtr();
    load_tabelkeranjang();
    lebar_tabelkeranjang();
    }//GEN-LAST:event_transaksimenuMouseClicked

    private void suppliermenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliermenuMouseClicked
    DASHBOARD.setVisible(false);
    BARANG.setVisible(false);
    TRANSAKSI.setVisible(false);
    SUPPLIER.setVisible(true);
    LAPORANTOTAL.setVisible(false);
    LAPORANSELECT1.setVisible(false);
    LAPORANSELECT2.setVisible(false);
    SETTING.setVisible(false);
    laporanselectcb.setVisible(false);
    suppliershow();
    kosong();
    kosongsp();
    load_tabelsupplier();
    lebar_tabelsupplier();
    }//GEN-LAST:event_suppliermenuMouseClicked

    private void laporanmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanmenuMouseClicked
    DASHBOARD.setVisible(false);
    BARANG.setVisible(false);
    TRANSAKSI.setVisible(false);
    SUPPLIER.setVisible(false);
    LAPORANTOTAL.setVisible(true);
    LAPORANSELECT1.setVisible(false);
    LAPORANSELECT2.setVisible(false);
    SETTING.setVisible(false);
    laporanselectcb.setVisible(true);
    laporanshow();
    kosong();
    kosongsp();
    }//GEN-LAST:event_laporanmenuMouseClicked

    private void pengaturanmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengaturanmenuMouseClicked
    DASHBOARD.setVisible(false);
    BARANG.setVisible(false);
    TRANSAKSI.setVisible(false);
    SUPPLIER.setVisible(false);
    LAPORANTOTAL.setVisible(false);
    LAPORANSELECT1.setVisible(false);
    LAPORANSELECT2.setVisible(false);
    SETTING.setVisible(true);
    HSDBFORM.setVisible(false);
    laporanselectcb.setVisible(false);
    pengaturanshow();
    eyehide.setVisible(false);
    idkaryawanstfield.enable();
    kosong();
    kosongst();
    load_tabelsetting();
    lebar_tabelsetting();
    
    }//GEN-LAST:event_pengaturanmenuMouseClicked

    private void keluarmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarmenuMouseClicked
    keluarshow();
    }//GEN-LAST:event_keluarmenuMouseClicked

    private void keluarbtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarbtnMouseMoved
    keluarbtn.setBackground(new java.awt.Color(194,184,156));
    }//GEN-LAST:event_keluarbtnMouseMoved

    private void keluarbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarbtnMouseExited
    keluarbtn.setBackground(new java.awt.Color(244, 239, 224));
    }//GEN-LAST:event_keluarbtnMouseExited

    private void tabelbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseClicked
    // Tampilan Barang
        int baris = tabelbarang.rowAtPoint(evt.getPoint());
        String idText = tabelbarang.getValueAt(baris, 1).toString();
        idbarangfield.setText(idText);
        idbarangfield.disable();

        if (tabelbarang.getValueAt(baris, 2)==null){
            namabarangfield.setText("");
        } else {
            namabarangfield.setText(tabelbarang.getValueAt(baris, 2).toString());
        }
        if (tabelbarang.getValueAt(baris, 3)==null){
            hargajualfield.setText("");
        } else {
            hargajualfield.setText(tabelbarang.getValueAt(baris, 3).toString());
        }
        if (tabelbarang.getValueAt(baris, 4)==null){
            hargabelifield.setText("");
        } else {
            hargabelifield.setText(tabelbarang.getValueAt(baris, 4).toString());
        }
        if (tabelbarang.getValueAt(baris, 5)==null){
            stokfield.setText("");
        } else {
            stokfield.setText(tabelbarang.getValueAt(baris, 5).toString());
        }
    }//GEN-LAST:event_tabelbarangMouseClicked

    
    
    private void tambahkanbrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahkanbrbtnMouseClicked
        // Tampilan Barang
    try {
        String sql3 = "INSERT INTO alatmusik VALUES ('"+idbarangfield.getText()+"','"+namabarangfield.getText()+
                "',"+hargajualfield.getText()+","+hargabelifield.getText()+","+stokfield.getText()+")";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql3);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
        DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
        model.setRowCount(0);
        load_tabelbarang();
        lebar_tabelbarang();
        kosong();
//        auto_id auto1 = new auto_id();
//        auto1.autoidbarang();
        
    } catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_tambahkanbrbtnMouseClicked

    private void updatebrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebrbtnMouseClicked
    // Tampilan Barang
    try {
        String sql = "UPDATE alatmusik "+"SET namaalatmusik = '"+namabarangfield.getText()+"', harga_jual = '"+hargajualfield.getText()
                +"', harga_beli = '"+hargabelifield.getText()
                +"', stok = '"+stokfield.getText()+"'"+
                " WHERE idalatmusik = '"+idbarangfield.getText()+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
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
    kosong();
    }//GEN-LAST:event_updatebrbtnMouseClicked

    private void caribrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caribrbtnMouseClicked
    // Tampilan Barang
    try {
        String sqls = "SELECT * FROM alatmusik WHERE idalatmusik LIKE '%"+carifield.getText()+
                    "%' OR namaalatmusik LIKE '%"+carifield.getText()+"%' OR harga_jual LIKE '"+carifield.getText()+"' OR harga_beli LIKE '"+carifield.getText()+
                    "' OR stok LIKE '"+carifield.getText()+"' ORDER BY idalatmusik";
        java.sql.Connection conn = (Connection)Config.configDB();
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
    }//GEN-LAST:event_caribrbtnMouseClicked

    private void exportbrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportbrbtnMouseClicked
    // Tampilan Barang
        DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
        tabelbarang.setModel(model);
        try{
            WritableWorkbook write = Workbook.createWorkbook(new File("C:/Users/Maulana Akbar/Documents/All XLS/export-data-barang.xls"));
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
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan Ke Excel");
        }catch(HeadlessException | IOException | WriteException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString());
        }
    }//GEN-LAST:event_exportbrbtnMouseClicked

    private void hapusbrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusbrbtnMouseClicked
    // Tampilan Barang
    try {
        String sql = "DELETE FROM alatmusik WHERE idalatmusik ='"+idbarangfield.getText()+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
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
    kosong();
    }//GEN-LAST:event_hapusbrbtnMouseClicked

    private void tabelsupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelsupplierMouseClicked
    // Tampilan Supplier
        int baris = tabelsupplier.rowAtPoint(evt.getPoint());
        String idText = tabelsupplier.getValueAt(baris, 1).toString();
        idsupplierfield.setText(idText);
        idsupplierfield.disable();

        if (tabelsupplier.getValueAt(baris, 2)==null){
            namasupplierfield.setText("");
        } else {
            namasupplierfield.setText(tabelsupplier.getValueAt(baris, 2).toString());
        }
        if (tabelsupplier.getValueAt(baris, 3)==null){
            alamatsupplierfield.setText("");
        } else {
            alamatsupplierfield.setText(tabelsupplier.getValueAt(baris, 3).toString());
        }
        if (tabelsupplier.getValueAt(baris, 4)==null){
            notelpsupplierfield.setText("");
        } else {
            notelpsupplierfield.setText(tabelsupplier.getValueAt(baris, 4).toString());
        }
        if (tabelsupplier.getValueAt(baris, 5)==null){
            keterangansupplierfield.setText("");
        } else {
            keterangansupplierfield.setText(tabelsupplier.getValueAt(baris, 5).toString());
        }
    }//GEN-LAST:event_tabelsupplierMouseClicked

    private void tambahkanspbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahkanspbtnMouseClicked
    // Tampilan Supplier
    try {
        String sql3 = "INSERT INTO supplier VALUES ('"+idsupplierfield.getText()+"','"+namasupplierfield.getText()+
                "','"+alamatsupplierfield.getText()+"',"+notelpsupplierfield.getText()+",'"+keterangansupplierfield.getText()+"')";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql3);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
        DefaultTableModel model = (DefaultTableModel)tabelsupplier.getModel();
        model.setRowCount(0);
        load_tabelsupplier();
        lebar_tabelsupplier();
        kosongsp();
//        kelas.autoidbarang();
        
    } catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_tambahkanspbtnMouseClicked

    private void updatespbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatespbtnMouseClicked
    // Tampilan Supplier
    try {
        String sql = "UPDATE supplier "+"SET nama_supplier = '"+namasupplierfield.getText()+"', alamat = '"+alamatsupplierfield.getText()
                +"', no_telp = '"+notelpsupplierfield.getText()
                +"', keterangan = '"+keterangansupplierfield.getText()+"'"+
                " WHERE id_supplier = '"+idsupplierfield.getText()+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
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
    kosongsp();
    }//GEN-LAST:event_updatespbtnMouseClicked

    private void hapusspbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusspbtnMouseClicked
    // Tampilan Supplier
    try {
        String sql = "DELETE FROM supplier WHERE id_supplier ='"+idsupplierfield.getText()+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
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
    kosongsp();
    }//GEN-LAST:event_hapusspbtnMouseClicked

    private void carispbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carispbtnMouseClicked
    // Tampilan Supplier
    try {
        String sqls = "SELECT * FROM supplier WHERE id_supplier LIKE '%"+carisupplierfield.getText()+
                    "%' OR nama_supplier LIKE '%"+carisupplierfield.getText()+"%' OR alamat LIKE '%"+carisupplierfield.getText()+
                    "%' OR no_telp LIKE '"+carisupplierfield.getText()+
                    "' OR keterangan LIKE '%"+carisupplierfield.getText()+"%' ORDER BY id_supplier";
        java.sql.Connection conn = (Connection)Config.configDB();
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
    }//GEN-LAST:event_carispbtnMouseClicked

    private void exportspbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportspbtnMouseClicked
    // Tampilan Supplier
    DefaultTableModel model = (DefaultTableModel)tabelsupplier.getModel();
        tabelsupplier.setModel(model);
        try{
            WritableWorkbook write = Workbook.createWorkbook(new File("C:/Users/Maulana Akbar/Documents/All XLS/export-data-supplier.xls"));
            WritableSheet sheet = write.createSheet("export-data",0);
            sheet.addCell(new Label(0,0,"Id Supplier"));
            sheet.addCell(new Label(1,0,"Nama Supplier"));
            sheet.addCell(new Label(2,0,"Alamat"));
            sheet.addCell(new Label(3,0,"No. Telepon"));
            sheet.addCell(new Label(4,0,"Keterangan"));
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
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan Ke Excel");
        }catch(HeadlessException | IOException | WriteException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString());
        }
    }//GEN-LAST:event_exportspbtnMouseClicked

    private void laporanselectcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanselectcbActionPerformed
    // Tampilan Laporan
    if (laporanselectcb.getSelectedIndex()==0){
        LAPORANTOTAL.setVisible(true);
        LAPORANSELECT1.setVisible(false);
        LAPORANSELECT2.setVisible(false);
    }
    if (laporanselectcb.getSelectedIndex()==1){
        LAPORANTOTAL.setVisible(false);
        LAPORANSELECT1.setVisible(true);
        LAPORANSELECT2.setVisible(false);
    }
    if (laporanselectcb.getSelectedIndex()==2){
        LAPORANTOTAL.setVisible(false);
        LAPORANSELECT1.setVisible(false);
        LAPORANSELECT2.setVisible(true);
    }
    }//GEN-LAST:event_laporanselectcbActionPerformed

    private void hapusstbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusstbtnMouseClicked
    // Tampilan Setting
    try {        
        String sql1 = "DELETE FROM user WHERE idkaryawan ='"+idkaryawanstfield.getText()+"'";
        String sql2 = "DELETE FROM login WHERE idkaryawan ='"+idkaryawanstfield.getText()+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
        pst2.execute();
        pst1.execute();
        JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus");
        DefaultTableModel model = (DefaultTableModel)tabelsetting.getModel();
        model.setRowCount(0);
        load_tabelsetting();
        lebar_tabelsetting();
        kosongst();
//        kelas.autoidbarang();
        
    } catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_hapusstbtnMouseClicked

    private void updatestbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatestbtnMouseClicked
    // Tampilan Setting
    try {        
        String sql1 = "UPDATE user "+"SET nama_karyawan = '"+namakaryawanstfield.getText()+"', user_parameter = '"+hakaksescb.getSelectedItem()
                +"', telepon = "+notelpstfield.getText()+
                " WHERE idkaryawan = '"+idkaryawanstfield.getText()+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        pst1.execute();
        JOptionPane.showMessageDialog(null,"Data Berhasil di Perbarui");
        DefaultTableModel model = (DefaultTableModel)tabelsetting.getModel();
        model.setRowCount(0);
        load_tabelsetting();
        lebar_tabelsetting();
        kosongst();
//        kelas.autoidbarang();
        
    } catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_updatestbtnMouseClicked

    private void tambahkanstbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahkanstbtnMouseClicked
     // Tampilan Setting
    try {        
        String sql1 = "INSERT INTO user VALUES('"+idkaryawanstfield.getText()+"','"+namakaryawanstfield.getText()+
                      "','"+hakaksescb.getSelectedItem()+"','"+tglst.getDate()+"','"+notelpstfield.getText()+"')";
        String sql2 = "INSERT INTO login VALUES('"+idkaryawanstfield.getText()+"','"+passwordstfield.getText()+"')";
        //String sql3 = "INSERT INTO user (idkaryawan, nama_karyawan, user_paramater, tgl_lahir, telepon)VALUES ('"+idkaryawanstfield.getText()+"','"+namakaryawanstfield.getText()+"'"
             //   + ",'"+hakaksescb.getSelectedItem()+"',"+notelpstfield1.getText()+",'"+notelpstfield.getText()+"')";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
        pst1.execute();
        pst2.execute();
        JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
        DefaultTableModel model = (DefaultTableModel)tabelsetting.getModel();
        model.setRowCount(0);
        load_tabelsetting();
        lebar_tabelsetting();
        kosongst();
//        kelas.autoidbarang();
        
    } catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_tambahkanstbtnMouseClicked

    private void exportstbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportstbtnMouseClicked
    // Tampilan Setting
    DefaultTableModel model = (DefaultTableModel)tabelsetting.getModel();
        tabelsetting.setModel(model);
        try{
            WritableWorkbook write = Workbook.createWorkbook(new File("C:/Users/Maulana Akbar/Documents/All XLS/export-data-setting.xls"));
            WritableSheet sheet = write.createSheet("export-data",0);
            sheet.addCell(new Label(0,0,"Id Karyawan"));
            sheet.addCell(new Label(1,0,"Nama Karyawan"));
            sheet.addCell(new Label(2,0,"Hak Akses"));
            sheet.addCell(new Label(3,0,"No. Telepon"));
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
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan Ke Excel");
        }catch(HeadlessException | IOException | WriteException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString());
        }
    }//GEN-LAST:event_exportstbtnMouseClicked

    private void caristbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caristbtnMouseClicked
    // Tampilan Setting
    try {
        String sqls = "SELECT * FROM user WHERE idkaryawan LIKE '%"+carisettingfield.getText()+
                    "%' OR nama_karyawan LIKE '%"+carisettingfield.getText()+
                    "%' OR user_parameter LIKE '%"+carisettingfield.getText()+"%' OR telepon LIKE '"+carisettingfield.getText()+"' ORDER BY idkaryawan";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
        java.sql.ResultSet ress = pst.executeQuery(sqls);
        DefaultTableModel model = (DefaultTableModel)tabelsetting.getModel();
        model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4)});
            }
        tabelsetting.setModel(model);
        } catch (SQLException ex) {
    }    
    }//GEN-LAST:event_caristbtnMouseClicked

    private void tabelsettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelsettingMouseClicked
    // Tampilan Setting
        int baris = tabelsetting.rowAtPoint(evt.getPoint());
        String idText = tabelsetting.getValueAt(baris, 1).toString();
        idkaryawanstfield.setText(idText);
        idkaryawanstfield.disable();
        passwordstfield.setText(null);

        if (tabelsetting.getValueAt(baris, 2)==null){
            namakaryawanstfield.setText("");
        } else {
            namakaryawanstfield.setText(tabelsetting.getValueAt(baris, 2).toString());
        }
        if (tabelsetting.getValueAt(baris, 4)==null){
            notelpstfield.setText("");
        } else {
            notelpstfield.setText(tabelsetting.getValueAt(baris, 4).toString());
        }
    }//GEN-LAST:event_tabelsettingMouseClicked

    private void eyehideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyehideMouseClicked
        // Tampilan Setting
        passwordstfield.setEchoChar('•');
        eyeshow.setVisible(true);
        eyehide.setVisible(false);
    }//GEN-LAST:event_eyehideMouseClicked

    private void eyeshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeshowMouseClicked
        // Tampilan Setting
        passwordstfield.setEchoChar((char)0);
        passwordstfield.setFont(new java.awt.Font("Segoe UI Bold", 2, 18));
        eyeshow.setVisible(false);
        eyehide.setVisible(true);
    }//GEN-LAST:event_eyeshowMouseClicked

    private void hapusdatabarangbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusdatabarangbtnMouseClicked
        // Tampilan Setting
        HSDBFORM.setVisible(true);
    }//GEN-LAST:event_hapusdatabarangbtnMouseClicked

    private void hapusdatasupplierbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusdatasupplierbtnMouseClicked
        // Tampilan Setting
    }//GEN-LAST:event_hapusdatasupplierbtnMouseClicked

    private void hapusdatalaporanpjbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusdatalaporanpjbtnMouseClicked
        // Tampilan Setting
    }//GEN-LAST:event_hapusdatalaporanpjbtnMouseClicked

    private void hapusdatalaporansmbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusdatalaporansmbtnMouseClicked
        // Tampilan Setting
    }//GEN-LAST:event_hapusdatalaporansmbtnMouseClicked

    private void tabelbarangtrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangtrMouseClicked
        // Tampilan Transaksi
        int baris = tabelbarangtr.rowAtPoint(evt.getPoint());
        if (tabelbarangtr.getValueAt(baris, 1)==null){
            idbarangtrfield.setText("");
        } else {
            idbarangtrfield.setText(tabelbarangtr.getValueAt(baris, 1).toString());
        }
        if (tabelbarangtr.getValueAt(baris, 2)==null){
            namabarangtrfield.setText("");
        } else {
            namabarangtrfield.setText(tabelbarangtr.getValueAt(baris, 2).toString());
        }
        if (tabelbarangtr.getValueAt(baris, 3)==null){
            hargatrfield.setText("");
        } else {
            hargatrfield.setText(tabelbarangtr.getValueAt(baris, 3).toString());
        }
    }//GEN-LAST:event_tabelbarangtrMouseClicked

    private void tambahkantrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahkantrbtnMouseClicked
        // Tampilan Transaksi
        String harga = hargatrfield.getText();
        String jumlah = jumlahtrfield.getText();
        int hargaa = Integer.parseInt(harga);
        
        try {
            int jumlahh = Integer.parseInt(jumlah);
            int totalh = hargaa * jumlahh;
            String totalhrg = Integer.toString(totalh);
            totalbelanjafield.setText(totalhrg);
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Hanya Masukkan Angka Goblok!!!");
            jumlahtrfield.setText(null);
        }
        
        try {        
        String sql1 = "INSERT INTO pembeli VALUES('"+idpembelitrfield.getText()+"','"+namapembelitrfield.getText()+"')";
        String sql2 = "INSERT INTO transaksi (idtransaksi, idpembeli, idalatmusik, namaalatmusik, harga, qty, totalbayar) VALUES ('"+idtransaksitrfield.getText()+"','"+idpembelitrfield.getText()+"','"
                +idbarangtrfield.getText()+"','"+namabarangtrfield.getText()+"',"+hargatrfield.getText()+","+jumlahtrfield.getText()+","+totalbelanjafield.getText()+")";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
        pst1.execute();
        pst2.execute();
        JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
        DefaultTableModel model = (DefaultTableModel)tabelkeranjang.getModel();
        model.setRowCount(0);
        load_tabelkeranjang();
        lebar_tabelkeranjang();
        jumlahtrfield.setText(null);
//        kelas.autoidbarang();
        
    } catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
        
    String procedures = "CALL `total_belanja`()";
        
        try{
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(procedures);
            java.sql.ResultSet ress = pst.executeQuery(procedures);
                while(ress.next()){
                    totalhargatrfield.setText("Rp. "+ress.getString(1));
                }
                
        }catch(SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_tambahkantrbtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BARANG;
    private javax.swing.JPanel DASHBOARD;
    private javax.swing.JLabel HSDBFORM;
    private javax.swing.JPanel LAPORANSELECT1;
    private javax.swing.JPanel LAPORANSELECT2;
    private javax.swing.JPanel LAPORANTOTAL;
    private javax.swing.JPanel SETTING;
    private javax.swing.JPanel SUPPLIER;
    private javax.swing.JPanel TRANSAKSI;
    private javax.swing.JLabel VivaceIcon;
    private javax.swing.JTextField alamatsupplierfield;
    private javax.swing.JLabel angkabrterjual;
    private javax.swing.JLabel angkadibeli;
    private javax.swing.JLabel angkajumlah;
    private javax.swing.JLabel angkapembelian1thn;
    private javax.swing.JLabel angkapenjualan1hr;
    private javax.swing.JLabel angkapenjualan1thn;
    private javax.swing.JLabel angkastok;
    private javax.swing.JLabel angkatotalpembelian;
    private javax.swing.JPanel barangbtn;
    private javax.swing.JLabel barangmenu;
    private javax.swing.JLabel barangpic;
    private javax.swing.JTextField bayartrfield;
    private javax.swing.JLabel bgBarang;
    private javax.swing.JLabel bgDashboard;
    private javax.swing.JLabel bgLaporanselect;
    private javax.swing.JLabel bgLaporanselect2;
    private javax.swing.JLabel bgLaporantotal;
    private javax.swing.JLabel bgSetting;
    private javax.swing.JLabel bgSupplier;
    private javax.swing.JLabel bgTransaksi;
    private javax.swing.JPanel caribrbtn;
    private javax.swing.JTextField carifield;
    private javax.swing.JTextField carisettingfield;
    private javax.swing.JPanel carispbtn;
    private javax.swing.JPanel caristbtn;
    private javax.swing.JTextField carisupplierfield;
    private javax.swing.JPanel dashboardbtn;
    private javax.swing.JLabel dashboardmenu;
    private javax.swing.JLabel dashboardpic;
    private javax.swing.JPanel exportbrbtn;
    private javax.swing.JPanel exportspbtn;
    private javax.swing.JPanel exportstbtn;
    private javax.swing.JLabel eyehide;
    private javax.swing.JLabel eyeshow;
    private javax.swing.JComboBox<String> hakaksescb;
    private javax.swing.JPanel hapusbrbtn;
    private javax.swing.JPanel hapusdatabarangbtn;
    private javax.swing.JPanel hapusdatalaporanpjbtn;
    private javax.swing.JPanel hapusdatalaporansmbtn;
    private javax.swing.JPanel hapusdatasupplierbtn;
    private javax.swing.JPanel hapusspbtn;
    private javax.swing.JPanel hapusstbtn;
    private javax.swing.JTextField hargabelifield;
    private javax.swing.JTextField hargajualfield;
    private javax.swing.JTextField hargatrfield;
    public javax.swing.JTextField idbarangfield;
    private javax.swing.JTextField idbarangtrfield;
    private javax.swing.JTextField idkaryawanstfield;
    private javax.swing.JTextField idpembelitrfield;
    private javax.swing.JTextField idsupplierfield;
    private javax.swing.JTextField idtransaksitrfield;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jPane;
    private javax.swing.JScrollPane jPane1;
    private javax.swing.JScrollPane jPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jumlahtrfield;
    private javax.swing.JPanel keluarbtn;
    private javax.swing.JLabel keluarmenu;
    private javax.swing.JTextField kembaliantrfield;
    private javax.swing.JTextField keterangansupplierfield;
    private javax.swing.JPanel laporanbtn;
    private javax.swing.JLabel laporanmenu;
    private javax.swing.JLabel laporanpic;
    private javax.swing.JLabel laporanpic1;
    private javax.swing.JLabel laporanpic2;
    private javax.swing.JComboBox<String> laporanselectcb;
    private javax.swing.JTextField namabarangfield;
    private javax.swing.JTextField namabarangtrfield;
    private javax.swing.JTextField namakaryawanstfield;
    private javax.swing.JTextField namapembelitrfield;
    private javax.swing.JTextField namasupplierfield;
    private javax.swing.JTextField notelpstfield;
    private javax.swing.JTextField notelpsupplierfield;
    private javax.swing.JPasswordField passwordstfield;
    private javax.swing.JPanel pengaturanbtn;
    private javax.swing.JLabel pengaturanmenu;
    private javax.swing.JLabel settingpic;
    private javax.swing.JTextField stokfield;
    private javax.swing.JPanel supplierbtn;
    private javax.swing.JLabel suppliermenu;
    private javax.swing.JLabel supplierpic;
    private javax.swing.JTable tabelbarang;
    private javax.swing.JTable tabelbarangtr;
    private javax.swing.JTable tabelkeranjang;
    private javax.swing.JTable tabelsetting;
    private javax.swing.JTable tabelsupplier;
    private javax.swing.JPanel tambahkanbrbtn;
    private javax.swing.JPanel tambahkanspbtn;
    private javax.swing.JPanel tambahkanstbtn;
    private javax.swing.JPanel tambahkantrbtn;
    private javax.swing.JLabel textbrterjual;
    private javax.swing.JLabel textdibeli;
    private javax.swing.JLabel textgrafik;
    private javax.swing.JLabel textgrafikthn;
    private javax.swing.JLabel textjumlah;
    private javax.swing.JLabel textpembelian1thn;
    private javax.swing.JLabel textpenjualan1hr;
    private javax.swing.JLabel textpenjualan1thn;
    private javax.swing.JLabel textstok;
    private javax.swing.JLabel texttotalpembelian;
    private com.toedter.calendar.JDateChooser tglst;
    private javax.swing.JTextField totalbelanjafield;
    private javax.swing.JTextField totalhargatrfield;
    private javax.swing.JPanel transaksibtn;
    private javax.swing.JLabel transaksimenu;
    private javax.swing.JLabel transaksipic;
    private javax.swing.JPanel updatebrbtn;
    private javax.swing.JPanel updatespbtn;
    private javax.swing.JPanel updatestbtn;
    private javax.swing.JLabel usermenu;
    // End of variables declaration//GEN-END:variables
}
