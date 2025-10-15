import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertExample {
    public static void main(String[] args) {
        try {
            // 1️⃣ Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Connect to the Database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", // your database name
                "root",                               // your username
                "password"                            // your password
            );

            // 3️⃣ Write SQL Insert Query
            String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

            // 4️⃣ Create PreparedStatement
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, 101);           // set id
            stmt.setString(2, "Arif");     // set name
            stmt.setInt(3, 22);            // set age

            // 5️⃣ Execute Query
            int rows = stmt.executeUpdate();

            // 6️⃣ Check if data inserted
            if (rows > 0) {
                System.out.println("Data inserted successfully!");
            }

            // 7️⃣ Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}