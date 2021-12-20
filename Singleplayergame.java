/*
 * @author Christopher Scheruebl, Laurens Birkenbach, Julius Rommel (07.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import javax.swing.*;



@SuppressWarnings("serial")
public class Singleplayergame extends Canvas implements Game, Returner {
    private final JFrame frame1;
    private final KeyHandler key;
    private Spieler s;
	private final int width;
	private final int height;
    private final Controller con;
    // private boolean shoot = false;

    public Singleplayergame(Controller c, Spieler sp) {
        con = c;
        s = sp;
        key = new KeyHandler(con, this);
        frame1 = new JFrame();
        frame1.setPreferredSize(new Dimension(1000, 1000));
        frame1.setTitle("Game");
        frame1.add(this);
        frame1.pack();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        this.setPreferredSize(frame1.getPreferredSize());
        width = (int) frame1.getPreferredSize().getWidth();
        height = (int) frame1.getPreferredSize().getHeight();
        this.addKeyListener(key);
    }

    public void update() {
        key.movesPlayer();
    }

    public void render() {
        key.movesPlayer();
    }

    public int gibWidth() {
        return width;
    }

    public int gibHeight() {
        return height;
    }

    public void setSpieler(Spieler spieler) {
        s = spieler;
    }

    public void setSpeed(double spielers) {
        s.setSpeed(spielers);
    }

    public void setSpeedr(double speedr) {
        s.setSpeedr(speedr);
    }

    public JFrame getFrame() {
        return frame1;
    }

    public void returne() {
        frame1.setVisible(true);
    }

    public void dealDamage() {
    }
}
