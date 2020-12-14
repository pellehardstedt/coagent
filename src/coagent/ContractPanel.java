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
public class ContractPanel extends javax.swing.JPanel {
        String[] dbSearchTables = {
            "contracts",
            "books",
            "authors",
            "clients",
            "editors",
            "publishers",
            "agents"
        };
        String[] dbSearchColumns = {
            "Contract_Id",
            "Books_title",
            "Authors_Name",
            "Clients_Name",
            "Editor_Name",
            "Publisher_Name",
            "Agent_Username"
        };


        String[] dbSearchIds = {
            "Contract_Id",
            "Books_Id",
            "Authors_Id",
            "Clients_Dd",
            "Editor_Id",
            "Publisher_Id",
            "Agent_Id"
        };

        String[] dbAddTables = {
            "contracts",
            "books",
            "editors",
            "publishers"
        };
        String[] dbAddColumns = {
            "Contract_Id",
            "Books_title",
            "Editor_Name",
            "Publisher_Name"
        };

        String[] dbAddIds = {
            "Contract_Id",
            "Books_Id",
            "Editor_Id",
            "Publisher_Id"
        };
        int selectedRowIndex;
        Boolean editable;
    /**
     * Creates new form ContractPanel
     */
    public ContractPanel() throws Exception {
        this.setFont(new java.awt.Font("Avenir Next", 0, 13));
        initComponents();
        this.setFont(new java.awt.Font("Avenir Next", 0, 13));
        
        for (int i = 1; i < dbAddTables.length; i++) {
            addComboBoxItems(dbAddTables[i], dbAddColumns[i], i, tableAdd);
        }

        for (int i = 1; i < dbSearchTables.length; i++) {
            addComboBoxItems(dbSearchTables[i], dbSearchColumns[i], i, tableSearch);
        }

        JTableHeader headerAdd = tableAdd.getTableHeader();
        headerAdd.setBackground( new Color(190, 227, 219) );
        headerAdd.setForeground( new Color(85, 91, 110) );

        JTableHeader headerSearch = tableSearch.getTableHeader();
        headerSearch.setBackground( new Color(190, 227, 219) );
        headerSearch.setForeground( new Color(85, 91, 110) );

        //hide ID columns
        TableColumn searchIdC = tableSearch.getColumnModel().getColumn(0);
        searchIdC.setMinWidth(0);
        searchIdC.setMaxWidth(0);
        searchIdC.setPreferredWidth(0);
        TableColumn addIdC = tableAdd.getColumnModel().getColumn(0);
        addIdC.setMinWidth(0);
        addIdC.setMaxWidth(0);
        addIdC.setPreferredWidth(0);
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
        jScrollPaneTableAdd = new javax.swing.JScrollPane();
        tableAdd = new javax.swing.JTable();
        addNewContract = new javax.swing.JButton();
        jButtonEditContracts = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 249, 249));
        setPreferredSize(new java.awt.Dimension(714, 543));

        tableSearch.setBackground(new java.awt.Color(190, 227, 219));
        tableSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Title", "Author", "Client", "Editor", "Publisher", "Agent"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            tableSearch.getColumnModel().getColumn(6).setPreferredWidth(30);
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

        tableAdd.setBackground(new java.awt.Color(190, 227, 219));
        tableAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Id", "Book", "Editor", "Publisher"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableAdd.setToolTipText("");
        jScrollPaneTableAdd.setViewportView(tableAdd);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTableSearch)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldContractSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSearchContracts1)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditContracts)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneTableAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNewContract, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldContractSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchContracts1)
                    .addComponent(jButtonEditContracts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTableSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addNewContract, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(jScrollPaneTableAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(162, Short.MAX_VALUE))
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
            queryString = "SELECT * FROM contract_all_info_with_ID;";
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

        ArrayList<String> selected = new ArrayList<String>();
        selected.add("empty");
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for(int i = 1; i < 4; i++){

            selected.add(String.valueOf(tableAdd.getModel().getValueAt(0, i)));
            System.out.println(selected.get(i));
            try {
                Connection con = Coagent.getConnection();
                PreparedStatement query = con.prepareStatement("SELECT " + dbAddIds[i] + " FROM " + dbAddTables[i] + " WHERE " + dbAddColumns[i] + " = '" + selected.get(i) + "';" );
                System.out.println(query);
                ResultSet result = query.executeQuery();
                System.out.println("before result.next");
                if(result.next()) {
                    System.out.println("inside result.next");
                    System.out.println(result.getInt(1));
                    ids.add(result.getInt(1));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        try {
            Connection con = Coagent.getConnection();
            PreparedStatement query = query = con.prepareStatement("INSERT INTO contracts(Books_Books_Id, Editor_Editor_Id, Publisher_Publisher_Id) VALUES(" + ids.get(0) + ", " + ids.get(1) + ", " + ids.get(2) + ");");

            if (addNewContract.getText().equals("Save changes")){
                Object id = tableAdd.getModel().getValueAt(0, 0);
                query = con.prepareStatement(""
                        + "UPDATE contracts "
                        + "SET Books_Books_Id = '" + ids.get(0) + "', "
                        + "Editor_Editor_Id = '" + ids.get(1) + "', "
                        + "Publisher_Publisher_Id = '" + ids.get(2)+ "' "
                        + "WHERE Contract_Id = " + id + ";" );
            } else {
                query = con.prepareStatement("INSERT INTO contracts(Books_Books_Id, Editor_Editor_Id, Publisher_Publisher_Id) VALUES(" + ids.get(0) + ", " + ids.get(1) + ", " + ids.get(2) + ");");
            }
            System.out.println(query);
            int result = query.executeUpdate();
            System.out.println(result);
            //remove previous selection after INSERT
            TableModel tableAddModel = tableAdd.getModel();
            for(int i = 0; i < 4; i++) {
                tableAddModel.setValueAt("", 0, i);
            }
            if(addNewContract.getText().equals("Save changes")){
                addNewContract.setText("Add");
            }
        } catch (Exception e) {
            System.out.println(e);
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
        Integer[] columnIndexes = {0,1,4,5};
        for (int i = 0; i < 4; i++) {
            Object value = tableSearch.getModel().getValueAt(selectedRowIndex, columnIndexes[i]);
            tableAdd.getModel().setValueAt(value, 0, i);
            System.out.println(tableAdd.getModel().getValueAt(0, i));
        }


    }//GEN-LAST:event_jButtonEditContractsActionPerformed
    @SuppressWarnings("unchecked")
    private void addComboBoxItems(String table, String title, int columnNumber, javax.swing.JTable tableComponent) throws Exception{
        TableColumn column = tableComponent.getColumnModel().getColumn(columnNumber);
        JComboBox comboBox = new JComboBox();
        Connection con = Coagent.getConnection();
        PreparedStatement query = con.prepareStatement("SELECT " + title + " FROM " + table + ";");
        ResultSet result = query.executeQuery();

        while(result.next()){
            comboBox.addItem(result.getString(1));
        }
        column.setCellEditor(new DefaultCellEditor(comboBox));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewContract;
    private javax.swing.JButton jButtonEditContracts;
    private javax.swing.JButton jButtonSearchContracts1;
    private javax.swing.JScrollPane jScrollPaneTableAdd;
    private javax.swing.JScrollPane jScrollPaneTableSearch;
    private javax.swing.JTextField jTextFieldContractSearch1;
    private javax.swing.JTable tableAdd;
    private javax.swing.JTable tableSearch;
    // End of variables declaration//GEN-END:variables
}
