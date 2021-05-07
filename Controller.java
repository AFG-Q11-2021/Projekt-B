
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
    
  //  public static Spieler spieler;
  //  public static Frame fenster;
   // public static KartenDarsteller darsteller;
    public static Game game;
    //karte soll nicht angesteuert WERDEN!
    
    public static Controller controller;
    
    public Controller(){

    }

    public static void main(String[] args){
        running = true;
        //spieler = new Spieler();
        game = new Game();
     
       // fenster = new Frame("Raycaster");
        //Canvas canvas = fenster.getCanvas();
       // darsteller = new KartenDarsteller(canvas);
        
        
        
        long lastupdate = System.nanoTime();
        long currentTime = System.nanoTime();
        while(running){
            currentTime = System.nanoTime();
            if(currentTime - lastupdate > 1000000000/FPS){
                Update();
                game.render();
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
