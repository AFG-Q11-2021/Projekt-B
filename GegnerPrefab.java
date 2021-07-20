public class GegnerPrefab {
    private Enemy statScript;
    private Player playerStatScript;
    private StatHandle statSystem;
    private EnemyAI entityAI;
    private int ID;

    public GegnerPrefab(Enemy temp, Player tempP, StatHandle tempS, int tempID) {
        setID(tempID);
        setStatScript(temp);
        setPlayerStatScript(tempP);
        setStatSystem(tempS);
    }

    public Enemy getStatScript() {
        return statScript;
    }

    public void setStatScript(Enemy statScript) {
        this.statScript = statScript;
    }

    public Player getPlayerStatScript() {
        return playerStatScript;
    }

    public void setPlayerStatScript(Player playerStatScript) {
        this.playerStatScript = playerStatScript;
    }

    public StatHandle getStatSystem() {
        return statSystem;
    }

    public void setStatSystem(StatHandle statSystem) {
        this.statSystem = statSystem;
    }

    public EnemyAI getEntityAI() {
        return entityAI;
    }

    public void setEntityAI(EnemyAI entityAI) {
        this.entityAI = entityAI;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

}
