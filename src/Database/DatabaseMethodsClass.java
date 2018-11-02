package Database;

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


    /**
     * the class prints all users from the database
     */

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
                System.out.println(myResults.getString("address") + ", " +
                                   myResults.getString("postal_code") + " " +
                                   myResults.getString("city"));
                System.out.println();
            }
        }

        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * this class adds a new user to the database
     */

    public static void addNewUser() {

      Scanner input = new Scanner(System.in);
      String password;
      String passwordconfirmation;

      System.out.println("Okey, you are new here! Welcome mate!");
      System.out.print("Insert your first name: ");

      String firstName = input.nextLine();
      System.out.print("Insert your last name: ");

      String lastName = input.nextLine();
      System.out.print("Insert your email: ");

      String email = input.nextLine();

      do {
          System.out.print("Insert your password: ");
          password = input.nextLine();
          System.out.print("confirm your password: ");
          passwordconfirmation = input.nextLine();

          if (password.equals(passwordconfirmation)){
              System.out.println("Password confirmed!");
              break;
          }

          else {
              System.out.println("You will have to do it again mate!");
          }
      }

      while(!password.equals(passwordconfirmation));

      System.out.print("Insert your address: ");
      String address = input.nextLine();
      System.out.print("Insert your postal code: ");
      String postalCode = input.nextLine();
      System.out.print("Insert your city: ");
      String city = input.nextLine();
      System.out.print("Insert your country: ");
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

    /**
     * updates a first name based on an email of a user
     */

    public static void updateFirstName(String email) {

        System.out.println("Enter new first name: ");
        Scanner input = new Scanner(System.in);
        String firstName = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "update users set first_name = '"+firstName+"' where email ='"+email+"'";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * updates a last name based on an email of a user
     */

    public static void updateLastName(String email) {

        System.out.println("Enter new last name: ");
        Scanner input = new Scanner(System.in);
        String lastName = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "update users set last_name = '"+lastName+"' where email ='"+email+"'";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * updates a email based on an email of a user
     */

    public static void updateEmail(String email) {

        System.out.println("Enter new email: ");
        Scanner input = new Scanner(System.in);
        String mail = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "update users set email = '"+mail+"' where email ='"+email+"'";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * updates a password based on an email of a user
     */

    public static void updatePassword(String email) {

        System.out.println("Enter new password: ");
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "update users set password = '"+password+"' where email ='"+email+"'";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * updates an address based on an email of a user
     */

    public static void updateAddress(String email) {

        System.out.println("Enter new address: ");
        Scanner input = new Scanner(System.in);
        String address = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "update users set address = '"+address+"' where email ='"+email+"'";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * updates a postal code based on an email of a user
     */

    public static void updatePostalCode(String email) {

        System.out.println("Enter new postal code: ");
        Scanner input = new Scanner(System.in);
        String postalCode = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "update users set postal_code = '"+postalCode+"' where email ='"+email+"'";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * updates a city based on an email of a user
     */

    public static void updateCity(String email) {

        System.out.println("Enter new city: ");
        Scanner input = new Scanner(System.in);
        String city = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "update users set city = '"+city+"' where email ='"+email+"'";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * updates a country based on an email of a user
     */

    public static void updateCountry(String email) {

        System.out.println("Enter new country: ");
        Scanner input = new Scanner(System.in);
        String country = input.nextLine();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();

            String sql = "update users set country = '"+country+"' where email ='"+email+"'";

            stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * in this class you can chooose what you want to update
     */

    public static void update(String email){
        Scanner input = new Scanner(System.in);

        int choice = 1;

        while(choice != 0){
            System.out.println("What thing you wanna change? Choose one option: ");
            System.out.print("1. first_name\n2. last_name\n3. email\n4. password\n5. address\n6. postal_code\n7. city\n8. country\n0. end\nINSERT NUMBER>>> ");

            choice = input.nextInt();
            boolean mailUpdate = false;

            switch (choice) {
                case 1: updateFirstName(email);
                    System.out.println("First name updated");
                        break;
                case 2: updateLastName(email);
                    System.out.println("Last name updated");
                    break;
                case 3: updateEmail(email);
                    System.out.println("Email was updated");
                    mailUpdate = true;
                    break;
                case 4: updatePassword(email);
                    System.out.println("Password updated");
                    break;
                case 5: updateAddress(email);
                    System.out.println("Address updated");
                    break;
                case 6: updatePostalCode(email);
                    System.out.println("Postal code updated");
                    break;
                case 7: updateCity(email);
                    System.out.println("City updated");
                    break;
                case 8: updateCountry(email);
                    System.out.println("Country updated");
                    break;
                case 0: System.out.println("Your new settings have been saved!");
                    break;
            }

            if (mailUpdate) break;
        }

        System.out.println("");
    }


    public static void testOneToChangeLater() {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert the mail of the user account you'd like to change: ");
        String email = input.nextLine();
        //printAllUsers();
        update(email);
        //addNewUser(); //("INSERT INTO users" + " VALUES (id ,'Zimpson', 'Gab', 'kupa@gmail.com', 'password', 'address', 'postalcode','city', 'country')");
    }
}
