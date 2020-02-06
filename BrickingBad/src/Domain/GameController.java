package Domain;

import java.util.ArrayList;

public class GameController {
	
	Board board ;
	
	
	public GameController(int sbNumber, int hmbNumber, int mbNumber, int wbNumber) {
		board = new Board(sbNumber, hmbNumber, mbNumber, wbNumber);
	}
	
	public int getLife() {
		return board.getLife();
	}
	
	public void launchBall() {
		board.launchBall();
	}
	
	public void loseBall() {
		board.loseBall();
	}
	
	public int moveBallX() {
		
		return board.moveBallX();
	}
	
	public Alien gameAlien() {
		return board.alien;
	}
	
	public ArrayList<Brick> getBrickList() {
		
		return board.brickList();
	}
	public ArrayList<Brick> metalBrickList() {
		return board.metalBrickList();
	}

	public ArrayList<Brick> mineBrickList() {
		return board.mineBrickList();
	}
	public ArrayList<Brick> wrapperBrickList() {
		return board.wrapperBrickList();
	}
	
	public ArrayList<Powerup> powerupList() {
		return board.powerup();
	}

	public int moveBallY() {
		return board.moveBallY();
	}
	
	public void movepowerup(){
		board.movePowerUp();
	}
	
	public int[][] rotatePaddle(String input) {
		
		return board.rotatePaddle(input);
		
	}
	

	public int[] movePaddle(String input) {
		return board.movePaddle(input);
	}
	
	
	public void destroy(ArrayList <Brick> list, int i) {
		board.destroy(list,i);
	}
	
	public void rebound() {

		board.rebound();
			
	}
	
	public String useMagnet() {
		return board.useMagnet();
	}
	
	public String useChemicalBall() {
		return board.useChemicalBall();
	}
	
	public int getNumberBrick() {
		return board.getNumberBrick();
	}

	public void setNumberBrick(int numberBrick) {
		board.setNumberBrick(numberBrick);
	}
	
	public int[] getPaddleXPosition() {
		return board.getPaddleXPosition();
	}
	public int[] getPaddleYPosition() {
		return board.getPaddleYPosition();
	}
	
	public void moveAlien() {
		board.moveAlien();
	}
	
	public void statusSetter() {
		board.statusSetter();
	}
	
	public void coop() {
		board.coop();
	}
	
	public void laserShot() {
		board.laserShot();
	}
	
	public void activateLaserGun() {
		board.activateLaserGun();
	}
	
	public void useLaserGun() {
		board.useLaserGun();
	}
	
	public int laserY(int i) {
		return board.laserY(i);
	}
	
	public int laserX(int i) {
		return board.laserX(i);
	}
	
	public ArrayList<LaserGun> lasergunlist(){
		return board.lasergunlist();
	}
	
	public void activateTallerPaddle() {
		board.activateTallerPaddle();
	}
	public int getScore() {
		return board.getScore();
	}
	
	public void alien() {
		board.alien();
	}
	
	public void updateSize() {
		board.updateSize();
	}
}
