package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcExample {
	public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/guddu";
        String user = "root";
        String pass = "Mohd#022006";
        
        System.out.println("Student Table Data:");
        System.out.println("====================================");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(rs.getString("name") + " - " +
                                   rs.getString("college") + " - " +
                                   rs.getString("course"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}