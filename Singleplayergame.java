
/**
 * @author Christopher Scherübl, Laurens Birkenbach, Julius Rommel (07.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Singleplayergame extends Canvas implements KeyListener, Game, Returner {
    private JFrame frame1;

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
    private boolean shoot = false;
    private boolean rotRight = false;
    private boolean rotLeft = false;

    public Singleplayergame(Karte k) {
        frame1 = new JFrame();
        frame1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame1.setTitle(title);
        frame1.add(this);
        frame1.pack();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        this.setPreferredSize(frame1.getPreferredSize());

        kartetest = k;
        csizeX = (int) WIDTH / kartetest.getSizeX() / 2;
        csizeY = (int) HEIGHT / kartetest.getSizeY() / 2;

        this.createBufferStrategy(3);
        bs = this.getBufferStrategy();

        this.addKeyListener(this);
    }

    public void update() {
        movePlayer();
    }

    private void movePlayer() {
        if (fwd == true) {
            s.geradeGehen();
        }
        if (back == true) {
            s.rueckwaertsGehen();
        }
        if (left == true) {
            s.linksGehen();
        }
        if (right == true) {
            s.rechtsGehen();
        }
        if (rotRight == true) {
            s.rechtsdrehen();
        }
        if (rotLeft == true) {
            s.linksdrehen();
        }
    }

    public void render() {
        g = bs.getDrawGraphics();
        g.setColor(new Color(37, 150, 190));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        movePlayer();
        // 3D Bild
        //CastTest.paintMap(g, kartetest, s);

        // 2D Bild
        paintMap();
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
            fwd = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            back = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
            settings();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rotRight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rotLeft = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            fwd = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            back = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rotRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rotLeft = false;
        }
    }

    private void settings() {
        frame1.setVisible(false);
        new Settings(this, s.getSpeed(), s.getSpeedr());
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

    public void setSpeed(double spielers) {
        s.setSpeed(spielers);
    }

    public void setSpeedr(double speedr) {
        s.setSpeedr(speedr);
    }

    public void returne() {
        frame1.setVisible(true);
    }
}
