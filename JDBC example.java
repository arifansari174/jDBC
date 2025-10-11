import java.sql.*;

public class SimpleJDBCExample {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/testdb"; // Replace 'testdb' with your database name
        String user = "root"; // Your MySQL username
        String password = "password"; // Your MySQL password

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!");

            // Step 3: Create a statement
            Statement stmt = con.createStatement();

            // Step 4: Execute SQL queries
            String insertQuery = "INSERT INTO student (id, name, age) VALUES (1, 'Arif', 20)";
            stmt.executeUpdate(insertQuery);
            System.out.println("Record inserted successfully!");

            // Step 5: Retrieve data
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            System.out.println("Student Table Data:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "  " + rs.getString("name") + "  " + rs.getInt("age"));
            }

            // Step 6: Close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}