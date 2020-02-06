import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Domain.Ball;
import Domain.Brick;
import Domain.BrickFactory;
import Domain.Paddle;
import Domain.Player;
import Domain.SimpleBrick;

class testing {
 Paddle p;
 Ball b;
 SimpleBrick brick;
 BrickFactory factory;
 Player player;

// 	@Before
// 	public void setUp() {
// 		int paddleX[]={346,446,446,346};
// 		int paddleY[]={500,500,508,508};
// 		p= new Paddle(20, 100, 2, 0, paddleX,paddleY, 346, 530, 0);
// 		b= new Ball(0,0,0,396,491,8);
// 		brick=new SimpleBrick(600,300,40,80);
// 		factory=new BrickFactory();
// 		player=Player.getInstance();
//	 
// 	}
	@Test
	void testBallmoveX() {
		
		b= new Ball(2,0,0,396,491,8);
 		//Testing moveX method of Ball Class -> Glass Box Testing
		int firstBallX= b.getxPosition();
		b.moveX(1);
		
		assertEquals(398,firstBallX+2);
		b.repOk();
		
	}
	
	@Test
	void testPaddleMove() {
		int paddleX[]={346,446,446,346};
 		int paddleY[]={500,500,508,508};
 		p= new Paddle(20, 100, 8, 0, paddleX,paddleY, 346, 530, 0);
 		int[] x1 = p.getxPositions();
 		int x= x1[0];
 		p.move(1, 5);
 		
 		assertEquals(351,x+5);
 		p.repOk();
	}
	@Test
	void TestBrickFactory() {
		factory=new BrickFactory();
		Brick x = new SimpleBrick(600,300,40,80);
		Brick y = factory.createBrick("simple", 600, 300, 40, 80);
		assertSame(80,y.getLength());
		
	}
	@Test
	void TestSimpleBrick() {
		brick=new SimpleBrick(600,300,40,80);
		brick.setXpos(500);
		assertEquals(500,brick.getXpos());
	}
	@Test
	void TestPlayer() {
		player=Player.getInstance();
		player.setScore(6500);
		assertEquals(6500,player.getScore());
		assertEquals(3,player.getLife());
		player.repOk();
	}
	

}
