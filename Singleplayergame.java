
/**
 * @author Christopher Scherübl, Laurens Birkenbach, Julius Rommel (07.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Singleplayergame extends Canvas implements KeyListener, Game {
    public JFrame frame1;

    private String title = "Game";
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;

    private Spieler s;

    private Karte kartetest;// für den Darsteller umschreiben
    private Graphics g;
    private BufferStrategy bs;
    private int csizeX;
    private int csizeY;

    private boolean fwd = false;
    private boolean back = false;
    private boolean left = false;
    private boolean right = false;

    public Singleplayergame(Karte k) {
        JFrame frame1 = new JFrame();
        Dimension size = new Dimension(WIDTH, HEIGHT);

        this.setPreferredSize(size);
        frame1.setTitle(title);
        frame1.add(this);
        frame1.pack();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);

        kartetest = k;
        csizeX = (int) WIDTH / kartetest.getSizeX();
        csizeY = (int) HEIGHT / kartetest.getSizeY();

        this.createBufferStrategy(3);
        bs = this.getBufferStrategy();

        this.addKeyListener(this);
    }

    public void render() {

        g = bs.getDrawGraphics();
        g.setColor(new Color(37, 150, 190));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if (fwd == true)
            s.geradeGehen();
        if (back == true)
            s.rueckwaertsGehen();
        if (left == true)
            s.linksdrehen();
        if (right == true)
            s.rechtsdrehen();
        // Karte malen
        CastTest.paintMap(g, kartetest, s);
        paintMap();

        // Spieler malen
        paintPlayer();

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

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            // vorwärts
            fwd = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            // rückwärts
            back = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            // links
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            // rechts
            right = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        // vorwärts
        if (e.getKeyCode() == KeyEvent.VK_W) {
            fwd = false;
        }
        // rückwärts
        if (e.getKeyCode() == KeyEvent.VK_S) {
            back = false;
        }
        // links
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
        }
        // rechts
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
        }
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public Graphics getGraphics() {
        return this.g;
    }

    public void setSpieler(Spieler spieler) {
        s = spieler;
    }

}