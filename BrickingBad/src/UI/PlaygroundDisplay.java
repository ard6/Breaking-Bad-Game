package UI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlaygroundDisplay {
	
	ImageIcon monopoly = new ImageIcon("monopolyUncle.png");

	public PlaygroundDisplay(){
		
	}
	
	public void drawPlayground(Graphics2D g) {
		
		g.setColor(Color.black);
		
		g.fillRect(1, 1, 692, 592);
		
		
	}
	
	public void drawBorders(Graphics2D g){
			g.setColor(Color.yellow);
			g.fillRect(0, 0, 3, 592);
			g.fillRect(0, 0, 692, 3);
			g.fillRect(691, 0, 3, 592);
	}

}
