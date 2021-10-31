import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagementSystem {
    // Having a public static User that exists until logging out.
    public static User currentUser = null;

    public static void start() {
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("Are you an existing user or do you want to register?");
            System.out.println("Press the number for the desired option and press enter.");
            System.out.println();
            System.out.println("1. Log In.");
            System.out.println("2. Register.");

            int choice = App.userChoice();

            // Choices:
            if (choice == 1) {
                userLogin();
                keepAsking = false;
            } else if (choice == 2) {
                userRegister();
                keepAsking = false;
            } else {
                System.out.println();
                System.out.println("Please choose from a number in the list.");
                System.out.println();
            }
        }
    }

    public static void userRegister(){

        System.out.println("So nice that you want to register!");
        Scanner registerUser = new Scanner(System.in);

        // Boolean for asking until a username is not taken.
        boolean keepAskingUsername = true;
        while (keepAskingUsername) {
            System.out.println("Please chose a username:");
            String username = registerUser.nextLine();

            boolean invalidUsername = false;

            for (User user : Main.users) {
                if (username.equalsIgnoreCase(user.getUsername())) {
                    System.out.println("I'm sorry, the name has already been chosen.");
                    invalidUsername = true;
                }
            }

            if (!invalidUsername){
                System.out.println("Great! Now please choose a password:");
                String password = registerUser.nextLine();

                Main.users.add(new User(username, password, new ArrayList<Movie>(), new ArrayList<String>()));
                keepAskingUsername = false;

                // ADD SERIALIZING OF THE NEW USERS TODO

                userLogin();
            }
        }
    }

    public static void userLogin() {

        System.out.println("Welcome back! Let's log in");
        Scanner logInUser = new Scanner(System.in);

        boolean keepAsking = true;

        while (keepAsking){
            System.out.println("Please enter your Username:");
            String username = logInUser.nextLine();
            System.out.println("Please enter your password:");
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
                System.out.println("Username and password not valid :( ");
            }
        }
    }
}