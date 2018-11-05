package Database;

import java.sql.*;
import java.util.Scanner;

public class LogInOrCreateUserClass {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://35.228.89.148:3306/hangerDatabase";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";
    static int counter=3;

    private static boolean logIn(){
        Scanner input = new Scanner(System.in);

        System.out.println("Insert your email: ");
        String email = input.nextLine();

        System.out.println("Insert your password: ");
        String password = input.nextLine();

        if(loginAndPasswordChecking(email,password)){
            System.out.println("You have been successfully logged in!");
            return true;
        }else{
            counter--;
            System.out.println("Your login or password is incorrect!");
            if (counter <= 0)
                return false;
            else {
                System.out.println("You have " + counter +" more tries!");
                logIn();
            }

        }
        return false;
    }

    private static boolean loginAndPasswordChecking (String email, String password){

        String emailDB;
        String passwordDB;
        try {

            // 1. Get a connection to the Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER,PASS);
            System.out.println("Connection established \n");

            // 2. Create a statement
            Statement stmt = conn.createStatement();

            // 3. Execute SQL query
            ResultSet myResults = stmt.executeQuery("select * from users");

            // 4. Process the result set
            while (myResults.next()) {
                emailDB = (myResults.getString("email"));
                passwordDB = (myResults.getString("password"));

                if(emailDB.equals(email) && passwordDB.equals(password))
                    return true;
            }
            return false;
        }

        catch (Exception exc) {
            exc.printStackTrace();

        }
        return false;
    }

    public static boolean welcomeScreen(){
        Scanner input = new Scanner(System.in);
        DatabaseMethodsClass database = new DatabaseMethodsClass();

        System.out.println("Are you an registered user? [y/n]");
        String yesOrNo = input.nextLine();

        if (yesOrNo.equals("y")){
            if(!logIn())
                return false;
        }else if (yesOrNo.equals("n")){
            database.addNewUser();
        }
        return true;
    }

}