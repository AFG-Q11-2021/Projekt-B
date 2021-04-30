
/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controller
{
    // instance variables - replace the example below with your own
   public static int FPS = 60;
    public static boolean running = false;
    
    public static Spieler spieler;
    public static Karte karte;
    public static Controller controller;
    
    public Controller(){

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
