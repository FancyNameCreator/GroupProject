package Database;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateOfBirthClass {

    public static void main(String[] args) throws Exception {

      Scanner input = new Scanner(System.in);
      String date;
      System.out.println("Insert your date of birth in the format (dd-MM-yyyy): ");
      date = input.nextLine();
      Date inputDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
      java.sql.Date sqlDateOfBirth = new java.sql.Date(inputDate.getTime());

    }

}
