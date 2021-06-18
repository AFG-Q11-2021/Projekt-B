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
    public EnemyTree tree;
    public StatHandle(Spieler s, int maxLIVE)
    {
        activePlayerObject = new Player(s, this, maxLIVE);
    }
    
    public void updatePlayerLiveState(boolean temp)
    {
        playerAlive = temp;
    }
    
    public void dealDamagetoPlayer(int amount)
    {
        activePlayerObject.damageDealtToPlayer(amount);
    }
    
    public void dealDamageToEnemy(int amount, int iD)
    {
        tree.returnEnemy(iD).dealDamage(amount);
    }
    
    //LOGIC FOR ENEMY FINDING
}
