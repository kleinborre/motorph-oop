package classes;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * LeaveRequest class that manages employee leave requests and handles CSV operations.
 */
public class LeaveRequest extends Employee implements CSVHandler {
    
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    private static final String DATABASES_FOLDER = "databases";
    private static final String FILE_NAME = "Leave Requests.csv";

    /**
     * Constructor for LeaveRequest.
     */
    public LeaveRequest(int employeeNumber, String leaveType, 
                        LocalDate startDate, LocalDate endDate, String status) {
        super(employeeNumber);
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public LeaveRequest() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /** Getters */
    public String getLeaveType() {
        return leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    /** Setters */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static File getCSVFile() {
        String userDir = System.getProperty("user.dir"); 
        File csvFile;

        // 1. Check target/databases/ (for NetBeans execution)
        File targetFile = new File(userDir, "target" + File.separator + DATABASES_FOLDER + File.separator + FILE_NAME);
        if (targetFile.exists()) {
            return targetFile;
        }

        // 2. Check databases/ (for JAR execution)
        File externalFile = new File(userDir, DATABASES_FOLDER + File.separator + FILE_NAME);
        if (externalFile.exists()) {
            return externalFile;
        }

        // 3. If missing, copy from resources
        InputStream internalFile = LeaveRequest.class.getClassLoader().getResourceAsStream(DATABASES_FOLDER + "/" + FILE_NAME);
        if (internalFile != null) {
            try {
                File directory = new File(userDir, DATABASES_FOLDER);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                Files.copy(internalFile, externalFile.toPath());
                System.out.println("Copied " + FILE_NAME + " from resources to external directory.");
                return externalFile;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("CSV file not found anywhere: " + FILE_NAME);
        return null;
    }

    /**
     * Reads all leave requests from the CSV file.
     */
    @Override
    public List<String[]> readCSV(String filePath) {
        List<String[]> leaveRequests = new ArrayList<>();
        File csvFile = getCSVFile();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext(); // Skip header row
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length >= 6) { // Ensure correct column count
                    leaveRequests.add(nextLine);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return leaveRequests;
    }

    /**
     * Writes all leave requests back to the CSV file.
     */
    @Override
    public void writeCSV(String filePath, List<String[]> data) {
        File csvFile = getCSVFile();

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile, false))) {
            String[] header = {"EmployeeNumber", "Name", "LeaveType", "StartDate", "EndDate", "Status", "OvertimeRequestNumber"};
            writer.writeNext(header); // Write header only once
            writer.writeAll(data);    // Write all records
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Submits a new leave request and writes it to the CSV file.
     */
    public void submitLeaveRequest() {
        List<String[]> allRequests = readCSV(getCSVFile().getPath());
        String leaveRequestNumber = generateLeaveRequestNumber(); // Generate ID

        Employee employee = new Employee(getEmployeeNumber());
        String fullName = employee.getLastName() + ", " + employee.getFirstName();

        // Create a new leave request row
        String[] newRequest = {
            String.valueOf(getEmployeeNumber()),
            fullName,
            leaveType,
            startDate.toString(),
            endDate.toString(),
            status,
            leaveRequestNumber // Include ID
        };

        // Check if leave request already exists
        boolean exists = false;
        List<String[]> updatedRequests = new ArrayList<>();

        for (String[] request : allRequests) {
            if (request.length >= 7) { // Ensure correct length
                String existingNumber = request[6].trim(); // Get stored LeaveRequestNumber
                LocalDate existingStart = LocalDate.parse(request[3].trim()); // Parse StartDate
                LocalDate existingEnd = LocalDate.parse(request[4].trim()); // Parse EndDate

                // Check for exact duplicate or overlapping range
                if (existingNumber.equals(leaveRequestNumber) ||
                    (startDate.isBefore(existingEnd) && endDate.isAfter(existingStart))) {
                    exists = true; // Conflict detected
                    continue; // Skip this request (delete in real-time)
                }
            }
            updatedRequests.add(request); // Keep valid requests
        }

        if (exists) {
            JOptionPane.showMessageDialog(null, "Cannot submit. Leave request conflicts with existing leave.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add new request and save
        updatedRequests.add(newRequest);
        writeCSV(getCSVFile().getPath(), updatedRequests);
        JOptionPane.showMessageDialog(null, "Leave request submitted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }


    /**
     * Cancels a leave request by removing it from the CSV file.
     */
    public void deleteLeaveRequest() {
        List<String[]> allRequests = readCSV(getCSVFile().getPath());
        List<String[]> updatedRequests = new ArrayList<>();
        boolean isDeleted = false;

        for (String[] request : allRequests) {
            if (request[0].equals(String.valueOf(getEmployeeNumber())) && 
                request[2].equals(leaveType) && 
                request[3].equals(startDate.toString())) {
                isDeleted = true; // Found and removed this request
                continue;
            }
            updatedRequests.add(request);
        }

        writeCSV(getCSVFile().getPath(), updatedRequests); // Overwrite file with updated data

        if (isDeleted) {
            System.out.println("Leave request cancelled successfully.");
        } else {
            System.out.println("No matching leave request found.");
        }
    }

    
    /**
    * Retrieves all leave requests for HR Manager to review.
    */
    public static List<String[]> getAllLeaveRequests() {
        LeaveRequest leaveRequestInstance = new LeaveRequest(0, "", null, null, ""); // Dummy instance
        return leaveRequestInstance.readCSV(getCSVFile().getPath()); // Use instance method
    }
    
    /**
    * Updates the status of a leave request (Approve/Reject)
    */
    public static void updateLeaveStatus(int employeeNumber, String leaveType, String startDate, String status) {
        LeaveRequest leaveRequestInstance = new LeaveRequest(0, "", null, null, ""); // Dummy instance
        List<String[]> allRequests = leaveRequestInstance.readCSV(getCSVFile().getPath());
        boolean updated = false;

        for (String[] request : allRequests) {
            if (request.length >= 6 && 
                request[0].equals(String.valueOf(employeeNumber)) &&
                request[2].equals(leaveType) &&
                request[3].equals(startDate)) {

                request[5] = status; // Update Status
                updated = true;
                break;
            }
        }

        if (updated) {
            leaveRequestInstance.writeCSV(getCSVFile().getPath(), allRequests);
            System.out.println("Leave request status updated to: " + status);
        } else {
            System.out.println("No matching leave request found.");
        }
    }
    
     /**
     * Converts LeaveRequest object to CSV row format.
     */
    public String[] toCSVArray() {
        Employee employee = new Employee(getEmployeeNumber());
        String fullName = employee.getLastName() + ", " + employee.getFirstName();
        String leaveRequestNumber = generateLeaveRequestNumber(); // Generate ID

        return new String[]{
            String.valueOf(getEmployeeNumber()),
            fullName,
            leaveType,
            startDate.toString(),
            endDate.toString(),
            status,
            leaveRequestNumber // New Index (Index 6)
        };
    }
    
    // Old method
    public String generateLeaveRequestNumber() {
        String companyNumber = "20"; // Static company number
        String start = startDate.toString().replaceAll("[^0-9]", ""); // YYYYMMDD
        String end = endDate.toString().replaceAll("[^0-9]", "").substring(4); // MMDD (last 4 digits)

        return companyNumber + start + end; // Format: 20YYYYMMDDMMDD
    }
    
    // New method
    public String generateLeaveRequestNumber(LocalDate start, LocalDate end) {
        String companyNumber = "20"; // Static company number
        String startFormatted = start.toString().replaceAll("[^0-9]", ""); // YYYYMMDD
        String endFormatted = end.toString().replaceAll("[^0-9]", "").substring(4); // MMDD (last 4 digits)

        return companyNumber + startFormatted + endFormatted; // Format: 20YYYYMMDDMMDD
    }
   
    public boolean updateLeaveRequest(String oldLeaveRequestNumber, LocalDate newStartDate, LocalDate newEndDate, String newLeaveType) {
        List<String[]> allRequests = readCSV(getCSVFile().getPath());
        List<String[]> updatedRequests = new ArrayList<>();
        boolean updated = false;
        String newLeaveRequestNumber = generateLeaveRequestNumber(newStartDate, newEndDate); // Generate new ID

        for (String[] request : allRequests) {
            if (request.length >= 7 && request[6].equals(oldLeaveRequestNumber) && request[0].equals(String.valueOf(getEmployeeNumber()))) {
                // The leave request to update has been found

                // Check for conflicts with other leave requests of the same employee (ignore current request)
                boolean conflict = false;
                for (String[] otherRequest : allRequests) {
                    if (otherRequest.length >= 7 && 
                        !otherRequest[6].equals(oldLeaveRequestNumber) && // Ignore current request
                        otherRequest[0].equals(String.valueOf(getEmployeeNumber()))) { // Same employee only

                        LocalDate otherStart = LocalDate.parse(otherRequest[3]);
                        LocalDate otherEnd = LocalDate.parse(otherRequest[4]);

                        // Check if new dates overlap with another request
                        if (newStartDate.isBefore(otherEnd) && newEndDate.isAfter(otherStart)) {
                            conflict = true;
                            break;
                        }
                    }
                }

                if (conflict) {
                    JOptionPane.showMessageDialog(null, "Cannot update. New leave request conflicts with another of your own.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                // Update the request with new values and new LeaveRequestNumber
                request[2] = newLeaveType;
                request[3] = newStartDate.toString();
                request[4] = newEndDate.toString();
                request[6] = newLeaveRequestNumber; // **Update the LeaveRequestNumber**
                updated = true;
            }
            updatedRequests.add(request);
        }

        if (updated) {
            writeCSV(getCSVFile().getPath(), updatedRequests);
            JOptionPane.showMessageDialog(null, "Leave request updated successfully!.", "Success", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No matching leave request found for update.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}