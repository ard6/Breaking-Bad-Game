package Domain;
/**
 * OVERVIEW: The one and only Player Object of the game Bricking Bad Game.
 * @author Team Monopoly
 *
 */
public class Player {
	private static Player instance = new Player();
	private int life=3;
	private int score=0;
	private int ammo=5;
	
	/**
	 * 
	 * Private constructor of Player Object. Singleton Pattern
	 * MODIFIES: This class.
	 */
	private Player() {
		
	}
	/**
	 * EFFECTS: Gets the only instance of the Player Object
	 * @return instance of this class
	 */
	public static Player getInstance() {
		return instance;
	}
	/**
	 * EFFECTS: Gets the life of this class.
	 * @return life of this class
	 */
	public int getLife() {
		return this.life;
	}
	/**
	 * MODIFIES: life property of the Player. 
	 * EFFECTS: Changes Ball's life.
	 * @param life
	 */
	public void setLife(int life) {
		this.life = life;
	}
	/**
	 * EFFECTS: Gets the score of this class.
	 * @return score of this class
	 */
	public int getScore() {
		return this.score;
	}
	/**
	 * MODIFIES: score property of the Player. 
	 * EFFECTS: Changes Ball's score.
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getAmmo() {
		return ammo;
	}
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	//Representation Invariant
	public void repOk() {
		assert this.score>=0;
		assert this.life<=3 || this.life>=0;
	}
	//Abstraction Function:
	//represents a player.
	@Override
	public String toString() {
		return "Player [life=" + life + ", score=" + score + "]";
	}
	
	
}
