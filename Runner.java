import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Runner{

	public static void main(String[] args){



	//INITIALIZE OBJECT LIBRARY
	ArrayList<Object> objLib = new ArrayList<Object>();

	try (Scanner scan = new Scanner(new File("objectlist.txt"))) {
            String data;
            while(scan.hasNextLine() ){
                 data = scan.nextLine();

                 String[] token = data.split(":");
            	   objLib.add(new Object(token[0],Double.parseDouble(token[1])));
            }
            scan.close();
      } catch (NumberFormatException | FileNotFoundException e) {

            e.printStackTrace();
      }

      //TODO UNFINISHED SCAN
      ArrayList<Trait> traitLib = new ArrayList<Trait>();

	try (Scanner scan = new Scanner(new File("traitlist.txt"))) {
            String data;
            while(scan.hasNextLine() ){
                 data = scan.nextLine();

                 String[] token = data.split(":");
                 traitLib.add(new Trait(token[0],0.5));
            }
            scan.close();
      } catch (NumberFormatException | FileNotFoundException e) {

            e.printStackTrace();
      }
	
      /*for(Trait tr: traitLib){
            System.out.println(tr.getTerm());

      }*/

      ArrayList<Status> statusLib = new ArrayList<Status>();

	try (Scanner scan = new Scanner(new File("statuslist.txt"))) {
            String data;
            while(scan.hasNextLine() ){
                 data = scan.nextLine();

                 String[] token = data.split(":");
                 statusLib.add(new Status(token[0],Double.parseDouble(token[1])));
            }
            scan.close();
      } catch (NumberFormatException | FileNotFoundException e) {

            e.printStackTrace();
      }
	


      ArrayList<Person> peopleLib = new ArrayList<Person>();

	try (Scanner scan = new Scanner(new File("personlist.txt"))) {
            String data;
            while(scan.hasNextLine() ){
                 data = scan.nextLine();

                 String[] token = data.split(":");
                 peopleLib.add(new Person(token[0], Double.parseDouble(token[1])));
            }
            scan.close();
      } catch (NumberFormatException | FileNotFoundException e) {

            e.printStackTrace();
      }
	

      //TODO UNFINISHED SCAN
      ArrayList<Place> placeLib = new ArrayList<Place>();

      try (Scanner scan = new Scanner(new File("placelist.txt"))) {
            String data;
            while(scan.hasNextLine() ){
                 data = scan.nextLine();

                 String[] token = data.split(":");
                 placeLib.add(new Place(token[0],0.5));
            }
            scan.close();
      } catch (NumberFormatException | FileNotFoundException e) {

            e.printStackTrace();
      }
	
      /*for(Word tr: placeLib){
            System.out.println(tr.getTerm());

      }*/


      ArrayList<LocationVerb> locVerbLib = new ArrayList<LocationVerb>();

      try (Scanner scan = new Scanner(new File("locationverb.txt"))) {
            String data;
            while(scan.hasNextLine() ){
                 data = scan.nextLine();

                 String[] token = data.split(":");
                 locVerbLib.add(new LocationVerb(token[0], token[1], Double.parseDouble(token[2])));
            }
            scan.close();
      } catch (NumberFormatException | FileNotFoundException e) {

            e.printStackTrace();
      }
	


      ArrayList<ObjectVerb> obVerbLib = new ArrayList<ObjectVerb>();

      try (Scanner scan = new Scanner(new File("objectverb.txt"))) {
            String data;
            while(scan.hasNextLine() ){
                 data = scan.nextLine();

                 String[] token = data.split(":");
                 obVerbLib.add(new ObjectVerb(token[0], token[1], Double.parseDouble(token[2])));
            }
            scan.close();
      } catch (NumberFormatException | FileNotFoundException e) {

            e.printStackTrace();
      }
	


      ArrayList<PersonVerb> perVerbLib = new ArrayList<PersonVerb>();

      try (Scanner scan = new Scanner(new File("personverb.txt"))) {
            String data;
            while(scan.hasNextLine() ){
                 data = scan.nextLine();

                 String[] token = data.split(":");
                 perVerbLib.add(new PersonVerb(token[0], token[1], Double.parseDouble(token[2])));
            }
            scan.close();
      } catch (NumberFormatException | FileNotFoundException e) {

            e.printStackTrace();
      }
	


      ArrayList<Verb> genVerbLib = new ArrayList<Verb>();

      try (Scanner scan = new Scanner(new File("verblist.txt"))) {
            String data;
            while(scan.hasNextLine() ){
                 data = scan.nextLine();

                 String[] token = data.split(":");
                 genVerbLib.add(new Verb(token[0], token[1], Double.parseDouble(token[2])));
            }
            scan.close();
      } catch (NumberFormatException | FileNotFoundException e) {

            e.printStackTrace();
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

      System.out.println("Story Generator! Make bad, illogical, and stupid stories!\n----------------------------------------------\n\n");
      Scanner sc = new Scanner(System.in);
      System.out.println("What is the protagonist's name?");
      String name = sc.nextLine();
      double moral = 99999;
      while(moral < 1 || moral > 100){
            System.out.println("On a scale of 1-99, how good/evil would "+ name + " be? (1 = very evil, 99 = very good)");
            System.out.println("(If you enter anything other than an integer, I will kill you! <3)");
            moral = sc.nextInt();
      }
      moral /= 100;
      ArrayList<Trait> startTrait = new ArrayList<Trait>();
      startTrait.add(traitLib.get(1));
      startTrait.add(traitLib.get(2));
      startTrait.add(traitLib.get(3));
      ArrayList<Object> startInv = new ArrayList<Object>();
      startInv.add(objLib.get(1));
      startInv.add(objLib.get(2));
      startInv.add(objLib.get(3));
      Place startPlace = placeLib.get(1);
      Character character = new Character(name, moral, startInv, startTrait, startPlace);
      System.out.println("\n\n\n\n\nNice! Time to generate a terrible story! Press enter to start!\n---------------------------------------------------------\nFun Fact: Worms taste like bacon!(Source: trust me bro)\n--------------------------------------------------------------\n");
      String pepepopo = sc.nextLine();
      sc.close();


      SenGen generator = new SenGen(character, locVerbLib, objLib, obVerbLib, peopleLib, perVerbLib, placeLib, statusLib, traitLib, genVerbLib);

      generator.GenerateSentence();
      
      

      


	}
}