/**
 * Framee Class
 * @author Christopher Scherübl, Timon Weiss, Julius Rommel (07.05.2021 n.Chr);
 * @version 0.2
 */
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Framee extends JFrame implements ActionListener, Returner {
    private JButton single, multi, settings, ende;
    private Bild build;
    private static Karte kartetest;
    private double spielerspeed, speedr;
    private Controller con;

    public Framee(String title, Karte k, Controller c) {
        super(title);
        kartetest = k;
        con = c;
        single = new JButton("Single Player");
        single.setBounds(280, 590, 750, 50);
        single.addActionListener(this);
        add(single);

        multi = new JButton("Multiplayer");
        multi.setBounds(280, 650, 750, 50);
        multi.addActionListener(this);
        add(multi);

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

        spielerspeed = 0.1;
        speedr = 4;
    }

    public void actionPerformed(ActionEvent e) {
        {
            if (e.getSource() == single) {
                this.setVisible(false);
                singel();
            } else if (e.getSource() == multi) {
                this.setVisible(false);
                mluti();
            } else if (e.getSource() == ende) {
                System.exit(0);
            } else if (e.getSource() == settings) {
                this.setVisible(false);
                setting();
            }
        }
    }

    private void singel() {
        Spieler sppileri = new Spieler("Spieler", spielerspeed, speedr, kartetest,con);
        con.setStatHandle(new StatHandle(100, con));
        con.setSpieler(sppileri);
        Singleplayergame gamee = new Singleplayergame(kartetest, con);
        gamee.setSpieler(sppileri);
        con.setGame(gamee);
    }

    private void mluti() {
        @SuppressWarnings("unused")
        Multiplayer multiplayer = new Multiplayer("Multiplayer", kartetest, spielerspeed, speedr, con);
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

	public void dealDamage() {		
	}
}
