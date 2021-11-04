public class SeeStatistics {

    private static int movieInTheSystem = Main.movies.size();
    private static int userInTheSystem = Main.users.size();
    private static int movieFavouriteList = movieFavouriteListCount();
    private static int movieWatchedList = movieWatchedListCount();
    private static int moviesPre2000 = moviesPre2000Count();
    private static int moviesPost2000 = moviesPost2000Count();
    private static int usersPassword = usersPasswordCount();

    public static void start(){

        System.out.println("\n--- Statistics ---");

        System.out.println("\nUsers registered in the app: " + userInTheSystem +
                "\nMovies in the app : " + movieInTheSystem +
                "\nMovies added to favourites list: " + movieFavouriteList +
                "\nMovies added to watched list: " + movieWatchedList +
                "\nNumber of Movies Pre-2000: " + moviesPre2000 +
                "\nNumber of Movies Post-2000: " + moviesPost2000 +
                "\nNumber of Users that have 'Password' as their password: " + usersPassword);

        App.appMainChoices();

    }

    public static int movieFavouriteListCount(){
        int count = 0;
        for (User user : Main.users){
            count = count + user.getFavouriteList().size();
        }

        return count;
    }

    public static int movieWatchedListCount(){
        int count = 0;
        for (User user : Main.users){
            count = count + user.getHistoryList().size();
        }

        return count;
    }

    public static int moviesPre2000Count(){
        int count = 0;
        for (Movie movie : Main.movies){
            if (movie.getYear() < 2000){
                count++;
            }
        }

        return count;
    }

    public static int moviesPost2000Count(){
        int count = 0;
        for (Movie movie : Main.movies){
            if (movie.getYear() >= 2000){
                count++;
            }
        }

        return count;
    }

    public static int usersPasswordCount(){
        int count = 0;
        for (User user : Main.users){
            if (user.getPassword().equalsIgnoreCase("password")){
                count++;
            }
        }

        return count;
    }
}