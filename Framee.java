/**
 * Frame Class
 *
 * @author Christopher Scherübl, Timon Weiss (07.05.2021 n.Chr);
 * @version 0.2
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Framee extends JFrame implements ActionListener
{
    private JButton schliessen;
    private JButton auswahl;
    private JButton ende;
    
    public Framee(String title)
    {
        super(title);

        schliessen = new JButton("Single Player");
        schliessen.setBounds(280,590,750,50);
        schliessen.addActionListener(this);
        add(schliessen);

        auswahl = new JButton("Multiplayer");
        auswahl.setBounds(280,650,750,50);
        auswahl.addActionListener(this);
        add(auswahl);

        ende = new JButton("Beenden");
        ende.setBounds(280,770,750,50);
        ende.addActionListener(this);
        add(ende);

    }

    public void actionPerformed(ActionEvent e){
        {
            if(e.getSource() == schliessen)
            {
                fenster();
                this.setVisible(false);
            }
            if(e.getSource() == auswahl)
            {
                auswahl();
                this.setVisible(false);
            }
            if(e.getSource() == ende)
            {
                System.exit(0);
            }
        }
    } 

    public static void fenster()
    {
        Game gamee = new Game();

        Controller.Setgame(gamee);

    }

    public static void auswahl()
    {
        Multiplayer multiplayer = new Multiplayer("Multiplayer");
    }
}
