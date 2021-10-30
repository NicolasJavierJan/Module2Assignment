import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SystemControlOptions {
    public static void start(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {

        // TODO
        // KASPER
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("Welcome to System Control Options");
            System.out.println("If you want to CREATE a Movie, press 1");
            System.out.println("If you want to UPDATE a Movie, press 2");
            System.out.println("If you want to DISPLAY a Movie, press 3");
            System.out.println("If you want to DISPLAY Actors, press 4");
            System.out.println("Go back, press 5");

            int choice = App.userChoice();

            if (choice == 1) {
                // Go to CREATE MOVIE
                SystemControlOptions.createMovie(userList, movieList, movies1);
                keepAsking = false;
            } else if (choice == 2) {
                // Go to UPDATE MOVIE
                SystemControlOptions.updateMovie(userList, movieList, movies1);
                keepAsking = false;
            } else if (choice == 3) {
                // Go to DISPLAY MOVIE
                SystemControlOptions.displayMovie(userList, movieList, movies1);
                keepAsking = false;
            } else if (choice == 4) {
                // Go to DISPLAY Actors
                SystemControlOptions.displayActors(userList, movieList, movies1);
                keepAsking = false;
            } else if (choice == 5) {
                App.appMainChoices(userList, movieList, movies1);
                keepAsking = false;
            } else {
                System.out.println("Pick one of the choices, c'mon");
            }
        }
    }

    public static void createMovie(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        // TODO
        Scanner makeNewFile = new Scanner(System.in);
        System.out.println("Enter movie title: ");
        String title = makeNewFile.nextLine();
        System.out.println("Enter movie release year: ");
        int year = Integer.parseInt(makeNewFile.nextLine());
        System.out.println("Enter actor (name): -> Press 'Enter' -> Enter character in movie: ");
        String actors = makeNewFile.nextLine();
        String character = makeNewFile.nextLine();

        // Creates a text file for each movie title
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
                App.appMainChoices(userList, movieList, movies1);
                keepAsking = false;
            }
            if (oneOrTwo == 2) {
                App.appMainChoices(userList, movieList, movies1);
                keepAsking = false;
            } else {
                System.out.println("type '1' or '2'");
            }
        }
    }

    public static void updateMovie(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        // TODO
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
                App.appMainChoices(userList, movieList, movies1);
                keepAsking = false;
            }
            if (oneOrTwo == 2) {
                App.appMainChoices(userList, movieList, movies1);
                keepAsking = false;
            } else {
                System.out.println("type '1' or '2'");
            }
        }
    }

    public static void displayMovie(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
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
                App.appMainChoices(userList, movieList, movies1);
            }
        }

        // something with hasNextLine to print all lines in the file.
        /*
        fileReader.openFile(title);
        fileReader.readAndReturnOneLine();
        fileReader.readAndReturnOneLine();
        fileReader.readAndReturnOneLine();
        fileReader.closeFileAfterUse();

        System.out.println("");

        Scanner newSearch = new Scanner(System.in);
        System.out.println("Press '1' for new search");
        System.out.println("Press '2' for System Control Options");
        int oneOrTwo = newSearch.nextInt();

        if (oneOrTwo == 1) {
            displayMovie();
        } else {
            App.appMainChoices();
        }
        */
    }

    public static void displayActors(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        // TODO
        Scanner displayActorsFile = new Scanner(System.in);
        System.out.println("Enter movie title: ");
        String title = displayActorsFile.nextLine();

        SystemControlOptions fileReader = new SystemControlOptions();

        boolean didOpen = fileReader.openFile(title + " (actors)");

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
                displayActors(userList, movieList, movies1);
            } else {
                App.appMainChoices(userList, movieList, movies1);
            }
        }

        /*
        fileReader.openFile(title + " (actors)");
        fileReader.readAndReturnOneLine();
        fileReader.readAndReturnOneLine();
        fileReader.readAndReturnOneLine();

        // something with hasNextLine to print all lines in the file.

        fileReader.closeFileAfterUse();

        System.out.println("");

        Scanner newSearch = new Scanner(System.in);
        System.out.println("Press '1' for new search");
        System.out.println("Press '2' for System Control Options");
        int oneOrTwo = newSearch.nextInt();

        if (oneOrTwo == 1) {
            displayActors();
        } else {
            App.appMainChoices();
        }
        */
    }

    private Scanner input;

    public Boolean openFile(String filename)
    {
        Boolean success = false;
        File f = new File(filename);

        try {
            input = new Scanner(f);
            success = true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Error. File not found");
        }
        return success;
    }

    public Scanner getScanner() {
        return input;
    }

    public void closeFileAfterUse()
    {
        input.close();
    }

    public String readAndReturnOneLine()
    {
        String line = "";
        System.out.println(input.nextLine());
        return line;
    }
}