import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemControlOptions {

    public static void start()  {
        System.out.println("\n--- System Control Options ---\n");
        menuSystemControlOptions();
    }

    public static void menuSystemControlOptions(){
        boolean keepAsking = true;
        while (keepAsking) {

            System.out.println("· 1. Create movie and add actors" +
                    "\n· 2. Update Movie and add Actors" +
                    "\n· 3. Display Movies" +
                    "\n· 4. Delete Movies" +
                    "\n· 5. Display Actors" +
                    "\n· 9. Main Menu");
            int choice = App.userChoice();

            if (choice == 1) {
                // Go to CREATE MOVIE
                SystemControlOptions.createMovie();
                keepAsking = false;
                //createMovie();
            } else if (choice == 2) {
                // Go to UPDATE MOVIE
                SystemControlOptions.updateMovie();
                keepAsking = false;
            } else if (choice == 3) {
                // Go to DISPLAY MOVIE
                SystemControlOptions.displayMovie();
                keepAsking = false;
            } else if (choice == 4) {
                // Go to DISPLAY Actors
                SystemControlOptions.deleteMovie();
                keepAsking = false;
            } else if (choice == 5){
                // Go to Display Actors
                SystemControlOptions.displayActors();
                keepAsking = false;
            } else if (choice == 9) {
                App.appMainChoices();
                keepAsking = false;
            } else {
                System.out.println("! Please write a number to choose one of the following options !\n");
            }
        }
    }

    public static void createMovie() {

        ArrayList<String> newMovieActors = new ArrayList<>();
        ArrayList<String> newActorRoles = new ArrayList<>();

        // CREATE A SCANNER FOR MOVIE TITLE
        Scanner userInput = new Scanner(System.in);
        System.out.println("\n· Enter movie title: ");
        String title = userInput.nextLine();

        // USE SCANNER FOR MOVIE YEAR
        boolean notNumberEntered = true;

        int year = 1;
        while (notNumberEntered){
            System.out.println("\n· Enter movie release year:");
            year = App.userChoice();
            if (year >= 1900){
                notNumberEntered = false;
            } else {
                System.out.println("\nRelease year have to be after 1900. Try again.");
            }
        }

        // LOOP FOR ADDING ACTORS AND ROLES
        boolean addActorLoop = true;
        while (addActorLoop) {

            //ADDING ACTOR
            System.out.println("\n· Enter actor name:");
            String actor = userInput.nextLine();
            newMovieActors.add(actor);

            //ADDING ROLE
            System.out.println("\n· Enter actor's role:");
            String actorRole = userInput.nextLine();
            newActorRoles.add(actorRole);

            boolean addActor = true;
            while (addActor){
            // ADD ANOTHER ACTOR LOOP
            System.out.println("\nDo you want to add another actor?" +
                    "\n· Yes" +
                    "\n· No");
            Scanner userInput1 = new Scanner(System.in);
            String userAnswer1 = userInput1.nextLine();

            // ADD ANOTHER ACTOR - ANSWER WRONG
            if (!userAnswer1.equalsIgnoreCase("no") && !userAnswer1.equalsIgnoreCase("yes")) {
                addActorLoop = false;
                System.out.println("\n! Please answer with yes or no !");
            }

            // ADD ANOTHER ACTOR - ANSWER NO
            if (userAnswer1.equalsIgnoreCase("no")) {
                addActorLoop = false;
                addActor = false;

                // ADD MOVIE IN THE ARRAYLIST OF MOVIES CREATING A NEW MOVIE OBJECT
                Main.movies.add(new Movie(title, year, newMovieActors, newActorRoles));

                System.out.println("\nOk, here you have the movie you have added:\n" +
                        "\nTitle:   " + title + " " + "( " + year + " )" + "\n" +
                        "Actors:  " + newMovieActors + "\n" +
                        "Role:    " + newActorRoles + "\n");

                System.out.println("What do you want to do now?");
                menuSystemControlOptions();
            }

            // ADD ANOTHER ACTOR - ANSWER YES
            if (userAnswer1.equalsIgnoreCase("yes")) {
                addActorLoop = true;
                addActor =false;
            }
        }}

    }

    // SHOULD WORK NOT SURE
    public static void updateMovie() {
        System.out.println("\nMovie List: " + Main.movies);
        System.out.println("\n· Please enter the name of the movie to Update:");
        Scanner userInput = new Scanner(System.in);
        String userAnswer = userInput.nextLine();

        boolean movieFound = false;

        for (Movie movie : Main.movies) {
            if (movie.getName().equalsIgnoreCase(userAnswer)) {
                movieFound = true;
                Main.movies.remove(movie);
                System.out.println("\nMovie found!");
                createMovie();
            }
        }

        if (!movieFound){
            System.out.println("\nMovie not found.");
            updateMovie();
        }
    }

    // DELETE MOVIES

    public static void deleteMovie(){

        System.out.println("\nMovie List: " + Main.movies);
        System.out.println(Main.movies);
        System.out.println("\n· Enter movie title you want to delete:");
        Scanner userInput = new Scanner(System.in);
        String userAnswer = userInput.nextLine();

        boolean movieFound = false;
         Movie movie1 = null;
        for (Movie movie : Main.movies) {
            if (movie.getName().equalsIgnoreCase(userAnswer)) {
                movieFound=true;
                movie1 = movie;
            }
        } if (!movieFound){
            System.out.println("\n! Movie not found !");
        }

        if(movieFound){
        Main.movies.remove(movie1);
        System.out.println("\nMovie removed from the list !");
        }

        boolean deleteMovieLoop = true;
        while (deleteMovieLoop){
        System.out.println("Do You want to delete another movie? " +
                "\n· Yes" +
                "\n· No");
        Scanner userInput1 = new Scanner(System.in);
        String userAnswer1 = userInput1.nextLine();

        if (!userAnswer1.equalsIgnoreCase("no") && !userAnswer1.equalsIgnoreCase("yes")){
            System.out.println("\n! Please answer with yes or no !");
        } else if (userAnswer1.equalsIgnoreCase("no")){
            deleteMovieLoop = false;
            App.appMainChoices();
        } else if (userAnswer1.equalsIgnoreCase("yes")){
            deleteMovieLoop = false;
            deleteMovie();
        }}
    }


    public static void displayMovie(){

        System.out.println("\nHere you can find the movie list: \n");


        for (Movie movie : Main.movies) {
            System.out.println(movie.toString());
        }

        System.out.println("\nWhat do you want to do now ?");
        menuSystemControlOptions();
    }

    //DOESN'T WORK THE FOR EACH LOOP
    public static void displayActors (){
        System.out.println("Here you can find the Actor list:\n ");

        for (Movie movie : Main.movies){
            System.out.println(movie.getActors());
        }

        System.out.println("\nWhat do you want to do now ?");
        menuSystemControlOptions();
    }
}
