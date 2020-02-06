package UI;

import java.awt.Color;
import java.awt.Graphics2D;

public class ChemicalPowerupDisplay {
	public int xPos=-100;
	public int yPos=-100;
	public int xVel=0;
	public int yVel=0;
	

	
	public ChemicalPowerupDisplay(int xPos, int yPos, int xVel, int yVel) {
		
	}
	
	public void drawPowerup(Graphics2D p) {
		
		
			p.setColor(Color.YELLOW);
		
		
		p.fillOval(xPos,yPos,10, 10);
		p.drawOval(xPos,yPos,10, 10);
	}
}
