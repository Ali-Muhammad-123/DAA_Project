package Classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testingForDatabase {
    public static void main(String[] args) {
        String dbURL = "jdbc:oracle:thin:hr/hr@Ali-Muhammad:1521/orclpdb";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            System.out.println("Connected");
        }
    }
}
