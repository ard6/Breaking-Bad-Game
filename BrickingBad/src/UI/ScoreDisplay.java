package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class ScoreDisplay {
	
	public int score;
	
	public ScoreDisplay(){
		
	}
	
	public void draw(Graphics2D p) {
		
		    String gameScore = Integer.toString(this.score);
		
			p.setColor(Color.white);
			p.setFont(new Font("Monaco", Font.PLAIN, 12));
			p.drawString("Score: " + gameScore , 630, 540);	

		
	}
}