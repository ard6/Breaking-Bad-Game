package UI;

import java.awt.Color;
import java.awt.Graphics;
import Domain.GameController;
public class PaddleDisplay{

	public GameController game;
	public int paddleLength;
	public int paddleWidth=8;
	public int paddleX=346;
	public int paddleY=530;
	public int rotateAngle=45;
	public int[] xPositions= {346,446,446,346};
	public int[] yPositions = {500,500,508,508};
	
	public String type="default";
	
	public PaddleDisplay() {

	}
	

	public void draw(Graphics p) {
		
		int[] xPoints=xPositions;
		int[] yPoints= yPositions;
		
		if(type.equals("magnet")) {
			p.setColor(Color.LIGHT_GRAY);
		}else {
			p.setColor(Color.ORANGE);
		}
		p.drawPolygon(xPoints, yPoints, 4);
		p.fillPolygon(xPoints, yPoints, 4);
		
	}
	
}
