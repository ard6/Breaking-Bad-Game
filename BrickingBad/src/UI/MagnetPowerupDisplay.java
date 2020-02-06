package UI;

import java.awt.Color;
import java.awt.Graphics2D;

public class MagnetPowerupDisplay {
	public int xPos=-100;
	public int yPos=-100;
	public int xVel=0;
	public int yVel=0;
	

	
	public MagnetPowerupDisplay(int xPos, int yPos, int xVel, int yVel) {
		
	}
	
	public void drawPowerup(Graphics2D p) {
		
		
			p.setColor(Color.CYAN);
		
		
		p.fillOval(xPos,yPos,10, 10);
		p.drawOval(xPos,yPos,10, 10);
	}
}
