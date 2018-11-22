package JavaFX;

public class Event{
    /*
    QUESTIONS TO SOKOL:
    how to handle moving from one type of pane to the other - Ask about returning to main menu from profile
    can we have more variables without displaying them in a table?
    can we put buttons in table or be able double click on entry to go to more info about event?
    ask about full screen, how to recenter textfields and all this things
    ask about the chat
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
}