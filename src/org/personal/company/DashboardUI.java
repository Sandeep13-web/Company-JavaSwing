package org.personal.company;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DashboardUI extends javax.swing.JFrame {
    //file path
    public static File file = new File("company.csv");

    public static final DaoCompany companyDao = new DaoImplCompany();

    private final String[] attributes = new String[]{"Company Name", "Company Address", 
        "Company Tel. No.", "Company Web Address"};
    private final DefaultTableModel model = new DefaultTableModel();

    public DashboardUI() throws FileNotFoundException{
        initComponents();
        setUpTableModel();
        findAll();
        
    }
    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    private void setUpTableModel() {
        companyTable.setModel(model);
        model.setColumnIdentifiers(attributes);
    }

    private void remove() {
        int selectedRow = companyTable.getSelectedRow();
        if (selectedRow != -1) {
            String companyName = (String) companyTable.getValueAt(selectedRow, 0);

            Company com = companyDao.findOne(companyName);
            if (com != null) {
                int rowCount = companyDao.remove(com.getName());
                if (rowCount >= 1) {
                    showMessageDialog("Company details sucessfully deleted!");
                    findAll();
                }
            }

        } else {
            showMessageDialog("Please select a company to remove!");
        }
    }

    
    private void save() throws  HeadlessException{
        Company company = getDetails();
        if (companyNameTextField.getCaretPosition() <= 0 || companyAddressTextField.getCaretPosition() <= 0 ||
                companyContactTextField.getCaretPosition() <= 0 ||
                companyWebAddTextField.getCaretPosition() <= 0) {
            showMessageDialog("Please fill all the fields.");
        } else {
            companyDao.add(company);
            findAll();
            resetForm();
            showMessageDialog("Company data sucessfully added!");
        }
    }
    private Company getDetails() {
        Company company;
        String cName = companyNameTextField.getText();
        String cAddress = companyAddressTextField.getText();
        String cContact = companyContactTextField.getText();
        String cEmail = companyWebAddTextField.getText();
        if (cName == null || cAddress == null || cContact == null || cEmail == null) {
            company = null;
        } else {
            company = new Company(cName, cAddress, cContact, cEmail);
        }
        return company;
    }
    
    
    private void resetForm() {
        companyNameTextField.setText("");
        companyAddressTextField.setText("");
        companyContactTextField.setText("");
        companyWebAddTextField.setText("");
    }
    
    private void findAll(){
        model.setRowCount(0);
        Map<String, Company> Company = companyDao.findAll();
        for (Map.Entry<String, Company> companyOne : Company.entrySet()) {
            if (companyOne.getKey() != null) {
                Company com = companyOne.getValue();
                Object[] row = {
                    companyOne.getKey(),
                    com.getAddress(),
                    com.getContact(),
                    com.getEmail()
                };
                model.addRow(row);
            }
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

        userInputLabel = new javax.swing.JPanel();
        companyNameLabel = new javax.swing.JLabel();
        companyNameTextField = new javax.swing.JTextField();
        companyContactLabel = new javax.swing.JLabel();
        companyAddressLabel = new javax.swing.JLabel();
        companyAddressTextField = new javax.swing.JTextField();
        companyContactTextField = new javax.swing.JTextField();
        companyWebAddLabel = new javax.swing.JLabel();
        companyWebAddTextField = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        companyTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Company Listing");

        companyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        companyNameLabel.setText("Company Name");

        companyNameTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        companyNameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        companyNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyNameTextFieldActionPerformed(evt);
            }
        });

        companyContactLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        companyContactLabel.setText("Company Tel. No.");

        companyAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        companyAddressLabel.setText("Company Address");

        companyAddressTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        companyAddressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyAddressTextFieldActionPerformed(evt);
            }
        });

        companyContactTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        companyContactTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyContactTextFieldActionPerformed(evt);
            }
        });

        companyWebAddLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        companyWebAddLabel.setText("Company Web Address");

        companyWebAddTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        companyWebAddTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyWebAddTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userInputLabelLayout = new javax.swing.GroupLayout(userInputLabel);
        userInputLabel.setLayout(userInputLabelLayout);
        userInputLabelLayout.setHorizontalGroup(
            userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInputLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companyNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyAddressLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyContactLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyWebAddLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companyWebAddTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(companyNameTextField)
                    .addComponent(companyAddressTextField)
                    .addComponent(companyContactTextField))
                .addContainerGap())
        );
        userInputLabelLayout.setVerticalGroup(
            userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInputLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyContactLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyContactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(userInputLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyWebAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyWebAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Remove");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        companyTable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        companyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        companyTable.setIntercellSpacing(new java.awt.Dimension(1, 5));
        companyTable.setMaximumSize(new java.awt.Dimension(2147483647, 140));
        companyTable.setMinimumSize(new java.awt.Dimension(60, 140));
        companyTable.setPreferredSize(new java.awt.Dimension(300, 140));
        companyTable.setRowHeight(35);
        jScrollPane1.setViewportView(companyTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void companyNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyNameTextFieldActionPerformed

    private void companyAddressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyAddressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyAddressTextFieldActionPerformed

    private void companyContactTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyContactTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyContactTextFieldActionPerformed

    private void companyWebAddTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyWebAddTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyWebAddTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        save();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        remove();
    }//GEN-LAST:event_deleteButtonActionPerformed

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (InstantiationException ex) {
            System.out.println(ex);
        } catch (IllegalAccessException ex) {
            System.out.println(ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DashboardUI().setVisible(true);
                } catch (FileNotFoundException ex) {
                    System.out.println(ex);
                }
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel companyAddressLabel;
    private javax.swing.JTextField companyAddressTextField;
    private javax.swing.JLabel companyContactLabel;
    private javax.swing.JTextField companyContactTextField;
    private javax.swing.JLabel companyNameLabel;
    private javax.swing.JTextField companyNameTextField;
    private javax.swing.JTable companyTable;
    private javax.swing.JLabel companyWebAddLabel;
    private javax.swing.JTextField companyWebAddTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel userInputLabel;
    // End of variables declaration//GEN-END:variables

    
    
}