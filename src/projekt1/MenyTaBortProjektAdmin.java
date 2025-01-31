/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projekt1;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author minna
 */
public class MenyTaBortProjektAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    /**
     * Creates new form MenyTaBortBortProjektAdmin
     */
    public MenyTaBortProjektAdmin(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        fyllComboBox();
    }

    
      //Kod för att kunna välja anställd i rullista
    private void fyllComboBox() {
    try {
        String sqlFraga = "SELECT projektnamn from projekt";
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        if (resultat != null && !resultat.isEmpty()) {
            jbxProjekt.removeAllItems();
            jbxProjekt.addItem("");
            for (HashMap<String, String> rad : resultat) {
                String ProjektNamn = rad.get("projektnamn");
                jbxProjekt.addItem(ProjektNamn);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga projekt hittades i databasen.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av projekt: " + e.getMessage());
    
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

        jLabel1 = new javax.swing.JLabel();
        jbxProjekt = new javax.swing.JComboBox<>();
        btnBekrafta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Välj projekt att ta bort:");

        jbxProjekt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBekrafta.setText("Bekräfta");
        btnBekrafta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBekraftaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jbxProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBekrafta)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbxProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(btnBekrafta)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBekraftaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBekraftaMouseClicked
 try {
        // Hämta den valda partnerns namn från JComboBox och trimma
        String valtProjekt = ((String) jbxProjekt.getSelectedItem()).trim();

        if (valtProjekt == null || valtProjekt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vänligen välj ett projekt att ta bort.");
            return;
        }

        // Visa bekräftelsedialog
        int svar = JOptionPane.showConfirmDialog(
                this,
                "Är du säker på att du vill ta bort projekt: " + valtProjekt + "?",
                "Bekräfta borttagning",
                JOptionPane.YES_NO_OPTION
        );

        if (svar == JOptionPane.NO_OPTION) {
            return;
        }

        // Hämta pid baserat på namn
        String selectPid = "SELECT pid FROM projekt WHERE LOWER(projektnamn) = LOWER('" + valtProjekt + "')";
        System.out.println("SQL-fråga: " + selectPid); // För felsökning
        String pid = idb.fetchSingle(selectPid);

        if (pid == null) {
            JOptionPane.showMessageDialog(this, "Inget projekt hittades med det namnet.");
            return;
        }

        // Ta bort relaterade rader från projekt_partner
        String deleteProjektPartner = "DELETE FROM projekt_partner WHERE pid = '" + pid + "'";
        idb.delete(deleteProjektPartner);

        JOptionPane.showMessageDialog(this, "Projekt " + valtProjekt + " har tagits bort.");
        fyllComboBox();

    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid borttagning av Projekt: " + e.getMessage());
    }
    }//GEN-LAST:event_btnBekraftaMouseClicked

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
            java.util.logging.Logger.getLogger(MenyTaBortProjektAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyTaBortProjektAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyTaBortProjektAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyTaBortProjektAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyTaBortBortProjektAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBekrafta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jbxProjekt;
    // End of variables declaration//GEN-END:variables
}
