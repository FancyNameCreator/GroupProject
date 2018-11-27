package JavaFX;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
    private String DoB;
    private String eventsAttending;
    private String friends;

    public Person(String id, String firstName, String lastName, String email, String password, String city, String doB, String eventsAttending, String friends) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.city = city;
        this.DoB = doB;
        this.eventsAttending = eventsAttending;
        this.friends = friends;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public void setEventsAttending(String eventsAttending) {
        this.eventsAttending = eventsAttending;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getDoB() {
        return DoB;
    }

    public String getEventsAttending() {
        return eventsAttending;
    }

    public String getFriends() {
        return friends;
    }
}
