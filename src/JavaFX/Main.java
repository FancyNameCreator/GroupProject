package JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;


public class Main extends Application {

    Stage window;
    final static String DB_URL = "jdbc:mysql://35.228.89.148:3306/hangerDatabase";

    //  Database credentials
    final static String USER = "root";
    final static String PASS = "PasswordOfGroup6P1Project";

    static Connection conn = null;
    static Statement stmt = null;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/resources/sample.fxml"));
        primaryStage.setTitle("Hanger");
        primaryStage.setScene(new Scene(root, 600, 400));
        window = primaryStage;
        window.show();
    }

    public static void main(String[] args) {
        createConnection();
        launch(args);
        closeCrap();
    }

    private static void createConnection(){
        try{

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection established \n");

            // 2. Create a statement
            stmt = conn.createStatement();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void closeCrap(){
        try{
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
