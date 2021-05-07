/**
 * Game Class
 *
 * @author Christopher Scherübl, Laurens Birkenbach (07.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

public class Game extends Canvas
{
    public JFrame frame1;
    public Graphics graphics;
    private String title = "Game";
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;

    public Game()
    {
        JFrame frame1 = new JFrame();
        Dimension size = new Dimension(WIDTH,HEIGHT);

        this.setPreferredSize(size);
        frame1.setTitle(title);
        frame1.add(this);
        frame1.pack();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

    public void render()
    {
        this.createBufferStrategy(2);
        BufferStrategy bs = this.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(0,0,WIDTH,HEIGHT);
        this.graphics = g;
        bs.show();
        
    }

}
