import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    // Attributes: Name, Year, Actors (list) and roles, etc.
    private String name;
    private int year;
    private ArrayList<String> actors = new ArrayList<>();
    private ArrayList<String> roles = new ArrayList<>();

    public Movie(String name, int year){
        this.name = name;
        this.year = year;
    }

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
}
