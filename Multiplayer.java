
/**
 * Multiplayer Class
 *
 * @author Christopher Scherübl und Julius Rommel(14.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

@SuppressWarnings("serial")
public class Multiplayer extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label;
    private static JTextField name;
    private JButton starten;
    public static Karte kartetest;

    public Multiplayer(String title, Karte k) {
        super(title);
        setTitle("Multiplayer");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        label = new JLabel("Spielername");
        name = new JTextField("", 20);
        starten = new JButton("Spiel starten");

        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);

        starten.addActionListener(this);

        panel.add(label);
        panel.add(name);
        panel.add(starten);

        add(panel);
        setVisible(true);

        kartetest = k;

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == starten) {
            starten1();
            this.setVisible(false);
        }
    }

    public static void starten1() {
        Multiplayergame gamee = new Multiplayergame(kartetest);
        Spieler spieleri = new Spieler(name.getText());
        //datenbankinsert("INSERT INTO multiplayer (name, xposition, yposition, rotation) VALUES (name  = '"
        //    + spieleri.getUsername() + "', " + spieleri.getX() + ", " + spieleri.getY() + ", "
        //    + spieleri.getRotation() + ")");
        gamee.setSpieler(spieleri);
        Controller.setSpieler(spieleri);
        Controller.setGame(gamee);
    }

    private static void datenbankinsert(String sql) {
        Connection verbindung = null;
        try {
            verbindung = DriverManager.getConnection("jdbc:mysql://srvxampp/q11wolfenstein", "q11", "abitur");
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
        }
        try {
            verbindung.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim schließen der Verbindung:" + e);
        }
    }
}
