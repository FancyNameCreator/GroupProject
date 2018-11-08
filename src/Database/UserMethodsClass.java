package Database;

import java.sql.*;
import java.lang.*;
import java.util.Scanner;


public class UserMethodsClass {
    private static void seeMyFriends() {

    }

    private static void seeFriendsGoingToEvent() {

    }

    private static void addFriend() {

    }

    private static void removeFriend() {

    }

    private static void seeMyProfile() {

    }

    private static void friendsMenu(String email) {

    }


    public static void userMenu(String email) {
        friendsMenu(email); //in order to get to friend options
        int myChoice=1;
        DatabaseMethodsClass database = new DatabaseMethodsClass();
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("WHAT YOU WANNA DO MAAAAN?\n1. update sth\n2. go to friends\n0. go back to main menu\nINSERT >>> ");
            myChoice = input.nextInt();

            switch (myChoice) {
                case 1: database.update(LogInOrCreateUserClass.emailOfUser); //update info about the user
                    break;
                case 2: friendsMenu(email); //in order to get to friend options
                    break;
                case 0 : break; //GO BACK TO THE MAIN CLASS
            }
        } while(myChoice != 0);

    }



}
