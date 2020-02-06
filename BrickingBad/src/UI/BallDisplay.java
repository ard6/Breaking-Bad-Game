package UI;

import java.awt.Color;
import java.awt.Graphics2D;

public class BallDisplay {
	public int xPos=396;
	public int yPos=491;
	public int xVel=0;
	public int yVel=0;
	public String type="default";

	
	public BallDisplay() {
		
	}
	
	public void drawBall(Graphics2D p) {
		
		if(type.equals("chemical")) {
			p.setColor(Color.GREEN);
		}else {
			p.setColor(Color.magenta);
		}
		
		p.fillOval(xPos,yPos,8, 8);
		p.drawOval(xPos,yPos,8, 8);
		
	}


	
}
