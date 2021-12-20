
/**
 * Multiplayer Class
 *
 * @author Christopher Scherübl und Julius Rommel(14.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Multiplayer extends JFrame implements ActionListener, KeyListener {
    private Bild build;
    private JLabel label;
    private static JTextField name;
    private JButton starten;
    private Karte kartetest;
    private double spielerspeed, speedr;
    private Controller con;

    public Multiplayer(String title, Karte k, double s, double r, Controller c) {
        super(title);
        setTitle("Multiplayer");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = c;
        kartetest = k;
        spielerspeed = s;
        speedr = r;

        starten = new JButton("Spiel starten");
        starten.setBounds(450, 600, 350, 40);
        name = new JTextField("", 20);
        name.setBounds(400, 530, 450, 40);

        label = new JLabel("Spielername");
        label.setBounds(313, 525, 350, 50);

        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);
        label.setBackground(Color.WHITE);
        starten.addActionListener(this);

        build = new Bild();
        build.setBounds(0, 0, 1290, 1100);

        add(label);
        add(name);
        add(starten);
        add(build);

        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            starten1();
            this.setVisible(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == starten) {
            starten1();
            this.setVisible(false);
        }

    }

    public void starten1() {
        Spieler spieleri = new Spieler(name.getText(), spielerspeed, speedr, kartetest, con);

        String sql = "INSERT INTO multiplayer (name, xposition, yposition, rotation, leben, state) VALUES ('"
                + spieleri.getUsername() + "', " + spieleri.getX() + ", " + spieleri.getY() + ", "
                + spieleri.getRotation() + ", " + spieleri.getLeben() + ", " + 0 + ")";

        datenbankinsert(sql);
        con.setSpieler(spieleri);
        Multiplayergame game = new Multiplayergame(kartetest, con);
        con.setGame(game);
        MulticastMulti cast = new MulticastMulti(con, game);
        Thread t = new Thread(cast);
        cast.updategame();
        t.start();
    }

    private void datenbankinsert(String sql) {
        Connection verbindung = null;
        try {
            verbindung = DriverManager.getConnection("jdbc:mysql://srvxampp/q11wolfenstein", "q11wolfenstein",
                    "abitur");
        } catch (SQLException e) {
            System.err.println("Datenbankfehler(Verbindungsaufbau): " + e);
            System.exit(0);
        }
        try {
            Statement st = verbindung.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen des Datensatzes: " + e);
            System.exit(0);
        }
        try {
            verbindung.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim schließen der Verbindung:" + e);
            System.exit(0);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
