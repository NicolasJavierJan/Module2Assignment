import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayMovie {

    public static void start() {

        System.out.println("\n--- Play Movie ---");
        playMovie();
    }

    public static void playMovie()  {
        System.out.println("\nMovie List: ");

        for (Movie movie: Main.movies){
            System.out.println(movie.toString());
        }
        System.out.println("\n· Which movie would you like to see?");

        Scanner userInput = new Scanner(System.in);
        String userResponse = userInput.nextLine();

        Movie movieFound =  null;

        for (Movie movie : Main.movies){
            if (movie.getName().equalsIgnoreCase(userResponse)){
                movieFound = movie;
            }
        }

        if (movieFound != null){
            if (movieFound.getName().equalsIgnoreCase("shrek")){
                System.out.println("⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀ ⣀⣀⣤⣤⣤⣀⡀\n" +
                        "⠸⡇⠀⠿⡀⠀⠀⠀⣀⡴⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀\n" +
                        "⠀⠀⠀⠀⠑⢄⣠⠾⠁⣀⣄⡈⠙⣿⣿⣿⣿⣿⣿⣿⣿⣆\n" +
                        "⠀⠀⠀⠀⢀⡀⠁⠀⠀⠈⠙⠛⠂⠈⣿⣿⣿⣿⣿⠿⡿⢿⣆\n" +
                        "⠀⠀⠀⢀⡾⣁⣀⠀⠴⠂⠙⣗⡀⠀⢻⣿⣿⠭⢤⣴⣦⣤⣹⠀⠀⠀⢀⢴⣶⣆\n" +
                        "⠀⠀⢀⣾⣿⣿⣿⣷⣮⣽⣾⣿⣥⣴⣿⣿⡿⢂⠔⢚⡿⢿⣿⣦⣴⣾⠸⣼⡿\n" +
                        "⠀⢀⡞⠁⠙⠻⠿⠟⠉⠀⠛⢹⣿⣿⣿⣿⣿⣌⢤⣼⣿⣾⣿⡟⠉\n" +
                        "⠀⣾⣷⣶⠇⠀⠀⣤⣄⣀⡀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\n" +
                        "⠀⠉⠈⠉⠀⠀⢦⡈⢻⣿⣿⣿⣶⣶⣶⣶⣤⣽⡹⣿⣿⣿⣿⡇\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠉⠲⣽⡻⢿⣿⣿⣿⣿⣿⣿⣷⣜⣿⣿⣿⡇\n" +
                        "⠀⠀ ⠀⠀⠀⠀⠀⢸⣿⣿⣷⣶⣮⣭⣽⣿⣿⣿⣿⣿⣿⣿⠇\n" +
                        "⠀⠀⠀⠀⠀⠀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇\n" +
                        "⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃ Nice");
                UserManagementSystem.currentUser.getHistoryList().add("Shrek, seen on " + LocalDate.now());
            } else {
                movieFound.printInfo();
                UserManagementSystem.currentUser.getHistoryList().add(movieFound.getName() + " seen on " + LocalDate.now());
            }
            System.out.println("\n· 1. Play another movie" +
                    "\n· 9. Go back to Main Menu");
            boolean keepAsking = true;
            while (keepAsking) {
                Scanner answer = new Scanner(System.in);
                int oneOrTwo = answer.nextInt();
                if (oneOrTwo == 1) {
                    playMovie();
                } else if (oneOrTwo == 9) {
                    App.appMainChoices();
                } else {
                    System.out.println("! Please write a number to choose one of the following options !");
                }
            }
        } else {
            System.out.println("\n! Movie not found !");
            System.out.println("\n· 1. Play another movie" +
                    "\n· 9. Go Back to Main Menu");
            boolean keepAsking = true;
            while (keepAsking) {
                Scanner answer = new Scanner(System.in);
                int oneOrTwo = answer.nextInt();
                if (oneOrTwo == 1) {
                    playMovie();
                } else if (oneOrTwo == 9) {
                    App.appMainChoices();
                } else {
                    System.out.println("! Please write a number to choose one of the following options !");
                }
            }
        playMovie();
        }
    }

}