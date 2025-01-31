package projekt1;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MenyAnstalldaHandlaggare extends javax.swing.JFrame {
    private InfDB idb; 
    private String dbAid;

    public MenyAnstalldaHandlaggare(InfDB idb, String dbAid) {
        this.idb = idb; 
        this.dbAid = dbAid;
        initComponents();
        fyllAnstalldaLista1(); // Fyll listan vid start
    }

    // 1. Visa alla anställda på avdelningen
    private void fyllAnstalldaLista1() {

    try {
        // SQL-fråga för att hämta förnamn, efternamn och e-post
        String SQLfraga = "SELECT fornamn, efternamn, epost "
                        + "FROM anstalld "
                        + "WHERE avdelning = (SELECT avdelning FROM anstalld WHERE aid = '" + dbAid + "')";
        
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(SQLfraga);

        DefaultListModel<String> model = new DefaultListModel<>();
        LstAvdelningenspersonal.setModel(model); // Rensa listan

        if (resultat != null) {
            for (HashMap<String, String> rad : resultat) {
                // Hämta värden från varje rad
                String fornamn = rad.get("fornamn");
                String efternamn = rad.get("efternamn");
                String epost = rad.get("epost");

                // Kontrollera att inga fält är null
                if (fornamn == null) fornamn = "";
                if (efternamn == null) efternamn = "";
                if (epost == null) epost = "";

                // Kombinera förnamn, efternamn och e-post
                String namnOchEpost = fornamn + " " + efternamn + " - " + epost;
                model.addElement(namnOchEpost); // Lägg till i listan
            }
        } else {
            model.addElement("Inga anställda hittades.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid hämtning av anställda: " + e.getMessage());
    }
}
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnstallda = new javax.swing.JLabel();
        lblAvdelningenspersonal = new javax.swing.JLabel();
        tfdsokAnstalld = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        LstAvdelningenspersonal = new javax.swing.JList<>();
        btnSok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAnstallda.setText("Anställda");

        lblAvdelningenspersonal.setText("Min Avdelning Personal");

        tfdsokAnstalld.setText("Sök på anställd");
        tfdsokAnstalld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdsokAnstalldActionPerformed(evt);
            }
        });

        LstAvdelningenspersonal.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        LstAvdelningenspersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LstAvdelningenspersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(LstAvdelningenspersonal);

        btnSok.setText("Sök");
        btnSok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSokMouseClicked(evt);
            }
        });
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnstallda, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSok)
                            .addComponent(tfdsokAnstalld, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblAvdelningenspersonal)
                                .addGap(120, 120, 120)))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAnstallda)
                .addGap(33, 33, 33)
                .addComponent(lblAvdelningenspersonal)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfdsokAnstalld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSok)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LstAvdelningenspersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LstAvdelningenspersonalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LstAvdelningenspersonalMouseClicked

    private void tfdsokAnstalldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdsokAnstalldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdsokAnstalldActionPerformed

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSokActionPerformed

    private void btnSokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokMouseClicked
        // TODO add your handling code here   private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {                                       
    try {
        // Hämta texten från sökfältet
        String sokText = tfdsokAnstalld.getText().trim();
        if (sokText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ange ett namn eller en e-postadress att söka efter.");
            return;
        }

        // SQL-fråga för att söka efter handläggare baserat på söktext
        String sqlFraga = "SELECT fornamn, efternamn, epost "
                        + "FROM anstalld "
                        + "WHERE avdelning = (SELECT avdelning FROM anstalld WHERE aid = '" + dbAid + "') "
                        + "AND (fornamn LIKE '%" + sokText + "%' "
                        + "OR efternamn LIKE '%" + sokText + "%' "
                        + "OR CONCAT(fornamn, ' ', efternamn) LIKE '%" + sokText + "%' "
                        + "OR epost LIKE '%" + sokText + "%')";

        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        DefaultListModel<String> model = new DefaultListModel<>();
        LstAvdelningenspersonal.setModel(model);

        if (resultat != null && !resultat.isEmpty()) {
            for (HashMap<String, String> rad : resultat) {
                // Hämta värden från varje rad
                String fornamn = rad.get("fornamn");
                String efternamn = rad.get("efternamn");
                String epost = rad.get("epost");

                // Kontrollera att inga fält är null
                if (fornamn == null) fornamn = "";
                if (efternamn == null) efternamn = "";
                if (epost == null) epost = "";

                // Kombinera förnamn, efternamn och e-post
                String namnOchEpost = fornamn + " " + efternamn + " - " + epost;
                model.addElement(namnOchEpost); // Lägg till i listan
            }
        } else {
            model.addElement("Ingen handläggare matchade sökningen.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(this, "Fel vid sökning: " + e.getMessage());
    }

    }//GEN-LAST:event_btnSokMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> LstAvdelningenspersonal;
    private javax.swing.JButton btnSok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnstallda;
    private javax.swing.JLabel lblAvdelningenspersonal;
    private javax.swing.JTextField tfdsokAnstalld;
    // End of variables declaration//GEN-END:variables
}
