
/**
 * Framee Class
 *
 * @author Christopher Scherübl, Timon Weiss, Julius Rommel (07.05.2021 n.Chr);
 * @version 0.2
 */
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Framee extends JFrame implements ActionListener, Returner {
    private JButton schliessen, auswahl, settings, ende;
    private Bild build;
    private static Karte kartetest;
    private double spielerspeed, speedr;
    private Controller con;
    
    public Framee(String title, Karte k, Controller c) {
        super(title);

        schliessen = new JButton("Single Player");
        schliessen.setBounds(280, 590, 750, 50);
        schliessen.addActionListener(this);
        add(schliessen);

        auswahl = new JButton("Multiplayer");
        auswahl.setBounds(280, 650, 750, 50);
        auswahl.addActionListener(this);
        add(auswahl);

        settings = new JButton("Settings");
        settings.setBounds(280, 710, 750, 50);
        settings.addActionListener(this);
        add(settings);

        ende = new JButton("Beenden");
        ende.setBounds(280, 770, 750, 50);
        ende.addActionListener(this);
        add(ende);

        build = new Bild();
        build.setBounds(0, 0, 1290, 1100);
        add(build);

        kartetest = k;
        spielerspeed = 0.1;
        speedr = 4;
        con = c;

    }

    public void actionPerformed(ActionEvent e) {
        {
            if (e.getSource() == schliessen) {
                this.setVisible(false);
                fenster();
            } else if (e.getSource() == auswahl) {
                this.setVisible(false);
                auswahl();
            } else if (e.getSource() == ende) {
                System.exit(0);
            } else if (e.getSource() == settings) {
                this.setVisible(false);
                setting();
            }
        }
    }

    private void fenster() {
        Spieler sppileri = new Spieler("Spieler", spielerspeed, speedr, kartetest);
        con.setStatHandle(new StatHandle(sppileri, 100));
        con.setSpieler(sppileri);
        Singleplayergame gamee = new Singleplayergame(kartetest, con);
        gamee.setSpieler(sppileri);
        con.setGame(gamee);
    }

    private void auswahl() {
        @SuppressWarnings("unused")
        Multiplayer multiplayer = new Multiplayer("Multiplayer", kartetest, spielerspeed, con);
    }

    private void setting() {
        new Settings(this, spielerspeed, speedr, con);
    }

    public void returne() {
        this.setVisible(true);
    }

    public double getSpeed() {
        return spielerspeed;
    }

    public void setSpeed(double spielers) {
        this.spielerspeed = spielers;
    }
    
    public JFrame getFrame(){
        return this;
    }
    
    public void setSpeedr(double speedrr) {
        this.speedr = speedrr;
    }
}
