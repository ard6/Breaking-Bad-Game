package Domain;
/**
 * OVERVIEW: This a class that helps us to create Brick object with respect to their type.
 * @author Team Monopoly
 *
 */
public class BrickFactory {
	
	/**
	 * REQUIREMENTS: 0 is smaller than (xPos and yPos) are smaller than gameScreen.length or width. length && width must be greater than 0
	 * EFFECTS: A new brick is created with the input type and given features.
	 * 
	 * @param type - type of the brick to be created.
	 * @param xPos - x position of the brick.
	 * @param yPos - y position of the brick.
	 * @param length - length of the brick.
	 * @param width - width of the brick.
	 * @return a newly created Brick with input features.
	 */
	public static Brick createBrick(String type, int xPos, int yPos,int length, int width){
		
		Brick brick;
		
		if(type.equals("simple")){
			brick= new SimpleBrick(xPos,yPos,length,width);
			
		}else if (type.equals("mine-brick")){
			brick= new MineBrick(xPos,yPos,length,width);
		}else if (type.equals("half-metal-brick")){
			brick= new HalfMetalBrick(xPos,yPos,length,width);
		}else if (type.equals("wrapper-brick")){
			brick= new WrapperBrick(xPos,yPos,length,width);
		}else{
			return null;
		}
		return brick;
		
	}
}