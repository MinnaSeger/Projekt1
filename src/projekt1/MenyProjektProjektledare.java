/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.ArrayList;

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
        
        FyllILabelAnsvarigForProjekt(); 
        FyllISamarbetspartners();
        FylliAvdelningensProjekt();
        
    }
    
    private void FyllILabelAnsvarigForProjekt () {
        try{ //Hämta data om anställdas projekt
String sqlFraga = "SELECT projektnamn "
    + "FROM projekt "
    + "WHERE projektchef = " + dbAid;

            HashMap <String, String> userData = idb.fetchRow(sqlFraga);
            
            if(userData !=null){
                
                lblAnsvarigForProjekt.setText("Ansvarig för projekt: " + userData.get("projektnamn"));
                
            }
           } catch (InfException e) { 
    JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!" + e.getMessage()); 
            
        } 
          
    } 
    
private void FyllISamarbetspartners() {
    try {
        // SQL-fråga som hämtar alla partners för projektet där projektchefen är den angivna aid
        String sqlFraga = "SELECT DISTINCT partner.namn "
                     + "FROM projekt "
                     + "INNER JOIN projekt_partner ON projekt.pid = projekt_partner.pid "
                     + "INNER JOIN partner ON projekt_partner.partner_pid = partner.pid "
                     + "WHERE projekt.projektchef = " + dbAid;

        // Hämta alla partners
        ArrayList<HashMap<String, String>> partners = idb.fetchRows(sqlFraga);

        // Om det finns resultat, sätt texten för labeln
        if (partners != null && !partners.isEmpty()) {
            StringBuilder partnerNames = new StringBuilder();

            // Loopa igenom alla partners och bygg upp en sträng med partnernamnen
            for (HashMap<String, String> partner : partners) {
                String partnerName = partner.get("namn"); // Använd rätt nyckel för partnernamnet
                if (partnerName != null) {
                    partnerNames.append(partnerName).append(", ");
                }
            }

            // Ta bort sista kommatecknet om det finns några namn
            if (partnerNames.length() > 0) {
                partnerNames.setLength(partnerNames.length() - 2); // Ta bort sista kommatecknet
            }

            // Sätt texten på labeln för att visa alla partners
            lblMinaSamarbetspartners.setText("Mina samarbetspartners: " + partnerNames.toString());
        } else {
            // Om inga partners hittas, visa ett meddelande
            lblMinaSamarbetspartners.setText("Inga samarbetspartners hittades.");
        }
    } catch (InfException e) {
        // Fångar eventuella fel och visar ett meddelande
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!" + e.getMessage());
    }
}

private void FylliAvdelningensProjekt() {
    try {
        // SQL-fråga för att hämta projektnamn från projekt i avdelningen där den inloggade projektchefen är chef
        String sqlFraga = "SELECT DISTINCT projekt.projektnamn "
                     + "FROM projekt "
                     + "INNER JOIN avdelning ON projekt.projektchef = avdelning.chef "
                     + "WHERE avdelning.chef = " + dbAid;

        // Kör frågan och hämta resultaten
        ArrayList<HashMap<String, String>> projektLista = idb.fetchRows(sqlFraga);

        // Kontrollera om vi fick några projekt från databasen
        if (projektLista != null && !projektLista.isEmpty()) {
            // Skapa en sträng för att lagra projektnamn
            String projektnamnString = "";

            // Loopa igenom varje projekt och lägg till namnet i strängen
            for (HashMap<String, String> projekt : projektLista) {
                String projektnamn = projekt.get("projektnamn");
                if (projektnamn != null) {
                    projektnamnString += projektnamn + ", ";
                }
            }

            // Ta bort sista kommatecknet och mellanslaget
            if (!projektnamnString.isEmpty()) {
                projektnamnString = projektnamnString.substring(0, projektnamnString.length() - 2);
            }

            // Visa projekten i labeln
            lblAvdelningensProjekt.setText("Avdelningens projekt: " + projektnamnString);
        } else {
            // Om inga projekt hittas
            lblAvdelningensProjekt.setText("Inga projekt hittades för din avdelning.");
        }
    } catch (InfException e) {
        // Om något går fel, visa ett felmeddelande
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av data! " + e.getMessage());
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

        lblProjekt = new javax.swing.JLabel();
        btnUppgifterOmProjekt = new javax.swing.JButton();
        lblAnsvarigForProjekt = new javax.swing.JLabel();
        lblMinaSamarbetspartners = new javax.swing.JLabel();
        lblAvdelningensProjekt = new javax.swing.JLabel();
        tfdFiltreraProjekt = new javax.swing.JTextField();
        lblSokStartdatum = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        lblSokSlutdatum = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProjekt.setText("Mina Projekt");

        btnUppgifterOmProjekt.setText("Uppgifter om projekt");
        btnUppgifterOmProjekt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUppgifterOmProjektMouseClicked(evt);
            }
        });
        btnUppgifterOmProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUppgifterOmProjektActionPerformed(evt);
            }
        });

        lblAnsvarigForProjekt.setText("Ansvarig för projekt");

        lblMinaSamarbetspartners.setText("Mina Samarbetspartners");

        lblAvdelningensProjekt.setText("Avdelningensprojekt");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSokStartdatum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSokSlutdatum)
                        .addGap(122, 122, 122))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(lblProjekt)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUppgifterOmProjekt)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAvdelningensProjekt)
                        .addGap(18, 18, 18)
                        .addComponent(tfdFiltreraProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMinaSamarbetspartners)
                    .addComponent(lblAnsvarigForProjekt))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProjekt)
                .addGap(22, 22, 22)
                .addComponent(lblAnsvarigForProjekt)
                .addGap(7, 7, 7)
                .addComponent(btnUppgifterOmProjekt)
                .addGap(3, 3, 3)
                .addComponent(lblMinaSamarbetspartners)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvdelningensProjekt)
                    .addComponent(tfdFiltreraProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSokSlutdatum)
                    .addComponent(lblSokStartdatum))
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

    private void btnUppgifterOmProjektMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUppgifterOmProjektMouseClicked
        // TODO add your handling code here:
        
       MenyUppgifterOmProjektProjektledare profilFönster = new MenyUppgifterOmProjektProjektledare(idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnUppgifterOmProjektMouseClicked

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
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JLabel lblAnsvarigForProjekt;
    private javax.swing.JLabel lblAvdelningensProjekt;
    private javax.swing.JLabel lblMinaSamarbetspartners;
    private javax.swing.JLabel lblProjekt;
    private javax.swing.JLabel lblSokSlutdatum;
    private javax.swing.JLabel lblSokStartdatum;
    private javax.swing.JTextField tfdFiltreraProjekt;
    // End of variables declaration//GEN-END:variables
}
