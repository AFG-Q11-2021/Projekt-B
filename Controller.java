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
    private CastTest cast;
    private StatHandle stat;
    private KartenVerwalter katver;

    public Controller() {
        running = true;
        setTextureManager(new TextureManager());
        katver = new KartenVerwalter();
        katver.setActiveMap(0);
        kartetest = katver.getMap();
        cast = new CastTest(this);

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
                fps = 1000000000.0/(currentTime - lastupdate);
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
        cast = new CastTest(this);
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

    public CastTest getCast(){
        return this.cast;
    }

    public void setStatHandle(StatHandle stemp){
        stat = stemp;
    }

    public StatHandle getStatHandle(){
        return stat;
    }
    
    public double getFPS(){
        return fps;
    }

}
