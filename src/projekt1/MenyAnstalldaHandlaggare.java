package projekt1;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MenyAnstalldaHandlaggare extends javax.swing.JFrame {
    private InfDB idb; 
    private String dbAvdelningId;

    public MenyAnstalldaHandlaggare(InfDB idb, String dbAvdelningId) {
        this.idb = idb; 
        this.dbAvdelningId = dbAvdelningId;
        initComponents();
        fyllAnstalldaLista(); // Fyll listan vid start
    }

    // 1. Visa alla anställda på avdelningen
    private void fyllAnstalldaLista() {
        try {
            String SQLfraga = "SELECT CONCAT(Fornamn, ' ', Efternamn) AS namn, epost FROM anstalld WHERE avdelning = '" + dbAvdelningId + "'";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(SQLfraga);

            DefaultListModel<String> model = new DefaultListModel<>();
            LstAvdelningenspersonal.setModel(model); // Rensa listan
            if (resultat != null) {
                for (HashMap<String, String> rad : resultat) {
                    String namnOchEpost = rad.get("namn") + " - " + rad.get("epost");
                    model.addElement(namnOchEpost); // Lägg till namn och e-post
                }
            } else {
                model.addElement("Inga anställda hittades.");
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av anställda: " + e.getMessage());
        }
    }

    // 2. Sök efter en specifik handläggare
    private void sokAnstalld() {
    try {
        // Hämta söktext från textfältet
        String sokText = tfdsokAnstalld.getText().trim();
        if (sokText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ange ett namn eller e-post att söka efter.");
            return;
        }

        // SQL-fråga som söker i både namn (förnamn och efternamn) och e-post
        String SQLfraga = "SELECT CONCAT(Fornamn, ' ', Efternamn) AS namn, epost " +
                          "FROM anstallda " +
                          "WHERE avdelning = '" + dbAvdelningId + "' " +
                          "AND (Fornamn LIKE '%" + sokText + "%' " +
                          "OR Efternamn LIKE '%" + sokText + "%' " +
                          "OR epost LIKE '%" + sokText + "%')";
        System.out.println("SQL-fråga: " + SQLfraga); // Logga frågan för felsökning

        // Hämta resultat från databasen
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(SQLfraga);

        // Skapa en ny modell för listan och rensa befintligt innehåll
        DefaultListModel<String> model = new DefaultListModel<>();
        LstAvdelningenspersonal.setModel(model); // Sätt den nya modellen

        if (resultat != null) {
            // Lägg till varje resultat i listan
            for (HashMap<String, String> rad : resultat) {
                String namnOchEpost = rad.get("namn") + " - " + rad.get("epost");
                model.addElement(namnOchEpost);
            }
        } else {
            // Om inget resultat hittas, visa ett meddelande i listan
            model.addElement("Ingen anställd matchade sökningen.");
        }
    } catch (InfException e) {
        // Visa ett felmeddelande om något går fel
        JOptionPane.showMessageDialog(this, "Fel vid sökning: " + e.getMessage());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAnstallda.setText("Anställda");

        lblAvdelningenspersonal.setText("Avdelningens personal:");

        tfdsokAnstalld.setText("Skriv Anställd");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSok)
                                        .addGap(78, 78, 78))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfdsokAnstalld)
                                        .addGap(27, 27, 27)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAvdelningenspersonal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lblAnstallda, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
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
                        .addGap(18, 18, 18)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> LstAvdelningenspersonal;
    private javax.swing.JButton btnSok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnstallda;
    private javax.swing.JLabel lblAvdelningenspersonal;
    private javax.swing.JTextField tfdsokAnstalld;
    // End of variables declaration//GEN-END:variables
}
