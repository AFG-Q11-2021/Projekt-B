//Autor:Julius/Samuel
//not for use!!! only data type like int. Not for use
public class Karte
{
    private int[][] kartenArray;
    private int x;
    private int y;
    public Karte(int x, int y)
    {
        kartenArray = new int[x][y];// setzt die Kartengröße
        
    }
    
    public void setKartenArray(int xCoord , int yCoord, int filler)
    {
        kartenArray[xCoord][yCoord] = filler; //zum MapBuilden
    }
    
    public int[][] getEntireMap()
    {
        return kartenArray;
    }
    
    public int getCoordinate(int x, int y)
    {
        return kartenArray[x][y];
    }
    
    public int getSizeX()
    {
        return x;
    }
    
    public int getSizeY()
    {
        return y;
    }
}
