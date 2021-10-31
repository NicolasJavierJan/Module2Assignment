import java.io.*;
import java.util.ArrayList;

//  Message for Username or Password, when not found
// Serialize Users.
// Create Serializing and Deserializing methods at the beginning of the Main method
// Create public arrayLists that can go for every person.
// Do the SEE STATISTICS

public class Main {

    public static ArrayList<Movie> movies = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
/*
        // This is ONLY for the first time. Delete later (or comment out)

        // ArrayLists of Movies and Users
        ArrayList<Movie> movieArray = addingMovie();
        ArrayList<User> userArray = addingUser();

        // Serializing Movie ArrayList and User ArrayList

        serializeMovies(movieArray);
        serializeUser(userArray);
*/
        // This is what should happen first:
        // Deserialize Users and Movies .ser file and
        // create the users and movies arraylist accessible for all the other classes.

        try {
            FileInputStream moviesIn = new FileInputStream("src/Movies.ser");
            FileInputStream usersIn = new FileInputStream("src/Users.ser");

            ObjectInputStream oisMovies = new ObjectInputStream(moviesIn);
            ObjectInputStream oisUsers = new ObjectInputStream(usersIn);

            Main.movies = (ArrayList) oisMovies.readObject();
            Main.users = (ArrayList) oisUsers.readObject();

            oisMovies.close();
            oisUsers.close();
            moviesIn.close();
            usersIn.close();

        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }

        System.out.println("\n--- WELCOME TO MOVIE TIME ---");
        System.out.println();
        // First of all, going to Register/Login.
        UserManagementSystem.start();

    }

/*
    // Method for creating ONE EXAMPLE MOVIE, ONLY FIRST TIME. IT CAN BE DELETED LATER.
    public static ArrayList<Movie> addingMovie(){
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

        return movies;
    }

    public static ArrayList<User> addingUser(){
        ArrayList<Movie> favouriteList = new ArrayList<>();
        ArrayList<String> historyList = new ArrayList<>();

        User admin = new User("admin", "admin", favouriteList, historyList);

        ArrayList<User> users = new ArrayList<>();
        users.add(admin);

        return users;
    }

    public static void serializeMovies(ArrayList<Movie> movieList){
        try {
            FileOutputStream fosMovies = new FileOutputStream("src/Movies.ser");
            ObjectOutputStream oosMovies = new ObjectOutputStream(fosMovies);

            oosMovies.writeObject(movieList);
            oosMovies.close();
            fosMovies.close();

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void serializeUser(ArrayList<User> userList){
        try {
            FileOutputStream fosUser = new FileOutputStream("src/Users.ser");
            ObjectOutputStream oosUser = new ObjectOutputStream(fosUser);

            oosUser.writeObject(userList);
            oosUser.close();
            fosUser.close();

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

 */
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
