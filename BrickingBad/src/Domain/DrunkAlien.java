package Domain;

public class DrunkAlien implements Alien {
	private int speed=1; 
	private int xPosition;
	private int yPosition;
	private int dir=1;
	private int length;
	private int width;
	private String type;
	private int status; 
	private boolean alienAppeared;

	private Playground playground=new Playground();
	
	public DrunkAlien(int xPos, int yPos, int length, int width) {
		this.xPosition=xPos;
		this.yPosition=yPos;
		this.length=length;
		this.width=width;
		this.setType("DrunkAlien");
		this.status=4;
		this.alienAppeared=false;
	}

	@Override
	public int getXpos() {
		// TODO Auto-generated method stub
		return xPosition;
	}

	@Override
	public int getYpos() {
		// TODO Auto-generated method stub
		return yPosition;
	}

	@Override
	public void setXpos(int X) {
		// TODO Auto-generated method stub
		this.xPosition=X;
	}

	@Override
	public void setYpos(int Y) {
		// TODO Auto-generated method stub
		this.yPosition=Y;
	}
//	public int getDir() {
//		return this.dir;
//	}
//	
//	public void setDir(int dir) {
//		this.dir=dir;
//	}
	
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return this.length;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type=type;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(status==0) {
			this.setYpos(this.getYpos()+(speed*this.getDir()));
			if(this.getYpos() < playground.getUpperbound() || this.getYpos() > 350)
			{
				this.setDir(this.getDir()*(-1));
			}
			
		}else if (status==1) {
			this.setYpos(this.getYpos()+(speed*this.getDir()));
			if(this.getYpos() < playground.getUpperbound() || this.getYpos() > 350)
			{
				this.setDir(this.getDir()*(-1));
			}
			
		}else if (status==2) {
			
			this.setYpos(350);
			this.setXpos(this.getXpos()+(speed*this.getDir()));
			if(this.getXpos() <= playground.getLeftbound() || this.getXpos() >= playground.getRightbound())
			{
				this.setDir(this.getDir()*(-1));
			}
		}else if (status==3) {
			this.setYpos(350);
			this.setXpos(this.getXpos()+(speed*this.getDir()));
			if(this.getXpos() < playground.getLeftbound() || this.getXpos() > playground.getRightbound())
			{
				this.setDir(this.getDir()*(-1));
			}
			
			
		}else if (status==4) {
			
		}else {
			System.out.println("Do nothing!");
		}
			
	}
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public void disappear() {
		// TODO Auto-generated method stub
	}

	@Override
	public void appear() {
		// TODO Auto-generated method stub
		this.setXpos(35);
		this.setYpos(350);
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}
	
	public void specialperform(int x, int y) {
		
		
		
		
	}

	@Override
	public void setDir(int dir) {
		// TODO Auto-generated method stub
		this.dir=dir;
	}

	@Override
	public int getDir() {
		// TODO Auto-generated method stub
		return this.dir;
	}

	@Override
	public boolean isAppeared() {
		// TODO Auto-generated method stub
		return this.alienAppeared;
	}

	@Override
	public void setAppeared(boolean appear) {
		// TODO Auto-generated method stub
		this.alienAppeared=appear;
	}



}
