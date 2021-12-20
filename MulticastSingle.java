import java.awt.*;
import java.awt.image.*;

public class MulticastSingle implements Runnable {
    private double fps;
    private final Karte karte;
    private final int FPS =60;
    private final Controller con;
    private final Caster cast;
    private boolean run = false;
    private BufferStrategy bs;
    private Graphics g;
    
    public MulticastSingle(Controller c, Singleplayergame s) {
        KartenVerwalter kartver = new KartenVerwalter();
        kartver.setActiveMap(0);
        karte = kartver.getMap();
        con= c;
        cast = c.getCast();
        s.createBufferStrategy(2);
        bs = s.getBufferStrategy();
    }

    @Override
    public void run() {
        long lastupdate = System.nanoTime();
        long currentTime;
        while (run) {
            currentTime = System.nanoTime();
            if (currentTime - lastupdate > 1000000000 / FPS) {
                g = bs.getDrawGraphics();
                cast.paintMap(g, karte, con.getSpieler());
                paintfps(g);
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
    
    public void updategame() {
        run = true;
    }

}
