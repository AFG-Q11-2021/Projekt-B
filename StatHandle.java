//author Sam Titt
/* TO DO LIST
 * ENEMY FINDER
 * STATS
 * PLAYER DEACTIVATION
 */

public class StatHandle
{
    public Player activePlayerObject;
    public boolean playerAlive;
    private int difficulty;
    public StatHandle(Spieler s, int maxLIVE)
    {
        activePlayerObject = new Player(s, this, maxLIVE);
    }
    
    public void setDiff(int i)
    {
        difficulty = i;
    }
    
    public int getDif()
    {
        return difficulty;
    }
    
    public void updatePlayerLiveState(boolean temp)
    {
        playerAlive = temp;
    }
    
    public void dealDamagetoPlayer(int amount)
    {
        activePlayerObject.damageDealtToPlayer(amount);
    }
    
    //LOGIC FOR ENEMY FINDING
}
