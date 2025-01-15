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
public class MenyAndraPartnersProjektledare extends javax.swing.JFrame {
     private InfDB idb;
     private String dbAid;

    /**
     * Creates new form MenyAndraPartnersProjektledare
     */
    public MenyAndraPartnersProjektledare(InfDB idb, String dbAid) {
         this.idb=idb; 
         this.dbAid = dbAid;
        initComponents();
        
        visaPartnersITabell();
        
        
    }
    
       // Visa alla projekt och partners
    private void visaPartnersITabell() {
    try {
        // Hämta projektets partners
        String sqlProjektPartners =  "SELECT DISTINCT partner.namn "
                + "FROM projekt "
                + "INNER JOIN projekt_partner ON projekt.pid = projekt_partner.pid "
                + "INNER JOIN partner ON projekt_partner.partner_pid = partner.pid "
                + "WHERE projekt.projektchef = " + dbAid;
        
        ArrayList<HashMap<String, String>> projektPartners = idb.fetchRows(sqlProjektPartners);

        // Hämta alla partners
        String sqlAllaPartners = "SELECT namn FROM partner";
        ArrayList<HashMap<String, String>> allaPartners = idb.fetchRows(sqlAllaPartners);

        // Fyll tabellen tblProjektetsPartners
        DefaultTableModel modelProjektPartners = (DefaultTableModel) tblPartners.getModel();
        modelProjektPartners.setRowCount(0); // Töm tabellen
        if (projektPartners != null) {
            for (HashMap<String, String> row : projektPartners) {
                modelProjektPartners.addRow(new Object[]{row.get("namn")});
            }
        }

        // Fyll tabellen tblListaPartner med partners som inte redan är kopplade till projektet
        DefaultTableModel modelAllaPartners = (DefaultTableModel) tblPartnerLista.getModel();
        modelAllaPartners.setRowCount(0); // Töm tabellen
        if (allaPartners != null) {
            for (HashMap<String, String> row : allaPartners) {
                String partnerNamn = row.get("namn");

                boolean redanKopplad = false;
                if (projektPartners != null) {
                    for (HashMap<String, String> projektRow : projektPartners) {
                        if (projektRow.get("namn").equals(partnerNamn)) {
                            redanKopplad = true;
                            break;
                        }
                    }
                }

                if (!redanKopplad) {
                    modelAllaPartners.addRow(new Object[]{partnerNamn});
                }
            }
        }

    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Fel vid hämtning av data: " + e.getMessage(), "Fel", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartners = new javax.swing.JTable();
        lblProjektetsPartners = new javax.swing.JLabel();
        tfdLaggTillPartner = new javax.swing.JTextField();
        btnLaggTillPartner = new javax.swing.JButton();
        tfdTaBortPartner = new javax.swing.JTextField();
        btnTaBortPartner = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPartnerLista = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPartners.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPartners);

        lblProjektetsPartners.setText("Projektets partners: ");

        tfdLaggTillPartner.setText("Ange partner");

        btnLaggTillPartner.setText("Lägg till partner");
        btnLaggTillPartner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaggTillPartnerMouseClicked(evt);
            }
        });

        tfdTaBortPartner.setText("Ange partner");

        btnTaBortPartner.setText("Ta bort partner");
        btnTaBortPartner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaBortPartnerMouseClicked(evt);
            }
        });

        jLabel1.setText("Partner lista");

        tblPartnerLista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPartnerLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblProjektetsPartners, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfdTaBortPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdLaggTillPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLaggTillPartner)
                    .addComponent(btnTaBortPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblProjektetsPartners))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdLaggTillPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLaggTillPartner))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdTaBortPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaBortPartner))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaggTillPartnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaggTillPartnerMouseClicked
        // TODO add your handling code here:
    try {
        String partnerNamn = tfdLaggTillPartner.getText().trim();

        if (partnerNamn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ange ett partnernamn!", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kontrollera om partnern finns i databasen
        String sqlHittaPartner = "SELECT namn FROM partner WHERE namn = '" + partnerNamn + "'";
        String hittadPartner = idb.fetchSingle(sqlHittaPartner);

        if (hittadPartner == null) {
            JOptionPane.showMessageDialog(this, "Partnern \"" + partnerNamn + "\" finns inte i databasen.");
            return;
        }

        // Hämta projektets PID
        String sqlHittaProjektPID = "SELECT pid FROM projekt WHERE projektchef = " + dbAid;
        String projektPID = idb.fetchSingle(sqlHittaProjektPID);

        if (projektPID == null) {
            JOptionPane.showMessageDialog(this, "Inget projekt hittades för projektchefen.", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kontrollera om partnern redan är kopplad till projektet
        String sqlKontrolleraKoppling = "SELECT partner_pid FROM projekt_partner " +
                "INNER JOIN partner ON projekt_partner.partner_pid = partner.pid " +
                "WHERE partner.namn = '" + partnerNamn + "' AND projekt_partner.pid = '" + projektPID + "'";
        String redanKopplad = idb.fetchSingle(sqlKontrolleraKoppling);

        if (redanKopplad != null) {
            JOptionPane.showMessageDialog(this, "Partnern \"" + partnerNamn + "\" är redan kopplad till projektet.");
            return;
        }

        // Lägg till kopplingen
        String sqlLaggTillKoppling = "INSERT INTO projekt_partner (partner_pid, pid) " +
                "SELECT pid, '" + projektPID + "' FROM partner WHERE namn = '" + partnerNamn + "'";
        idb.insert(sqlLaggTillKoppling);

        JOptionPane.showMessageDialog(this, "Partnern \"" + partnerNamn + "\" har lagts till i projektet.");

        visaPartnersITabell();
        tfdLaggTillPartner.setText("");

    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid lägg till: " + e.getMessage(), "Fel", JOptionPane.ERROR_MESSAGE);
    }

    
    }//GEN-LAST:event_btnLaggTillPartnerMouseClicked

    private void btnTaBortPartnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaBortPartnerMouseClicked
        // TODO add your handling code here:
        
        //Kod för att ta bort partner från projektet
     
    try {
        String partnerNamn = tfdTaBortPartner.getText().trim();

        if (partnerNamn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ange ett partnernamn!", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kontrollera om partnern finns i projektet
        String sqlHittaProjektPID = "SELECT pid FROM projekt WHERE projektchef = " + dbAid;
        String projektPID = idb.fetchSingle(sqlHittaProjektPID);

        if (projektPID == null) {
            JOptionPane.showMessageDialog(this, "Inget projekt hittades för projektchefen.", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sqlKontrolleraKoppling = "SELECT partner_pid FROM projekt_partner " +
                "INNER JOIN partner ON projekt_partner.partner_pid = partner.pid " +
                "WHERE partner.namn = '" + partnerNamn + "' AND projekt_partner.pid = '" + projektPID + "'";
        String redanKopplad = idb.fetchSingle(sqlKontrolleraKoppling);

        if (redanKopplad == null) {
            JOptionPane.showMessageDialog(this, "Partnern \"" + partnerNamn + "\" är inte kopplad till projektet.");
            return;
        }

        // Ta bort kopplingen
        String sqlTaBortKoppling = "DELETE FROM projekt_partner " +
                "WHERE partner_pid = (SELECT pid FROM partner WHERE namn = '" + partnerNamn + "') " +
                "AND pid = '" + projektPID + "'";
        idb.delete(sqlTaBortKoppling);

        JOptionPane.showMessageDialog(this, "Partnern \"" + partnerNamn + "\" har tagits bort från projektet.");

        visaPartnersITabell();
        tfdTaBortPartner.setText("");

    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid borttagning: " + e.getMessage(), "Fel", JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_btnTaBortPartnerMouseClicked

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
            java.util.logging.Logger.getLogger(MenyAndraPartnersProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAndraPartnersProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAndraPartnersProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAndraPartnersProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyAndraPartnersProjektledare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTillPartner;
    private javax.swing.JButton btnTaBortPartner;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblProjektetsPartners;
    private javax.swing.JTable tblPartnerLista;
    private javax.swing.JTable tblPartners;
    private javax.swing.JTextField tfdLaggTillPartner;
    private javax.swing.JTextField tfdTaBortPartner;
    // End of variables declaration//GEN-END:variables
}
