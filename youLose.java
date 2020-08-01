import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class youLose extends rocks {
	youLose() {
		// new frame to let user know that they lost the game
		setSize(500, 500);
		setVisible(true);
		setTitle("You Lose");
		getContentPane().setBackground(Color.red);
		myTimer.stop();// stopping the timer... THIS IS REQUIRED

		// the rest is designs to make the frame look good.
		Font f = new Font("Papyrus", Font.BOLD, 108);
		g.setFont(f);
		g.setColor(Color.GRAY);

		g.drawString("You Lose", 30, 480);

		Graphics2D g2 = (Graphics2D) g;
		int[] color = new int[5];
		for (int i = 0; i < color.length; i++) {
			color[i] = (int) ((255 - 1 + 1) * Math.random() + 1);
		}

		g2.setColor(new Color(color[1]));
		g2.draw(new Ellipse2D.Double(160, 120, 200, 200));
		g2.fill(new Ellipse2D.Double(210, 155, 50, 50));
		g2.fill(new Ellipse2D.Double(280, 150, 30, 70));
		g2.fillRect(180, 105, 160, 40);
		g2.setColor(new Color(color[2]));
		g2.fill(new Arc2D.Double(210, 230, 100, 100, 0, 180, Arc2D.CHORD));

	}
}
