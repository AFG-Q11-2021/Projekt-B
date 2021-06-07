import java.awt.event.*;
import javax.swing.*;

//Author: Julius Rommel

@SuppressWarnings("serial")
public class Settings extends JFrame implements ActionListener {
	private Returner fra;
	private JTextField textspeed;
	private JLabel labelspeed;
	private JTextField textrotation;
	private JLabel labelrotation;
	private JButton exit;
	private JButton save;

	public Settings(Returner f, double speedm, double speedr) {
		fra = f;

		save = new JButton("Save Settings");
		save.setBounds(280, 710, 750, 50);
		save.addActionListener(this);
		add(save);

		exit = new JButton("Leave Settings");
		exit.setBounds(280, 770, 750, 50);
		exit.addActionListener(this);
		add(exit);

		int tempm = (int) (speedm * 100);
		textspeed = new JTextField(Integer.toString(tempm));
		textspeed.setBounds(380, 590, 650, 50);
		add(textspeed);

		labelspeed = new JLabel("Player movement speed");
		labelspeed.setBounds(180, 590, 750, 50);
		add(labelspeed);
		
		int tempr = (int) (speedr * 100);
		textrotation = new JTextField(Integer.toString(tempr));
		textrotation.setBounds(380, 530, 650, 50);
		add(textrotation);
		
		labelrotation = new JLabel("Player rotational speed");
		labelrotation.setBounds(180, 530, 750, 50);
		add(labelrotation);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1290, 1100);
		setLayout(null);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			fra.returne();
			setVisible(false);
		} else if (e.getSource() == save) {
			double sm = Integer.valueOf(textspeed.getText());
			sm = sm / 100;
			fra.setSpeed(sm);
			double sr = Integer.valueOf(textrotation.getText());
			sr = sr / 100;
			fra.setSpeedr(sr);
		}
	}

}
