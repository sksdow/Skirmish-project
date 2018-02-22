package SidePanel;

import javax.swing.*;

import GameInterface.DataInterface;
import Scrollpanel.UnitScroll;
import Units.Archer;
import Utilities.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitSpawning extends JPanel{
	private UnitScroll us;
	private JToggleButton finish;
	private DataInterface DI;
	private ResizableText Pop;
	private BuildingSpawning buildings;
	public UnitSpawning(){
		us = new UnitScroll();
		JPanel Resource = new JPanel();
		Resource.setBackground(Color.black);
		Resource.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		Pop=new ResizableText("temp", Color.RED);
		c.fill=c.BOTH;c.weightx=1;c.weighty=1;
		Resource.add(Pop,c);
		Image a= ResizableText.createImage("Finish", Color.white,Color.darkGray);
		finish = new PaintButton(a);
		//JPanel empty = new JPanel
		setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill=c1.BOTH;
		c1.gridy=2;
		c1.weighty=.7;
		c1.weightx=1;
		add(us,c1);
		
		c1.gridy=0;
		c1.weighty=.1;
		add(Resource,c1);
		
		c1.gridy=1;
		buildings = new BuildingSpawning();
		buildings.updateDI(DI);
		add(buildings,c1);
		
		c1.gridy=3;
		finish.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(finish.isSelected()){
					if(DI.getPhase()==0){
						DI.setPhase(1);
						DI.setPlayer1Pop(DI.getPlayer1Pop()-DI.getTempPop());
						DI.setTempPop(DI.getPlayer2Pop());
						Pop.setText("Population Remain : "+DI.getTempPop());
						DI.clearSpawnHighLight();
						DI.spawnHighlight();
						DI.setTempUnit(new Archer(1));
						if(DI.Bbutton1!=null){
							DI.Bbutton1.setSelected(false);
							DI.Bbutton1.setVisible(true);
							DI.Bbutton1.repaint();}
						if(DI.Bbutton2!=null)
						DI.Bbutton2.setVisible(true);
						if(DI.Bbutton3!=null)
						DI.Bbutton3.setVisible(true);
					}
					else{
						DI.clearSpawnHighLight();
						SidePanel temp1=((SidePanel) getParent());
						temp1.loadPanel(1);
						DI.setPlayer2Pop(DI.getPlayer2Pop()-DI.getTempPop());
						DI.setTempNrg(DI.getPlayer1Nrg());
						DI.updatePlayerNrg(DI.getTempNrg());
						DI.setTempPop(DI.getPlayer1Pop());
						DI.updatePlayerPop(DI.getTempPop());
						DI.setPhase(2);
					}
					finish.setSelected(false);
				}
				
			}
		});
		add(finish,c1);
		
		
	}
	
	public void updateDI(DataInterface d){
		DI=d;
	}
	
	public UnitScroll getUnitScroll(){
		return us;
	}
	
	public BuildingSpawning getBuilding(){
		return buildings;
	}
	
	public void updatePop(int p){
		Pop.setText("Population Remain : "+p);
	}
	
}
