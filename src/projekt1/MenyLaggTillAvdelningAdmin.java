/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author minna
 */
public class MenyLaggTillAvdelningAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    /**
     * Creates new form MenyLaggTillAvdelningAdmin
     */
    public MenyLaggTillAvdelningAdmin(InfDB idb, String dbAid) {
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

        jLabel1 = new javax.swing.JLabel();
        tfdEpost = new javax.swing.JTextField();
        tfdTelefon = new javax.swing.JTextField();
        tfdStad = new javax.swing.JTextField();
        tfdChef = new javax.swing.JTextField();
        tfdNamn = new javax.swing.JTextField();
        tfdBeskrivning = new javax.swing.JTextField();
        tfdAdress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Lägg till avdelning");

        tfdEpost.setText("Skriv här...");

        tfdTelefon.setText("Skriv här...");

        tfdStad.setText("Skriv här...");

        tfdChef.setText("Skriv här...");

        tfdNamn.setText("Skriv här...");

        tfdBeskrivning.setText("Skriv här...");

        tfdAdress.setText("Skriv här...");

        jLabel2.setText("Namn:");

        jLabel3.setText("Beskrivning:");

        jLabel4.setText("Adress:");

        jLabel5.setText("Epost:");

        jLabel6.setText("Telefon:");

        jLabel7.setText("Stad:");

        jLabel8.setText("Chef:");

        btnOk.setText("OK");
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfdChef, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfdAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(tfdBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfdNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdStad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdChef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseClicked

    String nyttNamn = tfdNamn.getText();
    String nyttBeskrivning = tfdBeskrivning.getText();
    String nyttAdress = tfdAdress.getText();
    String nyttEpost = tfdEpost.getText();
    String nyttTelefon = tfdTelefon.getText();
    String nyttStad = tfdStad.getText();
    String nyttChef = tfdChef.getText();
    
    //validering
    
        if (!Validering.isValidNamn(nyttNamn)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ogiltigt förnamn! Endast bokstäver och minst två tecken långt är tillåtna.");
            return;
        }
        if (!Validering.isValidePost(nyttEpost)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ogiltig e-postadress! En Epostadress måste vara formaterad enligt exempel: förnamn.efternamn@domän.");
            return;
        }
        if (!Validering.isValidTelefonnummer(nyttTelefon)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Telefon numret måste bestå av 7-15 siffror, inga tecken är tillåtna.");
            return;
        }
        
        if (!Validering.isNumerisk(nyttStad)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ogiltig inmatning stad! Endast siffror och eventuellt en decimalpunkt är tillåtna.");
            return;
        } 
        if (!Validering.isNumerisk(nyttChef)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ogiltig inmatning chef! Endast siffror och eventuellt en decimalpunkt är tillåtna.");
        return;
        
        }
        if (!Validering.isValidAdress(nyttAdress)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Adressen får inte vara tom. Vänligen fyll i en giltig adress.");
            return;
        }
        if (!Validering.isValidLongText(nyttBeskrivning)) {
            javax.swing.JOptionPane.showMessageDialog(this, "fältet får ej vara tomt i beskrivning");
            return;
        }

    try {
        // Kontrollera om chefen finns i anstalld-tabellen
        String chefQuery = "SELECT aid FROM anstalld WHERE aid = '" + nyttChef + "'";
        String chefExists = idb.fetchSingle(chefQuery);

        if (chefExists == null) {
            JOptionPane.showMessageDialog(this, "Chef med AID " + nyttChef + " finns inte i anstalld-tabellen!");
            return;
        }

        // Hämta nästa lediga avdelnings-ID
        String nyttAvdid = idb.getAutoIncrement("avdelning", "avdid");

        // Lägg till ny avdelning i avdelning-tabellen
        String laggTillAvdelning = "INSERT INTO avdelning (avdid, namn, beskrivning, adress, epost, telefon, stad, chef) " +
                "VALUES (" + nyttAvdid + ", '" + nyttNamn + "', '" + nyttBeskrivning + "', '" + nyttAdress + "', '" + 
                nyttEpost + "', '" + nyttTelefon + "', '" + nyttStad + "', '" + nyttChef + "')";
        idb.insert(laggTillAvdelning);

        JOptionPane.showMessageDialog(this, "Ny avdelning har lagts till!");
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid inmatning av data: " + e.getMessage());
    }
    
    }//GEN-LAST:event_btnOkMouseClicked

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
            java.util.logging.Logger.getLogger(MenyLaggTillAvdelningAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyLaggTillAvdelningAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyLaggTillAvdelningAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyLaggTillAvdelningAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyLaggTillAvdelningAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tfdAdress;
    private javax.swing.JTextField tfdBeskrivning;
    private javax.swing.JTextField tfdChef;
    private javax.swing.JTextField tfdEpost;
    private javax.swing.JTextField tfdNamn;
    private javax.swing.JTextField tfdStad;
    private javax.swing.JTextField tfdTelefon;
    // End of variables declaration//GEN-END:variables
}
