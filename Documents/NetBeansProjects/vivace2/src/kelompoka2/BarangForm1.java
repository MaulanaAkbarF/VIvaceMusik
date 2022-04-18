package kelompoka2;

public class BarangForm1 extends javax.swing.JFrame {

    public BarangForm1() {
        initComponents();
    }
    
    private void dashboardshow (){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usermenu = new javax.swing.JLabel();
        barangmenu = new javax.swing.JLabel();
        keluarbtn = new javax.swing.JLabel();
        dashboardmenu = new javax.swing.JLabel();
        transaksimenu = new javax.swing.JLabel();
        suppliermenu = new javax.swing.JLabel();
        laporanmenu = new javax.swing.JLabel();
        pengaturanmenu = new javax.swing.JLabel();
        harga_jual = new javax.swing.JTextField();
        id_barang = new javax.swing.JTextField();
        nama_barang = new javax.swing.JTextField();
        harga_beli = new javax.swing.JTextField();
        stok = new javax.swing.JTextField();
        id_barang1 = new javax.swing.JTextField();
        btn_tambahkan = new javax.swing.JPanel();
        btn_export = new javax.swing.JPanel();
        btn_update = new javax.swing.JPanel();
        btn_cari = new javax.swing.JPanel();
        tabeldaftarbarang = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bgDashboard = new javax.swing.JLabel();
        btn_update1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                extends2(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usermenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        usermenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/usericon.png"))); // NOI18N
        usermenu.setText("   HAI, KARYAWAN!");
        getContentPane().add(usermenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, -1));

        barangmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        barangmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/barangicon.png"))); // NOI18N
        barangmenu.setText("     BARANG");
        getContentPane().add(barangmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 210, 40));

        keluarbtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        keluarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logouticon.png"))); // NOI18N
        keluarbtn.setText("     KELUAR");
        getContentPane().add(keluarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 930, 210, 40));

        dashboardmenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        dashboardmenu.setForeground(new java.awt.Color(153, 153, 153));
        dashboardmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/homeicon.png"))); // NOI18N
        dashboardmenu.setText("     DASHBOARD");
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

        harga_jual.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        harga_jual.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(harga_jual, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 570, 30));

        id_barang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        id_barang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        id_barang.setOpaque(false);
        getContentPane().add(id_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 90, 220, 40));

        nama_barang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nama_barang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(nama_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 570, 30));

        harga_beli.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        harga_beli.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(harga_beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 570, 40));

        stok.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        stok.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 690, 570, 40));

        id_barang1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id_barang1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(id_barang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 570, 30));

        btn_tambahkan.setOpaque(false);

        javax.swing.GroupLayout btn_tambahkanLayout = new javax.swing.GroupLayout(btn_tambahkan);
        btn_tambahkan.setLayout(btn_tambahkanLayout);
        btn_tambahkanLayout.setHorizontalGroup(
            btn_tambahkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        btn_tambahkanLayout.setVerticalGroup(
            btn_tambahkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(btn_tambahkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 810, 180, 70));

        btn_export.setOpaque(false);

        javax.swing.GroupLayout btn_exportLayout = new javax.swing.GroupLayout(btn_export);
        btn_export.setLayout(btn_exportLayout);
        btn_exportLayout.setHorizontalGroup(
            btn_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        btn_exportLayout.setVerticalGroup(
            btn_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(btn_export, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 810, 190, 70));

        btn_update.setOpaque(false);

        javax.swing.GroupLayout btn_updateLayout = new javax.swing.GroupLayout(btn_update);
        btn_update.setLayout(btn_updateLayout);
        btn_updateLayout.setHorizontalGroup(
            btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        btn_updateLayout.setVerticalGroup(
            btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 810, 180, 70));

        btn_cari.setOpaque(false);

        javax.swing.GroupLayout btn_cariLayout = new javax.swing.GroupLayout(btn_cari);
        btn_cari.setLayout(btn_cariLayout);
        btn_cariLayout.setHorizontalGroup(
            btn_cariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        btn_cariLayout.setVerticalGroup(
            btn_cariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 100, 120, 30));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(0, 255, 0));
        jTable1.setSelectionForeground(new java.awt.Color(255, 0, 255));
        tabeldaftarbarang.setViewportView(jTable1);

        getContentPane().add(tabeldaftarbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 160, 770, 800));

        bgDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BR1.png"))); // NOI18N
        bgDashboard.setText("jLabel2");
        getContentPane().add(bgDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1010));

        btn_update1.setOpaque(false);

        javax.swing.GroupLayout btn_update1Layout = new javax.swing.GroupLayout(btn_update1);
        btn_update1.setLayout(btn_update1Layout);
        btn_update1Layout.setHorizontalGroup(
            btn_update1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        btn_update1Layout.setVerticalGroup(
            btn_update1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(btn_update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 810, 180, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void extends2(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_extends2
        setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_extends2

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
            java.util.logging.Logger.getLogger(BarangForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangForm1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barangmenu;
    private javax.swing.JLabel bgDashboard;
    private javax.swing.JPanel btn_cari;
    private javax.swing.JPanel btn_export;
    private javax.swing.JPanel btn_tambahkan;
    private javax.swing.JPanel btn_update;
    private javax.swing.JPanel btn_update1;
    private javax.swing.JLabel dashboardmenu;
    private javax.swing.JTextField harga_beli;
    private javax.swing.JTextField harga_jual;
    private javax.swing.JTextField id_barang;
    private javax.swing.JTextField id_barang1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel keluarbtn;
    private javax.swing.JLabel laporanmenu;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JLabel pengaturanmenu;
    private javax.swing.JTextField stok;
    private javax.swing.JLabel suppliermenu;
    private javax.swing.JScrollPane tabeldaftarbarang;
    private javax.swing.JLabel transaksimenu;
    private javax.swing.JLabel usermenu;
    // End of variables declaration//GEN-END:variables
}
