public class EnemyAI
{
    private Enemy e;
    private StatHandle stat;
    private Player pl;
    public EnemyAI(Enemy eT, StatHandle temp)
    {
         setE(eT);
         setStat(temp);
         
    }
	
	public StatHandle getStat() {
		return stat;
	}
	
	public void setStat(StatHandle stat) {
		this.stat = stat;
	}
	
	public Player getPl() {
		return pl;
	}
	
	public void setPl(Player pl) {
		this.pl = pl;
	}
	
	public Enemy getE() {
		return e;
	}
	
	public void setE(Enemy e) {
		this.e = e;
	}
    
    
}
