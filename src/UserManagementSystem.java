import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagementSystem {
    // TODO
    // JASMIN

    public static ArrayList<UserInfo> registerInfo = new ArrayList<UserInfo>();

    public static void start(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
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
                if (userLogin(userList, movieList, movies1)) {
                    keepAsking = false;
                }
            } else if (choice == 2) {
                userRegister();
            } else {
                System.out.println();
                System.out.println("Please choose from a number in the list.");
                System.out.println();
            }
        }
    }

    public static void userRegister(){
        Scanner registerUser = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = registerUser.nextLine();
        System.out.println("Enter password: ");
        String password = registerUser.nextLine();
        System.out.println("Registering");
        UserInfo login = new UserInfo (username, password);
        registerInfo.add(login);
    }

    public static boolean userLogin(File userList, File movieList, ArrayList<Movie> movies1) throws FileNotFoundException {
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
    }
}