
//Samuel
public class GegnerBaum {
    private int IDint = 0;
    private GegnerPrefab[] eneArray = new GegnerPrefab[30];
    private StatHandle active;

    public GegnerBaum(StatHandle stemp) {
        setActive(stemp);
    }

    public int getIDint() {
        return IDint;
    }

    public void setIDint(int iDint) {
        IDint = iDint;
    }

    public GegnerPrefab[] getEneArray() {
        return eneArray;
    }

    public void setEneArray(GegnerPrefab[] eneArray) {
        this.eneArray = eneArray;
    }

    public StatHandle getActive() {
        return active;
    }

    public void setActive(StatHandle active) {
        this.active = active;
    }

    public void createNewEnemyInstance(Spieler s) {
        if (IDint < eneArray.length) {
            Enemy e = new Enemy();
            GegnerPrefab x = new GegnerPrefab(e, active.getActivePlayerObject(), active, IDint);
            eneArray[IDint] = x;
            IDint++;
        } else {
            System.out.println("Failed to instantiate new enemy");
        }

    }
}
