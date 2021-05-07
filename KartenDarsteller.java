//Author: Samuel T , Julius R
// Don't touch my baby
//das hier ist nicht die Endlösung. Wir wollen bloß sehen was wir machen 
import java.awt.*;
public class KartenDarsteller
{
    private Karte kartetest;//für den Darsteller umschreiben
    private Graphics graph;
    private int csizeX;
    private int csizeY;
    public KartenDarsteller(Graphics tgraph, Canvas tcanvas)
    {
        Canvas canvas = tcanvas;
        graph = tgraph;
        kartetest = new Karte(4,4);
        kartetest.setKartenArray(2, 2, 1);
        csizeX = (int)canvas.getMaximumSize().getWidth()/kartetest.getSizeX();
        csizeY = (int)canvas.getMaximumSize().getHeight()/kartetest.getSizeY();
    }

    public void castPic()
    {

        for(int x=0;x<kartetest.getSizeX();x++){
            for(int y=0;y<kartetest.getSizeY();y++){
                if(kartetest.getCoordinate(x, y)!=0){
                    Color color = new Color(100,0,0);
                    graph.setColor(color);
                    graph.fillRect(x*csizeX,y*csizeY,csizeX,csizeY);
                }
            }
        }
    }

}
