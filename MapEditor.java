import java.io.*;

/**
 * Write a description of class MapEditor here.
 *
 * @author Niklas Rösner, Laurens Birkenbach (30.04.2021)
 * @version 0.1
 */
public class MapEditor
{
 
    public void karteAktualisieren(Karte karte, String dateiName){
        FileReader fr = new FileReader(dateiName);
        BufferedReader br = new BufferedReader(fr);
        
        for(int y = 0; y < karte.getSizeY();y++){
            try{
                    String line = br.readLine();
                    String[] lineArray = line.split(" ");
                    for(int x = 0; x < lineArray.length;x++){
                        if(x < karte.getSizeX()){
                             karte.setKartenArray(x,y,Integer.parseInt(lineArray[x]));
                        }
                   
                    }
                    
            } catch (Exception e){
                //Klingelin
            }
    
            
        }
    }
    
    
    
}
