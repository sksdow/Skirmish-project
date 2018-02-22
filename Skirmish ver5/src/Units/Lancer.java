package Units;

import javax.swing.ImageIcon;

public class Lancer extends Unit {
	
	// Load the image that all units of this type will use when the class is loaded.
	private static ImageIcon icon = new ImageIcon(Lancer.class.getResource("Lancer.png"));
	
	// Stat Template:
	private static final int ATK = 2;
	private static final int DEF = 2;
	private static final int moveCost = 2;
	private static final int populationCost = 4;
	private static final int range = 2;
	
	public Lancer(int team) {
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
		return "Lancer";
	}

}
