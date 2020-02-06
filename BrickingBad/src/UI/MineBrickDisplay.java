package UI;
import java.awt.Color;
import java.awt.Graphics2D;

public class MineBrickDisplay{
	
	public int xPos;
	public int yPos;
	public int l;
	public int h;
	
	public MineBrickDisplay(int xPos, int yPos, int l, int h) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.l = l;
		this.h = h;
	}
	
	

	public void draw(Graphics2D b) {
		
		b.setColor(Color.red);
		b.fillOval(xPos, yPos, l,h);
		b.drawOval(xPos, yPos, l,h);
		
		
	}
	
}
