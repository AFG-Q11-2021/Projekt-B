public class GegnerPrefab
{
    public Enemy statScript;
    public Player playerStatScript;
    public StatHandle statSystem;
    public EnemyAI entityAI;
    private int ID;
    public GegnerPrefab(Enemy temp, Player tempP, StatHandle tempS, int tempID)
    {
        ID= tempID;
        statScript = temp;
        playerStatScript = tempP;
        statSystem = tempS;
    }
    
    public int giveID()
    {
        return this.ID;
    }
    
    
}
