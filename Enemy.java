//Author Sam Titt

public abstract class Enemy
{
    private int ID;
    public Spieler actPlayer;
    private int maxHealth;
    public int currentHealth;
    public int maxArmor;
    public int currentArmor;
    public boolean alive;
    //abstract public int getThisID();
    abstract public void dealDamage(int amount);
    abstract public int giveDamage();
    abstract public int giveArmor();
    
    
    abstract public void setHealth(int amount);
    abstract public void setArmor(int amount);
    abstract public void setHealthMax();
    abstract public void setArmorMax();
    
    abstract public void checkAlive();
    abstract public void changeLiveStatus(boolean checkset);
    
    abstract public void eventListener(); //has to be activated every frame or so to check for live actions
    
    
    
}
