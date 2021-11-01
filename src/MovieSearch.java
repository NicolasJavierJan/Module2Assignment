import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieSearch {


    public static void start() {

        System.out.println("--- Search Movie ---");
        movieSearchMenu();
    }

    private static void movieSearchMenu() {
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("· 1. Search movie by title" +
                    "\n· 2. Search movie by year" +
                    "\n· 9. Go Back");

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
                System.out.println("! Please write a number and choose one of the following options !\n");
            }
        }
    }

    public static void searchMovie()  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Search for a title");
        boolean found = false;
        String searchTitle = sc.nextLine();
        for (Movie i : Main.movies) {
            if (i.getName().contains(searchTitle)) {
                System.out.println(i.getName()  );
                found = true;
            }
        }
        if(found != true) {
            System.out.println("! Title not found !" +
                    "\n· 1. New search" +
                    "\n· 9. Go back");
            int one = App.userChoice();
            if (one == 1) {
                searchMovie();
            } else if (one == 9) {
                MovieSearch.start();
            }

        }
    }

    // Searches for the movie year
    public static void searchMovieYear()  {
        System.out.println("· Search for a year: ");
        boolean found = false;
        int searchYear = App.userChoice();

        for(Movie i : Main.movies) {
            if(i.getYear() == searchYear){
                System.out.println(i.getName());
                found = true;
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
                System.out.println("! No movies for this year !" +
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