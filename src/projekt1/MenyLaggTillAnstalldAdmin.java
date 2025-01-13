package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author minna
 */
public class MenyLaggTillAnstalldAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    
    
        public MenyLaggTillAnstalldAdmin(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        fyllComboBox();

        }
                
        //Kod för att kunna välja anställd i rullista
private void fyllComboBox() {
    try {
        String sqlFraga = "SELECT fornamn, efternamn FROM anstalld "+"order by fornamn";
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        if (resultat != null && !resultat.isEmpty()) {
            jbxAnstalld.removeAllItems();
            for (HashMap<String, String> rad : resultat) {
                String fullName = rad.get("fornamn") + " " + rad.get("efternamn");
                jbxAnstalld.addItem(fullName);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga anställda hittades i databasen.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av anställda: " + e.getMessage());
    
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

        lblLaggTillAnstalld = new javax.swing.JLabel();
        lblTaBortAnstalld = new javax.swing.JLabel();
        jbxAnstalld = new javax.swing.JComboBox<>();
        lblValjAnstalld = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        tfdFornamn = new javax.swing.JTextField();
        tfdAdress = new javax.swing.JTextField();
        tfdLosenord = new javax.swing.JTextField();
        tfdEfternamn = new javax.swing.JTextField();
        tfdEpost = new javax.swing.JTextField();
        tfdAnstallningsDat = new javax.swing.JTextField();
        tfdTelnr = new javax.swing.JTextField();
        btnOK1 = new javax.swing.JButton();
        lblFornamn = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblAnstallningsDat = new javax.swing.JLabel();
        lblLosenord = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLaggTillAnstalld.setText("Lägg till anställd:");

        lblTaBortAnstalld.setText("Ta bort anställd:");

        jbxAnstalld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jbxAnstalld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbxAnstalldActionPerformed(evt);
            }
        });

        lblValjAnstalld.setText("Välj anställd i rullistan");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        tfdFornamn.setText("Skriv förnamn här");
        tfdFornamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdFornamnActionPerformed(evt);
            }
        });

        tfdAdress.setText("Skriv Adress här");

        tfdLosenord.setText("Ditt slumpade lösenord är");
        tfdLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdLosenordActionPerformed(evt);
            }
        });

        tfdEfternamn.setText("Skriv efternamn här");
        tfdEfternamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdEfternamnActionPerformed(evt);
            }
        });

        tfdEpost.setText("Skriv Epost här");

        tfdAnstallningsDat.setText("Skriv anställningsdatum här");
        tfdAnstallningsDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdAnstallningsDatActionPerformed(evt);
            }
        });

        tfdTelnr.setText("Skriv telefonnummer här");

        btnOK1.setText("Slumpa lösenord");
        btnOK1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOK1MouseClicked(evt);
            }
        });
        btnOK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOK1ActionPerformed(evt);
            }
        });

        lblFornamn.setText("Förnamn:");

        lblAdress.setText("Adress:");

        lblEpost.setText("Epost:");

        lblTelefon.setText("Telefon:");

        lblAnstallningsDat.setText("Anställnings.dat:");

        lblLosenord.setText("Lösenord:");

        lblEfternamn.setText("Efternamn:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfdEfternamn, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfdFornamn))
                                    .addGap(76, 76, 76)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFornamn)
                                    .addComponent(lblLaggTillAnstalld, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAnstallningsDat, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfdAnstallningsDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblValjAnstalld)
                                            .addComponent(jbxAnstalld, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTaBortAnstalld, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(33, 33, 33)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdTelnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnOK))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfdLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOK1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblLaggTillAnstalld)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblFornamn)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelefon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdTelnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEfternamn)
                    .addComponent(lblEpost))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnstallningsDat)
                    .addComponent(lblAdress))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdAnstallningsDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOK1)
                            .addComponent(tfdLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTaBortAnstalld)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValjAnstalld)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbxAnstalld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOK)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
      try {
        // Hämta den valda anställdas namn från JComboBox
        String valdAnstalld = (String) jbxAnstalld.getSelectedItem();

        if (valdAnstalld != null) {
            // Dela upp det valda namnet i förnamn och efternamn
            String[] namnDelar = valdAnstalld.split(" ");
            String fornamn = namnDelar[0];
            String efternamn = namnDelar.length > 1 ? namnDelar[1] : "";

            // SQL-fråga för att ta bort den valda anställda
            String sqlTaBort = "DELETE FROM anstalld WHERE fornamn = '" + fornamn + 
                               "' AND efternamn = '" + efternamn + "'";

            // Utför borttagningen
            idb.delete(sqlTaBort);

            // Visa bekräftelse
            JOptionPane.showMessageDialog(this, "Anställd " + valdAnstalld + " togs bort.");
            // Uppdatera JComboBox
            fyllComboBox();
        } else {
        JOptionPane.showMessageDialog(this, "Vänligen välj en anställd att ta bort.");
    }
      } catch (InfException e) {
    JOptionPane.showMessageDialog(this, "Fel vid borttagning av anställd: " + e.getMessage());
}
    // TODO add your handling code here:
    }//GEN-LAST:event_btnOKActionPerformed

    private void tfdFornamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdFornamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdFornamnActionPerformed

    private void tfdLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdLosenordActionPerformed

    private void btnOK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOK1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOK1ActionPerformed

    private void tfdEfternamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdEfternamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdEfternamnActionPerformed

    private void tfdAnstallningsDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdAnstallningsDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdAnstallningsDatActionPerformed

    private void jbxAnstalldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbxAnstalldActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jbxAnstalldActionPerformed

    private void btnOK1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOK1MouseClicked
                                         

        int length = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        tfdLosenord.setText(password.toString());
         // TODO add your handling code here:
    }//GEN-LAST:event_btnOK1MouseClicked

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
            java.util.logging.Logger.getLogger(MenyLaggTillAnstalldAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyLaggTillAnstalldAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyLaggTillAnstalldAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyLaggTillAnstalldAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyLaggTillAnstalldAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnOK1;
    private javax.swing.JComboBox<String> jbxAnstalld;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblAnstallningsDat;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblLaggTillAnstalld;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblTaBortAnstalld;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JLabel lblValjAnstalld;
    private javax.swing.JTextField tfdAdress;
    private javax.swing.JTextField tfdAnstallningsDat;
    private javax.swing.JTextField tfdEfternamn;
    private javax.swing.JTextField tfdEpost;
    private javax.swing.JTextField tfdFornamn;
    private javax.swing.JTextField tfdLosenord;
    private javax.swing.JTextField tfdTelnr;
    // End of variables declaration//GEN-END:variables
}
