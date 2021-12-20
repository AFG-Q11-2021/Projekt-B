import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class MulticastMulti implements Runnable{
    private final Karte karte;
    private final Controller con;
    private final int FPS = 60;
    private final Caster cast;
    private double fps;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    
    public MulticastMulti(Controller c, Multiplayergame m) {
        KartenVerwalter kartver = new KartenVerwalter();
        kartver.setActiveMap(0);
        karte = kartver.getMap();
        con = c;
        cast = con.getCast();
        m.createBufferStrategy(2);
        bs = m.getBufferStrategy();
    }

    @Override
    public void run() {
        long lastupdate = System.nanoTime();
        long currentTime;
        while (running) {
            currentTime = System.nanoTime();
            // instance variables - replace the example below with your own
            if (currentTime - lastupdate > 1000000000 / FPS) {
                g = bs.getDrawGraphics();
                cast.paintMapMulti(g, karte, con.getSpieler());
                paintfps(g);
                paintlives(con.getSpieler());
                fps = 1000000000.0 / (currentTime - lastupdate);
                lastupdate = currentTime;
                g.dispose();
                bs.show();
            }
        }
        
    }
    
    private void paintfps(Graphics graph) {
        String tempi = Double.toString(Math.floor(fps*10)/10);
        graph.setColor(Color.GREEN);
        graph.drawString(tempi, 900, 100);
    }
    
    private void paintlives(Spieler s) {
        String tempi = Integer.toString(s.getLeben());
        char[] tulo = new char[tempi.length()];
        tempi.getChars(0, tempi.length(), tulo, 0);
        g.setColor(Color.GREEN);
        g.drawChars(tulo, 0, tempi.length(), 900, 150);
    }
    
    public void updategame() {
        running = true;
    }

}
