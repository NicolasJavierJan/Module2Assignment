import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

// ANDREA

public class UserControlOptions {

    public static void start()  {
        System.out.println("\n--- User Control Options ---");

        menuUserControlOptions();
    }

// METHODS:

    // GENERAL MENU : 1: Add movie - 2: see list - 3: go back
    public static void menuUserControlOptions() {
        boolean keepAsking = true;
        while (keepAsking){
            System.out.println("\n· 1. Favourites List" +
                    "\n· 2. Watched List" +
                    "\n· 9. Main Menu");

            int userAnswer = App.userChoice();
            if (userAnswer == 1) {
                keepAsking = false;
                goToFavouriteList();
            } else if (userAnswer == 2) {
                keepAsking = false;
                goToWatchedList();
            } else if (userAnswer == 9) {
                keepAsking = false;
                SeeStatistics.enteredMainMenuCount();
                App.appMainChoices();
            }
        }
    }

    // MENU FAV LIST - 1.ADD MOVIE - 2.SEE LIST - 3. GO BACK
    public static void menuFavList(){
        System.out.println(
                "· 1. Add movies to Favourites list" +
                        "\n· 2. See Favourites list" +
                        "\n· 9. Go back");
    }

    // FAVOURITE LIST
    public static void goToFavouriteList() {
        System.out.println("\n--- Favourites List ---\n" );
        boolean loopFromStart = true;
        while (loopFromStart) {

            boolean loopMenuFavList = true;
            while (loopMenuFavList) {
                menuFavList(); // 1: Add movie - 2: see list - 3: go back
                int choice = App.userChoice();

                // FAVOURITE LIST CHOICE 1 - ADD MOVIE
                if (choice == 1) {
                    loopFromStart = false;
                    loopMenuFavList = false;

                    // ADD MOVIE TO FAVOURITE LIST
                    boolean loopChoice1 = true;
                    while (loopChoice1) {

                        // FIRST INTERACTION
                        System.out.println("\nWrite the movie title you want to add:");
                        Scanner userInput = new Scanner(System.in);
                        String userFilm = userInput.nextLine();

                        Movie found = null;

                        for (Movie movie : Main.movies){
                            if (userFilm.equalsIgnoreCase(movie.getName())){
                                found = movie;
                            }
                        }

                        // CHECK FOR EQUALITY
                        if (UserManagementSystem.currentUser.getFavouriteList().contains(found)){
                            System.out.println("\nyou already added this movie! " + UserManagementSystem.currentUser.getFavouriteList() + "\nTry again with a different title\n");
                        } else if (found == null){
                            System.out.println("The movie does not exist!");
                        } else {
                            loopChoice1 = false;
                            UserManagementSystem.currentUser.getFavouriteList().add((found));
                            SeeStatistics.movieFavouriteListCount();
                            System.out.println("\nMovie added to the list!");
                        }

                        // IF TO ADD ANOTHER MOVIE
                        boolean loopAddAnotherMovie = true;
                        while(loopAddAnotherMovie) {

                            System.out.println("" +
                                    "\nDo you want to add another movie? " +
                                    "\n· Yes" +
                                    "\n· No ");
                            Scanner userInput1 = new Scanner(System.in);
                            String userAnswer1 = userInput1.nextLine();

                            // ADD ANOTHER MOVIE - ANSWER WRONG
                            if (!userAnswer1.equalsIgnoreCase("no") && !userAnswer1.equalsIgnoreCase("yes")) {
                                loopChoice1 = false;
                                System.out.println("\n! Please answer with yes or no !");
                            }

                            // ADD ANOTHER MOVIE - ANSWER NO
                            if (userAnswer1.equalsIgnoreCase("no")) {
                                loopChoice1 = false;
                                loopAddAnotherMovie =false;
                                System.out.println("\nOk, here you have your list updated: " + UserManagementSystem.currentUser.getFavouriteList());
                                menuUserControlOptions();
                            }

                            // ADD ANOTHER MOVIE - ANSWER YES
                            if (userAnswer1.equalsIgnoreCase("yes")) {
                                loopAddAnotherMovie = false;
                                loopChoice1 = true;
                            }
                        }
                    }
                    // FAVOURITE LIST CHOICE 2 - SEE FAVOURITE LIST
                } else if (choice == 2) {
                    loopMenuFavList = false;
                    loopFromStart = false;
                    if (UserManagementSystem.currentUser.getFavouriteList().isEmpty()){
                        System.out.println("\nYour list is empty!" +
                                "\nFirst add movies in the list and come back later :)" + "\n");
                    } else {
                        System.out.println("List: " + UserManagementSystem.currentUser.getFavouriteList());
                    }

                    //menuUserControlOptions();
                    loopMenuFavList = true;

                    // FAVOURITE LIST CHOICE 9 - GO TO USER OPTIONS
                } else if (choice == 9){
                    loopMenuFavList = false;
                    loopFromStart = false;
                    menuUserControlOptions();
                }
            }
        }
    }

    // MENU WATCHED LIST
    public static void menuWatchedList(){
        System.out.println(
                "· 1. Add movies to Watched list" +
                        "\n· 2. See Watched list" +
                        "\n· 9. Go Back");
    }

    // WATCHED LIST
    public static void goToWatchedList () {
        System.out.println("\n--- Watched List ---\n");
        boolean loopFromStart = true;
        while (loopFromStart) {

            boolean loopMenuFavList = true;
            while (loopMenuFavList) {
                menuWatchedList(); // 1: Add movie - 2: see list - 3: go back
                int choice = App.userChoice();

                // FAVOURITE LIST CHOICE 1 - ADD MOVIE
                if (choice == 1) {
                    loopFromStart = false;
                    loopMenuFavList = false;

                    // ADD MOVIE TO FAVOURITE LIST
                    boolean loopChoice1 = true;
                    while (loopChoice1) {

                        // FIRST INTERACTION
                        System.out.println("\nWrite the movie title you want to add:");
                        Scanner userInput = new Scanner(System.in);
                        String userFilm = userInput.nextLine();

                        String found = null;

                        for (Movie movie : Main.movies) {
                            if (userFilm.equalsIgnoreCase(movie.getName())) {
                                found = movie.getName();
                            }
                        }

                        // CHECK FOR EQUALITY
                        if (UserManagementSystem.currentUser.getHistoryList().contains(found)) {
                            System.out.println("\nyou already added this movie! " + UserManagementSystem.currentUser.getHistoryList() + "\nTry again with a different title");
                        } else {
                            loopChoice1 = false;
                            if (found != null) {
                                UserManagementSystem.currentUser.getHistoryList().add(found);
                                SeeStatistics.movieWatchedListCount();
                                System.out.println("\nMovie added to the list!");
                            } else {
                                System.out.println("\n! Movie not found !");
                            }
                        }

                        // IF TO ADD ANOTHER MOVIE
                        boolean loopAddAnotherMovie = true;
                        while (loopAddAnotherMovie) {

                            System.out.println("" +
                                    "\nDo you want to add another movie? " +
                                    "\n· Yes" +
                                    "\n· No");
                            Scanner userInput1 = new Scanner(System.in);
                            String userAnswer1 = userInput1.nextLine();

                            // ADD ANOTHER MOVIE - ANSWER WRONG
                            if (!userAnswer1.equalsIgnoreCase("no") && !userAnswer1.equalsIgnoreCase("yes")) {
                                loopChoice1 = false;
                                System.out.println("\n! Please answer with yes or no !");
                            }

                            // ADD ANOTHER MOVIE - ANSWER NO
                            if (userAnswer1.equalsIgnoreCase("no")) {
                                loopChoice1 = false;
                                loopAddAnotherMovie = false;
                                System.out.println("\nOk, here you have your list updated: " + UserManagementSystem.currentUser.getHistoryList() + "\n");
                                menuUserControlOptions();
                            }

                            // ADD ANOTHER MOVIE - ANSWER YES
                            if (userAnswer1.equalsIgnoreCase("yes")) {
                                loopAddAnotherMovie = false;
                                loopChoice1 = true;
                            }
                        }
                    }

                    // FAVOURITE LIST CHOICE 2 - SEE WATCHED LIST
                } else if (choice == 2) {
                    loopMenuFavList = false;
                    loopFromStart = false;
                    if (UserManagementSystem.currentUser.getHistoryList().isEmpty()) {
                        System.out.println("\nYour list is empty!" +
                                "\nFirst add movies in the list and come back later :)" + "\n");
                    } else {
                        System.out.println("List: " + UserManagementSystem.currentUser.getHistoryList());
                    }
                    loopMenuFavList = true;

                    // WATCHED LIST CHOICE 3 - GO TO USER OPTIONS
                } else if (choice == 9) {
                    loopMenuFavList = false;
                    loopFromStart = false;
                    menuUserControlOptions();
                }
            }
        }
    }
}