import java.awt.*;
import javax.swing.*;
public class tester
{
    private KartenDarsteller karte;
    
    public tester(){
        JFrame fame = new JFrame("test");
        fame.setSize(600,600);
        Canvas cani = new Canvas();
        karte = new KartenDarsteller(cani);
        
        fame.add(cani);
        fame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fame.setVisible(true);
    }
}
