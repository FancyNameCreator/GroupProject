package Database;

import java.sql.*;
import java.lang.*;
import java.util.Scanner;

/**
 * This is the class in which main class.
 * From this class program can be controlled,
 * that is to say all methods/other classes are called through this class.
 */
public class MainClass {
    /**
     * This is main method which starts the program
     * @param args
     */
    public static void main(String[] args) {

        // Here we create objects of other classes so that we can call them from this class
        LogInOrCreateUserClass login = new LogInOrCreateUserClass();
        DatabaseMethodsClass database = new DatabaseMethodsClass();
        EventsMethodsClass event = new EventsMethodsClass();
        UserMethodsClass user = new UserMethodsClass();
        ChatClass chat = new ChatClass();

        //We are calling method welcomeScreen of object login
        if (login.welcomeScreen()) { // Here we are checking if method returns true/false
            // If it returns true then user is successfully logged in
            System.out.println("OK mate now you are in da GAME!");
        }else{
            // else the program shuts down :(
            System.out.println("STH WENT WRONG, SU MATE!");
            System.exit(0);
        }


        //as soon user is successfully logged or registered he/she can choose between various options offered by program
        Scanner input = new Scanner(System.in);
        int myChoice=1;


        do {
            System.out.println("WHAT YOU WANNA DO MAAAAN?\n1. update sth\n0. END PROGRAM");
            myChoice = input.nextInt();

            switch (myChoice) {
                case 1: database.testOneToChangeLater(); //update info about the user
                    break;
                case 2: event.menuEvents(); //go to the events menu
                    break;
                case 3: user.userMenu(); //go to the user menu
                    break;
                case 4: //see my friends
                    break;
                case 5: //see my profile
                    break;
                case 6: chat.chat();//chat with somebody
                    break;
                case 7: //
                case 0 : break; //exit program
            }
        }while(myChoice!=0);
        //while (!logOut()){
        // }
    }
}

