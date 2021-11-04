public class SeeStatistics {

    public static void start(){

        System.out.println("\n--- Statistics ---");

        System.out.println("\nUsers registered in the app: " + Main.users.size() +
                "\nMovies in the app : " + Main.movies.size() +
                "\nMovies added to favourites list: " + movieFavouriteListCount() +
                "\nMovies added to watched list: " + movieWatchedListCount() +
                "\nNumber of Movies Pre-2000: " + moviesPre2000Count() +
                "\nNumber of Movies Post-2000: " + moviesPost2000Count() +
                "\nNumber of Users that have 'Password' as their password: " + usersPasswordCount());

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