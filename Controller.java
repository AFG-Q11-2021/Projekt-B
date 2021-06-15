import javax.swing.*;

public class Controller {
    // instance variables - replace the example below with your own
    private static int FPS = 60;
    private static boolean running = false;
    private Game game;
    private Spieler spieler;
    private Framee frame;
    private Karte kartetest;
    private TextureManager textureManager;
    private CastTest cast;

    public Controller() {
        running = true;

        kartetest = KartenVerwalter.getMapFromStorage(0);
        cast = new CastTest(this);
        setTextureManager(new TextureManager());
        // Startmenü öffnen
        frame = new Framee("Startmenü", kartetest, this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1290, 1100);
        frame.setLayout(null);
        frame.setVisible(true);

        long lastupdate = System.nanoTime();
        long currentTime = System.nanoTime();
        while (running) {
            currentTime = System.nanoTime();
            if (currentTime - lastupdate > 1000000000 / FPS) {
                // Update();
                Render();
                lastupdate = currentTime;
            }
        }
        game.getGraphics().dispose();
    }

    public static void main(String[] args) {
        new Controller();
    }

    public  void Update() {
        if (game != null) {
            game.update();
        }
    }

    private void Render() {
        if (game != null) {
            game.render();
        }
    }

    public void setGame(Game tmepi) {
        game = tmepi;
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
    
    public CastTest getCast(){
        return this.cast;
    }

}
