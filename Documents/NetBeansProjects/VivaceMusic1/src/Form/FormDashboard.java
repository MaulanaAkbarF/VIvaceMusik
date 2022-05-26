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
    
    private void tampilkan(){
        TampilkanJumlah();
        TampilkanOrang();
        TampilkanStok();
        TampilkanStokMasuk();
    }
    
    
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
    
    private void Grafik2(){
        try{
            //tanggal
            Date date = new Date();
            DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
            Calendar cal =Calendar.getInstance();
            cal.add(Calendar.DATE, -7);
            String sekarang = formattanggal.format(date);
            String tujuhHariLalu = formattanggal.format(cal.getTime());
            
            //query
            String query = "SELECT tanggal, SUM(jumlah) AS total FROM detail_transaksi WHERE tanggal BETWEEN '"+tujuhHariLalu+"' AND '"+sekarang+"' GROUP BY tanggal";
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
            GrafikPanel1.add(panel);
            panel.setVisible(true);
        } catch(Exception e){
            System.out.println(e);
        }}
    
    private void Grafik3(){
        try{
            //tanggal
            Date date = new Date();
            DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
            Calendar cal =Calendar.getInstance();
            cal.add(Calendar.DATE, -7);
            String sekarang = formattanggal.format(date);
            String tujuhHariLalu = formattanggal.format(cal.getTime());
            
            //query
            String query = "SELECT tanggal, SUM(totalharga) AS total FROM detail_transaksi WHERE tanggal BETWEEN '"+tujuhHariLalu+"' AND '"+sekarang+"' GROUP BY tanggal";
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
            GrafikPanel2.add(panel);
            panel.setVisible(true);
        } catch(Exception e){
            System.out.println(e);
        }}
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 

    public FormDashboard() {
        initComponents();
        tampilkan();
        Grafik();
        Grafik2();
        Grafik3();
        panelE.setVisible(false);
        GrafikPanel1.setVisible(false);
        GrafikPanel2.setVisible(false);
        btnSelesai.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtgrafik = new javax.swing.JLabel();
        txttampilkan = new javax.swing.JLabel();
        dashboardcb = new javax.swing.JComboBox<>();
        panelE = new javax.swing.JPanel();
        GrafikPanel2 = new javax.swing.JPanel();
        bgDashboard1 = new javax.swing.JLabel();
        panelD = new javax.swing.JPanel();
        txtMenu = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JLabel();
        btnSelesai = new javax.swing.JLabel();
        angkapenjualan1hr = new javax.swing.JLabel();
        textpenjualan1hr = new javax.swing.JLabel();
        angkapembeli = new javax.swing.JLabel();
        textpembeli = new javax.swing.JLabel();
        angkastok = new javax.swing.JLabel();
        textstok = new javax.swing.JLabel();
        angkastokmasuk = new javax.swing.JLabel();
        textstokmasuk = new javax.swing.JLabel();
        GrafikPanel1 = new javax.swing.JPanel();
        GrafikPanel = new javax.swing.JPanel();
        bgDashboard = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtgrafik.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtgrafik.setText("Grafik Pembeli Selama 7 Hari");
        add(txtgrafik, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, 500, -1));

        txttampilkan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txttampilkan.setText("Tampilkan :");
        add(txttampilkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 660, 100, 25));

        dashboardcb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dashboardcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grafik Pembeli Selama 7 Hari", "Grafik Barang Terjual Selama 7 Hari", "Grafik Total Penjualan Selama 7 Hari" }));
        dashboardcb.setBorder(null);
        dashboardcb.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dashboardcb.setOpaque(false);
        dashboardcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardcbActionPerformed(evt);
            }
        });
        add(dashboardcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1124, 657, 370, 30));

        panelE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GrafikPanel2.setOpaque(false);
        GrafikPanel2.setLayout(new javax.swing.BoxLayout(GrafikPanel2, javax.swing.BoxLayout.LINE_AXIS));
        panelE.add(GrafikPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 1450, 830));

        bgDashboard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Expand.png"))); // NOI18N
        panelE.add(bgDashboard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(panelE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        panelD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        txtMenu.setText("Dashboard");
        txtMenu.setAlignmentY(0.0F);
        panelD.add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 400, 45));

        btnRefresh.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(95, 95, 95));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refreshicon.png"))); // NOI18N
        btnRefresh.setText("   SEGARKAN");
        btnRefresh.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRefreshMouseMoved(evt);
            }
        });
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRefreshMouseExited(evt);
            }
        });
        panelD.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 110, -1, -1));

        btnSelesai.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btnSelesai.setForeground(new java.awt.Color(95, 95, 95));
        btnSelesai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/checkicon.png"))); // NOI18N
        btnSelesai.setText("   SELESAI");
        panelD.add(btnSelesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 110, -1, -1));

        angkapenjualan1hr.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapenjualan1hr.setText("Rp.0,0");
        panelD.add(angkapenjualan1hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 640, 80));

        textpenjualan1hr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpenjualan1hr.setForeground(new java.awt.Color(130, 130, 130));
        textpenjualan1hr.setText("Total Penjualan Hari Ini");
        panelD.add(textpenjualan1hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 490, -1));

        angkapembeli.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapembeli.setText("0 Orang");
        panelD.add(angkapembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 640, 50));

        textpembeli.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpembeli.setForeground(new java.awt.Color(130, 130, 130));
        textpembeli.setText("Total Pembeli Hari Ini");
        panelD.add(textpembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 490, -1));

        angkastok.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkastok.setText("0 Barang");
        panelD.add(angkastok, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 640, 80));

        textstok.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textstok.setForeground(new java.awt.Color(130, 130, 130));
        textstok.setText("Stok Barang Total");
        panelD.add(textstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 490, -1));

        angkastokmasuk.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkastokmasuk.setText("0 Barang");
        panelD.add(angkastokmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 640, 50));

        textstokmasuk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textstokmasuk.setForeground(new java.awt.Color(130, 130, 130));
        textstokmasuk.setText("Jumlah Stok Masuk Hari Ini");
        panelD.add(textstokmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 520, 490, -1));

        GrafikPanel1.setOpaque(false);
        GrafikPanel1.setLayout(new javax.swing.BoxLayout(GrafikPanel1, javax.swing.BoxLayout.LINE_AXIS));
        panelD.add(GrafikPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 1450, 230));

        GrafikPanel.setOpaque(false);
        GrafikPanel.setLayout(new javax.swing.BoxLayout(GrafikPanel, javax.swing.BoxLayout.LINE_AXIS));
        panelD.add(GrafikPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 1450, 230));

        bgDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Dashboard.png"))); // NOI18N
        panelD.add(bgDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(panelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseMoved
        btnRefresh.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnRefreshMouseMoved

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        tampilkan();
        btnRefresh.setVisible(false);
        btnSelesai.setVisible(true);
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseExited
        btnRefresh.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnRefreshMouseExited

    private void dashboardcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardcbActionPerformed
    if (dashboardcb.getSelectedIndex()==0){
        txtgrafik.setText("Grafik Pembeli Selama 7 Hari");
        panelD.setVisible(true);
        panelE.setVisible(false);
        GrafikPanel.setVisible(true);
        GrafikPanel1.setVisible(false);
    }
    if (dashboardcb.getSelectedIndex()==1){
        txtgrafik.setText("Grafik Barang Terjual Selama 7 Hari");
        panelD.setVisible(true);
        panelE.setVisible(false);
        GrafikPanel.setVisible(false);
        GrafikPanel1.setVisible(true);
    }
    if (dashboardcb.getSelectedIndex()==2){
        txtgrafik.setText("Grafik Total Penjualan Selama 7 Hari");
        panelD.setVisible(false);
        panelE.setVisible(true);
        GrafikPanel2.setVisible(true);
        txtgrafik.setBounds(70, 60, 500, 25);
        txttampilkan.setBounds(1010, 60, 100, 25);
        dashboardcb.setBounds(1124, 57, 370, 30);
    }
    }//GEN-LAST:event_dashboardcbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GrafikPanel;
    private javax.swing.JPanel GrafikPanel1;
    private javax.swing.JPanel GrafikPanel2;
    private javax.swing.JLabel angkapembeli;
    private javax.swing.JLabel angkapenjualan1hr;
    private javax.swing.JLabel angkastok;
    private javax.swing.JLabel angkastokmasuk;
    private javax.swing.JLabel bgDashboard;
    private javax.swing.JLabel bgDashboard1;
    public javax.swing.JLabel btnRefresh;
    public javax.swing.JLabel btnSelesai;
    private javax.swing.JComboBox<String> dashboardcb;
    private javax.swing.JPanel panelD;
    private javax.swing.JPanel panelE;
    private javax.swing.JLabel textpembeli;
    private javax.swing.JLabel textpenjualan1hr;
    private javax.swing.JLabel textstok;
    private javax.swing.JLabel textstokmasuk;
    private javax.swing.JLabel txtMenu;
    private javax.swing.JLabel txtgrafik;
    private javax.swing.JLabel txttampilkan;
    // End of variables declaration//GEN-END:variables
}
