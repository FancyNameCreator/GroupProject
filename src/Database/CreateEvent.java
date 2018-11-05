package Database;
import java.lang.*;
import java.security.SecureRandom;
import java.sql.*;
import java.util.Scanner;


public class CreateEvent {
   /* public static void main (String[] args) {
       // menuEvents();
    }
    */
        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        static final String DB_URL = "jdbc:mysql://35.228.89.148:3306/hangerDatabase";

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "password";

     static int eventChoice = 1;
     static int id = 0;
        public static void menuEvents() {
            Scanner input = new Scanner(System.in);
            while (eventChoice != 0) {
                System.out.println("Choose what you want to do with the event:\n0.Exit\n1.Update existing event\n2.Add new even\n3.Remove event\nINSERT NUMBER>>> ");
                eventChoice = input.nextInt();
                switch (eventChoice) {
                    case 1:
                        System.out.println("UPDATE");
                        changing();
                        break;
                    case 2:
                        addEvent();
                        System.out.println("ADD");
                        break;
                    case 3:
                        removeEvent();
                        System.out.println("REMOVE");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("The inserted option was not recognized. Please choose one of the options above.");
                        break;

                }

            }
        }
        public static void updateEvent(int id) {
        Scanner input = new Scanner(System.in);
            System.out.println("Choose what do you want to do:\n0.Exit\n1.Change event name\n2.Change event date\n3.Change event location\n4.Change event description");
            eventChoice = input.nextInt();
            switch (eventChoice) {
                case 1:
                    changeEventName();
                    break;
                case 2:
                    changeEventDate();
                    break;
                case 3:
                    changeEventLocation();
                    break;
                case 4:
                    changeEventDescription();
                    break;
                case 0:
                    System.out.println("You are about to exit this page");
                    break;
            }
        }
        public static void addEvent() {
            Scanner input = new Scanner(System.in);
            System.out.println("Start creating your event!");
            System.out.print("Add event name: ");
            String eventName = input.nextLine();
            System.out.print("Add the date\n ");
            System.out.print("Day: ");
            String eventDateDay = input.nextLine();
            System.out.print("\nMonth: ");
            String eventDateMonth = input.nextLine();
            System.out.print("\nYear: ");
            String eventDateYear = input.nextLine();
            String eventDate = eventDateDay + "." + eventDateMonth + "." + eventDateYear;
            System.out.print("Add event location: ");
            String eventLocation = input.nextLine();
            System.out.print("Add event description: ");
            String eventDescription = input.nextLine();


            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "insert into events "
                        + "(event_name, event_date, event_location, event_description)"
                        + "values ('"+eventName+"','"+eventDate+"','"+eventLocation+"','"+eventDescription+"')";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            }

            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void removeEvent() {

        }

        //changing part
        public static void changeEventName() {
            System.out.println("Enter new event name: ");
            Scanner input = new Scanner(System.in);
            String eventName = input.nextLine();
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "update events set event_name = '"+eventName+"' ";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        public static void changeEventDate() {
            System.out.println("Enter new event date: ");
            Scanner input = new Scanner(System.in);
            String eventDate = input.nextLine();
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "update events set event_date = '"+eventDate+"' ";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        public static void changeEventLocation() {
            System.out.println("Enter new event location: ");
            Scanner input = new Scanner(System.in);
            String eventLocation = input.nextLine();
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "update events set event_location = '"+eventLocation+"' ";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        public static void changeEventDescription() {
            System.out.println("Enter new event description: ");
            Scanner input = new Scanner(System.in);
            String eventDescription = input.nextLine();
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "update events set event_description = '"+eventDescription+"' ";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    public static void changing() {
        Scanner input = new Scanner(System.in);
        System.out.print("Which event would you like to change? Insert event id: ");
        int id = input.nextInt();
        updateEvent(id);
        }
    }

    /*
    funkcja co chcesz robic z eventami{

    wybierz co chcesz robić - switch
    1. update sth in events - wywołaj funkcje "updateEvent" (wzór funkcja update z DatabaseMethodsClass)
    2. add event - wywołaj funkcje "add event" - (wzór funkcja addNewUser)
    3. remove an event - wywołaj funkcję remove - do napisania


     */



