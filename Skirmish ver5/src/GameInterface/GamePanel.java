package GameInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GameBoard.MapPanel;
import MainMenu.MainPanel;
import MainMenu.ParentPanel;
import SidePanel.SidePanel;
import Utilities.AspectRatio;
import Utilities.PaintButton;
import Utilities.ResizableText;
import Utilities.ResizePanel;

public class GamePanel extends ResizePanel {
	
	private SidePanel u;
	private MapWrapper w;
	private PaintButton main;
	public DataInterface DI;
	
	public GamePanel() {
		u = new SidePanel();
		w = new MapWrapper();
		u.setPreferredSize(getSize());
		w.setPreferredSize(getSize());
		
		DI=new DataInterface();
		DI.SP=u;
		DI.MP=w.getMapPanel();
		
		w.getMapPanel().updateDI(DI);
		u.getUnitSpawning().updateDI(DI);
		u.getUnitSpawning().getUnitScroll().updateDI(DI);
		u.getUnitSpawning().getBuilding().updateDI(DI);
		u.getUnitSelection().getResource().updateDI(DI);
		u.getUnitSelection().updateDI(DI);
		
		DI.spawnHighlight();
		DI.setTempPop(DI.getPlayer1Pop());
		DI.updateSpawnPop(DI.getTempPop());
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1.0;
		c.gridy = 0;
		

		c.weightx = 0.75;
		c.gridx = 0;
		c.gridwidth=2;
		add(w, c);
		
		c.weightx = 0.25;
		c.gridx = 2;
		c.gridwidth=1;
		add(u, c);
		
		JPanel fill1 = new JPanel();
		fill1.setOpaque(false);
		c.fill=c.BOTH;
		c.weighty=0;
		c.weightx=.65;
		c.gridx=1;
		c.gridy=1;
		add(fill1,c);
		
		JPanel fill2 = new JPanel();
		fill2.setOpaque(false);
		c.fill=c.BOTH;
		c.weighty=0;
		c.weightx=.25;
		c.gridx=2;
		c.gridy=1;
		add(fill2,c);
		
		c.fill=c.BOTH;
		c.weighty=.05;
		c.weightx=.10;
		c.gridx=0;
		c.gridy=1;
		Image a = ResizableText.createImage("Main Menu", Color.WHITE, Color.DARK_GRAY);
		main = new PaintButton(a);
		main.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(main.isSelected()){
					GameWrapper wrapper=(GameWrapper) getParent();
					ParentPanel parent = (ParentPanel) wrapper.getParent();
					//DI.resetMove();
					parent.loadPanel(0);
					main.setSelected(false);
					}
			}
		});
		add(main,c);
		
		setBackground(Color.BLACK);
	}
	
	public MapPanel getmap(){
		return w.getMapPanel();
	}
	
}