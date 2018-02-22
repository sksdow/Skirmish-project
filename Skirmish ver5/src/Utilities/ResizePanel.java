package Utilities;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResizePanel extends JPanel implements ComponentListener {
	
	private AspectRatio a;
	
	public ResizePanel() {
		a = new AspectRatio(16, 9);
	}
	
	public ResizePanel(int w, int h) {
		a = new AspectRatio(w, h);
	}
	
	public void changeAspectRatio(int w, int h) {
		a = new AspectRatio(w, h);
		componentResized(null);
	}
	
	public void componentResized(ComponentEvent e) {
		Container p = getParent();
		if (p != null && p.getLayout() == null) {
			Dimension parentSize = p.getSize();
			Dimension newSize = a.resize((int)parentSize.getWidth(), (int)parentSize.getHeight());
			setSize(newSize);
			setLocation((int)(parentSize.getWidth() - newSize.getWidth()) / 2, (int)(parentSize.getHeight() - newSize.getHeight()) / 2);
			revalidate();
		} 
	}
	
	public void componentMoved(ComponentEvent e) {}
	
	public void componentHidden(ComponentEvent e) {}
	
	public void componentShown(ComponentEvent e) {}
	
}