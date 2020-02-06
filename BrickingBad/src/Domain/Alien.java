package Domain;

public interface Alien {

	int getXpos();
	int getYpos();
	void setXpos(int X);
	void setYpos(int Y);
	int getLength();
	int getWidth();
	String getType();
	void setType(String type);
	void move();
	void disappear();
	void appear();
	void perform();
	int getStatus();
	void setStatus(int status);
	boolean isAppeared();
	void setAppeared(boolean appear);
	
	int getDir();
	void setDir(int dir);
}
