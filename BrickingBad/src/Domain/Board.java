package Domain;

import java.util.ArrayList;
import java.util.Random;
public class Board {

	public int[] xPositions= {346,446,446,346};
	public int[] yPositions = {500,500,508,508};
	private  Paddle p = new Paddle(20, 100, 8, 0, xPositions,yPositions, 346, 530, 0);
	private Ball b = new Ball(0,0,0,396,491,8);
	private Player user = Player.getInstance();
	private Playground playground=new Playground();
	private int sbNumber;
	private int hmbNumber;
	private int mbNumber;
	private int wbNumber;
	private Random rand;
	public static ArrayList<Brick> simpleBrickList;
	public static ArrayList<Brick> halfMetalBrickList;
	public static ArrayList<Brick> mineBrickList;
	public static ArrayList<Brick> wrapperBrickList;
	public static ArrayList<Powerup> powerup;
	public static ArrayList<LaserGun> lasergun;
	private int isStatus3Used=1;
	public Alien alien;
	public int alienType;
	public static int[] pocket=new int[]{0,0,0,0,0,0};//1. magnet 2. chemical 3. alien 
	private boolean activeLaserGun=false;
	private int totalSize;
	public static int currentSize;
	public Board(int sbNumber, int hmbNumber, int mbNumber, int wbNumber) {
		
		
		this.sbNumber=sbNumber;
		this.hmbNumber=hmbNumber;
		this.mbNumber=mbNumber;
		this.wbNumber=wbNumber;
		
		rand=new Random();
		
		alienType=2;
		
		switch(alienType) {
		case 0:
			alien=new ProtectingAlien(50,350,40,15);
			break;	
		case 1:
			alien=new CooperativeAlien(50,350,40,15);
			break;	
		case 2:
			alien=new DrunkAlien(85,-1000,40,15);
			break;	
		case 3:	
			alien=new RepairingAlien(100,350,40,15);
			break;
		default:
			break;
		}
		
		simpleBrickList = new ArrayList<Brick>();
		halfMetalBrickList = new ArrayList<Brick>();
		mineBrickList = new ArrayList<Brick>();
		wrapperBrickList= new ArrayList<Brick>();
		powerup=new ArrayList<Powerup>();
		lasergun= new ArrayList<LaserGun>();
		rand=new Random();

		//repairing alien bricks
		for(int i=0; i<7; i++) {
			Brick brick1=BrickFactory.createBrick("simple", 30+i*90, -1000, 40, 80);
			simpleBrickList.add(brick1);
		}
		
		for(int i=0;i<sbNumber;i++) {
			int xb=playground.getBricks().get(i).getX();
			int yb=playground.getBricks().get(i).getY();
			Brick brick1=BrickFactory.createBrick("simple",xb, yb, 40, 80);
			simpleBrickList.add(brick1);
		}
		for(int i=0;i<hmbNumber;i++) {
			int xb=playground.getBricks().get(i+sbNumber).getX();
			int yb=playground.getBricks().get(i+sbNumber).getY();
			Brick brick1=BrickFactory.createBrick("half-metal-brick",xb, yb, 40, 80);
			halfMetalBrickList.add(brick1);
		}
		for(int i=0;i<mbNumber;i++) {
			int xb=playground.getBricks().get(i+sbNumber+hmbNumber).getX()+20;
			int yb=playground.getBricks().get(i+sbNumber+hmbNumber).getY();
			Brick brick1=BrickFactory.createBrick("mine-brick",xb ,yb, 40, 40);
			mineBrickList.add(brick1);
		}
		for(int i=0;i<wbNumber;i++) {
			int xb=playground.getBricks().get(i+sbNumber+hmbNumber+mbNumber).getX();
			int yb=playground.getBricks().get(i+sbNumber+hmbNumber+mbNumber).getY();

			Brick brick1=BrickFactory.createBrick("wrapper-brick",xb, yb, 40, 80);
			
			wrapperBrickList.add(brick1);
			int y=rand.nextInt(2);
			if(y==1) {
				MagnetPowerup magnet=new MagnetPowerup(xb+35,yb+15,10,"magnet",false,false);
				powerup.add(magnet);
			}else {
				ChemicalPowerup chemical=new ChemicalPowerup(xb+35,yb+15,10,"chemical",false,false);
				powerup.add(chemical);
			}
					
		}
		this.totalSize=this.hmbNumber+this.mbNumber+this.sbNumber+this.wbNumber;
		this.currentSize=this.totalSize;
		user.setLife(3);
		
		user.setAmmo(5);
		
		this.activeLaserGun=false;
		
		LaserGun laser1= new LaserGun(-1000, -1000, 0, false);
		LaserGun laser2= new LaserGun(-1000, -1000, 0, false);
		LaserGun laser3= new LaserGun(-1000, -1000, 0, false);
		LaserGun laser4= new LaserGun(-1000, -1000, 0, false);
		LaserGun laser5= new LaserGun(-1000, -1000, 0, false);
		LaserGun laser6= new LaserGun(-1000, -1000, 0, false);
		LaserGun laser7= new LaserGun(-1000, -1000, 0, false);
		LaserGun laser8= new LaserGun(-1000, -1000, 0, false);
		LaserGun laser9= new LaserGun(-1000, -1000, 0, false);
		LaserGun laser10= new LaserGun(-1000, -1000, 0, false);
		lasergun.add(laser1);
		lasergun.add(laser2);
		lasergun.add(laser3);
		lasergun.add(laser4);	
		lasergun.add(laser5);
		lasergun.add(laser6);	
		lasergun.add(laser7);
		lasergun.add(laser8);	
		lasergun.add(laser9);
		lasergun.add(laser10);	

		
	}
	
	public int getLife() {
		return user.getLife();
	
	}
	
	public void loseBall() {
		if(b.getyPosition() >592) {
			if(user.getLife()>1) {
				b.setxPosition(396);
				b.setyPosition(491);
				b.setVelocity(0);
				int[] initialPaddleX = {346,446,446,346};
				int[] initialPAddleY = {500,500,508,508};
				p.setxPositions(initialPaddleX);
				p.setyPositions(initialPAddleY);
				p.setStatus(0);
				p.setLaunched(false);
				user.setLife(user.getLife()-1);
				p.setCopyx(initialPaddleX);
				p.setCopyy(initialPAddleY);
				
				//Reset LaserGun
				for(int i=0; i<lasergun.size(); i++) {
					lasergun.get(i).setFired(false);
					lasergun.get(i).setVelocity(0);
					lasergun.get(i).setX(-1000);
					lasergun.get(i).setY(-1000);
					user.setAmmo(5);
					this.activeLaserGun=false;
				}
			}
			else  {
				int[] initialPaddleX = {346,446,446,346};
				int[] initialPAddleY = {500,500,508,508};
				p.setxPositions(initialPaddleX);
				p.setyPositions(initialPAddleY);
				p.setStatus(0);
				user.setLife(user.getLife()-1);
				p.setCopyx(initialPaddleX);
				p.setCopyy(initialPAddleY);
			}
		}
	}
	
	public void launchBall() {
		if(!p.isLaunched()){
			b.setVelocity(2);
			if( p.getStatus()==0){
				b.setxDir(0);
			}else if(p.getStatus()==-1){
				b.setxDir(-1);
			}else{
				b.setxDir(1);
			}
			b.setyDir(-1);
			p.setLaunched(true);
			
		}
	}
	
public void movePowerUp(){
		
		for(Powerup powerupinstance:powerup){
			if(powerupinstance.isHit()){
				powerupinstance.move();
			}
			
			if(powerupinstance.getXpos()>p.getxPositions()[0] && powerupinstance.getXpos()<p.getxPositions()[1]) {
				
				if(powerupinstance.getYpos() > p.getyPositions()[0]- powerupinstance.getRadii()/4 && powerupinstance.getYpos()  < p.getyPositions()[0] + powerupinstance.getRadii()/4) {
					
					if(powerupinstance.getType().equals("magnet")) {
						pocket[0]=pocket[0]+1;
					}else if(powerupinstance.getType().equals("chemical")) {
						pocket[1]=pocket[1]+1;
					}
					
					powerupinstance.setXpos(-500);
							
				}
		
			}
				
		}

	}
	
	public int moveBallX() {
		b.moveX(b.getxDir());
		
		return b.getxPosition();
	}
	
	
	public int moveBallY() {
		b.moveY(b.getyDir());
		return b.getyPosition();
	}
	
	
	public int[][] rotatePaddle(String input) {
		if(input.equals("D") && this.activeLaserGun==false) {
			
			
			p.rotate(1);
			if(!p.isLaunched()){
				
				
				b.setxPosition((p.getxPositions()[0]+p.getxPositions()[1])/2);
				b.setyPosition((p.getyPositions()[0]+p.getyPositions()[1])/2-b.getRadii());
			}
		}
		
		if(input.equals("A") && this.activeLaserGun==false) {
			p.rotate(-1);
			if(!p.isLaunched()){
				b.setxPosition((p.getxPositions()[0]+p.getxPositions()[1])/2-b.getRadii()+1);
				b.setyPosition((p.getyPositions()[0]+p.getyPositions()[1])/2-b.getRadii());
			}
		}
		
		
			int[][] positions = {{1,1,1,1},{2,2,2,2}};
			
			int[]temp1=p.getxPositions();
			int[]temp2=p.getyPositions();
			positions[0][0]=temp1[0];
			positions[0][1]=temp1[1];
			positions[0][2]=temp1[2];
			positions[0][3]=temp1[3];
			

			positions[1][0]=temp2[0];
			positions[1][1]=temp2[1];
			positions[1][2]=temp2[2];
			positions[1][3]=temp2[3];
			
			 return positions;
		
	}
	

	public int[] movePaddle(String input) {
		
		if (input.equals("left")) {
			int tempPaddlepos=p.getxPositions()[0];
			
			p.move(-1, p.getVelocity());
			int distance=p.getxPositions()[0]-tempPaddlepos;
			

				if(!p.isLaunched()){					
					b.setxPosition(b.getxPosition()+distance);
					
				}
				
				for(int i=0; i<10; i++) {
					if(lasergun.get(i).isFired()==false) {
						lasergun.get(i).setX(lasergun.get(i).getX()+distance);
					}
				}
			
		
		} else if (input.equals("right")) {
			int tempPaddlepos=p.getxPositions()[1];
			
			p.move(1, p.getVelocity());
			
			int distance=p.getxPositions()[1]-tempPaddlepos;
			
			if(!p.isLaunched()){
				b.setxPosition(b.getxPosition()+distance);
			}
			
			for(int i=0; i<10; i++) {
				if(lasergun.get(i).isFired()==false) {
					lasergun.get(i).setX(lasergun.get(i).getX()+distance);
				}
			}
		
		
		} else {
		
			return null;
		}
		return p.getxPositions();
	}
	
	
	public void destroy(ArrayList <Brick> list, int i) {

		
		list.get(i).setXpos(2000);
	}
	
public ArrayList<Brick> brickList(){
		
		return simpleBrickList;
	}
public ArrayList<Brick> metalBrickList(){
	
	return halfMetalBrickList;
}
public ArrayList<Brick> mineBrickList() {
	return mineBrickList;
}
public ArrayList<Brick> wrapperBrickList() {
	return wrapperBrickList;
}

public ArrayList<Powerup> powerup() {
	return powerup;
}
	
public void rebound() {
		
	//paddle rebound
	
	
			if(b.getxPosition()>p.getxPositions()[0] && b.getxPosition()<p.getxPositions()[1]) {
				if(p.getStatus()==0){
					if(b.getyPosition() > p.getyPositions()[0]- b.getRadii()/4 && b.getyPosition() < p.getyPositions()[0] + b.getRadii()/4) {
					
						if(p.isMagnet()==false) {
							b.setyDir((-1)*b.getyDir());
						}else {
							b.setxDir(0);
							b.setyDir(0);
							b.setyPosition(b.getyPosition()-b.getRadii());
							p.setLaunched(false);
						}
								
					}
				}
			
				else if(p.getStatus()==-1){
					if(b.getyPosition()>=p.getyPositions()[1]&& b.getyPosition()<=p.getyPositions()[0])
					
						if(b.getxPosition()-p.getxPositions()[0]>= -(b.getyPosition()-p.getyPositions()[0])) {
						
							if(p.isMagnet()==false) {
								int temp=b.getyDir();
								b.setyDir((-1)*b.getxDir());
								b.setxDir((-1)*temp);
							}else {
								b.setxDir(0);
								b.setyDir(0);
								b.setxPosition(b.getxPosition()-b.getRadii());
								b.setyPosition(b.getyPosition()-b.getRadii());
								p.setLaunched(false);
							}
						
					}	
				
				}else{
					if(b.getyPosition()>=p.getyPositions()[0]&& b.getyPosition()<=p.getyPositions()[1])
						
						if(b.getxPosition()-p.getxPositions()[1]<= (b.getyPosition()-p.getyPositions()[1])) {
						
							if(p.isMagnet()==false) {
								int temp=b.getyDir();
								b.setyDir(b.getxDir());
								b.setxDir(temp);
							}else {
								b.setxDir(0);
								b.setyDir(0);
//								b.setxPosition(b.getxPosition()+b.getRadii());
								b.setyPosition(b.getyPosition()-b.getRadii());
								p.setLaunched(false);
							}
							
						
					}	
				}
			}
	
	// brick rebound
	for(int i=0; i<simpleBrickList.size(); i++) {
		
		Brick brick=simpleBrickList.get(i);
		
		if(b.getxPosition()>brick.getXpos() && b.getxPosition()<brick.getXpos()+ brick.getLength()) {
			
			if(b.getyPosition() > brick.getYpos()- b.getRadii() && b.getyPosition() < brick.getYpos() + b.getRadii()) {
				brick.setXpos(-100);
				brick.setYpos(-100);

				this.currentSize--;
				user.setScore(user.getScore()+30);
				
				if(b.isChemical()==false) {
					b.setyDir((-1)*b.getyDir());
				}else
				if(b.isFireball()) {
					
					for(Brick bricks1:simpleBrickList) {
						for(Brick bricks2:halfMetalBrickList) {
							
							for(Brick bricks3:wrapperBrickList) {
								
							if((bricks2.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks2.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks2.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks2.getYpos()>=brick.getYpos()-2*p.getLength())) {
								
								bricks2.setXpos(-100);
								bricks2.setYpos(-100);
								this.currentSize--;
							}
							if((bricks1.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks1.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks1.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks1.getYpos()>=brick.getYpos()-2*p.getLength())) {
								
								bricks1.setXpos(-100);
								bricks1.setYpos(-100);
								this.currentSize--;
							}
							if((bricks3.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks3.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks3.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks3.getYpos()>=brick.getYpos()-2*p.getLength())) {
								// magnetPaddle
								powerup.get(wrapperBrickList.indexOf(bricks3)).setHit(true);
								bricks3.setXpos(-100);
								bricks3.setYpos(-100);
								this.currentSize--;
							}
						}
					  }
					}
				
				
				
					b.setyDir((-1)*b.getyDir());
				}
			}
			
			if(b.getyPosition() > brick.getYpos()+brick.getWidth()- b.getRadii() && b.getyPosition() < brick.getYpos()+brick.getWidth() + b.getRadii()) {
				brick.setXpos(-100);
				brick.setYpos(-100);
				this.currentSize--;
//---------------------------------
				user.setScore(user.getScore()+30);
				
				if(b.isChemical()==false) {
					b.setyDir((-1)*b.getyDir());
				}
			}	
			
		}
		
		if(b.getyPosition()>brick.getYpos() && b.getyPosition()<brick.getYpos()+ brick.getWidth()) {
			
			if(b.getxPosition() > brick.getXpos()- b.getRadii() && b.getxPosition() < brick.getXpos() + b.getRadii()) {
				brick.setXpos(-100);
				brick.setYpos(-100);

				this.currentSize--;
				user.setScore(user.getScore()+30);
				
				if(b.isChemical()==false) {
					b.setxDir((-1)*b.getxDir());
				}
			}
			
			if(b.getxPosition() > brick.getXpos()+brick.getLength()- b.getRadii() && b.getxPosition() < brick.getXpos()+brick.getLength() + b.getRadii()) {
				brick.setXpos(-100);
				brick.setYpos(-100);
				this.currentSize--;
				user.setScore(user.getScore()+30);
				
				if(b.isChemical()==false) {
					b.setxDir((-1)*b.getxDir());
				}
			}	
			
		}
		
	}
	
	//half metal destroy
	for(int i=0; i<halfMetalBrickList.size(); i++) {
		
		Brick brick=halfMetalBrickList.get(i);
		
		if(b.getxPosition()>brick.getXpos() && b.getxPosition()<brick.getXpos()+ brick.getLength()) {
			
			if(b.getyPosition() > brick.getYpos()- b.getRadii() && b.getyPosition() < brick.getYpos() + b.getRadii()) {
				brick.setXpos(-100);
				brick.setYpos(-100);
				this.currentSize--;

				user.setScore(user.getScore()+100);
				
				if(b.isChemical()==false) {
					b.setyDir((-1)*b.getyDir());
				}
			}
			
			if(b.getyPosition() > brick.getYpos()+brick.getWidth()- b.getRadii() && b.getyPosition() < brick.getYpos()+brick.getWidth() + b.getRadii()) {
				
				if(b.isChemical()==false) {
					b.setyDir((-1)*b.getyDir());
				}else {
					brick.setXpos(-100);
					brick.setYpos(-100);

					this.currentSize--;
					user.setScore(user.getScore()+100);
				}
			}	
			
		}
		
		if(b.getyPosition()>brick.getYpos() && b.getyPosition()<brick.getYpos()+ brick.getWidth()) {
			
			if(b.getxPosition() > brick.getXpos()- b.getRadii() && b.getxPosition() < brick.getXpos() + b.getRadii()) {
				
				if(b.isChemical()==false) {
					b.setxDir((-1)*b.getxDir());
				}
				else {
					brick.setXpos(-100);
					brick.setYpos(-100);
					this.currentSize--;

					user.setScore(user.getScore()+100);
				}
			}
			
			if(b.getxPosition() > brick.getXpos()+brick.getLength()- b.getRadii() && b.getxPosition() < brick.getXpos()+brick.getLength() + b.getRadii()) {
				
				if(b.isChemical()==false) {
					b.setxDir((-1)*b.getxDir());
				}
				else {
					brick.setXpos(-100);
					brick.setYpos(-100);
					this.currentSize--;

					user.setScore(user.getScore()+100);
				}
			}	
			
		}
		
	}
for(int i=0; i<mineBrickList.size(); i++) {
		
		Brick brick=mineBrickList.get(i);
		
		if(b.getxPosition()>brick.getXpos() && b.getxPosition()<brick.getXpos()+ brick.getLength()) {
			
			if(b.getyPosition() > brick.getYpos()- b.getRadii() && b.getyPosition() < brick.getYpos() + b.getRadii()) {
				
				for(Brick bricks1:simpleBrickList) {
					for(Brick bricks2:halfMetalBrickList) {
						
						for(Brick bricks3:wrapperBrickList) {
							
						if((bricks2.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks2.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks2.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks2.getYpos()>=brick.getYpos()-2*p.getLength())) {
							
							bricks2.setXpos(-100);
							bricks2.setYpos(-100);
							this.currentSize--;

							user.setScore(user.getScore()+100);
						}
						if((bricks1.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks1.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks1.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks1.getYpos()>=brick.getYpos()-2*p.getLength())) {
							
							bricks1.setXpos(-100);
							bricks1.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+30);
						}
						if((bricks3.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks3.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks3.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks3.getYpos()>=brick.getYpos()-2*p.getLength())) {
							// magnetPaddle
							powerup.get(wrapperBrickList.indexOf(bricks3)).setHit(true);
							bricks3.setXpos(-100);
							bricks3.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+30);
						}
					}
				}
				}
				brick.setXpos(-100);
				brick.setYpos(-100);
				this.currentSize--;

				user.setScore(user.getScore()+50);
				if(b.isChemical()==false) {
					b.setyDir((-1)*b.getyDir());
				}
			}
			
if(b.getyPosition() > brick.getYpos()+brick.getWidth()- b.getRadii() && b.getyPosition() < brick.getYpos()+brick.getWidth() + b.getRadii()) {
				
				for(Brick bricks1:simpleBrickList) {
					for(Brick bricks2:halfMetalBrickList) {
						for(Brick bricks3:wrapperBrickList) {
						if((bricks2.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks2.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks2.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks2.getYpos()>=brick.getYpos()-2*p.getLength())) {
							
							bricks2.setXpos(-100);
							bricks2.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+100);
						}
						if((bricks1.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks1.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks1.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks1.getYpos()>=brick.getYpos()-2*p.getLength())) {
							
							bricks1.setXpos(-100);
							bricks1.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+30);
						}
						if((bricks3.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks3.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks3.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks3.getYpos()>=brick.getYpos()-2*p.getLength())) {
							powerup.get(wrapperBrickList.indexOf(bricks3)).setHit(true);
							bricks3.setXpos(-100);
							bricks3.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+30);
						}
					}
				}
				}
				brick.setXpos(-100);
				brick.setYpos(-100);
				this.currentSize--;
				user.setScore(user.getScore()+50);
				if(b.isChemical()==false) {
					b.setyDir((-1)*b.getyDir());
				}
			}	
			
		}
		
		if(b.getyPosition()>brick.getYpos() && b.getyPosition()<brick.getYpos()+ brick.getWidth()) {
			
			if(b.getxPosition() > brick.getXpos()- b.getRadii() && b.getxPosition() < brick.getXpos() + b.getRadii()) {
				for(Brick bricks1:simpleBrickList) {
					for(Brick bricks2:halfMetalBrickList) {
						for(Brick bricks3:wrapperBrickList) {
						if((bricks2.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks2.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks2.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks2.getYpos()>=brick.getYpos()-2*p.getLength())) {
							
							bricks2.setXpos(-100);
							bricks2.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+100);
						}
						if((bricks1.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks1.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks1.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks1.getYpos()>=brick.getYpos()-2*p.getLength())) {
							
							bricks1.setXpos(-100);
							bricks1.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+30);
						}
						if((bricks3.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks3.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks3.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks3.getYpos()>=brick.getYpos()-2*p.getLength())) {
							powerup.get(wrapperBrickList.indexOf(bricks3)).setHit(true);
							bricks3.setXpos(-100);
							bricks3.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+30);
						}
					}
				}
				}
				brick.setXpos(-100);
				brick.setYpos(-100);
				this.currentSize--;
				user.setScore(user.getScore()+50);
				
				if(b.isChemical()==false) {
					b.setxDir((-1)*b.getxDir());
				}
			}
			
			if(b.getxPosition() > brick.getXpos()+brick.getLength()- b.getRadii() && b.getxPosition() < brick.getXpos()+brick.getLength() + b.getRadii()) {
				
				for(Brick bricks1:simpleBrickList) {
					for(Brick bricks2:halfMetalBrickList) {
						for(Brick bricks3:wrapperBrickList) {
						if((bricks2.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks2.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks2.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks2.getYpos()>=brick.getYpos()-2*p.getLength())) {
							
							bricks2.setXpos(-100);
							bricks2.setYpos(-100);
							this.currentSize--;
							
							user.setScore(user.getScore()+100);
						}
						if((bricks1.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks1.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks1.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks1.getYpos()>=brick.getYpos()-2*p.getLength())) {
							
							bricks1.setXpos(-100);
							bricks1.setYpos(-100);
							this.currentSize--;
							
							user.setScore(user.getScore()+30);
						}
						if((bricks3.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks3.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks3.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks3.getYpos()>=brick.getYpos()-2*p.getLength())) {
							powerup.get(wrapperBrickList.indexOf(bricks3)).setHit(true);
							bricks3.setXpos(-100);
							bricks3.setYpos(-100);
							this.currentSize--;
							
							user.setScore(user.getScore()+30);
						}
					}
				}
				}
				brick.setXpos(-100);
				brick.setYpos(-100);
				this.currentSize--;

				user.setScore(user.getScore()+50);
				if(b.isChemical()==false) {
					b.setxDir((-1)*b.getxDir());
				}
			}	
			
		}
		
	}
for(int i=0; i<wrapperBrickList.size(); i++) {

Brick brick=wrapperBrickList.get(i);

if(b.getxPosition()>brick.getXpos() && b.getxPosition()<brick.getXpos()+ brick.getLength()) {
	
	if(b.getyPosition() > brick.getYpos()- b.getRadii() && b.getyPosition() < brick.getYpos() + b.getRadii()) {
		
		this.powerup().get(i).setHit(true);
		
		brick.setXpos(-100);
		brick.setYpos(-100);
		this.currentSize--;
		user.setScore(user.getScore()+30);
		if(b.isChemical()==false) {
			b.setyDir((-1)*b.getyDir());
		}
		
	}
	
	if(b.getyPosition() > brick.getYpos()+brick.getWidth()- b.getRadii() && b.getyPosition() < brick.getYpos()+brick.getWidth() + b.getRadii()) {
		this.powerup().get(i).setHit(true);
		
		brick.setXpos(-100);
		brick.setYpos(-100);
		this.currentSize--;
		user.setScore(user.getScore()+30);
		if(b.isChemical()==false) {
			b.setyDir((-1)*b.getyDir());
		}
	}	
	
}

if(b.getyPosition()>brick.getYpos() && b.getyPosition()<brick.getYpos()+ brick.getWidth()) {
	
	if(b.getxPosition() > brick.getXpos()- b.getRadii() && b.getxPosition() < brick.getXpos() + b.getRadii()) {
		this.powerup().get(i).setHit(true);
		
		brick.setXpos(-100);
		brick.setYpos(-100);
		this.currentSize--;
		user.setScore(user.getScore()+30);
		if(b.isChemical()==false) {
			b.setxDir((-1)*b.getxDir());
		}
	}
	
	if(b.getxPosition() > brick.getXpos()+brick.getLength()- b.getRadii() && b.getxPosition() < brick.getXpos()+brick.getLength() + b.getRadii()) {
		this.powerup().get(i).setHit(true);
		
		brick.setXpos(-100);
		brick.setYpos(-100);
		this.currentSize--;
		user.setScore(user.getScore()+30);
		if(b.isChemical()==false) {
			b.setxDir((-1)*b.getxDir());
		}
	}	
	
}
}

//alien rebound
if(b.getxPosition()>alien.getXpos() && b.getxPosition()<alien.getXpos()+ alien.getLength()) {

if(b.getyPosition() > alien.getYpos()- b.getRadii() && b.getyPosition() < alien.getYpos() + b.getRadii()) {
	alien.setXpos(-100);
	alien.setYpos(-100);
	alien.setAppeared(false);
	alien.setStatus(4);
	if(b.isChemical()==false) {
		b.setyDir((-1)*b.getyDir());
	}
}

if(b.getyPosition() > alien.getYpos()+alien.getWidth()- b.getRadii() && b.getyPosition() < alien.getYpos()+alien.getWidth() + b.getRadii()) {
	
	if(b.isChemical()==false) {
		b.setyDir((-1)*b.getyDir());
	}else {
		alien.setXpos(-100);
		alien.setYpos(-100);
		alien.setAppeared(false);
		alien.setStatus(4);
	}
}	

}

if(b.getyPosition()>alien.getYpos() && b.getyPosition()<alien.getYpos()+ alien.getWidth()) {

if(b.getxPosition() > alien.getXpos()- b.getRadii() && b.getxPosition() < alien.getXpos() + b.getRadii()) {
	
	if(b.isChemical()==false) {
		b.setxDir((-1)*b.getxDir());
	}else {
		alien.setXpos(-100);
		alien.setYpos(-100);
		alien.setAppeared(false);
		alien.setStatus(4);
	}
}

if(b.getxPosition() > alien.getXpos()+alien.getLength()- b.getRadii() && b.getxPosition() < alien.getXpos()+alien.getLength() + b.getRadii()) {
	
	if(b.isChemical()==false) {
		b.setxDir((-1)*b.getxDir());
	}else {
		alien.setXpos(-100);
		alien.setYpos(-100);
		alien.setAppeared(false);
		alien.setStatus(4);
	}
}	

}
	if(alien.getType()=="DrunkAlien" && alien.isAppeared()==true) {
		statusSetter();
		if(alien.getStatus()==0) {
			coop();
		}
		if(alien.getStatus()==1) {
			repair();
		}
		if(alien.getStatus()==3) {
			protectAndRepair();		
		}
		
	}
	
}	
public void statusSetter() {
	if(currentSize>7*totalSize/10) {
		alien.setStatus(0);
		
	} else if(currentSize>=6*totalSize/10 && currentSize<=7*totalSize/10) {
		alien.setStatus(4);
		
	} else if(currentSize>totalSize/2 && currentSize<6*totalSize/10) {
		alien.setStatus(1);
		
	} else if(currentSize>4*totalSize/10 && currentSize<=totalSize/2) {
		alien.setStatus(2);
		this.isStatus3Used=1;
	} else if(currentSize>=3*totalSize/10 && currentSize<=4*totalSize/10) {
		alien.setStatus(4);
		this.isStatus3Used=1;
	} else if(currentSize<3*totalSize/10) {
		alien.setStatus(3);
		
	} else {
		alien.setStatus(4);
		this.isStatus3Used=1;
	}
}

public void coop() {
	if(alien.getType()=="DrunkAlien" && alien.getStatus()==0) {
		
		rand=new Random();
		int y = 0;
		int n = rand.nextInt(6);
		switch(n) {
		case 0: 
			y=10;
			break;
		case 1: 
			y=60;
			break;
		case 2: 
			y=110;
			break;
		case 3: 
			y=160;
			break;
		case 4: 
			y=210;
			break;
		case 5: 
			y=260;
			break;
		}
		
		for(int i=0; i<simpleBrickList.size(); i++) {
			Brick brick=simpleBrickList.get(i);
			if(y>brick.getYpos() && y<brick.getYpos()+30) {
				brick.setXpos(-100);
				brick.setYpos(-100);
				this.currentSize--;
			}				
		}
	}
}

public void repair() {
	if(alien.getType()=="DrunkAlien" && alien.getStatus()==1) {
		
		int y = alien.getYpos();
		for(int i=0; i<7; i++) {
			simpleBrickList.get(i).setYpos(y-50);
			simpleBrickList.get(i).setXpos(30+i*90);
			
		}
		this.currentSize+=7;
	}
}

public void protectAndRepair() {
	if(alien.getType()=="DrunkAlien" && alien.getStatus()==3 && this.isStatus3Used>0) {
		for(int i=0; i<7; i++) {
			simpleBrickList.get(i).setYpos(315);
			simpleBrickList.get(i).setXpos(30+i*90);
			
		}
		this.currentSize+=7;
		alien.setDir(1);
		this.isStatus3Used=0;
	}
	else
		alien.setDir(1);
}
public void laserShot() {
	
	for(int j=0; j<lasergun.size(); j++) {
		LaserGun laser = lasergun.get(j);
		// brick rebound
				for(int i=0; i<simpleBrickList.size(); i++) {
					
					Brick brick=simpleBrickList.get(i);
					
					if(laser.getX()>brick.getXpos() && laser.getX()<brick.getXpos()+ brick.getLength() ) {
						

						
						if(laser.getY()> brick.getYpos()+brick.getWidth()-8 && laser.getY() < brick.getYpos()+brick.getWidth() + 8) {
							brick.setXpos(-100);
							brick.setYpos(-100);

							this.currentSize--;
							user.setScore(user.getScore()+30);
						}	
							
						
					}
					
				}
				
				//half metal destroy
				for(int i=0; i<halfMetalBrickList.size(); i++) {
					
					Brick brick=halfMetalBrickList.get(i);
					
					if(laser.getX() >brick.getXpos() && laser.getX() <brick.getXpos()+ brick.getLength()) {

						
						if(laser.getY() > brick.getYpos()+brick.getWidth()- 8 && laser.getY() < brick.getYpos()+brick.getWidth() + 8){
							
							laser.setY(-100);
						}	
						
					}
					
					if(laser.getY() >brick.getYpos() && laser.getY() <brick.getYpos()+ brick.getWidth()) {
						
						if(laser.getX() > brick.getXpos()- 8 && laser.getX() < brick.getXpos() + 8) {
							
							laser.setY(-100);
						}
						
						if(laser.getX() > brick.getXpos()+brick.getLength()- 8 && laser.getX() < brick.getXpos()+brick.getLength() + 8) {
							
							laser.setY(-100);
						}	
						
					}
					
				}
		for(int i=0; i<mineBrickList.size(); i++) {
					
					Brick brick=mineBrickList.get(i);
					
					if(laser.getX()>brick.getXpos() && laser.getX()<brick.getXpos()+ brick.getLength()) {
						
						if(laser.getY() > brick.getYpos()- 8 && laser.getY() < brick.getYpos() + 8) {
							
							for(Brick bricks1:simpleBrickList) {
								for(Brick bricks2:halfMetalBrickList) {
									
									for(Brick bricks3:wrapperBrickList) {
										
									if((bricks2.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks2.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks2.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks2.getYpos()>=brick.getYpos()-2*p.getLength())) {
										
										bricks2.setXpos(-100);
										bricks2.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+100);
									}
									if((bricks1.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks1.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks1.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks1.getYpos()>=brick.getYpos()-2*p.getLength())) {
										
										bricks1.setXpos(-100);
										bricks1.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+30);
									}
									if((bricks3.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks3.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks3.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks3.getYpos()>=brick.getYpos()-2*p.getLength())) {
										// magnetPaddle
										powerup.get(wrapperBrickList.indexOf(bricks3)).setHit(true);
										bricks3.setXpos(-100);
										bricks3.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+30);
									}
								}
							}
							}
							brick.setXpos(-100);
							brick.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+50);
						}
						
		if(laser.getY() > brick.getYpos()+brick.getWidth()- 8 && laser.getY() < brick.getYpos()+brick.getWidth() + 8) {
							
							for(Brick bricks1:simpleBrickList) {
								for(Brick bricks2:halfMetalBrickList) {
									for(Brick bricks3:wrapperBrickList) {
									if((bricks2.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks2.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks2.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks2.getYpos()>=brick.getYpos()-2*p.getLength())) {
										
										bricks2.setXpos(-100);
										bricks2.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+100);
									}
									if((bricks1.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks1.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks1.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks1.getYpos()>=brick.getYpos()-2*p.getLength())) {
										
										bricks1.setXpos(-100);
										bricks1.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+30);
									}
									if((bricks3.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks3.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks3.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks3.getYpos()>=brick.getYpos()-2*p.getLength())) {
										powerup.get(wrapperBrickList.indexOf(bricks3)).setHit(true);
										bricks3.setXpos(-100);
										bricks3.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+30);
									}
								}
							}
							}
							brick.setXpos(-100);
							brick.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+50);
						}	
						
					}
					
					if(laser.getY()>brick.getYpos() && laser.getY()<brick.getYpos()+ brick.getWidth()) {
						
						if(laser.getX() > brick.getXpos()- 8 && laser.getX() < brick.getXpos() + 8) {
							for(Brick bricks1:simpleBrickList) {
								for(Brick bricks2:halfMetalBrickList) {
									for(Brick bricks3:wrapperBrickList) {
									if((bricks2.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks2.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks2.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks2.getYpos()>=brick.getYpos()-2*p.getLength())) {
										
										bricks2.setXpos(-100);
										bricks2.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+100);
									}
									if((bricks1.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks1.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks1.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks1.getYpos()>=brick.getYpos()-2*p.getLength())) {
										
										bricks1.setXpos(-100);
										bricks1.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+30);
									}
									if((bricks3.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks3.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks3.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks3.getYpos()>=brick.getYpos()-2*p.getLength())) {
										powerup.get(wrapperBrickList.indexOf(bricks3)).setHit(true);
										bricks3.setXpos(-100);
										bricks3.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+30);
									}
								}
							}
							}
							brick.setXpos(-100);
							brick.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+50);
						}
						
						if(laser.getX() > brick.getXpos()+brick.getLength()- 8 && laser.getX() < brick.getXpos()+brick.getLength() + 8){
							
							for(Brick bricks1:simpleBrickList) {
								for(Brick bricks2:halfMetalBrickList) {
									for(Brick bricks3:wrapperBrickList) {
									if((bricks2.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks2.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks2.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks2.getYpos()>=brick.getYpos()-2*p.getLength())) {
										
										bricks2.setXpos(-100);
										bricks2.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+100);
									}
									if((bricks1.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks1.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks1.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks1.getYpos()>=brick.getYpos()-2*p.getLength())) {
										
										bricks1.setXpos(-100);
										bricks1.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+30);
									}
									if((bricks3.getXpos()<=brick.getXpos()+2*p.getLength()&&bricks3.getXpos()>=brick.getXpos()-2*p.getLength()) && (bricks3.getYpos()<=brick.getYpos()+2*p.getLength()&&bricks3.getYpos()>=brick.getYpos()-2*p.getLength())) {
										powerup.get(wrapperBrickList.indexOf(bricks3)).setHit(true);
										bricks3.setXpos(-100);
										bricks3.setYpos(-100);
										this.currentSize--;
										user.setScore(user.getScore()+30);
									}
								}
							}
							}
							brick.setXpos(-100);
							brick.setYpos(-100);
							this.currentSize--;
							user.setScore(user.getScore()+50);
						}	
						
					}
					
				}
		for(int i=0; i<wrapperBrickList.size(); i++) {
			
			Brick brick=wrapperBrickList.get(i);
			
			if(laser.getX()>brick.getXpos() && laser.getX()<brick.getXpos()+ brick.getLength()) {
				
				if(laser.getY() > brick.getYpos()- 8 && laser.getY() < brick.getYpos() + 8){
					
					this.powerup().get(i).setHit(true);
					
					brick.setXpos(-100);
					brick.setYpos(-100);
					this.currentSize--;
					user.setScore(user.getScore()+30);
				}
				
				if(laser.getY() > brick.getYpos()+brick.getWidth()- 8 && laser.getY()< brick.getYpos()+brick.getWidth() + 8){
					this.powerup().get(i).setHit(true);
					
					brick.setXpos(-100);
					brick.setYpos(-100);
					this.currentSize--;
					user.setScore(user.getScore()+30);
				}	
				
			}
			
			if(laser.getY()>brick.getYpos() && laser.getY() <brick.getYpos()+ brick.getWidth()) {
				
				if(laser.getX() > brick.getXpos()- 8 && laser.getX() < brick.getXpos() + 8){
					this.powerup().get(i).setHit(true);
					
					brick.setXpos(-100);
					brick.setYpos(-100);
					this.currentSize--;
					user.setScore(user.getScore()+30);
				}
				
				if(laser.getX() > brick.getXpos()+brick.getLength()- 8 && laser.getX() < brick.getXpos()+brick.getLength() + 8){
					this.powerup().get(i).setHit(true);
					
					brick.setXpos(-100);
					brick.setYpos(-100);
					this.currentSize--;
					user.setScore(user.getScore()+30);
				}	
				
			}
		}

		//alien 

		if(laser.getX() >alien.getXpos() && laser.getX() <alien.getXpos()+ alien.getLength()) {
			
			if(laser.getY() > alien.getYpos()- 8 && laser.getY() < alien.getYpos() + 8){
				alien.setXpos(-10000000);
				alien.setYpos(-10000000);
				alien.setAppeared(false);
				alien.setStatus(4);
				alien.setDir(0);
			
			}
			
			if(laser.getY() > alien.getYpos()+alien.getWidth()- 8 && laser.getY() < alien.getYpos()+alien.getWidth() + 8){
				alien.setXpos(-100);
				alien.setYpos(-100);
				alien.setAppeared(false);
				alien.setStatus(4);

			}	
			
			}

		if(laser.getY() >alien.getYpos() && laser.getY() <alien.getYpos()+ alien.getWidth()) {
			
			if(laser.getX() > alien.getXpos()- 8 && laser.getX() < alien.getXpos() + 8){
				alien.setXpos(-100);
				alien.setYpos(-100);
				alien.setAppeared(false);
				alien.setStatus(4);

			}
			
			if(laser.getX() > alien.getXpos()+alien.getLength()- 8 && laser.getX() < alien.getXpos()+alien.getLength() + 8){
				alien.setXpos(-100);
				alien.setYpos(-100);
				alien.setAppeared(false);
				alien.setStatus(4);

			}	
			
		}
		
	}
}

	
public String useMagnet() {
	
	if(pocket[0]>0) {

		
	if(p.isMagnet()) {
		p.setMagnet(false);
		return "default";
	}else {
		pocket[0]=pocket[0]-1;
		p.setMagnet(true);

		return "magnet";
	}
	}else {
		p.setMagnet(false);
		return "default";
	}
	
}

public String useChemicalBall() {
	
	if(pocket[1]>0) {
	
	if(b.isChemical()) {
		b.setChemical(false);
		return "default";
	}else {
		b.setChemical(true);
		pocket[1]=pocket[1]-1;
		return "chemical";
	}
	
	}else {
		b.setChemical(false);
		return "default";
	}
}

	
	public int getBrickX(Brick br) {
		return br.getXpos();
	}
	
	public int getBrickY(Brick br) {
		return br.getYpos();
	}
	


	public int[] getxPositions() {
		return xPositions;
	}

	public int[] getyPositions() {
		return yPositions;
	}

	public Paddle getP() {
		return p;
	}

	public Ball getB() {
		return b;
	}

	public Player getUser() {
		return user;
	}

	public int getNumberBrick() {
		return sbNumber;
	}

	public void setNumberBrick(int numberBrick) {
		this.sbNumber = numberBrick;
	}
	
	
	public int[] getPaddleXPosition() {
		return p.getxPositions();
	}
	
	public int[] getPaddleYPosition() {
		return p.getyPositions();
	}

	public Alien gameAlien() {
		return alien;
	}
	
	public void moveAlien() {
		if(alien.getType()=="DrunkAlien" && alien.getStatus()==2 &&(alien.getXpos() > playground.getLeftbound() || alien.getXpos() <playground.getRightbound())&&b.getVelocity()!=0) {
			if(b.getxPosition()>alien.getXpos()+alien.getLength()&& b.getyPosition()>alien.getYpos()+alien.getWidth()&&b.getxDir()==1){
				alien.setDir(1);
			}
			else if(b.getxPosition()<alien.getXpos()+alien.getLength()&& b.getyPosition()>alien.getYpos()+alien.getWidth()&&b.getxDir()==-1){
				alien.setDir(-1);
			}
			else if(b.getxPosition()>alien.getXpos()+alien.getLength()&& b.getyPosition()<alien.getYpos()&&b.getxDir()==1){
				alien.setDir(-1);
			}
			else if(b.getxPosition()<alien.getXpos()+alien.getLength()&& b.getyPosition()<alien.getYpos()+alien.getWidth()&&b.getxDir()==-1){
				alien.setDir(1);
			}
			
		
		}
		if(alien.getXpos()<playground.getLeftbound()-5){
			alien.setDir(0);
		}
		
		alien.move();
		
	}
	
	public int getScore() {
		return user.getScore();
	}
	
	public void activateLaserGun() {
		if(p.getStatus()==0 && this.activeLaserGun==false) {
			user.setAmmo(5);
			lasergun.get(0).setX(p.getxPositions()[0]);
			lasergun.get(1).setX(p.getxPositions()[1]-4);
			lasergun.get(0).setY(p.getyPositions()[0]-9);
			lasergun.get(1).setY(p.getyPositions()[0]-9);
			
			lasergun.get(0).setVelocity(0);
			lasergun.get(1).setVelocity(0);
			lasergun.get(0).setFired(false);
			lasergun.get(1).setFired(false);
			this.activeLaserGun=true;
		}
	}
	
	public void useLaserGun() {
		if(this.activeLaserGun==true) {
			if(user.getAmmo()==5) {
				lasergun.get(0).setVelocity(1);
				lasergun.get(1).setVelocity(1);
				lasergun.get(0).setFired(true);
				lasergun.get(1).setFired(true);
				
				lasergun.get(2).setX(p.getxPositions()[0]);
				lasergun.get(3).setX(p.getxPositions()[1]-4);
				lasergun.get(2).setY(491);
				lasergun.get(3).setY(491);
				lasergun.get(2).setVelocity(0);
				lasergun.get(3).setVelocity(0);
				lasergun.get(2).setFired(false);
				lasergun.get(3).setFired(false);
				
				user.setAmmo(user.getAmmo()-1);
			} else if(user.getAmmo()==4) {
				lasergun.get(2).setVelocity(1);
				lasergun.get(3).setVelocity(1);
				lasergun.get(2).setFired(true);
				lasergun.get(3).setFired(true);
				
				lasergun.get(4).setX(p.getxPositions()[0]);
				lasergun.get(5).setX(p.getxPositions()[1]-4);
				lasergun.get(4).setY(491);
				lasergun.get(5).setY(491);
				lasergun.get(4).setVelocity(0);
				lasergun.get(5).setVelocity(0);
				lasergun.get(4).setFired(false);
				lasergun.get(5).setFired(false);
				
				user.setAmmo(user.getAmmo()-1);
			} else if(user.getAmmo()==3) {
				lasergun.get(4).setVelocity(1);
				lasergun.get(5).setVelocity(1);
				lasergun.get(4).setFired(true);
				lasergun.get(5).setFired(true);
				
				lasergun.get(6).setX(p.getxPositions()[0]);
				lasergun.get(7).setX(p.getxPositions()[1]-4);
				lasergun.get(6).setY(491);
				lasergun.get(7).setY(491);
				lasergun.get(6).setVelocity(0);
				lasergun.get(7).setVelocity(0);
				lasergun.get(6).setFired(false);
				lasergun.get(7).setFired(false);
				
				user.setAmmo(user.getAmmo()-1);
			} else if(user.getAmmo()==2) {
				lasergun.get(6).setVelocity(1);
				lasergun.get(7).setVelocity(1);
				lasergun.get(6).setFired(true);
				lasergun.get(7).setFired(true);
				
				lasergun.get(8).setX(p.getxPositions()[0]);
				lasergun.get(9).setX(p.getxPositions()[1]-4);
				lasergun.get(8).setY(491);
				lasergun.get(9).setY(491);
				lasergun.get(8).setVelocity(0);
				lasergun.get(9).setVelocity(0);
				lasergun.get(8).setFired(false);
				lasergun.get(9).setFired(false);
				
				user.setAmmo(user.getAmmo()-1);
			} else if(user.getAmmo()==1) {
				lasergun.get(8).setVelocity(1);
				lasergun.get(9).setVelocity(1);
				lasergun.get(8).setFired(true);
				lasergun.get(9).setFired(true);
				this.activeLaserGun=false;
			}else {
				this.activeLaserGun=false;
			}
		}
	}
	
	public int laserY(int i) {
		lasergun.get(i).setY(lasergun.get(i).getY()-lasergun.get(i).getVelocity());
		return lasergun.get(i).getY();
	}
	
	public int laserX(int i) {
		return lasergun.get(i).getX();
	}
	
	public ArrayList<LaserGun> lasergunlist(){
		return this.lasergun;
	}
	
	public void activateTallerPaddle() {

		if(!p.isTaller()&&  p.getStatus()==0) {
		
			int[] newPositions= {p.getxPositions()[0]-50, p.getxPositions()[1]+50, p.getxPositions()[2]+50, p.getxPositions()[3]-50};
			p.setxPositions(newPositions);
			p.setLength(p.getxPositions()[1]-p.getxPositions()[0]);
			p.setCopyx(newPositions);
			
			p.setTaller(true);
			
		}else if(p.isTaller()&& p.getStatus()==0){
			int[] newPositions= {p.getxPositions()[0]+50, p.getxPositions()[1]-50, p.getxPositions()[2]-50, p.getxPositions()[3]+50};
			p.setxPositions(newPositions);
			p.setLength(p.getxPositions()[1]-p.getxPositions()[0]);
			
			p.setCopyx(newPositions);
			p.setTaller(false);
			
		}else {
			return;
		}
		
		for(int i=0; i<lasergun.size(); i++) {
			if(i%2==0) {
				lasergun.get(i).setX(p.getxPositions()[0]);
			}else {
				lasergun.get(i).setX(p.getxPositions()[1]-4);
			}
		}
	}
	
	public void alien() {
		alien.appear();
		alien.setStatus(4);
		alien.setAppeared(true);
	}
	
	public void updateSize() {
		int size=0;
		for(int i=0; i<simpleBrickList.size(); i++) {
			if(simpleBrickList.get(i).getYpos()>0 && simpleBrickList.get(i).getXpos()>0 )
				size++;
		}
		for(int i=0; i<halfMetalBrickList.size(); i++) {
			if(halfMetalBrickList.get(i).getYpos()>0 )
				size++;
		}
		for(int i=0; i<mineBrickList.size(); i++) {
			if(mineBrickList.get(i).getYpos()>0)
				size++;
		}
		for(int i=0; i<wrapperBrickList.size(); i++) {
			if(wrapperBrickList.get(i).getYpos()>0)
				size++;
		}
		this.currentSize=size;
	}
	
}
