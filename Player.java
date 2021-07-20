
//Author Sam Titt
import java.util.Random;

public class Player {
    // IMPORTATNTE
    // *******
    // Implementas de la ammunitone
    // *******
    private Spieler actPlay;
    private StatHandle handler;
    private int maxH, curH, maxA, curA, ammoType1, ammoType2, ammoType3;
    private boolean aliveChecker;
    private Caster caster;
    private GegnerBaum baum;
    private Random randomGen;

    public Player(Spieler playTemp, StatHandle statTemp, int max, Caster castert) {
        aliveChecker = true;
        handler = statTemp;
        actPlay = playTemp;
        caster = castert;
        maxH = max;
        curH = max;
        maxA = max;
        curA = max;
        baum = new GegnerBaum(handler);
        randomGen = new Random();
        handler.updatePlayerLiveState(aliveChecker);
    }

    public void schiesen() {
        int a = 5;
        int i = caster.getHitID();
        if (i > -1) {
             baum.getEneArray()[i].getStatScript().dealDamage(a);
        }
    }

    public void setPlayer(Spieler temp) {
        actPlay = temp;
    }

    public void setCurrentHealth(int amount) {
        curH = amount;
    }

    public void setCurrentArmor(int amount) {
        curA = amount;
    }

    public void checkAlive() {
        if (curH <= 0) {
            aliveChecker = false;
            handler.updatePlayerLiveState(aliveChecker);
        } else {
            handler.updatePlayerLiveState(aliveChecker);
        }
    }

    public void damageDealtToPlayer(int amount) {
        curH = curH - amount; // rewrite to account for armor
        this.checkAlive();
    }

    public void pickUP(boolean type, int amount) {
        if (type == true) {// healthPickup
            this.setCurrentHealth(curH + amount);
        } else {
            this.setCurrentArmor(amount);
        }
    }

    public void shoot(int damage, int rngOAW) {
        // double yCO = actPlay.getX();
        // double xCO = actPlay.getY();
        // double rotat = actPlay.getRotation();

    }

    public Spieler returnThisSpieler() {
        return this.actPlay;
    }

}
