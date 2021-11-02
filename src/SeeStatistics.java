public class SeeStatistics {

    private static int movieInTheSystem = Main.movies.size();
    private static int userInTheSystem = Main.users.size();
    private static int movieCreated = 0;
    private static int movieUpdated = 0;
    private static int movieFavouriteList = 0;
    private static int movieWatchedList = 0;
    private static int enteredSystemControlOptions = 0;
    private static int enteredUserControlOptions = 0;
    private static int enteredMovieSearch = 0;
    private static int enteredStatistics = 0;
    private static int enteredPlayMovie = 0;
    private static int enteredMainMenu = 0;

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

    public static void movieCreatedCount(){
        movieCreated ++;
    }

    public static void movieUpdatedCount(){
        movieUpdated++;
    }

    public static void movieFavouriteListCount(){
        movieFavouriteList++;
    }

    public static void movieWatchedListCount(){
        movieWatchedList++;
    }

    public static void enteredSystemControlOptionsCount (){
        enteredSystemControlOptions ++;
    }

    public static void enteredUserControlOptionsCount(){
        enteredUserControlOptions ++;
    }

    public static void enteredMovieSearchCount(){
        enteredMovieSearch++;
    }

    public static void enteredStatisticsCount(){
        enteredStatistics++;
    }

    public static void enteredPlayMovieCount(){
        enteredPlayMovie++;
    }

    public static void enteredMainMenuCount(){
        enteredMainMenu ++;
    }
}