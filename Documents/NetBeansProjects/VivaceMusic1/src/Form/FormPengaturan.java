
/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

package Form;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FormPengaturan extends javax.swing.JPanel {
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Awal Deklarasi Method Fungsi
    */ 
    
    String location=null;
    String tgl, filename;
    DefaultTableModel model = new DefaultTableModel();
    
    private void load_tabel() {
        model.addColumn("No");
        model.addColumn("ID Keanggotaan");
        model.addColumn("Nama Keanggotaan");
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
        tabel.setModel(model);
        } catch (SQLException e){
        }
    }
    
    private void lebar_tabel(){
        TableColumn kolom;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN); 
        kolom = tabel.getColumnModel().getColumn(0); 
        kolom.setPreferredWidth(40);
        kolom = tabel.getColumnModel().getColumn(1); 
        kolom.setPreferredWidth(80); 
        kolom = tabel.getColumnModel().getColumn(2); 
        kolom.setPreferredWidth(200); 
        kolom = tabel.getColumnModel().getColumn(3); 
        kolom.setPreferredWidth(140);
        kolom = tabel.getColumnModel().getColumn(4); 
        kolom.setPreferredWidth(120);
    }
    
    public void kosongkan(){
        txtnamakeanggotaan.setText(null);
        txtpassword.setText(null);
        txtnotelp.setText(null);
        txtidktp.setText(null);
    }
    
    private void fileChooser(){
        JFileChooser path = new JFileChooser();
        path.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try{
                File f = path.getSelectedFile();
                location = f.getAbsolutePath();
                txtlokasi.setText(location + "_" + date +".xls");
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Perintah tidak valid/dibatalkan.","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
    }
    
    private void fileChooserD(){
        JFileChooser path = new JFileChooser();
        path.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try{
                File f = path.getSelectedFile();
                location = f.getAbsolutePath();
                txtlokasiD.setText(location + "_" + date +".xls");
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Perintah tidak valid/dibatalkan.","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
    }
    
    private void cadangkan(){
        try {
            String javaPath = txtlokasiD.getText() + ".sql"; 
            Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u root  toko_alatmusik1 -r " + javaPath);
            JOptionPane.showMessageDialog(this, "Backup Data Berhasil!" ,"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
         } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void tampilkaninfo_admin(){
        try {
            String sqls = "SELECT info_admin FROM informasi";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            while (ress.next()){
                txtinformasiadmin.setText(ress.getString(1));
            }
            } catch (SQLException ex) {
        }
    }
    
    private void tampilkaninfo_pemilik(){
        try {
            String sqls = "SELECT info_pemilik FROM informasi";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            while (ress.next()){
                txtinformasipemilik.setText(ress.getString(1));
            }
            } catch (SQLException ex) {
        }
    }
    
    private void tampilkaninfo_pemilik_edit(){
        try {
            String sqls = "SELECT info_pemilik FROM informasi";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            while (ress.next()){
                txtInfoP.setText(ress.getString(1));
            }
            } catch (SQLException ex) {
        }
    }
    
    private void hidebtn(){
        btnTWTON.setText(null);
        btnTWTON.setVisible(false);
        btnTSOFF.setText(null);
        btnTSOFF.setVisible(false);
        btnSOGON.setText(null);
        btnSOGON.setVisible(false);
        btnSOUON.setText(null);
        btnSOUON.setVisible(false);
    }
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Akhir Deklarasi Method Fungsi
    */ 
    
    public FormPengaturan() {
        initComponents();
        hidebtn();
        load_tabel();
        lebar_tabel();
        tampilkaninfo_admin();
        tampilkaninfo_pemilik();
        panelD.setVisible(false);
        panelIP.setVisible(false);
        panelIPE.setVisible(false);
        txtidkeanggotaan.disable();
        eyeshow.setVisible(false);
        txtLogout.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pengaturancb = new javax.swing.JComboBox<>();
        panelIPE = new javax.swing.JPanel();
        btnSimpanP = new javax.swing.JLabel();
        btnBatalP = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtInfoP = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        panelD = new javax.swing.JPanel();
        txtlokasiD = new javax.swing.JTextField();
        btnEmail = new javax.swing.JLabel();
        btnWA = new javax.swing.JLabel();
        btnEksporD = new javax.swing.JLabel();
        btnUbahD = new javax.swing.JLabel();
        btnTWTOFF = new javax.swing.JLabel();
        btnTWTON = new javax.swing.JLabel();
        btnTSOFF = new javax.swing.JLabel();
        btnTSON = new javax.swing.JLabel();
        btnSOGOFF = new javax.swing.JLabel();
        btnSOGON = new javax.swing.JLabel();
        btnSOUOFF = new javax.swing.JLabel();
        btnSOUON = new javax.swing.JLabel();
        teksTWT = new javax.swing.JLabel();
        teksTS = new javax.swing.JLabel();
        teksSOG = new javax.swing.JLabel();
        teksSOU = new javax.swing.JLabel();
        btnINFPEdit = new javax.swing.JLabel();
        teksINFP = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        txtLogout = new javax.swing.JLabel();
        bgP1 = new javax.swing.JLabel();
        panelIP = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtinformasipemilik = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtinformasiadmin = new javax.swing.JTextArea();
        bgP2 = new javax.swing.JLabel();
        panelP = new javax.swing.JPanel();
        txtidktp = new javax.swing.JTextField();
        txtidkeanggotaan = new javax.swing.JTextField();
        txtnamakeanggotaan = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        eyehide = new javax.swing.JLabel();
        eyeshow = new javax.swing.JLabel();
        txtnotelp = new javax.swing.JTextField();
        hakaksescb = new javax.swing.JComboBox<>();
        tglst = new com.toedter.calendar.JDateChooser();
        txtcarianggota = new javax.swing.JTextField();
        txtlokasi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnUbah = new javax.swing.JLabel();
        btnEkspor = new javax.swing.JLabel();
        btnCari = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        bgP = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pengaturancb.setFont(new java.awt.Font("Nirmala UI", 1, 32)); // NOI18N
        Pengaturancb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Keanggotaan", "Pengaturan", "Informasi" }));
        Pengaturancb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PengaturancbActionPerformed(evt);
            }
        });
        add(Pengaturancb, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 50, 400, 45));

        panelIPE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSimpanP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSimpanP.setForeground(new java.awt.Color(95, 95, 95));
        btnSimpanP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSimpanP.setText("SIMPAN");
        btnSimpanP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSimpanPMouseMoved(evt);
            }
        });
        btnSimpanP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSimpanPMouseExited(evt);
            }
        });
        panelIPE.add(btnSimpanP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1027, 786, 200, 40));

        btnBatalP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBatalP.setForeground(new java.awt.Color(95, 95, 95));
        btnBatalP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBatalP.setText("BATAL");
        btnBatalP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBatalPMouseMoved(evt);
            }
        });
        btnBatalP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBatalPMouseExited(evt);
            }
        });
        panelIPE.add(btnBatalP, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 786, 200, 40));

        jScrollPane4.setBorder(null);
        jScrollPane4.setOpaque(false);

        txtInfoP.setColumns(20);
        txtInfoP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtInfoP.setRows(5);
        jScrollPane4.setViewportView(txtInfoP);

        panelIPE.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 820, 460));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Informasi Pemilik Edit.png"))); // NOI18N
        panelIPE.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        add(panelIPE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        panelD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtlokasiD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtlokasiD.setBorder(null);
        txtlokasiD.setOpaque(false);
        panelD.add(txtlokasiD, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, 670, 50));

        btnEmail.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        btnEmail.setForeground(new java.awt.Color(95, 95, 95));
        btnEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmail.setText("              E-MAIL");
        btnEmail.setPreferredSize(new java.awt.Dimension(104, 36));
        btnEmail.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEmailMouseMoved(evt);
            }
        });
        btnEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmailMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmailMouseExited(evt);
            }
        });
        panelD.add(btnEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 660, 320, 60));

        btnWA.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        btnWA.setForeground(new java.awt.Color(95, 95, 95));
        btnWA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnWA.setText("              WHATSAPP");
        btnWA.setPreferredSize(new java.awt.Dimension(104, 36));
        btnWA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnWAMouseMoved(evt);
            }
        });
        btnWA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWAMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnWAMouseExited(evt);
            }
        });
        panelD.add(btnWA, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 580, 320, 60));

        btnEksporD.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnEksporD.setForeground(new java.awt.Color(95, 95, 95));
        btnEksporD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEksporD.setText("CADANGKAN");
        btnEksporD.setPreferredSize(new java.awt.Dimension(104, 36));
        btnEksporD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEksporDMouseMoved(evt);
            }
        });
        btnEksporD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEksporDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEksporDMouseExited(evt);
            }
        });
        panelD.add(btnEksporD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1279, 307, 200, 40));

        btnUbahD.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        btnUbahD.setForeground(new java.awt.Color(95, 95, 95));
        btnUbahD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbahD.setText("UBAH JALUR");
        btnUbahD.setPreferredSize(new java.awt.Dimension(104, 36));
        btnUbahD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUbahDMouseMoved(evt);
            }
        });
        btnUbahD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahDMouseExited(evt);
            }
        });
        panelD.add(btnUbahD, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 307, 200, 40));

        btnTWTOFF.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnTWTOFF.setForeground(new java.awt.Color(95, 95, 95));
        btnTWTOFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTWTOFF.setText("OFF");
        btnTWTOFF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTWTOFFMouseMoved(evt);
            }
        });
        btnTWTOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTWTOFFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTWTOFFMouseExited(evt);
            }
        });
        panelD.add(btnTWTOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 160, 40));

        btnTWTON.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnTWTON.setForeground(new java.awt.Color(95, 95, 95));
        btnTWTON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTWTON.setText("ON");
        btnTWTON.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTWTONMouseMoved(evt);
            }
        });
        btnTWTON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTWTONMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTWTONMouseExited(evt);
            }
        });
        panelD.add(btnTWTON, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 160, 40));

        btnTSOFF.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnTSOFF.setForeground(new java.awt.Color(95, 95, 95));
        btnTSOFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTSOFF.setText("OFF");
        btnTSOFF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTSOFFMouseMoved(evt);
            }
        });
        btnTSOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTSOFFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTSOFFMouseExited(evt);
            }
        });
        panelD.add(btnTSOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 160, 40));

        btnTSON.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnTSON.setForeground(new java.awt.Color(95, 95, 95));
        btnTSON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTSON.setText("ON");
        btnTSON.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTSONMouseMoved(evt);
            }
        });
        btnTSON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTSONMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTSONMouseExited(evt);
            }
        });
        panelD.add(btnTSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 160, 40));

        btnSOGOFF.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnSOGOFF.setForeground(new java.awt.Color(95, 95, 95));
        btnSOGOFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSOGOFF.setText("OFF");
        btnSOGOFF.setToolTipText("Sembunyikan Teks dan Pilihan Grafik pada Menu Dashboard dan Laporan Total");
        btnSOGOFF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSOGOFFMouseMoved(evt);
            }
        });
        btnSOGOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSOGOFFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSOGOFFMouseExited(evt);
            }
        });
        panelD.add(btnSOGOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 160, 40));

        btnSOGON.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnSOGON.setForeground(new java.awt.Color(95, 95, 95));
        btnSOGON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSOGON.setText("ON");
        btnSOGON.setToolTipText("Tampilkan Teks dan Pilihan Grafik pada Menu Dashboard dan Laporan Total");
        btnSOGON.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSOGONMouseMoved(evt);
            }
        });
        btnSOGON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSOGONMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSOGONMouseExited(evt);
            }
        });
        panelD.add(btnSOGON, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 160, 40));

        btnSOUOFF.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnSOUOFF.setForeground(new java.awt.Color(95, 95, 95));
        btnSOUOFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSOUOFF.setText("OFF");
        btnSOUOFF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSOUOFFMouseMoved(evt);
            }
        });
        btnSOUOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSOUOFFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSOUOFFMouseExited(evt);
            }
        });
        panelD.add(btnSOUOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 160, 40));

        btnSOUON.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnSOUON.setForeground(new java.awt.Color(95, 95, 95));
        btnSOUON.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSOUON.setText("ON");
        btnSOUON.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSOUONMouseMoved(evt);
            }
        });
        btnSOUON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSOUONMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSOUONMouseExited(evt);
            }
        });
        panelD.add(btnSOUON, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 160, 40));

        teksTWT.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        teksTWT.setText("Tampilkan Waktu dan Tanggal :");
        teksTWT.setToolTipText("");
        panelD.add(teksTWT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 410, 40));

        teksTS.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        teksTS.setText("Tampilkan Username :");
        panelD.add(teksTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 410, 40));

        teksSOG.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        teksSOG.setText("Sembunyikan Opsi Grafik :");
        teksSOG.setToolTipText("");
        panelD.add(teksSOG, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 410, 40));

        teksSOU.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        teksSOU.setText("Sembunyikan Opsi Urutkan :");
        panelD.add(teksSOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 410, 40));

        btnINFPEdit.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        btnINFPEdit.setForeground(new java.awt.Color(95, 95, 95));
        btnINFPEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnINFPEdit.setText("EDIT INFO");
        btnINFPEdit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnINFPEditMouseMoved(evt);
            }
        });
        btnINFPEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnINFPEditMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnINFPEditMouseExited(evt);
            }
        });
        panelD.add(btnINFPEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 160, 40));

        teksINFP.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        teksINFP.setText("Ubah Informasi Pemilik :");
        panelD.add(teksINFP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 410, 40));

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(95, 95, 95));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logouticon.png"))); // NOI18N
        btnLogout.setText("     KELUAR");
        btnLogout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLogoutMouseMoved(evt);
            }
        });
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        panelD.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 864, 140, 50));
        panelD.add(txtLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 950, -1, -1));

        bgP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Pengaturan Pemilik.png"))); // NOI18N
        panelD.add(bgP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        add(panelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        panelIP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(null);

        txtinformasipemilik.setColumns(20);
        txtinformasipemilik.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtinformasipemilik.setRows(5);
        jScrollPane3.setViewportView(txtinformasipemilik);

        panelIP.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 700, 720));

        jScrollPane2.setBorder(null);

        txtinformasiadmin.setColumns(20);
        txtinformasiadmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtinformasiadmin.setRows(5);
        jScrollPane2.setViewportView(txtinformasiadmin);

        panelIP.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 700, 720));

        bgP2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Informasi Pemilik.png"))); // NOI18N
        panelIP.add(bgP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        add(panelIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        panelP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtidktp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtidktp.setBorder(null);
        txtidktp.setOpaque(false);
        panelP.add(txtidktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 590, 40));

        txtidkeanggotaan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtidkeanggotaan.setBorder(null);
        txtidkeanggotaan.setOpaque(false);
        panelP.add(txtidkeanggotaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 590, 40));

        txtnamakeanggotaan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnamakeanggotaan.setBorder(null);
        txtnamakeanggotaan.setOpaque(false);
        panelP.add(txtnamakeanggotaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 590, 40));

        txtpassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtpassword.setBorder(null);
        txtpassword.setOpaque(false);
        panelP.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 540, 40));

        eyehide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eyehide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-hide-30.png"))); // NOI18N
        eyehide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyehideMouseClicked(evt);
            }
        });
        panelP.add(eyehide, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 550, 40, 40));

        eyeshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eyeshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-eye-30.png"))); // NOI18N
        eyeshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyeshowMouseClicked(evt);
            }
        });
        panelP.add(eyeshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 550, 40, 40));

        txtnotelp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnotelp.setBorder(null);
        txtnotelp.setOpaque(false);
        panelP.add(txtnotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 590, 40));

        hakaksescb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hakaksescb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "Pemilik", "Administrator", "Karyawan" }));
        hakaksescb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hakaksescbActionPerformed(evt);
            }
        });
        panelP.add(hakaksescb, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 750, 270, 40));

        tglst.setDateFormatString("dd-MM-yyyy");
        tglst.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelP.add(tglst, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 750, 290, 40));

        txtcarianggota.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcarianggota.setBorder(null);
        txtcarianggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarianggotaActionPerformed(evt);
            }
        });
        panelP.add(txtcarianggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 890, 600, 40));

        txtlokasi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtlokasi.setBorder(null);
        txtlokasi.setOpaque(false);
        panelP.add(txtlokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 530, 40));

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

        panelP.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 800, 680));

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
        panelP.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 30, 120, 40));

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
        panelP.add(btnEkspor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 30, 120, 40));

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
        panelP.add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 890, 148, 40));

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
        panelP.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 860, 175, 50));

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
        panelP.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 860, 170, 50));

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
        panelP.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 860, 166, 50));

        bgP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Keanggotaan.png"))); // NOI18N
        panelP.add(bgP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));

        add(panelP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int baris = tabel.rowAtPoint(evt.getPoint());
        String idText = tabel.getValueAt(baris, 1).toString();
        txtidkeanggotaan.setText(idText);
        txtidkeanggotaan.disable();

        if (tabel.getValueAt(baris, 2)==null){
            txtnamakeanggotaan.setText("");
        } else {
            txtnamakeanggotaan.setText(tabel.getValueAt(baris, 2).toString());
        }
        if (tabel.getValueAt(baris, 4)==null){
            txtnotelp.setText("");
        } else {
            txtnotelp.setText(tabel.getValueAt(baris, 4).toString());
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void txtcarianggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcarianggotaActionPerformed
    try {
            String sqls = "SELECT * FROM user WHERE idkaryawan LIKE '%"+txtcarianggota.getText()+
                    "%' OR nama_karyawan LIKE '%"+txtcarianggota.getText()+"%' OR user_parameter LIKE '%"+txtcarianggota.getText()+
                    "%' OR no_telp LIKE '"+txtcarianggota.getText()+"%' ORDER BY idkaryawan";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabel.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
        }
        tabel.setModel(model);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_txtcarianggotaActionPerformed

    private void btnTambahMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseMoved
        btnTambah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTambahMouseMoved

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        if (txtidktp.getText().equals("") && txtnamakeanggotaan.getText().equals("") && txtpassword.getText().equals("") && txtnotelp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Anda belum menulis data yang diperlukan!","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
        String tanggal = ((JTextField)tglst.getDateEditor().getUiComponent()).getText();
        try {
            String sql3 = "INSERT INTO user VALUES ('"+txtidkeanggotaan.getText()+"','"+txtnamakeanggotaan.getText()+
            "','"+txtpassword.getText()+"','"+hakaksescb.getSelectedItem()+"',"+tanggal+","+txtnotelp.getText()+","+txtidktp.getText()+")";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
            model.setRowCount(0);
            model.setColumnCount(0);
            load_tabel();
            lebar_tabel();
            kosongkan();
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
        }
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseExited
        btnTambah.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTambahMouseExited

    private void btnEditMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseMoved
        btnEdit.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEditMouseMoved

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        String tanggal = ((JTextField)tglst.getDateEditor().getUiComponent()).getText();
        try {
            String sql = "UPDATE user SET nama_karyawan = '"+txtnamakeanggotaan.getText()+"', telepon = "
                         +txtnotelp.getText()+", user_parameter = '"+hakaksescb.getSelectedItem()+"' WHERE idkaryawan = '" + txtidkeanggotaan.getText()+"'";
            String sql2 = "SELECT idkaryawan, telepon, tgl_lahir, idktp FROM user";
            String sql3 = "UPDATE user SET password = '"+txtpassword.getText()+"' WHERE idkaryawan = '" + txtidkeanggotaan.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
            java.sql.PreparedStatement pst3 = conn.prepareStatement(sql3);
            
            if (txtnamakeanggotaan.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Perubahan Data Gagal! Harap Tulis Nama Anggota","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
            } else if (txtnotelp.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Perubahan Data Gagal! Harap Isi Nomor Telepon Anggota","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
            } else if (hakaksescb.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Perubahan Data Gagal! Harap Pilih Hak Akses Anggota","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
            } else {
                pst.execute();
                JOptionPane.showMessageDialog(null,"Data :\nNama Anggota\nNo. Telepon dan,\nHak Akses\nBerhasil Diubah!","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
                java.sql.ResultSet rs = pst.executeQuery(sql2);
                while (rs.next()){
                if (txtidkeanggotaan.getText().equals(rs.getString("idkaryawan"))&& txtnotelp.getText().equals(rs.getString("telepon"))&& txtidktp.getText().equals(rs.getString("idktp"))){
//                && tglst.getDate().equals(rs.getString("tgl_lahir"))
                    pst3.execute();
                    JOptionPane.showMessageDialog(null,"Password Berhasil Diubah!","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
                }
                DefaultTableModel model = (DefaultTableModel)tabel.getModel();
                model.setRowCount(0);
                model.setColumnCount(0);
                load_tabel();
                lebar_tabel();
                kosongkan();
            }
            }
        } catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal!\n"+e.getMessage());
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        btnEdit.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEditMouseExited

    private void btnHapusMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseMoved
        btnHapus.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnHapusMouseMoved

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        if (txtidktp.getText().equals("") && txtnamakeanggotaan.getText().equals("") && txtnotelp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Anda belum memilih data pada tabel!","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
        try {
            String sql = "DELETE FROM user WHERE idkaryawan ='"+txtidkeanggotaan.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
            DefaultTableModel model = (DefaultTableModel)tabel.getModel();
            model.setRowCount(0);
            model.setColumnCount(0);
            load_tabel();
            lebar_tabel();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
        }
        kosongkan();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseExited
        btnHapus.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnHapusMouseExited

    private void btnCariMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseMoved
        btnCari.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnCariMouseMoved

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        try {
            String sqls = "SELECT * FROM user WHERE idkaryawan LIKE '%"+txtcarianggota.getText()+
                    "%' OR nama_karyawan LIKE '%"+txtcarianggota.getText()+"%' OR user_parameter LIKE '%"+txtcarianggota.getText()+
                    "%' OR no_telp LIKE '"+txtcarianggota.getText()+"%' ORDER BY idkaryawan";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            java.sql.ResultSet ress = pst.executeQuery(sqls);
            DefaultTableModel model = (DefaultTableModel)tabel.getModel();
            model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
        }
        tabel.setModel(model);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnCariMouseClicked

    private void btnCariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseExited
        btnCari.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnCariMouseExited

    private void btnEksporMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporMouseMoved
        btnEkspor.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEksporMouseMoved

    private void btnEksporMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporMouseClicked
        if (txtlokasi.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Gagal di Export ke Excel!\nHarap Pilih lokasi penyimpanan file Excel ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
        tabel.setModel(model);
        try{
            WritableWorkbook write = Workbook.createWorkbook(new File(txtlokasi.getText()));
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
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan dalam Bentuk Excel","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/approvedicon.png"));
        }catch(HeadlessException | IOException | WriteException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
        }
    }//GEN-LAST:event_btnEksporMouseClicked

    private void btnEksporMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporMouseExited
        btnEkspor.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEksporMouseExited

    private void btnUbahMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseMoved
        btnUbah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnUbahMouseMoved

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        fileChooser(); 
    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnUbahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseExited
        btnUbah.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnUbahMouseExited

    private void PengaturancbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PengaturancbActionPerformed
        if (Pengaturancb.getSelectedIndex()==0){
            model.setRowCount(0);
            model.setColumnCount(0);
            panelP.setVisible(true);
            panelD.setVisible(false);
            panelIP.setVisible(false);
            panelIPE.setVisible(false);
            load_tabel();
            lebar_tabel();
        }
        if (Pengaturancb.getSelectedIndex()==1){
            panelP.setVisible(false);
            panelD.setVisible(true);
            panelIP.setVisible(false);
            panelIPE.setVisible(false);
        }
        if (Pengaturancb.getSelectedIndex()==2){
            panelP.setVisible(false);
            panelD.setVisible(false);
            panelIP.setVisible(true);
            panelIPE.setVisible(false);
        }
    }//GEN-LAST:event_PengaturancbActionPerformed

    private void hakaksescbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hakaksescbActionPerformed
        if (hakaksescb.getSelectedIndex()==0){
            txtidkeanggotaan.setText(null);
        }
        if (hakaksescb.getSelectedIndex()==1){
            txtidkeanggotaan.disable();
            try{
                String sql = "SELECT MAX(RIGHT(idkaryawan,4)) FROM user";
                java.sql.Connection con = (Connection) Config.configDB();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rst = st.executeQuery(sql);
            if(rst.next()) {
                String auto_kdPM, tambah;
                int kdb;
                auto_kdPM = Integer.toString(rst.getInt(1)+1);
                kdb = auto_kdPM.length();
                tambah = "";
                for (int i = 1; i <= 4 - kdb; i++ ){
                    tambah = tambah + "0";
                }
                txtidkeanggotaan.setText("PM"+tambah+auto_kdPM);
                }
            }
            catch (Exception e) {
                txtidkeanggotaan.setText("PM0001");
            }
            }
        if (hakaksescb.getSelectedIndex()==2){
            txtidkeanggotaan.disable();
            try{
                String sql = "SELECT MAX(RIGHT(idkaryawan,4)) FROM user";
                java.sql.Connection con = (Connection) Config.configDB();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rst = st.executeQuery(sql);
            if(rst.next()) {
                String auto_kdPM, tambah;
                int kdb;
                auto_kdPM = Integer.toString(rst.getInt(1)+1);
                kdb = auto_kdPM.length();
                tambah = "";
                for (int i = 1; i <= 4 - kdb; i++ ){
                    tambah = tambah + "0";
                }
                txtidkeanggotaan.setText("AD"+tambah+auto_kdPM);
                }
            }
            catch (Exception e) {
                txtidkeanggotaan.setText("AD0001");
            }
        }
        if (hakaksescb.getSelectedIndex()==3){
            txtidkeanggotaan.disable();
            try{
                String sql = "SELECT MAX(RIGHT(idkaryawan,4)) FROM user";
                java.sql.Connection con = (Connection) Config.configDB();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rst = st.executeQuery(sql);
            if(rst.next()) {
                String auto_kdPM, tambah;
                int kdb;
                auto_kdPM = Integer.toString(rst.getInt(1)+1);
                kdb = auto_kdPM.length();
                tambah = "";
                for (int i = 1; i <= 4 - kdb; i++ ){
                    tambah = tambah + "0";
                }
                txtidkeanggotaan.setText("KR"+tambah+auto_kdPM);
                }
            }
            catch (Exception e) {
                txtidkeanggotaan.setText("KR0001");
            }
        }
    }//GEN-LAST:event_hakaksescbActionPerformed

    private void eyeshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeshowMouseClicked
        txtpassword.setEchoChar('•');
        eyeshow.setVisible(false);
        eyehide.setVisible(true);
    }//GEN-LAST:event_eyeshowMouseClicked

    private void eyehideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyehideMouseClicked
        txtpassword.setEchoChar((char)0);
        txtpassword.setFont(new java.awt.Font("Segoe UI Bold", 2, 18));
        eyeshow.setVisible(true);
        eyehide.setVisible(false);
    }//GEN-LAST:event_eyehideMouseClicked

    private void btnUbahDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahDMouseMoved
        btnUbahD.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnUbahDMouseMoved

    private void btnUbahDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahDMouseClicked
        fileChooserD();
    }//GEN-LAST:event_btnUbahDMouseClicked

    private void btnUbahDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahDMouseExited
        btnUbahD.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnUbahDMouseExited

    private void btnEksporDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporDMouseMoved
        btnEksporD.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEksporDMouseMoved

    private void btnEksporDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporDMouseClicked
        if (txtlokasiD.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Database Gagal Dicadangkan!\nHarap Pilih lokasi penyimpanan Database","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        } else {
            
        }
    }//GEN-LAST:event_btnEksporDMouseClicked

    private void btnEksporDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEksporDMouseExited
        btnEksporD.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEksporDMouseExited

    private void btnWAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWAMouseMoved
        btnWA.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnWAMouseMoved

    private void btnWAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWAMouseClicked
        String urlwa = "https://wa.link/jfbm8r";
        
        if (Desktop.isDesktopSupported()){
        Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(urlwa));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
        Runtime runtime = Runtime.getRuntime();
        try {
                runtime.exec("xdg-open" + urlwa);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnWAMouseClicked

    private void btnWAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWAMouseExited
        btnWA.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnWAMouseExited

    private void btnEmailMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmailMouseMoved
        btnEmail.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnEmailMouseMoved

    private void btnEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmailMouseClicked
        String urlemail = "mailto:aanblogme@gmail.com";
        
        if (Desktop.isDesktopSupported()){
        Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(urlemail));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
        Runtime runtime = Runtime.getRuntime();
        try {
                runtime.exec("xdg-open" + urlemail);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEmailMouseClicked

    private void btnEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmailMouseExited
        btnEmail.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnEmailMouseExited

    private void btnTWTOFFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTOFFMouseMoved
        btnTWTOFF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTWTOFFMouseMoved

    private void btnTWTOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTOFFMouseClicked
        btnTWTOFF.setText(null);
        btnTWTOFF.setVisible(false);
        btnTWTON.setText("ON");
        btnTWTON.setVisible(true);
    }//GEN-LAST:event_btnTWTOFFMouseClicked

    private void btnTWTOFFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTOFFMouseExited
        btnTWTOFF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTWTOFFMouseExited

    private void btnTWTONMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTONMouseMoved
        btnTWTON.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTWTONMouseMoved

    private void btnTWTONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTONMouseClicked
        btnTWTOFF.setText("OFF");
        btnTWTOFF.setVisible(true);
        btnTWTON.setText(null);
        btnTWTON.setVisible(false);
    }//GEN-LAST:event_btnTWTONMouseClicked

    private void btnTWTONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTWTONMouseExited
        btnTWTON.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTWTONMouseExited

    private void btnTSOFFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSOFFMouseMoved
        btnTSOFF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTSOFFMouseMoved

    private void btnTSOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSOFFMouseClicked
        btnTSOFF.setText(null);
        btnTSOFF.setVisible(false);
        btnTSON.setText("ON");
        btnTSON.setVisible(true);
    }//GEN-LAST:event_btnTSOFFMouseClicked

    private void btnTSOFFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSOFFMouseExited
        btnTSOFF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTSOFFMouseExited

    private void btnTSONMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSONMouseMoved
        btnTSON.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnTSONMouseMoved

    private void btnTSONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSONMouseClicked
        btnTSOFF.setText("OFF");
        btnTSOFF.setVisible(true);
        btnTSON.setText(null);
        btnTSON.setVisible(false);
    }//GEN-LAST:event_btnTSONMouseClicked

    private void btnTSONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTSONMouseExited
        btnTSON.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnTSONMouseExited

    private void btnSOGOFFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOGOFFMouseMoved
        btnSOGOFF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSOGOFFMouseMoved

    private void btnSOGOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOGOFFMouseClicked
        btnSOGOFF.setText(null);
        btnSOGOFF.setVisible(false);
        btnSOGON.setText("ON");
        btnSOGON.setVisible(true);
    }//GEN-LAST:event_btnSOGOFFMouseClicked

    private void btnSOGOFFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOGOFFMouseExited
        btnSOGOFF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSOGOFFMouseExited

    private void btnSOGONMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOGONMouseMoved
        btnSOGON.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSOGONMouseMoved

    private void btnSOGONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOGONMouseClicked
        btnSOGOFF.setText("OFF");
        btnSOGOFF.setVisible(true);
        btnSOGON.setText(null);
        btnSOGON.setVisible(false);
    }//GEN-LAST:event_btnSOGONMouseClicked

    private void btnSOGONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOGONMouseExited
        btnSOGON.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSOGONMouseExited

    private void btnSOUOFFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUOFFMouseMoved
        btnSOUOFF.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSOUOFFMouseMoved

    private void btnSOUOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUOFFMouseClicked
        btnSOUOFF.setText(null);
        btnSOUOFF.setVisible(false);
        btnSOUON.setText("ON");
        btnSOUON.setVisible(true);
    }//GEN-LAST:event_btnSOUOFFMouseClicked

    private void btnSOUOFFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUOFFMouseExited
        btnSOUOFF.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSOUOFFMouseExited

    private void btnSOUONMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUONMouseMoved
        btnSOUON.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSOUONMouseMoved

    private void btnSOUONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUONMouseClicked
        btnSOUOFF.setText("OFF");
        btnSOUOFF.setVisible(true);
        btnSOUON.setText(null);
        btnSOUON.setVisible(false);
    }//GEN-LAST:event_btnSOUONMouseClicked

    private void btnSOUONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSOUONMouseExited
        btnSOUON.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSOUONMouseExited

    private void btnLogoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseMoved
        btnLogout.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnLogoutMouseMoved

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        hidebtn();
        btnTWTOFF.setText("OFF");
        btnTSON.setText("ON");
        btnSOGON.setText("OFF");
        btnSOUON.setText("OFF");
        txtLogout.setText("logout");
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        btnLogout.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnINFPEditMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnINFPEditMouseMoved
        btnINFPEdit.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnINFPEditMouseMoved

    private void btnINFPEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnINFPEditMouseClicked
        tampilkaninfo_pemilik_edit();
        panelP.setVisible(false);
        panelD.setVisible(false);
        panelIP.setVisible(false);
        panelIPE.setVisible(true);
        btnINFPEdit.setVisible(false);
        btnLogout.setVisible(false);
    }//GEN-LAST:event_btnINFPEditMouseClicked

    private void btnINFPEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnINFPEditMouseExited
        btnINFPEdit.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnINFPEditMouseExited

    private void btnSimpanPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanPMouseMoved
        btnSimpanP.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnSimpanPMouseMoved

    private void btnSimpanPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanPMouseClicked
        try {
            String sqls = "UPDATE informasi SET info_pemilik = '"+txtInfoP.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
            pst.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal!\n"+e.getMessage(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
        }
        txtinformasipemilik.setText(txtInfoP.getText());
        panelP.setVisible(false);
        panelD.setVisible(true);
        panelIP.setVisible(false);
        panelIPE.setVisible(false);
        btnINFPEdit.setVisible(true);
        btnLogout.setVisible(true);
    }//GEN-LAST:event_btnSimpanPMouseClicked

    private void btnSimpanPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanPMouseExited
        btnSimpanP.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnSimpanPMouseExited

    private void btnBatalPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalPMouseMoved
        btnBatalP.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnBatalPMouseMoved

    private void btnBatalPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalPMouseClicked
        panelP.setVisible(false);
        panelD.setVisible(true);
        panelIP.setVisible(false);
        panelIPE.setVisible(false);
        btnINFPEdit.setVisible(true);
        btnLogout.setVisible(true);
    }//GEN-LAST:event_btnBatalPMouseClicked

    private void btnBatalPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalPMouseExited
        btnBatalP.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnBatalPMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Pengaturancb;
    private javax.swing.JLabel bgP;
    private javax.swing.JLabel bgP1;
    private javax.swing.JLabel bgP2;
    private javax.swing.JLabel btnBatalP;
    private javax.swing.JLabel btnCari;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnEkspor;
    private javax.swing.JLabel btnEksporD;
    private javax.swing.JLabel btnEmail;
    private javax.swing.JLabel btnHapus;
    public javax.swing.JLabel btnINFPEdit;
    private javax.swing.JLabel btnLogout;
    public javax.swing.JLabel btnSOGOFF;
    public javax.swing.JLabel btnSOGON;
    public javax.swing.JLabel btnSOUOFF;
    public javax.swing.JLabel btnSOUON;
    private javax.swing.JLabel btnSimpanP;
    public javax.swing.JLabel btnTSOFF;
    public javax.swing.JLabel btnTSON;
    public javax.swing.JLabel btnTWTOFF;
    public javax.swing.JLabel btnTWTON;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btnUbah;
    private javax.swing.JLabel btnUbahD;
    private javax.swing.JLabel btnWA;
    private javax.swing.JLabel eyehide;
    private javax.swing.JLabel eyeshow;
    private javax.swing.JComboBox<String> hakaksescb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelD;
    private javax.swing.JPanel panelIP;
    private javax.swing.JPanel panelIPE;
    private javax.swing.JPanel panelP;
    private javax.swing.JTable tabel;
    public javax.swing.JLabel teksINFP;
    private javax.swing.JLabel teksSOG;
    private javax.swing.JLabel teksSOU;
    private javax.swing.JLabel teksTS;
    private javax.swing.JLabel teksTWT;
    private com.toedter.calendar.JDateChooser tglst;
    public javax.swing.JTextArea txtInfoP;
    protected javax.swing.JLabel txtLogout;
    private javax.swing.JTextField txtcarianggota;
    private javax.swing.JTextField txtidkeanggotaan;
    private javax.swing.JTextField txtidktp;
    public javax.swing.JTextArea txtinformasiadmin;
    public javax.swing.JTextArea txtinformasipemilik;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtlokasiD;
    private javax.swing.JTextField txtnamakeanggotaan;
    private javax.swing.JTextField txtnotelp;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
