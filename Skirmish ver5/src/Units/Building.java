package Units;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public abstract class Building implements GObject {

	protected int maxHP;
	protected int remainingHP;
	protected int team;
	protected BuildingPiece[] bp;
	
	protected ImageIcon i;
	
	public int getMaxHP() {
		return maxHP;
	}
	
	public int getRemainingHP() {
		return remainingHP;
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
		return team;
	}
	
	public ImageIcon getIcon() {
		return i;
	}
	
	public void setTeam(int team) {
		this.team = team;
	}
	
	public void takeDamage(int dmg) {
		remainingHP -= dmg;
	}
	
	public ImageIcon cropImage(int id) {
		Image img = i.getImage();
		int w = img.getWidth(null) / 2;
		int h = img.getHeight(null) / 2;
		
		int x = 0, y = 0;
		
		if (id == 0) {
			x = 0;
			y = 0;
		} else if (id == 1) {
			x = 1;
			y = 0;
		} else if (id == 2) {
			x = 0;
			y = 1;
		} else if (id == 3) {
			x = 1;
			y = 1;
		}
		
		BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = result.getGraphics();
		g.drawImage(img, 0, 0, w, h, x*w, y*h, (x+1)*w, (y+1)*h, null);
		g.dispose();
		
		
		
		return new ImageIcon(result);
	}
	
	public BuildingPiece getPiece(int id) {
		if (id >= bp.length || id < 0)
			return null;
		return bp[id];
	}
	
	public abstract String getName();
	
}
