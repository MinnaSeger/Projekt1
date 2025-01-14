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
public class MenyAvdelningForSamhallsutvecklingAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    
        public MenyAvdelningForSamhallsutvecklingAdmin(InfDB idb, String dbAid) {
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
               "WHERE namn = 'Avdelning för Samhällsutveckling och utbildning' ";

   
        HashMap <String, String> userData = idb.fetchRow(sqlFraga);
            
            if (userData != null) {
             tfdNamn.setText(userData.get("namn"));
             tfdBeskrivning.setText(userData.get("beskrivning"));
             tfdAdress.setText(userData.get("adress"));
             tfdEpost.setText(userData.get("epost"));
             tfdTelefon.setText(userData.get("telefon"));
                        
        } else { JOptionPane.showMessageDialog(this, "Ingen Data hittades om dig.");

            } 
            
        }  catch (InfException e) { 
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!" + e.getMessage());
    }
    }                                     
                                    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAndraUppgifter = new javax.swing.JLabel();
        tfdNamn = new javax.swing.JTextField();
        tfdBeskrivning = new javax.swing.JTextField();
        tfdAdress = new javax.swing.JTextField();
        tfdEpost = new javax.swing.JTextField();
        tfdTelefon = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAndraUppgifter.setText("Ändra uppgifter:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAndraUppgifter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfdTelefon, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfdEpost, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfdAdress, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfdNamn, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfdBeskrivning, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblAndraUppgifter)
                .addGap(37, 37, 37)
                .addComponent(tfdNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfdBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfdAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfdEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfdTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //Hämtar nuvarande data om avdelning
        String nyttNamn = tfdNamn.getText();
        String nyttBeskrivning = tfdBeskrivning.getText();
        String nyttAdress = tfdAdress.getText();
        String nyttEpost = tfdEpost.getText();
        String nyttTelefon = tfdTelefon.getText();

        
        try {
            //Genomföra ändringar
        String uppdatering = "UPDATE avdelning SET " +  
        "namn = '" + nyttNamn + "', " + 
        "beskrivning = '" + nyttBeskrivning + "', " +
        "adress = '" + nyttAdress + "', " +
        "epost= '" + nyttEpost + "', " +
        "telefon= '" + nyttTelefon + "' " + 
        "WHERE avdid = " + dbAid;
            System.out.println(uppdatering);
            // Kör uppdateringen
            idb.update(uppdatering);
            
            //Visa bekräftelse av ändringar
            JOptionPane.showMessageDialog(this, "Dina ändringar är sparade!");
        } catch (Exception e) {
            //Hanterar fel
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
            java.util.logging.Logger.getLogger(MenyAvdelningForSamhallsutvecklingAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAvdelningForSamhallsutvecklingAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAvdelningForSamhallsutvecklingAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAvdelningForSamhallsutvecklingAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyAvdelningForSamhallsutvecklingAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAndraUppgifter;
    private javax.swing.JTextField tfdAdress;
    private javax.swing.JTextField tfdBeskrivning;
    private javax.swing.JTextField tfdEpost;
    private javax.swing.JTextField tfdNamn;
    private javax.swing.JTextField tfdTelefon;
    // End of variables declaration//GEN-END:variables
}
