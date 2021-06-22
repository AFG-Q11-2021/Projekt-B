import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//Author: Julius
public class KeyHandler implements KeyListener
{
    private Controller con;
    private Returner game;
    private Spieler s;
    private double speedm;
    private boolean rotRight = false;
    private boolean rotLeft = false;
    private boolean fwd = false;
    private boolean back = false;
    private boolean left = false;
    private boolean right = false;
    public KeyHandler(Controller c, Returner g)
    {
        con = c;
        game = g;
        s = con.getSpieler();
        speedm = s.getSpeed();
    }
    
    public void movesPlayer() {
        if (fwd == true) {
            s.geradeGehen();
        }
        if (back == true) {
            s.rueckwaertsGehen();
        }
        if (left == true) {
            s.linksGehen();
        }
        if (right == true) {
            s.rechtsGehen();
        }
        if (rotRight == true) {
            s.rechtsdrehen();
        }
        if (rotLeft == true) {
            s.linksdrehen();
        }
    }
    
    public void movemPlayer(Multiplayergame m){
        if (fwd == true) {
            s.geradeGehen();
            double x9 = s.getX();
            double y9 = s.getY();
            double r9 = s.getRotation();
            String sql = "UPDATE multiplayer SET xposition = " + x9 + ", yposition = " + y9 + ", rotation = " + r9
                + " WHERE name = '" + s.getUsername() + "'";
            m.datenbankupdaten(sql);
        }
        if (back == true) {
            s.rueckwaertsGehen();
            double x9 = s.getX();
            double y9 = s.getY();
            double r9 = s.getRotation();
            String sql = "UPDATE multiplayer SET xposition = " + x9 + ", yposition = " + y9 + ", rotation = " + r9
                + " WHERE name = '" + s.getUsername() + "'";
            m.datenbankupdaten(sql);
        }
        if (left == true) {
            s.linksGehen();
            double x9 = s.getX();
            double y9 = s.getY();
            double r9 = s.getRotation();
            String sql = "UPDATE multiplayer SET xposition = " + x9 + ", yposition = " + y9 + ", rotation = " + r9
                + " WHERE name = '" + s.getUsername() + "'";
            m.datenbankupdaten(sql);
        }
        if (right == true) {
            s.rechtsGehen();
            double x9 = s.getX();
            double y9 = s.getY();
            double r9 = s.getRotation();
            String sql = "UPDATE multiplayer SET xposition = " + x9 + ", yposition = " + y9 + ", rotation = " + r9
                + " WHERE name = '" + s.getUsername() + "'";
            m.datenbankupdaten(sql);
        }
        if (rotRight = true) {
            s.rechtsdrehen();
        }
        if (rotLeft = true) {
            s.linksdrehen();
        }    
    }
    
    private void settings() {
        game.getFrame().setVisible(false);
        new Settings(game, s.getSpeed(), s.getSpeedr(), con);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            fwd = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            back = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
            settings();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rotRight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rotLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT){
            s.setSpeed(speedm*2);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            fwd = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            back = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rotRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rotLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT){
            s.setSpeed(speedm);
        }
    }

}