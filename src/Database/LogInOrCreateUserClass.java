package Database;

import JavaFX.Main;

import java.sql.*;
import java.lang.*;
import java.util.Scanner;

public class LogInOrCreateUserClass {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://35.228.89.148:3306/hangerDatabase";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "PasswordOfGroup6P1Project";
    static int counter = 3;
    static String emailOfUser;

    private static boolean logIn(){
        Scanner input = new Scanner(System.in);

        System.out.println("Insert your email: ");
        emailOfUser = input.nextLine();

        System.out.println("Insert your password: ");
        String password = input.nextLine();

        if(loginAndPasswordChecking(emailOfUser,password)) {
            //if login and password matches then methods return true
            counter = 0;
            System.out.println("You have been successfully logged in!");
            return true;

        } else { //else your amount of tries--
            counter--;
            System.out.println("Your login or password is incorrect!");

            if (counter <= 1) { //if you reach the limit then method returns false
                return false;

            } else {
                System.out.println("You have " + counter +" more tries!");
                logIn(); //if you have some tries left then method calls method logIn() again
            }
        }
        return true;
    }

    public static boolean loginAndPasswordChecking (String email, String password){

        String emailDB;
        String passwordDB;
        Main main = new Main();
        try {
            ResultSet myResults = Main.stmt.executeQuery("select * from users");

            // 4. Check if email and password user entered match to any of registered in database
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

    /**
     * in this class user either log in or register
     * @return
     */

    public static boolean welcomeScreen() throws Exception{
        Scanner input = new Scanner(System.in);
        DatabaseMethodsClass database = new DatabaseMethodsClass();

        System.out.println("Are you an registered user? [y/n]");
        String yesOrNo = input.nextLine();

        while (counter != 0) {

            if (yesOrNo.equals("y")) {
                if (!logIn())            //log in
                    return false;
            } else if (yesOrNo.equals("n")) {
                if (/*!database.addNewUser()*/true)//register new user
                    return false;
            } else {
                counter--;
                if (counter == 0) {
                    return false;
                } else {
                    System.out.println("You have " + counter + " more tries!");
                    System.out.println("You need to insert either y or n. Try again.");
                    welcomeScreen();
                }
            }
        }
        return true;
    }

}
