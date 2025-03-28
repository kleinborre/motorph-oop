/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;

import classes.SystemAdministrator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author STUDY MODE
 */
public class SystemAdministratorPage extends javax.swing.JFrame {
    
    private String[] employeeData;
    /**
     * Creates new form SystemAdministratorPage
     */
    public SystemAdministratorPage() {
        initComponents();
        loadUserData(); // Load CSV data into userAccountTable
    }
    
    public SystemAdministratorPage(String[] employeeData) {
        this.employeeData = employeeData;
        initComponents();
        loadUserData();
    }
    
    void loadUserData() {
        SystemAdministrator admin = new SystemAdministrator(0, "", "", "");
        String[][] allData = admin.getAllUsers(); // 22-column joined data
        
        // Prepare a new array with 20 columns (skipping username and password)
        String[][] userData = new String[allData.length][20];
        for (int i = 0; i < allData.length; i++) {
            // Copy columns 0 to 18 (Employee #, Last Name, First Name, Birthday, Address, Phone Number, SSS #, Philhealth #, Pag-ibig #, TIN #, Status, Position, Immediate Supervisor, Basic Salary, Rice Subsidy, Phone Allowance, Clothing Allowance, Gross Semi-monthly Rate, Hourly Rate)
            for (int j = 0; j < 19; j++) {
                userData[i][j] = allData[i][j];
            }
            // Set column 19 to the Role (which is in column index 21 of the joined data)
            userData[i][19] = allData[i][21];
        }
        
        // Updated header (20 columns)
        String[] columnHeaders = {
            "Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number",
            "SSS #", "Philhealth #", "Pag-ibig #", "TIN #", "Status", "Position",
            "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance",
            "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate", "Role"
        };
        
        DefaultTableModel model = new DefaultTableModel(userData, columnHeaders) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        userAccountTable.setModel(model);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new buttons.whiteButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userAccountTable = new javax.swing.JTable();
        createButton = new buttons.redButton();
        jLabel1 = new javax.swing.JLabel();
        employeeRoleButton = new buttons.grayButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MotorPH Payroll System");
        setMaximumSize(new java.awt.Dimension(960, 540));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutButton.setText("Logout");
        logoutButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 110, 40));

        jScrollPane1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N

        userAccountTable.setBackground(new java.awt.Color(204, 204, 204));
        userAccountTable.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        userAccountTable.setForeground(new java.awt.Color(51, 51, 51));
        userAccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee #", "First Name", "Last Name", "Birthday", "Address", "Phone Number", "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position", "Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Gross Semi-Monthly Rate", "Hourly Rate", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userAccountTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        userAccountTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userAccountTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        userAccountTable.setShowGrid(false);
        userAccountTable.getTableHeader().setReorderingAllowed(false);
        userAccountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userAccountTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userAccountTable);
        if (userAccountTable.getColumnModel().getColumnCount() > 0) {
            userAccountTable.getColumnModel().getColumn(0).setResizable(false);
            userAccountTable.getColumnModel().getColumn(0).setHeaderValue("Employee #");
            userAccountTable.getColumnModel().getColumn(1).setResizable(false);
            userAccountTable.getColumnModel().getColumn(1).setHeaderValue("First Name");
            userAccountTable.getColumnModel().getColumn(2).setResizable(false);
            userAccountTable.getColumnModel().getColumn(2).setHeaderValue("Last Name");
            userAccountTable.getColumnModel().getColumn(3).setResizable(false);
            userAccountTable.getColumnModel().getColumn(3).setHeaderValue("Birthday");
            userAccountTable.getColumnModel().getColumn(4).setResizable(false);
            userAccountTable.getColumnModel().getColumn(4).setHeaderValue("Address");
            userAccountTable.getColumnModel().getColumn(5).setResizable(false);
            userAccountTable.getColumnModel().getColumn(5).setHeaderValue("Phone Number");
            userAccountTable.getColumnModel().getColumn(6).setResizable(false);
            userAccountTable.getColumnModel().getColumn(6).setHeaderValue("SSS #");
            userAccountTable.getColumnModel().getColumn(7).setResizable(false);
            userAccountTable.getColumnModel().getColumn(7).setHeaderValue("Philhealth #");
            userAccountTable.getColumnModel().getColumn(8).setResizable(false);
            userAccountTable.getColumnModel().getColumn(8).setHeaderValue("TIN #");
            userAccountTable.getColumnModel().getColumn(9).setResizable(false);
            userAccountTable.getColumnModel().getColumn(9).setHeaderValue("Pag-ibig #");
            userAccountTable.getColumnModel().getColumn(10).setResizable(false);
            userAccountTable.getColumnModel().getColumn(10).setHeaderValue("Status");
            userAccountTable.getColumnModel().getColumn(11).setResizable(false);
            userAccountTable.getColumnModel().getColumn(11).setHeaderValue("Position");
            userAccountTable.getColumnModel().getColumn(12).setResizable(false);
            userAccountTable.getColumnModel().getColumn(12).setHeaderValue("Supervisor");
            userAccountTable.getColumnModel().getColumn(13).setResizable(false);
            userAccountTable.getColumnModel().getColumn(13).setHeaderValue("Basic Salary");
            userAccountTable.getColumnModel().getColumn(14).setResizable(false);
            userAccountTable.getColumnModel().getColumn(14).setHeaderValue("Rice Subsidy");
            userAccountTable.getColumnModel().getColumn(15).setResizable(false);
            userAccountTable.getColumnModel().getColumn(15).setHeaderValue("Phone Allowance");
            userAccountTable.getColumnModel().getColumn(16).setResizable(false);
            userAccountTable.getColumnModel().getColumn(16).setHeaderValue("Clothing Allowance");
            userAccountTable.getColumnModel().getColumn(17).setResizable(false);
            userAccountTable.getColumnModel().getColumn(17).setHeaderValue("Gross Semi-Monthly Rate");
            userAccountTable.getColumnModel().getColumn(18).setResizable(false);
            userAccountTable.getColumnModel().getColumn(18).setHeaderValue("Hourly Rate");
            userAccountTable.getColumnModel().getColumn(19).setResizable(false);
            userAccountTable.getColumnModel().getColumn(19).setHeaderValue("Role");
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 840, 350));

        createButton.setText("Create New User");
        createButton.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 180, -1));

        jLabel1.setFont(new java.awt.Font("Inter", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("(Clicked the table to update or delete a user.)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, -1, -1));

        employeeRoleButton.setText("Switch to Employee Role");
        employeeRoleButton.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        employeeRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeRoleButtonActionPerformed(evt);
            }
        });
        getContentPane().add(employeeRoleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Admin Dashboard.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Do you really want to log out of your session?",
            "MotorPH Payroll System - Confirm Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        new SystemAdministratorCreateUser(employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_createButtonActionPerformed

    private void userAccountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userAccountTableMouseClicked
        int row = userAccountTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "No row selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] selectedUser = new String[userAccountTable.getColumnCount()];
        for (int i = 0; i < selectedUser.length; i++) {
            Object cellValue = userAccountTable.getValueAt(row, i);
            selectedUser[i] = (cellValue != null) ? cellValue.toString() : "";
        }

        String empNumber = selectedUser[0];

        int choice = JOptionPane.showOptionDialog(
            this,
            "Do you want to UPDATE or DELETE this user?",
            "User Action",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Update", "Delete"},
            "Update"
        );

        if (choice == 0) { // Update
            SystemAdministratorUpdateUser updateUserFrame = new SystemAdministratorUpdateUser(selectedUser, employeeData);
            updateUserFrame.setVisible(true);
            this.dispose();

            updateUserFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    SystemAdministratorPage adminPage = new SystemAdministratorPage(employeeData);
                    adminPage.setVisible(true);
                }
            });

        } else if (choice == 1) { // Delete
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                SystemAdministrator admin = new SystemAdministrator(0, "", "", "");
                admin.deleteUser(empNumber);
                loadUserData();  // Refresh table
            }
        }
    }//GEN-LAST:event_userAccountTableMouseClicked

    private void employeeRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeRoleButtonActionPerformed
        if (employeeData != null) {
            new EmployeePage(employeeData).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_employeeRoleButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SystemAdministratorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemAdministratorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemAdministratorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemAdministratorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemAdministratorPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private buttons.redButton createButton;
    private buttons.grayButton employeeRoleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private buttons.whiteButton logoutButton;
    private javax.swing.JTable userAccountTable;
    // End of variables declaration//GEN-END:variables
}
