package Units;

import javax.swing.ImageIcon;

public class Rider extends Unit {
	
	// Load the image that all units of this type will use when the class is loaded.
	private static ImageIcon icon = new ImageIcon(Rider.class.getResource("Rider.png"));
	
	// Stat Template:
	private static final int ATK = 2;
	private static final int DEF = 2;
	private static final int moveCost = 1;
	private static final int populationCost = 4;
	private static final int range = 1;
	
	public Rider(int team) {
		setTeam(team);
		maxHP = 13;
		remainingHP = maxHP;
	}
	
	public int getAttack() {
		return ATK;
	}
	
	public int getDefense() {
		return DEF;
	}
	
	public int getMoveCost() {
		return moveCost;
	}
	
	public int getPopulationCost() {
		return populationCost;
	}
	
	public int getRange() {
		return range;
	}
	
	public ImageIcon getIcon() {
		return icon;
	}
	
	public String getName() {
		return "Rider";
	}

}
