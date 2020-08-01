
/*The Rock class // bubble class*/
import java.awt.*;
import java.awt.geom.Ellipse2D;

class rockssss {
	// Instance Variables
	private int x, y;
	private double diameter;
	private Color color;
	private int speedY;
	private int length;
	private int width;
	private int playerx;
	private int playery;
	private int height;

	rockssss(int x, int y, int width, int length, Color color, int speedY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
		this.color = color;
		this.speedY = speedY;
	}

	rockssss(int x, int y, double diameter, Color color) {
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.color = color;
	}

	rockssss() {
		x = 50;
		y = 50;
		diameter = 94;

		speedY = 2;
	}

	rockssss(int x, int y, int d, int d2) {
		this.x = x;
		this.y = y;
		this.diameter = d;
		this.diameter = d;
	}

	// Setters
	public void setX(int newX) {
		x = newX;
	}

	public void setY(int newY) {
		y = newY;
	}

	public void setDiameter(int newDiameter) {
		diameter = newDiameter;
	}

	public void setWidth(int w) {
		width = w;
	}

	public void setLength(int l) {
		length = l;
	}

	public void setColor(Color newColor) {
		color = newColor;
	}

	public void setPlayerx(int pX) {
		playerx = pX;
	}

	public void setPlayery(int pY) {
		playery = pY;
	}

	// Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getDiameter() {
		return diameter;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public Color getColor() {
		return color;
	}

	public int playerx() {
		return playerx;
	}

	public int playery() {
		return playery();
	}

	public void move() { // moving the rocks
		y += speedY;
		x += 1;
		if (y > 775) { // if it moves out the screen. bring it back
			y = -80;
			x = (int) ((580 - 40 + 1) * Math.random() + 40);
			speedY++;
		}
		if (x > 580) { // if it moves out the screen. bring it back
			x = -80;
		}
	}

	public void draw(Graphics g) {
		// we use the Graphics object g to paint stuff on it
		Graphics2D g2D = (Graphics2D) g;
		// g2D.setStroke (new BasicStroke(5));
		g2D.setPaint(color);
		g2D.fillRect(x, y, (int) width, (int) length);

	}

	public void drawCar(Graphics g) { // drawing car
		Rectangle car = new Rectangle(playerx, playery, 50, 50);
	}

	public String toString() { // method printed details of each rock
		return "Circle:(" + x + "," + y + "),length " + length + ", width " + width + ", and color: " + color + ".";
	}

}
