package MainMenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import SidePanel.SidePanel;
public class MPanel3 extends JPanel{
	JButton button1;
	JButton button2;
	private GridBagConstraints c2 = new GridBagConstraints();

	public MPanel3(){
		setBackground(Color.GRAY);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		c2.fill=c2.BOTH;
		c2.weightx=1;
		c2.weighty=1;
		c2.insets= new Insets(25,10,30,0);
		
		c2.gridy=0;
		JLabel button1= new JLabel("Resolution");
		add(button1,c2);
		
		ButtonGroup resolution = new ButtonGroup();
		
		JRadioButton button1_2 = new JRadioButton("800x600",true);
		JRadioButton button1_3 = new JRadioButton("1280x800");
		JRadioButton button1_4 = new JRadioButton("1920x1080");
		resolution.add(button1_2);resolution.add(button1_3);resolution.add(button1_4);
		
		c2.gridx=1;
		c2.insets= new Insets(25,10,30,0);
		button1_2.setOpaque(false);
		button1_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainPanel main=(MainPanel) getParent();
				ParentPanel parent=(ParentPanel) main.getParent();
				parent.resize(800, 600);
			}
		});
		add(button1_2,c2);
		
		c2.gridx=2;
		c2.insets= new Insets(25,10,30,0);
		button1_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainPanel main=(MainPanel) getParent();
				ParentPanel parent=(ParentPanel) main.getParent();
				parent.resize(1280, 800);
			}
		});
		button1_3.setOpaque(false);
		add(button1_3,c2);
		
		c2.gridx=3;
		c2.insets= new Insets(25,10,30,10);
		button1_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainPanel main=(MainPanel) getParent();
				ParentPanel parent=(ParentPanel) main.getParent();
				parent.resize(1920, 1080);
			}
		});
		button1_4.setOpaque(false);
		add(button1_4,c2);
		
		c2.gridx=0;
		c2.gridy=1;
		c2.insets= new Insets(0,10,55,0);
		JLabel button2= new JLabel("Sound Volume");
		add(button2,c2);
		
		
	}

}