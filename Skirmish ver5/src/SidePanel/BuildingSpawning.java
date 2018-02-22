package SidePanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GameInterface.DataInterface;
import Units.*;
import Utilities.*;

public class BuildingSpawning extends JPanel{
	private DataInterface DI;
	PaintButton camp1;
	PaintButton camp2;
	PaintButton base;
	public BuildingSpawning(){
		setBackground(Color.BLACK);
		Building campi = new Camp(0);
		Building basei = new Base(0);
		camp1 = new PaintButton((campi.getIcon()).getImage());
		camp1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(camp1.isSelected()){
					GObject temp = new Camp(0);
					DI.temp=DI.getTempUnit();
					DI.setTempUnit(temp);
					DI.Bbutton1=camp1;
				}
			}
		});
		
		camp2 = new PaintButton(((ImageIcon)campi.getIcon()).getImage());
		camp2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(camp2.isSelected()){
					GObject temp =new Camp(0);
					DI.temp=DI.getTempUnit();
					DI.setTempUnit(temp);
					DI.Bbutton2=camp2;
				}
			}
		});

		base = new PaintButton(((ImageIcon)basei.getIcon()).getImage());
		base.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(base.isSelected()){
					GObject temp =new Base(0);
					DI.temp=DI.getTempUnit();
					DI.setTempUnit(temp);
					DI.Bbutton3=base;
				}
			}
		});
		
		setLayout(new GridLayout(1,3));
		add(camp1);add(camp2);add(base);
		
		SButtonGroup g = new SButtonGroup();
		g.addButton(camp1, "1st camp");g.addButton(camp2, "2nd camp");g.addButton(base, "base");
		
		
	}
	
	public void updateDI(DataInterface d){
		DI=d;
	}

}
