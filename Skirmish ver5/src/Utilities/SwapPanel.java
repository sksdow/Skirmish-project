package Utilities;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class SwapPanel extends JPanel {
	
	private HashMap<Integer, JPanel> panels;
	private GridBagConstraints c;
	
	public SwapPanel() {
		panels = new HashMap<Integer, JPanel>();
		c = new GridBagConstraints();
		c.fill = c.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		
		setLayout(new GridBagLayout());
		
	}
	
	private void isResizePanel(boolean b) {
		if (b)
			setLayout(null);
		else
			setLayout(new GridBagLayout());
		revalidate();
	}
	
	public void addPanel(JPanel p, int id) {
		panels.put(id, p);
		//if (p instanceof ResizePanel) {
		//addComponentListener((ResizePanel)p);}
		
	}
	
	public JPanel getPanel(int id) {
		return panels.get(id);
	}
	
	public JPanel removePanel(int id) {
		return panels.remove(id);
	}
	
	public void removeAll() {
		super.removeAll();
		ComponentListener[] listeners = getComponentListeners();
		for (ComponentListener c : listeners) {
			removeComponentListener(c);
		}
		//repaint();
	}
	
	public boolean loadPanel(int id) {
		JPanel p = panels.get(id);
		if (p != null) {
			removeAll();
			if (p instanceof ResizePanel) {
				isResizePanel(true);
				add(p);
				addComponentListener((ResizePanel)p);
				((ResizePanel) p).componentResized(null);
				
			} else {
				isResizePanel(false);
				add(p,c);
			}
			revalidate();
			repaint();
			return true;
		}
		return false;
	}
	
}