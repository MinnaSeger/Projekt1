package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author minna
 */
public class MenyAvdelningarAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    
        public MenyAvdelningarAdmin(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnAvd1 = new javax.swing.JButton();
        btnAvd2 = new javax.swing.JButton();
        btnAvd3 = new javax.swing.JButton();
        lblValjAvdelning = new javax.swing.JLabel();
        btnLaggTill = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAvd1.setText("Avdelning för hållbar energi och klimatförändringar");
        btnAvd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAvd1MouseClicked(evt);
            }
        });

        btnAvd2.setText("Avdelning för samhällsutveckling och utbildning");
        btnAvd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAvd2MouseClicked(evt);
            }
        });

        btnAvd3.setText("Avdelning för teknisk innovation och entreprenörskap");
        btnAvd3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAvd3MouseClicked(evt);
            }
        });

        lblValjAvdelning.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblValjAvdelning.setText("Välj avdelning att ändra:");

        btnLaggTill.setText("Lägg till avdelning");
        btnLaggTill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaggTillMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Eller...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAvd3)
                            .addComponent(btnAvd1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnAvd2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(lblValjAvdelning))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnLaggTill, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblValjAvdelning)
                        .addGap(28, 28, 28)
                        .addComponent(btnAvd1)))
                .addGap(18, 18, 18)
                .addComponent(btnAvd2)
                .addGap(18, 18, 18)
                .addComponent(btnAvd3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLaggTill)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvd1MouseClicked
        // Dirigerar användare till MenyAvdelningForHallbarEnergiAdmin 
       MenyAvdelningForHallbarEnergiAdmin profilFönster = new MenyAvdelningForHallbarEnergiAdmin(idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnAvd1MouseClicked

    private void btnAvd2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvd2MouseClicked
        // Dirigerar användare till MenyAvdelningForSamhallsutvecklingAdmin
       MenyAvdelningForSamhallsutvecklingAdmin profilFönster = new MenyAvdelningForSamhallsutvecklingAdmin(idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnAvd2MouseClicked

    private void btnAvd3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvd3MouseClicked
        // Dirigerar användare till MenyAvdelningForTekniskInnovation
       MenyAvdelningForTekniskInnovation profilFönster = new MenyAvdelningForTekniskInnovation(idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnAvd3MouseClicked

    private void btnLaggTillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaggTillMouseClicked
       MenyLaggTillAvdelningAdmin profilFönster = new MenyLaggTillAvdelningAdmin(idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnLaggTillMouseClicked

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
            java.util.logging.Logger.getLogger(MenyAvdelningarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAvdelningarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAvdelningarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAvdelningarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyAvdelningarAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvd1;
    private javax.swing.JButton btnAvd2;
    private javax.swing.JButton btnAvd3;
    private javax.swing.JButton btnLaggTill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblValjAvdelning;
    // End of variables declaration//GEN-END:variables
}
