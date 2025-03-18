/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;

import classes.Employee;
import classes.OvertimeRequest;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author STUDY MODE
 */
public class EmployeeOvertimeRequest extends javax.swing.JFrame {
    
    private String[] employeeData;
    private double overtimeHours;
    private double overtimePay;
    private String status;
    private String date;
    
    // Constructor for new overtime request
    public EmployeeOvertimeRequest(String[] employeeData) {
        this.employeeData = employeeData;
        initComponents();
    }
    
    // Default constructor (avoid errors)
    public EmployeeOvertimeRequest() {
        this.employeeData = null;
        initComponents();
    }
    
    // Constructor for updating an overtime request
    public EmployeeOvertimeRequest(String[] employeeData, String date, double overtimeHours, double overtimePay, String status) {
        this.employeeData = employeeData;
        this.date = date;
        this.overtimeHours = overtimeHours;
        this.overtimePay = overtimePay;
        this.status = status;

        initComponents();

        // Set overtime hours
        overtimejSpinner.setValue(overtimeHours);

        // Convert the date string to Date format and set it in chooseDatejDateChooser
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date formattedDate = dateFormat.parse(date);
            chooseDatejDateChooser.setDate(formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error setting date: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public EmployeeOvertimeRequest(String[] employeeData, double overtimeHours, double overtimePay, String status) {
        this.employeeData = employeeData;
        initComponents();
        overtimejSpinner.setValue(overtimeHours);
    }
    
    // Method to preload overtime hours when updating a request
    private void preloadOvertimeRequest() {
        overtimejSpinner.setValue(overtimeHours); 
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
        backButton1 = new buttons.grayButton();
        submitButton = new buttons.redButton();
        jLabel3 = new javax.swing.JLabel();
        overtimejSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        chooseDatejDateChooser = new com.toedter.calendar.JDateChooser();
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

        backButton1.setText("Back");
        backButton1.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 150, -1));

        submitButton.setText("Submit");
        submitButton.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 150, -1));

        jLabel3.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Choose Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        overtimejSpinner.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        overtimejSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));
        getContentPane().add(overtimejSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 130, -1));

        jLabel4.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Overtime Hours");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        chooseDatejDateChooser.setBackground(new java.awt.Color(204, 204, 204));
        chooseDatejDateChooser.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(chooseDatejDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Overtime Request.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        new EmployeeOvertime(this.employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        new EmployeeOvertime(this.employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_backButton1ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:      
        Employee employee = new Employee(Integer.parseInt(employeeData[0])); 
        double hourlyRate = employee.getHourlyRate();

        Number value = (Number) overtimejSpinner.getValue();
        double overtimeHours = value.doubleValue(); 

        double overtimePay = overtimeHours * hourlyRate;
        String status = "Pending";

        // Extract the selected date from jDateChooser
        Date selectedDate = chooseDatejDateChooser.getDate();
    
        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Please select a date.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convert Date to String format (YYYY-MM-DD)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(selectedDate);

        OvertimeRequest request = new OvertimeRequest(Integer.parseInt(employeeData[0]), date, overtimeHours, overtimePay, status);
        request.submitOvertimeRequest();

        JOptionPane.showMessageDialog(this, "Overtime request submitted successfully!");

        new EmployeeOvertime(employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_submitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeOvertimeRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeOvertimeRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeOvertimeRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeOvertimeRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeOvertimeRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private buttons.whiteButton backButton;
    private buttons.grayButton backButton1;
    private com.toedter.calendar.JDateChooser chooseDatejDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner overtimejSpinner;
    private buttons.redButton submitButton;
    // End of variables declaration//GEN-END:variables
}
