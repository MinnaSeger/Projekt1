/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projekt1;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author elsa
 */
public class MenyHallbarhetsmalProjektledare extends javax.swing.JFrame {
     private InfDB idb;
    private String dbAid;

    /**
     * Creates new form MenyHallbarhetsmalProjektledare
     */
    public MenyHallbarhetsmalProjektledare(InfDB idb, String dbAid) {
        this.idb = idb;
        this.dbAid = dbAid;
        initComponents();
        
        fyllComboBoxHallbarhetsmal ();
        
                //lägg till en lyssnare för att hantera val från rullistan
       ComboboxHallbarhetsmal.addActionListener(evt -> {
        String valtMål = (String) ComboboxHallbarhetsmal.getSelectedItem();//hämta valt namn
        System.out.println("Användaren valde: " + valtMål);
});
               }
    
    
private void fyllComboBoxHallbarhetsmal() {

    try{ String sqlFraga = "SELECT namn FROM hallbarhetsmal";
                        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);
            
            if (resultat !=null) {
                ComboboxHallbarhetsmal.removeAllItems();
                for (HashMap <String, String> rad : resultat) {
                 ComboboxHallbarhetsmal.addItem(rad.get("namn"));
                }
            }else{
                JOptionPane.showMessageDialog(this, "Inga hållbarhetsmål hittades i databasen.");

            }               
            } catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Fel vid hämtning av hållbarhetsmål.");
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

        lblAllaHallbarhetsmal = new javax.swing.JLabel();
        ComboboxHallbarhetsmal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAllaHallbarhetsmal.setText("Alla hållbarhetsmål:");

        ComboboxHallbarhetsmal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(lblAllaHallbarhetsmal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(ComboboxHallbarhetsmal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblAllaHallbarhetsmal)
                .addGap(18, 18, 18)
                .addComponent(ComboboxHallbarhetsmal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MenyHallbarhetsmalProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyHallbarhetsmalProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyHallbarhetsmalProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyHallbarhetsmalProjektledare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyHallbarhetsmalProjektledare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboboxHallbarhetsmal;
    private javax.swing.JLabel lblAllaHallbarhetsmal;
    // End of variables declaration//GEN-END:variables
}