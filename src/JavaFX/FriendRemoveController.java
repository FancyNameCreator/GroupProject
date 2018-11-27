package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class FriendRemoveController {

    private Person person = new Person(Main.chosenOne.getId(),Main.chosenOne.getFirstName(),Main.chosenOne.getLastName(),
            Main.chosenOne.getEmail(),Main.chosenOne.getPassword(),Main.chosenOne.getCity(),
            Main.chosenOne.getDoB(),Main.chosenOne.getEventsAttending(), Main.chosenOne.getFriends());

    @FXML
    private BorderPane profilePane;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField DoFTextField;


    @FXML
    private void initialize(){
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        cityTextField.setEditable(false);
        DoFTextField.setEditable(false);

        firstNameTextField.setText(person.getFirstName());
        lastNameTextField.setText(person.getLastName());
        cityTextField.setText(person.getCity());
        DoFTextField.setText(person.getDoB());
    }

    @FXML
    void removeFriend() {

    }
}
