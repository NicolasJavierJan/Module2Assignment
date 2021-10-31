import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String username;
    private String password;
    private ArrayList<Movie> favouriteList;
    private ArrayList<String> historyList;

    public User(String username, String password, ArrayList<Movie> favouriteList, ArrayList<String> historyList){
        this.username = username;
        this.password = password;
        this.favouriteList = favouriteList;
        this.historyList = historyList;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public ArrayList<Movie> getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(ArrayList<Movie> favouriteList) {
        this.favouriteList = favouriteList;
    }

    public ArrayList<String> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(ArrayList<String> historyList) {
        this.historyList = historyList;
    }

    public void printInfo(){
        System.out.println(username + " " + password);
    }
}