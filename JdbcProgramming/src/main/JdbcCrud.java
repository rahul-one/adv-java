package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rahulxxl
 */
public class JdbcCrud {
    
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    // Your MySQL Username
    private static final String USER = "root";
    // Your MySQL Password
    private static final String PASSWORD = "password";
    
    public void performCrud(){
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
            // Create
            createEmployee(conn, "Dhruv Sethi", "Software Engineer", 60000.00);
            createEmployee(conn, "Pratibha Devgan", "Software Engineer", 60000.00);
            createEmployee(conn, "Gourav Bhargav", "Manager", 70000.00);
            // Read
            readEmployees(conn);
            // Update
            updateEmployee(conn, 1, "Dhruv Sethi", "Senior Software Engineer", 80000.00);
            // Delete
            deleteEmployee(conn, 1);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private void createEmployee(Connection conn, String name, String position, double salary) throws SQLException {
        String sql = "INSERT INTO Employee (name, position, salary) VALUES (?, ?, ?)";
        // Creating prepared statement object.
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            // Setting the corresponding parameters
            pst.setString(1, name);
            pst.setString(2, position);
            pst.setDouble(3, salary);
            // Exceuting the Prepared Statement
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("New employee was Inserted Successfully...");
            }
        }
    }

    private void readEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Employee";
        // Creating Statement Object
        try (Statement st = conn.createStatement()) {
            // This will return a ResultSet object that acts like a table in Java World.
            ResultSet rSet = st.executeQuery(sql);
            while (rSet.next()) {
                int id = rSet.getInt("id");
                String name = rSet.getString("name");
                String position = rSet.getString("position");
                double salary = rSet.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
            }
        }
    }

    private void updateEmployee(Connection conn, int id, String name, String position, double salary) throws SQLException {
        String sql = "UPDATE Employee SET name = ?, position = ?, salary = ? WHERE id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setString(2, position);
            pst.setDouble(3, salary);
            pst.setInt(4, id);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("The existing employee was Updated Successfully...");
            }
        }
    }

    private void deleteEmployee(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM Employee WHERE id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee got Deleted Successfully...");
            }
        }
    }
}
