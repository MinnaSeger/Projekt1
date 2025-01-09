/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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

    private void fyllAnstalldaLista() {
        try {
            String SQLfraga = "SELECT namn FROM anstallda WHERE avdelning_id = '" + dbAvdelningId + "'";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(SQLfraga);

            DefaultListModel<String> model = new DefaultListModel<>();
            if (resultat != null) {
                for (HashMap<String, String> rad : resultat) {
                    model.addElement(rad.get("namn")); // Lägg till varje namn i modellen
                }
            } else {
                model.addElement("Inga anställda hittades.");
            }
            LstAvdelningenspersonal.setModel(model);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av anställda: " + e.getMessage());
        }
    }

    private void sokAnstalld() {
        try {
            String sokText = tfdsokAnstalld.getText().trim();
            if (sokText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ange ett namn att söka efter.");
                return;
            }

            String SQLfraga = "SELECT namn FROM anstallda WHERE avdelning_id = '" + dbAvdelningId + 
                              "' AND namn LIKE '%" + sokText + "%'";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(SQLfraga);

            DefaultListModel<String> model = new DefaultListModel<>();
            if (resultat != null) {
                for (HashMap<String, String> rad : resultat) {
                    model.addElement(rad.get("namn")); // Lägg till matchande namn
                }
            } else {
                model.addElement("Ingen anställd matchade sökningen.");
            }
            LstAvdelningenspersonal.setModel(model);
        } catch (InfException e) {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblAnstallda, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(lblAvdelningenspersonal))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblAnstallda)
                .addGap(18, 18, 18)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> LstAvdelningenspersonal;
    private javax.swing.JButton btnSok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnstallda;
    private javax.swing.JLabel lblAvdelningenspersonal;
    private javax.swing.JTextField tfdsokAnstalld;
    // End of variables declaration//GEN-END:variables
}
