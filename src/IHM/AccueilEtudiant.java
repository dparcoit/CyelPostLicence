/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Client.ClientEtudiant;
import CyelPostLicence.EnumDecision;
import CyelPostLicence.EnumOrdre;
import CyelPostLicence.EnumReponse;
import CyelPostLicence.Voeu;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cy
 */
public class AccueilEtudiant extends javax.swing.JFrame {

    private ClientEtudiant client;
    private Voeu[] tabVoeu;
    private Voeu voeuAccepte;

    /**
     * Creates new form AccueilEtudiant
     */
    public AccueilEtudiant() {
        initComponents();
    }

    public AccueilEtudiant(ClientEtudiant client) {
        initComponents();
        tAreaInsctruction.setVisible(false);
        tAreaInsctruction.setEditable(false);
        bt_enregistrerClassement.setVisible(false);
        tAreaErreur.setVisible(false);
        tAreaErreur.setEditable(false);
        this.client = client;
        initTableauVoeux();
        this.setVisible(true);
    }

    public void initTableauVoeux() {
        tabVoeu = client.mesVoeux();

        DefaultTableModel model = new DefaultTableModel();
        //On renseigne les identifiants des colonnes dans le modèle
        model.setColumnIdentifiers(new String[]{"ID", "Ordre", "Numero Master", "Master", "Numero Université", "Université", "Etat", "Réponse"});

        //On ajoute les ligne contenant les données dans le modèle
        int i=0;
        boolean dejaAccepte = false;
        voeuAccepte = new Voeu();
        while (i<tabVoeu.length) {
            Voeu v = tabVoeu[i];
            
            String etatCand = v.etatCandidature.toString();
            if (v.etatCandidature!=EnumDecision.acceptee || dejaAccepte) {
                etatCand = "----";
            }
            String reponse = v.reponse.toString();
            if (v.reponse==EnumReponse.vide || dejaAccepte) {
                reponse = "----";
            }
            model.addRow(new Object[]{v.numVoeu, v.ordre, v.master.numMaster, v.master.nomMaster, v.universite.numUniv, v.universite.nomUniv, etatCand, reponse});
            
            if (v.etatCandidature==EnumDecision.acceptee) {
                dejaAccepte = true;
                voeuAccepte = v;
            }
            i++;
        }
        
        if (!dejaAccepte) {
            bt_repondreVoeu.setEnabled(false);
        }

        //On ajoute le modèle dans la Jtable
        jTable_voeux.setModel(model);
        jTable_voeux.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_voeux = new javax.swing.JTable();
        bt_ajouterVoeux = new javax.swing.JButton();
        bt_repondreVoeu = new javax.swing.JButton();
        bt_seDeconnecter = new javax.swing.JButton();
        bt_ClasserVoeux = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tAreaInsctruction = new javax.swing.JTextArea();
        bt_enregistrerClassement = new javax.swing.JButton();
        bt_actualiser = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tAreaErreur = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Accueil Etudiant");

        jLabel2.setText("Consulter / Classer ses voeux");

        jTable_voeux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ordre", "Diplome", "Universite", "Etat", "ReponseEtudiant"
            }
        ));
        jScrollPane1.setViewportView(jTable_voeux);

        bt_ajouterVoeux.setText("Ajouter un voeux");
        bt_ajouterVoeux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajouterVoeuxActionPerformed(evt);
            }
        });

        bt_repondreVoeu.setText("Répondre au voeu accepté");
        bt_repondreVoeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_repondreVoeuActionPerformed(evt);
            }
        });

        bt_seDeconnecter.setText("Se déconnecter");

        bt_ClasserVoeux.setText("Classer ses voeux");
        bt_ClasserVoeux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ClasserVoeuxActionPerformed(evt);
            }
        });

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tAreaInsctruction.setEditable(false);
        tAreaInsctruction.setBackground(new java.awt.Color(240, 240, 240));
        tAreaInsctruction.setColumns(20);
        tAreaInsctruction.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tAreaInsctruction.setRows(5);
        tAreaInsctruction.setText("Pour classer vos voeux : \n - Double clic sur la cellule de la colonne \"ordre\".\n - Saisir un chiffre entre 1 et 5 (en chiffre)\n - Vérifier qu'il n'y a pas de doublon");
        tAreaInsctruction.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tAreaInsctruction);

        bt_enregistrerClassement.setText("Enregistrer votre classement");
        bt_enregistrerClassement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_enregistrerClassementActionPerformed(evt);
            }
        });

        bt_actualiser.setText("Actualiser");
        bt_actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_actualiserActionPerformed(evt);
            }
        });

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tAreaErreur.setEditable(false);
        tAreaErreur.setBackground(new java.awt.Color(240, 240, 240));
        tAreaErreur.setColumns(20);
        tAreaErreur.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tAreaErreur.setForeground(new java.awt.Color(255, 0, 51));
        tAreaErreur.setRows(5);
        tAreaErreur.setText("\n");
        tAreaErreur.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tAreaErreur);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_actualiser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(449, 449, 449))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_seDeconnecter)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_ajouterVoeux)
                                .addGap(249, 249, 249)
                                .addComponent(bt_ClasserVoeux)
                                .addGap(40, 40, 40)
                                .addComponent(bt_enregistrerClassement)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                                .addComponent(bt_repondreVoeu)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bt_seDeconnecter)
                    .addComponent(bt_actualiser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_ajouterVoeux)
                    .addComponent(bt_repondreVoeu)
                    .addComponent(bt_ClasserVoeux)
                    .addComponent(bt_enregistrerClassement))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_ajouterVoeuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajouterVoeuxActionPerformed
        new AjouterVoeu_Master(client);
    }//GEN-LAST:event_bt_ajouterVoeuxActionPerformed

    private void bt_ClasserVoeuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ClasserVoeuxActionPerformed
        jTable_voeux.setEnabled(true);

        tAreaInsctruction.setText("Pour classer vos voeux : \n"
                + " - Double clic sur la cellule de la colonne \"ordre\".\n"
                + " - Saisir un chiffre entre 1 et " + tabVoeu.length + " \n"
                + " - Vérifier qu'il n'y a pas de doublon");
        tAreaInsctruction.setVisible(true);
        bt_enregistrerClassement.setVisible(true);
        bt_ClasserVoeux.setVisible(false);

    }//GEN-LAST:event_bt_ClasserVoeuxActionPerformed

    private void bt_enregistrerClassementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_enregistrerClassementActionPerformed
        
        ArrayList<String> listOrdre;
        listOrdre = new ArrayList<>();
        boolean erreur1DejaLeve = false;
        boolean erreur2DejaLeve = false;
        boolean erreur3DejaLeve = false;
        
        tAreaErreur.setVisible(false);
        String raison = "Votre classement est incorrect : \n";

        for (int i = 0; i < tabVoeu.length; i++) {
            Object ordre = jTable_voeux.getValueAt(i, 1);
            try {
                int chiffreOrdre = Integer.parseInt(ordre.toString());
                if (chiffreOrdre <= 0 || chiffreOrdre > tabVoeu.length) {
                    if (!erreur1DejaLeve) {
                        raison += "- Valeur est en dehors de la plage de valeur possible \n";
                         erreur1DejaLeve = true;
                    }

                }
            } catch (Exception e) {
                if (!erreur2DejaLeve) {
                    raison += "- Valeur non numéraire ou vide \n";
                    erreur2DejaLeve = true;
                }
            }

            if (listOrdre.contains(ordre.toString()) == false) {
                listOrdre.add(ordre.toString());
            } else {
                if (!erreur3DejaLeve) {
                    raison += "- Doublon dans votre classement \n";
                    erreur3DejaLeve = true;
                }
            }
        }

        if (erreur1DejaLeve || erreur2DejaLeve || erreur3DejaLeve) {
            tAreaErreur.setVisible(true);
            tAreaErreur.setText(raison);
        } else {

            for (int i = 0; i < tabVoeu.length; i++) {
                Voeu v = tabVoeu[i];

                v.ordre = EnumOrdre.from_int(Integer.parseInt(listOrdre.get(i)) - 1);
                Voeu[] tab = {v};
                client.enregistrerVoeux(tab);
            }

            bt_ClasserVoeux.setVisible(true);
            bt_enregistrerClassement.setVisible(false);

        }
    }//GEN-LAST:event_bt_enregistrerClassementActionPerformed

    private void bt_actualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualiserActionPerformed
        tAreaInsctruction.setVisible(false);
        tAreaInsctruction.setEditable(false);
        bt_enregistrerClassement.setVisible(false);
        bt_ClasserVoeux.setVisible(true);
        tAreaErreur.setVisible(false);
        tAreaErreur.setEditable(false);
        initTableauVoeux();
    }//GEN-LAST:event_bt_actualiserActionPerformed

    private void bt_repondreVoeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_repondreVoeuActionPerformed
        Voeu v = voeuAccepte;

        RepondreVoeu repondre = new RepondreVoeu(client,v);
        this.setVisible(false);
        repondre.setVisible(true);
    }//GEN-LAST:event_bt_repondreVoeuActionPerformed

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
            java.util.logging.Logger.getLogger(AccueilEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccueilEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccueilEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccueilEtudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccueilEtudiant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ClasserVoeux;
    private javax.swing.JButton bt_actualiser;
    private javax.swing.JButton bt_ajouterVoeux;
    private javax.swing.JButton bt_enregistrerClassement;
    private javax.swing.JButton bt_repondreVoeu;
    private javax.swing.JButton bt_seDeconnecter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_voeux;
    private javax.swing.JTextArea tAreaErreur;
    private javax.swing.JTextArea tAreaInsctruction;
    // End of variables declaration//GEN-END:variables
}
