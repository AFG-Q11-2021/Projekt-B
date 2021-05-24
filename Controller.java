/**
 * Controller Class
 *
 * @author Laurens Birkenbach, Christopher Scherübl, Niklas Rösner, Julius Rommel (07.05.2021 n. Chr.)
 * @version 0.2
 */

import javax.swing.*;

public class Controller {
    // instance variables - replace the example below with your own
    private static int FPS = 60;
    private static boolean running = false;
    private static Game game;
    private static Spieler spieler;
    private static Framee frame;
    private static Karte kartetest;

    public  static TextureManager textureManager;


    public Controller() {

    }



 
    public static void main(String[] args) {
        running = true;
        
        kartetest = new Karte();
        kartetest.setKartenArray(2, 2, 1);
        kartetest.setKartenArray(3, 2, 1);
        kartetest.setKartenArray(4, 2, 1);
        kartetest.setKartenArray(4, 3, 1);
        
        // Startmenü öffnen
        frame = new Framee("Startmenü", kartetest);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 1100);
        frame.setLayout(null);
        frame.setVisible(true);
        
        long lastupdate = System.nanoTime();
        long currentTime = System.nanoTime();
        while (running) {
            currentTime = System.nanoTime();
            if (currentTime - lastupdate > 1000000000 / FPS) {
                Update();
                Render();
                lastupdate = currentTime;
            }
        }
        game.getGraphics().dispose();
    }

    // runs each Frame
    public static void Update() {

        long lastupdate = System.nanoTime();
        long currentTime = System.nanoTime();
        while (running) {
            currentTime = System.nanoTime();
            if (currentTime - lastupdate > 1000000000 / FPS) {
                Update();
                Render();
                lastupdate = currentTime;
            }
        }
        game.getGraphics().dispose();

    }

   
    public static void Render() {
        if (game != null) {
            game.render();
        }
    }
    public static void setGame(Game tmepi) {
        game = tmepi;
    }

    public static Game getGame() {
        return game;

    }



    public static Spieler getSpieler() {
        return spieler;
    }


    

    public static void setSpieler(Spieler spieler){
        spieler = spieler;
    }

}
