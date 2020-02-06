package Domain;

import java.util.Arrays;

/**
 * OVERVIEW: The one and only Paddle object of the Bricking Bad Game, holds the data for creating Paddle and implementing its functions.
 * @author Team Monopoly
 *
 */
public class Paddle {
	
	private int velocity;
	private int length;
	private int width;
	private int direction=0;
	private int[] xPositions;
	private int[] yPositions;
	private int[] copyx;
	private int[] copyy;
	//private int[] tallercopyx={this.getxPositions()[0]-50, this.getxPositions()[1]+50, this.getxPositions()[2]+50, this.getxPositions()[3]-50};;

	private int xposition=346;
	private int yposition=530;
	private int rotationAngle;
	private boolean isMagnet;
	private boolean isTaller;
	private boolean activeLaserGun;
	private boolean isLaunched;
	private int status=0;
	
	/**
	 *  MODIFIES: This class.
	 * EFFECTS: Construct an instance of this class.
	 * 	
	 * @param velocity - velocity of Paddle
	 * @param length - length of Paddle
	 * @param width - width of Paddle
	 * @param direction - direction of Paddle
	 * @param xPositions - x positions of Paddle
	 * @param yPositions - y positions of Paddle
	 * @param xposition - x position of Paddle
	 * @param yposition - y position of Paddle
	 * @param rotationAngle - rotation angle of Paddle
	 */
	public Paddle(int velocity, int length, int width, int direction,int[]xPositions,int[]yPositions, int xposition, int yposition,
			int rotationAngle) {
		this.velocity = velocity;
		this.length = length;
		this.direction = direction;
		this.xposition = xposition;
		this.yposition = yposition;
		this.rotationAngle = rotationAngle;
		this.xPositions=xPositions;
		this.yPositions=yPositions;
		this.copyx=xPositions;
		this.copyy=yPositions;
		this.isTaller=false;
		this.isMagnet=false;

	}
	/**
	 * REQUIREMENTS: angleSelection=1 || angleSelection=-1
	 * MODIFIES: angleSelection property of this class
	 * EFFECTS: angle of the paddle changed due to input angleSelection.
	 * @param angleSelection
	 */
	public void rotate(int angleSelection) {
	
		if(angleSelection==1&& status==0) {
			int[] xPos={
					(int) (((xPositions[0]-xPositions[1]-yPositions[0]+yPositions[3])/(2*(Math.sqrt(2))))+((xPositions[0]+xPositions[1])/2)),
					(int) (((xPositions[1]-xPositions[0]-(2*yPositions[1])+yPositions[0]+yPositions[3])/(2*(Math.sqrt(2))))+((xPositions[0]+xPositions[1])/2)),
					(int)(((xPositions[2]-xPositions[3]-yPositions[2]+yPositions[1])/(2*(Math.sqrt(2))))+((xPositions[2]+xPositions[3])/2)),
					(int)(((xPositions[3]-xPositions[2]-yPositions[3]+yPositions[0])/(2*(Math.sqrt(2))))+((xPositions[2]+xPositions[3])/2))};
			int[] yPos= {
					(int) (((xPositions[0]-xPositions[1]+yPositions[0]-yPositions[3])/(2*(Math.sqrt(2))))+((yPositions[0]+yPositions[3])/2)),
					(int)(((xPositions[1]-xPositions[0]+(2*yPositions[1])-yPositions[0]-yPositions[3])/(2*(Math.sqrt(2))))+((yPositions[0]+yPositions[3])/2)),
					(int)(((xPositions[2]-xPositions[3]+yPositions[2]-yPositions[1])/(2*(Math.sqrt(2))))+((yPositions[0]+yPositions[3])/2)),
					(int)(((xPositions[3]-xPositions[2]+yPositions[3]-yPositions[0])/(2*(Math.sqrt(2))))+((yPositions[0]+yPositions[3])/2)) };
			this.setxPositions(xPos);
			this.setyPositions(yPos);
			status=1;
		}
		if(angleSelection==-1&& status==0) {
			int[] xPos={
					(int) (((xPositions[0]-xPositions[1]+yPositions[0]-yPositions[3])/(2*(Math.sqrt(2))))+((xPositions[0]+xPositions[1])/2)),
					(int)(((xPositions[1]-xPositions[0]+(2*yPositions[1])-yPositions[0]-yPositions[3])/(2*(Math.sqrt(2))))+((xPositions[0]+xPositions[1])/2)),
					(int)(((xPositions[2]-xPositions[3]+yPositions[2]-yPositions[1])/(2*(Math.sqrt(2))))+((xPositions[0]+xPositions[1])/2)),
					(int)(((xPositions[3]-xPositions[2]+yPositions[3]-yPositions[0])/(2*(Math.sqrt(2))))+((xPositions[0]+xPositions[1])/2)) };
			int[] yPos= {
					(int) ( (-1)*((xPositions[0]-xPositions[1]-yPositions[0]+yPositions[3])/(2*(Math.sqrt(2))))+((yPositions[0]+yPositions[3])/2)),
					(int) ((-1)*((xPositions[1]-xPositions[0]-(2*yPositions[1])+yPositions[0]+yPositions[3])/(2*(Math.sqrt(2))))+((yPositions[0]+yPositions[3])/2)),
					(int)((-1)*((xPositions[2]-xPositions[3]-yPositions[2]+yPositions[1])/(2*(Math.sqrt(2))))+((yPositions[0]+yPositions[3])/2)),
					(int)((-1)*((xPositions[3]-xPositions[2]-yPositions[3]+yPositions[0])/(2*(Math.sqrt(2))))+((yPositions[0]+yPositions[3])/2))};
			this.setxPositions(xPos);
			this.setyPositions(yPos);
			status=-1;
		}
		
		
		
		if(angleSelection==1&& status==-1) {
			int[] xPos=copyx;
			int[] yPos= copyy;
			this.setxPositions(xPos);
			this.setyPositions(yPos);
			this.setCopyx(xPositions);
			status=0;
		
			
			
		}
		if(angleSelection==-1&& status==1) {
			int[] xPos=copyx;
			int[] yPos=copyy;
			this.setxPositions(xPos);
			this.setyPositions(yPos);
			this.setCopyx(xPositions);
			status=0;
			
			
		}
		
		
		
	}
	/**
	 * REQUIREMENTS: dir && speed != 0	
	 * MODIFIES: xPositions and yPositions of this class with respect to inputs.
	 * EFFECTS: moves paddle to given direction with the given speed.
	 * @param dir
	 * @param speed
	 */
	public void move(int dir, int speed) {
		
		if(dir==1)/* right direction*/ {
			if(this.status==0){
				if(this.xPositions[1]>=692-speed&&this.xPositions[2]>=692-speed) {
					this.xPositions[0]=692-this.length;
					this.xPositions[1]=692;
					this.xPositions[2]=692;
					this.xPositions[3]=692- this.length;
				}
				else{
					for(int i=0;i<this.xPositions.length;i++) {
						this.xPositions[i]=this.xPositions[i]+speed;
					}
				}
			}else if(this.status==1) {
				int xDif=this.xPositions[1]-xPositions[0];
				int yDif=this.yPositions[2]-yPositions[1];
				if(this.xPositions[1]>=692-speed) {
					this.xPositions[0]=692-xDif;
					this.xPositions[1]=692;
					this.xPositions[2]= 692-yDif;
					this.xPositions[3]=692-xDif-yDif;
				}else{
					for(int i=0;i<this.xPositions.length;i++) {
						this.xPositions[i]=this.xPositions[i]+speed;
					}
				}
			}else{
				int xDif=this.xPositions[1]-xPositions[0];
				int yDif=this.yPositions[2]-yPositions[1];
				if(this.xPositions[2]>=692-speed) {
					this.xPositions[0]=692-xDif-yDif;
					this.xPositions[1]=692-yDif;
					this.xPositions[2]= 692;
					this.xPositions[3]=692-xDif;
				}else{
					for(int i=0;i<this.xPositions.length;i++) {
						this.xPositions[i]=this.xPositions[i]+speed;
					}
				}
			}
			
			int[] temp={xPositions[0],xPositions[0]+length,xPositions[0]+length,xPositions[0]};
			this.setCopyx(temp);
		}
			
		if(dir==-1)/*left direction*/{
			if(this.status==0){
				if(this.xPositions[0]<=0+speed&&this.xPositions[3]<=0+speed) {
					this.xPositions[0]=0;
					this.xPositions[1]=0+this.length;
					this.xPositions[2]=0+this.length;
					this.xPositions[3]=0;
					
				}
				else{
					for(int i=0;i<this.xPositions.length;i++) {
						this.xPositions[i]=this.xPositions[i]-speed;
					}
				}
			}else if(this.status==1) {
				int xDif=this.xPositions[1]-xPositions[0];
				int yDif=this.yPositions[2]-yPositions[1];
				if(this.xPositions[3]<=0+speed) {
					this.xPositions[0]=0+yDif;
					this.xPositions[1]=0+xDif+yDif;
					this.xPositions[2]= 0+xDif;
					this.xPositions[3]=0;
				}else{
					for(int i=0;i<this.xPositions.length;i++) {
						this.xPositions[i]=this.xPositions[i]-speed;
					}
				}
			}else{
				int xDif=this.xPositions[1]-xPositions[0];
				int yDif=this.yPositions[2]-yPositions[1];
				if(this.xPositions[0]<=0+speed) {
					this.xPositions[0]=0;
					this.xPositions[1]=0+xDif;
					this.xPositions[2]= 0+xDif+yDif;
					this.xPositions[3]=0+yDif;
				}else{
					for(int i=0;i<this.xPositions.length;i++) {
						this.xPositions[i]=this.xPositions[i]-speed;
					}
				}
			}
		}
		int[] temp={xPositions[0],xPositions[0]+length,xPositions[0]+length,xPositions[0]};
		this.setCopyx(temp);

	}
	
	
	/**
	 * EFFECTS: Gets the copyx of this class.
	 * @return copyx(the temporary holder for xPositions for this class).
	 */
	public int[] getCopyx() {
		return copyx;
	}
	/**
	 * MODIFIES: copyx property of the Paddle. 
	 * EFFECTS: Changes Paddle's temporary holder for xPositions(copyx).
	 * @param copyx
	 */
	public void setCopyx(int[] copyX) {
		for(int i =0; i<copyX.length;i++)
			copyx[i]=copyX[i];
		
	}
	/**
	 * EFFECTS: Gets the copyy of this class.
	 * @return copyy(the temporary holder for yPositions for this class).
	 */
	public int[] getCopyy() {
		return copyy;
	}
	/**
	 * MODIFIES: copyy property of the Paddle. 
	 * EFFECTS: Changes Paddle's temporary holder for yPositions(copyy).
	 * @param copyy
	 */
	public void setCopyy(int[] copyY) {
		for(int i =0; i<copyY.length;i++)
		copyy[i]=copyY[i];
		//this.copyy = copyy;
	}
	/**
	 * EFFECTS: Gets the x positions of this class.
	 * @return xPositions of this class.
	 */
	public int[] getxPositions() {
		return this.xPositions;
	}
	/**
	 *  MODIFIES: xPositions property of the Paddle. 
	 * EFFECTS: Changes Paddle's xPositions.
	 * @param xPositions
	 */
	public void setxPositions(int[] xPositions) {
		this.xPositions = xPositions;
	}
	/**
	 * EFFECTS: Gets the y positions of this class.
	 * @return yPositions of this class.
	 */
	public int[] getyPositions() {
		return this.yPositions;
	}
	/**
	 *  MODIFIES: yPositions property of the Paddle. 
	 * EFFECTS: Changes Paddle's yPositions.
	 * @param xPositions
	 */
	public void setyPositions(int[] yPositions) {
		this.yPositions = yPositions;
	}
	/**
	 * EFFECTS: Gets the velocity of this class.
	 * @return velocity of this class.
	 */
	public int getVelocity() {
		return velocity;
	}
	/**
	 * MODIFIES: velocity property of the Paddle. 
	 * EFFECTS: Changes Paddle's velocity.
	 * @param velocity
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	/**
	 * EFFECTS: Gets the length of this class.
	 * @return length of this class.
	 */
	public int getLength() {
		return length;
	}
	/**
	 * MODIFIES: length property of the Paddle. 
	 * EFFECTS: Changes Paddle's length.
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * EFFECTS: Gets the width of this class.
	 * @return width of this class.
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * MODIFIES: velocity property of the Paddle. 
	 * EFFECTS: Changes Paddle's velocity.
	 * @param velocity
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * EFFECTS: Gets the direction of this class.
	 * @return direction of this class.
	 */
	public int getDirection() {
		return direction;
	}
	/**
	 * MODIFIES: direction property of the Paddle. 
	 * EFFECTS: Changes Paddle's direction.
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
	/**
	 * EFFECTS: Gets the x position of this class.
	 * @return xposition of this class.
	 */
	public int getXPosition() {
		return xposition;
	}
	/**
	 * MODIFIES: xposition property of the Paddle. 
	 * EFFECTS: Changes Paddle's x position.
	 * @param position
	 */
	public void setXPosition(int position) {
		this.xposition = position;
	}
	/**
	 * EFFECTS: Gets the y position of this class.
	 * @return yposition of this class.
	 */
	public int getYPosition() {
		return yposition;
	}
	/**
	 * MODIFIES: yposition property of the Paddle. 
	 * EFFECTS: Changes Paddle's y position.
	 * @param position
	 */
	public void setYPosition(int position) {
		this.yposition = position;
	}
	/**
	 * EFFECTS: Gets the rotation angle of this class.
	 * @return rotationAngle of this class.
	 */
	public int getRotationAngle() {
		return rotationAngle;
	}
	/**
	 * MODIFIES: rotationAngle property of the Paddle. 
	 * EFFECTS: Changes Paddle's rotation angle.
	 * @param rotationAngle
	 */
	public void setRotationAngle(int rotationAngle) {
		this.rotationAngle = rotationAngle;
	}
	/**
	 * EFFECTS: Gets the if the magnet is active knowledge of this class.
	 * @return isMagnet boolean of this class.
	 */
	public boolean isMagnet() {
		return isMagnet;
	}
	/**
	 * MODIFIES: isMagnet property of the Paddle. 
	 * EFFECTS: Changes Paddle's knowledge about being at magnet state or not.
	 * @param isMagnet
	 */
	public void setMagnet(boolean isMagnet) {
		this.isMagnet = isMagnet;
	}
	/**
	 * EFFECTS: Gets the if laser gun is active knowledge of this class.
	 * @return isActiveLaserGun boolean of this class.
	 */
	public boolean isActiveLaserGun() {
		return activeLaserGun;
	}
	/**
	 * MODIFIES: activeLaserGun property of the Paddle. 
	 * EFFECTS: Changes Paddle's knowledge about being at laser gun state or not.
	 * @param activeLaserGun
	 */
	public void setActiveLaserGun(boolean activeLaserGun) {
		this.activeLaserGun = activeLaserGun;
	}

	/**
	 * EFFECTS: Gets the if the ball is launched from paddle knowledge of this class.
	 * @return isLaunched boolean of this class.
	 */

	public boolean isLaunched() {
		return isLaunched;
	}
	
	/**
	 * MODIFIES: isLaunched property of the Paddle. 
	 * EFFECTS: Changes Paddle's knowledge about holding the ball.
	 * @param isLaunched
	 */
	
	
	public void setLaunched(boolean isLaunched) {
		this.isLaunched = isLaunched;
	}
	/**
	 * EFFECTS: Gets the status this class.
	 * @return status of this class.
	 */
	public int getStatus() {
		// TODO Auto-generated method stub
		return status;
	}
	/**
	 * MODIFIES: status property of the Paddle. 
	 * EFFECTS: Changes Paddle's status.
	 * @param n
	 */
	public void setStatus(int n) {
		this.status=n;
	}
	
	
	public boolean isTaller() {
		return isTaller;
	}
	public void setTaller(boolean isTaller) {
		this.isTaller = isTaller;
	}
	//Representation Invariant for Paddle Class
	
	
	public void repOk() {
		assert this.length==100;
		assert this.rotationAngle>=0 || this.rotationAngle<=135;
		assert this.status==-1 || this.status==0 || this.status==1;
	}
	
	//Abstract Function: represents the Paddle class
	@Override
	public String toString() {
		return "Paddle [velocity=" + velocity + ", length=" + length + ", width=" + width + ", direction=" + direction
				+ ", xPositions=" + Arrays.toString(xPositions) + ", yPositions=" + Arrays.toString(yPositions)
				+ ", status=" + status + "]";
	}
	
}
