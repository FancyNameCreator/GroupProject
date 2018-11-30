/*-----------------------------------------------------------------------------------------------------
 * CODE OF 'HANGER' SOCIAL MEDIA APPLICATION MADE BY:
 * IT, Communication and New Media Group 6,
 * as a part of Semester 1 Project
 * -----------------------------------------------------------------------------------------------------
 */

package JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.*;

/**
 * This is class in which main method is included - it starts execution of program
 */
public class Main extends Application {

    //  Database credentials:
    private final static String DB_URL = "jdbc:mysql://35.228.89.148:3306/hangerDatabase";
    private final static String USER = "root";
    private final static String PASS = "PasswordOfGroup6P1Project";

    //  Database 'variables':
    private static Connection conn = null;
    public static Statement stmt = null;

    //  Variables that need to be active during lifetime of application
    //  WHY... ?
    //  Because all variables that are not in this class are getting deleted as soon as execution of class they are in ends, for example while loading new window
    private static String emailIN;      //enables program to recognise current user
    static Person chosenOne;            //enables program to 'transport' info of chosen person to another class (scene/window)

    // enables various methods to recognise current user
    public static String getEmailIN() {
        return emailIN;
    }

    //  sets email of current user
    static void setEmailIN(String emailIN) {
        Main.emailIN = emailIN;
    }

    //  sets icon, primary stage, path to fxml file, stage title, resolution
    @Override
    public void start(Stage primaryStage) throws Exception{

        Image icon = new Image("/resources/Hanger Logo Done.png");
        primaryStage.getIcons().add(icon);
        Parent root = FXMLLoader.load(getClass().getResource("/resources/sample.fxml"));
        primaryStage.setTitle("Hanger");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }

    //  main method of application, by which is lunched
    public static void main(String[] args) {
        createConnection();     //  connect to DB
        launch(args);           //  start application
        closeCrap();            //  disconnect from DB
        System.exit(0);
    }

    //  creates a connection with the database, using previously implemented variables
    private static void createConnection(){
        try{
            //  create connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection established \n");

            //  create a statement
            stmt = conn.createStatement();

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("YOU STUPIDO !  DO YOU HAVE SQL CONNECTED !?");
        }
    }

    //  closes both statement and connection with the database, after program ends running
    private static void closeCrap(){
        try{
            stmt.close();
            conn.close();
            System.out.println("Crap closed");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
