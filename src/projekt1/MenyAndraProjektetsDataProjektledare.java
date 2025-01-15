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
public class MenyAndraProjektetsDataProjektledare extends javax.swing.JFrame {
        private InfDB idb;
        private String dbAid;

    /**
     * Creates new form MenyAndraProjektetsDataProjektledare
     */
    public MenyAndraProjektetsDataProjektledare(InfDB idb, String dbAid) {
            this.idb = idb; 
            this.dbAid = dbAid;
            initComponents();
            
            fyllProjektledarensProjektComboBox();
            
            fyllProjektetsTabell();
        

        
    }
    
    // Fyller ComboBox med projektnamn för projekt som tillhör projektchefen
    public void fyllProjektledarensProjektComboBox() {
        try {
            String sqlFraga = "SELECT projektnamn FROM projekt WHERE projektchef = " + dbAid;
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);
            
            // Tömmer gamla värden i ComboBox
            ProjektledarensProjekt.removeAllItems();
            
            // Lägg till projektnamn i ComboBox
            if (resultat != null && !resultat.isEmpty()) {
                for (HashMap<String, String> rad : resultat) {
                    ProjektledarensProjekt.addItem(rad.get("projektnamn"));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Inga projekt hittades för projektledaren.");
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av projektlistan: " + e.getMessage());
        }
    }

    // Fyller tabellen med projektdata för projektchefen
    public void fyllProjektetsTabell() {
        try {
            String sqlFraga = "SELECT DISTINCT projektnamn, beskrivning, status, prioritet, startdatum, slutdatum, kostnad " +
                    "FROM projekt WHERE projektchef = " + dbAid;
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);
            
            if (resultat == null || resultat.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingen data om projekt hittades!");
                return;
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
                model.addRow(new Object[] { rad.get("projektnamn"), rad.get("beskrivning"), rad.get("startdatum"),
                        rad.get("slutdatum"), rad.get("kostnad"), rad.get("status"), rad.get("prioritet") });
            }
            
            tblProjektetsData.setModel(model);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av projektets data: " + e.getMessage());
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

        lblProjektetsData = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProjektetsData = new javax.swing.JTable();
        btnSparaAndringar = new javax.swing.JButton();
        tfdNyttProjektnamn = new javax.swing.JTextField();
        tfdAngeNyBeskrivning = new javax.swing.JTextField();
        tfdAngeNyStatus = new javax.swing.JTextField();
        tfdAngeNyPrioritet = new javax.swing.JTextField();
        tfdNyttStartDatum = new javax.swing.JTextField();
        tfdNyttSlutDatum = new javax.swing.JTextField();
        tfdAngeNyKostnad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ProjektledarensProjekt = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProjektetsData.setText("Dina Projekts data:");

        tblProjektetsData.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProjektetsData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProjektetsDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProjektetsData);

        btnSparaAndringar.setText("Spara ny data");
        btnSparaAndringar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSparaAndringarMouseClicked(evt);
            }
        });

        tfdNyttProjektnamn.setText("Ange nytt Projektnamn");

        tfdAngeNyBeskrivning.setText("Ange ny beskrivning");
        tfdAngeNyBeskrivning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdAngeNyBeskrivningActionPerformed(evt);
            }
        });

        tfdAngeNyStatus.setText("Ange ny status");

        tfdAngeNyPrioritet.setText("Ange ny prioritet");

        tfdNyttStartDatum.setText("Ange nytt Start datum");

        tfdNyttSlutDatum.setText("Ange nytt Slut datum");

        tfdAngeNyKostnad.setText("Ange ny kostnad");

        jLabel1.setText("Välj Projekt att ändra: ");

        ProjektledarensProjekt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProjektledarensProjekt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfdAngeNyPrioritet)
                    .addComponent(tfdAngeNyStatus)
                    .addComponent(tfdAngeNyBeskrivning)
                    .addComponent(tfdNyttProjektnamn, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(tfdNyttStartDatum, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdNyttSlutDatum, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdAngeNyKostnad, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSparaAndringar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProjektetsData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblProjektetsData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdNyttProjektnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProjektledarensProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdAngeNyBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tfdAngeNyStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfdAngeNyPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(tfdNyttStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfdNyttSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfdAngeNyKostnad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSparaAndringar)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSparaAndringarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSparaAndringarMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_btnSparaAndringarMouseClicked

    private void tfdAngeNyBeskrivningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdAngeNyBeskrivningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdAngeNyBeskrivningActionPerformed
    // TODO add your handling code here:

    private void tblProjektetsDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProjektetsDataMouseClicked
        // TODO add your handling code here:

        int rad = tblProjektetsData.getSelectedRow();
        if (rad != -1) {
            String projektnamn = (String) tblProjektetsData.getValueAt(rad, 0);
            String beskrivning = (String) tblProjektetsData.getValueAt(rad, 1);
            String startdatum = (String) tblProjektetsData.getValueAt(rad, 2);
            String slutdatum = (String) tblProjektetsData.getValueAt(rad, 3);
            String kostnad = (String) tblProjektetsData.getValueAt(rad, 4);
            String status = (String) tblProjektetsData.getValueAt(rad, 5);
            String prioritet = (String) tblProjektetsData.getValueAt(rad, 6);

            tfdNyttProjektnamn.setText(projektnamn);
            tfdAngeNyBeskrivning.setText(beskrivning);
            tfdNyttStartDatum.setText(startdatum);
            tfdNyttSlutDatum.setText(slutdatum);
            tfdAngeNyKostnad.setText(kostnad);
            tfdAngeNyStatus.setText(status);
            tfdAngeNyPrioritet.setText(prioritet);
          }

    }//GEN-LAST:event_tblProjektetsDataMouseClicked

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
            java.util.logging.Logger.getLogger(MenyAndraProjektetsDataProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAndraProjektetsDataProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAndraProjektetsDataProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAndraProjektetsDataProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyAndraProjektetsDataProjektledare().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ProjektledarensProjekt;
    private javax.swing.JButton btnSparaAndringar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProjektetsData;
    private javax.swing.JTable tblProjektetsData;
    private javax.swing.JTextField tfdAngeNyBeskrivning;
    private javax.swing.JTextField tfdAngeNyKostnad;
    private javax.swing.JTextField tfdAngeNyPrioritet;
    private javax.swing.JTextField tfdAngeNyStatus;
    private javax.swing.JTextField tfdNyttProjektnamn;
    private javax.swing.JTextField tfdNyttSlutDatum;
    private javax.swing.JTextField tfdNyttStartDatum;
    // End of variables declaration//GEN-END:variables
}
