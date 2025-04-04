/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;

import classes.Attendance;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author STUDY MODE
 */
public class EmployeePage extends javax.swing.JFrame {
    
    private String[] employeeData; // Store employee details
    

    /**
     * Creates new form EmployeePage
     */
    public EmployeePage() {
        this.employeeData = new String[22]; // Ensure it has 22 empty values
        initComponents();
        populateEmployeeInfo();
        employeeRoleButton.setEnabled(isSpecialRoleUser());
        startRealTimeClock();
        setupFilters();
        updateAttendanceTable(-1, -1); // Load all records initially
        updateClockButtons();
    }
    
    public EmployeePage(String[] employeeData) {
        this.employeeData = employeeData;
        initComponents();
        populateEmployeeInfo();
        employeeRoleButton.setEnabled(isSpecialRoleUser());
        startRealTimeClock();
        setupFilters();
        updateAttendanceTable(-1, -1); // Load all records initially
        updateClockButtons();
    }
    
    // Method to populate employee information on the GUI
    private void populateEmployeeInfo() {
        if (employeeData == null || employeeData.length != 22) {
            System.out.println("Error: Incorrect employee data format.");
            return;
        }

        nameProfileLabel.setText(employeeData[2] + " " + employeeData[1]);
        positionProfileLabel.setText(employeeData[11]);
    }
    
    private void startRealTimeClock() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now(); 
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
                dateTimeProfileLabel.setText(now.format(formatter)); 
            }
        });
        timer.start();
    }
    
    private void setupFilters() {
        // Month chooser listener
        jMonthChooser1.addPropertyChangeListener("month", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateAttendanceTable(jMonthChooser1.getMonth() + 1, jYearChooser.getYear());
            }
        });

        // Year chooser listener
        jYearChooser.addPropertyChangeListener("year", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateAttendanceTable(jMonthChooser1.getMonth() + 1, jYearChooser.getYear());
            }
        });

        // Refresh button to show all records
        refreshTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAttendanceTable(-1, -1); // Load all records
            }
        });
    }
    
    // Fetch and display attendance records
    private void updateAttendanceTable(int month, int year) {
        int employeeNumber = Integer.parseInt(employeeData[0]);
        List<String[]> records = Attendance.getEmployeeAttendance(employeeNumber, month, year);

        DefaultTableModel model = (DefaultTableModel) attendanceTable.getModel();
        model.setRowCount(0); // Clear table

        for (String[] record : records) {
            model.addRow(new Object[]{
                record[3], // Date
                record[4], // Log In
                record[5]  // Log Out
            });
        }
    }
    
    private void updateClockButtons() {
    LocalDate today = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String formattedDate = today.format(dateFormatter);

    int employeeNumber = Integer.parseInt(employeeData[0]);
    List<String[]> records = Attendance.getEmployeeAttendance(employeeNumber, -1, -1);

    boolean hasClockedIn = false;
    boolean hasClockedOut = false;

    for (String[] record : records) {
        if (record[3].equals(formattedDate)) {
            if (!record[4].equals("N/A")) hasClockedIn = true; // Valid Clock-In
            if (!record[5].equals("N/A")) hasClockedOut = true; // Valid Clock-Out
            break;
        }
    }

    // Set button states correctly
    clockInButton.setEnabled(!hasClockedIn);
    clockoutButton.setEnabled(hasClockedIn && !hasClockedOut);
    }    
    
    private boolean isSpecialRoleUser() {
        if (employeeData == null || employeeData.length < 22) return false;

        String[] roles = employeeData[21].toLowerCase().split("\\|");
        for (String role : roles) {
            if (!role.equals("employee")) {
                return true; // has a special role
            }
        }
        return false; // employee-only
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileInformationButton = new buttons.redButton();
        leaveRequestButton = new buttons.redButton();
        overtimeRequestButton = new buttons.redButton();
        payslipButton = new buttons.redButton();
        nameProfileLabel = new javax.swing.JLabel();
        positionProfileLabel = new javax.swing.JLabel();
        logoutButton = new buttons.whiteButton();
        clockInButton = new buttons.grayButton();
        clockoutButton = new buttons.grayButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        dateTimeProfileLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser = new com.toedter.calendar.JYearChooser();
        jLabel4 = new javax.swing.JLabel();
        refreshTableButton = new buttons.grayButton();
        employeeRoleButton = new buttons.grayButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MotorPH Payroll System");
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setName("employeePage"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profileInformationButton.setText("Profile Info");
        profileInformationButton.setAlignmentY(0.0F);
        profileInformationButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        profileInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileInformationButtonActionPerformed(evt);
            }
        });
        getContentPane().add(profileInformationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 160, 40));

        leaveRequestButton.setText("Leave");
        leaveRequestButton.setAlignmentY(0.0F);
        leaveRequestButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        leaveRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveRequestButtonActionPerformed(evt);
            }
        });
        getContentPane().add(leaveRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 160, 40));

        overtimeRequestButton.setText("Overtime");
        overtimeRequestButton.setAlignmentY(0.0F);
        overtimeRequestButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        overtimeRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overtimeRequestButtonActionPerformed(evt);
            }
        });
        getContentPane().add(overtimeRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 160, 40));

        payslipButton.setText("Payslip");
        payslipButton.setAlignmentY(0.0F);
        payslipButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        payslipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payslipButtonActionPerformed(evt);
            }
        });
        getContentPane().add(payslipButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 160, 40));

        nameProfileLabel.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        nameProfileLabel.setForeground(new java.awt.Color(102, 102, 102));
        nameProfileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameProfileLabel.setText("Name");
        getContentPane().add(nameProfileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 230, 140, -1));

        positionProfileLabel.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        positionProfileLabel.setForeground(new java.awt.Color(102, 102, 102));
        positionProfileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        positionProfileLabel.setText("Position");
        positionProfileLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(positionProfileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 200, -1));

        logoutButton.setText("Logout");
        logoutButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 110, 40));

        clockInButton.setText("Clock-In");
        clockInButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        clockInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockInButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clockInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 130, -1));

        clockoutButton.setText("Clock-out");
        clockoutButton.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        clockoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clockoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 130, -1));

        attendanceTable.setBackground(new java.awt.Color(204, 204, 204));
        attendanceTable.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        attendanceTable.setForeground(new java.awt.Color(51, 51, 51));
        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Log In", "Log Out"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(attendanceTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 640, 140));

        dateTimeProfileLabel.setFont(new java.awt.Font("Inter", 0, 48)); // NOI18N
        dateTimeProfileLabel.setForeground(new java.awt.Color(102, 102, 102));
        dateTimeProfileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateTimeProfileLabel.setText("Date & Time");
        dateTimeProfileLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(dateTimeProfileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 610, -1));

        jLabel1.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Attendance Record");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 170, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Year:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, -1, 30));

        jMonthChooser1.setForeground(new java.awt.Color(51, 51, 51));
        jMonthChooser1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(jMonthChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, 30));
        getContentPane().add(jYearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 70, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Month:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, 30));

        refreshTableButton.setForeground(new java.awt.Color(51, 51, 51));
        refreshTableButton.setText("Refresh");
        refreshTableButton.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        getContentPane().add(refreshTableButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 100, 30));

        employeeRoleButton.setText("Switch to Special Role");
        employeeRoleButton.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        employeeRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeRoleButtonActionPerformed(evt);
            }
        });
        getContentPane().add(employeeRoleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Employee Dashboard.png"))); // NOI18N
        background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void profileInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileInformationButtonActionPerformed
        // TODO add your handling code here:
        new EmployeeProfileInformation(employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_profileInformationButtonActionPerformed

    private void leaveRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveRequestButtonActionPerformed
        // TODO add your handling code here:
        new EmployeeLeave(employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_leaveRequestButtonActionPerformed

    private void overtimeRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overtimeRequestButtonActionPerformed
        // TODO add your handling code here:
        new EmployeeOvertime(employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_overtimeRequestButtonActionPerformed

    private void payslipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payslipButtonActionPerformed
        // TODO add your handling code here:
        new EmployeePayslip(employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_payslipButtonActionPerformed

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

    private void clockInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockInButtonActionPerformed
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(dateFormatter);
        String formattedTime = now.format(timeFormatter);

        int employeeNumber = Integer.parseInt(employeeData[0]);

        // Load latest attendance records from CSV
        List<String[]> records = Attendance.getAllAttendanceRecords();

        // Strict check to prevent duplicate entry
        for (String[] record : records) {
            if (record[0].equals(String.valueOf(employeeNumber)) && record[3].equals(formattedDate)) {
                System.out.println("Already clocked in!");
                return; // Prevent duplicate entry
            }
        }

        // Disable Clock-In button immediately to reflect UI changes
        clockInButton.setEnabled(false);
        clockoutButton.setEnabled(true);

        // Append a single Clock-In record to CSV
        String[] newRecord = { String.valueOf(employeeNumber), employeeData[1], employeeData[2], formattedDate, formattedTime, "N/A" };
        Attendance.appendToCSV(newRecord);

        // Force UI update before CSV is written
        updateAttendanceTable(-1, -1);
    }//GEN-LAST:event_clockInButtonActionPerformed

    private void clockoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockoutButtonActionPerformed
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(dateFormatter);
        String formattedTime = now.format(timeFormatter);

        int employeeNumber = Integer.parseInt(employeeData[0]);

        // Load latest attendance records from CSV
        List<String[]> records = Attendance.getAllAttendanceRecords();

        boolean clockOutSuccess = false;
        int updateIndex = -1;

        // Find the latest "N/A" logout entry for today
        for (int i = records.size() - 1; i >= 0; i--) {
            String[] record = records.get(i);

            if (record[0].equals(String.valueOf(employeeNumber)) && record[3].equals(formattedDate) && record[5].equals("N/A")) {
                record[5] = formattedTime;  // ✅ Update the logout time
                updateIndex = i;
                clockOutSuccess = true;
                break;
            }
        }

        if (clockOutSuccess) {
            // Ensure we're only modifying the Attendance CSV (not Employee Details)
            Attendance attendance = new Attendance();
            attendance.writeCSV("src/main/java/databases/Attendance Records.csv", records);

            // Refresh UI without affecting login behavior
            updateClockButtons();
            updateAttendanceTable(-1, -1);
            System.out.println("Clock-Out successful.");
        } else {
            System.out.println("Clock-Out failed: No matching Clock-In found or already clocked out.");
        }
    }//GEN-LAST:event_clockoutButtonActionPerformed

    private void employeeRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeRoleButtonActionPerformed
        String[] roles = employeeData[21].toLowerCase().split("\\|");

        for (String role : roles) {
            if (!role.equals("employee")) {
                switch (role) {
                    case "hrmanager":
                        new HRManagerPage(employeeData).setVisible(true);
                        break;
                    case "payrollmanager":
                        new PayrollManagerPage(employeeData).setVisible(true);
                        break;
                    case "systemadministrator":
                        new SystemAdministratorPage(employeeData).setVisible(true);
                        break;
                }
                dispose();
                return;
            }
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
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendanceTable;
    private javax.swing.JLabel background;
    private buttons.grayButton clockInButton;
    private buttons.grayButton clockoutButton;
    private javax.swing.JLabel dateTimeProfileLabel;
    private buttons.grayButton employeeRoleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYearChooser;
    private buttons.redButton leaveRequestButton;
    private buttons.whiteButton logoutButton;
    private javax.swing.JLabel nameProfileLabel;
    private buttons.redButton overtimeRequestButton;
    private buttons.redButton payslipButton;
    private javax.swing.JLabel positionProfileLabel;
    private buttons.redButton profileInformationButton;
    private buttons.grayButton refreshTableButton;
    // End of variables declaration//GEN-END:variables
}
