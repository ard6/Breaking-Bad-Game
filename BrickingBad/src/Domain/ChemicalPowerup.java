package Domain;

public class ChemicalPowerup implements Powerup{
	private int x;
	private int y;
	private String type;
	private Boolean isActive;
	private int radii;
	private boolean isHit;

	
	

	public ChemicalPowerup(int x, int y,int radii, String type, Boolean isActive, Boolean isHit) {
		
		this.x = x;
		this.y = y;
		this.radii=radii;
		this.type = type;
		this.isActive = isActive;
		this.setHit(isHit);
	}

	@Override
	public int getXpos() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getYpos() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public Boolean getIsActive() {
		// TODO Auto-generated method stub
		return isActive;
	}

	@Override
	public void setXpos(int x) {
		this.x=x;
		
	}

	@Override
	public void setYpos(int y) {
		// TODO Auto-generated method stub
		this.y=y;
		
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type=type;
		
	}

	@Override
	public void setIsActive(Boolean isActive) {
		// TODO Auto-generated method stub
		this.isActive=isActive;
		
	}

	@Override
	public void usePowerup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRadii() {
		// TODO Auto-generated method stub
		return radii;
	}

	@Override
	public void setRadii(int radii) {
		// TODO Auto-generated method stub
		this.radii=radii;
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.setYpos(this.getYpos()+1);
		
		
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	
	
}
