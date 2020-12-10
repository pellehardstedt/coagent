/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coagent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author chi-peilei
 */
public class PublishersPanel extends javax.swing.JPanel {
    /**
     * Creates new form PublishersPanel
     */
    PreparedStatement query = null;
    ResultSet result = null;
    
    public PublishersPanel() {
        initComponents();
        addPublisherPanel.setVisible(false);
        //showList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        publisherTitleLbl = new javax.swing.JLabel();
        addPublisherBtn = new javax.swing.JButton();
        updatePublishersBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        publisherSearchTable = new javax.swing.JTable();
        searchPublisherBtn = new javax.swing.JButton();
        editPublishersBtn = new javax.swing.JButton();
        publishersSearchTxtFld = new javax.swing.JTextField();
        addPublisherPanel = new javax.swing.JPanel();
        addPublisherNameTxtFld = new javax.swing.JTextField();
        addPublisherContactTxtFld = new javax.swing.JTextField();
        confirmAddBtn = new javax.swing.JButton();
        cancelAddBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(190, 227, 219));

        publisherTitleLbl.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        publisherTitleLbl.setText("Publishers");

        addPublisherBtn.setText("Add");
        addPublisherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPublisherBtnActionPerformed(evt);
            }
        });

        updatePublishersBtn.setText("Update");
        updatePublishersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePublishersBtnActionPerformed(evt);
            }
        });

        publisherSearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ));
        publisherSearchTable.setToolTipText("");
        jScrollPane1.setViewportView(publisherSearchTable);

        searchPublisherBtn.setText("Search");
        searchPublisherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPublisherBtnActionPerformed(evt);
            }
        });

        editPublishersBtn.setText("Edit");
        editPublishersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPublishersBtnActionPerformed(evt);
            }
        });

        publishersSearchTxtFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                publishersSearchTxtFldKeyReleased(evt);
            }
        });

        addPublisherNameTxtFld.setForeground(new java.awt.Color(153, 153, 153));

        addPublisherContactTxtFld.setForeground(new java.awt.Color(153, 153, 153));

        confirmAddBtn.setText("OK");
        confirmAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAddBtnActionPerformed(evt);
            }
        });

        cancelAddBtn.setText("Cancel");
        cancelAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Publisher Name");

        jLabel2.setText("Publisher Contact");

        javax.swing.GroupLayout addPublisherPanelLayout = new javax.swing.GroupLayout(addPublisherPanel);
        addPublisherPanel.setLayout(addPublisherPanelLayout);
        addPublisherPanelLayout.setHorizontalGroup(
            addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPublisherPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelAddBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmAddBtn)
                .addGap(33, 33, 33))
            .addGroup(addPublisherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPublisherPanelLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(addPublisherNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(addPublisherPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(addPublisherContactTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addPublisherPanelLayout.setVerticalGroup(
            addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPublisherPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(addPublisherNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPublisherContactTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAddBtn)
                    .addComponent(confirmAddBtn))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updatePublishersBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(publishersSearchTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(searchPublisherBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addPublisherBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(editPublishersBtn))
                        .addComponent(publisherTitleLbl, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(addPublisherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(publisherTitleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPublisherBtn)
                    .addComponent(searchPublisherBtn)
                    .addComponent(publishersSearchTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPublishersBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updatePublishersBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPublisherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchPublisherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPublisherBtnActionPerformed
        // TODO add your handling code here:
        searchPublisher();
        
    }//GEN-LAST:event_searchPublisherBtnActionPerformed

    private void updatePublishersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePublishersBtnActionPerformed
        
    }//GEN-LAST:event_updatePublishersBtnActionPerformed

    private void publishersSearchTxtFldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_publishersSearchTxtFldKeyReleased
        // TODO add your handling code here:
        searchPublisher();
    }//GEN-LAST:event_publishersSearchTxtFldKeyReleased

    private void addPublisherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPublisherBtnActionPerformed
        // TODO add your handling code here:
        addPublisherPanel.setVisible(true);
    }//GEN-LAST:event_addPublisherBtnActionPerformed

    private void confirmAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAddBtnActionPerformed
        // TODO add your handling code here:
        addPublisher();
        JOptionPane.showMessageDialog(null, "Insert successfull");
        addPublisherPanel.setVisible(false);
    }//GEN-LAST:event_confirmAddBtnActionPerformed

    private void cancelAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddBtnActionPerformed
        // TODO add your handling code here:
        addPublisherPanel.setVisible(false);
    }//GEN-LAST:event_cancelAddBtnActionPerformed

    private void editPublishersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPublishersBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editPublishersBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPublisherBtn;
    private javax.swing.JTextField addPublisherContactTxtFld;
    private javax.swing.JTextField addPublisherNameTxtFld;
    private javax.swing.JPanel addPublisherPanel;
    private javax.swing.JButton cancelAddBtn;
    private javax.swing.JButton confirmAddBtn;
    private javax.swing.JButton editPublishersBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable publisherSearchTable;
    private javax.swing.JLabel publisherTitleLbl;
    private javax.swing.JTextField publishersSearchTxtFld;
    private javax.swing.JButton searchPublisherBtn;
    private javax.swing.JButton updatePublishersBtn;
    // End of variables declaration//GEN-END:variables

public void showList(){
    
   try {
         Connection con = Coagent.getConnection();
         query = con.prepareStatement("SELECT * FROM Publishers");
         
         result = query.executeQuery();
       
         publisherSearchTable.setModel(DbUtils.resultSetToTableModel(result));
         
    } catch (Exception ex) {
        Logger.getLogger(PublishersPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        

}
public void addPublisher(){
    //Insert publisher name
   
    try {
         Connection con = Coagent.getConnection();
         query = con.prepareStatement("INSERT INTO publishers(Publisher_Name, Publisher_Contact) +  VALUES(?)");
         query.setString(1, addPublisherNameTxtFld.getText());
         query.setString(1, addPublisherContactTxtFld.getText());
         query.executeUpdate();
      
    } catch (Exception ex) {
        Logger.getLogger(PublishersPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void editRow(){
    publisherSearchTable.getSelectedRow();
    //EJ klar
    //query = con.prepareStatement("UPDATE publishers SET  VALUES(?)");
   
}

public void searchPublisher(){

String searchString = publishersSearchTxtFld.getText();
        String queryString;
        //if search is empty, query all contracts
        if(searchString.equals("")){
            queryString = "SELECT * FROM publishers;";
        } else {
                queryString = "SELECT * FROM publishers "
                + "WHERE (Publisher_Name LIKE '" + searchString + "%'"
                + " OR "
                + "Publisher_Contact LIKE '" + searchString + "%'"
                + ");";
        }

        try {
            Connection con = Coagent.getConnection();
            PreparedStatement query = con.prepareStatement(queryString);
            ResultSet result = query.executeQuery();
            publisherSearchTable.setModel(DbUtils.resultSetToTableModel(result));

        } catch (Exception e) {
            System.out.println(e);
        }
}
}
