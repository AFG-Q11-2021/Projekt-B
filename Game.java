import java.awt.*;
/**
 * Tragen Sie hier eine Beschreibung des Interface Game ein.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public interface Game
{
    abstract int getWidth();
    abstract int getHeight();
    abstract void render();
    abstract void setSpieler(Spieler spiler);
    abstract Graphics getGraphics();
}
