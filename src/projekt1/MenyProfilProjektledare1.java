package projekt1;
import oru.inf.InfDB;
import javax.swing.JFrame;
import oru.inf.InfException;
import javax.swing.JOptionPane;
import java.util.HashMap;

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
        
        //fyll Textfälten med data från databasen
        
        fyllTextFalt ();
    }
    
    private void fyllTextFalt () {
        try {
            //Hämta data med SQL fråga
            
            String query = "SELECT fornamn, efternamn, epost, telefon, losenord FROM anstalld where aid =" + dbAid;
            
            HashMap <String, String> userData = idb.fetchRow(query);
            
            if (userData != null) {
             tfdFornamn.setText(userData.get("fornamn"));
             tfdEfternamn.setText(userData.get("efternamn"));
             tfdEpost.setText(userData.get("epost"));
             tfdTelefon.setText(userData.get("telefon"));
             tfdLosenord.setText(userData.get("losenord"));
             
} else { JOptionPane.showMessageDialog(this, "Ingen Data hittades om dig.");

            } 
            
} catch (InfException e) { 
    JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!" + e.getMessage());
                    
        }
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
        lblEpost = new javax.swing.JLabel();
        lblAnstallningsnummer = new javax.swing.JLabel();
        lblFornamn = new javax.swing.JLabel();
        lblAvdelning = new javax.swing.JLabel();
        lblAnsvarsomrade = new javax.swing.JLabel();
        lblMentor = new javax.swing.JLabel();
        tfdFornamn = new javax.swing.JTextField();
        tfdEpost = new javax.swing.JTextField();
        lblTelefon = new javax.swing.JLabel();
        tfdTelefon = new javax.swing.JTextField();
        lblLosenord = new javax.swing.JLabel();
        tfdLosenord = new javax.swing.JTextField();
        btnSparaAndringar = new javax.swing.JButton();
        lblEfternamn = new javax.swing.JLabel();
        tfdEfternamn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMinProfil.setText("Min profil ");

        lblMinaUppgifter.setText("Mina Uppgifter");

        lblEpost.setText("Epost");

        lblAnstallningsnummer.setText("Anställningsnummer");

        lblFornamn.setText("Fornamn");

        lblAvdelning.setText("Avdelning");

        lblAnsvarsomrade.setText("Ansvarsområde");

        lblMentor.setText("Mentor");

        tfdFornamn.setText("Förnamn");
        tfdFornamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdFornamnActionPerformed(evt);
            }
        });

        tfdEpost.setText("Epost");
        tfdEpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdEpostActionPerformed(evt);
            }
        });

        lblTelefon.setText("Telefon");

        tfdTelefon.setText("Telefon");
        tfdTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdTelefonActionPerformed(evt);
            }
        });

        lblLosenord.setText("Lösenord");

        tfdLosenord.setText("Lösenord");
        tfdLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdLosenordActionPerformed(evt);
            }
        });

        btnSparaAndringar.setText("Spara ändringar");
        btnSparaAndringar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSparaAndringarMouseClicked(evt);
            }
        });

        lblEfternamn.setText("Efternamn");

        tfdEfternamn.setText("Efternamn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSparaAndringar)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnstallningsnummer)
                            .addComponent(lblAnsvarsomrade)
                            .addComponent(lblAvdelning)
                            .addComponent(lblMentor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLosenord)
                                    .addComponent(lblTelefon)
                                    .addComponent(lblEpost)
                                    .addComponent(lblEfternamn)
                                    .addComponent(lblFornamn))
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblMinaUppgifter)
                                .addGap(81, 81, 81)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfdTelefon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdLosenord, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdEpost, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdEfternamn, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdFornamn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblMinProfil)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMinProfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMinaUppgifter)
                        .addGap(5, 5, 5)
                        .addComponent(lblFornamn)
                        .addGap(18, 18, 18)
                        .addComponent(lblEfternamn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfdFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfdEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEpost)
                    .addComponent(tfdEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLosenord)
                    .addComponent(tfdLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefon)
                    .addComponent(tfdTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAnstallningsnummer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblAnsvarsomrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSparaAndringar)
                    .addComponent(lblMentor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdFornamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdFornamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdFornamnActionPerformed

    private void tfdEpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdEpostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdEpostActionPerformed

    private void tfdLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdLosenordActionPerformed

    private void tfdTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdTelefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdTelefonActionPerformed

    private void btnSparaAndringarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSparaAndringarMouseClicked
        // TODO add your handling code here:
        
        //Hämta text från textfältet
        
        String nyttFornamn = tfdFornamn.getText();
        String nyttEfternamn = tfdEfternamn.getText();
        String nyttEpost = tfdEpost.getText();
        String nyttTelefon = tfdTelefon.getText();
        String nyttLosenord = tfdLosenord.getText();
        
        //Uppdetara ändringar i databasen
        
        try {
            //Byta ändrngar
            String updateQuery = "UPDATE anstalld SET " +  
                    "fornamn = '" + nyttFornamn + "', " + 
                    "efternamn = '" + nyttEfternamn + "'," +
                    "epost = '" + nyttEpost + "', " + 
                    "telefon = '" + nyttTelefon + "', " + 
                    "losenord = '" + nyttLosenord + "' " + 
                    "WHERE aid = " + dbAid;
            System.out.println(updateQuery);
            // Kör uppdateringen
            idb.update(updateQuery);
            
            //Visa bekräftelse av ändringar
            JOptionPane.showMessageDialog(this, "Dina Profil Ändringar Är Sparade!");
        } catch (Exception e) {
            //Hantera fel?
            JOptionPane.showMessageDialog (this, "Fel vid inmatning av ändringar!" + e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnSparaAndringarMouseClicked

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
    private javax.swing.JButton btnSparaAndringar;
    private javax.swing.JLabel lblAnstallningsnummer;
    private javax.swing.JLabel lblAnsvarsomrade;
    private javax.swing.JLabel lblAvdelning;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblMentor;
    private javax.swing.JLabel lblMinProfil;
    private javax.swing.JLabel lblMinaUppgifter;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField tfdEfternamn;
    private javax.swing.JTextField tfdEpost;
    private javax.swing.JTextField tfdFornamn;
    private javax.swing.JTextField tfdLosenord;
    private javax.swing.JTextField tfdTelefon;
    // End of variables declaration//GEN-END:variables
}
