//Author: Samuel T. , Julius R.
import java.io.*;

public class KartenVerwalter {
    private  Karte activeMap;

    public KartenVerwalter() {

    }

    public void setActiveMap(int bI) {
        activeMap = getMapFromStorage(bI);
    }

    public Karte getMap() {
        return activeMap;
    }

    private Karte getMapFromStorage(int buildIndex) {
        Karte gesucht = new Karte();
        String g = "maps/Map" + buildIndex + ".txt";
        // soll eine karte aus den Speicher Auslesen
        karteLaden(gesucht, g);
        return gesucht;
    }

    public void karteLaden(Karte karte, String dateiName) {
        try {
            FileReader fr = new FileReader(dateiName);
            BufferedReader br = new BufferedReader(fr);
            for (int y = 0; y < karte.getSizeY(); y++) {
                String line = br.readLine();
                String[] lineArray = line.split(" ");
                for (int x = 0; x < lineArray.length; x++) {
                    if (x < karte.getSizeX()) {
                        karte.setKartenArray(x, y, Integer.parseInt(lineArray[x]));
                    }
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Exception " + e + " has occured(Kartenverwalter)");
        }
    }
}