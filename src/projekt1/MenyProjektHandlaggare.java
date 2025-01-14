package projekt1;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenyProjektHandlaggare extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;

    public MenyProjektHandlaggare(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        fyllTilldeladeProjektTabell();
        fyllAvdelningensProjektTabell();
        fyllProjektPartnersTabell();
        fyllStatusComboBox();
    }

    // 1. Visa projekt där användaren är tilldelad som handläggare
    private void fyllTilldeladeProjektTabell() {
        try {
            String query = "SELECT projekt.projektnamn, projekt.startdatum, projekt.slutdatum, projekt.status " +
                           "FROM projekt " +
                           "JOIN ans_proj ON projekt.pid = ans_proj.pid " +
                           "WHERE ans_proj.aid = " + dbAid;

            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

            DefaultTableModel model = (DefaultTableModel) tblTilldeladeProjekt.getModel();
            model.setRowCount(0);

            if (resultat != null) {
                for (HashMap<String, String> rad : resultat) {
                    model.addRow(new Object[]{
                        rad.get("projektnamn"),
                        rad.get("startdatum"),
                        rad.get("slutdatum"),
                        rad.get("status")
                    });
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av tilldelade projekt: " + e.getMessage());
        }
    }

    // 2. Visa alla projekt på användarens avdelning
    private void fyllAvdelningensProjektTabell() {
        try {
          String query = "SELECT projekt.projektnamn "
                     + "FROM projekt "
                     + "INNER JOIN avdelning ON projekt.projektchef = avdelning.chef "
                     + "WHERE avdelning.chef = " + dbAid;

            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

            DefaultTableModel model = (DefaultTableModel) tblAvdelningensProjekt.getModel();
            model.setRowCount(0);

            if (resultat != null) {
                for (HashMap<String, String> rad : resultat) {
                    model.addRow(new Object[]{
                        rad.get("projektnamn"),
                        rad.get("startdatum"),
                        rad.get("slutdatum"),
                        rad.get("status")
                    });
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av avdelningens projekt: " + e.getMessage());
        }
    }

    // 3. Filtrera avdelningens projekt baserat på status
    private void filtreraAvdelningensProjekt() {
        String valdStatus = (String) cmbStatus.getSelectedItem();
        try {
            String query = "SELECT projektnamn, startdatum, slutdatum, status " +
                           "FROM projekt " +
                           "WHERE avdid = (SELECT avdelning FROM anstalld WHERE aid = " + dbAid + ") " +
                           "AND status = '" + valdStatus + "'";

            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

            DefaultTableModel model = (DefaultTableModel) tblAvdelningensProjekt.getModel();
            model.setRowCount(0);

            if (resultat != null) {
                for (HashMap<String, String> rad : resultat) {
                    model.addRow(new Object[]{
                        rad.get("projektnamn"),
                        rad.get("startdatum"),
                        rad.get("slutdatum"),
                        rad.get("status")
                    });
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid filtrering av avdelningens projekt: " + e.getMessage());
        }
    }

    // 4. Visa alla partners som samarbetar i projekten du är tilldelad på
    private void fyllProjektPartnersTabell() {
        try {
            String query = "SELECT DISTINCT projekt.projektnamn, projekt_partner.partner_pid " +
               "FROM projekt_partner " +
               "JOIN projekt ON projekt_partner.pid = projekt.pid " +
               "WHERE projekt_partner.pid IN (" +
               "  SELECT pid FROM ans_proj WHERE aid = " + dbAid + ")";


            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

            DefaultTableModel model = (DefaultTableModel) tblProjektPartners.getModel();
            model.setRowCount(0);

            if (resultat != null) {
                for (HashMap<String, String> rad : resultat) {
                    model.addRow(new Object[]{
                        rad.get("namn"),
                        rad.get("roll")
                    });
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av projektpartners: " + e.getMessage());
        }
    }

    // 5. Fyll status-väljaren
    private void fyllStatusComboBox() {
        try {
            String query = "SELECT DISTINCT status FROM projekt";
            ArrayList<String> resultat = idb.fetchColumn(query);

            if (resultat != null) {
                cmbStatus.addItem("Välj status");
                for (String status : resultat) {
                    cmbStatus.addItem(status);
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av status: " + e.getMessage());
        }
    }
                  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTilldeladeProjekt = new javax.swing.JLabel();
        lblMinaSamarbetspartners = new javax.swing.JLabel();
        lblAvdelningensprojekt = new javax.swing.JLabel();
        btnFiltreraStatus = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        lblSokStartdatum = new javax.swing.JLabel();
        lblSlutDatum = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTilldeladeProjekt = new javax.swing.JTable();
        cmbStatus = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAvdelningensProjekt = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProjektPartners = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mina Projekt");

        lblTilldeladeProjekt.setText("Mina Tilldelade Projekt");

        lblMinaSamarbetspartners.setText("Mina Samarbetspartners");

        lblAvdelningensprojekt.setText("Avdelningensprojekt");

        btnFiltreraStatus.setText("Filtrera status");
        btnFiltreraStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltreraStatusMouseClicked(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1104534000000L), new java.util.Date(1893452400000L), java.util.Calendar.DAY_OF_MONTH));

        lblSokStartdatum.setText("Sök Startdatum");

        lblSlutDatum.setText("Sök slutdatum");

        jSpinner2.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1104534000000L), new java.util.Date(1893452400000L), java.util.Calendar.DAY_OF_MONTH));

        tblTilldeladeProjekt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTilldeladeProjekt);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblAvdelningensProjekt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblAvdelningensProjekt);

        tblProjektPartners.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblProjektPartners);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(btnFiltreraStatus))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(lblAvdelningensprojekt)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSokStartdatum))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSlutDatum)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMinaSamarbetspartners)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblTilldeladeProjekt))
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(201, 201, 201))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnFiltreraStatus)
                            .addComponent(lblSokStartdatum)
                            .addComponent(lblSlutDatum))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(lblMinaSamarbetspartners, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAvdelningensprojekt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTilldeladeProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(287, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltreraStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltreraStatusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFiltreraStatusMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltreraStatus;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JLabel lblAvdelningensprojekt;
    private javax.swing.JLabel lblMinaSamarbetspartners;
    private javax.swing.JLabel lblSlutDatum;
    private javax.swing.JLabel lblSokStartdatum;
    private javax.swing.JLabel lblTilldeladeProjekt;
    private javax.swing.JTable tblAvdelningensProjekt;
    private javax.swing.JTable tblProjektPartners;
    private javax.swing.JTable tblTilldeladeProjekt;
    // End of variables declaration//GEN-END:variables

}
