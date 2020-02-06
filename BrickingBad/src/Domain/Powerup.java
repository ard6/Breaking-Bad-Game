package Domain;

public interface Powerup {
	
	
	 void usePowerup();
	 int getXpos();
	 int getYpos();
	 int getRadii();
	 String getType();
	 Boolean getIsActive();
	 void setXpos(int x);
	 void setYpos(int y);
	 void setRadii(int radii);
	 void setType(String type);
	 void setIsActive(Boolean isActive);
	 void move();
	 boolean isHit();
	 void setHit(boolean isHit);
	
}
