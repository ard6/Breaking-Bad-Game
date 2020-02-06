package Domain;

public class LaserGun {
	
	private int x;
	private int y;
	private int velocity;
	private boolean isFired;
	
	public LaserGun(int x, int y, int velocity, boolean isFired) {
		this.x=x;
		this.y=y;
		this.velocity=velocity;
		this.isFired=isFired;
	}
	
	public void moveLaser() {
		this.y=this.y-this.velocity;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public boolean isFired() {
		return isFired;
	}

	public void setFired(boolean isFired) {
		this.isFired = isFired;
	}
	
}
