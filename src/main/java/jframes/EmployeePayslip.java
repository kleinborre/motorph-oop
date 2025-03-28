/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;

import classes.Payslip;
import classes.Employee;

/**
 *
 * @author STUDY MODE
 */
public class EmployeePayslip extends javax.swing.JFrame {
    
    private Payslip payslip;
    private Employee employee;
    private String[] employeeData; // Holds authenticated user details

    /**
     * Creates new form EmployeePayslip for a specific employee.
     */
    public EmployeePayslip(String[] employeeData) {
        this.employeeData = employeeData;
        initComponents();

        // Initialize with the current month/year from the choosers
        int employeeNumber = Integer.parseInt(employeeData[0]);
        int selectedMonth = payslipMonthChooser.getMonth() + 1;
        int selectedYear = jYearChooser.getYear();

        // Create the Payslip and Employee objects
        this.employee = new Employee(employeeNumber);
        this.payslip = new Payslip(employeeNumber, selectedMonth, selectedYear);

        // Fill in the UI fields
        updatePayslipDetails();
        addListeners();
    }

    /**
     * For GUI Builder testing only (no real data).
     */
    public EmployeePayslip() {
        initComponents();
    }


    /**
    * Updates the UI text fields with the latest Payslip calculations.
    */
    private void updatePayslipDetails() {
        // Pull the current month/year from the UI
        int selectedMonth = payslipMonthChooser.getMonth() + 1;
        int selectedYear = jYearChooser.getYear();

        // Update the Payslip with new month and year
        payslip.updatePayslip(selectedMonth, selectedYear);

        // **Process calculations to reflect in UI**
        payslip.processAttendance();
        payslip.processOvertime();
        payslip.calculateGrossSalary();
        payslip.calculateDeductions();
        payslip.calculateNetSalary();

        // **Start/End Date**
        startDateText.setText(payslip.getStartDate().equals("No Records") ? "No records" : payslip.getStartDate());
        endDateText.setText(payslip.getEndDate().equals("No Records") ? "No records" : payslip.getEndDate());

        basicSalaryText.setText(String.format("₱ %.2f", payslip.getComputedBasicSalary()));
        hourlyRateText.setText(String.format("₱ %.2f", employee.getHourlyRate()));

        // Worked Hours & Overtime (No Peso sign needed)
        totalHoursText.setText(String.format("%.2f", payslip.getTotalWorkedHours()));
        overtimeHoursText.setText(String.format("%.2f", payslip.getOvertimeHours()));

        // Earnings
        grossSalaryText.setText(String.format("₱ %.2f", payslip.getGrossSalary()));
        grossSalaryText1.setText(String.format("₱ %.2f", payslip.getGrossSalary()));

        // Benefits
        riceSubsidyText.setText(String.format("₱ %.2f", employee.getRiceSubsidy()));
        phoneAllowanceText.setText(String.format("₱ %.2f", employee.getPhoneAllowance()));
        clothingAllowanceText.setText(String.format("₱%.2f", employee.getClothingAllowance()));

        totalBenefitsText.setText(String.format("₱ %.2f", employee.getTotalBenefits()));
        totalBenefitsText1.setText(String.format("₱ %.2f", employee.getTotalBenefits()));

        // Deductions (No Peso sign, usually deductions are displayed as positive values)
        sssDeductionText.setText(String.format("₱ %.2f", payslip.getSssDeduction()));
        philhealthDeductionText.setText(String.format("₱ %.2f", payslip.getPhilhealthDeduction()));
        pagibigDeductionText.setText(String.format("₱ %.2f", payslip.getPagibigDeduction()));
        witholdingTaxDeductionText.setText(String.format("₱ %.2f", payslip.getWithholdingTax()));

        totalDeductionsText.setText(String.format("₱ %.2f", payslip.getTotalDeductions()));
        totalDeductionsText1.setText(String.format("₱ %.2f", payslip.getTotalDeductions()));

        // Final Net Pay
        netPayText.setText(String.format("₱ %.2f", payslip.getNetSalary()));

    }

    /**
    * Refreshes the payslip whenever the user changes the month or year.
    */
    private void refreshPayslip() {
        updatePayslipDetails();
    }

    /**
    * Adds listeners so that changing the month/year triggers a refresh.
    */
    private void addListeners() {
        payslipMonthChooser.addPropertyChangeListener("month", evt -> refreshPayslip());
        jYearChooser.addPropertyChangeListener("year", evt -> refreshPayslip());
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        payslipMonthChooser = new com.toedter.calendar.JMonthChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jYearChooser = new com.toedter.calendar.JYearChooser();
        hourlyRateText = new javax.swing.JTextField();
        basicSalaryText = new javax.swing.JTextField();
        totalHoursText = new javax.swing.JTextField();
        grossSalaryText = new javax.swing.JTextField();
        endDateText = new javax.swing.JTextField();
        overtimeHoursText = new javax.swing.JTextField();
        overtimeHoursText3 = new javax.swing.JTextField();
        startDateText = new javax.swing.JTextField();
        phoneAllowanceText = new javax.swing.JTextField();
        riceSubsidyText = new javax.swing.JTextField();
        clothingAllowanceText = new javax.swing.JTextField();
        totalBenefitsText = new javax.swing.JTextField();
        philhealthDeductionText = new javax.swing.JTextField();
        sssDeductionText = new javax.swing.JTextField();
        netPayText = new javax.swing.JTextField();
        pagibigDeductionText = new javax.swing.JTextField();
        witholdingTaxDeductionText = new javax.swing.JTextField();
        totalDeductionsText = new javax.swing.JTextField();
        grossSalaryText1 = new javax.swing.JTextField();
        totalBenefitsText1 = new javax.swing.JTextField();
        totalDeductionsText1 = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

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

        jLabel3.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("SUMMARY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("TAKE HOME PAY");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, -1, -1));

        jLabel6.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("DEDUCTIONS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("BENEFITS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Period End Date:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, -1, -1));

        payslipMonthChooser.setForeground(new java.awt.Color(255, 255, 255));
        payslipMonthChooser.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(payslipMonthChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 90, -1));

        jLabel8.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Choose Period:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("EARNINGS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Hourly Rate");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        jLabel13.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Hours Worked");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Witholding Tax");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jLabel15.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("GROSS INCOME");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        jLabel16.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Gross Income");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, -1, -1));

        jLabel17.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Benefits");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, -1, -1));

        jLabel18.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Deductions");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, -1, -1));

        jLabel19.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Rice Subsidy");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jLabel20.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Phone Allowance");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        jLabel21.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Clothing Allowance");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        jLabel22.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("TOTAL BENEFITS");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, -1, -1));

        jLabel23.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Overtime");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        jLabel24.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Social Security System");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        jLabel25.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Philhealth");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, -1, -1));

        jLabel26.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Pag-Ibig");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, -1, -1));

        jLabel27.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("TOTAL DEDUCTIONS");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, -1, -1));

        jLabel28.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Monthly Rate");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jLabel11.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Period Start Date:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        jYearChooser.setBackground(new java.awt.Color(204, 204, 204));
        jYearChooser.setAutoscrolls(true);
        jYearChooser.setEndYear(2025);
        jYearChooser.setFocusable(false);
        jYearChooser.setOpaque(false);
        jYearChooser.setRequestFocusEnabled(false);
        jYearChooser.setStartYear(2015);
        jYearChooser.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jYearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 70, -1));

        hourlyRateText.setEditable(false);
        hourlyRateText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        hourlyRateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourlyRateTextActionPerformed(evt);
            }
        });
        getContentPane().add(hourlyRateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 130, -1));

        basicSalaryText.setEditable(false);
        basicSalaryText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        basicSalaryText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicSalaryTextActionPerformed(evt);
            }
        });
        getContentPane().add(basicSalaryText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 130, -1));

        totalHoursText.setEditable(false);
        totalHoursText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(totalHoursText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 130, -1));

        grossSalaryText.setEditable(false);
        grossSalaryText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        grossSalaryText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grossSalaryTextActionPerformed(evt);
            }
        });
        getContentPane().add(grossSalaryText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 130, -1));

        endDateText.setEditable(false);
        endDateText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(endDateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 130, -1));

        overtimeHoursText.setEditable(false);
        overtimeHoursText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(overtimeHoursText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 130, -1));

        overtimeHoursText3.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(overtimeHoursText3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 130, -1));

        startDateText.setEditable(false);
        startDateText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        startDateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateTextActionPerformed(evt);
            }
        });
        getContentPane().add(startDateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 130, -1));

        phoneAllowanceText.setEditable(false);
        phoneAllowanceText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(phoneAllowanceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 130, -1));

        riceSubsidyText.setEditable(false);
        riceSubsidyText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(riceSubsidyText, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 130, -1));

        clothingAllowanceText.setEditable(false);
        clothingAllowanceText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(clothingAllowanceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 130, -1));

        totalBenefitsText.setEditable(false);
        totalBenefitsText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(totalBenefitsText, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 130, -1));

        philhealthDeductionText.setEditable(false);
        philhealthDeductionText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(philhealthDeductionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 130, -1));

        sssDeductionText.setEditable(false);
        sssDeductionText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(sssDeductionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 130, -1));

        netPayText.setEditable(false);
        netPayText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(netPayText, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 130, -1));

        pagibigDeductionText.setEditable(false);
        pagibigDeductionText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(pagibigDeductionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 130, -1));

        witholdingTaxDeductionText.setEditable(false);
        witholdingTaxDeductionText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(witholdingTaxDeductionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 130, -1));

        totalDeductionsText.setEditable(false);
        totalDeductionsText.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(totalDeductionsText, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, 130, -1));

        grossSalaryText1.setEditable(false);
        grossSalaryText1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(grossSalaryText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 130, -1));

        totalBenefitsText1.setEditable(false);
        totalBenefitsText1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(totalBenefitsText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 130, -1));

        totalDeductionsText1.setEditable(false);
        totalDeductionsText1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        getContentPane().add(totalDeductionsText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 130, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Payslip Information.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        new EmployeePage(this.employeeData).setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void hourlyRateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourlyRateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hourlyRateTextActionPerformed

    private void startDateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateTextActionPerformed

    private void grossSalaryTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grossSalaryTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grossSalaryTextActionPerformed

    private void basicSalaryTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicSalaryTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_basicSalaryTextActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeePayslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeePayslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeePayslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeePayslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeePayslip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private buttons.whiteButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JTextField basicSalaryText;
    private javax.swing.JTextField clothingAllowanceText;
    private javax.swing.JTextField endDateText;
    private javax.swing.JTextField grossSalaryText;
    private javax.swing.JTextField grossSalaryText1;
    private javax.swing.JTextField hourlyRateText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.toedter.calendar.JYearChooser jYearChooser;
    private javax.swing.JTextField netPayText;
    private javax.swing.JTextField overtimeHoursText;
    private javax.swing.JTextField overtimeHoursText3;
    private javax.swing.JTextField pagibigDeductionText;
    private com.toedter.calendar.JMonthChooser payslipMonthChooser;
    private javax.swing.JTextField philhealthDeductionText;
    private javax.swing.JTextField phoneAllowanceText;
    private javax.swing.JTextField riceSubsidyText;
    private javax.swing.JTextField sssDeductionText;
    private javax.swing.JTextField startDateText;
    private javax.swing.JTextField totalBenefitsText;
    private javax.swing.JTextField totalBenefitsText1;
    private javax.swing.JTextField totalDeductionsText;
    private javax.swing.JTextField totalDeductionsText1;
    private javax.swing.JTextField totalHoursText;
    private javax.swing.JTextField witholdingTaxDeductionText;
    // End of variables declaration//GEN-END:variables
}
