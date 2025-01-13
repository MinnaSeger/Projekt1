package projekt1;

import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



public class MenyHanteraAnstalldAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    
        public MenyHanteraAnstalldAdmin(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        }
/**
 *
 * @author minna
 *

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnLaggTillAdm = new javax.swing.JButton();
        lblLaggTill = new javax.swing.JLabel();
        btnLaggTillHand = new javax.swing.JButton();
        btnTaBortAns = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Hantera anställda");

        btnLaggTillAdm.setText("Lägg till administratör");
        btnLaggTillAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaggTillAdmMouseClicked(evt);
            }
        });
        btnLaggTillAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillAdmActionPerformed(evt);
            }
        });

        lblLaggTill.setText("Lägg till anställd:");

        btnLaggTillHand.setText("Lägg till handläggare");
        btnLaggTillHand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaggTillHandMouseClicked(evt);
            }
        });

        btnTaBortAns.setText("Ta bort anställd");
        btnTaBortAns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaBortAnsMouseClicked(evt);
            }
        });

        jLabel3.setText("Ta bort anställd:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblLaggTill)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLaggTillAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTaBortAns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLaggTillHand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel3)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(lblLaggTill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLaggTillAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLaggTillHand)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnTaBortAns)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaggTillAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillAdmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLaggTillAdmActionPerformed

    private void btnLaggTillAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaggTillAdmMouseClicked
        // TODO add your handling code here:
       MenyLaggTillAdminAdmin profilFönster = new MenyLaggTillAdminAdmin(idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnLaggTillAdmMouseClicked

    private void btnTaBortAnsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaBortAnsMouseClicked
        // TODO add your handling code here:
           MenyTaBortAnstalld profilFönster = new MenyTaBortAnstalld(idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnTaBortAnsMouseClicked

    private void btnLaggTillHandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaggTillHandMouseClicked
       MenyLaggTillHandlaggareAdmin profilFönster = new MenyLaggTillHandlaggareAdmin(idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnLaggTillHandMouseClicked

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
            java.util.logging.Logger.getLogger(MenyHanteraAnstalldAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyHanteraAnstalldAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyHanteraAnstalldAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyHanteraAnstalldAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyHanteraAnstalldaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTillAdm;
    private javax.swing.JButton btnLaggTillHand;
    private javax.swing.JButton btnTaBortAns;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblLaggTill;
    // End of variables declaration//GEN-END:variables
}
