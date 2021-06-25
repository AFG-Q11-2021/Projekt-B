/**
 * Multiplayer Class
 *
 * @author Christopher Scherübl(22.06.2021 n.Chr);
 * @version 0.1
 */
import javax.swing.*;
import java.awt.Color;

public class Ladebalken
{
    public static void main(String[] args)
    {
        JFrame laden1 = new JFrame();
        laden1.setSize(1000,1000);
        laden1.setTitle("Laden");
        JProgressBar ladebalken = new JProgressBar(0,100);
        ladebalken.setBounds(10,10,100,50);
        ladebalken.setValue(0);
        ladebalken.setStringPainted(true);
        ladebalken.setBackground(Color.GREEN);
        ladebalken.setForeground(Color.BLACK);
        laden1.add(ladebalken);
        laden1.setVisible(true);
        for(int i=0; i<=ladebalken.getMaximum(); i++)
        {
            ladebalken.setValue(i);
            try
            {
                Thread.sleep(20);
            }
            catch(InterruptedException a)
            {
                a.printStackTrace();
            }
        }
    }
}
