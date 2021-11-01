import java.io.File;
import java.io.FileNotFoundException;
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
            System.out.println();
            System.out.println("! Please enter a number !");
            System.out.println();
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
                    "\n· 9. Log out");


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
            } else {
                System.out.println("! Please write a number and choose one of the following options !");
            }


        }
    }
}