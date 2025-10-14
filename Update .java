// Step 1: Import the required JDBC package
import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        // Step 2: Database information
        String url = "jdbc:mysql://localhost:3306/testdb"; // Database name = testdb
        String username = "root";  // Your MySQL username
        String password = "1234";  // Your MySQL password

        try {
            // Step 3: Load and register MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 4: Make connection to the database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connected to the database successfully!");

            // Step 5: Create SQL query
            String query = "SELECT * FROM students";

            // Step 6: Create a statement object
            Statement stmt = con.createStatement();

            // Step 7: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Step 8: Read data from ResultSet
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("---------------------------");
            }

            // Step 9: Close everything
            rs.close();
            stmt.close();
            con.close();
            System.out.println("✅ Connection closed successfully!");

        } catch (Exception e) {
            e.printStackTrace();  // Print any error if something goes wrong
        }
    }
}