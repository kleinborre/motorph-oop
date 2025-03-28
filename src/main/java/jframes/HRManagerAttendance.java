/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;

import classes.Attendance;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author STUDY MODE
 */
public class HRManagerAttendance extends javax.swing.JFrame {
    
    private String[] employeeData;
    /**
     * Creates new form HRManagerAttendance
     */
    public HRManagerAttendance() {
        initComponents();
        loadAttendanceRecords(); // Load all attendance records on startup
    }
    
    public HRManagerAttendance(String[] employeeData) {
        this.employeeData = employeeData;
        initComponents();
        loadAttendanceRecords(); // Load all attendance records on startup
    }
    
    /**
     * Loads all Attendance Records into attendanceTable.
     */
    private void loadAttendanceRecords() {
        DefaultTableModel model = (DefaultTableModel) attendanceTable.getModel();
        model.setRowCount(0); // Clear existing rows

        List<String[]> attendanceRecords = Attendance.getAllAttendanceRecords();
    
        if (attendanceRecords.isEmpty()) {
            System.out.println("No attendance records found!");
            return;
        }

        for (String[] record : attendanceRecords) {
            if (record.length >= 6) {
                model.addRow(new Object[]{
                    record[0], // Employee Number
                    record[1], // Last Name
                    record[2], // First Name
                    record[3], // Date
                    record[4], // Log In
                    record[5]  // Log Out
                });
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

        backButton = new buttons.whiteButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        searchBar = new javax.swing.JTextField();
        refreshButton = new buttons.grayButton();
        jLabel2 = new javax.swing.JLabel();
        searchButton1 = new buttons.grayButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MotorPH Payroll System");
        setMaximumSize(new java.awt.Dimension(960, 540));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setText("Back");
        backButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 110, 40));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        attendanceTable.setBackground(new java.awt.Color(204, 204, 204));
        attendanceTable.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        attendanceTable.setForeground(new java.awt.Color(51, 51, 51));
        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee Number", "Last Name", "First Name", "Date", "Log In", "Log Out"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(attendanceTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 830, 360));

        searchBar.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        getContentPane().add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 120, 30));

        refreshButton.setText("Refresh");
        refreshButton.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        getContentPane().add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 110, 30));

        jLabel2.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Enter Employee No. / Last Name / First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, 30));

        searchButton1.setText("Search");
        searchButton1.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        searchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/HR Manager Attendance Record.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        new HRManagerPage(employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        loadAttendanceRecords();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton1ActionPerformed
        String searchTerm = searchBar.getText().trim();

        if (searchTerm.isEmpty()) {
            loadAttendanceRecords();
            return;
        }

        DefaultTableModel model = (DefaultTableModel) attendanceTable.getModel();
        model.setRowCount(0); // Clear previous results

        List<String[]> filteredRecords = Attendance.searchAttendanceRecords(searchTerm);

        if (filteredRecords.isEmpty()) {
            System.out.println("No matching records found for: " + searchTerm);
            return;
        }

        for (String[] record : filteredRecords) {
            if (record.length >= 6) {
                model.addRow(new Object[]{
                    record[0], // Employee Number
                    record[1], // Last Name
                    record[2], // First Name
                    record[3], // Date
                    record[4], // Log In
                    record[5]  // Log Out
                });
            }
        }
    }//GEN-LAST:event_searchButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(HRManagerAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HRManagerAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HRManagerAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HRManagerAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HRManagerAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendanceTable;
    private buttons.whiteButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private buttons.grayButton refreshButton;
    private javax.swing.JTextField searchBar;
    private buttons.grayButton searchButton1;
    // End of variables declaration//GEN-END:variables
}
