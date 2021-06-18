//author Sam Titt

public class StatHandle
{
    public Player activePlayerObject;
    public boolean playerAlive;
    public StatHandle(Spieler s)
    {
        activePlayerObject = new Player(s, this);
    }
    
    public void updatePlayerLiveState(boolean temp)
    {
        playerAlive = temp;
    }
    
    public void dealDamagetoPlayer(int amount)
    {
        activePlayerObject.damageDealtToPlayer(amount);
    }
}
