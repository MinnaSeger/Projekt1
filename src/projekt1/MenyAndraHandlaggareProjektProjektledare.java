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
public class MenyAndraHandlaggareProjektProjektledare extends javax.swing.JFrame {
        private InfDB idb;
        private String dbAid;

    /**
     * Creates new form MenyAndraHandlaggareProjektProjektledare
     */
    public MenyAndraHandlaggareProjektProjektledare(InfDB idb, String dbAid) {
            this.idb = idb; 
            this.dbAid = dbAid;
            initComponents();
            
            
            fyllProjektetshandlaggare();
            fyllAllaHandlaggare();
            
    }
    
    
    public void fyllProjektetshandlaggare() {
        
        try {
            String sqlFraga = "SELECT anstalld.fornamn, anstalld.efternamn " +
                              "FROM anstalld " +
                              "JOIN handlaggare ON anstalld.aid = handlaggare.aid " +
                              "JOIN ans_proj ON anstalld.aid = ans_proj.aid " +
                              "JOIN projekt ON ans_proj.pid = projekt.pid " +
                              "WHERE projektchef = " + dbAid;

            ArrayList<HashMap<String, String>> resultatx = idb.fetchRows(sqlFraga);

            if (resultatx == null || resultatx.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Inga handläggare för projektet hittades.");
                return;
            }

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Handläggare");

            for (HashMap<String, String> rad : resultatx) {
                model.addRow(new Object[]{rad.get("fornamn") + " " + rad.get("efternamn")});
            }

            tblProjektetshandlaggare.setModel(model);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av projektets handläggare: " + e.getMessage());
        }
    }

    // Fyll tabellen med alla handläggare i databasen
    public void fyllAllaHandlaggare() {
        try {
            String sqlFraga = "SELECT fornamn, efternamn FROM anstalld JOIN handlaggare ON anstalld.aid = handlaggare.aid";

            ArrayList<HashMap<String, String>> resultatx = idb.fetchRows(sqlFraga);

            if (resultatx == null || resultatx.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Inga handläggare hittades i databasen.");
                return;
            }

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Handläggare");

            for (HashMap<String, String> rad : resultatx) {
                model.addRow(new Object[]{rad.get("fornamn") + " " + rad.get("efternamn")});
            }

            tblAllaHandlaggare.setModel(model);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av alla handläggare: " + e.getMessage());
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

        tfdAngeHandlaggare = new javax.swing.JTextField();
        btnLaggTillHandlaggare = new javax.swing.JButton();
        tfdTaBortHandlaggare = new javax.swing.JTextField();
        btnTaBortHandlaggare = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProjektetshandlaggare = new javax.swing.JTable();
        lblProjektetsHandlaggare = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllaHandlaggare = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tfdAngeHandlaggare.setText("Ange Handläggare");

        btnLaggTillHandlaggare.setText("Lägg till Handläggare");
        btnLaggTillHandlaggare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaggTillHandlaggareMouseClicked(evt);
            }
        });
        btnLaggTillHandlaggare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillHandlaggareActionPerformed(evt);
            }
        });

        tfdTaBortHandlaggare.setText("Ange Handlaggare");

        btnTaBortHandlaggare.setText("Ta bort Handläggare");
        btnTaBortHandlaggare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaBortHandlaggareMouseClicked(evt);
            }
        });

        tblProjektetshandlaggare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Handlaggare"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProjektetshandlaggare);

        lblProjektetsHandlaggare.setText("Projektets Handläggare :");

        jLabel1.setText("Alla handläggare : ");

        tblAllaHandlaggare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Handläggare"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAllaHandlaggare);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProjektetsHandlaggare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tfdAngeHandlaggare, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(tfdTaBortHandlaggare))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnTaBortHandlaggare, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLaggTillHandlaggare, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblProjektetsHandlaggare))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdAngeHandlaggare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLaggTillHandlaggare))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdTaBortHandlaggare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaBortHandlaggare))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaggTillHandlaggareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillHandlaggareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLaggTillHandlaggareActionPerformed

    private void btnLaggTillHandlaggareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaggTillHandlaggareMouseClicked
        // TODO add your handling code here:
    // Hämta text från fältet
    String handlaggareNamn = tfdAngeHandlaggare.getText().trim();

    if (handlaggareNamn.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Fyll i handläggarens namn.", "Fel", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Hämta AID för den valda handläggaren
        String sqlFraga = "SELECT aid FROM anstalld WHERE CONCAT(fornamn, ' ', efternamn) = '" + handlaggareNamn + "'";
        String handlaggareAID = idb.fetchSingle(sqlFraga);

        if (handlaggareAID == null) {
            JOptionPane.showMessageDialog(null, "Handläggaren hittades inte.", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hämta PID för projektet som projektchefen är ansvarig för (säkerställ att det endast finns ett resultat)
        String sqlProjektFraga = "SELECT pid FROM projekt WHERE projektchef = " + dbAid + " LIMIT 1";
        String projektId = idb.fetchSingle(sqlProjektFraga);

        if (projektId == null) {
            JOptionPane.showMessageDialog(null, "Inget projekt hittades för projektchefen.", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lägg till handläggaren till projektet
        String sqlInsert = "INSERT INTO ans_proj (aid, pid) VALUES (" + handlaggareAID + ", " + projektId + ")";
        idb.insert(sqlInsert);

        JOptionPane.showMessageDialog(null, "Handläggaren har lagts till projektet.");
        fyllProjektetshandlaggare();

    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Fel vid tillägg av handläggare: " + e.getMessage(), "Fel", JOptionPane.ERROR_MESSAGE);
    }

    tfdAngeHandlaggare.setText("");  // Rensa fältet


    }//GEN-LAST:event_btnLaggTillHandlaggareMouseClicked

    private void btnTaBortHandlaggareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaBortHandlaggareMouseClicked
        // TODO add your handling code here:

    // Hämta text från fältet
    String handlaggareNamn = tfdTaBortHandlaggare.getText().trim();

    if (handlaggareNamn.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Fyll i handläggarens namn.", "Fel", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Hämta AID för den valda handläggaren
        String sqlFraga = "SELECT aid FROM anstalld WHERE CONCAT(fornamn, ' ', efternamn) = '" + handlaggareNamn + "'";
        String handlaggareAID = idb.fetchSingle(sqlFraga);

        if (handlaggareAID == null) {
            JOptionPane.showMessageDialog(null, "Handläggaren hittades inte.", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hämta PID för projektet som projektchefen är ansvarig för (säkerställ att det endast finns ett resultat)
        String sqlProjektFraga = "SELECT pid FROM projekt WHERE projektchef = " + dbAid + " LIMIT 1";
        String projektId = idb.fetchSingle(sqlProjektFraga);

        if (projektId == null) {
            JOptionPane.showMessageDialog(null, "Inget projekt hittades för projektchefen.", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ta bort handläggaren från projektet
        String sqlDelete = "DELETE FROM ans_proj WHERE aid = " + handlaggareAID + " AND pid = " + projektId;
        idb.delete(sqlDelete);  // Här raderas posten utan att försöka få ett returvärde

        JOptionPane.showMessageDialog(null, "Handläggaren har tagits bort från projektet.");
        fyllProjektetshandlaggare();  // Uppdatera listan med handläggare i projektet

    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Fel vid borttagning av handläggare: " + e.getMessage(), "Fel", JOptionPane.ERROR_MESSAGE);
    }

    tfdTaBortHandlaggare.setText("");  // Rensa fältet
 
    }//GEN-LAST:event_btnTaBortHandlaggareMouseClicked

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
            java.util.logging.Logger.getLogger(MenyAndraHandlaggareProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAndraHandlaggareProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAndraHandlaggareProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAndraHandlaggareProjektProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyAndraHandlaggareProjektProjektledare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTillHandlaggare;
    private javax.swing.JButton btnTaBortHandlaggare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblProjektetsHandlaggare;
    private javax.swing.JTable tblAllaHandlaggare;
    private javax.swing.JTable tblProjektetshandlaggare;
    private javax.swing.JTextField tfdAngeHandlaggare;
    private javax.swing.JTextField tfdTaBortHandlaggare;
    // End of variables declaration//GEN-END:variables
}
