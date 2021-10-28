import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayMovie {


    private static ArrayList<Movie> listOfMovies = new ArrayList<>();


    public static void start(File movieList) throws FileNotFoundException {
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

        playMovie();
    }

    public static void playMovie(){
        System.out.println("Hello, pal!");
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
        }
    }
}
