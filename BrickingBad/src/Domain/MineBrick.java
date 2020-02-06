package Domain;

import Domain.Brick;

public class MineBrick implements Brick {
	
	private int xPos;
	private int yPos;
	private int width;
	private int length;
		
	public MineBrick(int xPos, int yPos, int width, int length) {
	
		this.xPos = xPos;
		this.yPos = yPos;
		this.length=length;
		this.width=width;
		
	}
	
	
	@Override
	public int getXpos() {
		// TODO Auto-generated method stub
		return xPos;
	}
	@Override
	public int getYpos() {
		// TODO Auto-generated method stub
		return yPos;
	}

	public int getXRightSide() {
		return xPos+length;
	}
	
	public int getYBottomSide() {
		return yPos-width;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return length;
	}


	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}


	@Override
	public void setXpos(int X) {
		// TODO Auto-generated method stub
		this.xPos=X;
	}


	@Override
	public void setYpos(int Y) {
		// TODO Auto-generated method stub
		this.yPos=Y;
	}
	
}
