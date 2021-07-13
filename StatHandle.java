//author Sam Titt
/* TO DO LIST
 * ENEMY FINDER
 * STATS
 * PLAYER DEACTIVATION
 */
// TECHNICAL LIMITATIONS MAKE THIS IMPOSSIBLE: STOP WRITING AN ENGINE
public class StatHandle
{
    public Player activePlayerObject;
    public boolean playerAlive;
    private int difficulty;
    public StatHandle(Spieler s, int difftemp)
    {
        this.setDiff(difftemp);
        activePlayerObject = new Player(s, this, 100*difficulty);
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
    
    public void creatNewEnemy()
    {
        //Enemy enemyIns = new GegnerTyp1StatPrefab();
        
       // activePlayerObject.returnThisSpieler().insertEnemy(enemyIns);
    }
    
    //LOGIC FOR ENEMY FINDING
}
