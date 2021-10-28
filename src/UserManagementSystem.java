import java.io.File;
import java.io.FileNotFoundException;

public class UserManagementSystem {
    // TODO
    // JASMIN
    public static void start(File userList, File movieList) throws FileNotFoundException {

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
                keepAsking = false;
                userLogin(userList, movieList);
            } else if (choice == 2) {
                keepAsking = false;
                userRegister();
            } else {
                System.out.println();
                System.out.println("Please choose from a number in the list.");
                System.out.println();
            }
        }
    }

    public static void userRegister(){
        // Placeholder.
        System.out.println("Registeringgggg");
        // Maybe call userLogin after the registering was succesfull?
        // Or maybe just jump to the next part.
    }

    public static void userLogin(File userList, File movieList) throws FileNotFoundException {
        // Placeholder.
        System.out.println("Logging innnn");
        App.appMainChoices(userList, movieList);
    }

}
