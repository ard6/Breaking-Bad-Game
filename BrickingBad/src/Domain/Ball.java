package Domain;
/**OVERVIEW: This class is the original Ball object for the Bricking Bad Game, holds the data for creating the Ball and implementing its functions
 * 
 * @author Team Monopoly
 *
 */
public class Ball  {
	
	private int velocity;
	private int xDir;
	private int yDir;
	private int xPosition;
	private int yPosition;
	private int radii;
	private boolean isChemical;
	private boolean fireball;
	private Playground playground=new Playground();
	
	/**
	 * MODIFIES: This class.
	 * EFFECTS: Construct an instance of this class.
	 * 	
	 * @param velocity - velocity of the ball
	 * @param xDir - x direction of the ball
	 * @param yDir - y direction of the ball
	 * @param xPosition - x position of the ball
	 * @param yPosition - y position of the ball
	 * @param radii - radius of the ball
	 */
	public Ball(int velocity, int xDir, int yDir, int xPosition, int yPosition,int radii) {
		this.velocity = velocity;
		this.xDir = xDir;
		this.yDir = yDir;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.radii=radii;
		this.isChemical=false;
		this.fireball=false;
	}


/**
 * EFFECTS: returns the updated value with respect to ball velocity and balls xDir 
 * @return next x position for the ball
 */
	public int nextPosX() {
		
		return this.xPosition+this.velocity*xDir;
		}
	/**
	 * EFFECTS: returns the updated value with respect to ball velocity and balls yDir 
	 * @return next y position for the ball
	 */
	public int nextPosY() {
			
			return this.yPosition+this.velocity*yDir;
		}
	/**
	 * REQUIREMENTS: xDir!=0
	 * MODIFIES: changes x position of the ball and x direction of the ball if it hits borders. 
	 * EFFECTS: Ball's x position updated and ball rebounds if it hits borders. 
	 * @param xDir
	 */
	public void moveX(int xDir) {
		this.xPosition=this.xPosition+this.velocity*xDir;
		
		if(xPosition < playground.getLeftbound() || xPosition > playground.getRightbound())
		{
			this.setxDir(xDir*(-1));
		}
		
	}
	/**
	 * REQUIREMENTS: yDir!=0 
	 * MODIFIES: changes y position of the ball and y direction of the ball if it hits borders. 
	 * EFFECTS: Ball's y position updated and ball rebounds if it hits borders.
	 * @param yDir
	 */
	public void moveY(int yDir){
		this.yPosition=this.yPosition+this.velocity*yDir;
		if(yPosition <= playground.getUpperbound() )
		{
			this.setyDir(yDir*(-1));
		}

	}
	
	
	/**
	 * EFFECTS: Gets the velocity of this class.
	 * @return velocity of this class
	 */

	public int getVelocity() {
		return velocity;
	}

/**
 * MODIFIES: Velocity property of the Ball. 
 * EFFECTS: Changes Ball's velocity.
 * @param velocity
 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	/**
 	* EFFECTS: Gets the x direction of the Ball.
	 * @return xDir of this class
	 */
	public int getxDir() {
		return xDir;
	}

	/**
	* MODIFIES: Changes xDir property of the Ball. 
	* EFFECTS: Changes Ball's x direction.
	 * @param xDir
	 */
	public void setxDir(int xDir) {
		this.xDir = xDir;
	}
	
	/**
 	* EFFECTS: Gets the y direction of the Ball.
	 * @return yDir of this class
	 */
	public int getyDir() {
		return yDir;
	}


	/**
 	* EFFECTS: Gets the radius of the Ball.
	 * @return radii of this class
	 */
	public int getRadii() {
		return radii;
	}



	/**
	 * MODIFIES: Changes radii property of the Ball. 
	* EFFECTS: Changes Ball's radius. 
	 * @param radii
	 */
	public void setRadii(int radii) {
		this.radii = radii;
	}


	/**
	 * MODIFIES: Changes yDir property of the Ball. 
	* EFFECTS: Changes Ball's y direction. 
	 * @param yDir
	 */

	public void setyDir(int yDir) {
		this.yDir = yDir;
	}

	/**
	 * EFFECTS: Gets the x position of this class.
	 * @return xPosition of this class
	 */
	public int getxPosition() {
		return xPosition;
	}

	/**
	 * MODIFIES: Changes xPosition property of the Ball. 
	* EFFECTS: Changes Ball's x position. 
	 * @param xPosition
	 */
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * EFFECTS: Gets the y position of this class.
	 * @return yPosition of this class
	 */
	public int getyPosition() {
		return yPosition;
	}

	/**
	 * MODIFIES: Changes yPosition property of the Ball. 
	* EFFECTS: Changes Ball's y position. 
	 * @param yPosition
	 */
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}



	/**
	 * EFFECTS: Gets is chemical knowledge of this class.
	 * @return isChemical of this class
	 */
	public boolean isChemical() {
		return isChemical;
	}



	/**
	 * MODIFIES: Changes isChemical property of the Ball.  
	* EFFECTS: Changes Ball's isChemical boolean. 
	 * @param isChemical
	 */
	public void setChemical(boolean isChemical) {
		this.isChemical = isChemical;
	}
	
	
	
	public boolean isFireball() {
		return fireball;
	}


	public void setFireball(boolean fireball) {
		this.fireball = fireball;
	}


	//Representation Invariant
	public void repOk() {
		assert this.velocity>=0;
		assert this.xDir==1 || this.xDir==-1 || this.xDir==0;
		assert this.yDir==1 || this.yDir==-1 || this.yDir==0;
		assert this.xPosition<=this.playground.getRightbound() || xPosition>=this.playground.getLeftbound();
		assert this.yPosition>=this.playground.getUpperbound();
		assert this.radii==8;
		
	}


	@Override
	public String toString() {
		return "Ball [velocity=" + velocity + ", xDir=" + xDir + ", yDir=" + yDir + ", xPosition=" + xPosition
				+ ", yPosition=" + yPosition + ", radii=" + radii + "]";
	}
	
	
}
