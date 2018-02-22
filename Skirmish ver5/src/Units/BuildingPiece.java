package Units;


import javax.swing.ImageIcon;

public class BuildingPiece implements GObject {
	
	private Building parent;
	private int id;
	
	public BuildingPiece(Building parent, int id) {
		this.parent = parent;
		this.id = id;
	}
	
	// Implementation Methods
	public int getMaxHP() {
		return parent.maxHP;
	}
	
	public int getRemainingHP() {
		return parent.remainingHP;
	}
	
	public int getAttack() {
		return 0;
	}
	
	public int getDefense() {
		return 0;
	}
	
	public int getMoveCost() {
		return Integer.MAX_VALUE;
	}
	
	public int getPopulationCost() {
		return 0;
	}
	
	public int getRange() {
		return 0;
	}
	
	public int getTeam() {
		return parent.team;
	}
	
	public void setTeam(int team) {
		if (team != BLUE_TEAM && team != RED_TEAM)
			System.out.println("Invalid team number inputted to building object.");
		parent.team = team;
	}
	
	public void takeDamage(int dmg) {
		parent.takeDamage(dmg);
	}
	
	public String getName() {
		return parent.getName();
	}
	
	public ImageIcon getIcon() {
		return parent.cropImage(id);
	}
	
	public Building getParent() {
		return parent;
	}

	
	public int getId(){
		return id;
	}

}
