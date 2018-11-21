package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class CreateEventController {

    String nameOfEvent;
    String locationOfEvent;
    String dateOfEvent;
    String descriptionOfEvent;
    String categoryOfEvent;
    String participantsOfEvent;
    String creatorOfEvent = Main.getEmailIN();

    private ObservableList<String> category = FXCollections.observableArrayList(
            "Food event","Clubbing","Music event","Just meeting","Sport match","Hobby event");

    @FXML
    private void initialize(){
        choiceBoxCreate.setItems(category);
    }

    private void createEvent(){
        getData();
        sendData();
    }

    private void getData(){

    }

    private void sendData(){
        try{
            String sql = "insert into users "
                    + "(first_name, last_name, email, password, address, postal_code, city, country, DoB)"
                    + "values ('" + nameOfEvent + "','" + dateOfEvent + "','" + locationOfEvent + "','" + descriptionOfEvent + "','" + categoryOfEvent + "','" + participantsOfEvent + "', '" + creatorOfEvent + "')";
            // executing MySQL command that value is stored in sql variable
            Main.stmt.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }


    }
}
