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
public class MenyTaBortAnstalld extends javax.swing.JFrame {
    private InfDB idb;
    private String dbAid;
    
    


    /**
     * Creates new form MenyTaBortAnstalld
     */
    public MenyTaBortAnstalld(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        fyllComboBox();
    }
    //Kod för att kunna välja anställd i rullista
private void fyllComboBox() {
    try {
        String sqlFraga = "SELECT fornamn, efternamn FROM anstalld "+"order by fornamn";
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        if (resultat != null && !resultat.isEmpty()) {
            jbxAnstalld.removeAllItems();
            jbxAnstalld.addItem("");
            for (HashMap<String, String> rad : resultat) {
                String fullName = rad.get("fornamn") + " " + rad.get("efternamn");
                jbxAnstalld.addItem(fullName);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga anställda hittades i databasen.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av anställda: " + e.getMessage());
    
}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBekrafta = new javax.swing.JButton();
        jbxAnstalld = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Välj anställd att ta bort:");

        btnBekrafta.setText("Bekräfta");
        btnBekrafta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBekraftaMouseClicked(evt);
            }
        });

        jbxAnstalld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBekrafta)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbxAnstalld, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jbxAnstalld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(btnBekrafta)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBekraftaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBekraftaMouseClicked
                                      
    try {
        // Hämta den valda anställdas namn från JComboBox och trimma
        String valdAnstalld = ((String) jbxAnstalld.getSelectedItem()).trim();

        if (valdAnstalld == null || valdAnstalld.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vänligen välj en anställd att ta bort.");
            return;
        }

        // Visa bekräftelsedialog
        int svar = JOptionPane.showConfirmDialog(
                this,
                "Är du säker på att du vill ta bort anställd: " + valdAnstalld + "?",
                "Bekräfta borttagning",
                JOptionPane.YES_NO_OPTION
        );

        if (svar == JOptionPane.NO_OPTION) {
            return;
        }

        // Dela upp förnamn och efternamn (hantera flera delar i efternamn)
        String[] namnDelar = valdAnstalld.split(" ", 2); // Dela namnet i högst två delar
        String fornamn = namnDelar[0];
        String efternamn = namnDelar.length > 1 ? namnDelar[1] : "";

        // Hämta aid baserat på namn (skiftlägesokänslig SQL-sökning)
        String selectAid = "SELECT aid FROM anstalld WHERE LOWER(fornamn) = LOWER('" + fornamn + "') AND LOWER(efternamn) = LOWER('" + efternamn + "')";
        System.out.println("SQL-fråga: " + selectAid); // För felsökning
        String aid = idb.fetchSingle(selectAid);

        // Kontrollera om den anställda är mentor
        String mentorCheckQuery = "SELECT COUNT(*) FROM handlaggare WHERE mentor = '" + aid + "'";
        String mentorCount = idb.fetchSingle(mentorCheckQuery);

        if (mentorCount != null && !mentorCount.equals("0")) {
        JOptionPane.showMessageDialog(this, "Denna handläggare är mentor för andra. Uppdatera deras mentor innan du tar bort.");
        return;
        }

        // Kontrollera om anställd är admin
        String selectAdmin = "SELECT behorighetsniva FROM admin WHERE aid = '" + aid + "'";
        String behörighetsnivå = idb.fetchSingle(selectAdmin);

        if (behörighetsnivå != null) {
            String deleteAdmin = "DELETE FROM admin WHERE aid = '" + aid + "'";
            idb.delete(deleteAdmin);
        } else {
            String deleteHandlaggare = "DELETE FROM handlaggare WHERE aid = '" + aid + "'";
            idb.delete(deleteHandlaggare);
        }

        // Ta bort från anställd
        String deleteAnstalld = "DELETE FROM anstalld WHERE aid = '" + aid + "'";
        idb.delete(deleteAnstalld);

        JOptionPane.showMessageDialog(this, "Anställd " + valdAnstalld + " har tagits bort.");
        fyllComboBox();

    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid borttagning av anställd: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(MenyTaBortAnstalld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyTaBortAnstalld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyTaBortAnstalld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyTaBortAnstalld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyTaBortAnstalld().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBekrafta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jbxAnstalld;
    // End of variables declaration//GEN-END:variables
}
