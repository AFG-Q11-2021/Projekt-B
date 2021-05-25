
/**
 * Framee Class
 *
 * @author Christopher Scherübl, Timon Weiss, Julius Rommel (07.05.2021 n.Chr);
 * @version 0.2
 */
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Framee extends JFrame implements ActionListener {
    private JButton schliessen;
    private JButton auswahl;
    private JButton settings;
    private JButton ende;
    private Bild build;
    private static Karte kartetest;
    private double spielers;

    public Framee(String title, Karte k) {
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
        spielers = 0.05;

    }

    public void actionPerformed(ActionEvent e) {
        {
            if (e.getSource() == schliessen) {
                fenster();
                this.setVisible(false);
            } else if (e.getSource() == auswahl) {
                auswahl();
                this.setVisible(false);
            } else if (e.getSource() == ende) {
                System.exit(0);
            } else if (e.getSource() == settings) {
                setting();
                this.setVisible(false);
            }
        }
    }

    private void fenster() {
        Singleplayergame gamee = new Singleplayergame(kartetest);
        Spieler sppileri = new Spieler("Spieler", spielers );
        Controller.setSpieler(sppileri);
        gamee.setSpieler(sppileri);
        Controller.setGame(gamee);
    }

    private void auswahl() {
        @SuppressWarnings("unused")
        Multiplayer multiplayer = new Multiplayer("Multiplayer", kartetest);
    }
    
    private void setting() {
        new Settings(this, spielers);
    }
    
    public void returne() {
        this.setVisible(true);
    }

    public double getSpeed() {
        return spielers;
    }

    public void setSpeed(double spielers) {
        this.spielers = spielers;
    }
}
