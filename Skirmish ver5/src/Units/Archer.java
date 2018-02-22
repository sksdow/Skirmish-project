package Units;

import javax.swing.ImageIcon;

public class Archer extends Unit {
	
	// Load the image that all units of this type will use when the class is loaded.
	private static ImageIcon icon = new ImageIcon(Archer.class.getResource("Archer.png"));
	
	// Stat Template:
	private static final int ATK = 1;
	private static final int DEF = 1;
	private static final int moveCost = 3;
	private static final int populationCost = 1;
	private static final int range = 3;
	
	public Archer(int team) {
		setTeam(team);
		maxHP = 3;
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
		return "Archer";
	}

}


