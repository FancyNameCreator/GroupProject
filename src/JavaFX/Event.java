package JavaFX;

public class Event{
    /*
    QUESTIONS TO SOKOL:
    can we have more variables without displaying them in a table?
    can we put buttons in table or be able double click on entry to go to more info about event?
    Ask about returning to main menu from profile
    */
    private final String name;
    private final String date;
    private final String location;
    private final String category;
    private final String creator;

    public String getName() { return name; }

    public String getDate() { return date; }

    public String getLocation() { return location; }

    public String getCategory() { return category; }

    public String getCreator() { return creator; }


    public Event(String name, String date, String location, String category, String creator){
        this.name = name;
        this.date = date;
        this.location = location;
        this.category = category;
        this.creator = creator;
    }
}