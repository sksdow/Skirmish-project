package Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class PaintButton extends JToggleButton implements ImageObserver{
	Image image;
	
	public PaintButton(ImageIcon ic){
		image= ic.getImage();
		

	}
	public PaintButton(Image a) {
		image = a;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (getModel().isSelected()) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(getWidth()-getWidth()*30/31));
			g2.draw(new Rectangle2D.Float(0,0,getWidth(),getHeight()));
		}
		g.drawImage(image,0,0, getWidth(),getHeight(),this);
	}
	

}
