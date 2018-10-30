import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseMethodsClass {

    public static void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://35.228.89.148:3306/testCreationOfDB", "root","password");
            System.out.println("Connection established");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseMethodsClass.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethodsClass.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    public static void printAllUsers(){
        try {
            // 1. Get a connection to the Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://35.228.89.148:3306/testCreationOfDB", "root","password");
            System.out.println("Connection established \n");

            // 2. Create a statement
            Statement myStatmnt = myConn.createStatement();

            // 3. Execute SQL query
            ResultSet myResults = myStatmnt.executeQuery("select * from users");

            // 4. Process the result set
            while (myResults.next()) {
                System.out.println(myResults.getString("first_name") + " " + myResults.getString("last_name"));
                System.out.println(myResults.getString("email"));
                System.out.println(myResults.getString("address") + ", " + myResults.getString("postal_code") + " " + myResults.getString("city"));
                System.out.println();

            }
        }

        catch (Exception exc) {
            exc.printStackTrace();

        }
    }

    public void addNewUser(){

    }


    public static void main(String args[]){
        createConnection();
        printAllUsers();
    }

}
