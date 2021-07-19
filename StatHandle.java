//author Sam Titt
/* TO DO LIST
 * ENEMY FINDER
 * STATS
 * PLAYER DEACTIVATION
 */
// TECHNICAL LIMITATIONS MAKE THIS IMPOSSIBLE: STOP WRITING AN ENGINE
public class StatHandle {
	private Player activePlayerObject;
	private boolean playerAlive;
	private int difficulty;

	public StatHandle(int difftemp, Controller con) {
		this.setDiff(difftemp);
		setActivePlayerObject(new Player(con.getSpieler(), this, 100 * difficulty, con.getCast()));
	}

	public void setDiff(int i) {
		difficulty = i;
	}

	public int getDif() {
		return difficulty;
	}

	public void updatePlayerLiveState(boolean temp) {
		setPlayerAlive(temp);
	}

	public void dealDamagetoPlayer(int amount) {
		activePlayerObject.damageDealtToPlayer(amount);
	}

	public void playerSchiesen() {
		this.activePlayerObject.schiesen();
	}

	public void creatNewEnemy() {
		// Enemy enemyIns = new GegnerTyp1StatPrefab();

		// activePlayerObject.returnThisSpieler().insertEnemy(enemyIns);
	}

	public boolean isPlayerAlive() {
		return playerAlive;
	}

	public void setPlayerAlive(boolean playerAlive) {
		this.playerAlive = playerAlive;
	}

	public Player getActivePlayerObject() {
		return activePlayerObject;
	}

	public void setActivePlayerObject(Player activePlayerObject) {
		this.activePlayerObject = activePlayerObject;
	}

	// LOGIC FOR ENEMY FINDING
}
