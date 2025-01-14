/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author elsa
 */
public class MenyUppgifterOmProjektProjektledare extends javax.swing.JFrame {
      private InfDB idb;
    private String dbAid;

    /**
     * Creates new form MenyUppgifterOmProjektProjektledare
     */
    public MenyUppgifterOmProjektProjektledare(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        
        FylliTextfalt();
        FylliTabeller();
        
    }
    
    private void FylliTextfalt () {
        try { 
            String sqlFraga = "SELECT DISTINCT projektnamn, kostnad, beskrivning, startdatum, slutdatum, status, prioritet, projektchef, land " +
            "FROM projekt " +
            "WHERE projektchef = " + dbAid;
            
            HashMap <String, String> userData = idb.fetchRow(sqlFraga);
            
            if(userData !=null) {
                tfdProjektNamn.setText(userData.get("projektnamn"));
                tfdKostnad.setText(userData.get("kostnad"));
                tfdBeskrivning.setText(userData.get("beskrivning"));
                tfdStartDatum.setText(userData.get("startdatum"));
                tfdSlutDatum.setText(userData.get("slutdatum"));
                tfdStatus.setText(userData.get("status"));
                tfdPrioritet.setText(userData.get("prioritet"));
                tfdLand.setText(userData.get("land"));
                
            }else{ JOptionPane.showMessageDialog(this, "Ingen data om projekt på avdelning hittades!");
            
            }
        }catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!");
            
        }
    }
    
    private void FylliTabeller() {
        
        fyllPartnerTabell();
        fyllHandlaggareTabell();
  
    }
    
    private void fyllPartnerTabell() {
        
        try{
            String sqlFraga = "SELECT DISTINCT partner.namn, projekt.projektnamn, projekt.pid " +
                   "FROM partner " +
                    "JOIN projekt_partner ON partner_pid = projekt_partner.partner_pid " +
                    "JOIN projekt ON projekt.pid = projekt_partner.pid " +
                    "WHERE projektchef = " + dbAid;
            
            ArrayList<HashMap<String, String >> partnerData = idb.fetchRows(sqlFraga);
            
            DefaultTableModel model = (DefaultTableModel) tblPartner.getModel();
            model.setRowCount(0); //Rensar partnertabellen
        
        if(partnerData !=null) {
            for (HashMap <String, String> row:partnerData) {
                model.addRow(new Object [] {
                    row.get("namn"),
                    row.get("projektnamn"),
                    row.get("pid")
});
                }

            }
}catch (InfException e) {
    JOptionPane.showMessageDialog (this, "Fel vid hämtning av data om partner: " + e.getMessage());
            
        }
    }
    
private void fyllHandlaggareTabell() {
try{
String sqlFraga = "SELECT DISTINCT anstalld.fornamn, anstalld.efternamn, anstalld.aid, projekt.projektnamn " +
"FROM anstalld " + 
"JOIN projekt ON anstalld.aid = projekt.projektchef " +
"WHERE projektchef = " + dbAid;

ArrayList<HashMap<String, String >> handlaggareData = idb.fetchRows (sqlFraga);

 DefaultTableModel model = (DefaultTableModel) tblhandlaggare.getModel();
 model.setRowCount(0); //Rensar handlaggareTabellen

 if (handlaggareData !=null) {
 for (HashMap<String, String > row:handlaggareData) {
 model.addRow(new Object []{
 row.get("fornamn"),
 row.get("efternamn"),
 row.get("aid"),
 row.get("projektnamn")

 });
 }
 }
 } catch (InfException e) {
 JOptionPane.showMessageDialog(this, "Fel vid hämtning av data om handläggare: " + e.getMessage());
 }
 }
 
private void laggTillPartner(String partnerNamn, int projektId) {
    try {
        // Kontrollera om partner redan finns
        String kontrollFraga = "SELECT partner_pid FROM partner WHERE namn = '" + partnerNamn + "'";
        String partnerPid = idb.fetchSingle(kontrollFraga);

        if (partnerPid == null) {
            // Om partner inte finns, lägg till ny partner i partner-tabellen
            String insertPartner = "INSERT INTO partner (namn) VALUES ('" + partnerNamn + "')";
            idb.insert(insertPartner);

            // Hämta partner_pid för den nya partnern
            partnerPid = idb.fetchSingle(kontrollFraga);
        }

        // Lägg till kopplingen mellan partner och projekt i projekt_partner-tabellen
        String insertProjektPartner = "INSERT INTO projekt_partner (partner_pid, pid) VALUES (" + partnerPid + ", " + projektId + ")";
        idb.insert(insertProjektPartner);

        // Uppdatera tabellen i GUI
        fyllPartnerTabell();

        JOptionPane.showMessageDialog(this, "Partner har lagts till i projektet!");
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid tillägg av partner: " + e.getMessage());
    }
}

private void taBortPartner(String partnerNamn, int projektId) {
    try {
        // Hämta partner_pid för den angivna partnern
        String kontrollFraga = "SELECT partner_pid FROM partner WHERE namn = '" + partnerNamn + "'";
        String partnerPid = idb.fetchSingle(kontrollFraga);

        if (partnerPid != null) {
            // Ta bort kopplingen mellan partner och projekt
            String deleteProjektPartner = "DELETE FROM projekt_partner WHERE partner_pid = " + partnerPid + " AND pid = " + projektId;
            idb.delete(deleteProjektPartner);

            // Kontrollera om partnern är kopplad till andra projekt
            String kontrollOmPartnerAnvands = "SELECT pid FROM projekt_partner WHERE partner_pid = " + partnerPid;
            String andraProjekt = idb.fetchSingle(kontrollOmPartnerAnvands);

            if (andraProjekt == null) {
                // Om partner inte är kopplad till andra projekt, ta bort partner från partner-tabellen
                String deletePartner = "DELETE FROM partner WHERE partner_pid = " + partnerPid;
                idb.delete(deletePartner);
            }

            // Uppdatera tabellen i GUI
            fyllPartnerTabell();

            JOptionPane.showMessageDialog(this, "Partner har tagits bort från projektet!");
        } else {
            JOptionPane.showMessageDialog(this, "Partner finns inte i projektet.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid borttagning av partner: " + e.getMessage());
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

        lblKostnader = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        tfdKostnad = new javax.swing.JTextField();
        tfdStatus = new javax.swing.JTextField();
        lblandraUppgifterOmProjekt = new javax.swing.JLabel();
        lblProjektNamn = new javax.swing.JLabel();
        lblProjektbeskrivning = new javax.swing.JLabel();
        lblStartDatum = new javax.swing.JLabel();
        lblSlutDatum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblLand = new javax.swing.JLabel();
        tfdProjektNamn = new javax.swing.JTextField();
        tfdBeskrivning = new javax.swing.JTextField();
        tfdStartDatum = new javax.swing.JTextField();
        tfdSlutDatum = new javax.swing.JTextField();
        tfdPrioritet = new javax.swing.JTextField();
        btnSparaAndringar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhandlaggare = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPartner = new javax.swing.JTable();
        tfdLand = new javax.swing.JTextField();
        tfdlaggtillpartner = new javax.swing.JTextField();
        tfdtabortpartner = new javax.swing.JTextField();
        tfdlaggtillhandlaggare = new javax.swing.JTextField();
        tfdtaborthandläggare = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblKostnader.setText("Kostnader");

        lblStatus.setText("Status");

        tfdKostnad.setText("Kostnader");
        tfdKostnad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdKostnadActionPerformed(evt);
            }
        });

        tfdStatus.setText("Status");
        tfdStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdStatusActionPerformed(evt);
            }
        });

        lblandraUppgifterOmProjekt.setText("Ändra uppgifter om projekt på avdelning");

        lblProjektNamn.setText("Projekt namn");

        lblProjektbeskrivning.setText("Beskrivning");

        lblStartDatum.setText("Start datum");

        lblSlutDatum.setText("Slut datum");

        jLabel1.setText("Prioritet");

        lblLand.setText("Land");

        tfdProjektNamn.setText("projektnamn");

        tfdBeskrivning.setText("Beskrivning");

        tfdStartDatum.setText("Start datum");

        tfdSlutDatum.setText("Slut datum");

        tfdPrioritet.setText("Prioritet");

        btnSparaAndringar.setText("Spara ändringar");
        btnSparaAndringar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSparaAndringarMouseClicked(evt);
            }
        });
        btnSparaAndringar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaAndringarActionPerformed(evt);
            }
        });

        tblhandlaggare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Förnamn", "Efternamn", "Aid", "Projekt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblhandlaggare);

        tblPartner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Partnernamn", "Projekt", "Pid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPartner);

        tfdLand.setText("Land");

        tfdlaggtillpartner.setText("Lägg till partner");

        tfdtabortpartner.setText("Ta bort partner");

        tfdlaggtillhandlaggare.setText("Lägg till handläggare");

        tfdtaborthandläggare.setText("Ta bort handläggare");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblLand)
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdStartDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(tfdSlutDatum)
                            .addComponent(tfdPrioritet, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfdLand, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfdlaggtillpartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnSparaAndringar)
                                .addComponent(lblandraUppgifterOmProjekt)))
                        .addGap(100, 100, 100)
                        .addComponent(tfdtabortpartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfdKostnad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 347, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblKostnader, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblStartDatum)
                            .addComponent(lblSlutDatum, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfdStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProjektNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(tfdProjektNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProjektbeskrivning)
                        .addGap(59, 59, 59)
                        .addComponent(tfdBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118)
                .addComponent(tfdlaggtillhandlaggare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(tfdtaborthandläggare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblProjektNamn)
                                .addComponent(tfdlaggtillpartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfdtabortpartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblandraUppgifterOmProjekt)
                                .addGap(87, 87, 87)
                                .addComponent(tfdProjektNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdKostnad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKostnader))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProjektbeskrivning))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStartDatum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSlutDatum))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfdStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdlaggtillhandlaggare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdtaborthandläggare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLand)
                            .addComponent(tfdLand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(btnSparaAndringar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdKostnadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdKostnadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdKostnadActionPerformed

    private void tfdStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdStatusActionPerformed

    private void btnSparaAndringarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaAndringarActionPerformed
        // TODO add your handling code here

        FylliTextfalt(); // Uppdatera fält
        FylliTabeller(); // Uppdatera tabeller
    
    }//GEN-LAST:event_btnSparaAndringarActionPerformed

    private void btnSparaAndringarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSparaAndringarMouseClicked
        // TODO add your handling code here:
        
        String nyttProjektnamn = tfdProjektNamn.getText();
        String nyttKostnad = tfdKostnad.getText();
        String nyttBeskrivning = tfdBeskrivning.getText();
        String nyttStartDatum = tfdStartDatum.getText();
        String nyttSlutDatum = tfdSlutDatum.getText();
        String nyttStatus = tfdStatus.getText();
        String nyttPrioritet = tfdPrioritet.getText();
        String nyttLand = tfdLand.getText();
        
        //Uppdetara ändringar i databasen
        
        try {
            //Byta ändringar
            String updatesqlFraga = "UPDATE projekt SET " +  
                    "projektnamn = '" + nyttProjektnamn + "', " + 
                    "kostnad = '" + nyttKostnad + "'," +
                    "beskrivning = '" + nyttBeskrivning + "', " + 
                    "startdatum = '" + nyttStartDatum + "', " + 
                    "slutdatum = '" + nyttSlutDatum + "', " + 
                    "status ='" + nyttStatus + "'," +
                    "prioritet = '" + nyttPrioritet + "'," +
                    "land = '" + nyttLand + "'" +
                    "WHERE projektchef = " + dbAid;
           
            System.out.println(updatesqlFraga);
            // Kör uppdateringen
            idb.update(updatesqlFraga);
            
            //Visa bekräftelse av ändringar
            JOptionPane.showMessageDialog(this, "Projektets Ändringar Är Sparade!");
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
            java.util.logging.Logger.getLogger(MenyUppgifterOmProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyUppgifterOmProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyUppgifterOmProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyUppgifterOmProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyUppgifterOmProjektProjektledare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSparaAndringar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblKostnader;
    private javax.swing.JLabel lblLand;
    private javax.swing.JLabel lblProjektNamn;
    private javax.swing.JLabel lblProjektbeskrivning;
    private javax.swing.JLabel lblSlutDatum;
    private javax.swing.JLabel lblStartDatum;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblandraUppgifterOmProjekt;
    private javax.swing.JTable tblPartner;
    private javax.swing.JTable tblhandlaggare;
    private javax.swing.JTextField tfdBeskrivning;
    private javax.swing.JTextField tfdKostnad;
    private javax.swing.JTextField tfdLand;
    private javax.swing.JTextField tfdPrioritet;
    private javax.swing.JTextField tfdProjektNamn;
    private javax.swing.JTextField tfdSlutDatum;
    private javax.swing.JTextField tfdStartDatum;
    private javax.swing.JTextField tfdStatus;
    private javax.swing.JTextField tfdlaggtillhandlaggare;
    private javax.swing.JTextField tfdlaggtillpartner;
    private javax.swing.JTextField tfdtaborthandläggare;
    private javax.swing.JTextField tfdtabortpartner;
    // End of variables declaration//GEN-END:variables
}
