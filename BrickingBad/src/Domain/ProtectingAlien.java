package Domain;

public class ProtectingAlien implements Alien {
	
	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStatus(int status) {
		// TODO Auto-generated method stub
		
	}

	private int speed=1; //3*(PaddleLength)/second= 3*100/60
	private int xPosition;
	private int yPosition;
	private int dir=1;
	private int length;
	private int width;
	private String type;
	
	private Playground playground=new Playground();
	
	
	public ProtectingAlien(int xPos, int yPos, int length, int width) {
		this.xPosition=xPos;
		this.yPosition=yPos;
		this.length=length;
		this.width=width;
		this.setType("ProtectingAlien");
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

	public int getDir() {
		return this.dir;
	}
	
	public void setDir(int dir) {
		this.dir=dir;
	}
	
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
		//System.out.println("hareket ediyor x:"+this.getXpos()+" y:"+this.getYpos());
		this.setXpos(this.getXpos()+(speed*this.getDir()));
		if(this.getXpos() < playground.getLeftbound() || this.getXpos() > playground.getRightbound())
		{
			this.setDir(this.getDir()*(-1));
		}
		
	}

	@Override
	public void disappear() {
		// TODO Auto-generated method stub
	}

	@Override
	public void appear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAppeared() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAppeared(boolean appear) {
		// TODO Auto-generated method stub
		
	}



	


}
