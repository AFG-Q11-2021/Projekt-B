
/**
 * Multiplayer Class
 *
 * @author Christopher Scherübl und Julius R.(14.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Multiplayer extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel label;
	private JTextField name;
	private JButton starten;

	public Multiplayer(String title) {
		super(title);
		setTitle("Multiplayer");
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		label = new JLabel("Spielername");
		name = new JTextField("", 20);
		starten = new JButton("Spiel starten");

		name.setForeground(Color.BLACK);
		name.setBackground(Color.WHITE);

		starten.addActionListener(this);

		panel.add(label);
		panel.add(name);
		panel.add(starten);

		add(panel);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == starten) {
			starten1();
			this.setVisible(false);
		}
	}

	public static void starten1() {
		Multiplayergame gamee = new Multiplayergame();
		Controller.setGame(gamee);
	}

}
