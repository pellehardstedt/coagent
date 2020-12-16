/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coagent;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class gui extends javax.swing.JFrame {

    /**
     * Creates new form gui
     */
    CardLayout cardLayout;
    public gui() throws Exception {
        initComponents();

        EditorPanel editorPanel = new EditorPanel();
        editorPanel.setVisible(true);
        card5.add(editorPanel, BorderLayout.CENTER);

        ClientsJPanel clientPanel = new ClientsJPanel();
        clientPanel.setVisible(true);
        card6.add(clientPanel, BorderLayout.CENTER);

        BooksPanel booksPanel = new BooksPanel();
        booksPanel.setVisible(true);
        card1.add(booksPanel, BorderLayout.CENTER);

        SubmissionsPanel submission = new SubmissionsPanel();
        submission.setVisible(true);
        card2.add(submission, BorderLayout.CENTER);

        PublishersPanel publishersPanel = new PublishersPanel();
        publishersPanel.setVisible(true);
        card4.add(publishersPanel, BorderLayout.CENTER);

        ContractPanel contract = new ContractPanel();
        contract.setVisible(true);
        card3.add(contract, BorderLayout.CENTER);

        cardLayout = (CardLayout)(jPanel2Cards.getLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2Cards = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        card2 = new javax.swing.JPanel();
        card3 = new javax.swing.JPanel();
        card4 = new javax.swing.JPanel();
        card5 = new javax.swing.JPanel();
        card6 = new javax.swing.JPanel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 900));

        jSplitPane1.setPreferredSize(new java.awt.Dimension(151, 900));

        jPanel1.setBackground(new java.awt.Color(137, 176, 174));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 900));

        jButton1.setBackground(new java.awt.Color(137, 176, 174));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(76, 80, 82));
        jButton1.setText("Books");
        jButton1.setBorderPainted(false);
        jButton1.setMaximumSize(new java.awt.Dimension(96, 22));
        jButton1.setMinimumSize(new java.awt.Dimension(96, 22));
        jButton1.setPreferredSize(new java.awt.Dimension(96, 22));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(137, 176, 174));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(76, 80, 82));
        jButton2.setText("Submissions");
        jButton2.setToolTipText("");
        jButton2.setBorderPainted(false);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.setMaximumSize(new java.awt.Dimension(96, 22));
        jButton2.setMinimumSize(new java.awt.Dimension(96, 22));
        jButton2.setPreferredSize(new java.awt.Dimension(96, 22));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(137, 176, 174));
        jButton3.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(76, 80, 82));
        jButton3.setText("Contracts");
        jButton3.setBorderPainted(false);
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.setMaximumSize(new java.awt.Dimension(96, 22));
        jButton3.setMinimumSize(new java.awt.Dimension(96, 22));
        jButton3.setPreferredSize(new java.awt.Dimension(96, 22));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(137, 176, 174));
        jButton4.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(76, 80, 82));
        jButton4.setText("Publishers");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(137, 176, 174));
        jButton5.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(76, 80, 82));
        jButton5.setText("Editors");
        jButton5.setBorderPainted(false);
        jButton5.setMaximumSize(new java.awt.Dimension(96, 22));
        jButton5.setMinimumSize(new java.awt.Dimension(96, 22));
        jButton5.setPreferredSize(new java.awt.Dimension(96, 22));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(137, 176, 174));
        jButton6.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(76, 80, 82));
        jButton6.setText("Clients");
        jButton6.setBorderPainted(false);
        jButton6.setMaximumSize(new java.awt.Dimension(96, 22));
        jButton6.setMinimumSize(new java.awt.Dimension(96, 22));
        jButton6.setPreferredSize(new java.awt.Dimension(96, 22));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(653, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2Cards.setBackground(new java.awt.Color(250, 249, 249));
        jPanel2Cards.setLayout(new java.awt.CardLayout());

        card1.setBackground(new java.awt.Color(250, 249, 249));
        card1.setLayout(new java.awt.BorderLayout());
        jPanel2Cards.add(card1, "card1");

        card2.setBackground(new java.awt.Color(250, 249, 249));
        card2.setLayout(new java.awt.BorderLayout());
        jPanel2Cards.add(card2, "card2");

        card3.setBackground(new java.awt.Color(250, 249, 249));
        card3.setLayout(new java.awt.BorderLayout());
        jPanel2Cards.add(card3, "card3");

        card4.setBackground(new java.awt.Color(250, 249, 249));
        card4.setLayout(new java.awt.BorderLayout());
        jPanel2Cards.add(card4, "card4");

        card5.setBackground(new java.awt.Color(250, 249, 249));
        card5.setLayout(new java.awt.BorderLayout());
        jPanel2Cards.add(card5, "card5");

        card6.setBackground(new java.awt.Color(250, 249, 249));
        card6.setLayout(new java.awt.BorderLayout());
        jPanel2Cards.add(card6, "card6");

        jSplitPane1.setRightComponent(jPanel2Cards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //cardLayout.show(jPanel2Cards, "card1");
        cardLayout.show(jPanel2Cards, "card1");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cardLayout.show(jPanel2Cards, "card2");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cardLayout.show(jPanel2Cards, "card3");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cardLayout.show(jPanel2Cards, "card4");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cardLayout.show(jPanel2Cards, "card5");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cardLayout.show(jPanel2Cards, "card6");
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new gui().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private javax.swing.JPanel card5;
    private javax.swing.JPanel card6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2Cards;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
