/**
 * @author Laurens Birkenbach, Christopher Scheruebl, Julius Rommel, Niklas R�sner, Samuel Titt (13.07.2021 n.Chr);
 * @version 0.2
 */

import javax.swing.*;

public class Controller {

    // instance variables - replace the example below with your own
    private static int FPS = 60;
    private static boolean running = false;
    private double fps;
    private Game game;
    private Spieler spieler;
    private Framee frame;
    private Karte kartetest;
    private TextureManager textureManager;
    private Caster cast;
    private KartenVerwalter katver;

    public Controller() {
        running = true;
        setTextureManager(new TextureManager());
        katver = new KartenVerwalter();
        katver.setActiveMap(0);
        kartetest = katver.getMap();
        cast = new Caster(this);

        // Startmenu oeffnen
        frame = new Framee("Startmenü", kartetest, this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 1100);
        frame.setLayout(null);
        frame.setVisible(true);
        
        long lastupdate = System.nanoTime();
        long currentTime;
        while (running) {
            currentTime = System.nanoTime();
            // instance variables - replace the example below with your own
            if (currentTime - lastupdate > 1000000000 / FPS) {
                Update();
                //Render();
                fps = 1000000000.0 / (currentTime - lastupdate);
                lastupdate = currentTime;
            }
        }
        game.getGraphics().dispose();

    }
	public void Update() {
		if (game != null) {
			game.update();
		}
    }
    
    private void Render() {
        if (game != null) {
        	game.render();
        }
    }
    
    public static void main(String[] args) {
        new Controller();
    }

    public void setGame(Game tmepi) {
        game = tmepi;
        cast.updategame();

    }

    public Game getGame() {
        return this.game;
    }

    public Spieler getSpieler() {
        return this.spieler;
    }

    public void setSpieler(Spieler spiler) {
        spieler = spiler;
    }

    public TextureManager getTextureManager() {
        return this.textureManager;
    }

    public void setTextureManager(TextureManager textureManagr) {
        textureManager = textureManagr;

    }

    public Framee getFramee() {
        return this.frame;
    }

    public Caster getCast() {
        return this.cast;
    }

    public double getFPS() {
        return fps;
    }
}
