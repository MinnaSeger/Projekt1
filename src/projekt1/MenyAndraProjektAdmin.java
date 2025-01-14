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
public class MenyAndraProjektAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    
        public MenyAndraProjektAdmin(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        fyllComboBox();
        fyllTextRutor ();
        fyllStatus();


        

    }
    //Fyller textrutor med data från tabellen projekt i DB
    private void fyllTextRutor () {
        try {
            //Hämta data med SQL fråga
            
            String sqlFraga = "SELECT projektnamn, beskrivning, startdatum, slutdatum, kostnad, status, prioritet, projektchef, land " +
               "FROM projekt " +
               "JOIN anstalld ON aid = projektchef " +
               "WHERE pid = " + dbAid;
            
            
           
            HashMap <String, String> userData = idb.fetchRow(sqlFraga);
            
            if (userData != null) {
             tfdProjektnamn.setText(userData.get("projektnamn"));
             tfdBeskrivning.setText(userData.get("beskrivning"));
             tfdStartdatum.setText(userData.get("startdatum"));
             tfdSlutdatum.setText(userData.get("slutdatum"));
             tfdKostnad.setText(userData.get("kostnad"));
             jbxStatus.setSelectedItem(userData.get("status"));
             tfdPrioritet.setText(userData.get("prioritet"));
             tfdProjektchef.setText(userData.get("projektchef"));
             lblLand.setText(userData.get("land"));
                        
    } else { JOptionPane.showMessageDialog(this, "Ingen Data hittades om dig.");

            } 
            
    }  catch (InfException e) { 
    JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!" + e.getMessage());
    }
    }
    
 
    //Fyller rullistan med data från projekt i DB
       private void fyllComboBox(){
        try{
            String sqlFraga ="SELECT projektnamn FROM projekt";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);
            
            if (resultat !=null) {
                jbxrullista.removeAllItems();
                for (HashMap <String, String> rad : resultat) {
                 jbxrullista.addItem(rad.get("projektnamn"));
                }
            }else{
                JOptionPane.showMessageDialog(this, "Inga projekt hittades i databasen.");

            }               
            } catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Fel vid hämtning av projekt.");
        } 
    }
       
           //Fyller rullistan med data från projekt i DB
       private void fyllStatus(){
        try{
            String sqlFraga = "SELECT DISTINCT status FROM projekt";


            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);
            
            if (resultat !=null) {
                jbxStatus.removeAllItems();
                for (HashMap <String, String> rad : resultat) {
                 jbxStatus.addItem(rad.get("status"));
                }
            }else{
                JOptionPane.showMessageDialog(this, "Ingen status hittades för projekt.");

            }               
            } catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Fel vid hämtning av status.");
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        lblValjProjekt = new javax.swing.JLabel();
        jbxrullista = new javax.swing.JComboBox<>();
        tfdProjektnamn = new javax.swing.JTextField();
        tfdBeskrivning = new javax.swing.JTextField();
        tfdStartdatum = new javax.swing.JTextField();
        tfdSlutdatum = new javax.swing.JTextField();
        tfdKostnad = new javax.swing.JTextField();
        tfdPrioritet = new javax.swing.JTextField();
        tfdProjektchef = new javax.swing.JTextField();
        lblProjektnamn = new javax.swing.JLabel();
        lblBeskrivning = new javax.swing.JLabel();
        lblStartdatum = new javax.swing.JLabel();
        lblSlutdatum = new javax.swing.JLabel();
        lblKostnad = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblPrioritet = new javax.swing.JLabel();
        lblProjektchef = new javax.swing.JLabel();
        btnSpara = new javax.swing.JButton();
        lblPIL = new javax.swing.JLabel();
        lblLand = new javax.swing.JLabel();
        jbxStatus = new javax.swing.JComboBox<>();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblValjProjekt.setText("Välj projekt:");

        jbxrullista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jbxrullista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbxrullistaActionPerformed(evt);
            }
        });

        tfdProjektnamn.setText("Ändra projektnamn");

        tfdBeskrivning.setText("Ändra beskrivning");

        tfdStartdatum.setText("Ändra startdatum");

        tfdSlutdatum.setText("Ändra slutdatum");

        tfdKostnad.setText("Ändra kostnad");

        tfdPrioritet.setText("Ändra prioritet");

        tfdProjektchef.setText("Ändra projektchef");

        lblProjektnamn.setText("Projektnamn:");

        lblBeskrivning.setText("Beskrivning:");

        lblStartdatum.setText("Startdatum:");

        lblSlutdatum.setText("Slutdatum:");

        lblKostnad.setText("Kostnad:");

        lblStatus.setText("Status:");

        lblPrioritet.setText("Prioritet:");

        lblProjektchef.setText("Projektchef:");

        btnSpara.setText("Spara ändring");
        btnSpara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSparaMouseClicked(evt);
            }
        });

        lblPIL.setText("Projekt utförs i land:");

        lblLand.setText("Land");

        jbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblValjProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbxrullista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdSlutdatum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(205, 205, 205)
                                        .addComponent(tfdProjektnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdBeskrivning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdStartdatum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdKostnad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdPrioritet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSpara)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblProjektchef, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfdProjektchef, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblPIL)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblLand, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)))
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKostnad)
                            .addComponent(lblSlutdatum)
                            .addComponent(lblStartdatum)
                            .addComponent(lblBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProjektnamn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblValjProjekt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbxrullista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProjektnamn)
                            .addComponent(tfdProjektnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBeskrivning)
                            .addComponent(tfdBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartdatum)
                    .addComponent(tfdStartdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSlutdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSlutdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKostnad)
                    .addComponent(tfdKostnad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(jbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrioritet)
                    .addComponent(tfdPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdProjektchef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProjektchef))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPIL)
                    .addComponent(lblLand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnSpara)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbxrullistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbxrullistaActionPerformed
    //Uppdaterar information i textrutor baserat på val av projekt i rullistan.  
        String valtProjektNamn = (String) jbxrullista.getSelectedItem();
    
    if (valtProjektNamn != null) {
        try {
        // SQL-fråga för att hämta data baserat på partnerns namn
        String sqlFraga = "SELECT projektnamn, beskrivning, startdatum, slutdatum, kostnad, status, prioritet, land, projektchef " +
        "FROM projekt " + "WHERE projektnamn = '" + valtProjektNamn + "'";
                               

        HashMap<String, String> userData = idb.fetchRow(sqlFraga);
            
        if (userData != null) {
        // Uppdatera textfälten med hämtad data
        tfdProjektnamn.setText(userData.get("projektnamn"));
        tfdBeskrivning.setText(userData.get("beskrivning"));
        tfdStartdatum.setText(userData.get("startdatum"));
        tfdSlutdatum.setText(userData.get("slutdatum"));
        tfdKostnad.setText(userData.get("kostnad"));
        jbxStatus.setSelectedItem(userData.get("status"));
        tfdPrioritet.setText(userData.get("prioritet"));
        lblLand.setText(userData.get("land"));
        tfdProjektchef.setText(userData.get("projektchef"));
                
        } else {
            JOptionPane.showMessageDialog(this, "Ingen data hittades för det valda projekter.");
        }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av data: " + e.getMessage());
        }
    } 
    }//GEN-LAST:event_jbxrullistaActionPerformed

    private void btnSparaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSparaMouseClicked
       String nyttStatus = (String) jbxStatus.getSelectedItem();
       //Hämtar text från täxtfältet
        
        String nyttProjektnamn = tfdProjektnamn.getText();
        String nyttBeskrivning = tfdBeskrivning.getText();
        String nyttStartdatum = tfdStartdatum.getText();
        String nyttSlutdatum = tfdSlutdatum.getText();
        String nyttKostnad = tfdKostnad.getText();
        String nyttPrioritet = tfdPrioritet.getText();
        String nyttProjektchef = tfdProjektchef.getText();
        //Uppdetara ändringar i databasen
        
        try {
        //Uppdaterar/byter informationen som användare anger i textrutorna.
        String uppdatering = "UPDATE projekt SET " +  
        "Projektnamn = '" + nyttProjektnamn + "', " + 
        "beskrivning = '" + nyttBeskrivning + "', " +
        "Startdatum = '" + nyttStartdatum + "', " + 
        "Slutdatum = '" + nyttSlutdatum + "', " + 
        "Kostnad = '" + nyttKostnad + "', " + 
        "Status = '" + nyttStatus + "', " + 
        "Prioritet = '" + nyttPrioritet + "', " + 
        "Projektchef = '" + nyttProjektchef + "' " + 
        "WHERE pid = " + dbAid;
            
        System.out.println(uppdatering);
            // Kör uppdateringen
            idb.update(uppdatering);
            
            //Visa bekräftelse av ändringar
            JOptionPane.showMessageDialog(this, "Dina projektändringar är sparade!");
        } catch (Exception e) {
            //Hanterar fel
            JOptionPane.showMessageDialog (this, "Fel vid inmatning av ändringar!" + e.getMessage());
        }
    }//GEN-LAST:event_btnSparaMouseClicked

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
            java.util.logging.Logger.getLogger(MenyAndraProjektAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAndraProjektAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAndraProjektAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAndraProjektAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyProjektAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpara;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jbxStatus;
    private javax.swing.JComboBox<String> jbxrullista;
    private javax.swing.JLabel lblBeskrivning;
    private javax.swing.JLabel lblKostnad;
    private javax.swing.JLabel lblLand;
    private javax.swing.JLabel lblPIL;
    private javax.swing.JLabel lblPrioritet;
    private javax.swing.JLabel lblProjektchef;
    private javax.swing.JLabel lblProjektnamn;
    private javax.swing.JLabel lblSlutdatum;
    private javax.swing.JLabel lblStartdatum;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblValjProjekt;
    private javax.swing.JTextField tfdBeskrivning;
    private javax.swing.JTextField tfdKostnad;
    private javax.swing.JTextField tfdPrioritet;
    private javax.swing.JTextField tfdProjektchef;
    private javax.swing.JTextField tfdProjektnamn;
    private javax.swing.JTextField tfdSlutdatum;
    private javax.swing.JTextField tfdStartdatum;
    // End of variables declaration//GEN-END:variables
}
