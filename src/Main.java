import java.io.*;
import java.util.ArrayList;

//  Message for Username or Password, when not found
// Serialize Users.
// Create Serializing and Deserializing methods at the beginning of the Main method
// Create public arrayLists that can go for every person.
// Do the SEE STATISTICS

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO
        // NICO
        // ******* Nico did this part *******

        // Create/Read from Users File
        File userList = new File("src/users.txt");
        // Create/Read from Movies File
        File movieList = new File("src/movies.txt");

        ArrayList<Movie> movies1 = new ArrayList<>();

        // Serializing Movie ArrayList
        try {
            FileOutputStream fos = new FileOutputStream("src/Movies.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(addingMovies());
            oos.close();
            fos.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        /*
        // Deserializing Movie ArrayList
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("src/Movies.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            movies = (ArrayList) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        for (Movie movie : movies){
            movie.printInfo();
        }
        */

        System.out.println("Hello, there! Welcome to the Movies App");
        System.out.println();
        UserManagementSystem.start(userList, movieList, movies1);


    }

    // ******* Nico used this ************
    public static ArrayList<Movie> addingMovies(){
        ArrayList<String> actors = new ArrayList<>();
        actors.add("Nico");
        actors.add("Andrea");
        actors.add("Jasmin");

        ArrayList<String> roles = new ArrayList<>();
        roles.add("Example 1");
        roles.add("Example 2");
        roles.add("Example 3");

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie 1", 2021, actors, roles));
        movies.add(new Movie("Movie 2", 2020, actors, roles));
        movies.add(new Movie("Movie 3", 2019, actors, roles));

        return movies;
    }





    // ******* Kim used this ************
    // Arraylist
    // Movie arraylist constructed with movie class.
    ArrayList<Movie> movies1 = new ArrayList<>();
    //ArrayList<Actor> actors = new ArrayList<>();

    // Movie names (I used video game names)
    Movie m1 = new Movie("RedDead Redemption", 2015);
    Movie m2 = new Movie("Skyrim", 2012);
    Movie m3 = new Movie("Witcher 3", 2015);

    /*
    // Adding to the movie arraylist
        movies1.add(m1);
        movies1.add(m2);
        movies1.add(m3);


    // Search methods
    MovieSearch.searchMovie(movies1);
    MovieSearch.searchMovieYear(movies1);
     */
}