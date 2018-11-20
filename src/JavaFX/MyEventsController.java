package JavaFX;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MyEventsController {

    private ObservableList<Event> table = FXCollections.observableArrayList();

    int lastIndex = 0;

    @FXML
    private BorderPane myEventsPane;


    @FXML
    private void initialize(){
        loadEventsTable(Main.getEmailIN());
        System.out.println(table);
        System.out.println(table.get(0));
    }

    private void loadEventsTable(String email){
        String idOfEventsIdAttending  = getEventsOfUser();
        System.out.println(idOfEventsIdAttending);

        try {
                // 3. Execute SQL query
                //ResultSet myResults = Main.stmt.executeQuery("select * from events where event_id = '"+ idOfEventsIdAttending +"'");
                ResultSet myResults = Main.stmt.executeQuery("select * from events where event_id in " + idOfEventsIdAttending);
                // 4. Process the result set
                while (myResults.next()) {
                    String id = myResults.getString("event_id");
                    String name = myResults.getString("event_name");
                    String date = myResults.getString("event_date");
                    String location = myResults.getString("event_location");
                    String description = myResults.getString("event_description");
                    String category = myResults.getString("event_category");
                    String participants = myResults.getString("participants");
                    String creator = myResults.getString("creator");
                    table.add(lastIndex, new Event(id,name,date,location,description,category,participants,creator));
                    lastIndex ++;

                }
            } catch (Exception exc) {    //catch the exception if occurs
                exc.printStackTrace();
            }
    }

    private String getEventsOfUser(){
        String emailPassed = Main.getEmailIN();
        System.out.println(emailPassed);


        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from users where email ='" + emailPassed + "' ");

            // 4. Process the result set
            while (myResults.next()) {
                emailPassed = myResults.getString("events_attending");
            }
            System.out.println(emailPassed);
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
        return emailPassed;
    }
}
