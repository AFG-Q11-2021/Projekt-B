/**
 * Frame Class
 *
 * @author Christopher Scherübl, Timon Weiss (30.04.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener

{

    private JButton schliessen;
    private JButton auswahl;
    private JButton ende;

    public static void main(String[] args)
    {
        Frame frame = new Frame("Menü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    public Frame(String title)
    {
        super(title);

        schliessen = new JButton("Single Player");
        schliessen.setBounds(120,40,160,40);
        schliessen.addActionListener(this);
        add(schliessen);

        auswahl = new JButton("Multiplayer");
        auswahl.setBounds(120,200,160,40);
        auswahl.addActionListener(this);
        add(auswahl);

        ende = new JButton("Beenden");
        ende.setBounds(120,280,160,40);
        ende.addActionListener(this);
        add (ende);

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
        JFrame fenster = new JFrame();
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setSize(650,350);
        fenster.setVisible(true);

    }

    public static void auswahl()
    {
        JFrame auswahl = new JFrame();
        auswahl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        auswahl.setSize(650,350);
        auswahl.setVisible(true);

    }
}
