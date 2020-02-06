package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class LivesDisplay {
	
	public int amount=0;

	public LivesDisplay() {
		
	}
	
	public void draw(Graphics2D p) {
		
		if(amount>0) {
			for(int i=0; i<amount; i++) {
				p.setColor(Color.red);
				p.fillOval(630+i*16,520,8, 8);
				p.drawOval(630+i*16,520,8, 8);
			}
		}else {
			p.setColor(Color.RED);
			p.setFont(new Font("Monaco", Font.PLAIN, 40));
			p.drawString("Game Over", 240, 240);	

		}


		
	}
}
