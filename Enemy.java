//Author Sam Titt

public class Enemy
{
    public Spieler actPlayer;
    private int maxHealth = 100;//contained to 100 each
    public int currentHealth;
    private int maxArmor = 100;
    public int currentArmor;
    public boolean alive;
    public float currentX, currentY;
    
    //abstract public int getThisID();
    
    
    
    public void dealDamage(int amount)
    {
        int i = currentHealth + currentArmor;
        
        if(i > 100)
        {
            i= i-amount;
            if(currentArmor - i < 0)
            {
                int y = currentArmor - amount;
                currentHealth = currentHealth + y;
            } else
            {
             currentArmor = currentArmor - amount;    
            }
        }
        else
        {
            currentHealth = currentHealth - amount;
        }
        
        if(currentHealth <= 0)
        {
          this.changeLiveStatus(false);   
        }
        
        //new ID finding
    }
    
    public int giveDamage()
    {
        return currentHealth;
    }
    
    public int giveArmor()
    {
        return currentArmor;
    }
    
    public void setHealth(int amount)
    {
        currentHealth = amount;
    }
    
    public void setArmor(int amount)
    {
        currentArmor = amount;
    }
    
    public void setHealthMax()
    {
        currentHealth = maxHealth;
    }
    public void setArmorMax()
    {
        currentArmor = maxArmor;
    }
    
    public void checkAlive()
    {
        if(alive = true)
        {
            
        }
        else if (alive = false)
        {
            this.deactivate();
        }
    }
    
    public void changeLiveStatus(boolean checkset)
    {
        alive = checkset;
    }
    
    public void eventListener()
    {
        
    }//has to be activated every frame or so to check for live actions
    
    
    private void deactivate()
    {
        //deactivates Movement
        //deactivates Weapon
        //deactivates rendering of enemy
    }
    
    //please implement logic to find the Enemy, consider to ask the RayCaster for help
    // ALTERNATIVE PLANS :
    // ENEMY ARRAY
    // TREE
    // EVENT SYSTEM
    
}
