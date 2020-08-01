import javax.swing.*;

import javafx.geometry.Rectangle2D;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class rocks extends JFrame {
	JLabel label;
	rockssss rock1, rock2, rock3, rock4, rock5, rock6, rock7, rock8, rock9, rock10;
	rockssss collision1, collision2, collision3, collision4, collision5, collision6, collision7, collision8;
	rockssss collisionCheck;
	Timer myTimer;// a Timer used to generate action events
	BufferedImage bImage;
	Graphics g;
	ImageIcon iIcon;
	int points = 0;
	int x, x1, x2, x3, x4, x5, x6, x7, x8;
	int w, w1, w2, w3, w4, w5, w6, w7, w8;
	int carx = 200;
	int cary = 200;
	int m1, m2, m3, m4;
	int playerx = 300;
	int playery = 300;
	int health = 100;
	boolean gameOver = false;

	// the rocks constructor
	public rocks() {

		// for loop for each rock to make a random number

		for (int i = 0; i < 9; i++) {
			if (i == 0) {
				x = (int) ((560 - 20 + 1) * Math.random() + 20);
				w = (int) ((100 - 10 + 1) * Math.random() + 10);
				rock1 = new rockssss(x, -150, w, w, new Color(255, 0, 0), 1);// red

			}
			if (i == 1) {
				x1 = (int) ((560 - 20 + 1) * Math.random() + 20);
				w1 = (int) ((90 - 10 + 1) * Math.random() + 10);
				rock2 = new rockssss(x1, -5, w1, w1, new Color(255, 0, 255), 1);// blue
			}
			if (i == 2) {
				x2 = (int) ((560 - 20 + 1) * Math.random() + 20);
				w2 = (int) ((90 - 10 + 1) * Math.random() + 10);
				rock3 = new rockssss(x2, -116, w2, w2, new Color(0, 255, 0), 1);// green
			}
			if (i == 3) {
				x3 = (int) ((560 - 20 + 1) * Math.random() + 20);
				w3 = (int) ((90 - 10 + 1) * Math.random() + 10);
				rock5 = new rockssss(x3, -60, w3, w3, new Color(255, 0, 0), 2);// red
			}
			if (i == 4) {
				x4 = (int) ((560 - 20 + 1) * Math.random() + 20);
				w4 = (int) ((90 - 10 + 1) * Math.random() + 10);
				rock6 = new rockssss(x4, -150, w4, w4, new Color(0, 0, 255), 2);// blue
			}
			if (i == 5) {
				x5 = (int) ((560 - 20 + 1) * Math.random() + 20);
				w5 = (int) ((90 - 10 + 1) * Math.random() + 10);
				rock7 = new rockssss(x5, -86, w5, w5, new Color(0, 255, 255), 1);// bright blue
			}
			if (i == 6) {
				x6 = (int) ((560 - 20 + 1) * Math.random() + 20);
				w6 = (int) ((90 - 10 + 1) * Math.random() + 10);
				rock8 = new rockssss(x6, -26, w6, w6, new Color(250, 255, 0), 2);// yellow
			}
			if (i == 7) {
				x7 = (int) ((560 - 20 + 1) * Math.random() + 20);
				w7 = (int) ((90 - 10 + 1) * Math.random() + 10);
				rock9 = new rockssss(x7, -200, w7, w7, new Color(100, 205, 100), 1);// yellow
			}
			if (i == 8) {
				x8 = (int) ((560 - 20 + 1) * Math.random() + 20);
				w8 = (int) ((90 - 10 + 1) * Math.random() + 10);
				rock10 = new rockssss(x8, -180, w8, w8, new Color(255, 255, 255), 2);// yellow
			}
		}

		// these lines set the window's properties
		setTitle("game");// sets the title for the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 0, 640, 730);

		// the code below makes a Graphics object on which we can paint stuff
		// and associates this Graphics object with a label to be displayed
		// in our window.
		label = new JLabel();// a JLabel that covers the frame is used to display an image
		// a BufferedImage is a virtual image object, like a canvas
		bImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		g = bImage.getGraphics();// access the graphics object of the BufferedImage

		// a Timer object used to control the FPS for this animation
		myTimer = new Timer(34, new ActionListener() { // makes the ball go faster and slower
			public void actionPerformed(ActionEvent evt) {
				moveRocks();
				g.setColor(new Color(0, 0, 0));// background
				g.fillRect(0, 0, getWidth(), getHeight());// clear the frame

				Font f = new Font("Papyrus", Font.BOLD, 32);
				g.setFont(f);
				g.setColor(Color.green);
				g.drawString("Score: " + points, 40, 690);
				g.drawString("Health: " + health, 410, 690);
				points++;
				drawRocks();

				drawCar(g);
				iIcon = new ImageIcon(bImage);// makes an ImageIcon from BufferedImage
				label.setIcon(iIcon);// applies the image onto label that covers the frame
				add(label);// this adds the label with the image onto the frame
				setVisible(true);// makes the frame visible
				repaint();
				if (points == 3251) { // 3001
					gameOver = true;
					youWin();
				}
				if (health <= -1 && !gameOver) {
					System.out.println("in game over");
					gameOver = true;
					youLose();
				}
			}
		});
		myTimer.start();
		this.addKeyListener(new KeyAdapter() { // listens to key interaction
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (e.getKeyCode() == KeyEvent.VK_UP) { // if up key... call up method
					up();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // if down key... call down method
					down();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // if left key... call left method
					left();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // if right key... call right method
					right();
				}

			}
		});

		// we print out information about rocks
		// Java will automatically call the toString() method
		System.out.println("rock1 " + rock1);
		System.out.println("rock2 " + rock2);
		System.out.println("rock3 " + rock3);
		System.out.println("rock5 " + rock5);
		System.out.println("rock6 " + rock6);
		System.out.println("rock7 " + rock7);
		System.out.println("rock8 " + rock8);
		System.out.println("rock9 " + rock9);
		System.out.println("rock10 " + rock10);

		// apply the BufferedImage on the label
		iIcon = new ImageIcon(bImage);// makes an ImageIcon from BufferedImage
		label.setIcon(iIcon);// this applies the image onto the Jlabel object
		// that covers the frame
		this.add(label);// this adds the label with the image onto the frame
		setVisible(true);// makes the frame visible

	}

	public void moveRocks() {
		rock1.move(); // move the rocks
		rock2.move();
		rock3.move();
		rock5.move();
		rock6.move();
		rock7.move();
		rock8.move();
		rock9.move();

	}

	public void youWin() { // call youWin method
		myTimer.stop();
		setVisible(false);
		new youWin(); // calling youWin class
	}

	public void youLose() { // call youLose method
		myTimer.stop();
		setVisible(false);
		new youLose(); // calling youLose class
	}

	public void drawRocks() {
		rock1.draw(g); // draw the rocks
		rock2.draw(g);
		rock3.draw(g);
		rock5.draw(g);
		rock6.draw(g);
		rock7.draw(g);
		rock8.draw(g);
		rock9.draw(g);
		rock10.draw(g);

		// if boolean methods are true then these if statements will execute
		if (collisionCheck(rock1.getX(), rock1.getY(), rock1.getWidth(), rock1.getLength())) {
			g.drawString("COLLISION", 200, 60);
			health--;
		}
		if (collisionCheck(rock2.getX(), rock2.getY(), rock2.getWidth(), rock2.getLength())) {
			g.drawString("COLLISION", 200, 60);
			health--;
		}
		if (collisionCheck(rock3.getX(), rock3.getY(), rock3.getWidth(), rock3.getLength())) {
			g.drawString("COLLISION", 200, 60);
			health--;
		}
		if (collisionCheck(rock5.getX(), rock5.getY(), rock5.getWidth(), rock5.getLength())) {
			g.drawString("COLLISION", 200, 60);
			health--;
		}
		if (collisionCheck(rock6.getX(), rock6.getY(), rock6.getWidth(), rock6.getLength())) {
			g.drawString("COLLISION", 200, 60);
			health--;
		}
		if (collisionCheck(rock7.getX(), rock7.getY(), rock7.getWidth(), rock7.getLength())) {
			g.drawString("COLLISION", 200, 60);
			health--;
		}
		if (collisionCheck(rock8.getX(), rock8.getY(), rock8.getWidth(), rock8.getLength())) {
			g.drawString("COLLISION", 200, 60);
			health--;
		}
		if (collisionCheck(rock9.getX(), rock9.getY(), rock9.getWidth(), rock9.getLength())) {
			g.drawString("COLLISION", 200, 60);
			health--;
		}
		if (collisionCheck(rock10.getX(), rock10.getY(), rock10.getWidth(), rock10.getLength())) {
			g.drawString("COLLISION", 200, 60);
			health--;
		}
	}

	public void drawCar(Graphics g) { // draws the car

		Graphics2D g2D = (Graphics2D) g;
		g2D.fillRect(playerx, playery, 50, 50);
	}

	boolean collisionCheck(int other_x, int other_y, int other_width, int other_length) {
		return (playerx < other_x + other_width) && // return true if collision occurs
				(playery < other_y + other_length) && (playerx + 50 > other_x) && (playery + 50 > other_y);
	}

	public void up() { // move up
		playery = playery - 30;
		if (playery <= 18) {
			playery = 18;
		}
	}

	public void down() { // move down
		playery = playery + 30;
		if (playery >= 660) {
			playery = 660;
		}
	}

	public void left() { // move left
		playerx = playerx - 30;
		if (playerx <= 0) {
			playerx = 0;
		}
	}

	public void right() { // move right
		playerx = playerx + 30;
		if (playerx >= 575) {
			playerx = 575;
		}
	}

}