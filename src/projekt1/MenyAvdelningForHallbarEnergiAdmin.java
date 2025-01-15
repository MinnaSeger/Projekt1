package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.HashMap;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
public class MenyAvdelningForHallbarEnergiAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    
        public MenyAvdelningForHallbarEnergiAdmin(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
       
        
        fyllTextRutor ();   

        }
   //SQL-fråga för att hämta information om aktuell avdelning, vidare fylla comboboxen med information.
    private void fyllTextRutor () {
        try {
       String sqlFraga = "SELECT namn, beskrivning, avdelning.adress, avdelning.epost, avdelning.telefon " +
               "FROM avdelning " +
               "JOIN anstalld ON avdelning.avdid = anstalld.avdelning " + 
               "WHERE namn = 'Avdelning för Hållbar Energi och Klimatförändringar' ";

   
    HashMap <String, String> userData = idb.fetchRow(sqlFraga);
            
            if (userData != null) {
             tfdNamn.setText(userData.get("namn"));
             tfdBeskrivning.setText(userData.get("beskrivning"));
             tfdAdress.setText(userData.get("adress"));
             tfdEpost.setText(userData.get("epost"));
             tfdTelefon.setText(userData.get("telefon"));
                        
    } else { JOptionPane.showMessageDialog(this, "Ingen Data hittades om avdelningen.");

            } 
            
    }  catch (InfException e) { 
    JOptionPane.showMessageDialog(this, "Fel vid hämtning av data, försök igen." + e.getMessage());
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAndraUppgifter = new javax.swing.JLabel();
        tfdNamn = new javax.swing.JTextField();
        tfdBeskrivning = new javax.swing.JTextField();
        tfdAdress = new javax.swing.JTextField();
        tfdEpost = new javax.swing.JTextField();
        tfdTelefon = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAndraUppgifter.setText("Ändra uppgifter");

        tfdNamn.setText("Namn...");

        tfdBeskrivning.setText("Beskrivning...");

        tfdAdress.setText("Adress...");

        tfdEpost.setText("Epost...");

        tfdTelefon.setText("Telefon...");

        jButton1.setText("OK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setText("Namn:");

        jLabel2.setText("Beskrivning:");

        jLabel3.setText("Adress:");

        jLabel4.setText("Epost:");

        jLabel5.setText("Telefon:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAndraUppgifter, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfdNamn)
                        .addComponent(tfdBeskrivning, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addComponent(tfdAdress)
                        .addComponent(tfdEpost)
                        .addComponent(tfdTelefon)))
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblAndraUppgifter)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //Hämtar nuvarande information om avdelningen
        String nyttNamn = tfdNamn.getText();
        String nyttBeskrivning = tfdBeskrivning.getText();
        String nyttAdress = tfdAdress.getText();
        String nyttEpost = tfdEpost.getText();
        String nyttTelefon = tfdTelefon.getText();
        
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
        if (!Validering.isValidAdress(nyttAdress)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Adressen får inte vara tom. Vänligen fyll i en giltig adress.");
            return;
        }
        if (!Validering.isValidLongText(nyttBeskrivning)) {
            javax.swing.JOptionPane.showMessageDialog(this, "fältet får ej vara tomt, avsluta med punkt.");
            return;
        }
        try {
        //Byta information om avdelningen
        String uppdatering = "UPDATE avdelning SET " +  
        "namn = '" + nyttNamn + "', " + 
        "beskrivning = '" + nyttBeskrivning + "', " +
        "adress = '" + nyttAdress + "', " +
        "epost= '" + nyttEpost + "', " +
        "telefon= '" + nyttTelefon + "' " + 
        "WHERE avdid = " + dbAid;
            System.out.println(uppdatering);
            idb.update(uppdatering);
            
            //Visa bekräftelse av ändringar
            JOptionPane.showMessageDialog(this, "Dina ändringar är sparade!");
        } catch (Exception e) {
            //Hanterar ev. fel
            JOptionPane.showMessageDialog (this, "Fel vid inmatning av ändringar!" + e.getMessage());
        }             
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(MenyAvdelningForHallbarEnergiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAvdelningForHallbarEnergiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAvdelningForHallbarEnergiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAvdelningForHallbarEnergiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyAvdelningForHallbarEnergiAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblAndraUppgifter;
    private javax.swing.JTextField tfdAdress;
    private javax.swing.JTextField tfdBeskrivning;
    private javax.swing.JTextField tfdEpost;
    private javax.swing.JTextField tfdNamn;
    private javax.swing.JTextField tfdTelefon;
    // End of variables declaration//GEN-END:variables
}
