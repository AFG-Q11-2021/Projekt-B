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

    private Karte kartetest;//für den Darsteller umschreiben
    private Graphics graph;
    private int csizeX;
    private int csizeY;

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

        kartetest = new Karte();
        kartetest.setKartenArray(2, 2, 1);
        csizeX = (int)WIDTH/kartetest.getSizeX();
        csizeY = (int)HEIGHT/kartetest.getSizeY();
    }

    public void render()
    {
        this.createBufferStrategy(2);
        BufferStrategy bs = this.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();

        //Karte malen
        g.setColor(Color.BLACK);
        for(int x=0;x<kartetest.getSizeX();x++){
            for(int y=0;y<kartetest.getSizeY();y++){
                if(kartetest.getCoordinate(x, y)!=0){
                    g.fillRect(x*csizeX,y*csizeY,csizeX,csizeY);
                }
                else{
                    g.drawRect(x*csizeX,y*csizeY,csizeX,csizeY);
                }
            }
        }

        //Spieler malen
        Spieler s = Controller.Getspieler();

        g.setColor(Color.RED);
        g.fillOval((int)s.getX()*csizeX,(int)(s.getY()*csizeY), 10, 10);
        switch((int)s.getRotation()/90){
            case 1: g.drawLine((int)(s.getX()*csizeX)+5, (int)(s.getY()*csizeY)+5, (int)(s.getX()*csizeX)+5, (int)(s.getY()*csizeY)-10);
            case 0: g.drawLine((int)(s.getX()*csizeX)+5, (int)(s.getY()*csizeY)+5, (int)(s.getX()*csizeX)+10, (int)(s.getY()*csizeY)+5);
            case 2: g.drawLine((int)(s.getX()*csizeX)+5, (int)(s.getY()*csizeY)+5, (int)(s.getX()*csizeX)-10, (int)(s.getY()*csizeY)+5);
            case 3: g.drawLine((int)(s.getX()*csizeX)+5, (int)(s.getY()*csizeY)+5, (int)(s.getX()*csizeX)+5, (int)(s.getY()*csizeY)+10);
        }

        this.graphics = g;
        bs.show();

    }

}
