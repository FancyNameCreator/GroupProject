import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    public static void databaseConnection() {
        DatabaseConnection pro = new DatabaseConnection();
        pro.createConnection();


    }

    void createConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://35.228.89.148:3306/testCreationOfDB", "root","password");
            System.out.println("Connection established");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}
