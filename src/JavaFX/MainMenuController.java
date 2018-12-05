package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * class is responsible for main menu of an application, includes:
 * - methods regarding calendar
 * - methods that load new scenes
 */
public class MainMenuController {

    private ObservableList<String> year = FXCollections.observableArrayList("2019", "2020", "2021", "2022");
    private ObservableList<String> month = FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
    private ObservableList<Event> events = FXCollections.observableArrayList();

    @FXML private BorderPane mainPane;

    @FXML private ChoiceBox <String> chooseYear;
    @FXML private ChoiceBox <String> chooseMonth;

    @FXML private TableView<Event> tableView;
    @FXML private TableColumn<Event, String> eventName;
    @FXML private TableColumn<Event, String> eventCategory;

    //  Buttons from button1 to button31 are used to handle calendar
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;
    @FXML private Button button6;
    @FXML private Button button7;
    @FXML private Button button8;
    @FXML private Button button9;
    @FXML private Button button10;
    @FXML private Button button11;
    @FXML private Button button12;
    @FXML private Button button13;
    @FXML private Button button14;
    @FXML private Button button15;
    @FXML private Button button16;
    @FXML private Button button17;
    @FXML private Button button18;
    @FXML private Button button19;
    @FXML private Button button20;
    @FXML private Button button21;
    @FXML private Button button22;
    @FXML private Button button23;
    @FXML private Button button24;
    @FXML private Button button25;
    @FXML private Button button26;
    @FXML private Button button27;
    @FXML private Button button28;
    @FXML private Button button29;
    @FXML private Button button30;
    @FXML private Button button31;
    @FXML private Button buttonMonthConfirm;

    @FXML
    public void initialize () {
        chooseYear.setItems(year);
        chooseMonth.setItems(month);
        eventName.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tableView.setItems(events);
        chooseMonth.getSelectionModel().selectFirst();
        chooseYear.getSelectionModel().selectFirst();
        setAllButtonsWhite();
    }

/*
-------------------------------------------------------------------------------------------------
CALENDAR METHODS - methods regarding calendar
-------------------------------------------------------------------------------------------------
*/

    //  after executing this method chooseMonth and buttonMonthConfirm become available for the user to click
    @FXML
    public void choiceYear(){
        chooseMonth.setDisable(false);
        buttonMonthConfirm.setDisable(false);
    }

    //  1. determine how many days does the month has and display it
    //  2. determine whether there are upcoming events in the month and if so mark those days as red
    @FXML
    public void choiceMonth() {
        setAllButtonsWhite();
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
        button10.setDisable(false);
        button11.setDisable(false);
        button12.setDisable(false);
        button13.setDisable(false);
        button14.setDisable(false);
        button15.setDisable(false);
        button16.setDisable(false);
        button17.setDisable(false);
        button18.setDisable(false);
        button19.setDisable(false);
        button20.setDisable(false);
        button21.setDisable(false);
        button22.setDisable(false);
        button23.setDisable(false);
        button24.setDisable(false);
        button25.setDisable(false);
        button26.setDisable(false);
        button27.setDisable(false);
        button28.setDisable(false);
        if (chooseYear.getValue().equals("2020")) {
            button29.setDisable(true);
            button30.setDisable(true);
            button31.setDisable(true);

            switch (chooseMonth.getValue()) {
                case ("02"):
                    button29.setDisable(false);
                    break;
                case ("04") : case ("06") : case ("09") : case ("11"):
                    button29.setDisable(false);
                    button30.setDisable(false);
                    break;
                default:
                    button29.setDisable(false);
                    button30.setDisable(false);
                    button31.setDisable(false);
                    break;
            }
        }
        else {
            button29.setDisable(true);
            button30.setDisable(true);
            button31.setDisable(true);
            switch (chooseMonth.getValue()) {
                case ("02"):
                    button29.setDisable(true);
                    break;
                case ("04") : case ("06") : case ("09") : case ("11"):
                    button29.setDisable(false);
                    button30.setDisable(false);
                    break;
                default:
                    button29.setDisable(false);
                    button30.setDisable(false);
                    button31.setDisable(false);
                    break;
            }
        }
        simulateButtonClicked();
    }

    //  change color of passed button to red
    private void changeColorRed(Button button) {
        button.setStyle("-fx-background-color: #ff0000");
    }

    //  change color of passed button to white
    private void changeColorWhite(Button button) {
        button.setBackground(null);
        button.setStyle("-fx-border-color: black");
    }

    private void setAllButtonsWhite(){
        changeColorWhite(button1);
        changeColorWhite(button2);
        changeColorWhite(button3);
        changeColorWhite(button4);
        changeColorWhite(button5);
        changeColorWhite(button6);
        changeColorWhite(button7);
        changeColorWhite(button8);
        changeColorWhite(button9);
        changeColorWhite(button10);
        changeColorWhite(button11);
        changeColorWhite(button12);
        changeColorWhite(button13);
        changeColorWhite(button14);
        changeColorWhite(button15);
        changeColorWhite(button16);
        changeColorWhite(button17);
        changeColorWhite(button18);
        changeColorWhite(button19);
        changeColorWhite(button20);
        changeColorWhite(button21);
        changeColorWhite(button22);
        changeColorWhite(button23);
        changeColorWhite(button24);
        changeColorWhite(button25);
        changeColorWhite(button26);
        changeColorWhite(button27);
        changeColorWhite(button28);
        changeColorWhite(button29);
        changeColorWhite(button30);
        changeColorWhite(button31);
    }

    //  simulates the clicking of a button in order to determine which days(buttons) should be marked red
    private void simulateButtonClicked(){
        chosenButton1();
        chosenButton2();
        chosenButton3();
        chosenButton4();
        chosenButton5();
        chosenButton6();
        chosenButton7();
        chosenButton8();
        chosenButton9();
        chosenButton10();
        chosenButton11();
        chosenButton12();
        chosenButton13();
        chosenButton14();
        chosenButton15();
        chosenButton16();
        chosenButton17();
        chosenButton18();
        chosenButton19();
        chosenButton20();
        chosenButton21();
        chosenButton22();
        chosenButton23();
        chosenButton24();
        chosenButton25();
        chosenButton26();
        chosenButton27();
        chosenButton28();
        chosenButton29();
        chosenButton30();
        chosenButton31();
        tableView.getItems().clear();
    }



//--------------------------------------------------------------------------------
// methods that are loading table of events on the chosen day of a month
//--------------------------------------------------------------------------------

    @FXML private void chosenButton1(){
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-01";

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button1);
        }
    }

    @FXML private void chosenButton2() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-02";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button2);
        }
    }

    @FXML private void chosenButton3() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-03";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button3);
        }
    }

    @FXML private void chosenButton4() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-04";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button4);
        }
    }

    @FXML private void chosenButton5() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-05";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button5);
        }
    }

    @FXML private void chosenButton6() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-06";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button6);
        }
    }

    @FXML private void chosenButton7() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-07";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button7);
        }
    }

    @FXML private void chosenButton8() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-08";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button8);
        }
    }

    @FXML private void chosenButton9() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-09";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button9);
        }
    }

    @FXML private void chosenButton10() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-10";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button10);
        }
    }

    @FXML private void chosenButton11() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-11";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button11);
        }
    }

    @FXML private void chosenButton12() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-12";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button12);
        }
    }

    @FXML private void chosenButton13() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-13";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button13);
        }
    }

    @FXML private void chosenButton14() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-14";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button14);
        }
    }

    @FXML private void chosenButton15() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-15";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button15);
        }
    }

    @FXML private void chosenButton16() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-16";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button16);
        }
    }

    @FXML private void chosenButton17() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-17";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button17);
        }
    }

    @FXML private void chosenButton18() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-18";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button18);
        }
    }

    @FXML private void chosenButton19() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-19";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button19);
        }
    }

    @FXML private void chosenButton20() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-20";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button20);
        }
    }

    @FXML private void chosenButton21() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-21";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button21);
        }
    }

    @FXML private void chosenButton22() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-22";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button22);
        }
    }

    @FXML private void chosenButton23() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-23";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button23);
        }
    }

    @FXML private void chosenButton24() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-24";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button24);
        }
    }

    @FXML private void chosenButton25() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-25";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button25);
        }
    }

    @FXML private void chosenButton26() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-26";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button26);
        }
    }

    @FXML private void chosenButton27() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-27";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button27);
        }
    }

    @FXML private void chosenButton28() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-28";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
        if (events.size() != 0){
            changeColorRed(button28);
        }
    }

    @FXML private void chosenButton29() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-29";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button29);
        }
    }

    @FXML private void chosenButton30() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-30";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button30);
        }
    }

    @FXML private void chosenButton31() {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-31";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (events.size() != 0){
            changeColorRed(button31);
        }
    }


//  this method shows details of the event user chose and displays them in a separate stage
    @FXML private void showDetailsEvent() throws IOException {

        Main.chosenEvent = tableView.getSelectionModel().getSelectedItem();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/resources/eventAttend.fxml"));
        Scene scene = new Scene (fxmlLoader.load(), 900, 600);
        Stage stage = new Stage();
        stage.setTitle("Attend an event");
        stage.setScene(scene);
        stage.show();
        Image icon = new Image("/resources/Hanger Logo Done.png");
        stage.getIcons().add(icon);

        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader();
            fxmlLoader1.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
            BorderPane pane = fxmlLoader1.load();
            mainPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
----------------------------------------------------------------------------------
LOADERS METHODS - methods that load another fxml files
----------------------------------------------------------------------------------
 */
    @FXML
    private void goToProfile() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profile.fxml"));
        BorderPane pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToEvents() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToFriends() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/friendsPage.fxml"));
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToChat() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/chatclient/FXMLDocument.fxml"));
        BorderPane pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }
}