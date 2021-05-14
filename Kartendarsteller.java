//Author: Samuel T , Julius R
// Don't touch my baby
//das hier ist nicht die Endlösung. Wir wollen bloß sehen was wir machen 
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
public class Kartendarsteller
{
    private Karte kartetest;//für den Darsteller umschreiben
    private Graphics graph;
    private int csizeX;
    private int csizeY;
    private Game canvas;
    public Kartendarsteller(Graphics tgraph, Game tcanvas)
    {
        canvas = tcanvas;
        graph = tgraph;
        kartetest = new Karte();
        kartetest.setKartenArray(2, 2, 1);
        csizeX = (int)canvas.getMaximumSize().getWidth()/kartetest.getSizeX();
        csizeY = (int)canvas.getMaximumSize().getHeight()/kartetest.getSizeY();
    }


    public Graphics castPic()
    {

        canvas.createBufferStrategy(2);
        BufferStrategy bs = canvas.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.GREEN);
        //g.fillRect(0,0,WIDTH,HEIGHT);
        

        for(int x=0;x<kartetest.getSizeX();x++){
            for(int y=0;y<kartetest.getSizeY();y++){
                if(kartetest.getCoordinate(x, y)!=0)
                {
                    g.fillRect(x*csizeX,y*csizeY,csizeX,csizeY);
                }
            }
        }
        canvas.graphics = g;
        bs.show();
        return graph;
    }


}