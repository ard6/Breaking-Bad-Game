package UI;

import Domain.GameController;

import java.awt.event.*;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;

public class GameEngine extends JPanel implements KeyListener,ActionListener,MouseListener {
	public Timer timer;
	private int delay=8;
	private PaddleDisplay paddle;
	private BallDisplay ball;
	
	public static int numberSB;
	public static int numberHMB;
	public static int numberMB;
	public static int numberWB;

	
	public GameController game;
	private PlaygroundDisplay playground;
	
	private AlienDisplay alien;
	private PowerupDisplay powerup;
	private BrickDisplay brick;
	private LivesDisplay lives;
	
	private LaserGunDisplay laser1;
	private LaserGunDisplay laser2;
	private LaserGunDisplay laser3;
	private LaserGunDisplay laser4;
	private LaserGunDisplay laser5;
	private LaserGunDisplay laser6;
	private LaserGunDisplay laser7;
	private LaserGunDisplay laser8;
	private LaserGunDisplay laser9;
	private LaserGunDisplay laser10;
	private ScoreDisplay score;

	public GameEngine(boolean b) {
	}
	
	public GameEngine() {

		
		game=new GameController(numberSB, numberHMB, numberMB, numberWB);
		
		paddle = new PaddleDisplay();
		ball= new BallDisplay();
		playground=new PlaygroundDisplay();
		
		brick = new BrickDisplay();
		powerup=new PowerupDisplay();
		alien= new AlienDisplay();
		lives= new LivesDisplay();
		score= new ScoreDisplay();
		
		laser1 = new LaserGunDisplay();
		laser2 = new LaserGunDisplay();
		laser3 = new LaserGunDisplay();
		laser4 = new LaserGunDisplay();
		laser5 = new LaserGunDisplay();
		laser6 = new LaserGunDisplay();
		laser7 = new LaserGunDisplay();
		laser8 = new LaserGunDisplay();
		laser9 = new LaserGunDisplay();
		laser10 = new LaserGunDisplay();
		addMouseListener(this);  
        
        setSize(300,300);  
        setLayout(null);  
        setVisible(true);  
		
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		
		playground.drawPlayground((Graphics2D) g);		
		paddle.draw((Graphics2D) g);
		ball.drawBall((Graphics2D) g);
		brick.draw((Graphics2D) g);

		powerup.draw((Graphics2D) g);
		alien.drawA((Graphics2D) g);
		lives.draw((Graphics2D) g);
		score.draw((Graphics2D) g);
		
		laser1.draw((Graphics2D) g);
		laser2.draw((Graphics2D) g);
		laser3.draw((Graphics2D) g);
		laser4.draw((Graphics2D) g);
		laser5.draw((Graphics2D) g);
		laser6.draw((Graphics2D) g);
		laser7.draw((Graphics2D) g);
		laser8.draw((Graphics2D) g);
		laser9.draw((Graphics2D) g);
		laser10.draw((Graphics2D) g);
		
		g.dispose();
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Monopoly Represents: Bricking Bad");
		
		timer.start();
		
		ball.xPos=game.moveBallX();
		ball.yPos=game.moveBallY();
		paddle.xPositions=game.getPaddleXPosition();
		paddle.yPositions=game.getPaddleYPosition();
		
		game.moveAlien();
		alien.xPos=game.gameAlien().getXpos();
		alien.yPos=game.gameAlien().getYpos();
		game.movepowerup();
		game.loseBall();
		lives.amount=game.getLife();
		game.rebound();
		game.laserShot();
		game.updateSize();
		
		score.score=game.getScore();
		laser1.xPos=game.laserX(0);
		laser1.yPos=game.laserY(0);
		
		laser2.xPos=game.laserX(1);
		laser2.yPos=game.laserY(1);
		
		laser3.xPos=game.laserX(2);
		laser3.yPos=game.laserY(2);
		
		laser4.xPos=game.laserX(3);
		laser4.yPos=game.laserY(3);
		
		laser5.xPos=game.laserX(4);
		laser5.yPos=game.laserY(4);
		
		laser6.xPos=game.laserX(5);
		laser6.yPos=game.laserY(5);
		
		laser7.xPos=game.laserX(6);
		laser7.yPos=game.laserY(6);
		
		laser8.xPos=game.laserX(7);
		laser8.yPos=game.laserY(7);
		
		laser9.xPos=game.laserX(8);
		laser9.yPos=game.laserY(8);
		
		laser10.xPos=game.laserX(9);
		laser10.yPos=game.laserY(9);
	
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{        
					
					paddle.xPositions=game.movePaddle("right");
			}
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{          
					paddle.xPositions=game.movePaddle("left") ;
			}
		if(arg0.getKeyCode()==KeyEvent.VK_UP ||arg0.getKeyCode()==KeyEvent.VK_SPACE  ) {				
				game.launchBall();
		}
		if(arg0.getKeyCode()==KeyEvent.VK_D) {
			int[][] positions= game.rotatePaddle("D");
			paddle.xPositions=positions[0];
			paddle.yPositions=positions[1];
		}
		if(arg0.getKeyCode()==KeyEvent.VK_A) {
			int[][] positions= game.rotatePaddle("A");
			paddle.xPositions=positions[0];
			paddle.yPositions=positions[1];
		}
		if(arg0.getKeyCode()==KeyEvent.VK_M) {
			paddle.type=game.useMagnet();
		}
		
		if(arg0.getKeyCode()==KeyEvent.VK_C) {
			ball.type=game.useChemicalBall();
		}
		
		if(arg0.getKeyCode()==KeyEvent.VK_1) {
			game.activateLaserGun();
		}
		
		if(arg0.getKeyCode()==KeyEvent.VK_W) {			
			game.useLaserGun();
		}
		if(arg0.getKeyCode()==KeyEvent.VK_T) {
			game.activateTallerPaddle();
		}
		
		if(arg0.getKeyCode()==KeyEvent.VK_2) {
			game.alien();
		}
		
	}	
	



	public void mouseClicked(MouseEvent e) {  
        
    }  

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getNumberSB() {
		return numberSB;
	}
	
	public void setNumberSB(int n) {
		this.numberSB=n;
	}

	public static int getNumberHMB() {
		return numberHMB;
	}

	public static void setNumberHMB(int numberHMB) {
		GameEngine.numberHMB = numberHMB;
	}

	public static int getNumberMB() {
		return numberMB;
	}

	public static void setNumberMB(int numberMB) {
		GameEngine.numberMB = numberMB;
	}

	public static int getNumberWB() {
		return numberWB;
	}

	public static void setNumberWB(int numberWB) {
		GameEngine.numberWB = numberWB;
	}
	
	
		
}
