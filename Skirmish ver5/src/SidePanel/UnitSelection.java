package SidePanel;
import java.awt.*;
import javax.swing.*;

import GameInterface.DataInterface;
import Units.*;
import Utilities.ResizePanel;
public class UnitSelection extends JPanel{
	private UnitInfo unit;
	private GridBagConstraints c;
	private Resource rsc;
	private DataInterface DI;
	public UnitSelection(){
		setBackground(Color.BLACK);
		setLayout(new GridBagLayout());
		
		c=new GridBagConstraints();
		c.fill=c.BOTH;
		c.weightx=1;c.weighty=.4;
		
		GObject u = new Apprentice(0);
		c.gridy=0;
		unit = new UnitInfo(u);
		add(unit,c);
		
		c.gridy=1;c.weighty=.6;
		rsc=new Resource();
		add(rsc,c);
		
	}
	
	public void upDateUnit(GObject u){
		remove(unit);
		c=new GridBagConstraints();
		c.fill=c.BOTH;
		c.weightx=1;c.weighty=.4;
		c.gridy=0;
		//System.out.println(u.getTeam());
		unit = new UnitInfo(u);
		add(unit,c);
		revalidate();
	}
	
	public Resource getResource(){
		return rsc;
	}
	
	public void takeDamage(int dmg){
		
	}

	public void updateDI(DataInterface d) {
		DI=d;
		
	}
}
