package Units;

import javax.swing.ImageIcon;

public class Spearman extends Unit {
	
	// Load the image that all units of this type will use when the class is loaded.
	private static ImageIcon icon = new ImageIcon(Spearman.class.getResource("Spearman.png"));
	
	// Stat Template:
	private static final int ATK = 2;
	private static final int DEF = 2;
	private static final int moveCost = 3;
	private static final int populationCost = 1;
	private static final int range = 2;
	
	public Spearman(int team) {
		setTeam(team);
		maxHP = 7;
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
		return "Spearman";
	}

}
