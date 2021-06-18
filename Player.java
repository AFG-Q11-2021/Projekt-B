//Author Sam Titt

public class Player
{
    public Spieler actPlay;
    public StatHandle handler;
    public int maxH, curH;
    public int maxA, curA;
    public boolean aliveChecker;
    public Player(Spieler playTemp, StatHandle statTemp)
    {
        handler = statTemp;
        actPlay = playTemp;
        maxH = 100;
        curH = 100;
        maxA = 100;
        curA = 100;
        
        aliveChecker = true;
        handler.updatePlayerLiveState(aliveChecker);
    }
    
    public void setPlayer(Spieler temp)
    {
         actPlay = temp;
    }
    
    public void setCurrentHealth(int amount)
    {
        curH = amount;
    }
    public void checkAlive()
    {
        if(curH <= 0)
        {
            aliveChecker = false;
            handler.updatePlayerLiveState(aliveChecker);
        } else
        {
            handler.updatePlayerLiveState(aliveChecker);
        }
    }
    public void damageDealtToPlayer(int amount)
    {
        curH = curH-amount; //rewrite to account for armor
        this.checkAlive();
    }
}
