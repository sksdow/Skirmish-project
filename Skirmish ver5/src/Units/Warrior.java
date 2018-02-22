package Units;

import javax.swing.ImageIcon;

public class Warrior extends Unit {
	
	// Load the image that all units of this type will use when the class is loaded.
	private static ImageIcon icon = new ImageIcon(Warrior.class.getResource("Warrior.png"));
	
	// Stat Template:
	private static final int ATK = 3;
	private static final int DEF = 3;
	private static final int moveCost = 4;
	private static final int populationCost = 3;
	private static final int range = 1;
	
	public Warrior(int team) {
		setTeam(team);
		maxHP = 12;
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
		return "Warrior";
	}

}
