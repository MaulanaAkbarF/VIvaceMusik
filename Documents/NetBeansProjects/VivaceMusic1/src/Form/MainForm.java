/*
 * Author               : Kelompok A2
 * Matkul               : WSIBD, ManPro, IMK
 * Dikembangkan Tanggal : 14 April 2022 - 4 Juni 2022
 * Versi                : v1.0
 */

package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class MainForm extends javax.swing.JFrame {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi HAPUS!!
    */ 
    
    FormDashboard dashboard = new FormDashboard();
    FormBarang barang = new FormBarang();
    FormBarangKaryawan barangkr = new FormBarangKaryawan();
    FormProdukmasuk produkmasuk = new FormProdukmasuk();
    FormProdukmasukKaryawan produkmasukkr = new FormProdukmasukKaryawan();
    FormTransaksi transaksi = new FormTransaksi();
    FormSupplier supplier = new FormSupplier();
    FormSupplierKaryawan supplierkr = new FormSupplierKaryawan();
    FormLaporan laporan = new FormLaporan();
    FormPengaturan pengaturan = new FormPengaturan();
    FormPengaturanAdminKaryawan pengaturanak = new FormPengaturanAdminKaryawan();
    
    public boolean menu1 = true;
    public boolean menu2 = true;
    public boolean menu3 = true;
    public boolean menu4 = true;
    public boolean menu5 = true;
    public boolean menu6 = true;
    public boolean menu7 = true;
    public boolean menu8 = true;
    
    private void hubungan(){
        FormPanel.add(dashboard);
        FormPanel.add(barang);
        FormPanel.add(barangkr);
        FormPanel.add(produkmasuk);
        FormPanel.add(produkmasukkr);
        FormPanel.add(transaksi);
        FormPanel.add(supplier);
        FormPanel.add(supplierkr);
        FormPanel.add(laporan);
        FormPanel.add(pengaturan);
        FormPanel.add(pengaturanak);
        
        dashboard.setVisible(true);
        barang.setVisible(false);
        barangkr.setVisible(false);
        produkmasuk.setVisible(false);
        produkmasukkr.setVisible(false);
        transaksi.setVisible(false);
        supplier.setVisible(false);
        supplierkr.setVisible(false);
        laporan.setVisible(false);
        pengaturan.setVisible(false);
        pengaturanak.setVisible(false);
    }
    
    private void opsiMenu(){
        dashboard.setVisible(false);
        barang.setVisible(false);
        barangkr.setVisible(false);
        produkmasuk.setVisible(false);
        produkmasukkr.setVisible(false);
        transaksi.setVisible(false);
        supplier.setVisible(false);
        supplierkr.setVisible(false);
        laporan.setVisible(false);
        pengaturan.setVisible(false);
        pengaturanak.setVisible(false);
    }
    
    private void txthide(){
        dsON.setVisible(false);
        brON.setVisible(false);
        pmON.setVisible(false);
        trON.setVisible(false);
        spON.setVisible(false);
        lpON.setVisible(false);
        stON.setVisible(false);
    }
    
    private void menuColor(){
        MenuDashboard.setBackground(new java.awt.Color(244, 239, 224));
        txtDashboard.setForeground(new java.awt.Color(153,153,153));
        MenuBarang.setBackground(new java.awt.Color(244, 239, 224));
        txtBarang.setForeground(new java.awt.Color(153,153,153));
        MenuProdukmasuk.setBackground(new java.awt.Color(244, 239, 224));
        txtProdukmasuk.setForeground(new java.awt.Color(153,153,153));
        MenuTransaksi.setBackground(new java.awt.Color(244, 239, 224));
        txtTransaksi.setForeground(new java.awt.Color(153,153,153));
        MenuSupplier.setBackground(new java.awt.Color(244, 239, 224));
        txtSupplier.setForeground(new java.awt.Color(153,153,153));
        MenuLaporan.setBackground(new java.awt.Color(244, 239, 224));
        txtLaporan.setForeground(new java.awt.Color(153,153,153));
        MenuPengaturan.setBackground(new java.awt.Color(244, 239, 224));
        txtPengaturan.setForeground(new java.awt.Color(153,153,153));
    }
    
    private void waktu(){
        ActionListener taskPerformer = new ActionListener() {

        @Override
            public void actionPerformed(ActionEvent evt) {
                
            //Variabel (Harus berada pada method Action Event)
            String nol_jam = "", nol_menit = "",nol_detik = "";
            Date now = new Date(); //import java.util.Date
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MM-yyyy");

            //Waktu
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();

            if(nilai_jam <= 9) nol_jam= "0";
            if(nilai_menit <= 9) nol_menit= "0";
            if(nilai_detik <= 9) nol_detik= "0";

            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);

            txtwaktu.setText(jam+": "+menit+": "+detik+"");
            txtwaktu1.setText(jam+": "+menit+": "+detik+"");
            
            // Tanggal
            txttanggal.setText(simpleDateFormat.format(now));
            txttanggal1.setText(simpleDateFormat.format(now));
            }
        };
    new Timer(1000, taskPerformer).start(); //1000 = 1 detik
    }
    
    public void refreshPengaturan(){
        ActionListener taskPerformer = (ActionEvent evt) -> {
            
            // Hak Akses
            if (hakakses.getText().equals("Pemilik")){
                pengaturanak.btnTWTOFF.setText("OFF");
                pengaturanak.btnTSOFF.setText("OFF");
                pengaturanak.btnTSON.setText(null);
                pengaturanak.btnSOUON.setText("ON");
            } else if (hakakses.getText().equals("Administrator") || hakakses.getText().equals("Karyawan")){
                pengaturan.btnTWTOFF.setText("OFF");
                pengaturan.btnTSOFF.setText("OFF");
                pengaturan.btnTSON.setText(null);
                pengaturan.btnSOGON.setText(null);
                pengaturan.btnSOGOFF.setText("OFF");
                pengaturan.btnSOUON.setText("ON");
                pengaturan.btnSOUOFF.setText(null);
            }
            
            // Tampilkan Waktu dan Tanggal
            if (pengaturan.btnTWTON.getText()==null){
                txtwaktu.setVisible(false);
                txttanggal.setVisible(false);
            } else {
                txtwaktu.setVisible(true);
                txttanggal.setVisible(true);
            }
            
            // Tampilkan Waktu dan Tanggal PAK
            if (pengaturanak.btnTWTON.getText()==null){
                txtwaktu1.setVisible(false);
                txttanggal1.setVisible(false);
            } else if (pengaturanak.btnTWTON.getText().equals("ON")){
                txtwaktu1.setVisible(true);
                txttanggal1.setVisible(true);
            }
            
            // Tampilkan Username
            if (pengaturan.btnTSON.getText()==null){
                userinfo.setVisible(false);
            } else {
                userinfo.setVisible(true);
            }
            
            // Tampilkan Username PAK
            if (pengaturanak.btnTSON.getText()==null){
                userinfo1.setVisible(false);
            } else {
                userinfo1.setVisible(true);
            }
            
            // Sembunyikan Opsi Grafik
            if (pengaturan.btnSOGON.getText()==null){
                dashboard.txttampilkan.setVisible(true);
                dashboard.dashboardcb.setVisible(true);
                
                laporan.txttampilkan.setVisible(true);
                laporan.dashboardcb.setVisible(true);
                
            } else {
                dashboard.txttampilkan.setVisible(false);
                dashboard.dashboardcb.setVisible(false);
//                dashboard.panelE.setVisible(false);
                laporan.txttampilkan.setVisible(false);
                laporan.dashboardcb.setVisible(false);
//                laporan.panelE.setVisible(false);
            }
            
            // Sembunyikan Opsi Urutkan
            if (pengaturan.btnSOUON.getText()==null){
                barang.teksbarang.setVisible(true);
                barang.barangcb.setVisible(true);
                supplier.tekssupplier.setVisible(true);
                supplier.suppliercb.setVisible(true);
            } else {
                barang.teksbarang.setVisible(false);
                barang.barangcb.setVisible(false);
                supplier.tekssupplier.setVisible(false);
                supplier.suppliercb.setVisible(false);
            }
            
            // Sembunyikan Opsi Urutkan PAK
            if (pengaturanak.btnSOUON.getText()==null){
                barang.teksbarang1.setVisible(true);
                barang.barangcb1.setVisible(true);
                supplier.tekssupplier1.setVisible(true);
                supplier.suppliercb1.setVisible(true);
            } else {
                barang.teksbarang1.setVisible(false);
                barang.barangcb1.setVisible(false);
                supplier.tekssupplier1.setVisible(false);
                supplier.suppliercb1.setVisible(false);
            }
            
            // Logout
            if (pengaturan.txtLogout.getText().equals("logout")){
                this.setVisible(false);
                new Login().setVisible(true);
                pengaturan.txtLogout.setText("login");
            }
            
            // Logout PAK
            if (pengaturanak.txtLogout.getText().equals("logout")){
                this.setVisible(false);
                new Login().setVisible(true);
                pengaturanak.txtLogout.setText("login");
            }
        };
    new Timer(100, taskPerformer).start();
    }
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 
    
    public MainForm() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        hakakses.setVisible(false);
//        pengaturanitem_hak();
        refreshPengaturan();
        waktu();
        txthide();
        hubungan();
        dsON.setText("on");
        menuColor();
        MenuDashboard.setBackground(new java.awt.Color(194,184,156));
        txtDashboard.setForeground(new java.awt.Color(0,0,0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPanel = new javax.swing.JPanel();
        MenuDashboard = new javax.swing.JPanel();
        txtDashboard = new javax.swing.JLabel();
        MenuBarang = new javax.swing.JPanel();
        txtBarang = new javax.swing.JLabel();
        MenuProdukmasuk = new javax.swing.JPanel();
        txtProdukmasuk = new javax.swing.JLabel();
        MenuTransaksi = new javax.swing.JPanel();
        txtTransaksi = new javax.swing.JLabel();
        MenuSupplier = new javax.swing.JPanel();
        txtSupplier = new javax.swing.JLabel();
        MenuLaporan = new javax.swing.JPanel();
        txtLaporan = new javax.swing.JLabel();
        MenuPengaturan = new javax.swing.JPanel();
        txtPengaturan = new javax.swing.JLabel();
        LogoVivace = new javax.swing.JLabel();
        txtversion = new javax.swing.JLabel();
        txtwaktu = new javax.swing.JLabel();
        txttanggal = new javax.swing.JLabel();
        txtwaktu1 = new javax.swing.JLabel();
        txttanggal1 = new javax.swing.JLabel();
        bacgroundsisikanan = new javax.swing.JLabel();
        hakakses = new javax.swing.JTextField();
        dsON = new javax.swing.JTextField();
        brON = new javax.swing.JTextField();
        pmON = new javax.swing.JTextField();
        trON = new javax.swing.JTextField();
        spON = new javax.swing.JTextField();
        lpON = new javax.swing.JTextField();
        stON = new javax.swing.JTextField();
        FormPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuPanel.setLayout(null);

        MenuDashboard.setBackground(new java.awt.Color(225, 225, 225));
        MenuDashboard.setToolTipText("");
        MenuDashboard.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MenuDashboardMouseMoved(evt);
            }
        });
        MenuDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuDashboardMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuDashboardMouseExited(evt);
            }
        });
        MenuDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDashboard.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        txtDashboard.setForeground(new java.awt.Color(153, 153, 153));
        txtDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/homeicon.png"))); // NOI18N
        txtDashboard.setText("       DASHBOARD");
        MenuDashboard.add(txtDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 60));

        MenuPanel.add(MenuDashboard);
        MenuDashboard.setBounds(0, 300, 300, 60);

        MenuBarang.setBackground(new java.awt.Color(244, 239, 224));
        MenuBarang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MenuBarangMouseMoved(evt);
            }
        });
        MenuBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuBarangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuBarangMouseExited(evt);
            }
        });
        MenuBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBarang.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        txtBarang.setForeground(new java.awt.Color(153, 153, 153));
        txtBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/barangicon.png"))); // NOI18N
        txtBarang.setText("       BARANG");
        MenuBarang.add(txtBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 60));

        MenuPanel.add(MenuBarang);
        MenuBarang.setBounds(0, 360, 300, 60);

        MenuProdukmasuk.setBackground(new java.awt.Color(244, 239, 224));
        MenuProdukmasuk.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MenuProdukmasukMouseMoved(evt);
            }
        });
        MenuProdukmasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuProdukmasukMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuProdukmasukMouseExited(evt);
            }
        });
        MenuProdukmasuk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProdukmasuk.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        txtProdukmasuk.setForeground(new java.awt.Color(153, 153, 153));
        txtProdukmasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/produkmasukicon.png"))); // NOI18N
        txtProdukmasuk.setText("       PRODUK MASUK");
        MenuProdukmasuk.add(txtProdukmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 60));

        MenuPanel.add(MenuProdukmasuk);
        MenuProdukmasuk.setBounds(0, 420, 300, 60);

        MenuTransaksi.setBackground(new java.awt.Color(244, 239, 224));
        MenuTransaksi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MenuTransaksiMouseMoved(evt);
            }
        });
        MenuTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuTransaksiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuTransaksiMouseExited(evt);
            }
        });
        MenuTransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTransaksi.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        txtTransaksi.setForeground(new java.awt.Color(153, 153, 153));
        txtTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/transaksiicon.png"))); // NOI18N
        txtTransaksi.setText("       TRANSAKSI");
        MenuTransaksi.add(txtTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 60));

        MenuPanel.add(MenuTransaksi);
        MenuTransaksi.setBounds(0, 480, 300, 60);

        MenuSupplier.setBackground(new java.awt.Color(244, 239, 224));
        MenuSupplier.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MenuSupplierMouseMoved(evt);
            }
        });
        MenuSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSupplierMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuSupplierMouseExited(evt);
            }
        });
        MenuSupplier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSupplier.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        txtSupplier.setForeground(new java.awt.Color(153, 153, 153));
        txtSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/suppliericon.icon.png"))); // NOI18N
        txtSupplier.setText("       SUPPLIER");
        MenuSupplier.add(txtSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 60));

        MenuPanel.add(MenuSupplier);
        MenuSupplier.setBounds(0, 540, 300, 60);

        MenuLaporan.setBackground(new java.awt.Color(244, 239, 224));
        MenuLaporan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MenuLaporanMouseMoved(evt);
            }
        });
        MenuLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuLaporanMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuLaporanMouseExited(evt);
            }
        });
        MenuLaporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLaporan.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        txtLaporan.setForeground(new java.awt.Color(153, 153, 153));
        txtLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/laporanicon.png"))); // NOI18N
        txtLaporan.setText("       LAPORAN");
        MenuLaporan.add(txtLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 60));

        MenuPanel.add(MenuLaporan);
        MenuLaporan.setBounds(0, 600, 300, 60);

        MenuPengaturan.setBackground(new java.awt.Color(244, 239, 224));
        MenuPengaturan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MenuPengaturanMouseMoved(evt);
            }
        });
        MenuPengaturan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPengaturanMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuPengaturanMouseExited(evt);
            }
        });
        MenuPengaturan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPengaturan.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        txtPengaturan.setForeground(new java.awt.Color(153, 153, 153));
        txtPengaturan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/settingicon.png"))); // NOI18N
        txtPengaturan.setText("       PENGATURAN");
        MenuPengaturan.add(txtPengaturan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 60));

        MenuPanel.add(MenuPengaturan);
        MenuPengaturan.setBounds(0, 660, 300, 60);

        LogoVivace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/VIVACEMUSIC 1.png"))); // NOI18N
        MenuPanel.add(LogoVivace);
        LogoVivace.setBounds(60, 30, 170, 160);

        userinfo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        userinfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/usericon.png"))); // NOI18N
        userinfo.setText("   Hai, Developers!");
        MenuPanel.add(userinfo);
        userinfo.setBounds(40, 240, 230, 40);

        userinfo1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        userinfo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/usericon.png"))); // NOI18N
        userinfo1.setText("   Hai, Developers!");
        MenuPanel.add(userinfo1);
        userinfo1.setBounds(40, 240, 230, 40);

        txtversion.setFont(new java.awt.Font("Monotype Corsiva", 0, 14)); // NOI18N
        txtversion.setText(" v1.0");
        MenuPanel.add(txtversion);
        txtversion.setBounds(254, 980, 30, 14);

        txtwaktu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MenuPanel.add(txtwaktu);
        txtwaktu.setBounds(30, 890, 190, 30);

        txttanggal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuPanel.add(txttanggal);
        txttanggal.setBounds(30, 924, 240, 30);

        txtwaktu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MenuPanel.add(txtwaktu1);
        txtwaktu1.setBounds(30, 890, 190, 30);

        txttanggal1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuPanel.add(txttanggal1);
        txttanggal1.setBounds(30, 924, 240, 30);

        bacgroundsisikanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Frame Menu.png"))); // NOI18N
        MenuPanel.add(bacgroundsisikanan);
        bacgroundsisikanan.setBounds(0, 0, 320, 1010);
        MenuPanel.add(hakakses);
        hakakses.setBounds(0, 0, 300, 20);

        dsON.setText("jTextField1");
        MenuPanel.add(dsON);
        dsON.setBounds(0, 0, 59, 20);

        brON.setText("jTextField1");
        MenuPanel.add(brON);
        brON.setBounds(0, 20, 59, 20);

        pmON.setText("jTextField1");
        MenuPanel.add(pmON);
        pmON.setBounds(0, 40, 59, 20);

        trON.setText("jTextField1");
        MenuPanel.add(trON);
        trON.setBounds(0, 60, 59, 20);

        spON.setText("jTextField1");
        MenuPanel.add(spON);
        spON.setBounds(0, 80, 59, 20);

        lpON.setText("jTextField1");
        MenuPanel.add(lpON);
        lpON.setBounds(0, 100, 59, 20);

        stON.setText("jTextField1");
        MenuPanel.add(stON);
        stON.setBounds(0, 140, 59, 20);

        getContentPane().add(MenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 1010));

        FormPanel.setLayout(new javax.swing.BoxLayout(FormPanel, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(FormPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 1600, 1010));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDashboardMouseClicked
        MenuPanel.setVisible(true);
        opsiMenu();
        dashboard.setVisible(true);
        dashboard.btnRefresh.setVisible(true);
        dashboard.btnSelesai.setVisible(false);
        dsON.setText("on");
        brON.setText("off");
        pmON.setText("off");
        trON.setText("off");
        spON.setText("off");
        lpON.setText("off");
        stON.setText("off");
        menuColor();
        if (dsON.getText().equals("on")){
            MenuDashboard.setBackground(new java.awt.Color(194,184,156));
            txtDashboard.setForeground(new java.awt.Color(0,0,0));
        }
        if (pengaturan.btnSOGOFF.getText()==null){
            dashboard.panelD.setVisible(true);
            dashboard.panelE.setVisible(false);
            dashboard.dashboardcb.setSelectedIndex(0);
        }
    }//GEN-LAST:event_MenuDashboardMouseClicked

    private void MenuBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBarangMouseClicked
        opsiMenu();
        barang.setVisible(menu1);
        barangkr.setVisible(menu5);
        dsON.setText("off");
        brON.setText("on");
        pmON.setText("off");
        trON.setText("off");
        spON.setText("off");
        lpON.setText("off");
        stON.setText("off");
        menuColor();
        if (brON.getText().equals("on")){
            MenuBarang.setBackground(new java.awt.Color(194,184,156));
            txtBarang.setForeground(new java.awt.Color(0,0,0));
        }
        barang.kosongkan();
        barang.txtstok.setEnabled(true);
    }//GEN-LAST:event_MenuBarangMouseClicked

    private void MenuProdukmasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuProdukmasukMouseClicked
        opsiMenu();
        produkmasuk.setVisible(menu2);
        produkmasukkr.setVisible(menu8);
        dsON.setText("off");
        brON.setText("off");
        pmON.setText("on");
        trON.setText("off");
        spON.setText("off");
        lpON.setText("off");
        stON.setText("off");
        menuColor();
        if (pmON.getText().equals("on")){
            MenuProdukmasuk.setBackground(new java.awt.Color(194,184,156));
            txtProdukmasuk.setForeground(new java.awt.Color(0,0,0));
        }
    }//GEN-LAST:event_MenuProdukmasukMouseClicked

    private void MenuTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTransaksiMouseClicked
        opsiMenu();
        transaksi.setVisible(true);
        dsON.setText("off");
        brON.setText("off");
        pmON.setText("off");
        trON.setText("on");
        spON.setText("off");
        lpON.setText("off");
        stON.setText("off");
        menuColor();
        if (trON.getText().equals("on")){
            MenuTransaksi.setBackground(new java.awt.Color(194,184,156));
            txtTransaksi.setForeground(new java.awt.Color(0,0,0));
        }
    }//GEN-LAST:event_MenuTransaksiMouseClicked

    private void MenuSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSupplierMouseClicked
        opsiMenu();
        supplier.setVisible(menu3);
        supplierkr.setVisible(menu6);
        dsON.setText("off");
        brON.setText("off");
        pmON.setText("off");
        trON.setText("off");
        spON.setText("on");
        lpON.setText("off");
        stON.setText("off");
        menuColor();
        if (spON.getText().equals("on")){
            MenuSupplier.setBackground(new java.awt.Color(194,184,156));
            txtSupplier.setForeground(new java.awt.Color(0,0,0));
        }
        supplier.kosongkan();
    }//GEN-LAST:event_MenuSupplierMouseClicked

    private void MenuLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLaporanMouseClicked
        opsiMenu();
        laporan.setVisible(true);
        dsON.setText("off");
        brON.setText("off");
        pmON.setText("off");
        trON.setText("off");
        spON.setText("off");
        lpON.setText("on");
        stON.setText("off");
        menuColor();
        if (lpON.getText().equals("on")){
            MenuLaporan.setBackground(new java.awt.Color(194,184,156));
            txtLaporan.setForeground(new java.awt.Color(0,0,0));
        }
        if (pengaturan.btnSOGOFF.getText()==null){
            laporan.panelLT.setVisible(true);
            laporan.panelE.setVisible(false);
            laporan.Laporancb.setVisible(true);
            laporan.Laporancb.setSelectedIndex(0);
            laporan.dashboardcb.setSelectedIndex(0);
        }
    }//GEN-LAST:event_MenuLaporanMouseClicked

    private void MenuPengaturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPengaturanMouseClicked
        opsiMenu();
        pengaturan.setVisible(menu4);
        pengaturanak.setVisible(menu7);
        dsON.setText("off");
        brON.setText("off");
        pmON.setText("off");
        trON.setText("off");
        spON.setText("off");
        lpON.setText("off");
        stON.setText("on");
        menuColor();
        if (stON.getText().equals("on")){
            MenuPengaturan.setBackground(new java.awt.Color(194,184,156));
            txtPengaturan.setForeground(new java.awt.Color(0,0,0));
        }
        if (hakakses.getText().equals("Karyawan")){
            pengaturanak.teksINFA.setVisible(false);
            pengaturanak.btnINFAEdit.setVisible(false);
        }
    }//GEN-LAST:event_MenuPengaturanMouseClicked

    private void MenuDashboardMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDashboardMouseMoved
        if (dsON.getText().equals("off")){
           MenuDashboard.setBackground(new java.awt.Color(225,225,225));
        }
    }//GEN-LAST:event_MenuDashboardMouseMoved

    private void MenuDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDashboardMouseExited
        if (dsON.getText().equals("off")){
           MenuDashboard.setBackground(new java.awt.Color(244, 239, 224));
        }
    }//GEN-LAST:event_MenuDashboardMouseExited

    private void MenuBarangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBarangMouseMoved
        if (brON.getText().equals("off")){
           MenuBarang.setBackground(new java.awt.Color(225,225,225));
        }
    }//GEN-LAST:event_MenuBarangMouseMoved

    private void MenuBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBarangMouseExited
        if (brON.getText().equals("off")){
           MenuBarang.setBackground(new java.awt.Color(244, 239, 224));
        }
    }//GEN-LAST:event_MenuBarangMouseExited

    private void MenuProdukmasukMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuProdukmasukMouseMoved
        if (pmON.getText().equals("off")){
           MenuProdukmasuk.setBackground(new java.awt.Color(225,225,225));
        }
    }//GEN-LAST:event_MenuProdukmasukMouseMoved

    private void MenuProdukmasukMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuProdukmasukMouseExited
        if (pmON.getText().equals("off")){
           MenuProdukmasuk.setBackground(new java.awt.Color(244, 239, 224));
        }
    }//GEN-LAST:event_MenuProdukmasukMouseExited

    private void MenuTransaksiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTransaksiMouseMoved
        if (trON.getText().equals("off")){
           MenuTransaksi.setBackground(new java.awt.Color(225,225,225));
        }
    }//GEN-LAST:event_MenuTransaksiMouseMoved

    private void MenuTransaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTransaksiMouseExited
        if (trON.getText().equals("off")){
           MenuTransaksi.setBackground(new java.awt.Color(244, 239, 224));
        }
    }//GEN-LAST:event_MenuTransaksiMouseExited

    private void MenuSupplierMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSupplierMouseMoved
        if (spON.getText().equals("off")){
           MenuSupplier.setBackground(new java.awt.Color(225,225,225));
        }
    }//GEN-LAST:event_MenuSupplierMouseMoved

    private void MenuSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSupplierMouseExited
        if (spON.getText().equals("off")){
           MenuSupplier.setBackground(new java.awt.Color(244, 239, 224));
        }
    }//GEN-LAST:event_MenuSupplierMouseExited

    private void MenuLaporanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLaporanMouseMoved
        if (lpON.getText().equals("off")){
           MenuLaporan.setBackground(new java.awt.Color(225,225,225));
        }
    }//GEN-LAST:event_MenuLaporanMouseMoved

    private void MenuLaporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLaporanMouseExited
        if (lpON.getText().equals("off")){
           MenuLaporan.setBackground(new java.awt.Color(244, 239, 224));
        }
    }//GEN-LAST:event_MenuLaporanMouseExited

    private void MenuPengaturanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPengaturanMouseMoved
        if (stON.getText().equals("off")){
           MenuPengaturan.setBackground(new java.awt.Color(225,225,225));
        }
    }//GEN-LAST:event_MenuPengaturanMouseMoved

    private void MenuPengaturanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPengaturanMouseExited
        if (stON.getText().equals("off")){
           MenuPengaturan.setBackground(new java.awt.Color(244, 239, 224));
        }
    }//GEN-LAST:event_MenuPengaturanMouseExited

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FormPanel;
    private javax.swing.JLabel LogoVivace;
    private javax.swing.JPanel MenuBarang;
    private javax.swing.JPanel MenuDashboard;
    private javax.swing.JPanel MenuLaporan;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel MenuPengaturan;
    private javax.swing.JPanel MenuProdukmasuk;
    private javax.swing.JPanel MenuSupplier;
    private javax.swing.JPanel MenuTransaksi;
    private javax.swing.JLabel bacgroundsisikanan;
    private javax.swing.JTextField brON;
    private javax.swing.JTextField dsON;
    protected javax.swing.JTextField hakakses;
    private javax.swing.JTextField lpON;
    private javax.swing.JTextField pmON;
    private javax.swing.JTextField spON;
    private javax.swing.JTextField stON;
    private javax.swing.JTextField trON;
    private javax.swing.JLabel txtBarang;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtLaporan;
    private javax.swing.JLabel txtPengaturan;
    private javax.swing.JLabel txtProdukmasuk;
    private javax.swing.JLabel txtSupplier;
    private javax.swing.JLabel txtTransaksi;
    private javax.swing.JLabel txttanggal;
    private javax.swing.JLabel txttanggal1;
    public javax.swing.JLabel txtversion;
    private javax.swing.JLabel txtwaktu;
    private javax.swing.JLabel txtwaktu1;
    public static final javax.swing.JLabel userinfo = new javax.swing.JLabel();
    public static final javax.swing.JLabel userinfo1 = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
