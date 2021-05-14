
/**
 * Controller Class
 *
 * @author Laurens Birkenbach, Christopher Scherübl, Niklas Rösner (07.05.2021 n. Chr.)
 * @version 0.2
 */

//import java.awt.*;
import javax.swing.*;
public class Controller
{
    // instance variables - replace the example below with your own
    public static int FPS = 60;
    public static boolean running = false;
    public static Game game;
    // public static KartenDarsteller darsteller;
    public static Framee frame;
    //public static Kartendarsteller darsteller;
    //karte soll nicht angesteuert WERDEN!

    public static Controller controller;

    public Controller(){

    }

    public static void main(String[] args){
        running = true;
        //Startmenü öffnen
        frame = new Framee("Startmenü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290,1100);

        frame.setLayout(null);
        frame.setVisible(true);
        
        
        
        long lastupdate = System.nanoTime();
        long currentTime = System.nanoTime();
        while(running){
            currentTime = System.nanoTime();
            if(currentTime - lastupdate > 1000000000/FPS){
                Update();
                Render();
                lastupdate = currentTime;
            }

        }
        game.graphics.dispose();
    } 

    //runs each Frame
    public static void Update(){

    }

    public static void Render(){
        if(game != null){
            game.render();
            
        }
    }
    
    public static void Setgame(Game tmepi){
        game=tmepi;
        
    }
    
    
    
}
