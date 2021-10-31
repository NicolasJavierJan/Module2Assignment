import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Movie implements Serializable {

    // Attributes: Name, Year, Actors (list) and roles, etc.
    private String name;
    private int year;
    private ArrayList<String> actors = new ArrayList<>();
    private ArrayList<String> roles = new ArrayList<>();

    public Movie(String name, int year, ArrayList<String> actors, ArrayList<String> roles){
        this.name = name;
        this.year = year;
        this.actors = actors;
        this.roles = roles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public void printInfo(){
        System.out.println(name);
        System.out.println(year);

        for (int i = 0; i < actors.size(); i++){
            System.out.println(actors.get(i) + " as " + roles.get(i));
        }
    }

    // Added BY ANDREA
    public Collection<Object> getTitle() {
        return getTitle();
    }

    public int getProdYear() {
        return getYear();
    }

    public String getName() {
        return getName();
    }
}