import java.awt.event.*;

//Author: Julius
public class KeyHandler extends MouseAdapter implements KeyListener {
	private Controller con;
	private Returner game;
	private Spieler s;
	private StatHandle stat;
	private double speedm;
	private boolean rotRight = false;
	private boolean rotLeft = false;
	private boolean fwd = false;
	private boolean back = false;
	private boolean left = false;
	private boolean right = false;
	private boolean exit;

	public KeyHandler(Controller c, Returner g) {
		con = c;
		game = g;
		s = con.getSpieler();
		speedm = s.getSpeed();
		stat = con.getStatHandle();
	}

	public void mouseClicked(MouseEvent e) {
		stat.playerSchiesen();
		game.dealDamage();
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
		if (exit == true) {
			System.exit(0);
		}
	}

	public void movemPlayer(Multiplayergame m) {
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
		double x9 = s.getX();
		double y9 = s.getY();
		double r9 = s.getRotation();
		String sql = "UPDATE multiplayer SET xposition = " + x9 + ", yposition = " + y9 + ", rotation = " + r9
				+ " WHERE name = '" + s.getUsername() + "'";
		m.datenbankupdaten(sql);

		if (exit == true) {
			m.datenbankupdaten("DELETE FROM multiplayer WHERE name = '" + s.getUsername() + "'");
			System.exit(0);
		}
	}

	private void settings() {
		game.getFrame().setVisible(false);
		con.getCast().setRun(false);
		new Settings(game, s.getSpeed(), s.getSpeedr(), con);
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
			exit = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rotRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rotLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			s.setSpeed(speedm * 2);
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
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			exit = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rotRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rotLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			s.setSpeed(speedm);
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}
