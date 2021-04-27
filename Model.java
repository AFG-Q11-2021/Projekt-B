
/**
 * Main Class
 *
 * @author Laurens Birkenbach, Niklas Rösner (27.04.2021 n.Chr);
 * @version 0.1
 */


public class Model
{
    //Spieler Klasse einfuegen:
    //Map Klasse einfuegen:
    //Controller Klasse Referenz:
    //view Klasse Referenz:

    public static int FPS = 60;
    public static boolean running = false;
    
    public static Spieler spieler;
    public static Karte karte;
    public static Controller controller;
    public Model(){

    }

    public static void main(String[] args){
        running = true;
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
    } 

    //runs each Frame
    public static void Update(){

    }
    public static void Render(){
    }
    
}
