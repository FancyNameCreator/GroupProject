package JavaFX;

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

    private final String ID;
    private final String name;
    private final String date;
    private final String location;
    private final String description;
    private final String category;
    private final String participants;
    private final String creator;


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
}