
/**
 * Controller Class
 *
 * @author Christus Scherübl, Laurens Birkenbach, Niklas Rösner (07.05.2021 n. Chr.)
 * @version 0.2
 */

import java.awt.*;
import javax.swing.*;
public class Controller
{
    // instance variables - replace the example below with your own
    public static int FPS = 60;
    public static boolean running = false;
    public static Game game;
    // public static KartenDarsteller darsteller;
    public static Frame frame;
    //karte soll nicht angesteuert WERDEN!

    public static Controller controller;

    public Controller(){

    }

    public static void main(String[] args){
        running = true;
        //Startmenü öffnen
        frame = new Frame("Startmenü");
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
        if(Controller.game != null){
            game.render();
        }
    }
}
