import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayMovie {
    /*
    private static ArrayList<Movie> listOfMovies = new ArrayList<>();

    public static void start(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        // TODO
        // Try to deserialize the ArrayList of Movies.
        try {
            FileInputStream fileIn = new FileInputStream("src/Movies.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            listOfMovies = (ArrayList) in.readObject();

            in.close();
            fileIn.close();

        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }

        playMovie(userList, movieList, movies1);
    }

    public static void playMovie(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
        System.out.println("Which movie would you like to see?");

        Scanner userInput = new Scanner(System.in);
        String userResponse = userInput.nextLine();

        Movie movieFound =  null;

        for (Movie movie : listOfMovies){
            if (movie.getName().equalsIgnoreCase(userResponse)){
                movieFound = movie;
            }
        }

        if (movieFound != null){
            movieFound.printInfo();
        } else {
            System.out.println("Cannot find that movie, pal. Sorry ☺");
            System.out.println("Type 1, to try again!");
            System.out.println("Type 2, to go back");
            boolean keepAsking = true;
            while (keepAsking) {
                Scanner answer = new Scanner(System.in);
                int oneOrTwo = answer.nextInt();
                if (oneOrTwo == 1) {
                    playMovie(userList, movieList, movies1);
                } else if (oneOrTwo == 2) {
                    App.appMainChoices(userList, movieList, movies1);
                } else {
                    System.out.println("type '1' or '2'");
                }
            }
        playMovie(userList, movieList, movies1);
        }
    }
*/
}