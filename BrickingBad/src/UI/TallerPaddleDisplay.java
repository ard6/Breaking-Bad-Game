package UI;

import java.awt.Color;
import java.awt.Graphics;

import Domain.GameController;

public class TallerPaddleDisplay {
	public GameController game;
	public int paddleLength;
	public int paddleWidth=8;
	public int paddleX=296;
	public int paddleY=530;
	public int rotateAngle=45;
	public int[] xPositions= {296,496,496,296};
	public int[] yPositions = {500,500,508,508};
	
	public String type="taller";
	
	public TallerPaddleDisplay() {

	}
	

	public void draw(Graphics p) {
		
		int[] xPoints=xPositions;
		int[] yPoints= yPositions;
		
		if(type.equals("taller")) {
			p.setColor(Color.RED);
		}else {
			p.setColor(Color.ORANGE);
		}
		p.drawPolygon(xPoints, yPoints, 4);
		p.fillPolygon(xPoints, yPoints, 4);
		
	}

}
