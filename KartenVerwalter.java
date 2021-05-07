//Author: Samuel T , Julius R
public class KartenVerwalter
{
    Karte activeMap;
    
    public KartenVerwalter()
    {
        
    }
    
    public void setActiveMap(int bI)
    {
        activeMap = this.getMapFromStorage(bI);
    }
    
    public Karte getMap()
    {
        return activeMap;
    }
    
    private Karte getMapFromStorage(int buildIndex)
    {
        Karte gesucht;
        //soll eine karte aus den Speicher Auslesen
        return gesucht;
    }
    
}
