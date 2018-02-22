package MainMenu;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Utilities.AspectRatio;
import Utilities.ResizePanel;

public class MainPanel extends ResizePanel{
	
	private GridBagConstraints c1,c2;
	private JPanel panels[];
	private Image background;
	public MainPanel(){
		
		//setBackground(Color.BLACK);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		panels=new JPanel[3];
		panels[0] = new MPanel1();
		c1= new GridBagConstraints();
		c1.gridheight=1;
		c1.gridwidth=1;
		c1.weighty=1;
		c1.weightx=1;
		c1.gridx=0;
		c1.gridy=0;
		c1.fill=GridBagConstraints.BOTH;
		c1.insets=new Insets(50,200,40,200);
		
		panels[1] = new MPanel2();
		c2= new GridBagConstraints();
		c2.gridheight=1;
		c2.gridwidth=1;
		c2.fill=GridBagConstraints.BOTH;
		c2.weighty=.5;
		c2.weightx=1;
		c2.gridx=0;
		c2.gridy=1;
		c2.insets=new Insets(0,0,0,0);
		//c2.insets=new Insets(0,320,100,320);
		
		panels[2] = new MPanel3();
		
		add(panels[1],c2);
		add(panels[0],c1);
		add(panels[2],c1);
		loadPanel(0);
		//Graphics g = this.getGraphics();
		//paintComponent(g);
		
		background = Toolkit.getDefaultToolkit().createImage((getClass().getResource("mainmenu2.png")));
		MediaTracker m = new MediaTracker(this);
		m.addImage(background, 0);
		try {
			m.waitForID(0);
		} catch (Exception e) {
			
		}
		
	}
	
	public void loadPanel(int id) {
		if (id ==0) {
			panels[2].setVisible(false);
		}else{
			panels[2].setVisible(true);
		}
		revalidate();
	}
	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(background,0,0, getWidth(), getHeight(),null);
	    
	    		
	}
	
	
}