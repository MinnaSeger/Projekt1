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
    
public MenyUppgifterOmProjektProjektledare (InfDB idb, String dbAid){
    
    this.idb=idb; 
    this.dbAid = dbAid;
    initComponents();
    fyllProjektetsTabell();
    fyllprojektetspartners();
    fyllProjektetshandlaggare();
    
    
}

public void fyllProjektetsTabell (){
    try {
        String sqlFraga = "SELECT projektnamn, beskrivning, status, prioritet, startdatum, slutdatum, kostnad " +
                "FROM projekt " +
                "WHERE projektchef IN (" +
                "SELECT aid " +
                "FROM anstalld " +
                "WHERE epost = '" + dbAid + "');";
        
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
            
            String sqlHandlaggare = "SELECT anstalld.fornamn, anstalld.efternamn, handlaggare.ansvarighetsomrade " +
                        "FROM anstalld " +
                        "JOIN handlaggare ON anstalld.aid = handlaggare.aid " +
                        "JOIN ans_proj ON anstalld.aid = ans_proj.aid " +
                        "JOIN projekt ON ans_proj.pid = projekt.pid " +
                        "WHERE projekt.projektchef IN (SELECT aid FROM anstalld WHERE epost = '" + dbAid + "')";
            
            ArrayList<HashMap<String, String>> resultatx = idb.fetchRows(sqlHandlaggare);
            
            if (resultatx == null || resultatx.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Inga handläggare hittades." );
            }
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Handläggare");
            model.addColumn("Ansvarighetsområde");
            
            for (HashMap<String, String> rad : resultatx) {
                model.addRow(new Object[]{rad.get("fornamn"), rad.get("ansvarighetsomrade")});
                
            }
            
            tblProjektetshandlaggare.setModel(model);
            
        } catch (InfException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Fel vid hämtning av handläggare: " + e.getMessage());
            
        }
    }
 public void fyllprojektetspartners () {
        
        try {
            
            String sqlPartner = "SELECT namn, telefon FROM partner " +
             "WHERE pid IN ( " +
             "    SELECT partner_pid FROM projekt_partner " +
             "    WHERE pid IN ( " +
             "        SELECT pid FROM projekt " +
             "        WHERE projektchef IN ( " +
             "            SELECT aid FROM anstalld " +
             "            WHERE epost = '" + dbAid + "' " +
             "        ) " +
             "    ) " +
             ");";
            
            ArrayList<HashMap<String, String>> resultaten = idb.fetchRows(sqlPartner);
            
            if (resultaten == null || resultaten.isEmpty()) {
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Partner");
                model.addColumn("Kontaktinformation");
                tblProjektetspartners.setModel(model);
                javax.swing.JOptionPane.showMessageDialog(this, "Inga partners hittades.");
                return;
            }
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn ("Partner");
            model.addColumn ("Kontaktinformation");
            
            
            for (HashMap<String, String> rad : resultaten) {
                model.addRow(new Object[]{rad.get("namn"), rad.get("telefon")});
            }
            
            tblProjektetspartners.setModel(model);
        } catch (InfException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Fel vid hämtning av partner: " + e.getMessage());
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
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblandraUppgifterOmProjekt.setText("Ändra uppgifter om projekt på avdelning");

        btnAndraProjektetsHandlaggare.setText("Ändra projektets Handläggare");

        btnAndraProjektetsPartners.setText("Ändra projektets Partners");

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

        jButton2.setText("Projektets statistik och kostnad");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(423, 423, 423)
                                .addComponent(lblProjektetspartners))
                            .addComponent(btnUppdateratabeller, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAndraProjektetsPartners, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAndraProjektetsHandlaggare, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(516, 516, 516))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(lblProjektetsHandlaggare))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 514, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblandraUppgifterOmProjekt)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnAndraProjektetsHandlaggare))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAndraProjektetsPartners)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblProjektetsHandlaggare)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProjektetspartners)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnUppdateratabeller))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(391, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

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
    private javax.swing.JButton btnAndraProjektetsHandlaggare;
    private javax.swing.JButton btnAndraProjektetsPartners;
    private javax.swing.JButton btnUppdateratabeller;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
