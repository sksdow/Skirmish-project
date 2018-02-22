package Units;

import javax.swing.ImageIcon;

public interface GObject {
	
	public static final int BLUE_TEAM = 0;
	public static final int RED_TEAM = 1;
	
	
	// ACCESSORS
	int getMaxHP();
	int getRemainingHP();
	int getAttack();  			// Buildings have a default value of 0.
	int getDefense(); 			// Buildings have a default value of 0.
	int getMoveCost(); 			// Buildings have a default value of Integer.MAX_VALUE.
	int getPopulationCost(); 	// Buildings have a default value of 0.
	int getRange(); 			// Buildings have a default value of 0.
	String getName();
	int getTeam();
	ImageIcon getIcon();
	
	// MODIFIERS
	void setTeam(int t);
	void takeDamage(int damage);
	
}
