package UI;
import java.awt.Color;
import java.awt.Graphics2D;

public class SimpleBrickDisplay{
	
	public int xPos;
	public int yPos;
	public int l;
	public int h;
	
	public SimpleBrickDisplay(int xPos, int yPos, int l, int h) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.l = l;
		this.h = h;
	}
	
	public SimpleBrickDisplay() {
		
	}

	public void draw(Graphics2D b) {
		
		b.setColor(Color.BLUE);
		b.fillRect(xPos, yPos, l,h);
		b.drawRect(xPos, yPos, l,h);
		
	}
	
}
