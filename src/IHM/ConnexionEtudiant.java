/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Client.ClientEtudiant;
import CyelPostLicence.Academie;
import CyelPostLicence.AcademieIncorrecte;
import CyelPostLicence.EtudiantInconnu;
import Outils.Item;
import javax.swing.JFrame;

/**
 *
 * @author Linkro
 */
public class ConnexionEtudiant extends javax.swing.JFrame {

    private static ClientEtudiant client;

    /**
     * Creates new form ConnexionEtudiant
     */
    public ConnexionEtudiant() {
        initComponents();
    }
    
    public ConnexionEtudiant(ClientEtudiant client) {
        this.client = client;
        initComponents();
        initListeAcademie();
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lConnexionTitre = new javax.swing.JLabel();
        lINE = new javax.swing.JLabel();
        lAcademie = new javax.swing.JLabel();
        txtINE = new javax.swing.JTextField();
        bt_Connexion = new javax.swing.JButton();
        lErreur = new javax.swing.JLabel();
        cb_listeAcademie = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lConnexionTitre.setText("Connexion Etudiant");

        lINE.setText("INE Etudiant : ");

        lAcademie.setText("Académie :");

        bt_Connexion.setText("Connexion");
        bt_Connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ConnexionActionPerformed(evt);
            }
        });

        lErreur.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lConnexionTitre)
                        .addGap(193, 193, 193))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_Connexion)
                        .addGap(201, 201, 201))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lAcademie)
                            .addComponent(lINE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtINE, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_listeAcademie, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lErreur)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lConnexionTitre)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lINE)
                    .addComponent(txtINE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAcademie)
                    .addComponent(cb_listeAcademie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(bt_Connexion)
                .addGap(18, 18, 18)
                .addComponent(lErreur)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_ConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ConnexionActionPerformed
       boolean exception = false;
        try {
            Item selectItem = (Item) cb_listeAcademie.getSelectedItem();
            client.connexion(txtINE.getText(), new Academie(selectItem.getId(), selectItem.getValeur()));
        } catch (EtudiantInconnu ex) {
            lErreur.setText(ex.raison);
            exception = true;
            //Logger.getLogger(ConnexionEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AcademieIncorrecte ex) {
            lErreur.setText(ex.raison);
            exception = true;
        }

        if (!exception) {
            AccueilEtudiant accueil = new AccueilEtudiant(client);
            this.dispose();
        }

    }//GEN-LAST:event_bt_ConnexionActionPerformed

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
            java.util.logging.Logger.getLogger(ConnexionEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnexionEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnexionEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnexionEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnexionEtudiant();

            }
        });
    }

    public void initListeAcademie() {
        Academie[] listeA = client.listeAcademie();
        for (int i = 0; i < listeA.length; i++) {
            cb_listeAcademie.addItem(new Item(listeA[i].numAcademie, listeA[i].nomAcademie));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Connexion;
    private javax.swing.JComboBox cb_listeAcademie;
    private javax.swing.JLabel lAcademie;
    private javax.swing.JLabel lConnexionTitre;
    private javax.swing.JLabel lErreur;
    private javax.swing.JLabel lINE;
    private javax.swing.JTextField txtINE;
    // End of variables declaration//GEN-END:variables
}
