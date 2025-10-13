import java.sql.*;

public class SimpleJdbc {
    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "1234");

            System.out.println("Connected to MySQL successfully!");

            // Step 3: Create a statement
            Statement stmt = con.createStatement();

            // Step 4: Insert a record
            stmt.executeUpdate("INSERT INTO students VALUES (1, 'Arif')");
            System.out.println("Record inserted successfully!");

            // Step 5: Display all records
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString(2));
            }

            // Step 6: Close connection
            con.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}