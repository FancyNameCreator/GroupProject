import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseMethodsClass {

    public static void printAllUsers(){
        try {
            // 1. Get a connection to the Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://35.228.89.148:3306/hangerDatabase", "root","password");
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

        public class JDBCExample {
            // JDBC driver name and database URL
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";

            //  Database credentials
            static final String USER = "username";
            static final String PASS = "password";

            public static void main(String[] args) {
                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    System.out.println("Connected database successfully...");

                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();

                    String sql = "INSERT INTO Registration " +
                        "VALUES (100, 'Zara', 'Ali', 18)";
                    stmt.executeUpdate(sql);
                    sql = "INSERT INTO Registration " +
                        "VALUES (101, 'Mahnaz', 'Fatma', 25)";
                    stmt.executeUpdate(sql);
                    sql = "INSERT INTO Registration " +
                        "VALUES (102, 'Zaid', 'Khan', 30)";
                    stmt.executeUpdate(sql);
                    sql = "INSERT INTO Registration " +
                        "VALUES(103, 'Sumit', 'Mittal', 28)";
                    stmt.executeUpdate(sql);
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception e){
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }finally{
                    //finally block used to close resources
                    try{
                        if(stmt!=null)
                            conn.close();
                    }catch(SQLException se){
                    }// do nothing
                    try{
                        if(conn!=null)
                            conn.close();
                    }catch(SQLException se){
                        se.printStackTrace();
                    }//end finally try
                }//end try
                System.out.println("Goodbye!");
            }//end main
        }//end JDBCExample

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
