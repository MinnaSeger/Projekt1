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
public class MenyAndraUppgifterOmProjektProjektledare extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;

    /**
     * Creates new form MenyUppgifterOmProjektProjektledare
     */
    
public MenyAndraUppgifterOmProjektProjektledare (InfDB idb, String dbAid){
    
    this.idb=idb; 
    this.dbAid = dbAid;
    initComponents();
    fyllProjektetsTabell();
    fyllprojektetspartners();
    fyllProjektetshandlaggare();
    
    
}

public void fyllProjektetsTabell (){
    try {
        String sqlFraga = "SELECT DISTINCT projektnamn, beskrivning, status, prioritet, startdatum, slutdatum, kostnad " +
                "FROM projekt " +
                "WHERE projektchef = " + dbAid;
        
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);
        
        if (resultat == null || resultat.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingen data om projekt hittades!");
        }
        DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Projektnamn");
            model.addColumn("Beskrivning");
            model.addColumn("Startdatum");
            model.addColumn("Slutdatum");
            model.addColumn("Kostnad");
            model.addColumn("Status");
            model.addColumn("Prioritet");
            
            
            for (HashMap<String, String> rad : resultat) {
                model.addRow(new Object[]{rad.get("projektnamn"), rad.get("beskrivning"), rad.get("startdatum"), rad.get("slutdatum"),
                rad.get("kostnad"), rad.get("status"), rad.get("prioritet")});
            }
            
            tblProjektetsTabell.setModel(model);
        } catch (InfException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Fel vid hämtning av projektets data: " + e.getMessage());
        }
    }
    
    public void fyllProjektetshandlaggare () {
        
        try {
            
            String sqlFraga = "SELECT anstalld.fornamn, anstalld.efternamn, handlaggare.ansvarighetsomrade " +
                        "FROM anstalld " +
                        "JOIN handlaggare ON anstalld.aid = handlaggare.aid " +
                        "JOIN ans_proj ON anstalld.aid = ans_proj.aid " +
                        "JOIN projekt ON ans_proj.pid = projekt.pid " +
                        "WHERE projektchef = " + dbAid;
            
            ArrayList<HashMap<String, String>> resultatx = idb.fetchRows(sqlFraga);
            
            if (resultatx == null || resultatx.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Inga handläggare för projektet hittades." );
            }
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Handlaggare");
            model.addColumn("Ansvarighetsomrade");
            
            for (HashMap<String, String> rad : resultatx) {
                model.addRow(new Object[]{rad.get("fornamn"), rad.get("ansvarighetsomrade")});
                
            }
            
            tblProjektetshandlaggare.setModel(model);
            
        } catch (InfException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Fel vid hämtning av projektets handläggare: " + e.getMessage());
            
        }
    }
 public void fyllprojektetspartners () {
        
        try {
            
            String sqlFraga = "SELECT DISTINCT namn, telefon " +
            "FROM partner " +
            "JOIN projekt_partner ON partner_pid = projekt_partner.partner_pid " +
            "JOIN projekt ON projekt_partner.pid = projekt.pid " +
            "WHERE projektchef = " + dbAid;
            
            ArrayList<HashMap<String, String>> resultaten = idb.fetchRows(sqlFraga);
            
            if (resultaten == null || resultaten.isEmpty()) {
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("namn");
                model.addColumn("telefon");
                tblProjektetspartners.setModel(model);
                javax.swing.JOptionPane.showMessageDialog(this, "Inga partners för projektet hittades.");
                return;
            }
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn ("namn");
            model.addColumn ("telefon");
            
            
            for (HashMap<String, String> rad : resultaten) {
                model.addRow(new Object[]{rad.get("namn"), rad.get("telefon")});
            }
            
            tblProjektetspartners.setModel(model);
        } catch (InfException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Fel vid hämtning av partner för projektet: " + e.getMessage());
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

        lblandraUppgifterOmProjekt = new javax.swing.JLabel();
        btnAndraProjektetsHandlaggare = new javax.swing.JButton();
        btnAndraProjektetsPartners = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnUppdateratabeller = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProjektetsTabell = new javax.swing.JTable();
        lblProjektetsHandlaggare = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProjektetshandlaggare = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProjektetspartners = new javax.swing.JTable();
        lblProjektetspartners = new javax.swing.JLabel();
        btnStatistikochKostnadProjekt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblandraUppgifterOmProjekt.setText("Ändra uppgifter om projekt jag är projektansvarig för");

        btnAndraProjektetsHandlaggare.setText("Ändra projektets Handläggare");

        btnAndraProjektetsPartners.setText("Ändra projektets Partners");
        btnAndraProjektetsPartners.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAndraProjektetsPartnersMouseClicked(evt);
            }
        });

        jButton1.setText("Ändra projektets data");

        btnUppdateratabeller.setText("Uppdatera data i tabellerna");
        btnUppdateratabeller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUppdateratabellerMouseClicked(evt);
            }
        });

        jLabel1.setText("Projektets data");

        tblProjektetsTabell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Projektnamn", "Beskrivning", "Status", "Prioritet", "Start datum", "Slut datum", "Kostnad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProjektetsTabell);

        lblProjektetsHandlaggare.setText("Projektets Handläggare");

        tblProjektetshandlaggare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Handläggare", "Ansvarsområde"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProjektetshandlaggare);

        tblProjektetspartners.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Partner", "Telefonnummer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProjektetspartners);

        lblProjektetspartners.setText("Projektets partners");

        btnStatistikochKostnadProjekt.setText("Projektets statistik och kostnad");
        btnStatistikochKostnadProjekt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatistikochKostnadProjektMouseClicked(evt);
            }
        });
        btnStatistikochKostnadProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatistikochKostnadProjektActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(lblandraUppgifterOmProjekt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(lblProjektetspartners)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnStatistikochKostnadProjekt, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(btnAndraProjektetsPartners, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAndraProjektetsHandlaggare, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProjektetsHandlaggare)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(btnUppdateratabeller, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 514, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblandraUppgifterOmProjekt)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAndraProjektetsHandlaggare)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAndraProjektetsPartners)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnStatistikochKostnadProjekt))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(lblProjektetsHandlaggare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProjektetspartners)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnUppdateratabeller)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUppdateratabellerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUppdateratabellerMouseClicked
                                                   
        
        try {
            
            fyllProjektetshandlaggare();
            fyllprojektetspartners();
            fyllProjektetsTabell();
            
            javax.swing.JOptionPane.showMessageDialog(this, "Tabellerna har uppdaterats");
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog (this, "Fel vid uppdatering av tabeller: " + e.getMessage());
        }
        
           // TODO add your handling code here:
    }//GEN-LAST:event_btnUppdateratabellerMouseClicked

    private void btnStatistikochKostnadProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatistikochKostnadProjektActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStatistikochKostnadProjektActionPerformed

    private void btnStatistikochKostnadProjektMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatistikochKostnadProjektMouseClicked
        // TODO add your handling code here:
         MenySatistikProjektProjektledare profilFönster = new MenySatistikProjektProjektledare (idb, dbAid);
         profilFönster.setVisible(true);
         this.setVisible(false);
    }//GEN-LAST:event_btnStatistikochKostnadProjektMouseClicked

    private void btnAndraProjektetsPartnersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAndraProjektetsPartnersMouseClicked
        // TODO add your handling code here:
        MenyAndraPartnersProjektledare profilFönster = new MenyAndraPartnersProjektledare (idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);
        
        
    }//GEN-LAST:event_btnAndraProjektetsPartnersMouseClicked

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
            java.util.logging.Logger.getLogger(MenyAndraUppgifterOmProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAndraUppgifterOmProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAndraUppgifterOmProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAndraUppgifterOmProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyUppgifterOmProjektProjektledare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraProjektetsHandlaggare;
    private javax.swing.JButton btnAndraProjektetsPartners;
    private javax.swing.JButton btnStatistikochKostnadProjekt;
    private javax.swing.JButton btnUppdateratabeller;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblProjektetsHandlaggare;
    private javax.swing.JLabel lblProjektetspartners;
    private javax.swing.JLabel lblandraUppgifterOmProjekt;
    private javax.swing.JTable tblProjektetsTabell;
    private javax.swing.JTable tblProjektetshandlaggare;
    private javax.swing.JTable tblProjektetspartners;
    // End of variables declaration//GEN-END:variables
}
