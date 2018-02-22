package SidePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

import Utilities.SwapPanel;

public class SidePanel extends SwapPanel{
	private UnitSpawning up;
	private UnitSelection ue;
	
	public SidePanel() {
		up=new UnitSpawning();
		up.setName("Spawning");
		ue=new UnitSelection();
		ue.setName("Combat");
		this.addPanel(up, 0);
		this.addPanel(ue, 1);
		loadPanel(0);
	}
	public String currentMode(){
		return getComponent(0).getName();
	}
	
	public UnitSelection getUnitSelection(){
		return ue;
	}
	
	public UnitSpawning getUnitSpawning(){
		return up;
	}
	
	
	
}