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
                    "\n· 2. Update movie and add actors" +
                    "\n· 3. Display movies" +
                    "\n· 4. Display actors" +
                    "\n· 9. Go back to main menu");
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
                SystemControlOptions.displayActors();
                keepAsking = false;
            } else if (choice == 9) {
                App.appMainChoices();
                keepAsking = false;
            } else {
                System.out.println("! Please write a number and choose one of the following options !\n");
            }
        }
    }

    // SHOULD WORK NOT SURE
    public static void createMovie() {

        ArrayList<String> newMovieActors = new ArrayList<>();
        ArrayList<String> newActorRoles = new ArrayList<>();

        // CREATE A SCANNER FOR MOVIE TITLE
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nEnter movie title: ");
        String title = userInput.nextLine();

        // USE SCANNER FOR MOVIE YEAR
        // TO DO: MAKE IT NUMBER ONLY ( Handle Exception)
        // TO DO: HANDLE EXCEPTION
        System.out.println("\nEnter movie release year:");
        int year = userInput.nextInt();

        // LOOP FOR ADDING ACTORS AND ROLES
        boolean addActorLoop = true;
        while (addActorLoop) {

            //ADDING ACTOR
            System.out.println("\nEnter actor name:");
            String actor = userInput.nextLine();
            newMovieActors.add(actor);

            //ADDING ROLE
            System.out.println("\nEnter actor's role:");
            String actorRole = userInput.nextLine();
            newActorRoles.add(actorRole);

            // ADD ANOTHER ACTOR LOOP
            System.out.println("\nDo you want to add another actor?" +
                    "\n· Yes" +
                    "\n· No");
            Scanner userInput1 = new Scanner(System.in);
            String userAnswer1 = userInput1.nextLine();

            // ADD ANOTHER ACTOR - ANSWER WRONG
            if (!userAnswer1.equalsIgnoreCase("no") && !userAnswer1.equalsIgnoreCase("yes")) {
                System.out.println("\n! Please answer with yes or no !");
            }

            // ADD ANOTHER ACTOR - ANSWER NO
            if (userAnswer1.equalsIgnoreCase("no")) {
                addActorLoop = false;

                // ADD MOVIE IN THE ARRAYLIST OF MOVIES CREATING A NEW MOVIE OBJECT
                Main.movies.add(new Movie(title, year, newMovieActors, newActorRoles));

                System.out.println("\nOk, here you have the movie you have added:  " +
                        "\nTitle: " + title + " " + "( " + year + " )" + "\n" +
                        newMovieActors + "\n" +
                        newActorRoles + "\n");

                System.out.println("What do you want to do now?");
                menuSystemControlOptions();
            }

            // ADD ANOTHER ACTOR - ANSWER YES
            if (userAnswer1.equalsIgnoreCase("yes")) {
                addActorLoop = true;
            }
        }

    }

    // SHOULD WORK NOT SURE
    public static void updateMovie() {

        // LOOP FOR REMOVING MOVIE
        boolean removeMovieLoop = true;
        while (removeMovieLoop){

        System.out.println(Main.movies +
        "\n· Please write the title of the movie you want to remove:");

        // CREATE SCANNER FOR MOVIE THAT YOU WANT TO REMOVE
        Scanner userInput = new Scanner(System.in);
        String userTitle = userInput.nextLine();

        // FOR EACH LOOP TO CHECK IF THE ARRAYLIST CONTAINS THE MOVIE
        for (Movie movie : Main.movies){

            if (movie.getName().equalsIgnoreCase(userTitle)){

                // SUCCESS SCENARIO
                Main.movies.remove(movie);
                removeMovieLoop = false;

                // LOOP FOR REMOVING ANOTHER MOVIE
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
                        System.out.println("\n! Please answer with yes or no !");
                    }

                    // ADD ANOTHER MOVIE - ANSWER NO
                    if (userAnswer1.equalsIgnoreCase("no")) {
                        loopAddAnotherMovie =false;
                        System.out.println("\nOk, here you have your list updated: " + Main.movies + "\n");
                        menuSystemControlOptions();
                    }

                    // ADD ANOTHER MOVIE - ANSWER YES
                    if (userAnswer1.equalsIgnoreCase("yes")) {
                        loopAddAnotherMovie = true;
                    }
                }

            } else {
                System.out.println("! Movie not found, please try again !");
            }
        }
        }


    }

    // DOESN'T WORK THE FOR EACH LOOP
    public static void displayMovie(){

        System.out.println("Here you can find the movie list: ");
        /*
        for (Movie movie : Main.movies){
            System.out.println(movie.getTitle());
        }
         */

        System.out.println("\nWhat do you want to do now ?");
        menuSystemControlOptions();
    }

    //DOESN'T WORK THE FOR EACH LOOP
    public static void displayActors (){
        System.out.println("Here you can find the movie list: ");
        /*
        for (Movie movie : Main.movies){
            System.out.println(movie.getActors());
        }
        */
        System.out.println("\nWhat do you want to do now ?");
        menuSystemControlOptions();
    }

        /*--------------–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
         PREVIOUS UPDATE MOVIE - DELETE LATER

        Scanner overwriteFile = new Scanner(System.in);
        System.out.println("Enter movie title: ");
        String title = overwriteFile.nextLine();
        System.out.println("Enter movie release year: ");
        int year = Integer.parseInt(overwriteFile.nextLine());
        System.out.println("Enter actor (name): -> Press 'Enter' -> Enter character in movie: ");
        String actors = overwriteFile.nextLine();
        String character = overwriteFile.nextLine();


        // Overwrites the text file that matches the movie title
        File updatesMovieFile = new File(title);
        FileOutputStream um = new FileOutputStream(updatesMovieFile, false);
        PrintStream userInput1 = new PrintStream(um);

        userInput1.println("Movie title: \t" + title);
        userInput1.println("Release year: \t" + year);
        userInput1.println("Actors: \t\t\t\t" + "Characters:");
        userInput1.println(actors + "\t\t\t\t" + character);

        File updatesMovieActors = new File(title + " (actors)");
        FileOutputStream ma = new FileOutputStream(updatesMovieActors, false);
        PrintStream userInput2 = new PrintStream(ma);

        userInput2.println("Actors: \t\t\t\t" + "Characters:");
        userInput2.println(actors + "\t\t\t\t" + character);

        boolean keepAsking = true;
        while (keepAsking) {
            Scanner newCharacter = new Scanner(System.in);
            System.out.println("Press '1' to add more characters");
            System.out.println("Press '2' for complete update, go back to System Control Options");
            int oneOrTwo = newCharacter.nextInt();
            if (oneOrTwo == 1) {
                Scanner addCharacterToFile = new Scanner(System.in);
                System.out.println("Enter actor (name): -> Press 'Enter' -> Enter character in movie: ");
                String ac = addCharacterToFile.nextLine();
                String ch = addCharacterToFile.nextLine();
                File addToMovieFile = new File(title);
                FileOutputStream atm = new FileOutputStream(addToMovieFile, true);
                PrintStream userInput3 = new PrintStream(atm);
                userInput3.println(ac + "\t\t\t\t" + ch);
                File addToActorsFile = new File(title + " (actors)");
                FileOutputStream ata = new FileOutputStream(addToActorsFile, true);
                PrintStream userInput4 = new PrintStream(ata);
                userInput4.println(ac + "\t\t\t\t" + ch);
                App.appMainChoices();
                keepAsking = false;
            }
            if (oneOrTwo == 2) {
                App.appMainChoices();
                keepAsking = false;
            } else {
                System.out.println("type '1' or '2'");
            }
        }
    }
--------------––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– /*
    public static void displayMovie() {
        // TODO
        Scanner displayMovieFile = new Scanner(System.in);
        System.out.println("Enter movie title: ");
        String title = displayMovieFile.nextLine();

        SystemControlOptions fileReader = new SystemControlOptions();

        boolean didOpen = fileReader.openFile(title);

        if (didOpen) {
            while (fileReader.getScanner().hasNextLine()) {
                System.out.println(fileReader.readAndReturnOneLine());
            }

            fileReader.closeFileAfterUse();

            System.out.println("");

            Scanner newSearch = new Scanner(System.in);
            System.out.println("Press '1' for new search");
            System.out.println("Press '2' for System Control Options");
            int oneOrTwo = newSearch.nextInt();

            if (oneOrTwo == 1) {
                displayMovie(userList, movieList, movies1);
            } else {
                App.appMainChoices();
            }
        }
 --------------––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– */
    // Creates a text file for each movie title
        /* PREVIOUS CREATE MOVIE DELETE LATER
        File createsMovieFile = new File(title);
        FileOutputStream cm = new FileOutputStream(createsMovieFile, false);
        PrintStream userInput2 = new PrintStream(cm);


        userInput2.println("Movie title: \t" + title);
        userInput2.println("Release year: \t" + year);
        userInput2.println("Actors: \t\t\t\t" + "Characters:");
        userInput2.println(actors + "\t\t\t\t" + character);


        File addsToMovieActors = new File(title + " (actors)");
        FileOutputStream ma = new FileOutputStream(addsToMovieActors, false);
        PrintStream userInput1 = new PrintStream(ma);

        userInput1.println("Actors: \t\t\t\t" + "Characters:");
        userInput1.println(actors + "\t\t\t\t" + character);


        boolean keepAsking = true;
        while (keepAsking) {
            Scanner newCharacter = new Scanner(System.in);
            System.out.println("Press '1' to add more characters");
            System.out.println("Press '2' for complete creating, go back to System Control Options");
            int oneOrTwo = newCharacter.nextInt();
            if (oneOrTwo == 1) {
                Scanner addCharacterToFile = new Scanner(System.in);
                System.out.println("Enter actor (name): -> Press 'Enter' -> Enter character in movie: ");
                String ac = addCharacterToFile.nextLine();
                String ch = addCharacterToFile.nextLine();
                File addToMovieFile = new File(title);
                FileOutputStream atm = new FileOutputStream(addToMovieFile, true);
                PrintStream userInput3 = new PrintStream(atm);
                userInput3.println(ac + "\t\t\t\t" + ch);
                File addToActorsFile = new File(title + " (actors)");
                FileOutputStream ata = new FileOutputStream(addToActorsFile, true);
                PrintStream userInput4 = new PrintStream(ata);
                userInput4.println(ac + "\t\t\t\t" + ch);
                App.appMainChoices();
                keepAsking = false;
            }
            if (oneOrTwo == 2) {
                App.appMainChoices();
                keepAsking = false;
            } else {
                System.out.println("type '1' or '2'");
            }
        }

        ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– */
}
