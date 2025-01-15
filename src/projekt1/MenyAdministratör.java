package projekt1;

import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author cecil
 */
public class MenyAdministratör extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    
    

    /**
     * Creates new form MenyAdministratör
     */
    public MenyAdministratör(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
       // lblInloggad.setText (dbAid);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVälkommenAdminstratör = new javax.swing.JLabel();
        lblMeny = new javax.swing.JLabel();
        btnHanteraAnställda = new javax.swing.JButton();
        BtnProjekt = new javax.swing.JButton();
        btnPartners = new javax.swing.JButton();
        btnAvdelningar = new javax.swing.JButton();
        btnLänder = new javax.swing.JButton();
        lblInloggad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblVälkommenAdminstratör.setText("Välkommen Adminstratör");

        lblMeny.setText("Meny");

        btnHanteraAnställda.setText("Hantera Anställda");
        btnHanteraAnställda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHanteraAnställdaMouseClicked(evt);
            }
        });

        BtnProjekt.setText("Projekt");
        BtnProjekt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnProjektMouseClicked(evt);
            }
        });

        btnPartners.setText("Partners");
        btnPartners.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPartnersMouseClicked(evt);
            }
        });

        btnAvdelningar.setText("Avdelningar");
        btnAvdelningar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAvdelningarMouseClicked(evt);
            }
        });

        btnLänder.setText("Länder");
        btnLänder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLänderMouseClicked(evt);
            }
        });

        lblInloggad.setText("Inloggad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHanteraAnställda)
                            .addComponent(btnPartners, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAvdelningar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLänder, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblInloggad)
                                .addGap(104, 104, 104)
                                .addComponent(lblMeny))
                            .addComponent(lblVälkommenAdminstratör))))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVälkommenAdminstratör)
                        .addGap(12, 12, 12)
                        .addComponent(lblMeny))
                    .addComponent(lblInloggad, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(btnHanteraAnställda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnProjekt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPartners)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvdelningar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLänder)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHanteraAnställdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHanteraAnställdaMouseClicked

       MenyHanteraAnstalldAdmin profilFönster = new MenyHanteraAnstalldAdmin(idb, dbAid);
       profilFönster.setVisible(true);
    }//GEN-LAST:event_btnHanteraAnställdaMouseClicked

    private void BtnProjektMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProjektMouseClicked

       MenyProjektAdmin profilFönster = new MenyProjektAdmin(idb, dbAid);
       profilFönster.setVisible(true);
    }//GEN-LAST:event_BtnProjektMouseClicked

    private void btnPartnersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPartnersMouseClicked

       MenyPartnerAdmin profilFönster = new MenyPartnerAdmin(idb, dbAid);
       profilFönster.setVisible(true);
    }//GEN-LAST:event_btnPartnersMouseClicked

    private void btnAvdelningarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvdelningarMouseClicked

       MenyAvdelningarAdmin profilFönster = new MenyAvdelningarAdmin(idb, dbAid);
       profilFönster.setVisible(true);
    }//GEN-LAST:event_btnAvdelningarMouseClicked

    private void btnLänderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLänderMouseClicked

       MenyLandAdmin profilFönster = new MenyLandAdmin(idb, dbAid);
       profilFönster.setVisible(true);
    }//GEN-LAST:event_btnLänderMouseClicked

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
            java.util.logging.Logger.getLogger(MenyAdministratör.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAdministratör.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAdministratör.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAdministratör.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyAdministratör().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnProjekt;
    private javax.swing.JButton btnAvdelningar;
    private javax.swing.JButton btnHanteraAnställda;
    private javax.swing.JButton btnLänder;
    private javax.swing.JButton btnPartners;
    private javax.swing.JLabel lblInloggad;
    private javax.swing.JLabel lblMeny;
    private javax.swing.JLabel lblVälkommenAdminstratör;
    // End of variables declaration//GEN-END:variables
}
