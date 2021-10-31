import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Jasmin - Nico - Done

public class UserManagementSystem {
    // Having a public static User that exists until logging out.
    public static User currentUser = null;

    public static void start() {

        System.out.println("Hello there," +
                "\nPlease log in to start using the app." +
                "\nDon't you have an account? Register now!\n");

        userManagementSystemMenu();

    }

    public static void userManagementSystemMenu(){
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("· 1. Log in" +
                    "\n· 2. Register");

            int choice = App.userChoice();

            // Choices:
            if (choice == 1) {
                userLogin();
                keepAsking = false;
            } else if (choice == 2) {
                userRegister();
                keepAsking = false;
            } else {
                System.out.println("\n ! Please ENTER a NUMBER and choose one of the following options !");
            }
        }
    }

    public static void userRegister(){

        System.out.println("\nSign up, it's quick and easy");
        Scanner registerUser = new Scanner(System.in);

        // Boolean for asking until a username is not taken.
        boolean keepAskingUsername = true;
        while (keepAskingUsername) {
            System.out.println("Please choose a username:");
            String username = registerUser.nextLine();

            boolean invalidUsername = false;

            for (User user : Main.users) {
                if (username.equalsIgnoreCase(user.getUsername())) {
                    System.out.println("\n! I'm sorry, this USERNAME has already been TAKEN !");
                    invalidUsername = true;
                }
            }

            if (!invalidUsername){
                System.out.println("\nGreat! Now please choose a password:");
                String password = registerUser.nextLine();

                Main.users.add(new User(username, password, new ArrayList<Movie>(), new ArrayList<String>()));
                keepAskingUsername = false;

                // ADD SERIALIZING OF THE NEW USERS TODO

                userLogin();
            }
        }
    }

    public static void userLogin() {

        System.out.println("\nWelcome back! Let's log in");

        Scanner logInUser = new Scanner(System.in);

        boolean keepAsking = true;
        while (keepAsking){

            System.out.println("Please enter your Username:");

            String username = logInUser.nextLine();

            System.out.println("\nPlease enter your Password:");
            String password = logInUser.nextLine();

            boolean foundUser = false;
            for (User user : Main.users){
                if (username.equalsIgnoreCase(user.getUsername()) && password.equalsIgnoreCase(user.getPassword())){
                    System.out.println("Logging innnnn");
                    keepAsking = false;
                    foundUser = true;
                    currentUser = user;
                }
            }

            if (foundUser){
                App.appMainChoices();
            } else {
                keepAsking = false;
                System.out.println("\n! Username and password not valid :( !\n");
                userManagementSystemMenu();

            }
        }
    }
}