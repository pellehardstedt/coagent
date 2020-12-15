/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coagent;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class SubmissionsPanel extends javax.swing.JPanel {


    /**
     * Creates new form Submissions
     */
    public SubmissionsPanel() {
        
        initComponents();
        panelSub.setMinimumSize(new java.awt.Dimension(250, 250));
        tableSearchSub.setShowGrid(false);
        
        
        PopulateComboBookTitle();
        comboBookTitle.setSelectedItem(null);

        PopulateComboPublisher();
        comboPublisher.setSelectedItem(null);
        
        PopulateComboEditor();
        comboEditor.setSelectedItem(null);
        
        PopulateComboReplyGrade();
        comboReplyGrade.setSelectedItem(null);


      
        tableSearchSub.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent event) {
                comboBookTitle.setSelectedItem(tableSearchSub.getValueAt(tableSearchSub.getSelectedRow(), 0).toString());
                comboPublisher.setSelectedItem(tableSearchSub.getValueAt(tableSearchSub.getSelectedRow(), 1).toString());
                comboReplyGrade.setSelectedItem(tableSearchSub.getValueAt(tableSearchSub.getSelectedRow(), 3).toString());
              
        }
    });
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSub = new javax.swing.JPanel();
        lblBookTitle = new javax.swing.JLabel();
        lblEditorName = new javax.swing.JLabel();
        lblReplyGrade = new javax.swing.JLabel();
        comboBookTitle = new javax.swing.JComboBox<>();
        comboEditor = new javax.swing.JComboBox<>();
        comboReplyGrade = new javax.swing.JComboBox<>();
        lblPublisher = new javax.swing.JLabel();
        comboPublisher = new javax.swing.JComboBox<>();
        btnUpdateReply = new javax.swing.JButton();
        lblSubmissionHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtfieldSubSearch = new javax.swing.JTextPane();
        btnSearch = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSearchSub = new javax.swing.JTable();
        lblSearchExplain = new javax.swing.JLabel();
        btnCreateNew = new javax.swing.JButton();
        btnClearSearch = new javax.swing.JButton();

        setBackground(new java.awt.Color(190, 227, 219));
        setToolTipText("");
        setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N

        panelSub.setBackground(new java.awt.Color(250, 249, 249));

        lblBookTitle.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        lblBookTitle.setText("Book");

        lblEditorName.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        lblEditorName.setText("Editor");

        lblReplyGrade.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        lblReplyGrade.setText("Reply");

        comboBookTitle.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N

        comboEditor.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N

        comboReplyGrade.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        comboReplyGrade.setToolTipText("");

        lblPublisher.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        lblPublisher.setText("Publisher");

        comboPublisher.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N

        btnUpdateReply.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        btnUpdateReply.setText("Update reply");
        btnUpdateReply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateReplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSubLayout = new javax.swing.GroupLayout(panelSub);
        panelSub.setLayout(panelSubLayout);
        panelSubLayout.setHorizontalGroup(
            panelSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelSubLayout.createSequentialGroup()
                            .addComponent(lblBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBookTitle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelSubLayout.createSequentialGroup()
                            .addComponent(lblPublisher)
                            .addGap(59, 59, 59)
                            .addComponent(comboPublisher, 0, 212, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(lblEditorName, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(comboEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSubLayout.createSequentialGroup()
                        .addComponent(lblReplyGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboReplyGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateReply)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelSubLayout.setVerticalGroup(
            panelSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBookTitle)
                    .addComponent(comboBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEditorName)
                    .addComponent(lblPublisher))
                .addGap(26, 26, 26)
                .addGroup(panelSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReplyGrade)
                    .addComponent(comboReplyGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateReply))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblSubmissionHeader.setFont(new java.awt.Font("Avenir Next", 0, 36)); // NOI18N
        lblSubmissionHeader.setText("Submissions");

        txtfieldSubSearch.setBackground(new java.awt.Color(249, 250, 250));
        txtfieldSubSearch.setBorder(null);
        txtfieldSubSearch.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        txtfieldSubSearch.setOpaque(false);
        jScrollPane1.setViewportView(txtfieldSubSearch);

        btnSearch.setBackground(new java.awt.Color(250, 249, 249));
        btnSearch.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        btnSearch.setText("Search submissions");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        btnSave.setText("Save new submssion");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(190, 227, 219));
        jScrollPane2.setForeground(new java.awt.Color(190, 227, 219));
        jScrollPane2.setToolTipText("");

        tableSearchSub.setBackground(new java.awt.Color(190, 227, 219));
        tableSearchSub.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        tableSearchSub.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book", "Publisher", "Editor", "Reply", "Date last updated"
            }
        ));
        tableSearchSub.setCellSelectionEnabled(true);
        tableSearchSub.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tableSearchSub.setGridColor(new java.awt.Color(250, 249, 249));
        tableSearchSub.setInheritsPopupMenu(true);
        tableSearchSub.setSelectionForeground(new java.awt.Color(250, 249, 249));
        jScrollPane2.setViewportView(tableSearchSub);
        tableSearchSub.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        lblSearchExplain.setFont(new java.awt.Font("Avenir Next", 0, 10)); // NOI18N
        lblSearchExplain.setText("Search in submissions by a book's title or an editor's name.");

        btnCreateNew.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        btnCreateNew.setText("Start new submission");
        btnCreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewActionPerformed(evt);
            }
        });

        btnClearSearch.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        btnClearSearch.setText("Clear search results ");
        btnClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClearSearch)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnCreateNew)
                            .addGap(18, 18, 18)
                            .addComponent(btnSave)
                            .addGap(205, 205, 205))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblSubmissionHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSearchExplain))
                        .addComponent(panelSub, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnSearch)))))
                .addGap(64, 121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSubmissionHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchExplain))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearSearch)
                .addGap(18, 18, 18)
                .addComponent(panelSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateNew)
                    .addComponent(btnSave))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        AddSubmission();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        SearchSubmission();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewActionPerformed
        CreateNewSub();
    }//GEN-LAST:event_btnCreateNewActionPerformed

    private void btnUpdateReplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateReplyActionPerformed
        UpdateReply();
    }//GEN-LAST:event_btnUpdateReplyActionPerformed

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        ClearSearch();
    }//GEN-LAST:event_btnClearSearchActionPerformed


    
    private void PopulateComboBookTitle(){
        String comboBoxQuery = "SELECT Books_Title FROM books";
        ResultSet rs;
        PreparedStatement statement;
        try {
            Connection con = Coagent.getConnection();
            statement = con.prepareStatement(comboBoxQuery);
            rs = statement.executeQuery();
        while (rs.next()) {
            String bookTitle = rs.getString("Books_Title");
            comboBookTitle.addItem(bookTitle);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            }
    }
    
    
    
    
    private void PopulateComboPublisher() {
            String comboBoxQuery = "SELECT Publisher_Name FROM publishers";
            ResultSet rs;
            PreparedStatement statement;
        try {
            Connection con = Coagent.getConnection();
            statement = con.prepareStatement(comboBoxQuery);
            rs = statement.executeQuery();
        while (rs.next()) {
            String publisherName = rs.getString("Publisher_Name");
            comboPublisher.addItem(publisherName);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            }
    
    
    }
    
    private void PopulateComboEditor() {
        comboPublisher.addItemListener(new ItemListener() {
        @Override
            public void itemStateChanged(ItemEvent arg0) {
                if (comboPublisher.getSelectedItem() == null){
                    return;
                } else {    
                    String s = comboPublisher.getSelectedItem().toString(); 
                    String statement = "SELECT publishers.Publisher_Id, publishers.Publisher_Name, editors.Editor_Name FROM publishers, editors WHERE Publisher_name =\"" + s + "\" and editors.Publisher_Publisher_Id = publishers.Publisher_Id";
                try {
                    Connection con = Coagent.getConnection();
                    PreparedStatement pst = con.prepareStatement(statement);
                    ResultSet rs = pst.executeQuery();
                    comboEditor.removeAllItems();
                        while (rs.next()) {
                            comboEditor.addItem(rs.getString("Editor_Name"));
                        }
                } catch (Exception e) {
                    System.out.println(e.toString());
                        }
                    }
            }
        });
    }
    
    
        
    private void PopulateComboReplyGrade () {
            
        ArrayList<String> comboOptions = new ArrayList<String>();
        comboOptions.add("No reply yet");
        comboOptions.add("Not interested in this genre");
        comboOptions.add("Not interested in this book");
        comboOptions.add("Keep them informed about any offers");
        comboOptions.add("Making an offer");
        comboOptions.add("Making a preempt");
        comboOptions.add("Requested title before submission");
                
        for (int i = 0; i < comboOptions.size(); i++)
            comboReplyGrade.addItem(comboOptions.get(i));
    }    
     
    
    private void AddSubmission() {
        String book = String.valueOf(comboBookTitle.getSelectedItem());
        String editor = String.valueOf(comboEditor.getSelectedItem());
        String reply = String.valueOf(comboReplyGrade.getSelectedItem());
        String queryString1 = "SELECT books.Books_Id, books.Books_Title FROM books WHERE Books_Title = \"" + book + "\";";
        ResultSet result1;
        String queryString2 = "SELECT editors.Editor_Id, editors.Editor_Name FROM editors WHERE editors.Editor_Name = \"" + editor + "\";";
        ResultSet result2;
        Statement stm;
        
        try {
            Connection con = Coagent.getConnection();
            //Get Book_ID from database
            PreparedStatement query1 = con.prepareStatement(queryString1);
            result1 = query1.executeQuery();
            //.next() shifts the cursor to the next (the first) row of the result set
            result1.next();
            
            //Get Editor_ID from database
            PreparedStatement query2 = con.prepareStatement(queryString2);
            result2 = query2.executeQuery();
            //.next() shifts the cursor to the next (the first) row of the result set
            result2.next();
        
            stm = con.createStatement();
            String sql = "INSERT INTO submissions (Books_Books_Id, Editor_Editor_Id, Reply_Grade) VALUES (" + result1.getString(1) + ", " + result2.getString(1) + ", '" + reply + "');";
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to save these changes into the database?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                     stm.executeUpdate(sql);
                     JOptionPane.showMessageDialog(null, "Submission is added");
                }
                else {
                }
        
           } catch (Exception e) {
                System.out.println(e);
             }
                    
    }
    
    
    private void CreateNewSub() {
        comboBookTitle.setSelectedItem(null);
        comboReplyGrade.setSelectedItem(null);
        comboEditor.setSelectedItem(null);
        comboPublisher.setSelectedItem(null);
    
    }

    private void ClearSearch() {
        try {
            DefaultTableModel model = (DefaultTableModel) tableSearchSub.getModel();
            model.setRowCount(0);
   
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    
    private void UpdateReply() {
        String book = String.valueOf(comboBookTitle.getSelectedItem());
        String editor = String.valueOf(comboEditor.getSelectedItem());
        String reply = String.valueOf(comboReplyGrade.getSelectedItem());
        String queryString1 = "SELECT books.Books_Id, books.Books_Title FROM books WHERE Books_Title = \"" + book + "\";";
        ResultSet result1;
        String queryString2 = "SELECT editors.Editor_Id, editors.Editor_Name FROM editors WHERE editors.Editor_Name = \"" + editor + "\";";
        ResultSet result2;
        Statement stm;
        
        try {
            Connection con = Coagent.getConnection();
            //Get Book_ID from database
            PreparedStatement query1 = con.prepareStatement(queryString1);
            result1 = query1.executeQuery();
            //.next() shifts the cursor to the next (the first) row of the result set
            result1.next();
            
            //Get Editor_ID from database
            PreparedStatement query2 = con.prepareStatement(queryString2);
            result2 = query2.executeQuery();
            //.next() shifts the cursor to the next (the first) row of the result set
            result2.next();
        
            stm = con.createStatement();
            String sql = "UPDATE submissions SET Reply_Grade = '" + reply + "' WHERE Books_Books_Id = " + result1.getString(1) + " AND Editor_Editor_Id = " + result2.getString(1) + ";";
            System.out.println(sql);
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like update this submission?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                     int updateresult = stm.executeUpdate(sql);
                     if (updateresult == 1) {
                     JOptionPane.showMessageDialog(null, "Submission updated");
                     }
                     else {
                     JOptionPane.showMessageDialog(null, "This submission doesn't exist. Please create it first to update the reply.");
                     }
                }
                else {
                }
        
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Submission doesn't exist yet");
               System.out.println(e);
             }
    
    }

    private void SearchSubmission() {
        String searchString = txtfieldSubSearch.getText();
        String queryString;
        //if search is empty, query all submissions
        if(searchString.equals("")){
            //SELECT only the columns in the mysql table that's going into the jTable
            queryString = "SELECT Books_Title, Publisher_Name, Editor_Name, Reply_Grade, Last_Updated FROM submission_all_info;";
        } else {
                //Same SELECT as above
                queryString = "SELECT Books_Title, Publisher_Name, Editor_Name, Reply_Grade, Last_Updated FROM submission_all_info "
                + "WHERE (Books_Title LIKE '" + searchString + "%'"
                + " OR "
                + "Editor_Name LIKE '" + searchString + "%'"
                + " OR "
                + "Publisher_Name LIKE '" + searchString + "%'"
                + ");";
        }
        
        try {
            Connection con = Coagent.getConnection();
            PreparedStatement query = con.prepareStatement(queryString);
            ResultSet result = query.executeQuery();

            // Removing Previous Data
            while (tableSearchSub.getRowCount() > 0) {
                ((DefaultTableModel) tableSearchSub.getModel()).removeRow(0);
            }

            //Creating Object []rowData for jTable's Table Model
            int columns = result.getMetaData().getColumnCount();
            while (result.next())
            {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    row[i - 1] = result.getObject(i); // 1
                }
                ((DefaultTableModel) tableSearchSub.getModel()).insertRow(result.getRow() - 1,row);
            }

            } catch (Exception e) {
                System.out.println(e);
            }

    
    
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearSearch;
    private javax.swing.JButton btnCreateNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateReply;
    private javax.swing.JComboBox<String> comboBookTitle;
    private javax.swing.JComboBox<String> comboEditor;
    private javax.swing.JComboBox<String> comboPublisher;
    private javax.swing.JComboBox<String> comboReplyGrade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBookTitle;
    private javax.swing.JLabel lblEditorName;
    private javax.swing.JLabel lblPublisher;
    private javax.swing.JLabel lblReplyGrade;
    private javax.swing.JLabel lblSearchExplain;
    private javax.swing.JLabel lblSubmissionHeader;
    private javax.swing.JPanel panelSub;
    private javax.swing.JTable tableSearchSub;
    private javax.swing.JTextPane txtfieldSubSearch;
    // End of variables declaration//GEN-END:variables







}
