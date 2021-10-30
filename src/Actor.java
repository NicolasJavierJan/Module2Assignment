import java.util.ArrayList;
import java.util.Date;

public class Actor {
    // Name, year of birth, whatever. Maybe a list of movies where they act?
    /*
    private String name;
    private Date DOB;
    private ArrayList<Movie> actedIn;
    */

    // ******* Kim used this part *******
    private String name;
    private String role;

    public Actor(String name, String role) {
        setName(name);
        setRole(role);
    }

    public String toString() {
        return "Name: " + getName() + " || " + " Role: " + getRole();
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setRole(String role) {
        this.role = role;
    }
    //Getters
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
}
