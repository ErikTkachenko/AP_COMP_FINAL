import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class SenGen {
    private Character subject1;
    private int counter;
    private ArrayList<LocationVerb> locVerbLib;
    private ArrayList<Object> objLib;
    private ArrayList<ObjectVerb> obVerbLib;
    private ArrayList<Person> peopleLib;
    private ArrayList<PersonVerb> perVerbLib;
    private ArrayList<Place> placeLib;
    private ArrayList<Status> statusLib;
    private ArrayList<Trait> traitLib;
    private ArrayList<Verb> genVerbLib;


    public SenGen(Character s1, ArrayList<LocationVerb> lv, ArrayList<Object> obj, ArrayList<ObjectVerb> ov, ArrayList<Person> p, ArrayList<PersonVerb> pv, ArrayList<Place> plv, ArrayList<Status> s, ArrayList<Trait> t, ArrayList<Verb> v){
        subject1 = s1;
        locVerbLib = lv;
        objLib = obj;
        obVerbLib = ov;
        peopleLib = p;
        perVerbLib = pv;
        placeLib = plv;
        statusLib = s;
        traitLib = t;
        genVerbLib = v;
        counter = 0;
    }
    
    
    public void GenerateSentence(){
       
        counter++;

        String peepeepoopoo = "pepepopo";
        if (counter == 5){
            //TODO: GET THIS DUMBASS SCANNER TO WORK
            Scanner scanscan = new Scanner(System.in);
            System.out.println("[Press enter to keep generating]\n");
            peepeepoopoo = scanscan.nextLine();
            scanscan.close();
        }
        

        String sentence = "Error!";

        double seed = Math.random();
        if(seed > 0.25){
            sentence = this.DescribeSomething();
        }else{
            sentence = this.TakeAction();
        }
        Collections.shuffle(perVerbLib);
      Collections.shuffle(statusLib);
      Collections.shuffle(traitLib);
      Collections.shuffle(obVerbLib);
      Collections.shuffle(objLib);
      Collections.shuffle(genVerbLib);
      Collections.shuffle(placeLib);
      Collections.shuffle(peopleLib);
      Collections.shuffle(locVerbLib);
        System.out.println(sentence);
        this.GenerateSentence();

    }
    public String DescribeSomething(){
        double seed = Math.random();
        String sentence = "ERROR!";
        if(seed < 0.25){
            sentence = this.DescribeCharacter();
        }else if(seed < 0.5){
            sentence = this.DescribeObject();
        }else if(seed < 0.75){
            sentence = this.DescribeCharacterLocation();
        }else{
            sentence = this.DescribeCharacterStatus();
        }
        return sentence;
    }
    public String TakeAction(){
        double seed = Math.random();
        String sentence = "ERROR!";
        if(seed < 0.25){
            sentence = this.ChangeLocation();
        }else if(seed < 0.5){
            sentence = this.ActionRegular();
        }else if(seed < 0.75){
            sentence = this.ActionWithObject();
        }else{
            sentence = this.ObtainObject();
        }
        return sentence;
    }
    public String ChangeLocation(){
        return (subject1.getName() + WordChooser.ChooseWord(subject1, locVerbLib).getTerm() + " to the " + );
    }
    public String ActionRegular(){
        return "";
    }
    public String ActionWithObject(){
        return "";
    }
    public String ActionOnObject(){
        return "";
    }
    public String ObtainObject(){
        return "";
    }
    public String NewTrait(){
        return "";
    }

    public String DescribeCharacterLocation(){
        return ("The " + subject1.getLocation().getTerm() + " is " + WordChooser.ChooseWordManualSeed(subject1.getLocation().getSentiment(), traitLib).getTerm());
    }
    public String DescribeCharacter(){
        return (subject1.getName() + " is " + subject1.getTraits().get(0).getTerm());
    }
    public String DescribeObject(){
        return ("The " + subject1.getInventory().get(0).getTerm() + " is " + WordChooser.ChooseWordManualSeed(subject1.getInventory().get(0).getSentiment(), traitLib).getTerm());
    }
    public String DescribeCharacterStatus(){
        return (subject1.getName() + " is " + subject1.getStatus().getTerm());
    }
    public String DescribeCharacterAction(){
        return (subject1.getName() + " is " + subject1.getAction().getCont());
    }

}
