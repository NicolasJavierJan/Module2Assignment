import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    // Attributes: Name, Year, Actors (list) and roles, etc.
    private String name;
    private int year;
    private ArrayList<String> actors = new ArrayList<>();
    private ArrayList<String> roles = new ArrayList<>();

    /*
    public Movie(String name, int year){
        this.name = name;
        this.year = year;
    }
     */

    public Movie(String name, int year, ArrayList<String> actors, ArrayList<String> roles){
        this.name = name;
        this.year = year;
        this.actors = actors;
        this.roles = roles;
    }

    public void addActors(String name){
        this.actors.add(name);
    }

    public void addRole(String role){
        this.roles.add(role);
    }

    public String getName(){
        return this.name;
    }

    public void printInfo(){
        System.out.println(name);
        System.out.println(year);

        for (int i = 0; i < actors.size(); i++){
            System.out.println(actors.get(i) + " as " + roles.get(i));
        }
    }



    // ******* Kim used this **********
    // just a movie class

    private String title;
    private int prodYear;

    // Movie constructor
    public Movie (String title, int prodYear) {
        setTitle(title);
        setProdYear(prodYear);
    }

    // To string generator
    public String toString() {
        return "Title: " + getTitle() + " || "+ " Production year: " + getProdYear();
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }
    // Getters
    public String getTitle() {
        return title;
    }
    public int getProdYear() {
        return prodYear;
    }
}