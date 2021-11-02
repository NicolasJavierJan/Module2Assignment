public class SeeStatistics {


    public static void start(){

        System.out.println("\n--- Statistics ---");

        System.out.println("\nUser registered in the app: " + userInTheSystem +
                "\nMovie in the app : " + movieInTheSystem +
                "\nMovie Created: " + movieCreated +
                "\nMovie Updated: " + movieUpdated +
                "\nMovie added to favourites list: " + movieFavouriteList +
                "\nMovie added to watched list: " + movieWatchedList +
                "\nNumber of time in System Control Options: " + enteredSystemControlOptions +
                "\nNumber of time in User Control Options: " + enteredUserControlOptions +
                "\nNumber of time in Search Movie: " + enteredMovieSearch +
                "\nNumber of time in See Statistics: " + enteredStatistics +
                "\nNumber of time in Play Movie: " + enteredPlayMovie +
                "\nNumber of time in Main Menu: " + enteredMainMenu);

        App.appMainChoices();

    }

    // NUMBER OF USERS

    private static  int userInTheSystem = Main.users.size();


    // HOW MANY MOVIES ARE IN THE SYSTEM
    private static int movieInTheSystem = Main.movies.size();

    // HOW MANY TIMES THE USER CREATED A MOVIE - System Control Options line

    private static int movieCreated = 0;
    public static void movieCreatedCount(){
        movieCreated ++;
    }

    // HOW MANY TIMES THE USER UPDATED A MOVIE

    private static int movieUpdated = 0;
    public static void movieUpdatedCount(){
        movieUpdated++;
    }


    // HOW MANY TIMES THE USER ADDED A MOVIE TO FAVOURITE LIST

    private static  int movieFavouriteList = 0;
    public static void movieFavouriteListCount(){
        movieFavouriteList++;
    }

    // HOW MANY TIMES THE USER ADDED A MOVIE TO THE WATCHED LIST

    private static int movieWatchedList = 0;
    public static void movieWatchedListCount(){
        movieWatchedList++;
    }

    // HOW MANY TIMES THE USER ENTERED IN 1. SYSTEM CONTROL OPTION

    private static int enteredSystemControlOptions = 0;
    public static void enteredSystemControlOptionsCount (){
        enteredSystemControlOptions ++;
    }

    // HOW MANY TIMES THE USER ENTERED 2. USER CONTROL OPTIONS

    private static int enteredUserControlOptions = 0;
    public static void enteredUserControlOptionsCount(){
        enteredUserControlOptions ++;
    }

    // HOW MANY TIMES THE USER ENTERED 3. SEARCH MOVIE

    private static int enteredMovieSearch = 0;
    public static void enteredMovieSearchCount(){
        enteredMovieSearch++;
    }

    // HOW MANY TIMES THE USER ENTERED 4. STATISTICS

    private static int enteredStatistics = 0;
    public static void enteredStatisticsCount(){
        enteredStatistics++;
    }

    // HOW MANY TIMES THE USER ENTERED 5. PLAY MOVIE

    private static int enteredPlayMovie = 0;
    public static void enteredPlayMovieCount(){
        enteredPlayMovie++;
    }

    // HOW MANY TIMES THE USER PRESSED 9 TO GO BACK TO MAIN MENU

    private static int enteredMainMenu = 0;
    public static void enteredMainMenuCount(){
        enteredMainMenu ++;
    }

}