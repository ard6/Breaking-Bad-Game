package UI;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Domain.GameController;

public class PowerupDisplay {
	GameEngine engine =new GameEngine(true);
	GameController game = new GameController(engine.getNumberSB(), engine.getNumberHMB(), engine.getNumberMB(),engine.getNumberWB());
	public static ArrayList<MagnetPowerupDisplay> magnetPowerups;
	public static ArrayList<ChemicalPowerupDisplay> chemicalPowerups;
	public static ArrayList<Integer> magnets=new ArrayList<Integer>();
	public static ArrayList<Integer> chemicals=new ArrayList<Integer>();
	
	public PowerupDisplay(){
		magnetPowerups= new ArrayList<MagnetPowerupDisplay>();
		chemicalPowerups= new ArrayList<ChemicalPowerupDisplay>();
		for(int i=0;i<game.powerupList().size();i++) {
			if(game.powerupList().get(i).getType().equals("magnet")) {
			MagnetPowerupDisplay magnet =new MagnetPowerupDisplay(game.powerupList().get(i).getXpos(),game.powerupList().get(i).getYpos(),0,0);
			magnetPowerups.add(magnet);
			magnets.add(i);
			
			}else {
				ChemicalPowerupDisplay chemical =new ChemicalPowerupDisplay(game.powerupList().get(i).getXpos(),game.powerupList().get(i).getYpos(),0,0);
				chemicalPowerups.add(chemical);	
				chemicals.add(i);
				
			}
		}

		

		
		
	}
	
	public void draw(Graphics2D b) {
		// TODO Auto-generated method stub
			MagnetPowerupDisplay temp;
			int j=0;
		for(int i=0;i<magnetPowerups.size();i++) {
			
			temp=magnetPowerups.get(i);
			temp.xPos=game.powerupList().get(magnets.get(j)).getXpos();
			temp.yPos=game.powerupList().get(magnets.get(j)).getYpos();
			temp.drawPowerup((Graphics2D) b);
			j++;
		}
		j=0;
		ChemicalPowerupDisplay temp2;
		for(int i=0;i<chemicalPowerups.size();i++) {
			
			temp2=chemicalPowerups.get(i);
			temp2.xPos=game.powerupList().get(chemicals.get(j)).getXpos();
			temp2.yPos=game.powerupList().get(chemicals.get(j)).getYpos();
			temp2.drawPowerup((Graphics2D) b);
			j++;
		}	
		
		
		
		}
}
