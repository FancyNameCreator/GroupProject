package JavaFX;

public class Event{
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

