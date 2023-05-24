
import java.util.ArrayList; 
public class Character {
    private double morality;
    private ArrayList<Object> inventory;
    private ArrayList<Trait> traits;
    private Place location;
    private Verb action;
    private String name;
    private Status stat;

    public Character(String n, double m, ArrayList<Object> inv, ArrayList<Trait> t, Place p){
        morality = m;
        traits = t;
        name = n;
        inventory = inv;
        location = p;
        stat = new Status("neutral", 0.5);

    }

    public double getSentiment(){
        return((stat.getSentiment() + morality)/2);
    }

    public ArrayList<Trait> getTraits(){
        return traits;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Object> getInventory(){
        return inventory;
    }

    public Verb getAction(){
        return action;
    }

    public Place getLocation(){
        return location;
    }

    public Status getStatus(){
        return stat;
    }

    

    
    
}
