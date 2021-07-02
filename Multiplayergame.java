import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.sql.*;

//Author: Julius(primär), Laurens
@SuppressWarnings("serial")
public class Multiplayergame extends Canvas implements Game, Returner {
   
    private JFrame frame1;
    private String title = "Game";
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    private KeyHandler key;
    private Spieler s;
    private Controller con;
    private Karte kartetest;// für den Darsteller umschreiben
    private Graphics g;
    private BufferStrategy bs;
    private int csizeX, csizeY;

    public Multiplayergame(Karte k, Controller c) {
        kartetest = k;
        con = c;
        frame1 = new JFrame();
        Dimension size = new Dimension(WIDTH, HEIGHT);
        key = new KeyHandler(con, this);
        this.setPreferredSize(size);
        this.addKeyListener(key);
        setupframe();
        csizeX = (int) gibWidth() / kartetest.getSizeX() / 2;
        csizeY = (int) gibHeight() / kartetest.getSizeY() / 2;

        this.createBufferStrategy(3);
        bs = this.getBufferStrategy();
    }

    public void update() {

    }

    public void render() {
        g = bs.getDrawGraphics();
        g.setColor(new Color(37, 150, 190));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        key.movemPlayer(this);

        // Karte malen
        //CastTest.paintMap(g, kartetest, s);
        paintMap();

        // Spieler malen
        paintPlayers(s);
        paintfps();
        g.dispose();
        bs.show();
    }

    private void paintPlayers(Spieler sp) {
        Spieler h;
        Connection verbindung = null;
        String sql2 = "SELECT name, xposition, yposition, rotation FROM multiplayer";
        verbindung = aufbau(verbindung);
        try {
            Statement st = verbindung.createStatement();
            ResultSet ergebnis = st.executeQuery(sql2);
            while (ergebnis.next()) {
                h = new Spieler(ergebnis.getString(1));
                h.setX(ergebnis.getDouble(2));
                h.setY(ergebnis.getDouble(3));
                h.setRotation(ergebnis.getDouble(4));
                paintPlayer(h);
            }
            ergebnis.close();
            st.close();
            abbau(verbindung);
        } catch (SQLException e) {
            System.err.println("Fehler beim Auslesen der Datenbank: " + e);
            System.exit(0);
        }
    }

    private void paintMap() {
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
    
    private void paintfps(){
        String tempi = Double.toString(Math.floor(con.getFPS()));
        char[] tulo = new char[tempi.length()];
        tempi.getChars(0, tempi.length(), tulo, 0);
        g.setColor(Color.GREEN);
        g.drawChars(tulo, 0, tempi.length(), 900, 100);
    }

    private void paintPlayer(Spieler s) {
        double rotRad = Math.toRadians(s.getRotation());
        int xc = (int) (s.getX() * csizeX);
        int xl = (int) (Math.sin(rotRad) * 20);
        int yc = (int) (s.getY() * csizeY);
        int yl = (int) (Math.cos(rotRad) * 20);
        g.setColor(Color.RED);
        g.fillOval(xc - 5, yc - 5, 10, 10);
        g.drawLine(xc, yc, xc + xl, yc + yl);
        String tempi = s.getUsername();
        char[] tulo = new char[tempi.length()];
        tempi.getChars(0, tempi.length(), tulo, 0);
        g.setColor(Color.GREEN);
        g.drawChars(tulo, 0, tempi.length(), xc - 10, yc - 6);
    }

    public void datenbankupdaten(String sql) {
        Connection verbindung = null;
        verbindung = aufbau(verbindung);
        try {
            Statement st = verbindung.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim Einfügen des Datensatzes: " + e);
            System.exit(0);
        }
        abbau(verbindung);
    }

    private Connection aufbau(Connection ver) {
        try {
            ver = DriverManager.getConnection("jdbc:mysql://srvxampp/q11wolfenstein", "q11wolfenstein", "abitur");
            return ver;
        } catch (Exception e) {
            System.err.println("Datenbankfehler(Verbindungsaufbau): " + e);
            System.exit(0);
            return null;
        }
    }

    private void abbau(Connection ver) {
        try {
            ver.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim schließen der Verbindung:" + e);
            System.exit(0);
        }
    }

    public int gibWidth() {
        return WIDTH;
    }

    public int gibHeight() {
        return HEIGHT;
    }

    public Graphics getGraphics() {
        return this.g;
    }

    public void setSpieler(Spieler spiler) {
        s = spiler;
    }

    public void returne() {
        frame1.setVisible(true);
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

    private void setupframe() {
        frame1.setTitle(title);
        frame1.add(this);
        frame1.pack();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}