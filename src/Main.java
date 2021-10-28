import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Create/Read from Users File
        File userList = new File("src/users.txt");
        // Create/Read from Movies File
        File movieList = new File("src/movies.txt");

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
        UserManagementSystem.start(userList, movieList);
    }

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
}

