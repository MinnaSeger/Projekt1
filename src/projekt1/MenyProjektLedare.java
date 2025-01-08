package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


public class MenyProjektLedare extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    /**
     * Creates new form MenyProjektLedare
     */
    public MenyProjektLedare(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
      //  lblInloggad.setText (dbAid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblvalkommenprojektledare = new javax.swing.JLabel();
        lblmeny = new javax.swing.JLabel();
        btnMinprofil = new javax.swing.JButton();
        btnprojekt = new javax.swing.JButton();
        btnAnställda = new javax.swing.JButton();
        btnHållbarhetsmål = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblvalkommenprojektledare.setText("Välkommen Projektledare");

        lblmeny.setText("Meny");

        btnMinprofil.setText("Min profil");
        btnMinprofil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinprofilMouseClicked(evt);
            }
        });
        btnMinprofil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinprofilActionPerformed(evt);
            }
        });

        btnprojekt.setText("Projekt");
        btnprojekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprojektActionPerformed(evt);
            }
        });

        btnAnställda.setText("Anställda");
        btnAnställda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnställdaActionPerformed(evt);
            }
        });

        btnHållbarhetsmål.setText("Hållbarhetsmål");
        btnHållbarhetsmål.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHållbarhetsmålActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblvalkommenprojektledare))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(lblmeny))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAnställda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHållbarhetsmål, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnprojekt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMinprofil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblvalkommenprojektledare, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblmeny)
                .addGap(9, 9, 9)
                .addComponent(btnMinprofil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnprojekt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHållbarhetsmål)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnställda)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprojektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprojektActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnprojektActionPerformed

    private void btnMinprofilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinprofilActionPerformed
        // TODO add your handling code here: 
        

      
    }//GEN-LAST:event_btnMinprofilActionPerformed

    private void btnHållbarhetsmålActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHållbarhetsmålActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHållbarhetsmålActionPerformed

    private void btnAnställdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnställdaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnställdaActionPerformed

    private void btnMinprofilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinprofilMouseClicked
        // TODO add your handling code here:
        btnMinprofil.setVisible(true);
    }//GEN-LAST:event_btnMinprofilMouseClicked

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
            java.util.logging.Logger.getLogger(MenyProjektLedare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyProjektLedare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyProjektLedare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyProjektLedare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyProjektLedare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnställda;
    private javax.swing.JButton btnHållbarhetsmål;
    private javax.swing.JButton btnMinprofil;
    private javax.swing.JButton btnprojekt;
    private javax.swing.JLabel lblmeny;
    private javax.swing.JLabel lblvalkommenprojektledare;
    // End of variables declaration//GEN-END:variables

} 



