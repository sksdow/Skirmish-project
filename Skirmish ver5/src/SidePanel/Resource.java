package SidePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GameInterface.DataInterface;
import Utilities.PaintButton;
import Utilities.ResizableText;
import Utilities.SButtonGroup;

public class Resource extends JPanel{
	private GridBagConstraints c;
	private SButtonGroup mode;
	private DataInterface DI;
	private ResizableText M;
	private ResizableText P;
	public Resource(){
		setBackground(Color.black);
		setLayout(new GridBagLayout());
		c=new GridBagConstraints();
		
		c.fill=c.BOTH;
		c.weightx=1;
		c.weighty=.25;
		c.gridy=0;
		c.gridx=0;
		c.gridwidth=2;
		c.insets=new Insets(10,0,0,0);
		M = new ResizableText("Energy Left: "+00, Color.RED);
		add(M,c);
		
		c.fill=c.BOTH;
		c.weightx=1;
		c.weighty=.25;
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=2;
		c.insets=new Insets(0,0,0,0);
		P = new ResizableText("Pop Remain : "+00, Color.RED);
		add(P,c);
		
		c.fill=c.BOTH;
		c.weightx=1;
		c.weighty=.25;
		c.insets=new Insets(0,0,0,0);
		c.gridwidth=1;
		c.gridy=2;
		c.gridx=0;
		c.insets=new Insets(10,10,0,10);
		Image a= ResizableText.createImage("Move", Color.white,Color.darkGray);
		JToggleButton mo = new PaintButton(a);
		mo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(mo.isSelected()){
					if(DI.getPhase()==4){
						DI.setPhase(2);
					}
					else if(DI.getPhase()==5){
						DI.setPhase(3);
					}
					DI.resetMove();
				}
				
			}
		});
		add(mo,c);
		
		c.gridx=1;
		a= ResizableText.createImage("Attack", Color.white,Color.darkGray);
		JToggleButton at = new PaintButton(a);
		at.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(at.isSelected()){
					if(DI.getPhase()==2){
						DI.setPhase(4);
					}
					else if(DI.getPhase()==3){
						DI.setPhase(5);
					}
					DI.resetMove();
				}
				
			}
		});
		add(at,c);
		
		c.weightx=.5;
		c.weighty=.25;
		c.gridx=0;c.gridy=3;c.gridwidth=1;
		c.insets=new Insets(10,10,10,10);
		a= ResizableText.createImage("Finish", Color.white,Color.darkGray);
		JToggleButton et = new PaintButton(a);
		et.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(et.isSelected()){
					if(DI.getPhase()==2||DI.getPhase()==4){
						DI.setTempNrg(DI.getPlayer2Nrg());
						DI.setTempPop(DI.getPlayer2Pop());
						DI.setPhase(3);
					}
					else{
						DI.setTempNrg(DI.getPlayer1Nrg());
						DI.setTempPop(DI.getPlayer1Pop());
						DI.setPhase(2);
					}
					mo.setSelected(true);
					DI.updatePlayerPop(DI.getTempPop());
					DI.updatePlayerNrg(DI.getTempNrg());
					DI.resetMove();
					et.setSelected(false);
				}
				
			}
		});
		add(et,c);
		
		c.weightx=.5;
		c.weighty=.25;
		c.gridx=1;c.gridy=3;c.gridwidth=1;
		c.insets=new Insets(10,10,10,10);
		a= ResizableText.createImage("Forfeit", Color.white,Color.darkGray);
		JToggleButton ff = new PaintButton(a);
		ff.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ff.isSelected()){
					if(DI.getPhase()==2||DI.getPhase()==4){
						DI.setVictory(1);}
					else
						DI.setVictory(0);
					ff.setSelected(false);
				}	
			}
		});
		add(ff,c);
		
		mode=new SButtonGroup();
		mode.addButton(mo, "move");
		mode.addButton(at, "attack");
		
	}
	
	public String getSelectedMode(){
		return mode.getSelected();
	}
	
	public void updateDI(DataInterface d){
		DI=d;
	}
	
	public void setNRG(int m){
		M.setText("Energy Left : "+m);
	}
	public void setPOP(int p){
		P.setText("Pop Remain : "+p);
	}
	
}
