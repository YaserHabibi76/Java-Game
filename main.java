import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;

public class main extends JFrame implements ActionListener {
	JButton instruction;
	JButton objective;
	JPanel panel;
	JButton play;
	JLabel label; // label for double buffering
	BufferedImage bImage;
	Graphics g;
	Timer myTimer;
	int carx = 240;
	int cary = 430;

	public main() {

		setLayout(new GridBagLayout());

		panel = new JPanel(new GridBagLayout()); // in a panel
		getContentPane().add(panel);

		// constraints tells the system where to put
		// the label or whatever inside the panel

		// Create a GridBagConstraints object
		GridBagConstraints c = new GridBagConstraints();
		instruction = new JButton("Instruction"); // instruction button
		instruction.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(25, 25, 25, 25);
		panel.add(instruction, c);

		objective = new JButton("Objective"); // objective button
		// objective.se
		c.gridx = 2;
		c.gridy = 2;
		c.insets = new Insets(25, 25, 25, 25);
		panel.add(objective, c);
		objective.setFont(new Font("Comic Sans MS", Font.BOLD, 40));

		instruction.addActionListener(this);
		instruction.setActionCommand("instruction");
		objective.addActionListener(this);
		objective.setActionCommand("objective");

		play = new JButton("PLAY"); // play button
		play.setFont(new Font("Comic Sans MS", Font.BOLD, 78));
		play.addActionListener(this);
		play.setActionCommand("play");
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(35, 25, 35, 25);
		panel.add(play, c);

		add(instruction);
		add(play);
		add(objective);

		setTitle("Save Your Ferrari!");// sets the title for the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 0, 1100, 800);
		setVisible(true);
		getContentPane().setBackground(new Color(155, 190, 220));
		repaint();

		// the code below makes a Graphics object on which we can paint stuff
		// and associates this Graphics object with a label to be displayed
		// in our window.
		label = new JLabel();// a JLabel that covers the frame is used to display an image
		// a BufferedImage is a virtual image object, like a canvas
		bImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		g = bImage.getGraphics();// access the graphics object of the BufferedImage

	}

	public void paint(Graphics g) {
		// Repaints the frame and its components
		super.paint(g);
		// Declare and initialize a Graphics2D object
		Graphics2D g2 = (Graphics2D) g;
		// Sets the font and colour of the string
		Font f = new Font("Comic Sans MS", Font.BOLD, 70);
		g2.setFont(f);
		g2.setColor(Color.black);
		// Draws the string
		g2.drawString("Save Your", 400, 120);
		Font ff = new Font("Comic Sans MS", Font.BOLD, 140);
		g2.setFont(ff);
		g2.drawString("Ferrari!!", 300, 270);
		Font ffF = new Font("Comic Sans MS", Font.BOLD, 90);
		g2.setFont(ffF);
		g2.setColor(Color.red);
		g2.drawString("TORNADO ALERT", 145, 550);
		g2.drawString("!!!!!!!!!!!!!", 445, 650);

		Font ffff = new Font("Comic Sans MS", Font.BOLD, 20);
		g2.setFont(ffff);
		g2.setColor(Color.DARK_GRAY);
		g2.drawString("Created and Founded by: Yaser Habibi", 405, 780);

		int[][] rect = new int[8][8]; // 2D array to create the rectangles
		for (int i = 0; i < rect.length; i++) {
			for (int m = 0; m < rect[i].length; m++) {
				rect[i][m] = (int) ((820 - 10 + 1) * Math.random() + 10);
			}

		}
		for (int i = 0; i < rect.length; i++) {
			for (int m = 0; m < rect[i].length; m++) {
				g2.setColor(new Color(55, 30, 155));
				g2.fillRect(20, rect[i][m], 70, 10);
			}

		}

		int[][] oval = new int[6][6]; // 2D array to create the ovals
		for (int i = 0; i < oval.length; i++) {
			for (int m = 0; m < oval[i].length; m++) {
				oval[i][m] = (int) ((820 - 20 + 1) * Math.random() + 20);
			}

		}
		for (int i = 0; i < oval.length; i++) {
			for (int m = 0; m < oval[i].length; m++) {
				g2.setColor(new Color(55, 30, 155));
				g2.fillOval(oval[m][i], 30, 60, 10);
			}

		}

	}

	public void actionPerformed(ActionEvent evt) {

		if (evt.getActionCommand().equals("instruction")) { // if user clicks instruction button
			JOptionPane.showMessageDialog(null,
					"Use the Arraw keys to move your car. You must reach 3250 points before your health reaches 0. "
							+ "Otherwise your car will be destroyed",
					"Save Your Ferrari Instructions", JOptionPane.INFORMATION_MESSAGE);

		} else if (evt.getActionCommand().equals("objective")) { // if user clicks objective button
			JOptionPane.showMessageDialog(null,
					"Warning!!! A Tornado is set out to destroy your BRAND NEW FERRARI. "
							+ "Dodge the flying objects untill you have escaped the Tornado... GOOD LUCK ",
					"Save Your Ferrari Objective", JOptionPane.INFORMATION_MESSAGE);

		} else if (evt.getActionCommand().equals("play")) { // if user clicks play button
			setVisible(false);
			rocks rock = new rocks(); // if user clicks play, the code goes to the rocks class

		}

	}

	public static void main(String[] args) {
		main kjnm = new main();
	}

}