package Form;

/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    MainForm tu = new MainForm();

    public Login() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        eyeshow.setVisible(false);
        pass.setEchoChar('•');
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JLabel();
        btnLP = new javax.swing.JLabel();
        eyeshow = new javax.swing.JLabel();
        eyehide = new javax.swing.JLabel();
        bgLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        user.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        user.setOpaque(false);
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 425, 740, 40));

        pass.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pass.setOpaque(false);
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 525, 700, 40));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(95, 95, 95));
        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLogin.setText("LOGIN");
        btnLogin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLoginMouseMoved(evt);
            }
        });
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1197, 652, 248, 80));

        btnLP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLP.setForeground(new java.awt.Color(95, 95, 95));
        btnLP.setText("Lupa Password?");
        btnLP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLPMouseMoved(evt);
            }
        });
        btnLP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLPMouseExited(evt);
            }
        });
        getContentPane().add(btnLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1564, 570, 130, 30));

        eyeshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eyeshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-eye-30.png"))); // NOI18N
        eyeshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyeshowMouseClicked(evt);
            }
        });
        getContentPane().add(eyeshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1655, 525, 40, 40));

        eyehide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eyehide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-hide-30.png"))); // NOI18N
        eyehide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyehideMouseClicked(evt);
            }
        });
        getContentPane().add(eyehide, new org.netbeans.lib.awtextra.AbsoluteConstraints(1655, 525, 40, 40));

        bgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Login.png"))); // NOI18N
        getContentPane().add(bgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1010));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eyeshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeshowMouseClicked
        pass.setEchoChar('•');
        eyeshow.setVisible(false);
        eyehide.setVisible(true);
    }//GEN-LAST:event_eyeshowMouseClicked

    private void eyehideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyehideMouseClicked
        pass.setEchoChar((char)0);
        pass.setFont(new java.awt.Font("Segoe UI Bold", 2, 18));
        eyeshow.setVisible(true);
        eyehide.setVisible(false);
    }//GEN-LAST:event_eyehideMouseClicked

    
    private void btnLoginMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseMoved
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnLoginMouseMoved

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        if (user.getText().equals("") && pass.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kamu belum mengisi apapun!","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png")); 
        } else {
        try {
        String sql1 = "SELECT * FROM user WHERE idkaryawan='"+user.getText()+"'AND password='"+pass.getText()+"'";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
        java.sql.ResultSet rs1 = pst1.executeQuery(sql1);
        if (rs1.next()){
                if (user.getText().equals(rs1.getString("idkaryawan"))&& pass.getText().equals(rs1.getString("password"))){
                tu.hakakses.setText(rs1.getString(4));
                    if (tu.hakakses.getText().equals("Pemilik")){
                        this.setVisible(false);
                        tu.setVisible(true);
                        tu.menu5 = false;
                        tu.menu6 = false;
                        tu.menu7 = false;
                        tu.menu8 = false;
                    } if (tu.hakakses.getText().equals("Administrator")){
                        this.setVisible(false);
                        tu.setVisible(true);
                        tu.menu4 = false;
                        tu.menu5 = false;
                        tu.menu6 = false;
                        tu.menu7 = true;
                        tu.menu8 = false;
                    } if (tu.hakakses.getText().equals("Karyawan")){
                        this.setVisible(false);
                        tu.setVisible(true);
                        tu.menu1 = false;
                        tu.menu2 = false;
                        tu.menu3 = false;
                        tu.menu4 = false;
                        tu.menu5 = true;
                        tu.menu6 = true;
                        tu.menu7 = true;
                        tu.menu8 = true;
                    }
                String nama = "  Hai, "+rs1.getString(2);

                tu.userinfo.setText(nama);
                tu.userinfo1.setText(nama);
        }
        
        } else {
            JOptionPane.showMessageDialog(null, "Username atau Password salah!\nHarap Cek Kembali ","Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png")); 
        }
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage(),"Pesan",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Image/rejectedicon.png"));
    }
    }
    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnLPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLPMouseMoved
        btnLP.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnLPMouseMoved

    private void btnLPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLPMouseClicked
        new LupaPassword().setVisible(true);
    }//GEN-LAST:event_btnLPMouseClicked

    private void btnLPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLPMouseExited
        btnLP.setForeground(new java.awt.Color(95,95,95));
    }//GEN-LAST:event_btnLPMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLogin;
    private javax.swing.JLabel btnLP;
    private javax.swing.JLabel btnLogin;
    private javax.swing.JLabel eyehide;
    private javax.swing.JLabel eyeshow;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
