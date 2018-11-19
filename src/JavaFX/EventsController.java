package JavaFX;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class EventsController {
    ObservableList<String> kupa = FXCollections.observableArrayList("Kupa","Siku", "Rzyg");

    @FXML
    private ChoiceBox <String> choicebox;

    @FXML
    private void initialize(){
        choicebox.setItems(kupa);
    }

}
