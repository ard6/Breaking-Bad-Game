package Domain;

import Domain.Brick;
/**
 * OVERVIEW: The Simple Brick class of the game Bricking Bad Game, holds the data for creating a brick.
 * @author Team Monopoly
 *
 */
public class SimpleBrick implements Brick {
	

	private int xPos;
	private int yPos;
	private int width;
	private int length;
	/**
	 * MODIFIES: This Class.
	 * EFFECTS: Create a new SimpleBrick with respected inputs.
	 * @param xPos - x position of the brick.
	 * @param yPos - y position of the brick.
	 * @param width - width of the brick.
	 * @param length - length of the brick.
	 */
	public SimpleBrick(int xPos, int yPos, int width, int length) {
	
		this.xPos = xPos;
		this.yPos = yPos;
		this.length=length;
		this.width=width;
		
	}
	
	/**
 	* EFFECTS: Gets the x position of the Ball.
	 * @return xPos of this class
	 */
	@Override
	public int getXpos() {
		// TODO Auto-generated method stub
		return xPos;
	}
	/**
 	* EFFECTS: Gets the y position of the Brick.
	 * @return yPos of this class
	 */
	@Override
	public int getYpos() {
		// TODO Auto-generated method stub
		return yPos;
	}
	/**
 	* EFFECTS: Gets the right side of the Brick.
	 * @return xPos+length
	 */

	public int getXRightSide() {
		return xPos+length;
	}
	/**
 	* EFFECTS: Gets the bottom side of the Brick.
	 * @return yPos-width
	 */
	public int getYBottomSide() {
		return yPos-width;
	}
	/**
 	* EFFECTS: Gets the length of the Brick.
	 * @return length of this class
	 */
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return length;
	}

	/**
 	* EFFECTS: Gets the width of the Brick.
	 * @return width of this class
	 */
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	/**
	* MODIFIES: Changes xPos property of the Brick. 
	* EFFECTS: Changes Brick's x position.
	 * @param X
	 */
	@Override
	public void setXpos(int X) {
		// TODO Auto-generated method stub
		this.xPos=X;
	}

	/**
	* MODIFIES: Changes yPos property of the Brick. 
	* EFFECTS: Changes Brick's y position.
	 * @param Y
	 */
	@Override
	public void setYpos(int Y) {
		// TODO Auto-generated method stub
		this.yPos=Y;
	}
	//Representation Invariant
	public void repOk() {
		assert this.length==80;
		assert this.width==40;
		assert this.xPos<=605 || xPos>=5;
		assert this.yPos<=305 || yPos>=5;
	}
	//Abstraction Function
	//represents Simple Brick.
	@Override
	public String toString() {
		return "SimpleBrick [xPos=" + xPos + ", yPos=" + yPos + ", width=" + width + ", length=" + length + "]";
	}
	
	
}
