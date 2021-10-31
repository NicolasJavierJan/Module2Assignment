import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagementSystem {

    public static ArrayList<UserInfo> registerInfo = new ArrayList<UserInfo>();
    public static ArrayList<User> currentUser = null;

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

        boolean keepAskingUsername = true;
        while (keepAskingUsername) {
            System.out.println("Please chose a username:");
            String username = registerUser.nextLine();

            boolean usernameChosen = false;

            for (User user : Main.users) {
                if (username.equalsIgnoreCase(user.getUsername())) {
                    System.out.println("I'm sorry, the name has already been chosen.");
                    usernameChosen = true;
                }
            }

            if (!usernameChosen){
                System.out.println("Great! Now please choose a password:");
                String password = registerUser.nextLine();

                Main.users.add(new User(username, password, new ArrayList<Movie>(), new ArrayList<String>()));
                keepAskingUsername = false;
            }
        }

        for (User user : Main.users){
            user.printInfo();
        }


        /*
        Scanner registerUser = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = registerUser.nextLine();
        System.out.println("Enter password: ");
        String password = registerUser.nextLine();
        System.out.println("Registering");
        UserInfo login = new UserInfo (username, password);
        registerInfo.add(login);
        */
    }

    public static void userLogin() {
        /*
        Scanner LoginUser = new Scanner(System.in);
        System.out.println("Enter username: ");
        String usernameLogin = LoginUser.nextLine();
        System.out.println("Enter password: ");
        String passwordLogin = LoginUser.nextLine();


        boolean keepAsking = true;

        while (keepAsking) {
            for (int i = 0; i < registerInfo.size(); i++) {
                if (registerInfo.get(i).getUserName().equals(usernameLogin)
                        && registerInfo.get(i).getPassword().equals(passwordLogin)) {
                    System.out.println("logging in");
                    App.appMainChoices(userList, movieList, movies1);
                    keepAsking = false;
                    return true;
                } else {
                    System.out.println("Username or password is incorrect, try again");
                }

            }
            return false;
        }
        return keepAsking;
        */
    }
}