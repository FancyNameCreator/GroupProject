package Database;
import java.lang.*;
import java.security.SecureRandom;
import java.sql.*;
import java.util.Scanner;


public class EventsMethodsClass {
   public static void main (String[] args) {
       menuEvents();
    }

        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        static final String DB_URL = "jdbc:mysql://35.228.89.148:3306/hangerDatabase";

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "PasswordOfGroup6P1Project";

     static int eventChoice = 1;
     static int id = 0;
        public static void menuEvents() {
            Scanner input = new Scanner(System.in);
            while (eventChoice != 0) {
                System.out.println("Choose what you want to do with the event:\n0.Exit\n1.Update existing event\n2.Add new event\n3.Remove event\nINSERT NUMBER>>> ");
                eventChoice = 1;
                while (eventChoice!=0) {
                    eventChoice = input.nextInt();
                switch (eventChoice) {
                    case 1:
                        changing();
                        break;
                    case 2:
                        addEvent();
                        break;
                    case 3:
                        removeEvent(id);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("The inserted option was not recognized. Please choose one of the options above.");
                        break;
                }

                }

            }
        }
        public static void updateEvent(int id) {
        Scanner input = new Scanner(System.in);
            System.out.println("Choose what do you want to do:\n0.Exit\n1.Change event name\n2.Change event date\n3.Change event location\n4.Change event description\n5. Change event category\n6. Return to menu");
            eventChoice = 1;
            while (eventChoice!=0) {
                eventChoice = input.nextInt();
                switch (eventChoice) {
                    case 1:
                        changeEventName(id);
                        System.out.println("If you want to change something more insert one of displayed numbers:\n0.Exit\n1.Change event name\n2.Change event date\n3.Change event location\n4.Change event description\n5. Change event category\n6. Return to menu");
                        break;
                    case 2:
                        changeEventDate(id);
                        System.out.println("If you want to change something more insert one of displayed numbers:\n0.Exit\n1.Change event name\n2.Change event date\n3.Change event location\n4.Change event description\n5. Change event category\n6. Return to menu");
                        break;
                    case 3:
                        changeEventLocation(id);
                        System.out.println("If you want to change something more insert one of displayed numbers:\n0.Exit\n1.Change event name\n2.Change event date\n3.Change event location\n4.Change event description\n5. Change event category\n6. Return to menu");
                        break;
                    case 4:
                        changeEventDescription(id);
                        System.out.println("If you want to change something more insert one of displayed numbers:\n0.Exit\n1.Change event name\n2.Change event date\n3.Change event location\n4.Change event description\n5. Change event category\n6. Return to menu");
                        break;
                    case 5:
                        changeEventCategory(id);
                        System.out.println("If you want to change something more insert one of displayed numbers:\n0.Exit\n1.Change event name\n2.Change event date\n3.Change event location\n4.Change event description\n5. Change event category\n6. Return to menu");
                        break;
                    case 0:
                        System.out.println("You are about to exit this page.");
                        break;
                    case 6:
                        menuEvents();
                        break;
                    default:
                        System.out.println("Number was not recognized. Please, insert one of displayed above numbers.");
                }
            }
        }
        public static void addEvent() {
            Scanner input = new Scanner(System.in);

            System.out.println("Start creating your event!");

            System.out.print("Add event name: ");
            String eventName = input.nextLine();

            System.out.println("Add event description: ");
            String eventDescription = input.nextLine();

            System.out.println("Add event location: ");
            String eventLocation = input.nextLine();

            System.out.print("Add the date\n ");

            System.out.print("Year (insert all 4 digits): ");
            int eventDateYear = input.nextInt();
            System.out.print("\nMonth(insert a number): ");
            int eventDateMonth1 = 1;
            int eventDateMonth = 1;
            while (eventDateMonth1 != 0) {
                eventDateMonth1 = input.nextInt();
                if (eventDateMonth1 >= 1 && eventDateMonth1 <= 12) {
                    eventDateMonth = eventDateMonth1;
                    break;
                } else {
                    System.out.println("Please enter a valid date.");
                }
            }

            System.out.print("\nDay(insert a number): ");
            int eventDateDay1 = 1;
            int eventDateDay = 1;
            if (eventDateYear % 4 == 0 && eventDateMonth == 2) {
                while (eventDateDay1 != 0) {
                    eventDateDay1 = input.nextInt();
                    if (eventDateDay1 >= 1 && eventDateDay1 <= 29) {
                        eventDateDay = eventDateDay1;
                        break;
                    } else {
                        System.out.println("Please enter a valid date.");
                    }
                }
            }
            else {
                if (eventDateMonth == 1 || eventDateMonth == 3 || eventDateMonth == 5 || eventDateMonth == 7 || eventDateMonth == 8 || eventDateMonth == 10 || eventDateMonth == 12) {
                    while (eventDateDay1 != 0) {
                        eventDateDay1 = input.nextInt();
                        if (eventDateDay1 >= 1 && eventDateDay1 <= 31) {
                            eventDateDay = eventDateDay1;
                            break;
                        } else {
                            System.out.println("Please enter a valid date.");
                        }
                    }
                } else if (eventDateMonth == 4 || eventDateMonth == 6 || eventDateMonth == 9 || eventDateMonth == 11) {
                    while (eventDateDay1 != 0) {
                        eventDateDay1 = input.nextInt();
                        if (eventDateDay1 >= 1 && eventDateDay1 <= 30) {
                            eventDateDay = eventDateDay1;
                            break;
                        } else {
                            System.out.println("Please enter a valid date.");
                        }
                    }
                } else if (eventDateMonth == 2) {
                    while (eventDateDay1 != 0) {
                        eventDateDay1 = input.nextInt();
                        if (eventDateDay1 >= 1 && eventDateDay1 <= 28) {
                            eventDateDay = eventDateDay1;
                            break;
                        } else {
                            System.out.println("Please enter a valid date.");
                        }
                    }
                }
            }

            String eventDate = eventDateYear + "." + eventDateMonth + "." + eventDateDay;

            System.out.println("Add event category from the list below:\n1. Food event\n2. Clubbing\n3. Music event\n4. Just meeting\n5. Sport match\n6.Hobby event");
            int eventCategory = 1;
            String eventCategoryString  = "";
            while (eventCategory!=0) {
                eventCategory = input.nextInt();
                switch (eventCategory) {
                    case 1:
                        eventCategoryString = "Food event";
                        break;
                    case 2:
                        eventCategoryString = "Clubbing";
                        break;
                    case 3:
                        eventCategoryString = "Music event";
                        break;
                    case 4:
                        eventCategoryString = "Just meeting";
                        break;
                    case 5:
                        eventCategoryString = "Sport match";
                        break;
                    case 6:
                        eventCategoryString = "Hobby event";
                        break;
                    default:
                        System.out.println("Please enter one of the above stated numbers.");
                        break;
                }
                if (eventCategory == 1||eventCategory == 2||eventCategory == 3||eventCategory == 4||eventCategory == 5||eventCategory == 6) {
                    break;
                }
            }


            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "insert into events "
                        + "(event_name, event_date, event_location, event_description, event_category)"
                        + "values ('"+eventName+"','"+eventDate+"','"+eventLocation+"','"+eventDescription+"','"+eventCategoryString+"')";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            }

            catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("If you want to return to the menu, press 1, otherwise press any other number.");
            int answer = input.nextInt();
            if (answer == 1) {
                menuEvents();
            }
            else {
                System.out.println("You have left the page.");
            };

        }
        public static void removeEvent(int id) {
            System.out.println("Enter the id of the event you want to delete: ");
            Scanner input = new Scanner(System.in);
            id = input.nextInt();
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "DELETE FROM events WHERE event_id = "+id+" ";

                stmt.executeUpdate(sql);
                System.out.println("Event deleted");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("If you want to return to the menu, press 1, otherwise press anything.");
            int answer = input.nextInt();
            if (answer == 1) {
                menuEvents();
            } else {
                System.out.println();
            }
        }

        //changing part
        public static void changeEventName(int id) {
            System.out.println("Enter new event name: ");
            Scanner input = new Scanner(System.in);
            String eventName = input.nextLine();
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "update events set event_name = '"+eventName+"' where event_id = "+id+" ";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        public static void changeEventDate(int id) {
            System.out.println("Enter new event date:\n Year (insert 4 digits):  ");
            Scanner input = new Scanner(System.in);
            int eventDateYear = input.nextInt();
            System.out.println("\n Month(insert number): ");
            int eventDateMonth1 = 1;
            int eventDateMonth = 1;
            while (eventDateMonth1!=0) {
                eventDateMonth1 = input.nextInt();
                if (eventDateMonth1 >= 1 && eventDateMonth1 <= 12) {
                    eventDateMonth = eventDateMonth1;
                    break;
                } else {
                    System.out.println("Please enter a valid date.");
                }
            }

            System.out.println("\n Day (insert number): ");
            int eventDateDay1 = 1;
            int eventDateDay = 1;
            if (eventDateYear % 4 == 0 && eventDateMonth == 2) {
                while (eventDateDay1 != 0) {
                    eventDateDay1 = input.nextInt();
                    if (eventDateDay1 >= 1 && eventDateDay1 <= 29) {
                        eventDateDay = eventDateDay1;
                        break;
                    } else {
                        System.out.println("Please enter a valid date.");
                    }
                }
            } else {
                if (eventDateMonth == 1 || eventDateMonth == 3 || eventDateMonth == 5 || eventDateMonth == 7 || eventDateMonth == 8 || eventDateMonth == 10 || eventDateMonth == 12) {
                    while (eventDateDay1 != 0) {
                        eventDateDay1 = input.nextInt();
                        if (eventDateDay1 >= 1 && eventDateDay1 <= 31) {
                            eventDateDay = eventDateDay1;
                            break;
                        } else {
                            System.out.println("Please enter a valid date.");
                        }
                    }
                } else if (eventDateMonth == 4 || eventDateMonth == 6 || eventDateMonth == 9 || eventDateMonth == 11) {
                    while (eventDateDay1 != 0) {
                        eventDateDay1 = input.nextInt();
                        if (eventDateDay1 >= 1 && eventDateDay1 <= 30) {
                            eventDateDay = eventDateDay1;
                            break;
                        } else {
                            System.out.println("Please enter a valid date.");
                        }
                    }
                } else if (eventDateMonth == 2) {
                    while (eventDateDay1 != 0) {
                        eventDateDay1 = input.nextInt();
                        if (eventDateDay1 >= 1 && eventDateDay1 <= 28) {
                            eventDateDay = eventDateDay1;
                            break;
                        } else {
                            System.out.println("Please enter a valid date.");
                        }
                    }
                }
            }

            String eventDate = eventDateYear + "." + eventDateMonth + "." + eventDateDay;
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "update events set event_date = '"+eventDate+"' where event_id = "+id+" ";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        public static void changeEventLocation(int id) {
            System.out.println("Enter new event location: ");
            Scanner input = new Scanner(System.in);
            String eventLocation = input.nextLine();
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "update events set event_location = '"+eventLocation+"' where event_id = "+id+" ";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        public static void changeEventDescription(int id) {
            System.out.println("Enter new event description: ");
            Scanner input = new Scanner(System.in);
            String eventDescription = input.nextLine();
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "update events set event_description = '"+eventDescription+"' where event_id = "+id+"";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    public static void changing() {
        Scanner input = new Scanner(System.in);
        System.out.print("Which event would you like to change? Insert event id:  ");
        int id = input.nextInt();
        updateEvent(id);
        }
        public static void changeEventCategory(int id) {
            Scanner input = new Scanner(System.in);
            Connection conn = null;
            Statement stmt = null;
            System.out.println("Choose new category for this event:\n1. Food event\n2. Clubbing\n3. Music event\n4. Just meeting\n5. Sport match\n6.Hobby event ");
            int eventCategory = input.nextInt();
            String eventCategoryString = "";
            switch (eventCategory) {
                case 1:
                    eventCategoryString = "Food event";
                    break;
                case 2:
                    eventCategoryString = "Clubbing";
                    break;
                case 3:
                    eventCategoryString = "Music event";
                    break;
                case 4:
                    eventCategoryString = "Just meeting";
                    break;
                case 5:
                    eventCategoryString = "Sport match";
                    break;
                case 6:
                    eventCategoryString = "Hobby event";
                    break;
            }
            try {
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                stmt = conn.createStatement();

                String sql = "update events set event_category = '"+eventCategoryString+"' where event_id = "+id+"";

                stmt.executeUpdate(sql);
                System.out.println("Data inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




