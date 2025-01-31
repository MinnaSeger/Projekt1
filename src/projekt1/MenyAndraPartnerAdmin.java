package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
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
public class MenyAndraPartnerAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    
        public MenyAndraPartnerAdmin(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents(); 
        fyllComboBox();       
        fyllTextRutor ();

    }
    
    private void fyllTextRutor () {
        try {
            //Hämta data om partner med SQL fråga samt fyller tillhörande combobox
            
            String sqlFraga = "SELECT namn, kontaktperson, kontaktepost, partner.telefon, partner.adress, branch " +
               "FROM partner " +
               "JOIN projekt ON projekt.pid = partner.pid " +
               "JOIN anstalld ON projekt.projektchef = anstalld.aid " +
               "WHERE partner.pid = " + dbAid;
           
            
            HashMap <String, String> userData = idb.fetchRow(sqlFraga);
            
           //Fyller textfields med aktuell information om partner baserat på val från comboboxen
            if (userData != null) {
             tfdNamn.setText(userData.get("namn"));
             tfdKontaktperson.setText(userData.get("kontaktperson"));
             tfdKontaktEpost.setText(userData.get("kontaktepost"));
             tfdTelefon.setText(userData.get("telefon"));
             tfdAdress.setText(userData.get("adress"));
             tfdBranch.setText(userData.get("branch"));
                        
    } else { JOptionPane.showMessageDialog(this, "Ingen Data hittades om partnern.");

            } 
            
    }  catch (InfException e) { 
    JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!" + e.getMessage());
    }}
    
    //Fyller comboboxen med de partners som finns baserat på databasen.
    private void fyllComboBox(){
        try{
            String sqlFraga ="SELECT namn FROM partner";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);
            
            //Rensar comboboxen och lägger till aktuella partners
            if (resultat !=null) {
                jComboBox1.removeAllItems();
                for (HashMap <String, String> rad : resultat) {
                 jComboBox1.addItem(rad.get("namn"));
                }
            }else{
                JOptionPane.showMessageDialog(this, "Inga partners hittades i databasen.");

            }               
            } catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Fel vid hämtning av partner.");
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

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        tfdNamn = new javax.swing.JTextField();
        tfdKontaktperson = new javax.swing.JTextField();
        tfdKontaktEpost = new javax.swing.JTextField();
        tfdTelefon = new javax.swing.JTextField();
        tfdAdress = new javax.swing.JTextField();
        tfdBranch = new javax.swing.JTextField();
        lblNamn = new javax.swing.JLabel();
        lblKontaktperson = new javax.swing.JLabel();
        lblKontaktEpost = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblBranch = new javax.swing.JLabel();
        btnSpara = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Välj partner:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        tfdNamn.setText("Ändra Namn");

        tfdKontaktperson.setText("Ändra kontaktperson");

        tfdKontaktEpost.setText("Ändra kontakt ePost");

        tfdTelefon.setText("Ändra telefon");

        tfdAdress.setText("Ändra adress");

        tfdBranch.setText("Ändra branch");

        lblNamn.setText("Namn:");

        lblKontaktperson.setText("Kontaktperson:");

        lblKontaktEpost.setText("Kontakt ePost:");

        lblTelefon.setText("Telefon:");

        lblAdress.setText("Adress:");

        lblBranch.setText("Branch:");

        btnSpara.setText("Spara änringar");
        btnSpara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSparaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKontaktEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKontaktperson, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfdKontaktperson)
                    .addComponent(tfdBranch)
                    .addComponent(tfdAdress)
                    .addComponent(tfdTelefon)
                    .addComponent(tfdKontaktEpost)
                    .addComponent(tfdNamn))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSpara)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNamn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdKontaktperson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKontaktperson))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdKontaktEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKontaktEpost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAdress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBranch)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnSpara)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSparaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSparaMouseClicked
          //Hämta text från textfälten i tabellen partner
        
        String nyttNamn = tfdNamn.getText();
        String nyttKontaktperson = tfdKontaktperson.getText();
        String nyttEpost = tfdKontaktEpost.getText();
        String nyttTelefon = tfdTelefon.getText();
        String nyttAdress = tfdAdress.getText();
        String nyttBranch = tfdBranch.getText();
        
        //validering
        
        if (!Validering.isValidNamn(nyttNamn) || !Validering.isValidNamn(nyttKontaktperson)|| !Validering.isValidNamn(nyttBranch)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ogiltigt förnamn! Endast bokstäver och minst två tecken långt är tillåtet.");
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
        
        try {
            //Uppdaterar ändringar baserat på vad användare skriver in
        String uppdatering = "UPDATE partner SET " +  
        "namn = '" + nyttNamn + "', " + 
        "kontaktperson = '" + nyttKontaktperson + "', " +
        "kontaktepost = '" + nyttEpost + "', " + 
        "telefon = '" + nyttTelefon + "', " + 
        "adress = '" + nyttAdress + "', " + 
        "branch = '" + nyttBranch + "' " + 
        "WHERE pid = " + dbAid;
            System.out.println(uppdatering);
            // Kör uppdateringen
            idb.update(uppdatering);
            
            //Visa bekräftelse av ändringar
            JOptionPane.showMessageDialog(this, "Dina Profil Ändringar Är Sparade!");
        } catch (Exception e) {
            //Hanterar fel
            JOptionPane.showMessageDialog (this, "Fel vid inmatning av ändringar!" + e.getMessage());
        } 
    }//GEN-LAST:event_btnSparaMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String valtPartnerNamn = (String) jComboBox1.getSelectedItem();
    
        if (valtPartnerNamn != null) {
        try {
            // SQL-fråga för att hämta data baserat på partnerns namn
            String sqlFraga = "SELECT namn, kontaktperson, kontaktepost, partner.telefon, partner.adress, branch " +
                               "FROM partner " +
                               "WHERE namn = '" + valtPartnerNamn + "'";

            HashMap<String, String> userData = idb.fetchRow(sqlFraga);
            
            if (userData != null) {
                // Uppdatera textfälten med hämtad data
                tfdNamn.setText(userData.get("namn"));
                tfdKontaktperson.setText(userData.get("kontaktperson"));
                tfdKontaktEpost.setText(userData.get("kontaktepost"));
                tfdTelefon.setText(userData.get("telefon"));
                tfdAdress.setText(userData.get("adress"));
                tfdBranch.setText(userData.get("branch"));
            } else {
                JOptionPane.showMessageDialog(this, "Ingen data hittades för den valda partnern.");
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av data: " + e.getMessage());
        }
    }     
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenyAndraPartnerAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAndraPartnerAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAndraPartnerAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAndraPartnerAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyPartnersAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpara;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblKontaktEpost;
    private javax.swing.JLabel lblKontaktperson;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField tfdAdress;
    private javax.swing.JTextField tfdBranch;
    private javax.swing.JTextField tfdKontaktEpost;
    private javax.swing.JTextField tfdKontaktperson;
    private javax.swing.JTextField tfdNamn;
    private javax.swing.JTextField tfdTelefon;
    // End of variables declaration//GEN-END:variables
}
