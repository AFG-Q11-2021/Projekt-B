//Autor:Julius/Samuel
//not for use!!! only data type like int. Not for use
public class Karte
{
    private int[][] kartenArray;
    private int x1;
    private int y1;
    public Karte(int x, int y)
    {
        kartenArray = new int[x][y];// setzt die Kartengröße
        x1=x;
        y1=y;
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
        return x1;
    }
    
    public int getSizeY()
    {
        return y1;
    }
}
