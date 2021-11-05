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
            System.out.println("\nAre you an existing user or do you want to register?");
            System.out.println("Press the number for the desired option and press enter");
            System.out.println();
            System.out.println("· 1. Log In");
            System.out.println("· 2. Register");
            System.out.println("· 3. Exit");

            int choice = App.userChoice();

            // Choices:
            if (choice == 1) {
                userLogin();
                keepAsking = false;
            } else if (choice == 2) {
                userRegister();
                keepAsking = false;
            } else if (choice == 3) {
                System.exit(0);
            } else {
                System.out.println();
                System.out.println("! Please choose a number from the list !");
                System.out.println();
            }
        }
    }

    public static void userRegister() {
        boolean usernameFound = true;
        while (usernameFound) {
                Scanner registerUser = new Scanner(System.in);
            System.out.println("\n· Enter a username: ");
            String username = registerUser.nextLine();
            System.out.println("\n· Enter a password: ");
            String password = registerUser.nextLine();

            ArrayList<Movie> favourite = new ArrayList<>();
            ArrayList<String> history = new ArrayList<>();

            User newUser = new User(username, password, favourite, history);

            usernameFound = false;
            for (User user : Main.users) {
                if (user.getUsername().equalsIgnoreCase(username)) {
                    System.out.println("Username is already taken, please choose a different one");
                    usernameFound = false;
                    start();
                }

            }
            if (!usernameFound) {
                System.out.println("You are now registered \n");
                System.out.println("Please Log in with your new account");
                Main.users.add(newUser);
                userLogin();
            }
        }
    }

    public static void userLogin() {
        boolean userFound = false;

        while (!userFound) {
            Scanner LoginUser = new Scanner(System.in);
            System.out.println("\n· Enter your username: ");
            String usernameLogin = LoginUser.nextLine();
            System.out.println("\n· Enter your password: ");
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
                System.out.println("\n! Wrong username or password !\n");

                boolean logInLoop = true;
                while (logInLoop){
                System.out.println("\nDo you want to try again?" +
                        "\n· Yes" +
                        "\n· No");
                String answer = LoginUser.nextLine();

                if (!answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("yes")) {
                    System.out.println("\n! Please answer with yes or no !");
                } else if (answer.equalsIgnoreCase("no")){
                    //System.out.println("I'll redirect you to the Register and Login page ☺");
                    userFound = true;
                    UserManagementSystem.start();
                }  else {
                    logInLoop = false;
                    userLogin();
                }
            }}
        }
    }
}