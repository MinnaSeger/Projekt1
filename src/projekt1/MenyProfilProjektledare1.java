package projekt1;
import oru.inf.InfDB;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author elsa
 */
public class MenyProfilProjektledare1 extends javax.swing.JFrame {
    
    private InfDB idb;
    private String dbAid;

    /**
     * Creates new form MenyProfilHandlaggare
     */
    public MenyProfilProjektledare1(InfDB idb, String dbAid) {
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

        lblMinProfil = new javax.swing.JLabel();
        lblMinaUppgifter = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAnstallningsnummer = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblAvdelning = new javax.swing.JLabel();
        lblAnsvarsomrade = new javax.swing.JLabel();
        lblMentor = new javax.swing.JLabel();
        tfdAndraNamn = new javax.swing.JTextField();
        tfdAndraEmail = new javax.swing.JTextField();
        lblTelefonnummer = new javax.swing.JLabel();
        tfdAndraTelefonnummer = new javax.swing.JTextField();
        lblLosenord = new javax.swing.JLabel();
        tfdAndraLosenord = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMinProfil.setText("Min profil ");

        lblMinaUppgifter.setText("Mina Uppgifter");

        lblEmail.setText("Email");

        lblAnstallningsnummer.setText("Anställningsnummer");

        lblNamn.setText("Namn");

        lblAvdelning.setText("Avdelning");

        lblAnsvarsomrade.setText("Ansvarsområde");

        lblMentor.setText("Mentor");

        tfdAndraNamn.setText("Ändra Namn");
        tfdAndraNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdAndraNamnActionPerformed(evt);
            }
        });

        tfdAndraEmail.setText("Ändra Email");
        tfdAndraEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdAndraEmailActionPerformed(evt);
            }
        });

        lblTelefonnummer.setText("Telefonnummer");

        tfdAndraTelefonnummer.setText("Ändra Telefonnummer");
        tfdAndraTelefonnummer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdAndraTelefonnummerActionPerformed(evt);
            }
        });

        lblLosenord.setText("Lösenord");

        tfdAndraLosenord.setText("Ändra Lösenord");
        tfdAndraLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdAndraLosenordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblMinProfil))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMinaUppgifter)
                            .addComponent(lblAnstallningsnummer)
                            .addComponent(lblAnsvarsomrade)
                            .addComponent(lblAvdelning)
                            .addComponent(lblMentor)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTelefonnummer)
                                .addGap(58, 58, 58)
                                .addComponent(tfdAndraTelefonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNamn)
                                    .addComponent(lblEmail)
                                    .addComponent(lblLosenord))
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfdAndraEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdAndraNamn, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdAndraLosenord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMinProfil)
                .addGap(10, 10, 10)
                .addComponent(lblMinaUppgifter)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamn)
                    .addComponent(tfdAndraNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(tfdAndraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLosenord)
                    .addComponent(tfdAndraLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonnummer)
                    .addComponent(tfdAndraTelefonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(lblAnstallningsnummer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAnsvarsomrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMentor)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdAndraNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdAndraNamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdAndraNamnActionPerformed

    private void tfdAndraEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdAndraEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdAndraEmailActionPerformed

    private void tfdAndraLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdAndraLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdAndraLosenordActionPerformed

    private void tfdAndraTelefonnummerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdAndraTelefonnummerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdAndraTelefonnummerActionPerformed

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
            java.util.logging.Logger.getLogger(MenyProfilProjektledare1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyProfilProjektledare1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyProfilProjektledare1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyProfilProjektledare1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyProfilProjektledare1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAnstallningsnummer;
    private javax.swing.JLabel lblAnsvarsomrade;
    private javax.swing.JLabel lblAvdelning;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblMentor;
    private javax.swing.JLabel lblMinProfil;
    private javax.swing.JLabel lblMinaUppgifter;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblTelefonnummer;
    private javax.swing.JTextField tfdAndraEmail;
    private javax.swing.JTextField tfdAndraLosenord;
    private javax.swing.JTextField tfdAndraNamn;
    private javax.swing.JTextField tfdAndraTelefonnummer;
    // End of variables declaration//GEN-END:variables
}
