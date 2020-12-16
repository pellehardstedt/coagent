/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coagent;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
import javax.swing.table.TableModel;

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
        editPublisherPanel.setVisible(false);
        JTableHeader headerSearch = publisherSearchTable.getTableHeader();
        headerSearch.setBackground( new Color(190, 227, 219) );
        headerSearch.setForeground( new Color(85, 91, 110) );
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
        editPublisherPanel = new javax.swing.JPanel();
        editPublisherNameTxtFld = new javax.swing.JTextField();
        editPublisherContactTxtFld = new javax.swing.JTextField();
        confirmEditBtn1 = new javax.swing.JButton();
        cancelEditBtn1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        publisherDeleteBtn = new javax.swing.JButton();
        publisherIdLabel = new javax.swing.JLabel();
        publisherIdNumlbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(190, 227, 219));

        publisherTitleLbl.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        publisherTitleLbl.setText("Publishers");

        addPublisherBtn.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        addPublisherBtn.setText("Add");
        addPublisherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPublisherBtnActionPerformed(evt);
            }
        });

        publisherSearchTable.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        publisherSearchTable.setForeground(new java.awt.Color(85, 91, 110));
        publisherSearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Publisher Id", "Publisher Name", "Publisher Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        publisherSearchTable.setToolTipText("");
        publisherSearchTable.getTableHeader().setReorderingAllowed(false);
        publisherSearchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                publisherSearchTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(publisherSearchTable);
        if (publisherSearchTable.getColumnModel().getColumnCount() > 0) {
            publisherSearchTable.getColumnModel().getColumn(0).setResizable(false);
            publisherSearchTable.getColumnModel().getColumn(1).setResizable(false);
            publisherSearchTable.getColumnModel().getColumn(2).setResizable(false);
        }

        searchPublisherBtn.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        searchPublisherBtn.setText("Search");
        searchPublisherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPublisherBtnActionPerformed(evt);
            }
        });

        editPublishersBtn.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        editPublishersBtn.setText("Edit");
        editPublishersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPublishersBtnActionPerformed(evt);
            }
        });

        publishersSearchTxtFld.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        publishersSearchTxtFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                publishersSearchTxtFldKeyReleased(evt);
            }
        });

        addPublisherPanel.setBackground(new java.awt.Color(137, 176, 174));

        confirmAddBtn.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        confirmAddBtn.setText("OK");
        confirmAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAddBtnActionPerformed(evt);
            }
        });

        cancelAddBtn.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        cancelAddBtn.setText("Cancel");
        cancelAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel1.setText("Publisher Name");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel2.setText("Publisher Contact");

        javax.swing.GroupLayout addPublisherPanelLayout = new javax.swing.GroupLayout(addPublisherPanel);
        addPublisherPanel.setLayout(addPublisherPanelLayout);
        addPublisherPanelLayout.setHorizontalGroup(
            addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPublisherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPublisherNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPublisherPanelLayout.createSequentialGroup()
                            .addComponent(cancelAddBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(confirmAddBtn))
                        .addComponent(addPublisherContactTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(147, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAddBtn)
                    .addComponent(confirmAddBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editPublisherPanel.setBackground(new java.awt.Color(137, 176, 174));

        confirmEditBtn1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        confirmEditBtn1.setText("OK");
        confirmEditBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmEditBtn1ActionPerformed(evt);
            }
        });

        cancelEditBtn1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        cancelEditBtn1.setText("Cancel");
        cancelEditBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditBtn1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel3.setText("Publisher Name");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel4.setText("Publisher Contact");

        publisherDeleteBtn.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        publisherDeleteBtn.setText("Delete");
        publisherDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherDeleteBtnActionPerformed(evt);
            }
        });

        publisherIdLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        publisherIdLabel.setText("Publisher Id: ");

        publisherIdNumlbl.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N

        javax.swing.GroupLayout editPublisherPanelLayout = new javax.swing.GroupLayout(editPublisherPanel);
        editPublisherPanel.setLayout(editPublisherPanelLayout);
        editPublisherPanelLayout.setHorizontalGroup(
            editPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPublisherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPublisherPanelLayout.createSequentialGroup()
                            .addComponent(publisherDeleteBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelEditBtn1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(confirmEditBtn1))
                        .addGroup(editPublisherPanelLayout.createSequentialGroup()
                            .addGroup(editPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(editPublisherPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editPublisherNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(editPublisherPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(editPublisherContactTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(2, 2, 2)))
                    .addGroup(editPublisherPanelLayout.createSequentialGroup()
                        .addComponent(publisherIdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(publisherIdNumlbl)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        editPublisherPanelLayout.setVerticalGroup(
            editPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPublisherPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(editPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publisherIdLabel)
                    .addComponent(publisherIdNumlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(editPublisherNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPublisherContactTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editPublisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelEditBtn1)
                    .addComponent(confirmEditBtn1)
                    .addComponent(publisherDeleteBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
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
                    .addComponent(publisherTitleLbl, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(addPublisherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editPublisherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(41, 41, 41)
                .addComponent(addPublisherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editPublisherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchPublisherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPublisherBtnActionPerformed
        //Search in database when Search button is clicked.
        searchPublisher();
        
    }//GEN-LAST:event_searchPublisherBtnActionPerformed

    private void publishersSearchTxtFldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_publishersSearchTxtFldKeyReleased
        // Search in database when key is released in TextField
        searchPublisher();
    }//GEN-LAST:event_publishersSearchTxtFldKeyReleased

    private void addPublisherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPublisherBtnActionPerformed
        
        editPublisherPanel.setVisible(false);
        addPublisherPanel.setVisible(true);
    }//GEN-LAST:event_addPublisherBtnActionPerformed

    private void confirmAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAddBtnActionPerformed
        // Performs addPublisher method
        addPublisher();
        addPublisherPanel.setVisible(false);
    }//GEN-LAST:event_confirmAddBtnActionPerformed

    private void cancelAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddBtnActionPerformed
        
        addPublisherPanel.setVisible(false);
    }//GEN-LAST:event_cancelAddBtnActionPerformed

    private void editPublishersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPublishersBtnActionPerformed
        
        addPublisherPanel.setVisible(false);
        editPublisherPanel.setVisible(true);
    }//GEN-LAST:event_editPublishersBtnActionPerformed

    private void confirmEditBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmEditBtn1ActionPerformed
        // Performs editConfirm method
        editConfirm();
        editPublisherPanel.setVisible(false);
    }//GEN-LAST:event_confirmEditBtn1ActionPerformed

    private void cancelEditBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditBtn1ActionPerformed
        
        editPublisherPanel.setVisible(false);
    }//GEN-LAST:event_cancelEditBtn1ActionPerformed

    private void publisherSearchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_publisherSearchTableMouseClicked
        // Performs getRow method
        getRow();
    }//GEN-LAST:event_publisherSearchTableMouseClicked

    private void publisherDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherDeleteBtnActionPerformed
        // Performs deleteRow method
        deleteRow();
    }//GEN-LAST:event_publisherDeleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPublisherBtn;
    private javax.swing.JTextField addPublisherContactTxtFld;
    private javax.swing.JTextField addPublisherNameTxtFld;
    private javax.swing.JPanel addPublisherPanel;
    private javax.swing.JButton cancelAddBtn;
    private javax.swing.JButton cancelEditBtn1;
    private javax.swing.JButton confirmAddBtn;
    private javax.swing.JButton confirmEditBtn1;
    private javax.swing.JTextField editPublisherContactTxtFld;
    private javax.swing.JTextField editPublisherNameTxtFld;
    private javax.swing.JPanel editPublisherPanel;
    private javax.swing.JButton editPublishersBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton publisherDeleteBtn;
    private javax.swing.JLabel publisherIdLabel;
    private javax.swing.JLabel publisherIdNumlbl;
    private javax.swing.JTable publisherSearchTable;
    private javax.swing.JLabel publisherTitleLbl;
    private javax.swing.JTextField publishersSearchTxtFld;
    private javax.swing.JButton searchPublisherBtn;
    // End of variables declaration//GEN-END:variables

   
public void showList(){
    
   try {
         //Connects to database by getConnection method declared in separate class
         Connection con = Coagent.getConnection();
         query = con.prepareStatement("SELECT * FROM Publishers");

         result = query.executeQuery();
       
         publisherSearchTable.setModel(DbUtils.resultSetToTableModel(result));
         
    } catch (Exception ex) {
        Logger.getLogger(PublishersPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

}
public void addPublisher(){
    //Insert new Publisher to database
   
    try {
         Connection con = Coagent.getConnection();
         query = con.prepareStatement("INSERT INTO publishers (Publisher_Name, Publisher_Contact) VALUES(?, ?)");
         query.setString(1, addPublisherNameTxtFld.getText());
         query.setString(2, addPublisherContactTxtFld.getText());
         query.executeUpdate();
         JOptionPane.showMessageDialog(null, "Insert successfull");
         showList();
      
    } catch (Exception ex) {
        Logger.getLogger(PublishersPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void getRow(){
   //Inserts data from selected row in table to jLabel and jTextFields
   
   int i = publisherSearchTable.getSelectedRow();
        
   TableModel model = publisherSearchTable.getModel();
   publisherIdNumlbl.setText(model.getValueAt(i, 0).toString());
   editPublisherNameTxtFld.setText(model.getValueAt(i, 1).toString());
   editPublisherContactTxtFld.setText(model.getValueAt(i, 2).toString());
  
   
        }

public void editConfirm(){
    //Sends UPDATE query when data is edited
    try {
         Connection con = Coagent.getConnection();
         TableModel model = publisherSearchTable.getModel();
         int i = publisherSearchTable.getSelectedRow();
         
         query = con.prepareStatement("UPDATE publishers SET Publisher_Name = ?, Publisher_Contact = ? WHERE Publisher_ID = ?");
         query.setString(1, editPublisherNameTxtFld.getText());
         query.setString(2, editPublisherContactTxtFld.getText());
         query.setString(3, publisherIdNumlbl.getText());
         
         query.executeUpdate();
         JOptionPane.showMessageDialog(null, "Update successfull");
         showList();
      
    } catch (Exception ex) {
        Logger.getLogger(PublishersPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void deleteRow(){
    //Deletes selected row from database
    try {
         Connection con = Coagent.getConnection();
         TableModel model = publisherSearchTable.getModel();
         int i = publisherSearchTable.getSelectedRow();
         
         query = con.prepareStatement("DELETE FROM publishers WHERE Publisher_ID = ?");
         query.setString(1, publisherIdNumlbl.getText());
         query.executeUpdate();
         
         JOptionPane.showMessageDialog(null, "Delete successfull");
         showList();
      
    } catch (Exception ex) {
        Logger.getLogger(PublishersPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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