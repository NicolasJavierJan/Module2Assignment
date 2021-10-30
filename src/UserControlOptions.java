import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

// TODO
// ANDREA

public class UserControlOptions {
    /*

    public static void start(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        title();
        menuUserControlOptions(userList, movieList, movies1);
    }

// METHODS:
    // JUST PRINTING TITLE
    public static void title() {
        System.out.println("\n--- User Control Options ---\n");
    }

    // GENERAL MENU : 1: Add movie - 2: see list - 3: go back
    public static void menuUserControlOptions(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        boolean keepAsking = true;
        while (keepAsking){
            System.out.println("· 1. Access Favourites List" +
                    "\n· 2. Access Watched list" +
                    "\n· 9. Go back to home page");

            int userAnswer = App.userChoice();
            if (userAnswer == 1) {
                keepAsking = false;
                goToFavouriteList(userList, movieList, movies1);
            } else if (userAnswer == 2) {
                keepAsking = false;
                goToWatchedList(userList, movieList, movies1);
            } else if (userAnswer == 9) {
                keepAsking = false;
                App.appMainChoices(userList, movieList, movies1);
            }
        }
    }

    // MENU FAV LIST - 1.ADD MOVIE - 2.SEE LIST - 3. GO BACK
    public static void menuFavList(){
        System.out.println(
                "· 1. Add movies to your favourites list" +
                        "\n· 2. See your favourites list" +
                        "\n· 9. Go back");
    }

    // FAVOURITE LIST
    public static void goToFavouriteList(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
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

                        // CHECK FOR EQUALITY
                        if (favouriteList.contains(userFilm)){
                            System.out.println("\nyou already added this movie! " + favouriteList + "\nTry again with a different title\n");
                        } else {
                            loopChoice1 = false;
                            addFavouriteList(userFilm);
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
                                System.out.println("\nOk, here you have your list updated: " + favouriteList + "\n");
                                menuUserControlOptions(userList, movieList, movies1);
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
                    if (favouriteList.isEmpty()){
                        System.out.println("\nYour list is empty!" +
                                "\nFirst add movies in the list and come back later :)" + "\n");
                    } else if (!favouriteList.isEmpty()){
                        System.out.println("List: " + favouriteList);
                    }

                    //menuUserControlOptions();
                    loopMenuFavList = true;

                    // FAVOURITE LIST CHOICE 9 - GO TO USER OPTIONS
                } else if (choice == 9){
                    loopMenuFavList = false;
                    loopFromStart = false;
                    menuUserControlOptions(userList, movieList, movies1);
                }
            }
        }
    }

    // MENU WATCHED LIST
    public static void menuWatchedList(){
        System.out.println(
                "· 1. add movies to your watched list" +
                        "\n· 2. to see your watched list" +
                        "\n· 9. to go back");
    }

    // WATCHED LIST
    public static void goToWatchedList (File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        System.out.println("\n--- Watched List ---\n" );
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

                        // CHECK FOR EQUALITY
                        if (watchedList.contains(userFilm)){
                            System.out.println("\nyou already added this movie! " + watchedList + "\nTry again with a different title");
                        } else {
                            loopChoice1 = false;
                            addWatchedList(userFilm);
                            System.out.println("\nMovie added to the list!");
                        }

                        // IF TO ADD ANOTHER MOVIE
                        boolean loopAddAnotherMovie = true;
                        while(loopAddAnotherMovie) {

                            System.out.println("" +
                                    "\nDo you want to add another movie? " +
                                    "\n· The answer should be yes or no:");
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
                                System.out.println("\nOk, here you have your list updated: " + watchedList + "\n");
                                menuUserControlOptions(userList, movieList, movies1);
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
                    if (watchedList.isEmpty()){
                        System.out.println("\nYour list is empty!" +
                                "\nFirst add movies in the list and come back later :)" + "\n");
                    } else if (!watchedList.isEmpty()){
                        System.out.println("List: " + watchedList);
                    }
                    loopMenuFavList = true;

                    // WATCHED LIST CHOICE 3 - GO TO USER OPTIONS
                } else if (choice == 9){
                    loopMenuFavList = false;
                    loopFromStart = false;
                    menuUserControlOptions(userList, movieList, movies1);
                }
            }
        }
    }

    // ARRAYLIST FOR FAVOURITE
    public static ArrayList<String> favouriteList = new ArrayList<>();
    public static void addFavouriteList(String movie) {
        favouriteList.add(movie);
    }

    // ARRAYLIST FOR WATCHED
    public static ArrayList<String> watchedList = new ArrayList<>();
    public static void addWatchedList(String movie) {
        watchedList.add(movie);
    }

     */
}