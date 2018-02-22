package test;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class WeirdButton extends JToggleButton {
	
	private Color c;
	
	public WeirdButton(Color c) {
		this.c = c;
		setPreferredSize(new Dimension(200,200));
		
		// Remove the default stuff drawn with the button.
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		
	}
	
	public void paintComponent(Graphics g) {
		// Clear what was already drawn. Redraws the background color.
		super.paintComponent(g);
		
		// Takes advantage of the fact that Swing passes in a Graphics2D object already casted as a regular Graphics object.
		Graphics2D g2 = (Graphics2D)g;
		// Code for what goes inside the button.
		g2.setColor(c);
		g2.fillRect(getWidth()/4,getHeight()/4,getWidth()/2,getHeight()/2);
		
		// Code to box the button. Red if selected. Black if not.
		if (getModel().isSelected()) {
			g2.setStroke(new BasicStroke(5));
			g2.setColor(Color.RED);
			g2.draw(new Rectangle2D.Float(0,0,getWidth(),getHeight()));
		} else {
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.BLACK);
			g2.draw(new Rectangle2D.Float(0,0,getWidth(),getHeight()));
		}
	}
	
}