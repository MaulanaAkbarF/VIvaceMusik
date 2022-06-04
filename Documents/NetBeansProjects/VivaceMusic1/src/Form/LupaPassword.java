package Form;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

public class LupaPassword extends javax.swing.JFrame {

    public LupaPassword() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEmail = new javax.swing.JLabel();
        btnWA = new javax.swing.JLabel();
        bgLupaPassowrd = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEmail.setForeground(new java.awt.Color(95, 95, 95));
        btnEmail.setText("           E-MAIL");
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
        getContentPane().add(btnEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 210, 50));

        btnWA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnWA.setForeground(new java.awt.Color(95, 95, 95));
        btnWA.setText("           WHATSAPP");
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
        getContentPane().add(btnWA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 210, 50));

        bgLupaPassowrd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Lupa Password.png"))); // NOI18N
        getContentPane().add(bgLupaPassowrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LupaPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLupaPassowrd;
    private javax.swing.JLabel btnEmail;
    private javax.swing.JLabel btnWA;
    // End of variables declaration//GEN-END:variables
}
