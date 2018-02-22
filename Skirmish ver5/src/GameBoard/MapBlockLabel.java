package GameBoard;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Units.*;

public class MapBlockLabel extends JLabel implements MouseListener {
	private GObject u;
	private int data;
	private Coordinate coor;
	private Color highlight;
	private boolean fog;
	
	private static final ImageIcon grass = new ImageIcon(MapBlockLabel.class.getResource("Grass.jpg"));
	
	public MapBlockLabel(int d, Coordinate c, GObject unit) {
		data = d;
		coor = c;
		u=unit;
		fog=false;
		addMouseListener(this);
	}
	
	public void setHighlight(Color c,boolean f) {
		fog = f;
		if (c == null) {
			highlight = null;
			return;
		}
		highlight = makeHighlight(c);
	}
	
	private Color makeHighlight(Color highlight) {
		return new Color(highlight.getRed(), highlight.getGreen(), highlight.getBlue(), 96);
		//return Color.GRAY;
	}
	
	public void paintComponent(Graphics g) {
		
		if (data == 0){
			g.drawImage(grass.getImage(), 0, 0, getWidth(), getHeight(), null);
		} else if (data == 1){
			//System.out.println("blue");
			g.setColor(Color.BLUE);
			g.fillRect(0,0,getWidth(),getHeight());}
		if (highlight != null) {
			g.setColor(highlight);
			g.fillRect(0,0,getWidth(),getHeight());
		}
		if(u!=null&&fog==false){
			//System.out.println("unit");
			if(u.getTeam()==1)
				g.setColor(Color.RED);
			else
				g.setColor(Color.BLUE);
			g.fillRect(0,0,getWidth(),getHeight());
			Image i = u.getIcon().getImage();
			g.drawImage(i,0,0, getWidth(),getHeight(),null);
			
		}
		g.setColor(Color.BLACK);
		g.drawRect(0,0,getWidth(),getHeight());
	}
	
	public void upDateUnit(GObject un){
		u=un;
	}
	
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			((MapPanel)getParent()).leftClick(coor);
		} else if (SwingUtilities.isRightMouseButton(e)) {
			((MapPanel)getParent()).rightClick(coor);
		}
		
		//System.out.println("Clicked Square: (" + coor.getX() + ", " + coor.getY() + ")");
	}
	
	public void mouseEntered(MouseEvent e) {
		((MapPanel)getParent()).setSearchCoordinate(coor,true);
	}
	
	public void mouseExited(MouseEvent e) {}
	
	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
}