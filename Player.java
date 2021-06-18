//Author Sam Titt

public class Player
{
    public Spieler actPlay;
    public StatHandle handler;
    public int maxH, curH;
    public int maxA, curA;
    public boolean aliveChecker;
    public Player(Spieler playTemp, StatHandle statTemp, int max)
    {
        handler = statTemp;
        actPlay = playTemp;
        maxH = max;
        curH = max;
        maxA = max;
        curA = max;
        
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
    
    public void setCurrentArmor(int amount)
    {
        curA = amount;
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
    
    public void pickUP(boolean type, int amount)
    {
        if(type == true) //healthPickup
        {
            this.setCurrentHealth(curH + amount);   
        } else if (type == false)
        {
            this.setCurrentArmor(amount);
        }
    }
}
