/**
 * Frame Class
 *
 * @author Christopher Scherübl, Timon Weiss (07.05.2021 n.Chr);
 * @version 0.2
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener
{
    private JButton schliessen;
    private JButton auswahl;
    private JButton ende;
    
    public Frame(String title)
    {
        super(title);

        schliessen = new JButton("Single Player");
        schliessen.setBounds(550,600,500,50);
        schliessen.addActionListener(this);
        add(schliessen);

        auswahl = new JButton("Multiplayer");
        auswahl.setBounds(550,650,500,50);
        auswahl.addActionListener(this);
        add(auswahl);

        ende = new JButton("Beenden");
        ende.setBounds(550,770,500,50);
        ende.addActionListener(this);
        add(ende);

    }

    public void actionPerformed(ActionEvent e){
        {
            if(e.getSource() == schliessen)
            {
                fenster();
            }
            if(e.getSource() == auswahl)
            {
                auswahl();
            }
            if(e.getSource() == ende)
            {
                System.exit(0);
            }
        }
    } 

    public static void fenster()
    {
        Controller.game = new Game();
    }

    public static void auswahl()
    {
        JFrame auswahl = new JFrame("Multiplayer Menü");
        auswahl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        auswahl.setSize(650,350);
        auswahl.setVisible(true);
    }
}
