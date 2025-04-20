import org.code.theater.*;
import org.code.media.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class Methods extends Scene {

public Methods(){
   
}

  
/** 
  * establish the arraylists
  * player sprite, player name, goalie sprite, goalie name
  */
    ArrayList<String> playerSprites = new ArrayList<String>(FileReader.toStringList("playerimages.txt"));
    ArrayList<String> playerNames = new ArrayList<String>(FileReader.toStringList("playernames.txt"));
    ArrayList<String> goalieSprites = new ArrayList<String>(FileReader.toStringList("goalieimages.txt"));
    ArrayList<String> goalieNames = new ArrayList<String>(FileReader.toStringList("goalienames.txt"));

String name = "";

  /**
  * plays all the scenes
  * because i wanted to make it 3 methods
  * for better sorting
  * param s is the scene and is used as an argument only here
  */
public void play(Scene s){
  startingScene();
  midScene(s);
  endScene(s);
}
  /**
  * starts the scene
  * no param
  */
private void startingScene(){
          Scanner input = new Scanner(System.in);
 System.out.println("Choose your character.\nIf you do not input a valid name, please restart the program.\n");
  for (String fish : playerNames){
    System.out.println(fish);
  }
  System.out.println("\n");
    String userInput = input.nextLine(); // user input is whatever name the user decides to type
  System.out.println("\n");
    boolean found = false;

while (found == false){
  
  for (String lobster : playerNames){
  /**
  * find player last name, so if userInput is only the last name it still works
  */
    int space = lobster.indexOf(" "); // find space between first and last name
    String lastName = lobster.substring(space + 1); // get  last name
      
     /*
     * Check to see if the userInput matches the last name or full name, then print if it does
     */
if (userInput.equalsIgnoreCase(lobster) || userInput.equalsIgnoreCase(lastName)){
      System.out.println(lobster + " is a great choice!");
  found = true;
  name = lobster;
      }
    }
  }
}
/**
  * establishes scene
  * shows scoring
  * param s is to signify the scene and is passed down from play() and the TheaterRunner tester class
  */
  private void midScene(Scene s){
    String rink = "rink.jpeg";
    SceneImage background = new SceneImage(rink, -100, 0);
    String p = 	"pngimg.com---hockey_PNG95.png";
    SceneImage puck = new SceneImage(p, 60, 380);
    s.drawImage(background.getFileName(), background.getX(), background.getY(), 700);
    String sprite = "";
    for (int i = 0; i < playerNames.size(); i++){
      if (name.equalsIgnoreCase(playerNames.get(i))){
        sprite = playerSprites.get(i);
      }
    }
    double num = Math.random() * 100;
    String goalieSprite = "";
if (20 >= num){
  goalieSprite = goalieSprites.get(0);
  } else if (40 >= num){
  goalieSprite = goalieSprites.get(1);
  } else if (60 >= num){
  goalieSprite = goalieSprites.get(2);
  } else if (80 >= num){
  goalieSprite = goalieSprites.get(3);
  } else {
  goalieSprite = goalieSprites.get(4);
  }

    /**
    * all of the drawing which was honestly pretty lazily done and could have been made more efficiently
    * but anesthesia makes my brain slow
    */
    s.drawImage(sprite, 0, 260, 250);
    s.drawImage(puck.getFileName(), puck.getX(), puck.getY(), 20);
    s.drawImage(goalieSprite, 200, 270, 175);
    s.pause(1);
    s.clear("black");
    s.drawImage(background.getFileName(), background.getX(), background.getY(), 700);
    s.drawImage(sprite, 0, 260, 250);
    s.drawImage(puck.getFileName(), puck.getX()+50, puck.getY()-50, 20);
    s.drawImage(goalieSprite, 200, 270, 175);
    s.pause(1);
    s.clear("black");
    s.drawImage(background.getFileName(), background.getX(), background.getY(), 700);
    s.drawImage(sprite, 0, 260, 250);
    s.drawImage(puck.getFileName(), puck.getX()+100, puck.getY()-100, 20);
    s.drawImage(goalieSprite, 200, 270, 175);
    s.pause(1);
    s.clear("black");
    s.drawImage(background.getFileName(), background.getX(), background.getY(), 700);
    s.drawImage(sprite, 0, 260, 250);
    s.drawImage(puck.getFileName(), 222, 273, 20);
    s.drawImage(goalieSprite, 200, 270, 175);
    s.pause(.3);
    s.playNote(Instrument.PIANO, 60, 2);
    s.pause(1.3);
  }

  /**
  * gives scene an ending with cartoonish text
  * param s is to represent the scene as used in midScene
  */
  private void endScene(Scene s){
    s.pause(0.3);
    s.clear("white");
    s.drawText("hooray!!", 60, 200);
    Theater.playScenes(s);
  }
}
