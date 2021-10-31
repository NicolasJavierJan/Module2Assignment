import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieSearch {


    public static void start(File userList, File movieList, ArrayList<Movie> movies1) {

        System.out.println("--- Search Movie ---");
        movieSearchMenu(userList, movieList, movies1);
    }

    private static void movieSearchMenu(File userList, File movieList, ArrayList<Movie> movies1) {
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("· 1. Search movie by title" +
                    "\n· 2. Search movie by year" +
                    "\n· 9. Go Back");

            int choice = App.userChoice();

            if (choice == 1) {
                // Go to CREATE MOVIE
                MovieSearch.searchMovie(userList, movieList, movies1);
                keepAsking = false;
            } else if (choice == 2) {
                // Go to UPDATE MOVIE
                MovieSearch.searchMovieYear(userList, movieList, movies1);
                keepAsking = false;
            } else if (choice == 9) {
                // Go to UPDATE MOVIE
                App.appMainChoices();
                keepAsking = false;
            } else {
                System.out.println("! Please write a number and choose one of the following options !\n");
            }
        }
    }

    public static void searchMovie(File userList, File movieList, ArrayList<Movie> movies1)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Search for a title");
        boolean found = false;
        String searchTitle = sc.nextLine();
        for (Movie i : movies1) {
            if (i.getName().contains(searchTitle)) {
                System.out.println(i);
                found = true;
            }
        }
        if(found != true) {
            System.out.println("! Title not found !" +
                    "\n· 1. New search" +
                    "\n· 9. Go back");
            int one = App.userChoice();
            if (one == 1) {
                searchMovieYear(userList, movieList, movies1);
            } else if (one == 9) {
                MovieSearch.start(userList, movieList, movies1);
            }

        }
    }

    // Searches for the movie year
    public static void searchMovieYear(File userList, File movieList, ArrayList<Movie> movies1)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("· Search for a year: ");
        boolean found = false;
        int searchYear = sc.nextInt();
        for(Movie i : movies1) {
            if(i.getYear() == searchYear){
                System.out.println(i);
                found = true;
            }
        }
        if(found != true) {
            System.out.println("! No movies for this year !" +
                    "\n· 1. New search" +
                    "\n· 9. Go back");
            int one = App.userChoice();
            if (one == 1) {
                searchMovieYear(userList, movieList, movies1);
            } else if (one == 9) {
                MovieSearch.start(userList, movieList, movies1);
            }

        }
    }

}