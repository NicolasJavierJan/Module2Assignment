import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieSearch {

    public static void start() {

        System.out.println("\n--- Search Movie ---");
        movieSearchMenu();
    }

    public static void movieSearchMenu() {
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("\n· 1. Search movie by title" +
                    "\n· 2. Search movie by release year" +
                    "\n· 9. Go Back to Main Menu");

            int choice = App.userChoice();

            if (choice == 1) {
                MovieSearch.searchMovie();
                keepAsking = false;
            } else if (choice == 2) {
                MovieSearch.searchMovieYear();
                keepAsking = false;
            } else if (choice == 9) {
                App.appMainChoices();
                keepAsking = false;
            } else {
                System.out.println("! Please write a number to choose one of the following options !\n");
            }
        }
    }

    public static void searchMovie()  {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n· Search for a title");
        ArrayList<Movie> foundMovies = new ArrayList<>();
        String searchTitle = sc.nextLine();
        for (Movie i : Main.movies) {
            if (i.getName().contains(searchTitle)) {
                foundMovies.add(i);
            }
        }
        if(foundMovies.size() == 0) {
            System.out.println("\n! Title not found !\n" +
                    "\n· 1. New search" +
                    "\n· 9. Go back");
            int one = App.userChoice();
            if (one == 1) {
                searchMovie();
            } else if (one == 9) {
                MovieSearch.start();
            }

        } else {
            System.out.println(foundMovies);
        }
    }

    // Searches for the movie year
    public static void searchMovieYear()  {
        System.out.println("\n· Search for a year: ");
        boolean found = false;
        int searchYear = App.userChoice();

        for(Movie i : Main.movies) {
            if(i.getYear() == searchYear){
                System.out.println(" ");
                System.out.println(i.getName());
                found = true;
                movieSearchMenu();
            }
        }


        if(found != true) {
            if (searchYear == 0){
                System.out.println("· 1. New search" +
                        "\n· 9. Go back");
                int one = App.userChoice();
                if (one == 1) {
                    searchMovieYear();
                } else if (one == 9) {
                    MovieSearch.start();
                }
            } else {
                System.out.println("\n! No movies for this year !" +
                        "\n· 1. New search" +
                        "\n· 9. Go back");
                int one = App.userChoice();
                if (one == 1) {
                    searchMovieYear();
                } else if (one == 9) {
                    MovieSearch.start();
                }
            }
        }
    }

}