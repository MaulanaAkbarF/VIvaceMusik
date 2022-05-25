/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

package Form;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class FormDashboard extends javax.swing.JPanel {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi
    */ 
    
    
    private void TampilkanJumlah() {
        try {
        String sql = "SELECT SUM(totalharga) AS total FROM detail_transaksi WHERE tanggal = CURDATE()";    
        java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
        String data = rs.getString("total");
             if(data == null){
                angkapenjualan1hr.setText("Rp. 0");   
            }else{
                angkapenjualan1hr.setText(String.format("Rp. %,d,00", Integer.parseInt(data)));
            }                                        
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void TampilkanOrang() {
        try {
            String sql = "SELECT COUNT(idpembeli) AS total FROM transaksi WHERE tanggal = CURDATE()";      
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            
        while(rs.next()){
            String data = rs.getString("total");
             if(data == null){
                angkapembeli.setText("0 Orang");   
            }else{
                angkapembeli.setText(data+" Orang" );   
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
                angkastok.setText("0 Barang");   
            }else{
                angkastok.setText(String.format("%,d Barang", Integer.parseInt(data)));   
            }                                        
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        }       
                
    private void TampilkanStokMasuk() {
        try {
        String sql = "SELECT SUM(stok_masuk) AS total FROM detail_produkmasuk WHERE tanggal = CURDATE()";      
        java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
        String data = rs.getString("total");
             if(data == null){
                angkastokmasuk.setText("0 Barang");   
            }else{
                angkastokmasuk.setText(String.format("%,d Barang", Integer.parseInt(data)));   
            }                                        
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void Grafik(){
        try{
            //tanggal
            Date date = new Date();
            DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
            Calendar cal =Calendar.getInstance();
            cal.add(Calendar.DATE, -7);
            String sekarang = formattanggal.format(date);
            String tujuhHariLalu = formattanggal.format(cal.getTime());
            
            //query
            String query = "SELECT tanggal, COUNT(tanggal) AS total FROM transaksi WHERE tanggal BETWEEN '"+tujuhHariLalu+"' AND '"+sekarang+"' GROUP BY tanggal";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(Config.configDB(), query);
            JFreeChart grafik = ChartFactory.createLineChart("", "Tanggal", "Jumlah", dataset, PlotOrientation.VERTICAL, false, true, true);
            
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
        } catch(Exception e){
            System.out.println(e);
        }}
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 

    public FormDashboard() {
        initComponents();
        TampilkanJumlah();
        TampilkanOrang();
        TampilkanStok();
        TampilkanStokMasuk();
        Grafik();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMenu = new javax.swing.JLabel();
        angkapenjualan1hr = new javax.swing.JLabel();
        textpenjualan1hr = new javax.swing.JLabel();
        angkapembeli = new javax.swing.JLabel();
        textpembeli = new javax.swing.JLabel();
        angkastok = new javax.swing.JLabel();
        textstok = new javax.swing.JLabel();
        angkastokmasuk = new javax.swing.JLabel();
        textstokmasuk = new javax.swing.JLabel();
        textpembeli1 = new javax.swing.JLabel();
        GrafikPanel = new javax.swing.JPanel();
        bgDashboard = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        txtMenu.setText("Dashboard");
        txtMenu.setAlignmentY(0.0F);
        add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 400, 45));

        angkapenjualan1hr.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapenjualan1hr.setText("Rp.0,0");
        add(angkapenjualan1hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 640, 80));

        textpenjualan1hr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpenjualan1hr.setForeground(new java.awt.Color(130, 130, 130));
        textpenjualan1hr.setText("Total Penjualan Hari Ini");
        add(textpenjualan1hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 490, -1));

        angkapembeli.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapembeli.setText("0 Orang");
        add(angkapembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 640, 50));

        textpembeli.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpembeli.setText("Grafik Penjualan Minggu Ini");
        add(textpembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 700, 490, -1));

        angkastok.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkastok.setText("0 Barang");
        add(angkastok, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 640, 80));

        textstok.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textstok.setForeground(new java.awt.Color(130, 130, 130));
        textstok.setText("Stok Barang Total");
        add(textstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 490, -1));

        angkastokmasuk.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkastokmasuk.setText("0 Barang");
        add(angkastokmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 640, 50));

        textstokmasuk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textstokmasuk.setForeground(new java.awt.Color(130, 130, 130));
        textstokmasuk.setText("Jumlah Stok Masuk Hari Ini");
        add(textstokmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 520, 490, -1));

        textpembeli1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpembeli1.setForeground(new java.awt.Color(130, 130, 130));
        textpembeli1.setText("Total Pembeli Hari Ini");
        add(textpembeli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 490, -1));

        GrafikPanel.setOpaque(false);
        GrafikPanel.setLayout(new javax.swing.BoxLayout(GrafikPanel, javax.swing.BoxLayout.LINE_AXIS));
        add(GrafikPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 740, 1450, 180));

        bgDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Dashboard.png"))); // NOI18N
        add(bgDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GrafikPanel;
    private javax.swing.JLabel angkapembeli;
    private javax.swing.JLabel angkapenjualan1hr;
    private javax.swing.JLabel angkastok;
    private javax.swing.JLabel angkastokmasuk;
    private javax.swing.JLabel bgDashboard;
    private javax.swing.JLabel textpembeli;
    private javax.swing.JLabel textpembeli1;
    private javax.swing.JLabel textpenjualan1hr;
    private javax.swing.JLabel textstok;
    private javax.swing.JLabel textstokmasuk;
    private javax.swing.JLabel txtMenu;
    // End of variables declaration//GEN-END:variables
}
