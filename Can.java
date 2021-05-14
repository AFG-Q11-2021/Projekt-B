/**
 * Frame Class
 *
 * @author Christopher Scherübl (14.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import javax.swing.*;

public class Can extends JPanel
{
    Image bild;
    
    public Can()
    {
        setFocusable(true);
        ImageIcon b = new ImageIcon("");
        bild = b.getImage();
    }
    
    public void paint (Graphics g)
    {
        super.paint(g);
        Graphics2D f2= (Graphics2D)g;
        f2.drawImage(bild,0,0,null);
    }
}
