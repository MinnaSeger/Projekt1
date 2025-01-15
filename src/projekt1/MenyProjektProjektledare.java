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
import javax.swing.table.DefaultTableModel;

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
        FyllStatusComboBox();
        
    }
    
    private void FyllILabelAnsvarigForProjekt() {
    try {
        // Hämta alla projekt som tilldelats projektchefen
        String sqlFraga = "SELECT DISTINCT projektnamn FROM projekt WHERE projektchef = " + dbAid;
        ArrayList<HashMap<String, String>> projektLista = idb.fetchRows(sqlFraga);

        // Fyll tabellen med projektnamn
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Rensa tidigare data

        if (projektLista != null && !projektLista.isEmpty()) {
            for (HashMap<String, String> projekt : projektLista) {
                String projektnamn = projekt.get("projektnamn");
                model.addRow(new Object[]{projektnamn});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga projekt tilldelade.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!" + e.getMessage());
    }
}

private void FyllISamarbetspartners() {
    try {
        // Hämta alla partners för projekt där projektchefen är ansvarig
        String sqlFraga = "SELECT DISTINCT partner.namn "
                + "FROM projekt "
                + "INNER JOIN projekt_partner ON projekt.pid = projekt_partner.pid "
                + "INNER JOIN partner ON projekt_partner.partner_pid = partner.pid "
                + "WHERE projekt.projektchef = " + dbAid;

        ArrayList<HashMap<String, String>> partners = idb.fetchRows(sqlFraga);

        // Fyll tabellen med partnernamn
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        if (partners != null && !partners.isEmpty()) {
            for (HashMap<String, String> partner : partners) {
                String partnerName = partner.get("namn");
                model.addRow(new Object[]{partnerName});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga samarbetspartners hittades.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!" + e.getMessage());
    }
}

private void FylliAvdelningensProjekt() {
    try {
        // Hämta alla projekt från avdelningen
        String sqlFraga = "SELECT DISTINCT projekt.projektnamn "
                + "FROM projekt "
                + "INNER JOIN avdelning ON projekt.projektchef = avdelning.chef "
                + "WHERE avdelning.chef = " + dbAid;

        ArrayList<HashMap<String, String>> projektLista = idb.fetchRows(sqlFraga);

        // Fyll tabellen med alla avdelningens projekt
        DefaultTableModel model = (DefaultTableModel) tblAvdelningensProjekt.getModel();
        model.setRowCount(0);

        if (projektLista != null && !projektLista.isEmpty()) {
            for (HashMap<String, String> projekt : projektLista) {
                String projektnamn = projekt.get("projektnamn");
                model.addRow(new Object[]{projektnamn});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga projekt hittades för din avdelning.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av data!" + e.getMessage());
    }
}

    private void FyllStatusComboBox() {
    try {
        String query = "SELECT DISTINCT status FROM projekt";
        ArrayList<String> resultat = idb.fetchColumn(query);

        ComboBoxFiltreraStatus.removeAllItems(); // Töm tidigare alternativ
        ComboBoxFiltreraStatus.addItem("Välj status"); // Lägg till standardval

        if (resultat != null) {
            for (String status : resultat) {
                ComboBoxFiltreraStatus.addItem(status); // Lägg till statusalternativ
            }
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av status: " + e.getMessage());
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
        btnAndraUppgifterOmProjekt = new javax.swing.JButton();
        lblAnsvarigForProjekt = new javax.swing.JLabel();
        lblMinaSamarbetspartners = new javax.swing.JLabel();
        lblAvdelningensProjekt = new javax.swing.JLabel();
        lblSokStartdatum = new javax.swing.JLabel();
        SpinnerStartDatum = new javax.swing.JSpinner();
        lblSokSlutdatum = new javax.swing.JLabel();
        SpinnerSlutDatum = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAvdelningensProjekt = new javax.swing.JTable();
        ComboBoxFiltreraStatus = new javax.swing.JComboBox<>();
        btnFiltreraPaStatus = new javax.swing.JButton();
        btnSokProjektPaDatum = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblProjekt.setText("Mina Projekt");

        btnAndraUppgifterOmProjekt.setText("Ändra uppgifter om projekt");
        btnAndraUppgifterOmProjekt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAndraUppgifterOmProjektMouseClicked(evt);
            }
        });
        btnAndraUppgifterOmProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraUppgifterOmProjektActionPerformed(evt);
            }
        });

        lblAnsvarigForProjekt.setText("Tilldelade projekt: ");

        lblMinaSamarbetspartners.setText("Mina Samarbetspartners:");

        lblAvdelningensProjekt.setText("Avdelningensprojekt:");

        lblSokStartdatum.setText("Sök Startdatum");

        SpinnerStartDatum.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1736254860000L), new java.util.Date(1104534000000L), new java.util.Date(1893452400000L), java.util.Calendar.DAY_OF_MONTH));

        lblSokSlutdatum.setText("Sök Slutdatum");

        SpinnerSlutDatum.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1736254980000L), new java.util.Date(1104534000000L), new java.util.Date(1893452400000L), java.util.Calendar.DAY_OF_MONTH));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Projekt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Partner"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        tblAvdelningensProjekt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Projekt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblAvdelningensProjekt);

        ComboBoxFiltreraStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFiltreraPaStatus.setText("Filtrera Avdelningens projekt på status");
        btnFiltreraPaStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltreraPaStatusMouseClicked(evt);
            }
        });

        btnSokProjektPaDatum.setText("Sök efter avdelningensprojekt på datum ");
        btnSokProjektPaDatum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSokProjektPaDatumMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(lblProjekt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SpinnerStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSokStartdatum))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnsvarigForProjekt)
                            .addComponent(lblMinaSamarbetspartners)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAvdelningensProjekt)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btnAndraUppgifterOmProjekt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(ComboBoxFiltreraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSokSlutdatum)
                                    .addComponent(btnFiltreraPaStatus)
                                    .addComponent(SpinnerSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnSokProjektPaDatum)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblProjekt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAnsvarigForProjekt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAndraUppgifterOmProjekt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMinaSamarbetspartners)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblAvdelningensProjekt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboBoxFiltreraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFiltreraPaStatus)))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSokStartdatum)
                    .addComponent(lblSokSlutdatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpinnerSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpinnerStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnSokProjektPaDatum)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndraUppgifterOmProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraUppgifterOmProjektActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnAndraUppgifterOmProjektActionPerformed

    private void btnAndraUppgifterOmProjektMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAndraUppgifterOmProjektMouseClicked
        // TODO add your handling code here:
        
       MenyAndraUppgifterOmProjektProjektledare profilFönster = new MenyAndraUppgifterOmProjektProjektledare(idb, dbAid);
       profilFönster.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnAndraUppgifterOmProjektMouseClicked

    private void btnFiltreraPaStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltreraPaStatusMouseClicked
        // TODO add your handling code here:
        
    String selectedStatus = ComboBoxFiltreraStatus.getSelectedItem().toString();

    if (selectedStatus.equals("Välj status")) {
        JOptionPane.showMessageDialog(this, "Vänligen välj en status att filtrera på.");
        return;
    }

    try {
        // SQL-fråga för att hämta projekt baserat på vald status
        String sqlFraga = "SELECT projektnamn FROM projekt "
                + "WHERE projektchef = " + dbAid + " "
                + "AND status = '" + selectedStatus + "'";

        ArrayList<HashMap<String, String>> projektLista = idb.fetchRows(sqlFraga);

        // Fyll tabellen med de filtrerade projekten
        DefaultTableModel model = (DefaultTableModel) tblAvdelningensProjekt.getModel();
        model.setRowCount(0); // Rensa tidigare data

        if (projektLista != null && !projektLista.isEmpty()) {
            for (HashMap<String, String> projekt : projektLista) {
                String projektnamn = projekt.get("projektnamn");
                model.addRow(new Object[]{projektnamn});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga projekt hittades för den valda statusen.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid filtrering av projekt!" + e.getMessage());
    }
    }//GEN-LAST:event_btnFiltreraPaStatusMouseClicked

    private void btnSokProjektPaDatumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokProjektPaDatumMouseClicked
        // TODO add your handling code here:
            
// Hämta start- och slutdatum från spinners
    java.util.Date startDatum = (java.util.Date) SpinnerStartDatum.getValue();
    java.util.Date slutDatum = (java.util.Date) SpinnerSlutDatum.getValue();
    
    // Kontrollera om slutdatum är före startdatum
    if (slutDatum.before(startDatum)) {
        JOptionPane.showMessageDialog(this, "Slutdatum kan inte vara före startdatum.");
        return;
    }

    // Konvertera datum till String i SQL-format (yyyy-MM-dd)
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String startDatumStr = sdf.format(startDatum);
    String slutDatumStr = sdf.format(slutDatum);
    
    try {
        // SQL-fråga för att hämta projekt baserat på datumintervall
        String sqlFraga = "SELECT projektnamn FROM projekt "
                + "WHERE projektchef = " + dbAid + " "
                + "AND startdatum >= '" + startDatumStr + "' "
                + "AND slutdatum <= '" + slutDatumStr + "'";

        ArrayList<HashMap<String, String>> projektLista = idb.fetchRows(sqlFraga);

        // Fyll tabellen med de filtrerade projekten
        DefaultTableModel model = (DefaultTableModel) tblAvdelningensProjekt.getModel();
        model.setRowCount(0); // Rensa tidigare data

        if (projektLista != null && !projektLista.isEmpty()) {
            for (HashMap<String, String> projekt : projektLista) {
                String projektnamn = projekt.get("projektnamn");
                model.addRow(new Object[]{projektnamn});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga projekt hittades inom det valda datumintervallet.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av projekt: " + e.getMessage());
        
}
    }//GEN-LAST:event_btnSokProjektPaDatumMouseClicked

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
    private javax.swing.JComboBox<String> ComboBoxFiltreraStatus;
    private javax.swing.JSpinner SpinnerSlutDatum;
    private javax.swing.JSpinner SpinnerStartDatum;
    private javax.swing.JButton btnAndraUppgifterOmProjekt;
    private javax.swing.JButton btnFiltreraPaStatus;
    private javax.swing.JButton btnSokProjektPaDatum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblAnsvarigForProjekt;
    private javax.swing.JLabel lblAvdelningensProjekt;
    private javax.swing.JLabel lblMinaSamarbetspartners;
    private javax.swing.JLabel lblProjekt;
    private javax.swing.JLabel lblSokSlutdatum;
    private javax.swing.JLabel lblSokStartdatum;
    private javax.swing.JTable tblAvdelningensProjekt;
    // End of variables declaration//GEN-END:variables
}
