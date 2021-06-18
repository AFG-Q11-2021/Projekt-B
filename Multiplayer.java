
/**
 * Multiplayer Class
 *
 * @author Christopher Scherübl und Julius Rommel(14.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Multiplayer extends JFrame implements ActionListener {
    private Bild build;
    private JLabel label;
    private static JTextField name;
    private JButton starten;
    public Karte kartetest;
    private double spielerspeed;
    private Controller con;

    public Multiplayer(String title, Karte k, double s, Controller c) {
        super(title);
        setTitle("Multiplayer");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Spielername");
        name = new JTextField("", 20);
        starten = new JButton("Spiel starten");
        starten.setBounds(450, 600, 350, 40);

        name = new JTextField("", 20);
        name.setBounds(400, 530, 450, 40);
        add(name);
        label = new JLabel("Spielername:");
        label.setBounds(313, 525, 350, 50);
        add(label);

        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);
        label.setBackground(Color.WHITE);
        starten.addActionListener(this);

        build= new Bild();
        build.setBounds(0, 0, 1290, 1100);

        add(label);
        add(name);
        add(starten);
        add(build);

        setVisible(true);
        kartetest = k;
        spielerspeed = s;
        con = c;

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == starten) {
            starten1();
            this.setVisible(false);
        }
    }

    public void starten1() {
        Multiplayergame gamee = new Multiplayergame(kartetest, con);
        Spieler spieleri = new Spieler(name.getText(), spielerspeed, 2, kartetest);
        datenbankinsert("INSERT INTO multiplayer (name, xposition, yposition, rotation) VALUES (name  = '"
            + spieleri.getUsername() + "', " + spieleri.getX() + ", " + spieleri.getY() + ", "
            + spieleri.getRotation() + ")");
        gamee.setSpieler(spieleri);
        con.setSpieler(spieleri);
        con.setGame(gamee);
    }

    private void datenbankinsert(String sql) {
        Connection verbindung = null;
        try {
            verbindung = DriverManager.getConnection("jdbc:mysql://srvxampp/q11wolfenstein", "q11wolfenstein", "abitur");
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
}
