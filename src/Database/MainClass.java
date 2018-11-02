package Database;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        LogInOrCreateUserClass login = new LogInOrCreateUserClass();
        DatabaseMethodsClass database = new DatabaseMethodsClass();

        Scanner input = new Scanner(System.in);
        int myChoice = 1;

        if (login.welcomeScreen()) {
            System.out.println("OK mate now you are in da GAME!");
        }

        else {
            System.out.println("STH WENT WRONG SU MATE!");
            System.exit(0);
        }

        do {
            System.out.println("WHAT YOU WANNA DO MAAAAN?\n1. update sth\n0. END PROGRAM");
            myChoice = 1;
            myChoice = input.nextInt();

            switch (myChoice) {
                case 1:
                    database.testOneToChangeLater();
                    break;
                case 2: //go to events menu
                    break;
                case 3: //see calendar
                    break;
                case 4: //see my friends
                    break;
                case 5: //see my profile
                    break;
                case 6: //chat with somebody
                    break;
                case 7: //
                case 0 : break;
            }
        }

        while(myChoice!=0);
        //while (!logOut()){
        // }
    }
}

