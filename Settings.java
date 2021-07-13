import java.awt.event.*;
import javax.swing.*;

//Author Julius Rommel

@SuppressWarnings("serial")
public class Settings extends JFrame implements ActionListener, KeyListener {
    private Returner fra;
    private JTextField textspeed, textrotation, textresolution;
    private JLabel labelspeed, labelrotation, labelresolution;
    private JButton exit, save;
    private Controller con;

    public Settings(Returner f, double speedm, double speedr, Controller c) {
        fra = f;
        con = c;

        save = new JButton("Save Settings");
        save.setBounds(280, 710, 750, 50);
        save.addActionListener(this);
        add(save);

        exit = new JButton("Leave Settings");
        exit.setBounds(280, 770, 750, 50);
        exit.addActionListener(this);
        add(exit);

        // movementspeed setting
        int tempm = (int) (speedm * 100);
        textspeed = new JTextField(Integer.toString(tempm));
        textspeed.setBounds(500, 590, 530, 50);
        add(textspeed);
        labelspeed = new JLabel("Player movement speed (higher=faster)");
        labelspeed.setBounds(180, 590, 750, 50);
        add(labelspeed);

        // rotationspeed setting
        int tempr = (int) (speedr * 100);
        textrotation = new JTextField(Integer.toString(tempr));
        textrotation.setBounds(500, 530, 530, 50);
        add(textrotation);
        labelrotation = new JLabel("Player rotational speed (higher=faster)");
        labelrotation.setBounds(180, 530, 750, 50);
        add(labelrotation);

        // resolution setting
        textresolution = new JTextField(Integer.toString(con.getCast().getResolution()));
        textresolution.setBounds(500, 470, 530, 50);
        add(textresolution);
        labelresolution = new JLabel("Resolution of 3D-Render (lower=better)");
        labelresolution.setBounds(180, 470, 7500, 50);
        add(labelresolution);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1290, 1100);
        setLayout(null);
        setVisible(true);

    }

    private void save() {
        double sm = Integer.valueOf(textspeed.getText());
        sm = sm / 100;
        fra.setSpeed(sm);
        double sr = Integer.valueOf(textrotation.getText());
        sr = sr / 100;
        fra.setSpeedr(sr);
        int r = Integer.valueOf(textresolution.getText());
        con.getCast().setwallRes(r);
        con.getCast().setfloorRes(r);
        if(con.getGame()!=null){
            con.getCast().updategame();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            fra.returne();
            setVisible(false);
        } else if (e.getSource() == save) {
            save();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            save();
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
            fra.returne();
            setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
