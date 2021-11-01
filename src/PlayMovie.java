import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayMovie {

    private static ArrayList<Movie> listOfMovies = new ArrayList<>();

    public static void start() {
        playMovie();
    }

    public static void playMovie()  {
        System.out.println("· Which movie would you like to see?");

        Scanner userInput = new Scanner(System.in);
        String userResponse = userInput.nextLine();

        Movie movieFound =  null;

        for (Movie movie : Main.movies){
            if (movie.getName().equalsIgnoreCase(userResponse)){
                movieFound = movie;
            }
        }

        if (movieFound != null){
            movieFound.printInfo();
            System.out.println();
            System.out.println("· 1. Play another movie");
            System.out.println("· 9. Go back");
            boolean keepAsking = true;
            while (keepAsking) {
                Scanner answer = new Scanner(System.in);
                int oneOrTwo = answer.nextInt();
                if (oneOrTwo == 1) {
                    playMovie();
                } else if (oneOrTwo == 9) {
                    App.appMainChoices();
                } else {
                    System.out.println("! Please write a number and choose one of the following options !");
                }
            }
        } else {
            System.out.println("! Cannot find that movie, pal. Sorry ☺ !");
            System.out.println("· 1. Play another movie");
            System.out.println("· 9. Go back");
            boolean keepAsking = true;
            while (keepAsking) {
                Scanner answer = new Scanner(System.in);
                int oneOrTwo = answer.nextInt();
                if (oneOrTwo == 1) {
                    playMovie();
                } else if (oneOrTwo == 9) {
                    App.appMainChoices();
                } else {
                    System.out.println("! Please write a number and choose one of the following options !");
                }
            }
        playMovie();
        }
    }

}