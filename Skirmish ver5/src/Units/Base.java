package Units;

import javax.swing.ImageIcon;


public class Base extends Building {
	
	private int building;
	
	public Base(int team) {
		maxHP = 30;
		remainingHP = maxHP;
		this.team = team;
		bp = new BuildingPiece[4];
		bp[0] = new BuildingPiece(this, 0);
		bp[1] = new BuildingPiece(this, 1);
		bp[2] = new BuildingPiece(this, 2);
		bp[3] = new BuildingPiece(this, 3);
		
		i = new ImageIcon(getClass().getResource("Base.png"));
	}
	
	public String getName() {
		return "Base";
	}

	
}
