public class SystemControlOptions {
    public static void start() {

        // TODO
        // KASPER
        boolean keepAsking = true;

        while (keepAsking) {
            System.out.println("Welcome to System Control Options");
            System.out.println("If you want to CREATE a Movie, press 1");
            System.out.println("If you want to UPDATE a Movie, press 2");
            System.out.println("If you want to DISPLAY a Movie, press 3");
            System.out.println("If you want to DISPLAY Actors, press 4");

            int choice = App.userChoice();

            if (choice == 1) {
                // Go to CREATE MOVIE
                keepAsking = false;
            } else if (choice == 2) {
                // Go to UPDATE MOVIE
                keepAsking = false;
            } else if (choice == 3) {
                // Go to DISPLAY MOVIE
                keepAsking = false;
            } else if (choice == 4) {
                // Go to DISPLAY Actors
                keepAsking = false;
            } else {
                System.out.println("Pick one of the choices, c'mon");
            }
        }
    }

    public static void createMovie(){
       // TODO
    }

    public static void updateMovie(){
        // TODO
    }

    public static void displayMovie(){
        // TODO
    }

    public static void displayActors(){
        // TODO
    }
}
