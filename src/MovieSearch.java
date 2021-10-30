import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieSearch {

    public static void start(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {

        // TODO
        // Kim
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("Welcome to Movie Search Options");
            System.out.println("Search for a movie, press 1");
            System.out.println("Search for a year, press 2");
            System.out.println("Go back, press 3");

            int choice = App.userChoice();

            if (choice == 1) {
                // Go to CREATE MOVIE
                MovieSearch.searchMovie(userList, movieList, movies1);
                keepAsking = false;
            } else if (choice == 2) {
                // Go to UPDATE MOVIE
                MovieSearch.searchMovieYear(userList, movieList, movies1);
                keepAsking = false;
            } else if (choice == 3) {
                // Go to UPDATE MOVIE
                App.appMainChoices(userList, movieList, movies1);
                keepAsking = false;
            } else {
                System.out.println("Pick one of the choices, c'mon");
            }
        }
    }

    public static void searchMovie(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Search for a title");
        boolean found = false;
        String searchTitle = sc.nextLine();
        for(Movie i : movies1) {
            if(i.getTitle().contains(searchTitle)){
                System.out.println(i);
                found = true;
            }
        }
        if(found != true) {
            System.out.println("Title not found!");
            System.out.println("New search, type '1'");
            System.out.println("Go back, type '2'");
            Scanner s = new Scanner(System.in);
            int one = s.nextInt();
            if (one == 1) {
                searchMovie(userList, movieList, movies1);
            } else {
                MovieSearch.start(userList, movieList, movies1);
            }

        }
    }

    // Searches for the movie year
    public static void searchMovieYear(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Search for a year");
        boolean found = false;
        int searchYear = sc.nextInt();
        for(Movie i : movies1) {
            if(i.getProdYear() == searchYear){
                System.out.println(i);
                found = true;
            }
        }
        if(found != true) {
            System.out.println("No movies for this year!");
            System.out.println("New search, type '1'");
            System.out.println("Go back, type '2'");
            Scanner s = new Scanner(System.in);
            int one = s.nextInt();
            if (one == 1) {
                searchMovieYear(userList, movieList, movies1);
            } else {
                MovieSearch.start(userList, movieList, movies1);
            }

        }
    }

}