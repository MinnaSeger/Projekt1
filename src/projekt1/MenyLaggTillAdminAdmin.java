package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author minna
 */

public class MenyLaggTillAdminAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    private String aid;
    
    
        public MenyLaggTillAdminAdmin(InfDB idb, String dbAid) {
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

        lblLaggTillAnstalld = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        tfdFornamn = new javax.swing.JTextField();
        tfdAdress = new javax.swing.JTextField();
        tfdLosenord = new javax.swing.JTextField();
        tfdEfternamn = new javax.swing.JTextField();
        tfdEpost = new javax.swing.JTextField();
        tfdAnstallningsDat = new javax.swing.JTextField();
        tfdTelnr = new javax.swing.JTextField();
        btnSlumpaLosen = new javax.swing.JButton();
        lblFornamn = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblAnstallningsDat = new javax.swing.JLabel();
        lblLosenord = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfdBehorighet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdAvdelning = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLaggTillAnstalld.setText("Lägg till anställd:");

        btnOK.setText("OK");
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKMouseClicked(evt);
            }
        });
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

        tfdLosenord.setText("Ditt nya lösenord");
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

        btnSlumpaLosen.setText("Slumpa lösenord");
        btnSlumpaLosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSlumpaLosenMouseClicked(evt);
            }
        });
        btnSlumpaLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSlumpaLosenActionPerformed(evt);
            }
        });

        lblFornamn.setText("Förnamn:");

        lblAdress.setText("Adress:");

        lblEpost.setText("Epost:");

        lblTelefon.setText("Telefon:");

        lblAnstallningsDat.setText("Anställnings.dat:");

        lblLosenord.setText("Lösenord:");

        lblEfternamn.setText("Efternamn:");

        jLabel1.setText("Behörighetsnivå");

        tfdBehorighet.setText("Skriv behörighet här");

        jLabel2.setText("Avdelning:");

        tfdAvdelning.setText("Skriv avdelning här");
        tfdAvdelning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdAvdelningActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tfdEfternamn, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfdFornamn))
                                            .addGap(76, 76, 76)))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFornamn)
                                        .addComponent(lblLaggTillAnstalld, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAnstallningsDat, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfdAnstallningsDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfdBehorighet))
                                .addGap(87, 87, 87)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnOK)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfdEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfdTelnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfdAdress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 37, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfdLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSlumpaLosen)
                        .addContainerGap())))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdBehorighet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSlumpaLosen)
                    .addComponent(tfdLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnOK)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
 
    // TODO add your handling code here:
    }//GEN-LAST:event_btnOKActionPerformed

    private void tfdFornamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdFornamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdFornamnActionPerformed

    private void tfdLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdLosenordActionPerformed

    private void btnSlumpaLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSlumpaLosenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSlumpaLosenActionPerformed

    private void tfdEfternamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdEfternamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdEfternamnActionPerformed

    private void tfdAnstallningsDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdAnstallningsDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdAnstallningsDatActionPerformed

    private void tfdAvdelningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdAvdelningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdAvdelningActionPerformed

    private void btnSlumpaLosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSlumpaLosenMouseClicked
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
    }//GEN-LAST:event_btnSlumpaLosenMouseClicked

    private void btnOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseClicked
try {
            this.aid = idb.getAutoIncrement("anstalld", "aid");
        } catch (InfException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Problem med att autoinkrementera aid.");
        }
        String nyttFornamn = tfdFornamn.getText();
        String nyttEfternamn = tfdEfternamn.getText();
        String nyttAnstallningsdatum = tfdAnstallningsDat.getText();
        String nyttAvdelning = tfdAvdelning.getText();
        String nyttTelefon = tfdTelnr.getText();
        String nyttEpost = tfdEpost.getText();
        String nyttAdress = tfdAdress.getText();
        String nyttBehorighetsniva = tfdBehorighet.getText();
        String nyttLosenord = tfdLosenord.getText();
        
        try {
        // Hämta nästa lediga autoinkrement-ID (om databasen stödjer detta)
        String nyttAid = idb.getAutoIncrement("anstalld", "aid");

        // Lägg till ny anställd i anstalld-tabellen
        String insertAnstalld = "INSERT INTO anstalld (aid, fornamn, efternamn, adress, epost, telefon, anstallningsdatum, avdelning, losenord ) " +
                "VALUES (" + nyttAid + ", '" + nyttFornamn + "', '" + nyttEfternamn + "', '" + nyttAdress + "', '" + nyttEpost + "', '" + 
                nyttTelefon + "', '" + nyttAnstallningsdatum + "', '" + nyttAvdelning + "', '" + nyttLosenord + "')";
        
        idb.insert(insertAnstalld);

        // Lägg till behörighetsnivå i admin-tabellen
        String insertAdmin = "INSERT INTO admin (aid, behorighetsniva) VALUES (" + nyttAid + ", '" + nyttBehorighetsniva + "')";
        idb.insert(insertAdmin);

        // Bekräftelse
        JOptionPane.showMessageDialog(this, "Ny administratör har lagts till!");
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid inmatning av data: " + e.getMessage());
    }                       
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOKMouseClicked

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
            java.util.logging.Logger.getLogger(MenyLaggTillAdminAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyLaggTillAdminAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyLaggTillAdminAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyLaggTillAdminAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSlumpaLosen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblAnstallningsDat;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblLaggTillAnstalld;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField tfdAdress;
    private javax.swing.JTextField tfdAnstallningsDat;
    private javax.swing.JTextField tfdAvdelning;
    private javax.swing.JTextField tfdBehorighet;
    private javax.swing.JTextField tfdEfternamn;
    private javax.swing.JTextField tfdEpost;
    private javax.swing.JTextField tfdFornamn;
    private javax.swing.JTextField tfdLosenord;
    private javax.swing.JTextField tfdTelnr;
    // End of variables declaration//GEN-END:variables
}
