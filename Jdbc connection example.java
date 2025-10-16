import java.sql.*;

class JdbcExample {
    public static void main(String args[]) {
        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 2: Connect to Database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "1234");

            // Step 3: Create Statement
            Statement stmt = con.createStatement();

            // Step 4: Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            // Step 5: Process Results
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

            // Step 6: Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}