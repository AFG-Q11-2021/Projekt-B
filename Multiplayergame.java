import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.sql.*;

//Author: Julius(primar), Laurens
@SuppressWarnings("serial")
public class Multiplayergame extends Canvas implements Game, Returner {

    private JFrame frame1;
    private String title = "Game";
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    private KeyHandler key;
    private Spieler s;
    private Controller con;
    private Karte kartetest;// fuer den Darsteller umschreiben
    private Graphics g;
    private BufferStrategy bs;

    public Multiplayergame(Karte k, Controller c) {
        kartetest = k;
        con = c;
        s = con.getSpieler();
        frame1 = new JFrame();
        Dimension size = new Dimension(WIDTH, HEIGHT);
        key = new KeyHandler(con, this);
        this.setPreferredSize(size);
        this.addKeyListener(key);
        setupframe();

        this.createBufferStrategy(3);
        bs = this.getBufferStrategy();
    }

    public void update() {
    	key.movemPlayer();
    	updatelives();
    }

    public void render() {
        g = bs.getDrawGraphics();
        g.setColor(new Color(37, 150, 190));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        key.movemPlayer();
        updatelives();
        
        // Karte malen
        con.getCast().paintMapMulti(g, kartetest, s);
        paintfps();
        paintlives();
        
        g.dispose();
        bs.show();
    }

	private void updatelives() {
		String sql2 = "SELECT leben FROM multiplayer WHERE name = '" + s.getUsername() + "'";
        Connection verbindung = null;
        verbindung = aufbau(verbindung);
        try {
            Statement st = verbindung.createStatement();
            ResultSet ergebnis = st.executeQuery(sql2);
            while (ergebnis.next()) {
                s.setLeben(ergebnis.getInt(1));
            }
            ergebnis.close();
            st.close();
            abbau(verbindung);
        } catch (SQLException e) {
            System.err.println("Fehler beim Auslesen der Datenbank: " + e);
            System.exit(0);
        }
        if (s.getLeben()<=0) {
            datenbankupdaten("DELETE FROM multiplayer WHERE name = '" + s.getUsername() + "'");
            System.exit(0);
        }
	}

    private void paintlives() {
        String tempi = Integer.toString(s.getLeben());
        char[] tulo = new char[tempi.length()];
        tempi.getChars(0, tempi.length(), tulo, 0);
        g.setColor(Color.GREEN);
        g.drawChars(tulo, 0, tempi.length(), 900, 150);
    }

    private void paintfps() {
        String tempi = Double.toString(Math.floor(con.getFPS()));
        char[] tulo = new char[tempi.length()];
        tempi.getChars(0, tempi.length(), tulo, 0);
        g.setColor(Color.GREEN);
        g.drawChars(tulo, 0, tempi.length(), 900, 100);
    }

    public void dealDamage() {
        Sprite su = con.getCast().getLastsprite();
        if (su != null) {
            if (su.getID() > 0) {
                int damage = (int)(Math.random()*5);
                // int damage = s.getUsedWeapon().getDamagePerBullet();
                String sql = "UPDATE multiplayer SET leben = leben-" + damage + " WHERE name = '" + su.getName() + "'";
                datenbankupdaten(sql);
                System.out.println("Schaden gegeben:" + su.getName());
            }
        }

    }

    private void datenbankupdaten(String sql) {
        Connection verbindung = null;
        verbindung = aufbau(verbindung);
        try {
            Statement st = verbindung.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim Einfuegen des Datensatzes: " + e);
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
            System.err.println("Fehler beim schliesen der Verbindung:" + e);
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

    public JFrame getFrame() {
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