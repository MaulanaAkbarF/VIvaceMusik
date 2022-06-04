/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

package Form;

import com.sun.glass.events.KeyEvent;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FormTransaksi extends javax.swing.JPanel {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi
    */ 
    
    // Tabel model
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    
    private void load_tabelbr() {
        model.addColumn("No");
        model.addColumn("ID Alat Musik");
        model.addColumn("Nama Alat Musik");
        model.addColumn("Harga Beli");
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

        model2.addColumn("ID Transaksi");
        model2.addColumn("ID Alat Musik ");
        model2.addColumn("Nama Alat Musik");
        model2.addColumn("Harga");
        model2.addColumn("Jumlah");
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
        txtidpembeli.setVisible(false);
        txtstok.setVisible(false);
        pbON.setVisible(false);
    }
    
    private void kosongkan(){
        txtidbarang.setText(null);
        txtjumlah.setText(null);
        txthargatotal.setText(null);
        txtpembayaran.setText(null);
        txtpembayaranauto.setText(null);
        txtkembalian.setText(null);
        
    }
    
    private void auto_kdTR() {
        txtidtransaksi.disable();
        try{
        String sql = "SELECT MAX(RIGHT(idtransaksi,8)) FROM transaksi";
        java.sql.Connection con = (Connection) Config.configDB();
        java.sql.Statement st = con.createStatement();
        java.sql.ResultSet rst = st.executeQuery(sql);
        if(rst.next()) {
            String auto_kdtransaksi, tambah;
            int kdb;
            auto_kdtransaksi = Integer.toString(rst.getInt(1)+1);
            kdb = auto_kdtransaksi.length();
            tambah = "";
            for (int i = 1; i <= 8 - kdb; i++ ){
                tambah = tambah + "0";
            }
            txtidtransaksi.setText("IT"+tambah+auto_kdtransaksi);
            
         }
        }
        catch (Exception e) {
            txtidtransaksi.setText("IT00000001");
        }
    }
    
    
    private void auto_kdPB() {
        txtidpembeli.disable();
        try{
        String sql = "SELECT MAX(RIGHT(idpembeli,8)) FROM pembeli";
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
            txtidpembeli.setText("PB"+tambah+auto_kdPM);
            }
        }
        catch (Exception e) {
            txtidpembeli.setText("PB00000001");
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

    public FormTransaksi() {
        initComponents();
        hidebtn();
        pbON.setText("off");
        btnHapuspb.setVisible(false);
        btnSegarkan.setVisible(false);
        btnHitungdancetak.setVisible(false);
        txtpembayaranauto.setVisible(false);
        btnAktifkanON.setVisible(false);
        btnAktifkanOFFX.setVisible(false);
        jLabel4.setVisible(false);
        auto_kdTR();
        auto_kdPB();
        load_tabelbr();
        lebar_tabelbr();
        load_tabelkeranjang();
        lebar_tabelkeranjang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMenu = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        btnCetak = new javax.swing.JLabel();
        btnHitung = new javax.swing.JLabel();
        btnSegarkan = new javax.swing.JLabel();
        btnHitungdancetak = new javax.swing.JLabel();
        btnTambahkan = new javax.swing.JLabel();
        btnTambahpb = new javax.swing.JLabel();
        btnHapuspb = new javax.swing.JLabel();
        btnCaribr = new javax.swing.JLabel();
        txtcaribarang = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        txtpembayaran = new javax.swing.JTextField();
        txtpembayaranauto = new javax.swing.JTextField();
        txthargatotal = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        txtidbarang = new javax.swing.JTextField();
        txtnamapembeli = new javax.swing.JTextField();
        txtidtransaksi = new javax.swing.JTextField();
        txtAktifkan = new javax.swing.JLabel();
        btnAktifkanOFFX = new javax.swing.JLabel();
        btnAktifkanOFF = new javax.swing.JLabel();
        btnAktifkanON = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        daftar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtidpembeli = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txthargabeli = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        pbON = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        txtMenu.setText("Transaksi");
        txtMenu.setAlignmentY(0.0F);
        add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 400, 45));

        btnReset.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnReset.setForeground(new java.awt.Color(95, 95, 95));
        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReset.setText("RESET BELANJAAN");
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

        btnSegarkan.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnSegarkan.setForeground(new java.awt.Color(95, 95, 95));
        btnSegarkan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSegarkan.setText("SEGARKAN");
        btnSegarkan.setPreferredSize(new java.awt.Dimension(104, 36));
        btnSegarkan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSegarkanMouseMoved(evt);
            }
        });
        btnSegarkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSegarkanMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSegarkanMouseExited(evt);
            }
        });
        add(btnSegarkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(984, 903, 235, 38));

        btnHitungdancetak.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnHitungdancetak.setForeground(new java.awt.Color(95, 95, 95));
        btnHitungdancetak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHitungdancetak.setText("HITUNG DAN CETAK");
        btnHitungdancetak.setPreferredSize(new java.awt.Dimension(104, 36));
        btnHitungdancetak.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnHitungdancetakMouseMoved(evt);
            }
        });
        btnHitungdancetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHitungdancetakMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHitungdancetakMouseExited(evt);
            }
        });
        add(btnHitungdancetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(984, 903, 523, 38));

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

        btnTambahpb.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnTambahpb.setForeground(new java.awt.Color(95, 95, 95));
        btnTambahpb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTambahpb.setText("TAMBAH");
        btnTambahpb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTambahpb.setPreferredSize(new java.awt.Dimension(104, 36));
        btnTambahpb.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTambahpbMouseMoved(evt);
            }
        });
        btnTambahpb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahpbMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahpbMouseExited(evt);
            }
        });
        add(btnTambahpb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 34, 154, 30));

        btnHapuspb.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnHapuspb.setForeground(new java.awt.Color(95, 95, 95));
        btnHapuspb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapuspb.setText("HAPUS");
        btnHapuspb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHapuspb.setPreferredSize(new java.awt.Dimension(104, 36));
        btnHapuspb.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnHapuspbMouseMoved(evt);
            }
        });
        btnHapuspb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapuspbMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHapuspbMouseExited(evt);
            }
        });
        add(btnHapuspb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 34, 154, 30));

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

        txtcaribarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcaribarang.setBorder(null);
        txtcaribarang.setOpaque(false);
        txtcaribarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaribarangActionPerformed(evt);
            }
        });
        add(txtcaribarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 230, 40));

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

        txtpembayaranauto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtpembayaranauto.setBorder(null);
        txtpembayaranauto.setOpaque(false);
        txtpembayaranauto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpembayaranautoActionPerformed(evt);
            }
        });
        add(txtpembayaranauto, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 740, 510, 40));

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
        txtidbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidbarangActionPerformed(evt);
            }
        });
        add(txtidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 260, 510, 40));

        txtnamapembeli.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnamapembeli.setBorder(null);
        txtnamapembeli.setOpaque(false);
        add(txtnamapembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 70, 310, 40));

        txtidtransaksi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtidtransaksi.setBorder(null);
        txtidtransaksi.setOpaque(false);
        add(txtidtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, 200, 40));

        txtAktifkan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAktifkan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAktifkan.setText("Aktifkan Cetak Faktur Otomatis :");
        add(txtAktifkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 520, 210, 20));

        btnAktifkanOFFX.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAktifkanOFFX.setForeground(new java.awt.Color(95, 95, 95));
        btnAktifkanOFFX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAktifkanOFFX.setText("OFF");
        btnAktifkanOFFX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAktifkanOFFXMouseClicked(evt);
            }
        });
        add(btnAktifkanOFFX, new org.netbeans.lib.awtextra.AbsoluteConstraints(1485, 520, 40, 20));

        btnAktifkanOFF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAktifkanOFF.setForeground(new java.awt.Color(95, 95, 95));
        btnAktifkanOFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAktifkanOFF.setText("OFF");
        btnAktifkanOFF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAktifkanOFFMouseMoved(evt);
            }
        });
        btnAktifkanOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAktifkanOFFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAktifkanOFFMouseExited(evt);
            }
        });
        add(btnAktifkanOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1485, 520, 40, 20));

        btnAktifkanON.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAktifkanON.setForeground(new java.awt.Color(95, 95, 95));
        btnAktifkanON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAktifkanON.setText("ON");
        btnAktifkanON.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAktifkanONMouseMoved(evt);
            }
        });
        btnAktifkanON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAktifkanONMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAktifkanONMouseExited(evt);
            }
        });
        add(btnAktifkanON, new org.netbeans.lib.awtextra.AbsoluteConstraints(1485, 520, 40, 20));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Transaksi.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Transaksi 2.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        txtidpembeli.setText("jTextField1");
        add(txtidpembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        txtnamabarang.setText("jTextField1");
        add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        txthargabeli.setText("jTextField1");
        add(txthargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        txtstok.setText("jTextField1");
        add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, -1, -1));

        pbON.setText("jLabel2");
        add(pbON, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    // Variabel untuk tabelMouseClicked
    public String idbr, namabr, hargabelibr, stokbr;
    
    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int x = tabel.getSelectedRow();
        int baris = tabel.rowAtPoint(evt.getPoint());
        if (tabel.getValueAt(baris, 1)==null){
            txtidbarang.setText("");    
        } else {
            txtidbarang.setText(tabel.getValueAt(baris, 1).toString());
            txtidbarang.setEditable(false);
            String id = model.getValueAt(x, 1).toString();
            idbr = id;
        }
        if (tabel.getValueAt(baris, 2)==null){
            txtidbarang.setText("");
        } else {
            String nama = model.getValueAt(x, 2).toString();
            namabr = nama;
        }
        if (tabel.getValueAt(baris, 3)==null){
            txtidbarang.setText("");
        } else {
            String harga = model.getValueAt(x, 3).toString();
            hargabelibr = harga;
        }
        
        stokbr = model.getValueAt(x, 4).toString();
        System.out.println(stokbr);
    }//GEN-LAST:event_tabelMouseClicked

    // Variabel untuk daftarMouseClicked
    public int mctp;
    
    private void daftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarMouseClicked
        int mct = daftar.getSelectedRow();
        mctp = mct;
    }//GEN-LAST:event_daftarMouseClicked

    private void btnCaribrMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaribrMouseMoved
        btnCaribr.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCaribrMouseMoved

    private void btnCaribrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaribrMouseClicked
        try {
            String sqls = "SELECT idalatmusik, namaalatmusik, harga_beli, stok FROM alatmusik WHERE idalatmusik LIKE '%"+txtcaribarang.getText()+
            "%' OR namaalatmusik LIKE '%"+txtcaribarang.getText()+"%' OR harga_beli LIKE '"+txtcaribarang.getText()+
            "' OR stok LIKE '"+txtcaribarang.getText()+"' ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4)});
            }
        tabel.setModel(model);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnCaribrMouseClicked

    private void btnCaribrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaribrMouseExited
        btnCaribr.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCaribrMouseExited

    private void txtcaribarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaribarangActionPerformed
        try {
            String sqls = "SELECT idalatmusik, namaalatmusik, harga_beli, stok FROM alatmusik WHERE idalatmusik LIKE '%"+txtcaribarang.getText()+
            "%' OR namaalatmusik LIKE '%"+txtcaribarang.getText()+"%' OR harga_beli LIKE '"+txtcaribarang.getText()+
            "' OR stok LIKE '"+txtcaribarang.getText()+"' ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4)});
            }
        tabel.setModel(model);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_txtcaribarangActionPerformed

    private void btnTambahpbMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahpbMouseMoved
        btnTambahpb.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTambahpbMouseMoved

    private void btnTambahpbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahpbMouseClicked
        try {        
        String sql1 = "INSERT INTO pembeli VALUES('"+txtidpembeli.getText()+"','"+txtnamapembeli.getText()+"')";
        String sql2 = "INSERT INTO transaksi (idtransaksi, idpembeli, tanggal) VALUES ('"+txtidtransaksi.getText()+"','"+txtidpembeli.getText()+"', CURRENT_TIMESTAMP)";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
        pst1.execute();
        pst2.execute();
        JOptionPane.showMessageDialog(null,"Data Pembeli dan Transaksi Berhasil Ditambahkan","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
        pbON.setText("on");
        txtnamapembeli.setEnabled(false);
        btnTambahpb.setVisible(false);
        btnHapuspb.setVisible(true);
        txthargatotal.setText(null);
        txtpembayaran.setText(null);
        txtkembalian.setText(null);
        peralihan = -1;
        
    } catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
    }
    }//GEN-LAST:event_btnTambahpbMouseClicked

    private void btnTambahpbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahpbMouseExited
        btnTambahpb.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTambahpbMouseExited

    private void btnTambahkanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahkanMouseMoved
        btnTambahkan.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTambahkanMouseMoved

    // Variabel untuk btnTambahkan
    public int peralihan = -1;
    
    private void btnTambahkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahkanMouseClicked
        if (pbON.getText().equals("off")){
                JOptionPane.showMessageDialog(null,"Tidak dapat menambahkan barang!\nTambahkan nama pembeli terlebih dahulu","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else if (txtjumlah.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Tentukan jumlah barang dibeli terlebih dahulu.","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
            int stok  = Integer.parseInt(stokbr);
            String jumlah = txtjumlah.getText();
            int jumlah1 = Integer.parseInt(jumlah);
          
            if(stok <= 0 || jumlah1 > stok){
                JOptionPane.showMessageDialog(null, "Stok barang kurang atau barang tidak tersedia","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
            } else {
                int harga1 = Integer.parseInt(hargabelibr);
                int total = jumlah1 * harga1;
                txthargabeli.setText(String.valueOf(total));

                Date date = new Date();
                DateFormat formattanggal = new SimpleDateFormat("yyyy-MM-dd");
                String sekarang = formattanggal.format(date);
                
                int c = daftar.getRowCount();
                int i = 0;
                do{
                    if (c!= 0 && daftar.getValueAt(i, 1).toString().equals(txtidbarang.getText())){
                        int jml1 = Integer.parseInt(daftar.getValueAt(i, 4).toString());
                        int jml2 = jumlah1 + jml1;
                        int hr1 = jml2 * harga1;
                        daftar.setValueAt(jml2, i, 4);
                        daftar.setValueAt(hr1,i,5);
                    }else{
                        peralihan++;
                    }
                    i++;
                    
                }while(i<c);

                if(peralihan == c){
                     model2.addRow (new Object[] {txtidtransaksi.getText(), idbr, namabr, hargabelibr, jumlah, total, sekarang});
                     
                }
                peralihan= 0;
                tambahtotalkeranjang();
                txtjumlah.setText(null);
            }
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
        txthargatotal.setText(null);
        peralihan = -1;
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseExited
        btnReset.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnResetMouseExited

    private void txtpembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpembayaranActionPerformed
        Date date = new Date();
        DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
        String sekarang = formattanggal.format(date);
        
        int bayar = Integer.parseInt(txtpembayaran.getText());
        int totalharga = Integer.parseInt(txthargatotal.getText());
        
            int kembalian = totalharga - bayar;
            if(bayar>=totalharga){
                txtkembalian.setText(String.valueOf(Math.abs(kembalian)));
                JOptionPane.showMessageDialog(this, "Pembayaran Berhasil","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
                try{
                    for(int i = 0; i < model2.getRowCount(); i++){
                        String sql = "INSERT INTO detail_transaksi VALUE('"+model2.getValueAt(i, 0)+"',"
                            + " '"+model2.getValueAt(i, 1)+"', '"+model2.getValueAt(i, 3)+"', "
                            + "'"+model2.getValueAt(i, 4)+"', '"+model2.getValueAt(i, 5)+"', '"+model2.getValueAt(i, 6)+"')";
                        String sql2 = "UPDATE transaksi SET subtotal = "+txthargatotal.getText()+", pembayaran = "+txtpembayaran.getText()+","
                                + "kembalian = "+txtkembalian.getText()+" WHERE idtransaksi = '"+txtidtransaksi.getText()+"'";
                        Connection conn = (Connection)Config.configDB();
                        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
                        pst.execute();
                        pst2.execute();
                        btnHitung.setVisible(false);
                        btnSegarkan.setVisible(true);
                        btnAktifkanOFF.setVisible(false);
                        btnAktifkanOFFX.setVisible(true);
                    }
                    
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, e.getMessage(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null,"Pembayaran Gagal!\nUang yang di bayarkan kurang sebesar RP."+kembalian,"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
            }
    }//GEN-LAST:event_txtpembayaranActionPerformed

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
                JOptionPane.showMessageDialog(this, "Pembayaran Berhasil","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
                try{
                    for(int i = 0; i < model2.getRowCount(); i++){
                        String sql = "INSERT INTO detail_transaksi VALUE('"+model2.getValueAt(i, 0)+"',"
                            + " '"+model2.getValueAt(i, 1)+"', '"+model2.getValueAt(i, 3)+"', "
                            + "'"+model2.getValueAt(i, 4)+"', '"+model2.getValueAt(i, 5)+"', '"+model2.getValueAt(i, 6)+"')";
                        String sql2 = "UPDATE transaksi SET subtotal = "+txthargatotal.getText()+", pembayaran = "+txtpembayaran.getText()+","
                                + "kembalian = "+txtkembalian.getText()+" WHERE idtransaksi = '"+txtidtransaksi.getText()+"'";
                        Connection conn = (Connection)Config.configDB();
                        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
                        pst.execute();
                        pst2.execute();
                        btnHitung.setVisible(false);
                        btnSegarkan.setVisible(true);
                        btnAktifkanOFF.setVisible(false);
                        btnAktifkanOFFX.setVisible(true);
                    }
                    
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, e.getMessage(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null,"Pembayaran Gagal!\nUang yang di bayarkan kurang sebesar RP."+kembalian,"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
            }
    }//GEN-LAST:event_btnHitungMouseClicked

    private void btnHitungMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitungMouseExited
        btnHitung.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnHitungMouseExited

    private void btnCetakMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseMoved
        btnCetak.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCetakMouseMoved

    private void btnCetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseClicked
        if (txtkembalian.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Tidak dapat mencetak faktur!\nHarap lakukan pembayaran terlebih dahulu","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
        try{
              JasperDesign jessp = JRXmlLoader.load("C:\\Users\\Maulana Akbar\\Documents\\NetBeansProjects\\VivaceMusic1\\src\\Form\\report1.jrxml");
              
              String sql = "SELECT\n" +
            "     transaksi.`idtransaksi` AS transaksi_idtransaksi,\n" +
            "     transaksi.`idpembeli` AS transaksi_idpembeli,\n" +
            "     transaksi.`tanggal` AS transaksi_tanggal,\n" +
            "     detail_transaksi.`idtransaksi` AS detail_transaksi_idtransaksi,\n" +
            "     detail_transaksi.`idalatmusik` AS detail_transaksi_idalatmusik,\n" +
            "     detail_transaksi.`harga` AS detail_transaksi_harga,\n" +
            "     detail_transaksi.`jumlah` AS detail_transaksi_jumlah,\n" +
            "     detail_transaksi.`totalharga` AS detail_transaksi_totalharga,\n" +
            "     detail_transaksi.`tanggal` AS detail_transaksi_tanggal,\n" +
            "     alatmusik.`idalatmusik` AS alatmusik_idalatmusik,\n" +
            "     transaksi.`kembalian` AS transaksi_kembalian,\n" +
            "     transaksi.`pembayaran` AS transaksi_pembayaran,\n" +
            "     transaksi.`subtotal` AS transaksi_subtotal,\n" +
            "     alatmusik.`namaalatmusik` AS alatmusik_namaalatmusik\n" +
            "FROM\n" +
            "     `transaksi` transaksi INNER JOIN `detail_transaksi` detail_transaksi ON transaksi.`idtransaksi` = detail_transaksi.`idtransaksi`\n" +
            "     INNER JOIN `alatmusik` alatmusik ON detail_transaksi.`idalatmusik` = alatmusik.`idalatmusik` WHERE transaksi.idtransaksi = '"+txtidtransaksi.getText()+"'";

               Connection con = (Connection) Config.configDB();
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jessp.setQuery(newQuery);
                JasperReport js = JasperCompileManager.compileReport(jessp);
                JasperPrint jp = JasperFillManager.fillReport(js, null, con);
              
                JasperViewer.viewReport(jp,false);
              
          }
          catch(Exception e){
              JOptionPane.showMessageDialog(null, e,"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
          }
        }
    }//GEN-LAST:event_btnCetakMouseClicked

    private void btnCetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseExited
        btnCetak.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCetakMouseExited

    private void btnHapuspbMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapuspbMouseMoved
        btnHapuspb.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnHapuspbMouseMoved

    private void btnHapuspbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapuspbMouseClicked
        try {        
        String sql1 = "DELETE FROM pembeli WHERE idpembeli = '"+txtidpembeli.getText()+"'";
        String sql2 = "DELETE FROM transaksi WHERE idtransaksi= '"+txtidtransaksi.getText()+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
        pst2.execute();
        pst1.execute();
        JOptionPane.showMessageDialog(null,"Data Pembeli dan Transaksi Berhasil Dihapus","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
        pbON.setText("on");
        txtnamapembeli.setText(null);
        txtnamapembeli.setEnabled(true);
        btnTambahpb.setVisible(true);
        btnHapuspb.setVisible(false);
        txthargatotal.setText(null);
        txtpembayaran.setText(null);
        txtkembalian.setText(null);
        model2.setRowCount(0);
        peralihan = -1;
        
    } catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
    }
    }//GEN-LAST:event_btnHapuspbMouseClicked

    private void btnHapuspbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapuspbMouseExited
        btnHapuspb.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnHapuspbMouseExited

    private void btnHitungdancetakMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitungdancetakMouseMoved
        btnHitungdancetak.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnHitungdancetakMouseMoved

    private void btnHitungdancetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitungdancetakMouseClicked
        Date date = new Date();
        DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
        String sekarang = formattanggal.format(date);
        
        int bayar = Integer.parseInt(txtpembayaranauto.getText());
        int totalharga = Integer.parseInt(txthargatotal.getText());
        
            int kembalian = totalharga - bayar;
            if(bayar>=totalharga){
                txtkembalian.setText(String.valueOf(Math.abs(kembalian)));
                JOptionPane.showMessageDialog(this, "Pembayaran Berhasil","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
                try{
                    for(int i = 0; i < model2.getRowCount(); i++){
                        String sql = "INSERT INTO detail_transaksi VALUE('"+model2.getValueAt(i, 0)+"',"
                            + " '"+model2.getValueAt(i, 1)+"', '"+model2.getValueAt(i, 3)+"', "
                            + "'"+model2.getValueAt(i, 4)+"', '"+model2.getValueAt(i, 5)+"', '"+model2.getValueAt(i, 6)+"')";
                        String sql2 = "UPDATE transaksi SET subtotal = "+txthargatotal.getText()+", pembayaran = "+txtpembayaranauto.getText()+","
                                + "kembalian = "+txtkembalian.getText()+" WHERE idtransaksi = '"+txtidtransaksi.getText()+"'";
                        Connection conn = (Connection)Config.configDB();
                        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
                        pst.execute();
                        pst2.execute();
                        
                        try{
                                JasperDesign jessp = JRXmlLoader.load("C:\\Users\\Maulana Akbar\\Documents\\NetBeansProjects\\VivaceMusic1\\src\\Form\\report1.jrxml");

                                String sql3 = "SELECT\n" +
                                "     transaksi.`idtransaksi` AS transaksi_idtransaksi,\n" +
                                "     transaksi.`idpembeli` AS transaksi_idpembeli,\n" +
                                "     transaksi.`tanggal` AS transaksi_tanggal,\n" +
                                "     detail_transaksi.`idtransaksi` AS detail_transaksi_idtransaksi,\n" +
                                "     detail_transaksi.`idalatmusik` AS detail_transaksi_idalatmusik,\n" +
                                "     detail_transaksi.`harga` AS detail_transaksi_harga,\n" +
                                "     detail_transaksi.`jumlah` AS detail_transaksi_jumlah,\n" +
                                "     detail_transaksi.`totalharga` AS detail_transaksi_totalharga,\n" +
                                "     detail_transaksi.`tanggal` AS detail_transaksi_tanggal,\n" +
                                "     alatmusik.`idalatmusik` AS alatmusik_idalatmusik,\n" +
                                "     transaksi.`kembalian` AS transaksi_kembalian,\n" +
                                "     transaksi.`pembayaran` AS transaksi_pembayaran,\n" +
                                "     transaksi.`subtotal` AS transaksi_subtotal,\n" +
                                "     alatmusik.`namaalatmusik` AS alatmusik_namaalatmusik\n" +
                                "FROM\n" +
                                "     `transaksi` transaksi INNER JOIN `detail_transaksi` detail_transaksi ON transaksi.`idtransaksi` = detail_transaksi.`idtransaksi`\n" +
                                "     INNER JOIN `alatmusik` alatmusik ON detail_transaksi.`idalatmusik` = alatmusik.`idalatmusik` WHERE transaksi.idtransaksi = '"+txtidtransaksi.getText()+"'";

                                 Connection con = (Connection) Config.configDB();
                                  JRDesignQuery newQuery = new JRDesignQuery();
                                  newQuery.setText(sql3);
                                  jessp.setQuery(newQuery);
                                  JasperReport js = JasperCompileManager.compileReport(jessp);
                                  JasperPrint jp = JasperFillManager.fillReport(js, null, con);

                                  JasperViewer.viewReport(jp,false);
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null, e,"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
                            }
                        pbON.setText("off");
                        txtnamapembeli.setText(null);
                        txtnamapembeli.setEnabled(true);
                        btnTambahpb.setVisible(true);
                        btnHapuspb.setVisible(false);model.setRowCount(0);
                        model.setColumnCount(0);
                        load_tabelbr();
                        lebar_tabelbr();
                        model2.setRowCount(0);
                        model2.setColumnCount(0);
                        load_tabelkeranjang();
                        lebar_tabelkeranjang();
                        kosongkan();
                        auto_kdTR();
                        auto_kdPB();
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(null,"Pembayaran Gagal!\nUang yang di bayarkan kurang sebesar RP."+kembalian,"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
            }
    }//GEN-LAST:event_btnHitungdancetakMouseClicked

    private void btnHitungdancetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitungdancetakMouseExited
        btnHitungdancetak.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnHitungdancetakMouseExited

    private void btnSegarkanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSegarkanMouseMoved
        btnSegarkan.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSegarkanMouseMoved

    private void btnSegarkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSegarkanMouseClicked
        pbON.setText("off");
            txtnamapembeli.setText(null);
            txtnamapembeli.setEnabled(true);
            btnTambahpb.setVisible(true);
            btnHapuspb.setVisible(false);
            model.setRowCount(0);
            model.setColumnCount(0);
            load_tabelbr();
            lebar_tabelbr();
            model2.setRowCount(0);
            model2.setColumnCount(0);
            load_tabelkeranjang();
            lebar_tabelkeranjang();
            kosongkan();
            auto_kdTR();
            auto_kdPB();
            btnAktifkanOFF.setVisible(true);
            btnAktifkanOFFX.setVisible(false);
            btnHitung.setVisible(true);
            btnSegarkan.setVisible(false);
    }//GEN-LAST:event_btnSegarkanMouseClicked

    private void btnSegarkanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSegarkanMouseExited
        btnSegarkan.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSegarkanMouseExited

    private void txtpembayaranautoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpembayaranautoActionPerformed
        Date date = new Date();
        DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
        String sekarang = formattanggal.format(date);
        
        int bayar = Integer.parseInt(txtpembayaranauto.getText());
        int totalharga = Integer.parseInt(txthargatotal.getText());
        
            int kembalian = totalharga - bayar;
            if(bayar>=totalharga){
                txtkembalian.setText(String.valueOf(Math.abs(kembalian)));
                JOptionPane.showMessageDialog(this, "Pembayaran Berhasil","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
                try{
                    for(int i = 0; i < model2.getRowCount(); i++){
                        String sql = "INSERT INTO detail_transaksi VALUE('"+model2.getValueAt(i, 0)+"',"
                            + " '"+model2.getValueAt(i, 1)+"', '"+model2.getValueAt(i, 3)+"', "
                            + "'"+model2.getValueAt(i, 4)+"', '"+model2.getValueAt(i, 5)+"', '"+model2.getValueAt(i, 6)+"')";
                        String sql2 = "UPDATE transaksi SET subtotal = "+txthargatotal.getText()+", pembayaran = "+txtpembayaranauto.getText()+","
                                + "kembalian = "+txtkembalian.getText()+" WHERE idtransaksi = '"+txtidtransaksi.getText()+"'";
                        Connection conn = (Connection)Config.configDB();
                        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
                        pst.execute();
                        pst2.execute();
                        
                        try{
                                JasperDesign jessp = JRXmlLoader.load("C:\\Users\\Maulana Akbar\\Documents\\NetBeansProjects\\VivaceMusic1\\src\\Form\\report1.jrxml");

                                String sql3 = "SELECT\n" +
                                "     transaksi.`idtransaksi` AS transaksi_idtransaksi,\n" +
                                "     transaksi.`idpembeli` AS transaksi_idpembeli,\n" +
                                "     transaksi.`tanggal` AS transaksi_tanggal,\n" +
                                "     detail_transaksi.`idtransaksi` AS detail_transaksi_idtransaksi,\n" +
                                "     detail_transaksi.`idalatmusik` AS detail_transaksi_idalatmusik,\n" +
                                "     detail_transaksi.`harga` AS detail_transaksi_harga,\n" +
                                "     detail_transaksi.`jumlah` AS detail_transaksi_jumlah,\n" +
                                "     detail_transaksi.`totalharga` AS detail_transaksi_totalharga,\n" +
                                "     detail_transaksi.`tanggal` AS detail_transaksi_tanggal,\n" +
                                "     alatmusik.`idalatmusik` AS alatmusik_idalatmusik,\n" +
                                "     transaksi.`kembalian` AS transaksi_kembalian,\n" +
                                "     transaksi.`pembayaran` AS transaksi_pembayaran,\n" +
                                "     transaksi.`subtotal` AS transaksi_subtotal,\n" +
                                "     alatmusik.`namaalatmusik` AS alatmusik_namaalatmusik\n" +
                                "FROM\n" +
                                "     `transaksi` transaksi INNER JOIN `detail_transaksi` detail_transaksi ON transaksi.`idtransaksi` = detail_transaksi.`idtransaksi`\n" +
                                "     INNER JOIN `alatmusik` alatmusik ON detail_transaksi.`idalatmusik` = alatmusik.`idalatmusik` WHERE transaksi.idtransaksi = '"+txtidtransaksi.getText()+"'";

                                 Connection con = (Connection) Config.configDB();
                                  JRDesignQuery newQuery = new JRDesignQuery();
                                  newQuery.setText(sql3);
                                  jessp.setQuery(newQuery);
                                  JasperReport js = JasperCompileManager.compileReport(jessp);
                                  JasperPrint jp = JasperFillManager.fillReport(js, null, con);

                                  JasperViewer.viewReport(jp,false);
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null, e,"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
                            }
                        pbON.setText("off");
                        txtnamapembeli.setText(null);
                        txtnamapembeli.setEnabled(true);
                        btnTambahpb.setVisible(true);
                        btnHapuspb.setVisible(false);model.setRowCount(0);
                        model.setColumnCount(0);
                        load_tabelbr();
                        lebar_tabelbr();
                        model2.setRowCount(0);
                        model2.setColumnCount(0);
                        load_tabelkeranjang();
                        lebar_tabelkeranjang();
                        kosongkan();
                        auto_kdTR();
                        auto_kdPB();
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(null,"Pembayaran Gagal!\nUang yang di bayarkan kurang sebesar RP."+kembalian,"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
            }
    }//GEN-LAST:event_txtpembayaranautoActionPerformed

    private void btnAktifkanOFFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAktifkanOFFMouseMoved
        btnAktifkanOFF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnAktifkanOFFMouseMoved

    private void btnAktifkanOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAktifkanOFFMouseClicked
        btnAktifkanOFF.setText(null);
        btnAktifkanOFF.setVisible(false);
        btnAktifkanON.setText("ON");
        btnAktifkanON.setVisible(true);
        btnCetak.setVisible(false);
        btnHitung.setVisible(false);
        btnSegarkan.setVisible(false);
        txtpembayaran.setVisible(false);
        btnHitungdancetak.setVisible(true);
        txtpembayaranauto.setVisible(true);
        jLabel1.setVisible(false);
        jLabel4.setVisible(true);
    }//GEN-LAST:event_btnAktifkanOFFMouseClicked

    private void btnAktifkanOFFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAktifkanOFFMouseExited
        btnAktifkanOFF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnAktifkanOFFMouseExited

    private void btnAktifkanONMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAktifkanONMouseMoved
        btnAktifkanON.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnAktifkanONMouseMoved

    private void btnAktifkanONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAktifkanONMouseClicked
        btnAktifkanOFF.setText("OFF");
        btnAktifkanOFF.setVisible(true);
        btnAktifkanON.setText(null);
        btnAktifkanON.setVisible(false);
        btnCetak.setVisible(true);
        btnHitung.setVisible(true);
        btnSegarkan.setVisible(false);
        txtpembayaran.setVisible(true);
        btnHitungdancetak.setVisible(false);
        txtpembayaranauto.setVisible(false);
        jLabel1.setVisible(true);
        jLabel4.setVisible(false);
    }//GEN-LAST:event_btnAktifkanONMouseClicked

    private void btnAktifkanONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAktifkanONMouseExited
        btnAktifkanON.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnAktifkanONMouseExited

    
    public int peralihanbarang = 0;
    
    private void txtidbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidbarangActionPerformed
        int jmltabl = tabel.getRowCount(); 
        int pl = 0;
        if (pbON.getText().equals("off")){
                    JOptionPane.showMessageDialog(null,"Tidak dapat menambahkan barang!\nTambahkan nama pembeli terlebih dahulu","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }else{
            do{
                 if(tabel.getValueAt(pl, 1).toString().equals(txtidbarang.getText())){
                    String idBarang = tabel.getValueAt(pl, 1).toString();
                    String namaBarang = tabel.getValueAt(pl,2).toString();
                    int hargaBarang = Integer.parseInt( tabel.getValueAt(pl, 3).toString());

                    int stok  = Integer.parseInt(tabel.getValueAt(pl, 4).toString());
    //                String jumlah = txtjumlah.getText();
                    int jumlah1 = 1;



                        if(stok <= 0 || jumlah1 > stok){
                            JOptionPane.showMessageDialog(null, "Stok barang kurang atau barang tidak tersedia","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
                        }else{
                            int total = jumlah1 * hargaBarang;
                            txthargabeli.setText(String.valueOf(total));

                            Date date = new Date();
                            DateFormat formattanggal = new SimpleDateFormat("yyyy-MM-dd");
                            String sekarang = formattanggal.format(date);

                            int c = daftar.getRowCount();
                            int i = 0;
                            do{
                                if (c!= 0 && daftar.getValueAt(i, 1).toString().equals(txtidbarang.getText())){
                                    int jml1 = Integer.parseInt(daftar.getValueAt(i, 4).toString());
                                    int jml2 = jumlah1 + jml1;
                                    int hr1 = jml2 * hargaBarang;
                                    daftar.setValueAt(jml2, i, 4);
                                    daftar.setValueAt(hr1,i,5);
                                }else{
                                    peralihan++;
                                }
                                i++;

                            }while(i<c);

                            if(peralihan == c){
                                 model2.addRow (new Object[] {txtidtransaksi.getText(), idBarang, namaBarang, hargaBarang, jumlah1, total, sekarang});
                            }
                            peralihan= 0;
                            tambahtotalkeranjang();
                            txtjumlah.setText(null);
                            }
                         } else {
                            peralihanbarang++;
                         }

                 pl++;
            } while(pl < jmltabl);
        }
        if (peralihanbarang == jmltabl){
         JOptionPane.showMessageDialog(null, "Tambahkan Barang Untuk Memulai Transaksi","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
         peralihanbarang = 0;
        }
    }//GEN-LAST:event_txtidbarangActionPerformed

    private void btnAktifkanOFFXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAktifkanOFFXMouseClicked
        JOptionPane.showMessageDialog(this, "Tidak dapat mengaktifkan Cetak Faktur otomatis!\nTekan tombol 'Segarkan' untuk mengaktifkan.","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
    }//GEN-LAST:event_btnAktifkanOFFXMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAktifkanOFF;
    private javax.swing.JLabel btnAktifkanOFFX;
    private javax.swing.JLabel btnAktifkanON;
    private javax.swing.JLabel btnCaribr;
    private javax.swing.JLabel btnCetak;
    private javax.swing.JLabel btnHapuspb;
    private javax.swing.JLabel btnHitung;
    private javax.swing.JLabel btnHitungdancetak;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSegarkan;
    private javax.swing.JLabel btnTambahkan;
    private javax.swing.JLabel btnTambahpb;
    private javax.swing.JTable daftar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel pbON;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel txtAktifkan;
    private javax.swing.JLabel txtMenu;
    private javax.swing.JTextField txtcaribarang;
    private javax.swing.JTextField txthargabeli;
    private javax.swing.JTextField txthargatotal;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtidpembeli;
    private javax.swing.JTextField txtidtransaksi;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnamapembeli;
    private javax.swing.JTextField txtpembayaran;
    private javax.swing.JTextField txtpembayaranauto;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
} 
