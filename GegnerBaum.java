
//Samuel
public class GegnerBaum
{
    private int IDint = 0;
    public GegnerPrefab[] eneArray = new GegnerPrefab[30];
    public StatHandle active;
    
    public GegnerBaum(StatHandle stemp)
    {
      active = stemp; 
    }
    
    public void createNewEnemyInstance(Spieler s)
    {
        if(IDint < eneArray.length)
        {
            Enemy e = new Enemy();
            IDint = IDint++;
            GegnerPrefab x = new GegnerPrefab(e, active.activePlayerObject, active, IDint);
            eneArray[IDint] = x;
        }else
        {
            System.out.println("Failed to instantiate new enemy");
        }
        
    }
}
