//Nur zum test
//KEINE FUNKTION !!!
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class Hintergrundbild extends JLabel
{
    private static final long serialVersionUID = 1L;
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(img, 0, y, null)
    }
}
