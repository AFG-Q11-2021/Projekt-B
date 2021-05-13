//Author: Samuel T , Julius R
import java.io.*;
public class Kartenverwalter
{
    private Karte activeMap;

    public Kartenverwalter()
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
        Karte gesucht = new Karte();
        String g = buildIndex + ".txt";
        //soll eine karte aus den Speicher Auslesen
        this.karteLaden(gesucht,g);
        return gesucht;
    }

    private void karteLaden(Karte karte, String dateiName){
        try{
            FileReader fr = new FileReader(dateiName);
            BufferedReader br = new BufferedReader(fr);

            for(int y = 0; y < karte.getSizeY();y++){

                String line = br.readLine();
                String[] lineArray = line.split(" ");
                for(int x = 0; x < lineArray.length;x++){
                    if(x < karte.getSizeX()){
                        karte.setKartenArray(x,y,Integer.parseInt(lineArray[x]));
                    }
                }
            }
            br.close();
        } 
        catch (Exception e){
            //Klingelin
        }
    }
}