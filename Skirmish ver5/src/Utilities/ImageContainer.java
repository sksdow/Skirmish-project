package Utilities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

import Units.GObject;

public class ImageContainer extends JPanel{
	Image image;
	GObject Unit;
	
public ImageContainer(Image img, GObject u){
	Unit=u;
	image=img;
}
protected void paintComponent(Graphics g){
	super.paintComponent(g);
	//System.out.println(getWidth()+" "+ getHeight());
	if(Unit.getTeam()==1)
		g.setColor(Color.RED);
	else
		g.setColor(Color.BLUE);
	g.fillRect(0,0,getWidth(),getHeight());
	g.drawImage(image,0,0, getWidth(),getHeight(),null);
}
}
