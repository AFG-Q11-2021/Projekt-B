
/**
 * @author Christopher Scherübl, Laurens Birkenbach, Julius Rommel (07.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Singleplayergame extends Canvas implements Game, Returner {
    private JFrame frame1;
    private KeyHandler key;
    private Spieler s;
    private Karte kartetest;// für den Darsteller umschreiben
    private Graphics g;
    private BufferStrategy bs;
    private int csizeX, csizeY;
    private Controller con;
    private double speedm;
    private boolean shoot = false;

    public Singleplayergame(Karte k, Controller c) {
        kartetest = k;
        con = c;
        key = new KeyHandler(con, this);
        frame1 = new JFrame();
        frame1.setPreferredSize(new Dimension(1000,1000));
        frame1.setTitle("Game");
        frame1.add(this);
        frame1.pack();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        this.setPreferredSize(frame1.getPreferredSize());
        csizeX = (int) gibWidth() / kartetest.getSizeX() / 2;
        csizeY = (int) gibHeight() / kartetest.getSizeY() / 2;
        speedm = con.getSpieler().getSpeed();
        this.createBufferStrategy(3);
        bs = this.getBufferStrategy();
        this.addKeyListener(key);
    }

    public void update() {
        key.movesPlayer();
    }

    public void render() {
        g = bs.getDrawGraphics();
        g.setColor(new Color(37, 150, 190));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        key.movesPlayer();
        // 3D Bild

        con.getCast().paintMap(g, kartetest, s);

        // 2D Bild
        // paintMap();
        // paintPlayer();

        g.dispose();
        bs.show();

    }

    public void paintMap() {
        g.setColor(Color.BLACK);
        for (int x = 0; x < kartetest.getSizeX(); x++) {
            for (int y = 0; y < kartetest.getSizeY(); y++) {
                if (kartetest.getCoordinate(x, y) != 0) {
                    g.fillRect(x * csizeX, y * csizeY, csizeX, csizeY);
                } else {
                    g.drawRect(x * csizeX, y * csizeY, csizeX, csizeY);
                }
            }
        }
    }

    public void paintPlayer() {
        double rotRad = Math.toRadians(s.getRotation());
        int xc = (int) (s.getX() * csizeX);
        int xl = (int) (Math.sin(rotRad) * 20);
        int yc = (int) (s.getY() * csizeY);
        int yl = (int) (Math.cos(rotRad) * 20);
        g.setColor(Color.RED);
        g.fillOval(xc - 5, yc - 5, 10, 10);
        g.drawLine(xc, yc, xc + xl, yc + yl);
    }

    public double gibWidth() {
        return frame1.getPreferredSize().getWidth();
    }

    public double gibHeight() {
        return frame1.getPreferredSize().getHeight();
    }

    public Graphics getGraphics() {
        return this.g;
    }

    public void setSpieler(Spieler spieler) {
        s = spieler;
    }

    public void setSpeed(double spielers) {
        s.setSpeed(spielers);
    }

    public void setSpeedr(double speedr) {
        s.setSpeedr(speedr);
    }
    
    public JFrame getFrame(){
        return frame1;
    }

    public void returne() {
        frame1.setVisible(true);
    }
}
