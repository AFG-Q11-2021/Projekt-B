/**
 * @author Laurens Birkenbach, Christopher Scheruebl, Julius Rommel, Niklas R�sner, Samuel Titt (13.07.2021 n.Chr);
 * @version 0.2
 */

import javax.swing.*;

public class Controller {
<<<<<<< HEAD
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
=======
    private double fps;
    private Game game;
    private Spieler spieler;
    private final Framee frame;
    private TextureManager textureManager;
    private final Caster cast;
    private final int FPS = 60;
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058

<<<<<<< HEAD
    private KartenVerwalter katver;
=======
    public Controller() {
        boolean running = true;
        setTextureManager(new TextureManager());
        KartenVerwalter katver = new KartenVerwalter();
        katver.setActiveMap(0);
        Karte kartetest = katver.getMap();
        cast = new Caster(this);
        // Startmenu oeffnen
        frame = new Framee("Startmen�", kartetest, this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 1100);
        frame.setLayout(null);
        frame.setVisible(true);
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058

<<<<<<< HEAD
    public Controller() {
        running = true;
        setTextureManager(new TextureManager());
        katver = new KartenVerwalter();
        katver.setActiveMap(0);
        kartetest = katver.getMap();
        cast = new Caster(this);
=======
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
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058

<<<<<<< HEAD
        // Startmenu oeffnen
        frame = new Framee("Startmenü", kartetest, this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 1100);
        frame.setLayout(null);
        frame.setVisible(true);
=======
    public static void main(String[] args) {
        new Controller();
    }
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058

<<<<<<< HEAD
        long lastupdate = System.nanoTime();
        long currentTime = System.nanoTime();
        while (running) {
            currentTime = System.nanoTime();
            if (currentTime - lastupdate > 1000000000 / FPS) {
                // Update();
                Render();
                fps = 1000000000.0 / (currentTime - lastupdate);
                lastupdate = currentTime;
            }
        }
        game.getGraphics().dispose();
=======
    public void Update() {
        if (game != null) {
            game.update();
        }
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    public static void main(String[] args) {
        new Controller();
=======
    private void Render() {
        if (game != null) {
            game.render();
        }
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    public void Update() {
        if (game != null) {
            game.update();
        }
=======
    public void setGame(Game tmepi) {
        game = tmepi;
        cast.updategame();
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    private void Render() {
        if (game != null) {
            game.render();
        }
=======
    public Game getGame() {
        return this.game;
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    public void setGame(Game tmepi) {
        game = tmepi;
        cast.updategame();
=======
    public Spieler getSpieler() {
        return this.spieler;
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    public Game getGame() {
        return this.game;
=======
    public void setSpieler(Spieler spiler) {
        spieler = spiler;
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    public Spieler getSpieler() {
        return this.spieler;
=======
    public TextureManager getTextureManager() {
        return this.textureManager;
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    public void setSpieler(Spieler spiler) {
        spieler = spiler;
=======
    public void setTextureManager(TextureManager textureManagr) {
        textureManager = textureManagr;
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    public TextureManager getTextureManager() {
        return this.textureManager;
=======
    public Framee getFramee() {
        return this.frame;
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    public void setTextureManager(TextureManager textureManagr) {
        textureManager = textureManagr;
=======
    public Caster getCast() {
        return this.cast;
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    }

<<<<<<< HEAD
    public Framee getFramee() {
        return this.frame;
    }

    public Caster getCast() {
        return this.cast;
    }

=======
>>>>>>> 2cd59a64c04693dd8468cec26a35b4877a89a058
    public double getFPS() {
        return fps;
    }
}
