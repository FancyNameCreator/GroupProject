package Database;

import java.util.Scanner;


public class CreateEvent {

    public static void eventsMenu() {
       //to wszystko do usunięcia

        DatabaseConnection connect = new DatabaseConnection();
        connect.databaseConnection();
        Scanner sc = new Scanner(System.in);
        String event_name = sc.next();
        String event_date = sc.next();
        String event_location = sc.next();
        String event_participant = sc.next();
        String event_description = sc.next();



    }

    /*
    funkcja co chcesz robic z eventami{

    wybierz co chcesz robić - switch
    1. update sth in events - wywołaj funkcje "updateEvent" (wzór funkcja update z DatabaseMethodsClass)
    2. add event - wywołaj funkcje "add event" - (wzór funkcja addNewUser)
    3. remove an event - wywołaj funkcję remove - do napisania


     */


}
