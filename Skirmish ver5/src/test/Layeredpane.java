package test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Layeredpane extends JPanel{
	
	public Layeredpane(){
		setLayout(new GridBagLayout());
		setBackground(Color.GREEN);
		
		JLayeredPane layers = new JLayeredPane();
		layers.setBackground(Color.RED);
		layers.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill=c.BOTH;c.weightx=1;c.weighty=1;
		c.gridx=0;c.gridy=0;
		JPanel back = new JPanel();
		back.setBackground(Color.BLACK);
		layers.add(back,c);
		
		JPanel front = new JPanel();
		front.setBackground(Color.red);
		layers.add(front,c);
		
		//layers.moveToBack(back);
		//layers.moveToFront(front);
		layers.setLayer(back, 0);
		layers.setLayer(front, 1);
		
		add(layers,c);
		
		
	}
	
	 public static void main(String[] args) {
		 JFrame f = new JFrame();
		 f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		 f.setSize(800, 600);
		 f.setTitle("Skirmish");
		 Layeredpane l = new Layeredpane();
		 f.setContentPane(l);
		 f.setVisible(true);
	 }

}
