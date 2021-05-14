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
    private static int FPS = 60;
    private static boolean running = false;
    private static Game game;
    private static Spieler spieler;
    public static Framee frame;
    private static Multiplayer multiplayer;
    //karte soll nicht angesteuert WERDEN!
    public static Controller controller;//Wieso das?

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
        spieler = new Spieler("SpielerOne");
    }
    
    public static void Setmultiplayer(Multiplayer multi){
        multiplayer = multi;
    }
    
    public static Spieler Getspieler(){
        return spieler;
    }
    
}
