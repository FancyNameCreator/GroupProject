import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseMethodsClass {

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

    public static void addNewUser(){
        try {
            String url = "jdbc:mysql://35.228.89.148:3306/hangerDatabase";
            Connection conn = DriverManager.getConnection(url,"root","password");
            Statement st = conn.createStatement();


            st.executeUpdate("INSERT INTO users VALUES (id ,'Zimpson', 'Gab', 'kupa@gmail.com', 'password', 'address', 'postalcode','city', 'country')");
           /* st.executeUpdate("INSERT INTO Customers " +
                    "VALUES (2, 'McBeal', 'Ms.', 'Boston', 2004)");
            st.executeUpdate("INSERT INTO Customers " +
                    "VALUES (3, 'Flinstone', 'Mr.', 'Bedrock', 2003)");
            st.executeUpdate("INSERT INTO Customers " +
                    "VALUES (4, 'Cramden', 'Mr.', 'New York', 2001)");
*/
           //conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        System.out.println("Jesteś zajebisty!");

    }


    public static void main(String args[]){
        printAllUsers();
        addNewUser();
    }

}
