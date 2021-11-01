import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagementSystem {

    // Check on register that USERNAME is not taken
    // Create a loop so if username or password wrong it goes directly to
    // asking for username and password again without the choosing.


    public static User currentUser = null;

    public static void start() {
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("Are you an existing user or do you want to register?");
            System.out.println("Press the number for the desired option and press enter");
            System.out.println();
            System.out.println("· 1. Log In");
            System.out.println("· 2. Register");

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
                System.out.println("! Please choose a number from the list !");
                System.out.println();
            }
        }
    }

    public static void userRegister() {
        Scanner registerUser = new Scanner(System.in);
        System.out.println("\n· Enter username: ");
        String username = registerUser.nextLine();
        System.out.println("\n· Enter password: ");
        String password = registerUser.nextLine();
        System.out.println("Registering");

        ArrayList<Movie> favourite = new ArrayList<>();
        ArrayList<String> history = new ArrayList<>();

        User newUser = new User(username, password, favourite, history);

        Main.users.add(newUser);

        currentUser = newUser;

        App.appMainChoices();

    }

    public static void userLogin() {
        boolean userFound = false;

        while (!userFound) {
            Scanner LoginUser = new Scanner(System.in);
            System.out.println("\n· Enter username: ");
            String usernameLogin = LoginUser.nextLine();
            System.out.println("\n· Enter password: ");
            String passwordLogin = LoginUser.nextLine();

            for (User user : Main.users) {
                if (user.getUsername().equalsIgnoreCase(usernameLogin) && user.getPassword().equals(passwordLogin)) {
                    System.out.println("\nLogging in");
                    currentUser = user;
                    userFound = true;
                    App.appMainChoices();
                }
            }

            if (!userFound){
                System.out.println("! Wrong username and password !");
            }
        }
    }
}