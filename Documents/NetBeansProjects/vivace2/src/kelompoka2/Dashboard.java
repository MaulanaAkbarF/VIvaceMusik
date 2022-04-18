package kelompoka2;

public class Dashboard extends javax.swing.JFrame {
    
    private void dashboardshow (){
        angkapenjualan1hr.setVisible(true);
        textpenjualan1hr.setVisible(true);
        angkastok.setVisible(true);
        textstok.setVisible(true);
        angkatotalpembelian.setVisible(true);
        texttotalpembelian.setVisible(true);
        angkajumlah.setVisible(true);
        textjumlah.setVisible(true);
        textgrafik.setVisible(true);
    }
    
    private void dashboardhide (){
        angkapenjualan1hr.setVisible(false);
        textpenjualan1hr.setVisible(false);
        angkastok.setVisible(false);
        textstok.setVisible(false);
        angkatotalpembelian.setVisible(false);
        texttotalpembelian.setVisible(false);
        angkajumlah.setVisible(false);
        textjumlah.setVisible(false);
        textgrafik.setVisible(false);
    }

    public Dashboard() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        angkapenjualan1hr = new javax.swing.JLabel();
        textpenjualan1hr = new javax.swing.JLabel();
        angkastok = new javax.swing.JLabel();
        textstok = new javax.swing.JLabel();
        angkatotalpembelian = new javax.swing.JLabel();
        texttotalpembelian = new javax.swing.JLabel();
        angkajumlah = new javax.swing.JLabel();
        textjumlah = new javax.swing.JLabel();
        textgrafik = new javax.swing.JLabel();
        usermenu = new javax.swing.JLabel();
        barangmenu = new javax.swing.JLabel();
        keluarbtn = new javax.swing.JLabel();
        dashboardmenu = new javax.swing.JLabel();
        transaksimenu = new javax.swing.JLabel();
        suppliermenu = new javax.swing.JLabel();
        laporanmenu = new javax.swing.JLabel();
        pengaturanmenu = new javax.swing.JLabel();
        bgDashboard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1010));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                extends2(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        angkapenjualan1hr.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkapenjualan1hr.setText("Rp.0,0");
        getContentPane().add(angkapenjualan1hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 410, 50));

        textpenjualan1hr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textpenjualan1hr.setForeground(new java.awt.Color(130, 130, 130));
        textpenjualan1hr.setText("Penjualan Selama Satu Hari");
        getContentPane().add(textpenjualan1hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 260, -1));

        angkastok.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkastok.setText("0");
        getContentPane().add(angkastok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 250, 410, 50));

        textstok.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textstok.setForeground(new java.awt.Color(130, 130, 130));
        textstok.setText("Stok Barang");
        getContentPane().add(textstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 300, 260, -1));

        angkatotalpembelian.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkatotalpembelian.setText("0 ORANG");
        getContentPane().add(angkatotalpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 410, 50));

        texttotalpembelian.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        texttotalpembelian.setForeground(new java.awt.Color(130, 130, 130));
        texttotalpembelian.setText("Total Pembelian Hari Ini");
        getContentPane().add(texttotalpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 260, -1));

        angkajumlah.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        angkajumlah.setText("0");
        getContentPane().add(angkajumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 490, 410, 50));

        textjumlah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textjumlah.setForeground(new java.awt.Color(130, 130, 130));
        textjumlah.setText("Jumlah Barang Masuk");
        getContentPane().add(textjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 540, 260, -1));

        textgrafik.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textgrafik.setText("Grafik Penjulan Selama Satu Minggu");
        getContentPane().add(textgrafik, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 740, 630, 50));

        usermenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        usermenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/usericon.png"))); // NOI18N
        usermenu.setText("   HAI, KARYAWAN!");
        getContentPane().add(usermenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, -1));

        barangmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        barangmenu.setForeground(new java.awt.Color(153, 153, 153));
        barangmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/barangicon.png"))); // NOI18N
        barangmenu.setText("     BARANG");
        getContentPane().add(barangmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 210, 40));

        keluarbtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        keluarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logouticon.png"))); // NOI18N
        keluarbtn.setText("     KELUAR");
        getContentPane().add(keluarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 930, 210, 40));

        dashboardmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        dashboardmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/homeicon.png"))); // NOI18N
        dashboardmenu.setText("     DASHBOARD");
        dashboardmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardmenuMouseClicked(evt);
            }
        });
        getContentPane().add(dashboardmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 210, 40));

        transaksimenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        transaksimenu.setForeground(new java.awt.Color(153, 153, 153));
        transaksimenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/creditcard.png"))); // NOI18N
        transaksimenu.setText("     TRANSAKSI");
        getContentPane().add(transaksimenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 210, 40));

        suppliermenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        suppliermenu.setForeground(new java.awt.Color(153, 153, 153));
        suppliermenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/suppliericon.icon.png"))); // NOI18N
        suppliermenu.setText("     SUPPLIER");
        getContentPane().add(suppliermenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 210, 40));

        laporanmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        laporanmenu.setForeground(new java.awt.Color(153, 153, 153));
        laporanmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/laporanicon.png"))); // NOI18N
        laporanmenu.setText("     LAPORAN");
        getContentPane().add(laporanmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 210, 40));

        pengaturanmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        pengaturanmenu.setForeground(new java.awt.Color(153, 153, 153));
        pengaturanmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settingicon.png"))); // NOI18N
        pengaturanmenu.setText("     PENGATURAN");
        getContentPane().add(pengaturanmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 210, 40));

        bgDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Group 37.png"))); // NOI18N
        bgDashboard.setText("jLabel2");
        getContentPane().add(bgDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void extends2(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_extends2
        
    }//GEN-LAST:event_extends2

    private void dashboardmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardmenuMouseClicked
        dashboardhide();
    }//GEN-LAST:event_dashboardmenuMouseClicked

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel angkajumlah;
    private javax.swing.JLabel angkapenjualan1hr;
    private javax.swing.JLabel angkastok;
    private javax.swing.JLabel angkatotalpembelian;
    private javax.swing.JLabel barangmenu;
    private javax.swing.JLabel bgDashboard;
    private javax.swing.JLabel dashboardmenu;
    private javax.swing.JLabel keluarbtn;
    private javax.swing.JLabel laporanmenu;
    private javax.swing.JLabel pengaturanmenu;
    private javax.swing.JLabel suppliermenu;
    private javax.swing.JLabel textgrafik;
    private javax.swing.JLabel textjumlah;
    private javax.swing.JLabel textpenjualan1hr;
    private javax.swing.JLabel textstok;
    private javax.swing.JLabel texttotalpembelian;
    private javax.swing.JLabel transaksimenu;
    private javax.swing.JLabel usermenu;
    // End of variables declaration//GEN-END:variables
}
