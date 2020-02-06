package UI;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Domain.GameController;

public class BrickDisplay {

	public int radii=20;
	public int x,y,l,h;
	GameEngine engine =new GameEngine(true);
	GameController game = new GameController(engine.getNumberSB(), engine.getNumberHMB(), engine.getNumberMB(),engine.getNumberWB());
	public static ArrayList<SimpleBrickDisplay> bricks;
	public static ArrayList<HalfMetalBrickDisplay> metalbricks;
	public static ArrayList<MineBrickDisplay> minebricks;
	public static ArrayList<WrapperBrickDisplay> wrapperbricks;
	public BrickDisplay(){
		bricks = new ArrayList<SimpleBrickDisplay>();
		metalbricks = new ArrayList<HalfMetalBrickDisplay>();
		minebricks = new ArrayList<MineBrickDisplay>();
		wrapperbricks= new ArrayList<WrapperBrickDisplay>();
		for(int i=0;i<game.getBrickList().size();i++) {
			SimpleBrickDisplay brick3 =new SimpleBrickDisplay(game.getBrickList().get(i).getXpos(),game.getBrickList().get(i).getYpos(),80,40);
			bricks.add(brick3);
		}
		
		for(int i=0;i<game.metalBrickList().size();i++) {
			HalfMetalBrickDisplay brick4 =new HalfMetalBrickDisplay(game.metalBrickList().get(i).getXpos(),game.metalBrickList().get(i).getYpos(),80,40);
			metalbricks.add(brick4);
		}
		for(int i=0;i<game.mineBrickList().size();i++) {
			MineBrickDisplay brick5 =new MineBrickDisplay(game.mineBrickList().get(i).getXpos(),game.mineBrickList().get(i).getYpos(),40,40);
			minebricks.add(brick5);
		}
		for(int i=0;i<game.wrapperBrickList().size();i++) {
			WrapperBrickDisplay brick5 =new WrapperBrickDisplay(game.wrapperBrickList().get(i).getXpos(),game.wrapperBrickList().get(i).getYpos(),80,40);
			wrapperbricks.add(brick5);
		}
		
		
	}
	
	public void draw(Graphics2D b) {
		// TODO Auto-generated method stub

		for(int i=0;i<game.getBrickList().size();i++) {
			SimpleBrickDisplay temp=bricks.get(i);
			temp.xPos=game.getBrickList().get(i).getXpos();
			temp.yPos=game.getBrickList().get(i).getYpos();
			temp.draw((Graphics2D) b);
		}
		for(int i=0;i<game.metalBrickList().size();i++) {
			HalfMetalBrickDisplay temp=metalbricks.get(i);
			temp.xPos=game.metalBrickList().get(i).getXpos();
			temp.yPos=game.metalBrickList().get(i).getYpos();
			temp.draw((Graphics2D) b);
		}
		for(int i=0;i<game.mineBrickList().size();i++) {
			MineBrickDisplay temp=minebricks.get(i);
			temp.xPos=game.mineBrickList().get(i).getXpos();
			temp.yPos=game.mineBrickList().get(i).getYpos();
			temp.draw((Graphics2D) b);
		}
		for(int i=0;i<game.wrapperBrickList().size();i++) {
			WrapperBrickDisplay temp=wrapperbricks.get(i);
			temp.xPos=game.wrapperBrickList().get(i).getXpos();
			temp.yPos=game.wrapperBrickList().get(i).getYpos();
			temp.draw((Graphics2D) b);
		}
		
		
	}
	
}
