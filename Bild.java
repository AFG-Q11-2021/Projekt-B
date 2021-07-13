
/**
 * Bild Class
 * @author Christopher Scherübl (18.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Bild extends JPanel {
    Image bild;

    public Bild() {
        setFocusable(true);
        ImageIcon b = new ImageIcon("bild/Hintergrundbild.png");
        bild = b.getImage();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D f2 = (Graphics2D) g;
        f2.drawImage(bild, 0, 0, 1290, 1000, 0, 0, bild.getWidth(null), bild.getHeight(null), null);
    }
}
