/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

package Form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class FormLaporan extends javax.swing.JPanel {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi
    Laporan Total
    */ 
    
        // Variabel dan Fungsi tanggal
        Date now = new Date(); //import java.util.Date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now), data;
        
        String location=null;
        String tglfile, filename;
        DefaultTableModel model = new DefaultTableModel();
    
    private int TampilkanJumlah1thn() {
        
         try {
                String sql = "SELECT SUM(totalharga) AS total FROM detail_transaksi WHERE YEAR(tanggal) = '"+tgl+"'";      
                java.sql.Connection conn = (Connection)Config.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                java.sql.ResultSet rs= pst.executeQuery(sql);                             

                while(rs.next()){
                    data = rs.getString("total");
                    if(data == null){
                        angkapenjualan1thn.setText("Rp. 0");
                    }else{
                        angkapenjualan1thn.setText(String.format("Rp. %,d,00", Integer.parseInt(data)));
                    }                                                     
                }
                 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
           return -1;
       }
    
    private int TampilkanBeli1thn() {
        
         try {
                String sql = "SELECT SUM(harga_total) AS total FROM detail_produkmasuk WHERE YEAR(tanggal) = '"+tgl+"'";      
                java.sql.Connection conn = (Connection)Config.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                java.sql.ResultSet rs= pst.executeQuery(sql);                             

                while(rs.next()){
                    data = rs.getString("total");
                    if(data == null){
                        angkapembelian1thn.setText("Rp. 0");
                    }else{
                         angkapembelian1thn.setText(String.format("Rp. %,d,00", Integer.parseInt(data)));
                    }                                                     
                }
                 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
           return -1;
       }
    
    private int TampilkanBarangterjual() {
        
         try {
                String sql = "SELECT SUM(jumlah) AS total FROM detail_transaksi WHERE YEAR(tanggal) = '"+tgl+"'";      
                java.sql.Connection conn = (Connection)Config.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                java.sql.ResultSet rs= pst.executeQuery(sql);                             

                while(rs.next()){
                    data = rs.getString("total");
                    if(data == null){
                        angkabrterjual.setText("0 Barang");
                    }else{
                        angkabrterjual.setText(data+" Barang");
                    }                                                     
                }
                 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
           return -1;
       }
    
    private int TampilkanBarangdibeli() {
        
         try {
                String sql = "SELECT SUM(stok_masuk) AS total FROM detail_produkmasuk WHERE YEAR(tanggal) = '"+tgl+"'";      
                java.sql.Connection conn = (Connection)Config.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                java.sql.ResultSet rs= pst.executeQuery(sql);                             

                while(rs.next()){
                    data = rs.getString("total");
                    if(data == null){
                        angkadibeli.setText("0 Barang");
                    }else{
                        angkadibeli.setText(data+" Barang");
                    }                                                     
                }
                 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
           return -1;
       }
    
    private void fileChooserLP(){
        JFileChooser path = new JFileChooser();
        path.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try{
                File f = path.getSelectedFile();
                location = f.getAbsolutePath();
                txtlokasiLP.setText(location + "_" + date +".xls");
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Perintah tidak valid/dibatalkan.","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
    }
    
    private void fileChooserLSM(){
        JFileChooser path = new JFileChooser();
        path.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try{
                File f = path.getSelectedFile();
                location = f.getAbsolutePath();
                txtlokasiLSM.setText(location + "_" + date +".xls");
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Perintah tidak valid/dibatalkan.","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
    }
    
    private void fileChooserLPPDF(){
        JFileChooser path = new JFileChooser();
        path.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try{
                File f = path.getSelectedFile();
                location = f.getAbsolutePath();
                txtlokasiLPPDF.setText(location + "_" + date +".xls");
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Perintah tidak valid/dibatalkan.","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
    }
    
    private void fileChooserLSMPDF(){
        JFileChooser path = new JFileChooser();
        path.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try{
                File f = path.getSelectedFile();
                location = f.getAbsolutePath();
                txtlokasiLSMPDF.setText(location + "_" + date +".xls");
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Perintah tidak valid/dibatalkan.","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
    }
    
    private void Grafik(){
        try{
            //tanggal
            Date date = new Date();
            DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
            Calendar cal =Calendar.getInstance();
            cal.add(Calendar.MONTH, -12);
            String sekarang = formattanggal.format(date);
            String satuTahunLalu = formattanggal.format(cal.getTime());
            
            //query
            String query = "SELECT tanggal, COUNT(tanggal) AS total FROM transaksi WHERE tanggal BETWEEN '"+satuTahunLalu+"' AND '"+sekarang+"' GROUP BY tanggal";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(Config.configDB(), query);
            JFreeChart grafik = ChartFactory.createLineChart("", "Bulan", "Jumlah", dataset, PlotOrientation.VERTICAL, false, true, true);
            
            //set warna background
            Color au = new Color(244, 239, 239);
            grafik.getPlot().setBackgroundPaint(au);
            grafik.setBackgroundPaint(au);
            
            //ganti warna garis
            CategoryPlot plot = (CategoryPlot) grafik.getPlot();
            plot.getRenderer().setSeriesPaint(0, Color.DARK_GRAY);
            
            //set grafik di panel 
            ChartPanel panel = new ChartPanel(grafik);
            GrafikPanel.add(panel);
            panel.setPreferredSize(new Dimension(1445, 174));
            panel.setVisible(true);
        } catch(SQLException e){
            System.out.println(e);
        }}
    
    private void Grafik1(){
        try{
            //tanggal
            Date date = new Date();
            DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
            Calendar cal =Calendar.getInstance();
            cal.add(Calendar.MONTH, -12);
            String sekarang = formattanggal.format(date);
            String satuTahunLalu = formattanggal.format(cal.getTime());
            
            //query
            String query = "SELECT tanggal, SUM(jumlah) AS total FROM detail_transaksi WHERE tanggal BETWEEN '"+satuTahunLalu+"' AND '"+sekarang+"' GROUP BY tanggal";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(Config.configDB(), query);
            JFreeChart grafik = ChartFactory.createLineChart("", "Bulan", "Jumlah", dataset, PlotOrientation.VERTICAL, false, true, true);
            
            //set warna background
            Color au = new Color(244, 239, 239);
            grafik.getPlot().setBackgroundPaint(au);
            grafik.setBackgroundPaint(au);
            
            //ganti warna garis
            CategoryPlot plot = (CategoryPlot) grafik.getPlot();
            plot.getRenderer().setSeriesPaint(0, Color.DARK_GRAY);
            
            //set grafik di panel 
            ChartPanel panel = new ChartPanel(grafik);
            GrafikPanel1.add(panel);
            panel.setPreferredSize(new Dimension(1445, 174));
            panel.setVisible(true);
        } catch(SQLException e){
            System.out.println(e);
        }}
    
    private void Grafik2(){
        try{
            //tanggal
            Date date = new Date();
            DateFormat formattanggal = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal =Calendar.getInstance();
            cal.add(Calendar.MONTH, -12);
            String sekarang = formattanggal.format(date);
            String satuTahunLalu = formattanggal.format(cal.getTime());
            
            //query
            String query = "SELECT tanggal, SUM(totalharga) AS total FROM detail_transaksi WHERE tanggal BETWEEN '"+satuTahunLalu+"' AND '"+sekarang+"' GROUP BY tanggal";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(Config.configDB(), query);
            JFreeChart grafik = ChartFactory.createLineChart("", "Bulan", "Jumlah", dataset, PlotOrientation.VERTICAL, false, true, true);
            
            //set warna background
            Color au = new Color(244, 239, 239);
            grafik.getPlot().setBackgroundPaint(au);
            grafik.setBackgroundPaint(au);
            
            //ganti warna garis
            CategoryPlot plot = (CategoryPlot) grafik.getPlot();
            plot.getRenderer().setSeriesPaint(0, Color.DARK_GRAY);
            
            //set grafik di panel 
            ChartPanel panel = new ChartPanel(grafik);
            GrafikPanel2.add(panel);
            panel.setPreferredSize(new Dimension(1445, 174));
            panel.setVisible(true);
        } catch(SQLException e){
            System.out.println(e);
        }}
    
    /*----------------------------------------------------------------------------------------------------------------------
    Laporan Penjualan
    */ 
    
    private void load_tabelLP() {
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("ID Pembeli");
        model.addColumn("Nama Pembeli");
        model.addColumn("ID Alat Musik");
        model.addColumn("Nama Alat Musik");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");
        model.addColumn("Tanggal");
        
        try { 
            int no = 1;
            String sql2 = "SELECT transaksi.idtransaksi, pembeli.idpembeli, pembeli.namapembeli, alatmusik.idalatmusik, alatmusik.namaalatmusik, detail_transaksi.harga, detail_transaksi.jumlah, detail_transaksi.totalharga, detail_transaksi.tanggal\n" +
                          "FROM transaksi JOIN detail_transaksi ON transaksi.idtransaksi = detail_transaksi.idtransaksi\n" +
                          "JOIN pembeli ON pembeli.idpembeli = transaksi.idpembeli\n" +
                          "JOIN alatmusik ON alatmusik.idalatmusik = detail_transaksi.idalatmusik ORDER BY transaksi.idtransaksi";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm2 = conn.createStatement();
            java.sql.ResultSet res2 = stm2.executeQuery(sql2);
            while (res2.next()){
                model.addRow (new Object[] {no++, res2.getString(1), res2.getString(2), res2.getString(3), res2.getString(4),
                    res2.getString(5), res2.getString(6), ("- " +res2.getString(7)), res2.getString(8), res2.getString(9)});
            }
        tabelLP.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabelLP(){
        TableColumn kolom;
        tabelLP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabelLP.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(30);
        kolom = tabelLP.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(100);
        kolom = tabelLP.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(100);
        kolom = tabelLP.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(150);
        kolom = tabelLP.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(100);
        kolom = tabelLP.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(200);
        kolom = tabelLP.getColumnModel().getColumn(6); 
        kolom.setPreferredWidth(150);
        kolom = tabelLP.getColumnModel().getColumn(7); 
        kolom.setPreferredWidth(100);
        kolom = tabelLP.getColumnModel().getColumn(8); 
        kolom.setPreferredWidth(150);
        kolom = tabelLP.getColumnModel().getColumn(9); 
        kolom.setPreferredWidth(150);
    }
    
    private void tampilkan_tabelLP() {
   
        String tanggal = ((JTextField)date1LP.getDateEditor().getUiComponent()).getText();
        String tanggal2 = ((JTextField)date2LP.getDateEditor().getUiComponent()).getText();
            
        try {
        String sql1 = "SELECT transaksi.idtransaksi, pembeli.idpembeli, pembeli.namapembeli, alatmusik.idalatmusik, alatmusik.namaalatmusik, detail_transaksi.harga, detail_transaksi.jumlah, detail_transaksi.totalharga, detail_transaksi.tanggal\n" +
                      "FROM transaksi JOIN detail_transaksi ON transaksi.idtransaksi = detail_transaksi.idtransaksi\n" +
                      "JOIN pembeli ON pembeli.idpembeli = transaksi.idpembeli\n" +
                      "JOIN alatmusik ON alatmusik.idalatmusik = detail_transaksi.idalatmusik WHERE transaksi.tanggal BETWEEN '"+tanggal+"' AND '"+tanggal2+"' ORDER BY transaksi.idtransaksi";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.ResultSet res1 = pst1.executeQuery(sql1);
        DefaultTableModel model = (DefaultTableModel)tabelLP.getModel();
        model.setRowCount(0);
            int no = 1;
            while (res1.next()){
                model.addRow (new Object[] {no++, res1.getString(1),res1.getString(2), res1.getString(3), 
                    res1.getString(4), res1.getString(5),res1.getString(6), ("- " +res1.getString(7)),res1.getString(8), res1.getString(9)});
            }
        tabelLP.setModel(model);
        } catch (SQLException ex) {
    }    
    }
    
    /*----------------------------------------------------------------------------------------------------------------------
    Laporan Stok Masuk
    */ 
    
    private void load_tabelLSM() {
        model.addColumn("No");
        model.addColumn("ID Produk Masuk");
        model.addColumn("ID Supplier");
        model.addColumn("Nama Supplier");
        model.addColumn("ID Alat Musik");
        model.addColumn("Nama Alat Musik");
        model.addColumn("Harga Beli");
        model.addColumn("Stok Masuk");
        model.addColumn("Harga Total");
        model.addColumn("Tanggal");
        
        try { 
            int no = 1;
            String sql = "SELECT produkmasuk.id_produkmasuk, supplier.id_supplier, supplier.nama_supplier, alatmusik.idalatmusik, alatmusik.namaalatmusik, detail_produkmasuk.harga_beli, detail_produkmasuk.stok_masuk, detail_produkmasuk.harga_total, produkmasuk.tgl_pembelian\n" +
                         "FROM produkmasuk JOIN detail_produkmasuk ON produkmasuk.id_produkmasuk = detail_produkmasuk.id_produkmasuk\n" +
                         "JOIN supplier ON supplier.id_supplier = produkmasuk.id_supplier\n" +
                         "JOIN alatmusik ON alatmusik.idalatmusik = detail_produkmasuk.idalatmusik ORDER BY produkmasuk.id_produkmasuk";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow (new Object[] {no++, res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), ("+ " +res.getString(7)), res.getString(8), res.getString(9)});
            }
        tabelLSM.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabelLSM(){
        TableColumn kolom;
        tabelLSM.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabelLSM.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(30);
        kolom = tabelLSM.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(100);
        kolom = tabelLSM.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(100);
        kolom = tabelLSM.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(150);
        kolom = tabelLSM.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(100);
        kolom = tabelLSM.getColumnModel().getColumn(5); 
        kolom.setPreferredWidth(200);
        kolom = tabelLSM.getColumnModel().getColumn(6); 
        kolom.setPreferredWidth(150);
        kolom = tabelLSM.getColumnModel().getColumn(7); 
        kolom.setPreferredWidth(100);
        kolom = tabelLSM.getColumnModel().getColumn(8); 
        kolom.setPreferredWidth(150);
        kolom = tabelLSM.getColumnModel().getColumn(9); 
        kolom.setPreferredWidth(150);
    }
    
    private void tampilkan_tabelLSM() {
   
        String tanggal = ((JTextField)date1LSM.getDateEditor().getUiComponent()).getText();
        String tanggal2 = ((JTextField)date1LSM.getDateEditor().getUiComponent()).getText();
            
        try {
        String sql1 = "SELECT produkmasuk.id_produkmasuk, supplier.id_supplier, supplier.nama_supplier, alatmusik.idalatmusik, alatmusik.namaalatmusik, detail_produkmasuk.harga_beli, detail_produkmasuk.stok_masuk, detail_produkmasuk.harga_total, produkmasuk.tgl_pembelian\n" +
                      "FROM produkmasuk JOIN detail_produkmasuk ON produkmasuk.id_produkmasuk = detail_produkmasuk.id_produkmasuk\n" +
                      "JOIN supplier ON supplier.id_supplier = produkmasuk.id_supplier\n" +
                      "JOIN alatmusik ON alatmusik.idalatmusik = detail_produkmasuk.idalatmusik WHERE produkmasuk.tgl_pembelian BETWEEN '"+tanggal+"' AND '"+tanggal2+"' ORDER BY produkmasuk.id_produkmasuk";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.ResultSet res1 = pst1.executeQuery(sql1);
        DefaultTableModel model = (DefaultTableModel)tabelLSM.getModel();
        model.setRowCount(0);
            int no = 1;
            while (res1.next()){
                model.addRow (new Object[] {no++, res1.getString(1),res1.getString(2), res1.getString(3), 
                    res1.getString(4), res1.getString(5),res1.getString(6), ("+ " +res1.getString(7)),res1.getString(8), res1.getString(9)});
            }
        tabelLSM.setModel(model);
        } catch (SQLException ex) {
    }    
    }
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 

    public FormLaporan() {
        initComponents();
        model.setRowCount(0);
        model.setColumnCount(0);
        panelLT.setVisible(true);
        panelLP.setVisible(false);
        panelLSM.setVisible(false);
        TampilkanJumlah1thn();
        TampilkanBeli1thn();
        TampilkanBarangterjual();
        TampilkanBarangdibeli();
        Grafik();
        Grafik1();
        Grafik2();
        panelE.setVisible(false);
        GrafikPanel1.setVisible(false);
        GrafikPanel2.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Laporancb = new javax.swing.JComboBox<>();
        panelLT = new javax.swing.JPanel();
        angkapenjualan1thn = new javax.swing.JLabel();
        textpenjualan1hr = new javax.swing.JLabel();
        angkapembelian1thn = new javax.swing.JLabel();
        angkabrterjual = new javax.swing.JLabel();
        textstok = new javax.swing.JLabel();
        angkadibeli = new javax.swing.JLabel();
        textstokmasuk = new javax.swing.JLabel();
        textpembeli1 = new javax.swing.JLabel();
        txtgrafik = new javax.swing.JLabel();
        txttampilkan = new javax.swing.JLabel();
        dashboardcb = new javax.swing.JComboBox<>();
        GrafikPanel1 = new javax.swing.JPanel();
        GrafikPanel = new javax.swing.JPanel();
        bgLT = new javax.swing.JLabel();
        panelLP = new javax.swing.JPanel();
        date2LP = new com.toedter.calendar.JDateChooser();
        date1LP = new com.toedter.calendar.JDateChooser();
        btnCariLP = new javax.swing.JLabel();
        txtCariLP = new javax.swing.JTextField();
        btnTampilkanLP = new javax.swing.JLabel();
        btnUbahLP = new javax.swing.JLabel();
        btnEksporLP = new javax.swing.JLabel();
        txtlokasiLP = new javax.swing.JTextField();
        btnUbahLPPDF = new javax.swing.JLabel();
        btnEksporLPPDF = new javax.swing.JLabel();
        txtlokasiLPPDF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelLP = new javax.swing.JTable();
        bgLP = new javax.swing.JLabel();
        panelLSM = new javax.swing.JPanel();
        date2LSM = new com.toedter.calendar.JDateChooser();
        date1LSM = new com.toedter.calendar.JDateChooser();
        btnCariLSM = new javax.swing.JLabel();
        txtCariLSM = new javax.swing.JTextField();
        btnTampilkanLSM = new javax.swing.JLabel();
        btnUbahLSM = new javax.swing.JLabel();
        btnEksporLSM = new javax.swing.JLabel();
        txtlokasiLSM = new javax.swing.JTextField();
        btnUbahLSMPDF = new javax.swing.JLabel();
        btnEksporLSMPDF = new javax.swing.JLabel();
        txtlokasiLSMPDF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelLSM = new javax.swing.JTable();
        bgLSM = new javax.swing.JLabel();
        panelE = new javax.swing.JPanel();
        txtgrafik1 = new javax.swing.JLabel();
        txttampilkan1 = new javax.swing.JLabel();
        dashboardcb1 = new javax.swing.JComboBox<>();
        GrafikPanel2 = new javax.swing.JPanel();
        bgDashboard1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Laporancb.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        Laporancb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laporan Total", "Laporan Penjualan", "Laporan Stok Masuk" }));
        Laporancb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporancbActionPerformed(evt);
            }
        });
        add(Laporancb, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 50, 400, 45));

        panelLT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        angkapenjualan1thn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapenjualan1thn.setText("Rp.0,0");
        panelLT.add(angkapenjualan1thn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 640, 80));

        textpenjualan1hr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpenjualan1hr.setForeground(new java.awt.Color(130, 130, 130));
        textpenjualan1hr.setText("Penjualan Selama Satu Tahun");
        panelLT.add(textpenjualan1hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 490, -1));

        angkapembelian1thn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapembelian1thn.setText("Rp.0,0");
        panelLT.add(angkapembelian1thn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 640, 50));

        angkabrterjual.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkabrterjual.setText("0 Barang");
        panelLT.add(angkabrterjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 640, 80));

        textstok.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textstok.setForeground(new java.awt.Color(130, 130, 130));
        textstok.setText("Jumlah Barang Terjual");
        panelLT.add(textstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 490, -1));

        angkadibeli.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkadibeli.setText("0 Barang");
        panelLT.add(angkadibeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 640, 50));

        textstokmasuk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textstokmasuk.setForeground(new java.awt.Color(130, 130, 130));
        textstokmasuk.setText("Jumlah Barang Dibeli");
        panelLT.add(textstokmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 520, 490, -1));

        textpembeli1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpembeli1.setForeground(new java.awt.Color(130, 130, 130));
        textpembeli1.setText("Pembelian Selama Satu Tahun");
        panelLT.add(textpembeli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 490, -1));

        txtgrafik.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtgrafik.setText("Grafik Pembeli Selama 12 Bulan");
        panelLT.add(txtgrafik, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, 490, -1));

        txttampilkan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txttampilkan.setText("Tampilkan :");
        panelLT.add(txttampilkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 660, 100, 25));

        dashboardcb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dashboardcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grafik Pembeli Selama 12 Bulan", "Grafik Barang Terjual Selama 12 Bulan", "Grafik Total Penjualan Selama 12 Bulan" }));
        dashboardcb.setBorder(null);
        dashboardcb.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dashboardcb.setOpaque(false);
        dashboardcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardcbActionPerformed(evt);
            }
        });
        panelLT.add(dashboardcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1124, 657, 370, 30));

        GrafikPanel1.setOpaque(false);
        GrafikPanel1.setLayout(new javax.swing.BoxLayout(GrafikPanel1, javax.swing.BoxLayout.LINE_AXIS));
        panelLT.add(GrafikPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 1450, 230));

        GrafikPanel.setOpaque(false);
        GrafikPanel.setLayout(new javax.swing.BoxLayout(GrafikPanel, javax.swing.BoxLayout.LINE_AXIS));
        panelLT.add(GrafikPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 1450, 230));

        bgLT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Laporan Total.png"))); // NOI18N
        bgLT.setText("Pembelian Selama Satu Tahun");
        panelLT.add(bgLT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(panelLT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        panelLP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date2LP.setDateFormatString("yyyy-MM-dd");
        date2LP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelLP.add(date2LP, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 260, 40));

        date1LP.setDateFormatString("yyyy-MM-dd");
        date1LP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelLP.add(date1LP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 139, 260, 40));

        btnCariLP.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnCariLP.setForeground(new java.awt.Color(95, 95, 95));
        btnCariLP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCariLP.setText("CARI");
        btnCariLP.setPreferredSize(new java.awt.Dimension(104, 36));
        btnCariLP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCariLPMouseMoved(evt);
            }
        });
        btnCariLP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariLPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCariLPMouseExited(evt);
            }
        });
        panelLP.add(btnCariLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 140, 126, 38));

        txtCariLP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCariLP.setBorder(null);
        txtCariLP.setOpaque(false);
        txtCariLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariLPActionPerformed(evt);
            }
        });
        panelLP.add(txtCariLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 140, 240, 38));

        btnTampilkanLP.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnTampilkanLP.setForeground(new java.awt.Color(95, 95, 95));
        btnTampilkanLP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTampilkanLP.setText("TAMPILKAN");
        btnTampilkanLP.setPreferredSize(new java.awt.Dimension(104, 36));
        btnTampilkanLP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTampilkanLPMouseMoved(evt);
            }
        });
        btnTampilkanLP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTampilkanLPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTampilkanLPMouseExited(evt);
            }
        });
        panelLP.add(btnTampilkanLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 139, 172, 40));

        btnUbahLP.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnUbahLP.setForeground(new java.awt.Color(95, 95, 95));
        btnUbahLP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbahLP.setText("UBAH");
        btnUbahLP.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnUbahLP.setPreferredSize(new java.awt.Dimension(104, 36));
        btnUbahLP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUbahLPMouseMoved(evt);
            }
        });
        btnUbahLP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahLPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahLPMouseExited(evt);
            }
        });
        panelLP.add(btnUbahLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 904, 120, 30));

        btnEksporLP.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnEksporLP.setForeground(new java.awt.Color(95, 95, 95));
        btnEksporLP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEksporLP.setText("EKSPOR");
        btnEksporLP.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEksporLP.setPreferredSize(new java.awt.Dimension(104, 36));
        btnEksporLP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEksporLPMouseMoved(evt);
            }
        });
        btnEksporLP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEksporLPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEksporLPMouseExited(evt);
            }
        });
        panelLP.add(btnEksporLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 904, 120, 30));

        txtlokasiLP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtlokasiLP.setBorder(null);
        txtlokasiLP.setOpaque(false);
        panelLP.add(txtlokasiLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 940, 580, 40));

        btnUbahLPPDF.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnUbahLPPDF.setForeground(new java.awt.Color(95, 95, 95));
        btnUbahLPPDF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbahLPPDF.setText("UBAH");
        btnUbahLPPDF.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnUbahLPPDF.setPreferredSize(new java.awt.Dimension(104, 36));
        btnUbahLPPDF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUbahLPPDFMouseMoved(evt);
            }
        });
        btnUbahLPPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahLPPDFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahLPPDFMouseExited(evt);
            }
        });
        panelLP.add(btnUbahLPPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1264, 904, 120, 30));

        btnEksporLPPDF.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnEksporLPPDF.setForeground(new java.awt.Color(95, 95, 95));
        btnEksporLPPDF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEksporLPPDF.setText("EKSPOR");
        btnEksporLPPDF.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEksporLPPDF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEksporLPPDF.setPreferredSize(new java.awt.Dimension(104, 36));
        btnEksporLPPDF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEksporLPPDFMouseMoved(evt);
            }
        });
        btnEksporLPPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEksporLPPDFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEksporLPPDFMouseExited(evt);
            }
        });
        panelLP.add(btnEksporLPPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 904, 120, 30));

        txtlokasiLPPDF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtlokasiLPPDF.setBorder(null);
        txtlokasiLPPDF.setOpaque(false);
        panelLP.add(txtlokasiLPPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(939, 940, 580, 40));

        tabelLP.setBackground(new java.awt.Color(244, 239, 224));
        tabelLP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabelLP.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelLP.setGridColor(new java.awt.Color(199, 199, 199));
        tabelLP.setRowHeight(18);
        tabelLP.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabelLP.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabelLP);

        panelLP.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 1490, 680));

        bgLP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Laporan.png"))); // NOI18N
        bgLP.setText("Pembelian Selama Satu Tahun");
        panelLP.add(bgLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(panelLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        panelLSM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date2LSM.setDateFormatString("yyyy-MM-dd");
        date2LSM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelLSM.add(date2LSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 260, 40));

        date1LSM.setDateFormatString("yyyy-MM-dd");
        date1LSM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelLSM.add(date1LSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 139, 260, 40));

        btnCariLSM.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnCariLSM.setForeground(new java.awt.Color(95, 95, 95));
        btnCariLSM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCariLSM.setText("CARI");
        btnCariLSM.setPreferredSize(new java.awt.Dimension(104, 36));
        btnCariLSM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCariLSMMouseMoved(evt);
            }
        });
        btnCariLSM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariLSMMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCariLSMMouseExited(evt);
            }
        });
        panelLSM.add(btnCariLSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 140, 126, 38));

        txtCariLSM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCariLSM.setBorder(null);
        txtCariLSM.setOpaque(false);
        txtCariLSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariLSMActionPerformed(evt);
            }
        });
        panelLSM.add(txtCariLSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 140, 240, 38));

        btnTampilkanLSM.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnTampilkanLSM.setForeground(new java.awt.Color(95, 95, 95));
        btnTampilkanLSM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTampilkanLSM.setText("TAMPILKAN");
        btnTampilkanLSM.setPreferredSize(new java.awt.Dimension(104, 36));
        btnTampilkanLSM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTampilkanLSMMouseMoved(evt);
            }
        });
        btnTampilkanLSM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTampilkanLSMMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTampilkanLSMMouseExited(evt);
            }
        });
        panelLSM.add(btnTampilkanLSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 139, 172, 40));

        btnUbahLSM.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnUbahLSM.setForeground(new java.awt.Color(95, 95, 95));
        btnUbahLSM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbahLSM.setText("UBAH");
        btnUbahLSM.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnUbahLSM.setPreferredSize(new java.awt.Dimension(104, 36));
        btnUbahLSM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUbahLSMMouseMoved(evt);
            }
        });
        btnUbahLSM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahLSMMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahLSMMouseExited(evt);
            }
        });
        panelLSM.add(btnUbahLSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 904, 120, 30));

        btnEksporLSM.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnEksporLSM.setForeground(new java.awt.Color(95, 95, 95));
        btnEksporLSM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEksporLSM.setText("EKSPOR");
        btnEksporLSM.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEksporLSM.setPreferredSize(new java.awt.Dimension(104, 36));
        btnEksporLSM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEksporLSMMouseMoved(evt);
            }
        });
        btnEksporLSM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEksporLSMMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEksporLSMMouseExited(evt);
            }
        });
        panelLSM.add(btnEksporLSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 904, 120, 30));

        txtlokasiLSM.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtlokasiLSM.setBorder(null);
        txtlokasiLSM.setOpaque(false);
        panelLSM.add(txtlokasiLSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 940, 580, 40));

        btnUbahLSMPDF.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnUbahLSMPDF.setForeground(new java.awt.Color(95, 95, 95));
        btnUbahLSMPDF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbahLSMPDF.setText("UBAH");
        btnUbahLSMPDF.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnUbahLSMPDF.setPreferredSize(new java.awt.Dimension(104, 36));
        btnUbahLSMPDF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUbahLSMPDFMouseMoved(evt);
            }
        });
        btnUbahLSMPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahLSMPDFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahLSMPDFMouseExited(evt);
            }
        });
        panelLSM.add(btnUbahLSMPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1264, 904, 120, 30));

        btnEksporLSMPDF.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnEksporLSMPDF.setForeground(new java.awt.Color(95, 95, 95));
        btnEksporLSMPDF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEksporLSMPDF.setText("EKSPOR");
        btnEksporLSMPDF.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEksporLSMPDF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEksporLSMPDF.setPreferredSize(new java.awt.Dimension(104, 36));
        btnEksporLSMPDF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEksporLSMPDFMouseMoved(evt);
            }
        });
        btnEksporLSMPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEksporLSMPDFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEksporLSMPDFMouseExited(evt);
            }
        });
        panelLSM.add(btnEksporLSMPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 904, 120, 30));

        txtlokasiLSMPDF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtlokasiLSMPDF.setBorder(null);
        txtlokasiLSMPDF.setOpaque(false);
        panelLSM.add(txtlokasiLSMPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(939, 940, 580, 40));

        tabelLSM.setBackground(new java.awt.Color(244, 239, 224));
        tabelLSM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabelLSM.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelLSM.setGridColor(new java.awt.Color(199, 199, 199));
        tabelLSM.setRowHeight(18);
        tabelLSM.setSelectionBackground(new java.awt.Color(194, 184, 156));
        tabelLSM.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tabelLSM);

        panelLSM.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 1490, 680));

        bgLSM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Laporan.png"))); // NOI18N
        bgLSM.setText("Pembelian Selama Satu Tahun");
        panelLSM.add(bgLSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(panelLSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        panelE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtgrafik1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtgrafik1.setText("Grafik Total Penjualan Selama 7 Hari");
        panelE.add(txtgrafik1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 500, -1));

        txttampilkan1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txttampilkan1.setText("Tampilkan :");
        panelE.add(txttampilkan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 100, 25));

        dashboardcb1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dashboardcb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grafik Pembeli Selama 7 Hari", "Grafik Barang Terjual Selama 7 Hari", "Grafik Total Penjualan Selama 7 Hari" }));
        dashboardcb1.setBorder(null);
        dashboardcb1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dashboardcb1.setOpaque(false);
        dashboardcb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardcb1ActionPerformed(evt);
            }
        });
        panelE.add(dashboardcb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1124, 67, 370, 30));

        GrafikPanel2.setOpaque(false);
        GrafikPanel2.setLayout(new javax.swing.BoxLayout(GrafikPanel2, javax.swing.BoxLayout.LINE_AXIS));
        panelE.add(GrafikPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 1450, 830));

        bgDashboard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Expand.png"))); // NOI18N
        panelE.add(bgDashboard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(panelE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void LaporancbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporancbActionPerformed
    if (Laporancb.getSelectedIndex()==0){
        model.setRowCount(0);
        model.setColumnCount(0);
        panelLT.setVisible(true);
        panelLP.setVisible(false);
        panelLSM.setVisible(false);
    }
    if (Laporancb.getSelectedIndex()==1){
        model.setRowCount(0);
        model.setColumnCount(0);
        panelLT.setVisible(false);
        panelLP.setVisible(true);
        panelLSM.setVisible(false);
        load_tabelLP();
        lebar_tabelLP();
    }
    if (Laporancb.getSelectedIndex()==2){
        model.setRowCount(0);
        model.setColumnCount(0);
        panelLT.setVisible(false);
        panelLP.setVisible(false);
        panelLSM.setVisible(true);
        load_tabelLSM();
        lebar_tabelLSM();
    }
    }//GEN-LAST:event_LaporancbActionPerformed

    private void btnTampilkanLPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTampilkanLPMouseMoved
    btnTampilkanLP.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTampilkanLPMouseMoved

    private void btnTampilkanLPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTampilkanLPMouseClicked
    tampilkan_tabelLP();
    }//GEN-LAST:event_btnTampilkanLPMouseClicked

    private void btnTampilkanLPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTampilkanLPMouseExited
    btnTampilkanLP.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTampilkanLPMouseExited

    private void btnTampilkanLSMMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTampilkanLSMMouseMoved
    btnTampilkanLSM.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTampilkanLSMMouseMoved

    private void btnTampilkanLSMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTampilkanLSMMouseClicked
    tampilkan_tabelLSM();
    }//GEN-LAST:event_btnTampilkanLSMMouseClicked

    private void btnTampilkanLSMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTampilkanLSMMouseExited
    btnTampilkanLSM.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTampilkanLSMMouseExited

    private void btnCariLPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariLPMouseMoved
    btnCariLP.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCariLPMouseMoved

    private void btnCariLPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariLPMouseClicked
    try {
        String sql1 = "SELECT transaksi.idtransaksi, pembeli.idpembeli, pembeli.namapembeli, alatmusik.idalatmusik, alatmusik.namaalatmusik, detail_transaksi.harga, detail_transaksi.jumlah, detail_transaksi.totalharga, detail_transaksi.tanggal\n" +
                      "FROM transaksi JOIN detail_transaksi ON transaksi.idtransaksi = detail_transaksi.idtransaksi\n" +
                      "JOIN pembeli ON pembeli.idpembeli = transaksi.idpembeli\n" +
                      "JOIN alatmusik ON alatmusik.idalatmusik = detail_transaksi.idalatmusik WHERE transaksi.idtransaksi LIKE '%"+txtCariLP.getText()+"%' OR pembeli.idpembeli LIKE '%"+txtCariLP.getText()+"%' \n" +
                      "OR pembeli.namapembeli LIKE '%"+txtCariLP.getText()+"%' OR alatmusik.idalatmusik LIKE '%"+txtCariLP.getText()+"%' OR alatmusik.namaalatmusik LIKE '%"+txtCariLP.getText()+"%' OR detail_transaksi.harga LIKE '%"+txtCariLP.getText()+"%' \n" +
                      "OR detail_transaksi.jumlah LIKE '%"+txtCariLP.getText()+"%' OR detail_transaksi.totalharga LIKE '%"+txtCariLP.getText()+"%' OR detail_transaksi.tanggal LIKE '%"+txtCariLP.getText()+"%' ORDER BY transaksi.idtransaksi";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.ResultSet res1 = pst1.executeQuery(sql1);
        DefaultTableModel model = (DefaultTableModel)tabelLP.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
            int no = 1;
            while (res1.next()){
                model.addRow (new Object[] {no++, res1.getString(1),res1.getString(2), res1.getString(3), 
                    res1.getString(4), res1.getString(5),res1.getString(6), ("- " +res1.getString(7)),res1.getString(8), res1.getString(9)});
            }
        tabelLP.setModel(model);
        } catch (SQLException ex) {
    }    
    }//GEN-LAST:event_btnCariLPMouseClicked

    private void btnCariLPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariLPMouseExited
    btnCariLP.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCariLPMouseExited

    private void txtCariLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariLPActionPerformed
        try {
        String sql1 = "SELECT transaksi.idtransaksi, pembeli.idpembeli, pembeli.namapembeli, alatmusik.idalatmusik, alatmusik.namaalatmusik, detail_transaksi.harga, detail_transaksi.jumlah, detail_transaksi.totalharga, detail_transaksi.tanggal\n" +
                      "FROM transaksi JOIN detail_transaksi ON transaksi.idtransaksi = detail_transaksi.idtransaksi\n" +
                      "JOIN pembeli ON pembeli.idpembeli = transaksi.idpembeli\n" +
                      "JOIN alatmusik ON alatmusik.idalatmusik = detail_transaksi.idalatmusik WHERE transaksi.idtransaksi LIKE '%"+txtCariLP.getText()+"%' OR pembeli.idpembeli LIKE '%"+txtCariLP.getText()+"%' \n" +
                      "OR pembeli.namapembeli LIKE '%"+txtCariLP.getText()+"%' OR alatmusik.idalatmusik LIKE '%"+txtCariLP.getText()+"%' OR alatmusik.namaalatmusik LIKE '%"+txtCariLP.getText()+"%' OR detail_transaksi.harga LIKE '%"+txtCariLP.getText()+"%' \n" +
                      "OR detail_transaksi.jumlah LIKE '%"+txtCariLP.getText()+"%' OR detail_transaksi.totalharga LIKE '%"+txtCariLP.getText()+"%' OR detail_transaksi.tanggal LIKE '%"+txtCariLP.getText()+"%' ORDER BY transaksi.idtransaksi";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.ResultSet res1 = pst1.executeQuery(sql1);
        DefaultTableModel model = (DefaultTableModel)tabelLP.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
            int no = 1;
            while (res1.next()){
                model.addRow (new Object[] {no++, res1.getString(1),res1.getString(2), res1.getString(3), 
                    res1.getString(4), res1.getString(5),res1.getString(6), ("- " +res1.getString(7)),res1.getString(8), res1.getString(9)});
            }
        tabelLP.setModel(model);
        } catch (SQLException ex) {
    }    
    }//GEN-LAST:event_txtCariLPActionPerformed

    private void btnCariLSMMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariLSMMouseMoved
    btnCariLSM.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCariLSMMouseMoved

    private void btnCariLSMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariLSMMouseClicked
    try {
        String sql1 = "SELECT produkmasuk.id_produkmasuk, supplier.id_supplier, supplier.nama_supplier, alatmusik.idalatmusik, alatmusik.namaalatmusik, detail_produkmasuk.harga_beli, detail_produkmasuk.stok_masuk, detail_produkmasuk.harga_total, produkmasuk.tgl_pembelian\n" +
                      "FROM produkmasuk JOIN detail_produkmasuk ON produkmasuk.id_produkmasuk = detail_produkmasuk.id_produkmasuk\n" +
                      "JOIN supplier ON supplier.id_supplier = produkmasuk.id_supplier\n" +
                      "JOIN alatmusik ON alatmusik.idalatmusik = detail_produkmasuk.idalatmusik WHERE produkmasuk.id_produkmasuk LIKE '%"+btnCariLSM.getText()+"%' OR supplier.id_supplier LIKE '%"+btnCariLSM.getText()+"%' \n" +
                      "OR supplier.nama_supplier LIKE '%"+btnCariLSM.getText()+"%' OR alatmusik.idalatmusik LIKE '%"+btnCariLSM.getText()+"%' OR alatmusik.namaalatmusik LIKE '%"+btnCariLSM.getText()+"%' OR detail_produkmasuk.harga_beli LIKE '%"+btnCariLSM.getText()+"%' \n" +
                      "OR detail_produkmasuk.stok_masuk LIKE '%"+btnCariLSM.getText()+"%' OR detail_produkmasuk.harga_total LIKE '%"+btnCariLSM.getText()+"%' OR produkmasuk.tgl_pembelian LIKE '%"+btnCariLSM.getText()+"%' ORDER BY produkmasuk.id_produkmasuk";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.ResultSet res1 = pst1.executeQuery(sql1);
        model.setRowCount(0);
        model.setColumnCount(0);
            int no = 1;
            while (res1.next()){
                model.addRow (new Object[] {no++, res1.getString(1),res1.getString(2), res1.getString(3), 
                    res1.getString(4), res1.getString(5),res1.getString(6), ("+ " +res1.getString(7)),res1.getString(8), res1.getString(9)});
            }
        tabelLSM.setModel(model);
        } catch (SQLException ex) {
    }
    }//GEN-LAST:event_btnCariLSMMouseClicked

    private void btnCariLSMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariLSMMouseExited
    btnCariLSM.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCariLSMMouseExited

    private void txtCariLSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariLSMActionPerformed
    try {
        String sql1 = "SELECT produkmasuk.id_produkmasuk, supplier.id_supplier, supplier.nama_supplier, alatmusik.idalatmusik, alatmusik.namaalatmusik, detail_produkmasuk.harga_beli, detail_produkmasuk.stok_masuk, detail_produkmasuk.harga_total, produkmasuk.tgl_pembelian\n" +
                      "FROM produkmasuk JOIN detail_produkmasuk ON produkmasuk.id_produkmasuk = detail_produkmasuk.id_produkmasuk\n" +
                      "JOIN supplier ON supplier.id_supplier = produkmasuk.id_supplier\n" +
                      "JOIN alatmusik ON alatmusik.idalatmusik = detail_produkmasuk.idalatmusik WHERE produkmasuk.id_produkmasuk LIKE '%"+btnCariLSM.getText()+"%' OR supplier.id_supplier LIKE '%"+btnCariLSM.getText()+"%' \n" +
                      "OR supplier.nama_supplier LIKE '%"+btnCariLSM.getText()+"%' OR alatmusik.idalatmusik LIKE '%"+btnCariLSM.getText()+"%' OR alatmusik.namaalatmusik LIKE '%"+btnCariLSM.getText()+"%' OR detail_produkmasuk.harga_beli LIKE '%"+btnCariLSM.getText()+"%' \n" +
                      "OR detail_produkmasuk.stok_masuk LIKE '%"+btnCariLSM.getText()+"%' OR detail_produkmasuk.harga_total LIKE '%"+btnCariLSM.getText()+"%' OR produkmasuk.tgl_pembelian LIKE '%"+btnCariLSM.getText()+"%' ORDER BY produkmasuk.id_produkmasuk";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.ResultSet res1 = pst1.executeQuery(sql1);
        model.setRowCount(0);
        model.setColumnCount(0);
            int no = 1;
            while (res1.next()){
                model.addRow (new Object[] {no++, res1.getString(1),res1.getString(2), res1.getString(3), 
                    res1.getString(4), res1.getString(5),res1.getString(6), ("+ " +res1.getString(7)),res1.getString(8), res1.getString(9)});
            }
        tabelLSM.setModel(model);
        } catch (SQLException ex) {
    }
    }//GEN-LAST:event_txtCariLSMActionPerformed

    private void btnUbahLPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLPMouseMoved
        btnUbahLP.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnUbahLPMouseMoved

    private void btnUbahLPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLPMouseClicked
        fileChooserLP();
    }//GEN-LAST:event_btnUbahLPMouseClicked

    private void btnUbahLPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLPMouseExited
        btnUbahLP.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnUbahLPMouseExited

    private void btnEksporLPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLPMouseMoved
        btnEksporLP.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEksporLPMouseMoved

    private void btnEksporLPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLPMouseClicked
        tabelLP.setModel(model);
        if (txtlokasiLP.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Gagal di Export ke Excel!\nHarap Pilih lokasi penyimpanan file Excel ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
        try{
            WritableWorkbook write = Workbook.createWorkbook(new File(txtlokasiLP.getText()));
            WritableSheet sheet = write.createSheet("export-data",0);
            sheet.addCell(new Label(0,0,"ID Transaksi"));
            sheet.addCell(new Label(1,0,"ID Pembeli"));
            sheet.addCell(new Label(2,0,"ID Alat Musik"));
            sheet.addCell(new Label(3,0,"Nama Alat Musik"));
            sheet.addCell(new Label(4,0,"Harga"));
            sheet.addCell(new Label(5,0,"Jumlah"));
            sheet.addCell(new Label(6,0,"Total Harga"));
            sheet.addCell(new Label(7,0,"Tanggal"));
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
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString());
        }
        }
    }//GEN-LAST:event_btnEksporLPMouseClicked

    private void btnEksporLPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLPMouseExited
        btnEksporLP.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEksporLPMouseExited

    private void btnUbahLSMMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLSMMouseMoved
        btnUbahLSM.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnUbahLSMMouseMoved

    private void btnUbahLSMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLSMMouseClicked
        fileChooserLSM();
    }//GEN-LAST:event_btnUbahLSMMouseClicked

    private void btnUbahLSMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLSMMouseExited
        btnUbahLSM.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnUbahLSMMouseExited

    private void btnEksporLSMMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLSMMouseMoved
        btnEksporLSM.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEksporLSMMouseMoved

    private void btnEksporLSMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLSMMouseClicked
        tabelLSM.setModel(model);
        if (txtlokasiLSM.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Gagal di Export ke Excel!\nHarap Pilih lokasi penyimpanan file Excel ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
        try{
            WritableWorkbook write = Workbook.createWorkbook(new File(txtlokasiLSM.getText()));
            WritableSheet sheet = write.createSheet("export-data",0);
            sheet.addCell(new Label(0,0,"ID Produk Masuk"));
            sheet.addCell(new Label(1,0,"ID Supplier"));
            sheet.addCell(new Label(2,0,"Nama Supplier"));
            sheet.addCell(new Label(3,0,"ID Alat Musik"));
            sheet.addCell(new Label(4,0,"Nama Alat Musik"));
            sheet.addCell(new Label(5,0,"Harga Beli"));
            sheet.addCell(new Label(6,0,"Stok Masuk"));
            sheet.addCell(new Label(7,0,"Harga Total"));
            sheet.addCell(new Label(4,0,"Tanggal"));
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
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString());
        }
        }
    }//GEN-LAST:event_btnEksporLSMMouseClicked

    private void btnEksporLSMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLSMMouseExited
        btnEksporLSM.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEksporLSMMouseExited

    private void btnEksporLPPDFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLPPDFMouseMoved
        btnEksporLPPDF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEksporLPPDFMouseMoved

    // Fungsi getObject tabel Laporan
    public Object getObject(JTable tabel,int baris,int kolom){
        return tabelLP.getModel().getValueAt(baris, kolom);
    }
    
    private void btnEksporLPPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLPPDFMouseClicked
        int count = tabelLP.getRowCount();
        if (txtlokasiLPPDF.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Gagal di Export ke PDF!\nHarap Pilih lokasi penyimpanan file PDF ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
        try {
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream(txtlokasiLPPDF.getText()));
		doc.open();
		PdfPTable pdfTable = new PdfPTable(10);
                pdfTable.addCell("No.");
		pdfTable.addCell("ID Transaksi");
		pdfTable.addCell("ID Pembeli");
                pdfTable.addCell("Nama Pembeli");
		pdfTable.addCell("ID Alat Musik");
                pdfTable.addCell("Nama Alat Musik");
		pdfTable.addCell("Harga");
		pdfTable.addCell("Jumlah");
                pdfTable.addCell("Total Harga");
		pdfTable.addCell("Tanggal");
                
		for (int a = 0; a<count; a++) {
			Object obj_0 = getObject(tabelLP, a, 0);
			Object obj_1 = getObject(tabelLP, a, 1);
			Object obj_2 = getObject(tabelLP, a, 2);
                        Object obj_3 = getObject(tabelLP, a, 3);
			Object obj_4 = getObject(tabelLP, a, 4);
			Object obj_5 = getObject(tabelLP, a, 5);
                        Object obj_6 = getObject(tabelLP, a, 6);
			Object obj_7 = getObject(tabelLP, a, 7);
                        Object obj_8 = getObject(tabelLP, a, 8);
			Object obj_9 = getObject(tabelLP, a, 9);
						
			String i = obj_0.toString();
			String j = obj_1.toString();
			String k = obj_2.toString();
                        String l = obj_3.toString();
			String m = obj_4.toString();
			String n = obj_5.toString();
                        String o = obj_6.toString();
			String p = obj_7.toString();
                        String q = obj_8.toString();
			String r = obj_9.toString();
						
			pdfTable.addCell(i);
			pdfTable.addCell(j);
			pdfTable.addCell(k);
                        pdfTable.addCell(l);
			pdfTable.addCell(m);
			pdfTable.addCell(n);
                        pdfTable.addCell(o);
			pdfTable.addCell(p);
                        pdfTable.addCell(q);
			pdfTable.addCell(r);
		}
		doc.add(pdfTable);
		doc.close();
		JOptionPane.showMessageDialog(null,"Data berhasil di Export ke PDF ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
	} catch(Exception ex) {
		System.out.println(ex);
	}
        }
    }//GEN-LAST:event_btnEksporLPPDFMouseClicked

    private void btnEksporLPPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLPPDFMouseExited
        btnEksporLPPDF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEksporLPPDFMouseExited

    private void dashboardcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardcbActionPerformed
        if (dashboardcb.getSelectedIndex()==0){
            txtgrafik.setText("Grafik Pembeli Selama 12 Bulan");
            panelLT.setVisible(true);
            panelE.setVisible(false);
            //        dashboardcb.setSelectedIndex(0);
            GrafikPanel.setVisible(true);
            GrafikPanel1.setVisible(false);
        }
        if (dashboardcb.getSelectedIndex()==1){
            txtgrafik.setText("Grafik Barang Terjual Selama 12 Bulan");
            panelLT.setVisible(true);
            panelE.setVisible(false);
            //        dashboardcb.setSelectedIndex(1);
            GrafikPanel.setVisible(false);
            GrafikPanel1.setVisible(true);
        }
        if (dashboardcb.getSelectedIndex()==2){
            txtgrafik1.setText("Grafik Total Penjualan Selama 12 Bulan");
            panelLT.setVisible(false);
            panelE.setVisible(true);
            dashboardcb1.setSelectedIndex(2);
            GrafikPanel2.setVisible(true);
            Laporancb.setVisible(false);
        }
    }//GEN-LAST:event_dashboardcbActionPerformed

    private void dashboardcb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardcb1ActionPerformed
        if (dashboardcb1.getSelectedIndex()==0){
            txtgrafik.setText("Grafik Pembeli Selama 12 Bulan");
            panelLT.setVisible(true);
            panelE.setVisible(false);
            dashboardcb.setSelectedIndex(0);
            GrafikPanel.setVisible(true);
            GrafikPanel1.setVisible(false);
            Laporancb.setVisible(true);
        }
        if (dashboardcb1.getSelectedIndex()==1){
            txtgrafik.setText("Grafik Barang Terjual Selama 12 Bulan");
            panelLT.setVisible(true);
            panelE.setVisible(false);
            dashboardcb.setSelectedIndex(1);
            GrafikPanel.setVisible(false);
            GrafikPanel1.setVisible(true);
            Laporancb.setVisible(true);
        }
        if (dashboardcb1.getSelectedIndex()==2){
            txtgrafik1.setText("Grafik Total Penjualan Selama 12 Bulan");
            panelLT.setVisible(false);
            panelE.setVisible(true);
            //        dashboardcb1.setSelectedIndex(2);
            GrafikPanel2.setVisible(true);
            Laporancb.setVisible(false);
        }
    }//GEN-LAST:event_dashboardcb1ActionPerformed

    private void btnUbahLPPDFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLPPDFMouseMoved
        btnUbahLPPDF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnUbahLPPDFMouseMoved

    private void btnUbahLPPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLPPDFMouseClicked
        fileChooserLPPDF();
    }//GEN-LAST:event_btnUbahLPPDFMouseClicked

    private void btnUbahLPPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLPPDFMouseExited
        btnUbahLPPDF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnUbahLPPDFMouseExited

    private void btnUbahLSMPDFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLSMPDFMouseMoved
        btnUbahLSMPDF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnUbahLSMPDFMouseMoved

    private void btnUbahLSMPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLSMPDFMouseClicked
        fileChooserLSMPDF();
    }//GEN-LAST:event_btnUbahLSMPDFMouseClicked

    private void btnUbahLSMPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahLSMPDFMouseExited
        btnUbahLSMPDF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnUbahLSMPDFMouseExited

    private void btnEksporLSMPDFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLSMPDFMouseMoved
        btnEksporLSMPDF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEksporLSMPDFMouseMoved

    private void btnEksporLSMPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLSMPDFMouseClicked
        int count = tabelLP.getRowCount();
        if (txtlokasiLSMPDF.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Gagal di Export ke PDF!\nHarap Pilih lokasi penyimpanan file PDF ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
        try {
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream(txtlokasiLSMPDF.getText()));
		doc.open();
		PdfPTable pdfTable = new PdfPTable(10);
                pdfTable.addCell("No.");
		pdfTable.addCell("ID Produk Masuk");
		pdfTable.addCell("ID Supplier");
                pdfTable.addCell("Nama Supplier");
		pdfTable.addCell("ID Alat Musik");
                pdfTable.addCell("Nama Alat Musik");
		pdfTable.addCell("Harga Beli");
		pdfTable.addCell("Stok Masuk");
                pdfTable.addCell("Total Harga");
		pdfTable.addCell("Tanggal");
                
		for (int a = 0; a<count; a++) {
			Object obj_0 = getObject(tabelLP, a, 0);
			Object obj_1 = getObject(tabelLP, a, 1);
			Object obj_2 = getObject(tabelLP, a, 2);
                        Object obj_3 = getObject(tabelLP, a, 3);
			Object obj_4 = getObject(tabelLP, a, 4);
			Object obj_5 = getObject(tabelLP, a, 5);
                        Object obj_6 = getObject(tabelLP, a, 6);
			Object obj_7 = getObject(tabelLP, a, 7);
                        Object obj_8 = getObject(tabelLP, a, 8);
			Object obj_9 = getObject(tabelLP, a, 9);
						
			String i = obj_0.toString();
			String j = obj_1.toString();
			String k = obj_2.toString();
                        String l = obj_3.toString();
			String m = obj_4.toString();
			String n = obj_5.toString();
                        String o = obj_6.toString();
			String p = obj_7.toString();
                        String q = obj_8.toString();
			String r = obj_9.toString();
						
			pdfTable.addCell(i);
			pdfTable.addCell(j);
			pdfTable.addCell(k);
                        pdfTable.addCell(l);
			pdfTable.addCell(m);
			pdfTable.addCell(n);
                        pdfTable.addCell(o);
			pdfTable.addCell(p);
                        pdfTable.addCell(q);
			pdfTable.addCell(r);
		}
		doc.add(pdfTable);
		doc.close();
		JOptionPane.showMessageDialog(null,"Data berhasil di Export ke PDF ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
	} catch(Exception ex) {
		System.out.println(ex);
	}
        }
    }//GEN-LAST:event_btnEksporLSMPDFMouseClicked

    private void btnEksporLSMPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporLSMPDFMouseExited
        btnEksporLSMPDF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEksporLSMPDFMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GrafikPanel;
    private javax.swing.JPanel GrafikPanel1;
    private javax.swing.JPanel GrafikPanel2;
    public javax.swing.JComboBox<String> Laporancb;
    private javax.swing.JLabel angkabrterjual;
    private javax.swing.JLabel angkadibeli;
    private javax.swing.JLabel angkapembelian1thn;
    private javax.swing.JLabel angkapenjualan1thn;
    private javax.swing.JLabel bgDashboard1;
    private javax.swing.JLabel bgLP;
    private javax.swing.JLabel bgLSM;
    private javax.swing.JLabel bgLT;
    private javax.swing.JLabel btnCariLP;
    private javax.swing.JLabel btnCariLSM;
    private javax.swing.JLabel btnEksporLP;
    private javax.swing.JLabel btnEksporLPPDF;
    private javax.swing.JLabel btnEksporLSM;
    private javax.swing.JLabel btnEksporLSMPDF;
    private javax.swing.JLabel btnTampilkanLP;
    private javax.swing.JLabel btnTampilkanLSM;
    private javax.swing.JLabel btnUbahLP;
    private javax.swing.JLabel btnUbahLPPDF;
    private javax.swing.JLabel btnUbahLSM;
    private javax.swing.JLabel btnUbahLSMPDF;
    public javax.swing.JComboBox<String> dashboardcb;
    private javax.swing.JComboBox<String> dashboardcb1;
    private com.toedter.calendar.JDateChooser date1LP;
    private com.toedter.calendar.JDateChooser date1LSM;
    private com.toedter.calendar.JDateChooser date2LP;
    private com.toedter.calendar.JDateChooser date2LSM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JPanel panelE;
    private javax.swing.JPanel panelLP;
    private javax.swing.JPanel panelLSM;
    protected javax.swing.JPanel panelLT;
    private javax.swing.JTable tabelLP;
    private javax.swing.JTable tabelLSM;
    private javax.swing.JLabel textpembeli1;
    private javax.swing.JLabel textpenjualan1hr;
    private javax.swing.JLabel textstok;
    private javax.swing.JLabel textstokmasuk;
    private javax.swing.JTextField txtCariLP;
    private javax.swing.JTextField txtCariLSM;
    public javax.swing.JLabel txtgrafik;
    private javax.swing.JLabel txtgrafik1;
    private javax.swing.JTextField txtlokasiLP;
    private javax.swing.JTextField txtlokasiLPPDF;
    private javax.swing.JTextField txtlokasiLSM;
    private javax.swing.JTextField txtlokasiLSMPDF;
    public javax.swing.JLabel txttampilkan;
    private javax.swing.JLabel txttampilkan1;
    // End of variables declaration//GEN-END:variables
}
