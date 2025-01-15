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
public class MenyTaBortPartnerAdmin extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    /**
     * Creates new form MenyTaBortPartnerAdmin
     */
    public MenyTaBortPartnerAdmin(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        fyllComboBox();
    }

    //Kod för att kunna välja anställd i rullista
private void fyllComboBox() {
    try {
        String sqlFraga = "SELECT namn from partner";
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        if (resultat != null && !resultat.isEmpty()) {
            jbxPartner.removeAllItems();
            jbxPartner.addItem("");
            for (HashMap<String, String> rad : resultat) {
                String PartnerNamn = rad.get("namn");
                jbxPartner.addItem(PartnerNamn);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga partners hittades i databasen.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av partners: " + e.getMessage());
    
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
        btnBekrafta = new javax.swing.JButton();
        jbxPartner = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Välj partner att ta bort:");

        btnBekrafta.setText("Bekräfta");
        btnBekrafta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBekraftaMouseClicked(evt);
            }
        });

        jbxPartner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBekrafta)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbxPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jbxPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(btnBekrafta)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBekraftaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBekraftaMouseClicked
                                        
    try {
        // Hämta den valda partnerns namn från JComboBox och trimma
        String valdPartner = ((String) jbxPartner.getSelectedItem()).trim();

        if (valdPartner == null || valdPartner.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vänligen välj en partner att ta bort.");
            return;
        }

        // Visa bekräftelsedialog
        int svar = JOptionPane.showConfirmDialog(
                this,
                "Är du säker på att du vill ta bort partner med namn: " + valdPartner + "?",
                "Bekräfta borttagning",
                JOptionPane.YES_NO_OPTION
        );

        if (svar == JOptionPane.NO_OPTION) {
            return;
        }

        // Hämta pid baserat på namn
        String selectPid = "SELECT pid FROM partner WHERE LOWER(namn) = LOWER('" + valdPartner + "')";
        System.out.println("SQL-fråga: " + selectPid); // För felsökning
        String pid = idb.fetchSingle(selectPid);

        if (pid == null) {
            JOptionPane.showMessageDialog(this, "Ingen partner hittades med det namnet.");
            return;
        }

        // Ta bort relaterade rader från projekt_partner
        String deleteProjektPartner = "DELETE FROM projekt_partner WHERE partner_pid = '" + pid + "'";
        idb.delete(deleteProjektPartner);

        // Ta bort partner från partner-tabellen
        String deletePartner = "DELETE FROM partner WHERE pid = '" + pid + "'";
        idb.delete(deletePartner);

        JOptionPane.showMessageDialog(this, "Partner " + valdPartner + " har tagits bort.");
        fyllComboBox();

    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid borttagning av Partner: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(MenyTaBortPartnerAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyTaBortPartnerAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyTaBortPartnerAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyTaBortPartnerAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyTaBortPartnerAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBekrafta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jbxPartner;
    // End of variables declaration//GEN-END:variables
}
