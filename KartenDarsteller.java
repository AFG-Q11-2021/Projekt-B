//Author: Samuel T , Julius R
// Don't touch my baby 
import java.awt.*;
public class KartenDarsteller
{
    private Karte kartetest;//für den Darsteller umschreiben
    private Canvas canvas;
    public KartenDarsteller(Canvas tcanvas)
    {
        canvas = tcanvas;
        kartetest = new Karte(4,4);
        kartetest.setKartenArray(2, 2, 1);
        int csizeX = canvas.getMaximumSize().getWidth()/kartetest.getSizeX();
        int csizeY = canvas.getMaximumSize().getHeight()/kartetest.getSizeY();
    }
    
    public void castPic()
    {
        Graphics graph;
        for(int x=0;x<kartetest.getSizeX();x++){
            for(int y=0;y<kartetest.getSizeY();y++){
                if(kartetest.getCoordinate(x, y)!=0){
                    graph.drawRect(x*csizeX,y*csizeY,csizeX,csizeY);
                }
            }
        }
    }
    
}
