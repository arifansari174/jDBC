import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcMySQLExample {
    public static void main(String[] args) {

        // Database information
        String url = "jdbc:mysql://localhost:3306/testdb";  // your database name
        String user = "root";                                // your MySQL username
        String password = "1234";                            // your MySQL password

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            Connection con = DriverManager.getConnection(url, user, password);

            // Step 3: Check if connected
            if (con != null) {
                System.out.println("Connected to MySQL successfully!");
            }

            // Step 4: Close connection
            con.close();
            System.out.println("Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
        }
    }
}