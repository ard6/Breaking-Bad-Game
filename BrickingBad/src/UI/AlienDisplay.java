package UI;

import java.awt.Graphics2D;

import Domain.GameController;

public class AlienDisplay {
	
	public int radii=10;
	public int y,l,h;
	public int x=2;
	public int xPos;
	public int yPos;
	GameEngine engine =new GameEngine(true);
	GameController game = new GameController(engine.getNumberSB(), engine.getNumberHMB(), engine.getNumberMB(),engine.getNumberWB());
	DrunkAlienDisplay da;
	CooperativeAlienDisplay ca;
	RepairingAlienDisplay ra;
	ProtectingAlienDisplay pa;
	
	public AlienDisplay(){
		if(game.gameAlien().getType()=="DrunkAlien") {
			
			da=new DrunkAlienDisplay(70,50,40,15);
		}else if(game.gameAlien().getType()=="CooperativeAlien") {

			ca=new CooperativeAlienDisplay(70,50,40,15);
		}else if(game.gameAlien().getType()=="RepairingAlien") {
		
			ra=new RepairingAlienDisplay(70,50,40,15);
		}else if(game.gameAlien().getType()=="ProtectingAlien") {
			pa= new ProtectingAlienDisplay(x,350,40,15);
		}
	}
	
	public void drawA(Graphics2D a) {
		
	if(game.gameAlien().getType()=="DrunkAlien") {
		
		da.xPos=this.xPos;
		da.yPos=this.yPos;
		da.drawA((Graphics2D) a);
	}else if(game.gameAlien().getType()=="CooperativeAlien") {
		ca.xPos=this.xPos;
		ca.yPos=this.yPos;	
		ca.drawA((Graphics2D) a);
	}else if(game.gameAlien().getType()=="RepairingAlien") {
		ra.xPos=this.xPos;
		ra.yPos=this.yPos;
		
		ra.drawA((Graphics2D) a);
	}else if(game.gameAlien().getType()=="ProtectingAlien") {
		
		pa.xPos=this.xPos;
		pa.yPos=this.yPos;

		pa.drawA((Graphics2D)a);
	}

		
	}

}

