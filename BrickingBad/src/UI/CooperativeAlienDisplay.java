package UI;

import java.awt.Color;
import java.awt.Graphics2D;

import Domain.GameController;

public class CooperativeAlienDisplay {

	
	public int xPos=20;
	public int yPos=20;
	public int l;
	public int h;
	GameEngine engine =new GameEngine(true);
	GameController game = new GameController(engine.getNumberSB(), engine.getNumberHMB(), engine.getNumberMB(),engine.getNumberWB());
	
	public CooperativeAlienDisplay(int xPos, int yPos, int l, int h) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.l = l;
		this.h = h;
	}
	
	public CooperativeAlienDisplay() {
		
	}
	
	public void drawA(Graphics2D a) {
		
		a.setColor(Color.PINK);
		a.fillRect(xPos, yPos, l,h);
		a.drawRect(xPos, yPos, l,h);
		
	}
}
