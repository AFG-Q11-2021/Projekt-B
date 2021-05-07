import java.awt.*;
import javax.swing.*;
public class tester
{
    private KartenDarsteller karte;
    
    public tester(){
        JFrame fame = new JFrame("test");
        Canvas cani = new Canvas();
        Graphics graphics = cani.getGraphics();
        fame.setSize(600,600);
        karte = new KartenDarsteller(graphics, cani);
        karte.castPic();
        fame.add(cani);
        fame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fame.setVisible(true);
    }
}
