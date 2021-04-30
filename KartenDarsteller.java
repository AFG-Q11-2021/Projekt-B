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
    }
    
    public void castTestPic(int width, int heigth)
    {
        int coordSizeX = width/kartetest.getSizeX();
        int coordsizeY = heigth/kartetest.getSizeY();
    }
    
}
