import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static int userChoice(){
        // Creates a Scanner, waits for the User Choice and returns the choice.
        Scanner userInput = new Scanner(System.in);
        int choice = 0;
        try {
            choice = userInput.nextInt();
        } catch (Exception InputMismatchException){
            System.out.println();
            System.out.println("NUMBERS PLEASE");
            System.out.println();
        }
        return choice;
    }

    public static void appMainChoices(File userList, File movieList) throws FileNotFoundException {
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("If you want to Create, Update, Delete, Display Movies or Display Actors, please press 1 " +
                    "and proceed to the SYSTEM CONTROL OPTIONS");
            System.out.println("If you want to add movies to your favourite list or add movies to your watched list, please press 2" +
                    " and proceed to the USER CONTROL OPTIONS");
            System.out.println("If you want to Search for a movie, press 3");
            System.out.println("If you want to See Statistics, press 4");
            System.out.println("If you want to Play a Movie, press 5");

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
                PlayMovie.start(movieList);
            } else {
                System.out.println("What if you choose one of the options and quit playing with me, pal?");
            }
        }
    }
}
