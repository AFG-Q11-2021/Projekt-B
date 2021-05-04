import java.awt.*;
import javax.swing.*;
public class tester
{
    private KartenDarsteller karte;
    
    public tester(){
        JFrame fame=new JFrame("test");
        fame.setSize(600,600);
        Canvas cani= new Canvas();
        fame.add(cani);
        
        karte = new KartenDarsteller(cani);
        
        
        fame.setVisible(true);
    }
}
