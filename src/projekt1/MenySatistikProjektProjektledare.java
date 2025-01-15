/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


/**
 *
 * @author elsa
 */
public class MenySatistikProjektProjektledare extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;

    /**
     * Creates new form MenySatistikProjektProjektledare
     */
    public MenySatistikProjektProjektledare(InfDB idb, String dbAid) {
    this.idb=idb; 
    this.dbAid = dbAid;
        initComponents();

         fyllTabeller();

    }
    
        private void fyllTabeller() {
         
        fyllTabellerMedDatumFilter();
        fyllStatistikKostnadPerLand();
        fyllStatistikOverPartners();
        fyllStatistikOverLander();
        fyllProjektetsKostnad();
    }

private void fyllTabellerMedDatumFilter() {
    String startDatum = tfdStartdatum.getText().trim();
    String slutDatum = tfdSlutDatum.getText().trim();

    if (valideraDatumInput(startDatum, slutDatum)) {
        fyllStatistikKostnadPerLand(startDatum, slutDatum);
        fyllStatistikOverPartners(startDatum, slutDatum);
        fyllStatistikOverLander(startDatum, slutDatum);
        fyllProjektetsKostnad(startDatum, slutDatum);
    } else {
        System.out.println("Ogiltiga datum. Kontrollera formatet och försök igen.");
    }
}

// En enkel metod för att validera datumformatet
private boolean valideraDatumInput(String startDatum, String slutDatum) {
    // Enkelt datumvalidering (YYYY-MM-DD)
    return startDatum.matches("\\d{4}-\\d{2}-\\d{2}") && slutDatum.matches("\\d{4}-\\d{2}-\\d{2}");
}

// Överlagring av metoder utan datumparametrar
private void fyllStatistikKostnadPerLand() {
    fyllStatistikKostnadPerLand("", "");
}

private void fyllStatistikOverPartners() {
    fyllStatistikOverPartners("", "");
}

private void fyllStatistikOverLander() {
    fyllStatistikOverLander("", "");
}

private void fyllProjektetsKostnad() {
    fyllProjektetsKostnad("", "");
}

// Metod som tar emot start- och slutdatum som parametrar
private void fyllStatistikKostnadPerLand(String startDatum, String slutDatum) {
    try {
        String sqlFraga = "SELECT DISTINCT land, SUM(kostnad) AS TotalKostnad " +
                          "FROM projekt WHERE startdatum >= '" + startDatum + "' " +
                          "AND slutdatum <= '" + slutDatum + "' GROUP BY land";
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        DefaultTableModel model = (DefaultTableModel) tblStatistikKostnadPerLand.getModel();
        model.setRowCount(0); // Rensa tabellen

        for (HashMap<String, String> rad : resultat) {
            model.addRow(new Object[]{rad.get("land"), rad.get("TotalKostnad")});
        }
    } catch (InfException e) {
        System.out.println("Fel vid hämtning av kostnad per land: " + e.getMessage());
    }
}

private void fyllStatistikOverPartners(String startDatum, String slutDatum) {
    try {
        String sqlFraga = "SELECT DISTINCT partner.namn " +
                          "FROM partner " +
                          "JOIN projekt_partner ON partner_pid = projekt_partner.partner_pid " +
                          "JOIN projekt ON projekt_partner.pid = projekt.pid " +
                          "WHERE projektchef = " + dbAid + " " +
                          "AND startdatum >= '" + startDatum + "' AND slutdatum <= '" + slutDatum + "'";
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        DefaultTableModel model = (DefaultTableModel) tblStatistikOverPartners.getModel();
        model.setRowCount(0); // Rensa tabellen

        for (HashMap<String, String> rad : resultat) {
            model.addRow(new Object[]{rad.get("namn")});
        }
    } catch (InfException e) {
        System.out.println("Fel vid hämtning av projektets partners: " + e.getMessage());
    }
}

private void fyllStatistikOverLander(String startDatum, String slutDatum) {
    try {
        String sqlFraga = "SELECT DISTINCT land FROM projekt " +
                          "WHERE projektchef = " + dbAid + " " +
                          "AND startdatum >= '" + startDatum + "' AND slutdatum <= '" + slutDatum + "'";
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        DefaultTableModel model = (DefaultTableModel) tblStatistikOverLander.getModel();
        model.setRowCount(0); // Rensa tabellen

        for (HashMap<String, String> rad : resultat) {
            model.addRow(new Object[]{rad.get("land")});
        }
    } catch (InfException e) {
        System.out.println("Fel vid hämtning av projektets länder: " + e.getMessage());
    }
}

private void fyllProjektetsKostnad(String startDatum, String slutDatum) {
    try {
        String sqlFraga = "SELECT DISTINCT projektnamn, kostnad FROM projekt " +
                          "WHERE projektchef = " + dbAid + " " +
                          "AND startdatum >= '" + startDatum + "' AND slutdatum <= '" + slutDatum + "'";
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        DefaultTableModel model = (DefaultTableModel) tblVisaProjektetsKostnad.getModel();
        model.setRowCount(0); // Rensa tabellen

        for (HashMap<String, String> rad : resultat) {
            model.addRow(new Object[]{rad.get("projektnamn"), rad.get("kostnad")});
        }
    } catch (InfException e) {
        System.out.println("Fel vid hämtning av projektets kostnad: " + e.getMessage());
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

        lblStatistikKostnadPerLand = new javax.swing.JLabel();
        lblStatistikpartners = new javax.swing.JLabel();
        lblStatistiklander = new javax.swing.JLabel();
        lblProjektetskostnad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatistikKostnadPerLand = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVisaProjektetsKostnad = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStatistikOverLander = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblStatistikOverPartners = new javax.swing.JTable();
        lblValjDatum = new javax.swing.JLabel();
        tfdStartdatum = new javax.swing.JTextField();
        tfdSlutDatum = new javax.swing.JTextField();
        btnFiltreraDatum = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblStatistikKostnadPerLand.setText("Statistik Kostand per land ");

        lblStatistikpartners.setText("Statistik över partners ");

        lblStatistiklander.setText("Statistik över länder");

        lblProjektetskostnad.setText("Statistik över projektens kostnader");

        tblStatistikKostnadPerLand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Land", "Total Kostnad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStatistikKostnadPerLand);

        tblVisaProjektetsKostnad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Projekt", "Kostnad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVisaProjektetsKostnad);

        tblStatistikOverLander.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Länder"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblStatistikOverLander);

        tblStatistikOverPartners.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Partners"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblStatistikOverPartners);

        lblValjDatum.setText("Välj datum");

        tfdStartdatum.setText("Ange start datum");

        tfdSlutDatum.setText("Ange slut datum");

        btnFiltreraDatum.setText("Filtrera datum");
        btnFiltreraDatum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltreraDatumMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblStatistikpartners, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblStatistikKostnadPerLand, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblStatistiklander, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblProjektetskostnad, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(tfdStartdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(tfdSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)
                                    .addComponent(btnFiltreraDatum)))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(lblValjDatum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblValjDatum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdStartdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltreraDatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblStatistikpartners)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatistikKostnadPerLand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatistiklander)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProjektetskostnad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltreraDatumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltreraDatumMouseClicked
        // TODO add your handling code here:
            // Hämta datum från textfälten
    String startDatum = tfdStartdatum.getText().trim();
    String slutDatum = tfdSlutDatum.getText().trim();
    
    // Kontrollera om datumen är giltiga
    if (valideraDatumInput(startDatum, slutDatum)) {
        // Om datumen är giltiga, hämta och visa filtrerad statistik
        fyllStatistikKostnadPerLand(startDatum, slutDatum);
        fyllStatistikOverPartners(startDatum, slutDatum);
        fyllStatistikOverLander(startDatum, slutDatum);
        fyllProjektetsKostnad(startDatum, slutDatum);
    } else {
        // Visa ett felmeddelande om datumen inte är giltiga
        JOptionPane.showMessageDialog(null, "Ogiltiga datum. Kontrollera formatet och försök igen.", "Fel", JOptionPane.ERROR_MESSAGE);
    }                                           

        
    }//GEN-LAST:event_btnFiltreraDatumMouseClicked

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
            java.util.logging.Logger.getLogger(MenySatistikProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenySatistikProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenySatistikProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenySatistikProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenySatistikProjektProjektledare().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltreraDatum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblProjektetskostnad;
    private javax.swing.JLabel lblStatistikKostnadPerLand;
    private javax.swing.JLabel lblStatistiklander;
    private javax.swing.JLabel lblStatistikpartners;
    private javax.swing.JLabel lblValjDatum;
    private javax.swing.JTable tblStatistikKostnadPerLand;
    private javax.swing.JTable tblStatistikOverLander;
    private javax.swing.JTable tblStatistikOverPartners;
    private javax.swing.JTable tblVisaProjektetsKostnad;
    private javax.swing.JTextField tfdSlutDatum;
    private javax.swing.JTextField tfdStartdatum;
    // End of variables declaration//GEN-END:variables
}
