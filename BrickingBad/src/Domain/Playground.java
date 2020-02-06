package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Playground {
	
	private  int width = 692;
	private  int length = 592;
	private  int upperbound = 0;
	private  int lowerbound = 592;
	private  int leftbound = 0;
	private  int rightbound = 692;
	private Random rand;
	private BrickPositions brickPos;
	
	private static ArrayList<BrickPositions> bricks;

	
	public Playground() {

		bricks=new ArrayList<BrickPositions>();
		for(int i=0; i<7; i++) {
			int x=30+i*90;
			
			for(int j=0; j<6;j++) {
				
				int y=15+j*50;
				
				brickPos= new BrickPositions(x,y);
				this.bricks.add(brickPos);
			}
		}
		
		Collections.shuffle(bricks);
		
	}
	
	public  int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getUpperbound() {
		return upperbound;
	}
	public void setUpperbound(int upperbound) {
		this.upperbound = upperbound;
	}
	public int getLowerbound() {
		return lowerbound;
	}
	public void setLowerbound(int lowerbound) {
		this.lowerbound = lowerbound;
	}
	public int getLeftbound() {
		return leftbound;
	}
	public void setLeftbound(int leftbound) {
		this.leftbound = leftbound;
	}
	public int getRightbound() {
		return rightbound;
	}
	public void setRightbound(int rightbound) {
		this.rightbound = rightbound;
	}


	public ArrayList<BrickPositions> getBricks() {
		return bricks;
	}

	public static void setBricks(ArrayList<BrickPositions> bricks) {
		Playground.bricks = bricks;
	}
	
	

	
//	private void randomX() {
//		Collections.shuffle(brickX);
//	}
	
}
