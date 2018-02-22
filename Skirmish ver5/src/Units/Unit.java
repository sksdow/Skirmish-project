package Units;

import javax.swing.ImageIcon;

public abstract class Unit implements GObject {
	
	// All of these are set in the concrete class constructors.
	protected int maxHP;
	protected int remainingHP;
	private int team;
	private int building;
	
	// Health Utilities:
	public int getMaxHP() {
		return maxHP;
	}
	
	public int getRemainingHP() {
		return remainingHP;
	}
	
	public void takeDamage(int dmg) {
		remainingHP = remainingHP - dmg;
	}
	
	
	// Team Utilities:
	public int getTeam() {
		return team;
	}
	
	public void setTeam(int t) {
		if (t != BLUE_TEAM && t != RED_TEAM)
			System.out.println("Invalid team number inputted to unit object.");
		team = t; // Set regardless but warn for debugging purposes.
	}
	
	public int getbuilding(){
		return building;
	}
	
	public void setbuilding(int i){
		building=i;
	}
	
	
	
	
	// Abstract Methods:
	public abstract int getAttack();
	public abstract int getDefense();
	public abstract int getMoveCost();
	public abstract int getPopulationCost();
	public abstract int getRange();
	public abstract String getName();
	public abstract ImageIcon getIcon();
	
}