/*
 * Author   : Kelompok A2
 * Matkul   : WSIBD, ManPro, IMK
 */

package Form;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FormProdukmasukKaryawan extends javax.swing.JPanel {

    public FormProdukmasukKaryawan() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnWA = new javax.swing.JLabel();
        btnEmail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnWA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnWA.setForeground(new java.awt.Color(95, 95, 95));
        btnWA.setText("               WHATSAPP");
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
        add(btnWA, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 580, 210, 70));

        btnEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEmail.setForeground(new java.awt.Color(95, 95, 95));
        btnEmail.setText("               E-MAIL");
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
        add(btnEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 580, 210, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Form Produk Masuk Karyawan.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 1010));
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

    // Variabel untuk tabelMouseClicked
    public String idbr, namabr, hargabelibr;
    
    // Variabel untuk daftarMouseClicked
    public int mctp;
    
    // Variabel untuk txtidbarang
    public int peralihanPm = -1;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEmail;
    private javax.swing.JLabel btnWA;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
