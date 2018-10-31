import java.sql.*;
import java.lang.*;
import java.util.Scanner;

public class DatabaseMethodsClass {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://35.228.89.148:3306/hangerDatabase";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";


    public static void printAllUsers() {
        try {

            // 1. Get a connection to the Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(DB_URL, USER,PASS);
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

    public static void addNewUser() {

      Scanner input = new Scanner(System.in);
      String firstName = input.nextLine();
      String lastName = input.nextLine();
      String email = input.nextLine();
      String password = input.nextLine();
      String address = input.nextLine();
      String postalCode = input.nextLine();
      String city = input.nextLine();
      String country = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "insert into users "
                + "(first_name, last_name, email, password, address, postal_code, city, country)"
                + "values ('"+firstName+"','"+lastName+"','"+email+"','"+password+"','"+address+"','"+postalCode+"','"+city+"','"+country+"')";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
          }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateFirstName(String email) {

        Scanner input = new Scanner(System.in);
        String firstName = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "update users set first_name= '"+firstName+"' where id='"+id+"'";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String email){
        Scanner input = new Scanner(System.in);
        int choice=1;

        while(choice!=0){
            System.out.println("What thing you wanna change? Choose one option: ");
            System.out.print("1. first_name\n2. last_name\n3. email\n4. password\n5. address\n6. postal_code\n7. city\n8. country\nINSERT NUMBER>>> ");
            choice=input.nextInt();
            switch (choice){
                case 1: updateFirstName(email);
                        break;
                case 2: updateLastName(email);
                    break;
                case 3: updateEmail(email);
                    break;
                case 4: updatePassword(email);
                    break;
                case 5: updateAddress(email);
                    break;
                case 6: updatePostalCode(email);
                    break;
                case 7: updateCity(email);
                    break;
                case 8: updateCountry(email);
                    break;
                case 0: System.out.println("You are about to exit this site!");
                    break;
            }
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert the user's mail you wanna change in sth: ");
        String email = input.nextLine();
        //printAllUsers();
        update(email);
        //addNewUser(); //("INSERT INTO users" + " VALUES (id ,'Zimpson', 'Gab', 'kupa@gmail.com', 'password', 'address', 'postalcode','city', 'country')");
    }
}
