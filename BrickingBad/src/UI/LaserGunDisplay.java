package UI;

import java.awt.Color;
import java.awt.Graphics2D;

public class LaserGunDisplay {
	
	public int xPos=346;
	public int yPos=-491;
	
	LaserGunDisplay(){
		
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(xPos, yPos, 4, 10);
		g.drawOval(xPos, yPos, 4, 10);
	}
}
