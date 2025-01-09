/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projekt1;

import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author elsa
 */
public class MenyHandlaggare extends javax.swing.JFrame {
    private InfDB idb; 
    private String dbAid;

    /**
     * Creates new form MenyHandlaggare
     */
    public MenyHandlaggare(InfDB idb, String dbAid) {
        this.idb = idb; 
        this.dbAid = dbAid; 
        initComponents();
        lblInloggad.setText (dbAid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInloggad = new javax.swing.JLabel();
        lblMeny = new javax.swing.JLabel();
        btnProjekt = new javax.swing.JButton();
        btnHallbarhetsmal = new javax.swing.JButton();
        btnMinProfil = new javax.swing.JButton();
        btnAnstallda = new javax.swing.JButton();
        lblValkommenHandläggare = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInloggad.setText("Inloggad");

        lblMeny.setText("Meny");

        btnProjekt.setText("Projekt");
        btnProjekt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjektMouseClicked(evt);
            }
        });
        btnProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjektActionPerformed(evt);
            }
        });

        btnHallbarhetsmal.setText("Hållbarhetsmål");
        btnHallbarhetsmal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHallbarhetsmalMouseClicked(evt);
            }
        });

        btnMinProfil.setText("Min Profil");
        btnMinProfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinProfilMouseClicked(evt);
            }
        });
        btnMinProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinProfilActionPerformed(evt);
            }
        });

        btnAnstallda.setText("Anställda");
        btnAnstallda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnstalldaMouseClicked(evt);
            }
        });

        lblValkommenHandläggare.setText("Välkommen Handläggare");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblInloggad))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHallbarhetsmal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProjekt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMinProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAnstallda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblValkommenHandläggare)
                        .addGap(31, 31, 31)
                        .addComponent(lblMeny)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInloggad)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblValkommenHandläggare)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMeny)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(btnMinProfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProjekt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHallbarhetsmal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnstallda)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjektActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProjektActionPerformed

    private void btnMinProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinProfilActionPerformed
        // TODO add your handling code here:
  
    
    }//GEN-LAST:event_btnMinProfilActionPerformed

    private void btnMinProfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinProfilMouseClicked
        // TODO add your handling code here:
        MenyProfilHandlaggare profilFönster = new MenyProfilHandlaggare(idb, dbAid);
       profilFönster.setVisible(true);
    }//GEN-LAST:event_btnMinProfilMouseClicked

    private void btnProjektMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjektMouseClicked
        // TODO add your handling code here:
        MenyProjektHandlaggare profilFönster = new MenyProjektHandlaggare(idb, dbAid);
       profilFönster.setVisible(true);
    }//GEN-LAST:event_btnProjektMouseClicked

    private void btnHallbarhetsmalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHallbarhetsmalMouseClicked
        // TODO add your handling code here:
        MenyHallbarhetsmalHandlaggare profilFönster = new MenyHallbarhetsmalHandlaggare(idb, dbAid);
       profilFönster.setVisible(true);
    }//GEN-LAST:event_btnHallbarhetsmalMouseClicked

    private void btnAnstalldaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnstalldaMouseClicked
        // TODO add your handling code here:
          MenyAnstalldaHandlaggare profilFönster = new MenyAnstalldaHandlaggare(idb, dbAid);
       profilFönster.setVisible(true);
    }//GEN-LAST:event_btnAnstalldaMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenyHandlaggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyHandlaggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyHandlaggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyHandlaggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyHandlaggare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnstallda;
    private javax.swing.JButton btnHallbarhetsmal;
    private javax.swing.JButton btnMinProfil;
    private javax.swing.JButton btnProjekt;
    private javax.swing.JLabel lblInloggad;
    private javax.swing.JLabel lblMeny;
    private javax.swing.JLabel lblValkommenHandläggare;
    // End of variables declaration//GEN-END:variables
}
