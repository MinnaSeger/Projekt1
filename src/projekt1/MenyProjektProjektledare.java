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
public class MenyProjektProjektledare extends javax.swing.JFrame {
      private InfDB idb;
    private String dbAid;

    /**
     * Creates new form MenyProjektProjektledare
     */
    public MenyProjektProjektledare(InfDB idb, String dbAid) {
         this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProjekt = new javax.swing.JLabel();
        lblAnsvarigForProjekt = new javax.swing.JLabel();
        btnUppgifterOmProjekt = new javax.swing.JButton();
        lblMinaProjektProjektledare = new javax.swing.JLabel();
        lblMinaSamarbetspartners = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfdFiltreraProjekt = new javax.swing.JTextField();
        lblSokStartdatum = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        lblSokSlutdatum = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProjekt.setText("Projekt");

        lblAnsvarigForProjekt.setText("Ansvarig för projekt");

        btnUppgifterOmProjekt.setText("Uppgifter om projekt");
        btnUppgifterOmProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUppgifterOmProjektActionPerformed(evt);
            }
        });

        lblMinaProjektProjektledare.setText("Mina tilldelade projekt");

        lblMinaSamarbetspartners.setText("Mina Samarbetspartners");

        jLabel1.setText("Avdelningensprojekt");

        tfdFiltreraProjekt.setText("Filtrera Status");
        tfdFiltreraProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdFiltreraProjektActionPerformed(evt);
            }
        });

        lblSokStartdatum.setText("Sök Startdatum");

        jSpinner1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1736254860000L), new java.util.Date(1104534000000L), new java.util.Date(1893452400000L), java.util.Calendar.DAY_OF_MONTH));

        lblSokSlutdatum.setText("Sök Slutdatum");

        jSpinner2.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1736254980000L), new java.util.Date(1104534000000L), new java.util.Date(1893452400000L), java.util.Calendar.DAY_OF_MONTH));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMinaSamarbetspartners)
                            .addComponent(lblProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMinaProjektProjektledare)
                            .addComponent(lblAnsvarigForProjekt))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblSokStartdatum))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSokSlutdatum)
                                .addGap(122, 122, 122))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(tfdFiltreraProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUppgifterOmProjekt)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblProjekt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMinaProjektProjektledare)
                .addGap(14, 14, 14)
                .addComponent(lblAnsvarigForProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMinaSamarbetspartners)
                .addGap(21, 21, 21)
                .addComponent(btnUppgifterOmProjekt)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdFiltreraProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSokStartdatum)
                    .addComponent(lblSokSlutdatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUppgifterOmProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppgifterOmProjektActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUppgifterOmProjektActionPerformed

    private void tfdFiltreraProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdFiltreraProjektActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdFiltreraProjektActionPerformed

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
            java.util.logging.Logger.getLogger(MenyProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyProjektProjektledare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUppgifterOmProjekt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JLabel lblAnsvarigForProjekt;
    private javax.swing.JLabel lblMinaProjektProjektledare;
    private javax.swing.JLabel lblMinaSamarbetspartners;
    private javax.swing.JLabel lblProjekt;
    private javax.swing.JLabel lblSokSlutdatum;
    private javax.swing.JLabel lblSokStartdatum;
    private javax.swing.JTextField tfdFiltreraProjekt;
    // End of variables declaration//GEN-END:variables
}
