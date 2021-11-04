import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static int userChoice() {
        // Creates a Scanner, waits for the User Choice and returns the choice.
        Scanner userInput = new Scanner(System.in);
        int choice = 0;
        try {
            choice = userInput.nextInt();
        } catch (Exception InputMismatchException) {

        }
        return choice;
    }

    public static void appMainChoices() {

        System.out.println("\nHi " + UserManagementSystem.currentUser.getUsername());

        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("\n--- Main Menu ---\n" +
                    "\n· 1. System Control Options - Create, Update, Delete, Display Movies or Display Actors" +
                    "\n· 2. User Control Options - Add movies to your Favourite/Watched list" +
                    "\n· 3. Search movie" +
                    "\n· 4. See Statistics" +
                    "\n· 5. Play movie" +
                    "\n· 9. Log out" +
                    "\n· 15. Exit Program and Save All Changes!" );


            int choice = userChoice();

            if (choice == 1) {
                // Go to SYSTEM CONTROL OPTIONS
                keepAsking = false;
                SystemControlOptions.start();
            } else if (choice == 2) {
                // Go to USER CONTROL OPTIONS
                keepAsking = false;
                UserControlOptions.start();
            } else if (choice == 3) {
                // Go to Search For Movie
                keepAsking = false;
                MovieSearch.start();
            } else if (choice == 4) {
                // Go to See Statistics
                keepAsking = false;
                SeeStatistics.start();
            } else if (choice == 5) {
                // Go to Play a Movie
                keepAsking = false;
                PlayMovie.start();
            } else if (choice == 9) {
                keepAsking = false;
                UserManagementSystem.start();
            } else if (choice == 15){
                try {
                    FileOutputStream fosMovies = new FileOutputStream("src/Movies.ser");
                    ObjectOutputStream oosMovies = new ObjectOutputStream(fosMovies);

                    oosMovies.writeObject(Main.movies);
                    oosMovies.close();
                    fosMovies.close();

                    FileOutputStream fosUser = new FileOutputStream("src/Users.ser");
                    ObjectOutputStream oosUser = new ObjectOutputStream(fosUser);

                    oosUser.writeObject(Main.users);
                    oosUser.close();
                    fosUser.close();

                    System.out.println("Everything was saved. See you soon!");

                    System.exit(0);

                } catch (IOException ioe){
                    ioe.printStackTrace();
                }
            } else {
                System.out.println("! Please write a number and choose one of the following options !");
            }


        }
    }
}