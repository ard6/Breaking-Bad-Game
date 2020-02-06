package UI;

import java.awt.Color;
import java.awt.Graphics2D;

import Domain.GameController;

public class ProtectingAlienDisplay {
	
	public int xPos=20;
	public int yPos=500;
	public int l;
	public int h;
	GameEngine engine =new GameEngine(true);
	GameController game = new GameController(engine.getNumberSB(), engine.getNumberHMB(), engine.getNumberMB(),engine.getNumberWB());
	
	public ProtectingAlienDisplay(int xPos, int yPos, int l, int h) {
	
		this.xPos = xPos;
		this.yPos = yPos;
		this.l = l;
		this.h = h;
	}
	
	public ProtectingAlienDisplay() {
		
	}
	
	public void drawA(Graphics2D a) {
		a.setColor(Color.GREEN);
		a.fillRect(xPos, yPos, l,h);
		a.drawRect(xPos, yPos, l,h);
		
	}
	

}
