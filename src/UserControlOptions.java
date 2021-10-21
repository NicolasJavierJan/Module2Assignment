public class UserControlOptions {
    public static void start(){
        boolean keepAsking = true;
        while (keepAsking) {
            System.out.println("Welcome to User Control Options");
            System.out.println("If you want to Add Movies to your Favourite List, press 1");
            System.out.println("If you want to Add Movies to your Watched List, press 2");

            int choice = App.userChoice();

            if (choice == 1){
                // Go to Favourite List movie add
                keepAsking = false;
            } else if (choice == 2){
                // Go to Watched List
                keepAsking = false;
            }
        }
    }

    public static void addFavouriteList(){
        // TODO
    }

    public static void addWatchedList(){
        // TODO
    }
}
