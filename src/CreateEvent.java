import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;





public class CreateEvent {

    public static void main(String[] args) {
        DatabaseConnection connect = new DatabaseConnection();
        connect.databaseConnection();
        Scanner sc = new Scanner(System.in);
        String event_name = sc.next();
        String event_date = sc.next();
        String event_location = sc.next();
        String event_participant = sc.next();
        String event_description = sc.next();


    }



}
