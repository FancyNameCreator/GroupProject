package JavaFX;

import java.sql.ResultSet;

public class Event{

    /*
    QUESTIONS TO SOKOL:
    DONE - how to handle moving from one type of pane to the other - Ask about returning to main menu from profile
    DONE - can we have more variables without displaying them in a table?
    DONE - can we put buttons in table or be able double click on entry to go to more info about event?
    ask about full screen, how to recenter textfields and all this things - dont bother that much
    ask about the chat - check the deadlock - dont do GUI for server, only clients
    ask about photos of the users - we can also have folder in a server on google, it has that option!
    ^we can also make cache - when you click at the profile, check if it is ia a pc

    */

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public void setID (String ID) {
        this.ID = ID;
    }

    public void setName (String name) {
        this.name = name;
    }

    private String ID;
    private String name;
    private String date;
    private String location;
    private String description;
    private String category;
    private String participants;
    private String creator;


    public String getID() { return ID; }

    public String getName() { return name; }

    public String getDate() { return date; }

    public String getLocation() { return location; }

    public String getCategory() { return category; }

    public String getCreator() { return creator; }

    public String getDescription() { return description; }

    public String getParticipants() { return participants; }


    public Event(String ID, String name, String date, String location,String description, String category, String participants, String creator){
        this.ID = ID;
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
        this.category = category;
        this.participants = participants;
        this.creator = creator;
    }

    public static String printNiceParticipants(String participants){
        /*
        get single id from a list
        append to string
        */
        String checking="";
        String returning="";
        String name = "";
        String lastName = "";

        StringBuilder sb = new StringBuilder(checking);
        StringBuilder rt = new StringBuilder(returning);

        if (participants.length() != 0) {
            for (int i = 1; i < participants.length(); i++) {
                if (participants.charAt(i) != ',' && participants.charAt(i) != ')') {
                    sb.append(participants.charAt(i));
                } else {
                    //load person name and last
                    //append to string
                    try {
                        ResultSet myResults = Main.stmt.executeQuery("select * from users where id = '" + sb.toString() + "'");

                        while (myResults.next()) {
                            name = myResults.getString("first_name");
                            lastName = myResults.getString("last_name");
                        }
                    } catch (Exception exc) {    //catch the exception if occurs
                        exc.printStackTrace();
                    }
                    rt.append(name).append(" ").append(lastName).append("\n");

                    sb.deleteCharAt(1);
                    sb.deleteCharAt(0);
                }
            }
        } else {
            return "No of the users is going to participate :(";
        }
        return rt.toString();
    }
}