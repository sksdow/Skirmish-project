package MainMenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;

import javax.swing.*;

import Utilities.AspectRatio;
import Utilities.PaintButton;
import Utilities.ResizableText;
public class MPanel2 extends JPanel{
	
	JButton button1,button2,button4;
	JToggleButton button3;
	private GridBagConstraints c2;
	AspectRatio a;
	public MPanel2(){
		c2 = new GridBagConstraints();
		a=new AspectRatio(10,30);
		setOpaque(false);
		setLayout(new GridBagLayout());
		JPanel left=new JPanel();left.setOpaque(false);
		JPanel right = new JPanel();right.setOpaque(false);
		JPanel middle = new JPanel();
		middle.setLayout(new GridBagLayout());middle.setOpaque(false);
		JPanel bottom = new JPanel();bottom.setOpaque(false);
		c2.weighty=1;
		c2.weightx=1;
		c2.fill=c2.BOTH;
		c2.insets=new Insets(5, 10, 5, 10);
		c2.gridy=0;
		
		Image a= ResizableText.createImage("New Game", Color.white,Color.darkGray);
		JToggleButton button1 = new PaintButton(a);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(button1.isSelected()){
					MainPanel main=(MainPanel) getParent();
					ParentPanel parent=(ParentPanel) main.getParent();
					parent.resetGame();
					parent.loadPanel(1);
					parent.gw.loadPanel(0);
					button1.setSelected(false);}
			}
		});
		middle.add(button1,c2);
		
		c2.gridy=1;
		a= ResizableText.createImage("Continue", Color.white,Color.darkGray);
		JToggleButton button2 = new PaintButton(a);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(button2.isSelected()){
					MainPanel main=(MainPanel) getParent();
					ParentPanel parent=(ParentPanel) main.getParent();
					parent.loadPanel(1);
					button2.setSelected(false);}
			}
		});
		middle.add(button2,c2);
		
		c2.gridy=2;
		a= ResizableText.createImage("Settings", Color.white,Color.darkGray);
		JToggleButton button3 = new PaintButton(a);
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(button3.isSelected()){
					((MainPanel) getParent()).loadPanel(2);
				}
				else
					((MainPanel) getParent()).loadPanel(0);
			}
		});
		middle.add(button3,c2);
		c2.gridy=3;
		a= ResizableText.createImage("Quit", Color.white,Color.darkGray);
		JToggleButton button4 = new PaintButton(a);
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame f = (JFrame)SwingUtilities.getWindowAncestor(getParent());
				f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			}
		});
		middle.add(button4,c2);
		c2.gridy=4;c2.insets=new Insets(0,0,0,0);
		middle.add(bottom,c2);
		
		c2=new GridBagConstraints();
		c2.fill=c2.BOTH;
		c2.weightx=.45;
		c2.weighty=1;
		c2.gridx=0;
		add(left,c2);
		c2.gridx=2;
		add(right,c2);
		c2.weightx=.1;
		c2.gridx=1;
		c2.gridy=0;
		c2.weighty=.8;
		add(middle,c2);
		
		
		
	}
	public void componentResized(int w,int h) {
		Dimension newSize = a.resize(w, h);
		System.out.println(newSize);
		setPreferredSize(newSize);
	}
	
}
