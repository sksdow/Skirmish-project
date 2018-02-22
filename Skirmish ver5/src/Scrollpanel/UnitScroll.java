package Scrollpanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import GameInterface.*;
import Units.*;
import Utilities.*;

import javax.swing.*;

public class UnitScroll extends JScrollPane implements ComponentListener{
	JPanel view;
	SButtonGroup Units;
	private DataInterface DI;
	public UnitScroll(){
		view=new JPanel();
		GridBagConstraints c1=new GridBagConstraints();
		view.setLayout(new GridBagLayout());
		c1.weightx=1;
		c1.weighty=1;
		c1.fill=c1.BOTH;
		
		Units = new SButtonGroup();
		
		c1.gridy=0;
		ImageIcon archer = new ImageIcon(getClass().getResource("Archer.png"));
		JToggleButton unit1=new PaintButton(archer);
		unit1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit1.isSelected()){
					DI.setTempUnit(new Archer(0));}
			}
		});
		Units.addButton(unit1,"archer");
		view.add(unit1,c1);
		c1.gridy=1;
		
		ImageIcon footsoldier = new ImageIcon(getClass().getResource("Footsoldier.png"));
		JToggleButton unit2=new PaintButton(footsoldier);
		unit2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit2.isSelected()){
					DI.setTempUnit(new FootSoldier(0));}
			}
		});
		Units.addButton(unit2,"footsoldier");
		view.add(unit2,c1);
		c1.gridy=2;
		
		ImageIcon spearman = new ImageIcon(getClass().getResource("Spearman.png"));
		JToggleButton unit3=new PaintButton(spearman);
		unit3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit3.isSelected()){
					DI.setTempUnit(new Spearman(0));}
			}
		});
		Units.addButton(unit3,"spearman");
		view.add(unit3,c1);
		c1.gridy=3;
		
		ImageIcon hunter = new ImageIcon(getClass().getResource("Hunter.png"));
		JToggleButton unit4=new PaintButton(hunter);
		unit4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit4.isSelected()){
					DI.setTempUnit(new Hunter(0));}
			}
		});
		Units.addButton(unit4,"hunter");
		view.add(unit4,c1);
		c1.gridy=4;
		
		ImageIcon berserker = new ImageIcon(getClass().getResource("Berserker.png"));
		JToggleButton unit5=new PaintButton(berserker);
		unit5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit5.isSelected()){
					DI.setTempUnit(new Berserker(0));}
			}
		});
		Units.addButton(unit5,"berserker");
		view.add(unit5,c1);
		c1.gridy=5;
		
		ImageIcon warrior = new ImageIcon(getClass().getResource("Warrior.png"));
		JToggleButton unit6=new PaintButton(warrior);
		unit6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit6.isSelected()){
					DI.setTempUnit(new Warrior(0));}
			}
		});
		Units.addButton(unit6,"warrior");
		view.add(unit6,c1);
		c1.gridy=6;
		
		ImageIcon guardian = new ImageIcon(getClass().getResource("Guardian.png"));
		JToggleButton unit7=new PaintButton(guardian);
		unit7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit7.isSelected()){
					DI.setTempUnit(new Guardian(0));}
			}
		});
		Units.addButton(unit7,"guardian");
		view.add(unit7,c1);
		c1.gridy=7;
		
		ImageIcon rider = new ImageIcon(getClass().getResource("Rider.png"));
		JToggleButton unit8=new PaintButton(rider);
		unit8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit8.isSelected()){
					DI.setTempUnit(new Rider(0));}
			}
		});
		Units.addButton(unit8,"rider");
		view.add(unit8,c1);
		c1.gridy=8;
		
		ImageIcon lancer = new ImageIcon(getClass().getResource("Lancer.png"));
		JToggleButton unit9=new PaintButton(lancer);
		unit9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit9.isSelected()){
					DI.setTempUnit(new Lancer(0));}
			}
		});
		Units.addButton(unit9,"lancer");
		view.add(unit9,c1);
		c1.gridy=9;
		
		ImageIcon apprentice = new ImageIcon(getClass().getResource("Apprentice.png"));
		JToggleButton unit10=new PaintButton(apprentice);
		unit10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(unit10.isSelected()){
					DI.setTempUnit(new Apprentice(0));}
			}
		});
		Units.addButton(unit10,"apprentice");
		view.add(unit10,c1);

		this.getViewport().add(view);
		this.addComponentListener(this);
	}
	
	public void updateDI(DataInterface d){
		DI=d;
	}

	public void componentHidden(ComponentEvent arg0) {}

	public void componentMoved(ComponentEvent arg0) {}

	public void componentResized(ComponentEvent arg0) {
		Dimension newSize=new Dimension(getWidth()*5/6,getHeight()*2);
		view.setPreferredSize(newSize);
	}

	public void componentShown(ComponentEvent arg0) {}

}
