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
public class Multiplayer extends JFrame implements ActionListener {
    private Bild build;
    private JLabel label;
    private static JTextField name;
    private JButton starten, test, test1;
    private Karte kartetest;
    private double spielerspeed;
    private Controller con;
    private Spieler spieleri;

    public Multiplayer(String title, Karte k, double s, Controller c) {
        super(title);
        setTitle("Multiplayer");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        starten = new JButton("Spiel starten");
        starten.setBounds(450, 600, 350, 40);
        test = new JButton("test");
        test.setBounds(200, 300, 100, 50);
        test1 = new JButton("delete");
        test1.setBounds(400, 300, 300, 50);
        name = new JTextField("", 20);
        name.setBounds(400, 530, 450, 40);

        label = new JLabel("Spielername");
        label.setBounds(313, 525, 350, 50);

        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);
        label.setBackground(Color.WHITE);
        starten.addActionListener(this);

        build= new Bild();
        build.setBounds(0, 0, 1290, 1100);

        add(test);
        add(test1);
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
        if ( e.getSource() == test){
            testen();
        }
        if (e.getSource() == test1){
            dele();
        }
    }

    private void dele(){
        datenbankinsert("DELETE FROM multiplayer");
    }

    private void testen(){
        spieleri = new Spieler(name.getText(), spielerspeed, 2, kartetest);
        datenbankinsert("DELETE FROM multiplayer");
    }

    public void starten1() {
        Spieler spieleri = new Spieler(name.getText(), spielerspeed, 2, kartetest);
        String sql = "INSERT INTO multiplayer (name, xposition, yposition, rotation) VALUES ('"
            + spieleri.getUsername() + "', " + spieleri.getX() + ", " + spieleri.getY() + ", "
            + spieleri.getRotation() + ")";
        datenbankinsert(sql);
        con.setSpieler(spieleri);
        Multiplayergame game = new Multiplayergame(kartetest, con);
        con.setGame(game);
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
