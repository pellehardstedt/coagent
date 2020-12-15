/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coagent;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author lenovo
 */
public class BooksPanel extends javax.swing.JPanel {
        String[] dbSearchTables = {
            "books",
            "books",
            "authors",
            "authors",
            "clients",
            "clients"
        };
        String[] dbSearchColumns = {
            "Books_Id",
            "Books_Title",
            "Authors_Id",
            "Authors_Name",
            "Clients_Id",
            "Clients_Name",
        };


        String[] dbSearchIds = {
            "Books_Id",
            "Authors_Id",
            "Editor_Id",
            "Clients_Id",
        };

        String[] dbAddTables = {
            "books",
            "authors",
            "clients",
            "agents"
        };
        String[] dbAddIds = {
            "Books_Id",
            "Authors_Id",
            "Clients_Id",
            "Agent_Id"
        };
        String[] dbAddName = {
            "Books_Title",
            "Authors_Name",
            "Clients_Name",
            "Agent_Username"
        };
        
        Object bookIdFromEdit;
        int selectedRowIndex;
        Boolean editable;
    /**
     * Creates new form ContractPanel
     */
    public BooksPanel() throws Exception {
        this.setFont(new java.awt.Font("Avenir Next", 0, 13));
        initComponents();
        this.setFont(new java.awt.Font("Avenir Next", 0, 13));
        
        
        addComboBoxItems("authors", "Authors_Name", jComboBox1);
        addComboBoxItems("clients", "Clients_Name", jComboBox2);
        addComboBoxItems("agents", "Agent_Username", jComboBox3);

        

        JTableHeader headerSearch = tableSearch.getTableHeader();
        headerSearch.setBackground( new Color(190, 227, 219) );
        headerSearch.setForeground( new Color(85, 91, 110) );

        //hide ID columns
        
        TableColumn sBookId = tableSearch.getColumnModel().getColumn(0);
        sBookId.setMinWidth(0);
        sBookId.setMaxWidth(0);
        sBookId.setPreferredWidth(0);
        
        TableColumn sAuthorId = tableSearch.getColumnModel().getColumn(2);
        sAuthorId.setMinWidth(0);
        sAuthorId.setMaxWidth(0);
        sAuthorId.setPreferredWidth(0);
        
        TableColumn sClientId = tableSearch.getColumnModel().getColumn(4);
        sClientId.setMinWidth(0);
        sClientId.setMaxWidth(0);
        sClientId.setPreferredWidth(0);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneTableSearch = new javax.swing.JScrollPane();
        tableSearch = new javax.swing.JTable();
        jTextFieldContractSearch1 = new javax.swing.JTextField();
        jButtonSearchContracts1 = new javax.swing.JButton();
        addNewContract = new javax.swing.JButton();
        jButtonEditContracts = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(190, 227, 219));
        setForeground(new java.awt.Color(69, 73, 74));
        setPreferredSize(new java.awt.Dimension(714, 543));

        tableSearch.setBackground(new java.awt.Color(190, 227, 219));
        tableSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Title", "Author ID", "Author Name", "Client ID", "Client Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSearch.setColumnSelectionAllowed(true);
        tableSearch.setFocusable(false);
        tableSearch.setRowHeight(40);
        tableSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableSearchMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableSearchMouseReleased(evt);
            }
        });
        jScrollPaneTableSearch.setViewportView(tableSearch);
        tableSearch.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableSearch.getColumnModel().getColumnCount() > 0) {
            tableSearch.getColumnModel().getColumn(0).setResizable(false);
            tableSearch.getColumnModel().getColumn(1).setPreferredWidth(80);
            tableSearch.getColumnModel().getColumn(2).setPreferredWidth(40);
            tableSearch.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableSearch.getColumnModel().getColumn(4).setPreferredWidth(30);
            tableSearch.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        jTextFieldContractSearch1.setBackground(new java.awt.Color(190, 227, 219));
        jTextFieldContractSearch1.setMargin(new java.awt.Insets(2, 14, 2, 14));
        jTextFieldContractSearch1.setMinimumSize(new java.awt.Dimension(200, 22));
        jTextFieldContractSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContractSearch1ActionPerformed(evt);
            }
        });

        jButtonSearchContracts1.setBackground(new java.awt.Color(190, 227, 219));
        jButtonSearchContracts1.setText("Search");
        jButtonSearchContracts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchContracts1ActionPerformed(evt);
            }
        });

        addNewContract.setBackground(new java.awt.Color(190, 227, 219));
        addNewContract.setText("Add");
        addNewContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewContractActionPerformed(evt);
            }
        });

        jButtonEditContracts.setBackground(new java.awt.Color(190, 227, 219));
        jButtonEditContracts.setText("Edit");
        jButtonEditContracts.setToolTipText("");
        jButtonEditContracts.setEnabled(false);
        jButtonEditContracts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditContractsActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(69, 73, 74));
        jLabel1.setText("Book Title");

        jLabel2.setForeground(new java.awt.Color(69, 73, 74));
        jLabel2.setText("Author");

        jLabel3.setForeground(new java.awt.Color(69, 73, 74));
        jLabel3.setText("Client");

        jLabel4.setForeground(new java.awt.Color(69, 73, 74));
        jLabel4.setText("Agent");

        jTextField2.setText("New author");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTableSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldContractSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSearchContracts1)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEditContracts))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addNewContract, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(addNewContract, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldContractSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchContracts1)
                    .addComponent(jButtonEditContracts))
                .addGap(86, 86, 86)
                .addComponent(jScrollPaneTableSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldContractSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContractSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContractSearch1ActionPerformed

    private void jButtonSearchContracts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchContracts1ActionPerformed
        String searchString = jTextFieldContractSearch1.getText();
        String queryString;
        //if search is empty, query all contracts
        if(searchString.equals("")){
            queryString = "SELECT books.Books_Id, books.Books_Title, authors.Authors_Id, authors.Authors_Name, clients.Clients_Id, clients.Clients_Name\n" +
                "FROM ((books\n" +
                "INNER JOIN authors ON books.Authors_Authors_Id = authors.Authors_Id)\n" +
                "INNER JOIN clients ON authors.Clients_Clients_Id = clients.Clients_Id);";
        } else {
                queryString = "SELECT * FROM contract_all_info "
                + "WHERE (Books_Title LIKE '" + searchString + "%'"
                + " OR "
                + "Authors_Name LIKE '" + searchString + "%'"
                + " OR "
                + "Clients_Name LIKE '" + searchString + "%'"
                + " OR "
                + "Editor_Name LIKE '" + searchString + "%'"
                + " OR "
                + "Publisher_Name LIKE '" + searchString + "%'"
                + " OR "
                + "Agent_Username LIKE '" + searchString + "%'"
                + ");";
        }

        try {
            Connection con = Coagent.getConnection();
            PreparedStatement query = con.prepareStatement(queryString);
            ResultSet result = query.executeQuery();

            // Removing Previous Data
            while (tableSearch.getRowCount() > 0) {
                ((DefaultTableModel) tableSearch.getModel()).removeRow(0);
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
                ((DefaultTableModel) tableSearch.getModel()).insertRow(result.getRow() - 1,row);
            }

            //jTableContracts1.setValueAt("AAA", 0, 0);
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButtonSearchContracts1ActionPerformed

    private void addNewContractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewContractActionPerformed
        try {                                               
            javax.swing.JTextField source = jTextField1;
            
            ArrayList<String> selected = new ArrayList<String>();
            ArrayList<Integer> ids = new ArrayList<Integer>();
            
            Connection con = Coagent.getConnection();
            
            String title = jTextField1.getText();
            selected.add(title);
            String author;  
            if(jTextField2.getText().equals("New author")) {
                author = String.valueOf(jComboBox1.getSelectedItem());
            } else {
                author = jTextField1.getText(); 
                PreparedStatement query = con.prepareStatement("INSERT INTO authors(Authors_Name, Clients_Clients_Id) VALUES('" + author + "', (SELECT Clients_Id FROM clients WHERE Clients_Name = '" + String.valueOf(jComboBox2.getSelectedItem()) + "'));");
                System.out.println(query);
                int result = query.executeUpdate();
                System.out.println(result);
            }
            selected.add(author);
            String client = String.valueOf(jComboBox2.getSelectedItem());
            selected.add(client);
            String agent = String.valueOf(jComboBox3.getSelectedItem());
            selected.add(agent);
            
            
            for(int i = 1; i < 4; i++){

                PreparedStatement query = con.prepareStatement("SELECT " + dbAddIds[i] + " FROM " + dbAddTables[i] + " WHERE " + dbAddName[i] + " = '" + selected.get(i) + "';" );
                System.out.println(query);
                ResultSet result = query.executeQuery();
                if(result.next()) {
                    System.out.println(result.getInt(1));
                    ids.add(result.getInt(1));
                }
            }
            
            PreparedStatement query;
            int book_id = 0;
            if (addNewContract.getText().equals("Save changes")){
                /*
                query = con.prepareStatement("SELECT Books_Id FROM books WHERE Books_Title = '" + String.valueOf(bookIdFromEdit) + "';");
                System.out.println(query);
                ResultSet result = query.executeQuery();
                if(result.next()) {
                    System.out.println(result.getInt(1));
                    book_id = result.getInt(1);
                }
*/
                
                Object id = source.getText();
                query = con.prepareStatement(""
                        + "UPDATE books "
                        + "SET Books_Title = '" + title + "', "
                        + "Authors_Authors_Id = '" + ids.get(0) + "', "
                        + "Agent_Agent_Id = '" + ids.get(2)+ "' "
                        + "WHERE Books_Id = " + bookIdFromEdit + ";" );
            } else {
                //INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("Layla", 5, 5);
                query = con.prepareStatement("INSERT INTO books(Books_Title, Authors_Authors_Id, Agent_Agent_Id) VALUES('" + selected.get(0) + "', " + ids.get(0) + ", " + ids.get(1) + ");");

            }
            System.out.println(query);
            int result = query.executeUpdate();
            System.out.println(result);
            //  remove previous selection after INSERT

            if(addNewContract.getText().equals("Save changes")){
                addNewContract.setText("Add");
            }

        } catch (Exception ex) {
                Logger.getLogger(BooksPanel.class.getName()).log(Level.SEVERE, null,ex);
        }
    }//GEN-LAST:event_addNewContractActionPerformed

    private void tableSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchMousePressed

    }//GEN-LAST:event_tableSearchMousePressed

    @SuppressWarnings("unchecked")
    private void tableSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchMouseReleased
        jButtonEditContracts.setEnabled(true);
        selectedRowIndex = tableSearch.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tableSearchMouseReleased

    private void jButtonEditContractsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditContractsActionPerformed
        addNewContract.setText("Save changes");
        bookIdFromEdit = tableSearch.getModel().getValueAt(selectedRowIndex, 0);
        System.out.println("BOOK ID: " + bookIdFromEdit);
        
        Object title = tableSearch.getModel().getValueAt(selectedRowIndex, 1);
        jTextField1.setText(String.valueOf(title));

        Object author = tableSearch.getModel().getValueAt(selectedRowIndex, 3);
        jComboBox1.setSelectedItem(String.valueOf(author));

        Object client = tableSearch.getModel().getValueAt(selectedRowIndex, 5   );
        jComboBox2.setSelectedItem(String.valueOf(client));
    }//GEN-LAST:event_jButtonEditContractsActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    @SuppressWarnings("unchecked")
    private void addComboBoxItems(String table, String title, javax.swing.JComboBox comboBox) throws Exception{

        Connection con = Coagent.getConnection();
        PreparedStatement query = con.prepareStatement("SELECT " + title + " FROM " + table + ";");
        ResultSet result = query.executeQuery();

        while(result.next()){
            comboBox.addItem(result.getString(1));
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewContract;
    private javax.swing.JButton jButtonEditContracts;
    private javax.swing.JButton jButtonSearchContracts1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPaneTableSearch;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldContractSearch1;
    private javax.swing.JTable tableSearch;
    // End of variables declaration//GEN-END:variables
}
