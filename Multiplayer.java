/**
 * Frame Class
 *
 * @author Christopher Scherübl (14.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Multiplayer extends JFrame implements ActionListener
{
    private JButton starten;

    public Multiplayer(String title)
    {
        super(title);

        JFrame multiplayer1 = new JFrame();
        multiplayer1.setTitle("Multiplayer");
        multiplayer1.setSize(1000,1000);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Spielername");
        panel.add(label);
        JTextField name = new JTextField("", 20);
        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);
        panel.add(name);
        JButton starten = new JButton("Spiel starten");
        panel.add(starten);
        
        multiplayer1.add(panel);
        multiplayer1.setVisible(true);
        multiplayer1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == starten)
        {
            starten1();
            this.setVisible(false);
        }
    }

    public static void starten1()
    {
        Game gamee = new Game();
        Controller.Setgame(gamee);
    }
}
