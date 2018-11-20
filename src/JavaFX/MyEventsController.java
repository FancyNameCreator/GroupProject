package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Event{
    String id;
    String name;
    String date;
    String location;
    String description;
    String category;
    String participants;
    String creator;

    public Event(String id, String name, String date, String location, String description, String category,
            String participants, String creator){
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
        this.category = category;
        this.participants = participants;
        this.creator = creator;
    }
}

public class MyEventsController {

    private ObservableList<Event> table = FXCollections.observableArrayList();

    int lastIndex = 0;

    @FXML
    private void initialize(){
        loadEventsTable(Main.getEmailIN());
    }

    private void loadEventsTable(String email){
        String idOfEventsIdAttending  = getEventsOfUser();

        try {
                // 3. Execute SQL query
                ResultSet myResults = Main.stmt.executeQuery("select * from events where id in '" + idOfEventsIdAttending + "' ");

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
        String str = "";

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from users where email = '" + Main.getEmailIN() + "' ");

            // 4. Process the result set
            while (myResults.next())
                str = (myResults.getString("events_attending"));

        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
        return str;
    }
}
